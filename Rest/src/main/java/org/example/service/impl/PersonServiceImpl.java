package org.example.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.request.Document;
import org.example.dto.request.Person;
import org.example.model.Doc;
import org.example.model.Gender;
import org.example.model.PersonXml;
import org.example.repository.DocumentRepository;
import org.example.repository.PersonRepository;
import org.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private final PersonRepository personRepository;
    private final MappingJackson2XmlHttpMessageConverter xmlConverter;

    public PersonServiceImpl(PersonRepository personRepository,
                             MappingJackson2XmlHttpMessageConverter xmlConverter) {
        this.personRepository = personRepository;
        this.xmlConverter = xmlConverter;
    }

    @Override
    public org.example.model.Person createPerson(String name, String surname, String patronymic, LocalDate birthDate, Gender gender) {
        org.example.model.Person person = new org.example.model.Person(
                name,
                surname,
                patronymic,
                birthDate,
                gender
        );
        personRepository.save(person);
        return person;
    }

    @Override
    public String convertToXml(Person personRequest) throws JsonProcessingException {
        ObjectMapper xmlMapper = xmlConverter.getObjectMapper();
        return xmlMapper.writeValueAsString(personRequest);
    }

    @Override
    public void createPersonXml(org.example.model.Person person, String xml) {
        PersonXml personXml = new PersonXml(person, xml);
        personRepository.save(personXml);
    }
}

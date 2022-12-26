package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.request.Person;
import org.example.model.Gender;

import java.time.LocalDate;

public interface PersonService {
    org.example.model.Person createPerson(String name, String surname, String patronymic, LocalDate birthDate, Gender gender);

    String convertToXml(Person personRequest) throws JsonProcessingException;

    void createPersonXml(org.example.model.Person person, String personXml);
}

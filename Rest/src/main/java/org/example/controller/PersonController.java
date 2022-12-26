package org.example.controller;

import org.example.dto.request.Person;
import org.example.service.DocumentService;
import org.example.service.PersonService;
import org.example.soap.ws.client.generated.PersonRequest;
import org.example.soap.ws.client.generated.PersonResponse;
import org.example.soap.ws.client.generated.PersonsPort;
import org.example.soap.ws.client.generated.SoapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class PersonController {

    @Autowired
    private final PersonService personService;
    private final DocumentService documentService;

    public PersonController(PersonService personService, DocumentService documentService) {
        this.personService = personService;
        this.documentService = documentService;
    }

    @PostMapping(path = "/persons", produces = "text/xml;charset=utf-8")
    @ResponseStatus(code = HttpStatus.OK)
    public String createPerson(@RequestBody Person person) throws IOException {
        org.example.model.Person personModel = personService.createPerson(
                person.getName(),
                person.getSurname(),
                person.getPatronymic(),
                person.getBirthDate(),
                person.getGender()
        );

        documentService.createDocument(personModel, person.getDocument());

        String xmlPerson = personService.convertToXml(person);

        SoapServiceImpl soapService = new SoapServiceImpl();
        PersonsPort personsPort = soapService.getPersonsPortSoap11();

        PersonRequest personRequest = new PersonRequest();
        personRequest.setPersonXml(xmlPerson);

        PersonResponse personResponse = personsPort.person(personRequest);
        personService.createPersonXml(personModel, personResponse.getPersonXml());
        return personResponse.getPersonXml();
    }
}
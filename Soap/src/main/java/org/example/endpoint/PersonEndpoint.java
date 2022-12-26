package org.example.endpoint;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import localhost._7071.ws.PersonRequest;
import localhost._7071.ws.PersonResponse;
import org.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.xml.sax.SAXException;

@Endpoint
public class PersonEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:7071/ws";

    @Autowired
    private final PersonService personService;

    public PersonEndpoint(PersonService personService) {
        this.personService = personService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "PersonRequest")
    @ResponsePayload
    public PersonResponse transformPerson(@RequestPayload PersonRequest request)
            throws TransformerException, ParserConfigurationException, IOException, SAXException {
        PersonResponse personResponse = new PersonResponse();
        personResponse.setPersonXml(personService.getPersonResponse(request.getPersonXml()));
        return personResponse;
    }
}

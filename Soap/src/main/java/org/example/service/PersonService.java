package org.example.service;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public interface PersonService {
    String getPersonResponse(String xml)
            throws ParserConfigurationException, IOException, SAXException, TransformerException;
}

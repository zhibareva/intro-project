package org.example.service.impl;

import org.example.service.PersonService;
import org.example.util.XmlHelper;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public String getPersonResponse(String xml)
            throws TransformerException {
        return XmlHelper.transform(xml);
    }
}

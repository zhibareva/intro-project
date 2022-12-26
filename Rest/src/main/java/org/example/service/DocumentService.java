package org.example.service;

import org.example.dto.request.Document;
import org.example.model.Doc;
import org.example.model.Person;

public interface DocumentService {
    Doc createDocument(Person person, Document documentRequest);
}

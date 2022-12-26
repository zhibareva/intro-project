package org.example.service.impl;

import org.example.dto.request.Document;
import org.example.model.Doc;
import org.example.model.Person;
import org.example.repository.DocumentRepository;
import org.example.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Doc createDocument(Person person, Document documentRequest) {
        Doc document = new Doc(
                person,
                documentRequest.getSeries(),
                documentRequest.getNumber(),
                documentRequest.getType(),
                documentRequest.getIssueDate()
        );
        return documentRepository.save(document);
    }

}

package org.example.repository.impl;

import org.example.model.Doc;
import org.example.repository.DocumentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class DocumentRepositoryImpl implements DocumentRepository {

    @Autowired
    private final SessionFactory sessionFactory;

    public DocumentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Doc save(Doc document) {
        Session session =  sessionFactory.openSession();
        session.save(document);
        session.close();
        return document;
    }
}

package org.example.repository.impl;

import org.example.model.Person;
import org.example.model.PersonXml;
import org.example.repository.PersonRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private final SessionFactory sessionFactory;

    public PersonRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Person save(Person person) {
        Session session = sessionFactory.openSession();
        session.save(person);
        session.close();
        return person;
    }

    @Override
    public PersonXml save(PersonXml personXml) {
        Session session = sessionFactory.openSession();
        session.save(personXml);
        session.close();
        return personXml;
    }
}

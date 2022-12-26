package org.example.repository;

import org.example.model.Person;
import org.example.model.PersonXml;

public interface PersonRepository {
    Person save(Person person);

    PersonXml save(PersonXml personXml);
}

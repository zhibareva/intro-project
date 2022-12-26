package org.example.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.example.model.Gender;

import java.time.LocalDate;

@JsonRootName("person")
public class Person {

    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthDate;
    private Gender gender;
    @JsonProperty("document")
    private Document document;

    public Person() {
    }

    public Person(String name, String surname, String patronymic,
                  LocalDate birthDate, Gender gender, Document document) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.gender = gender;
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public Document getDocument() {
        return document;
    }
}

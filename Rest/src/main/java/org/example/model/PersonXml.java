package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "persons_xml")
public class PersonXml {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    private String personXml;

    public PersonXml(Person person, String personXml) {
        this.person = person;
        this.personXml = personXml;
    }

    public PersonXml() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPersonXml() {
        return personXml;
    }

    public void setPersonXml(String personXml) {
        this.personXml = personXml;
    }
}

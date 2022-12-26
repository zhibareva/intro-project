package org.example.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "documents")
public class Doc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
    private String series;
    private String number;
    @Enumerated(EnumType.STRING)
    private PassportType type;
    private LocalDate issueDate;

    public Doc() {
    }

    public Doc(Person person, String series, String number, PassportType type, LocalDate issueDate) {
        this.person = person;
        this.series = series;
        this.number = number;
        this.type = type;
        this.issueDate = issueDate;
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

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PassportType getType() {
        return type;
    }

    public void setType(PassportType type) {
        this.type = type;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }
}

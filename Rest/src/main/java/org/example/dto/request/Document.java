package org.example.dto.request;

import org.example.model.PassportType;

import java.time.LocalDate;

public class Document {
    private String series;
    private String number;
    private PassportType type;
    private LocalDate issueDate;

    public Document() {
    }

    public Document(String series, String number, PassportType type,
                    LocalDate issueDate) {
        this.series = series;
        this.number = number;
        this.type = type;
        this.issueDate = issueDate;
    }

    public String getSeries() {
        return series;
    }

    public String getNumber() {
        return number;
    }

    public PassportType getType() {
        return type;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }
}

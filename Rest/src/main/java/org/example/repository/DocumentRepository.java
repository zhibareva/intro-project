package org.example.repository;

import org.example.model.Doc;

public interface DocumentRepository {
    Doc save(Doc document);
}

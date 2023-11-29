package org.example.libraryEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor

public class BookEntity {
    private String tittle;
    private AuthorEntity authors;
    private PublisherEntity publsihers;

    @Override
    public String toString() {
        return "Название книги: " + tittle + "|Автор книги: " + authors + "|Издательство: " + publsihers;
    }

    public BookEntity() {
    }
}
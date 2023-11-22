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
    private String authors;
    private String publsihers;

    @Override
    public String toString() {
        return "Название книги: "+ tittle + " | Автор книги: " + authors + " | Издательство: " + publsihers;
    }

    public BookEntity() {
    }
}
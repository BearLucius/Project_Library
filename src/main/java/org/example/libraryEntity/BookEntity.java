package org.example.libraryEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookEntity {
    private String tittle;
    private String authors;
    private String publsihers;

    public BookEntity() {
    }
}
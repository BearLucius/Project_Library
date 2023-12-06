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
    private String year;
    private String genre;
    private String history;
    private AuthorEntity authors;
    private PublisherEntity publsihers;

    @Override
    public String toString() {
        return "|Название книги: " + tittle + "\n|Автор книги: " + authors + "\n|Издательство: " + publsihers + "\n|Год выпуска: " + year + "\n|Раздели библиотеки: " + genre + "\n|Происхождение книги: " + history;
    }

    public BookEntity() {
    }
}
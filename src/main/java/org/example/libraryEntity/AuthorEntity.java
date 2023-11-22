package org.example.libraryEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class AuthorEntity {
    private String name;
    private String surname;
    private String lastname;

    public AuthorEntity() {

    }
}

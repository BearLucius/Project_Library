package org.example.libraryEntity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;



import java.util.List;

@Data
@Getter
@Setter

public class LibraryAllBooks {
    private List <BookEntity> data;

    public LibraryAllBooks() {
    }
}
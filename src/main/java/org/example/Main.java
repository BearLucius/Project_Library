//Импорт файлов с папки LibraryEntity;
package org.example;
import org.example.libraryEntity.AuthorEntity;
import org.example.libraryEntity.BookEntity;
import org.example.libraryEntity.LibraryAllBooks;
import org.example.libraryEntity.PublisherEntity;
//Импорт java инструментов для работы;
import java.awt.*;
import java.awt.print.Book;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Основная программа;
public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        //Название приложения (Или же данные которые появляются при запуске программы;
        System.out.printf("         (|22.11.2023|)" + "\n       -=Крапивин Илья | ИС-3=-" + "\n     [Project Library] v0.1");
        // Делаем переменную а в которую мы будем что-то вписывать (А ИМЕННО ЦИФРЫ), и это что-то вписанное должно менять case;
        int a;
        Scanner scanner = new Scanner(System.in);
        //Само меню, точнее, её функционал;
        do {
            Menu.mainMenu();
            a = scanner.nextInt();
            switch (a) {
                case 1: System.out.println("Заглушка");break;
                case 2: System.out.println("Заглушка");break;
                case 3:
                    //AuthorEntity ==================================
                    AuthorEntity author = new AuthorEntity();
                    scanner.nextLine(); //Штука, которая не позволяет сканнеру перепрыгивать на другое поле, которое надо заполнить
                    System.out.printf("Введите ИМЯ автора: ");
                    author.setName(scanner.nextLine());
                    System.out.printf("Введите ФАМИЛИЮ автора: ");
                    author.setLastname(scanner.nextLine());
                    System.out.printf("Введите ОТЧЕСТВО автора: ");
                    author.setSurname(scanner.nextLine());
                    //PublisherEntity =================================
                    PublisherEntity publisher = new PublisherEntity();
                    System.out.printf("Введите НАЗВАНИЕ издательства: ");
                    publisher.setNamePublisher(scanner.nextLine());
                    System.out.printf("Введите ГОРОД издательства: ");
                    publisher.setCityPublisher(scanner.nextLine());
                    //BookEntity ======================================
                    BookEntity book = new BookEntity();
                    book.setAuthors(String.valueOf(author));
                    book.setPublsihers(String.valueOf(publisher));
                    System.out.printf("Введите НАЗВАНИЕ книги: ");
                    book.setTittle(scanner.nextLine());
                    List <BookEntity> temp = new ArrayList<>();
                    temp.add(book);

                    break;
                case 4: System.out.println("Заглушка");break;
                case 5: System.out.println("Заглушка");break;
                case 6: Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                    System.out.println("РИКРОЛ ДЕТКА!");break;
                case 7: System.out.println("До свидания, хорошего дня!");
            }
        }
        while (a!=7);

    }
}

    //
      //


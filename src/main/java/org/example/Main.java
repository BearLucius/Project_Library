//Импорт файлов с папки LibraryEntity;
package org.example;
import org.example.libraryEntity.*;
//Импорт java инструментов для работы;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Основная программа;
public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        //Название приложения (Или же данные которые появляются при запуске программы;
        System.out.printf("           (|22.11.2023|)" + "\n       -=Крапивин Илья | ИС-3=-" + "\n       [Project Library] v0.1");
        // Делаем переменную а в которую мы будем что-то вписывать (А ИМЕННО ЦИФРЫ), и это что-то вписанное должно менять case;
        int a;

        Scanner scanner = new Scanner(System.in);
        LibraryAllBooks books = new LibraryAllBooks();
        //Само меню, точнее, её функционал;
        do {
            Menu.mainMenu();
            a = scanner.nextInt();
            switch (a) {
                case 1: System.out.println("Заглушка");break;
                case 2:
                    if (books.getData()== null) {
                        System.out.println("Библиотека пуста, заполните же её!");
                    }
                    else books.getData().forEach(System.out::println);break;
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
                    //Условие, если getData ровняется Null, то созадётся новый массив с данными, которые ввёл пользователь;
                    if (books.getData()==null) {
                        List<BookEntity> temp = new ArrayList<>();
                        temp.add(book);
                        books.setData(temp);
                        System.out.printf("Книга успешно добавлена в библиотеку!\n");
                    }
                    //Иначе добавляется просто книга, тоесть, просто сами данные пользователя в созданный массив;
                    else {
                        books.getData().add(book);
                        System.out.printf("Книга успешно добавлена в библиотеку!\n");
                    }
                    break;
                case 4: System.out.println("Заглушка");break;
                case 5: System.out.println("Заглушка");break;
                case 6: Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));

                    System.out.println("....................„-~~'''''''~~--„„_\n" +
                            "..............„-~''-,::::::::::::::::::: ''-„\n" +
                            "..........,~''::::::::',:::::::::::::::: ::::|',\n" +
                            ".... .::::::,-~'''¯¯¯''''~~--~'''¯'''-,:|\n" +
                            ".........'|:::::|: : : : : : : : : : : ::: : |,'\n" +
                            "........|:::::|: : :-~~---: : : -----: |\n" +
                            ".......(¯''~-': : : :'¯°: ',: :|: :°-: :|\n" +
                            ".....'....''~-,|: : : : : : ~---': : : :,'\n" +
                            "...............|,: : : : : :-~~--: : ::/ NEVER GONNA GIVE YOU UP\n" +
                            "......,-''\\':\\: :'~„„_: : : : : _,-' NEVER GONNA LET YOU DOOOWN\n" +
                            "__„-';;;;;\\:''-,: : : :'~---~''/| NEVER GONNA RUN AROUND AND DESERT YOU\n" +
                            ";;;;;/;;;;;;;\\: :\\: : :____/: :',__\n" +
                            ";;;;;;;;;;;;;;',. .''-,:|:::::::|. . |;;;;''-„__\n" +
                            ";;;;;;,;;;;;;;;;\\. . .''|::::::::|. .,';;;;;;;;;;''-„\n" +
                            ";;;;;;;|;;;;;;;;;;;\\. . .\\:::::,'. ./|;;;;;;;;;;;;;|\n" +
                            ";;;;;;;\\;;;;;;;;;;;',: : :|¯¯|. . .|;;;;;;;;;,';;|\n" +
                            ";;;;;;;;;',;;;;;;;;;;;\\. . |:::|. . .'',;;;;;;;;|;;/\n" +
                            ";;;;;;;;;;\\;;;;;;;;;;;\\. .|:::|. . . |;;;;;;;;|/\n" +
                            ";;;;;;;;;;;;,;;;;;;;;;;|. .\\:/ . . . .|;;;;;;;;|");break;

                            case 7: System.out.println("До свидания, хорошего дня!");
                    }

            }
        while (a!=7);

        }
    }



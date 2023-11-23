//Импорт файлов с папки LibraryEntity;
package org.example;
import com.google.gson.Gson;
import org.example.libraryEntity.*;
//Импорт java инструментов для работы;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
        System.out.printf("           (|22.11.2023|)" + "\n       -=Крапивин Илья | ИС-3=-" + "\n       [Project Library] v0.1");
        // Делаем переменную а в которую мы будем что-то вписывать (А ИМЕННО ЦИФРЫ), и это что-то вписанное должно менять case;
        int a;
        // Делаем Сканнер для того, чтобы пользователь мог что-то вводить.
        Scanner scanner = new Scanner(System.in);
        // Делаем массив чтобы сюда что-то вписывалось;
        LibraryAllBooks books = new LibraryAllBooks();
        // А это красавец Gson;
        Gson gson = new Gson();
        // Чтение файлов, для того, чтобы вписать/прочитать текстовой файл.
        try
        {
            FileReader reader = new FileReader("./fileForJson.txt");
        }

        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

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
                    //Условие, если getData ровняется Null, то создаётся новый массив с данными, которые ввёл пользователь;
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
                            ";;;;;;;;;;;;,;;;;;;;;;;|. .\\:/ . . . .|;;;;;;;;|");
                            break;
                            case 7:  try{ File fileForJson = new File("./fileForJson.txt");
                                if (!fileForJson.exists())
                                    fileForJson.createNewFile();
                                FileWriter fw;
                                fw = new FileWriter(fileForJson);
                                fw.write(gson.toJson(books));
                                fw.close();
                                System.out.println("Запись завершена.");
                            } catch (IOException e) {
                                e.printStackTrace();
                            };break;
                            case 8: System.out.println("До свидания, хорошего дня!");
            }
            }
        while (a!=8);
        }
    }
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
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


//Основная программа;
public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        //Название приложения (Или же данные которые появляются при запуске программы;
        System.out.printf("           (|06.12.2023|)" + "\n       -=Крапивин Илья | ИС-3=-" + "\n       [Project Library] v0.1");
        // Делаем переменную а в которую мы будем что-то вписывать (А ИМЕННО ЦИФРЫ), и это что-то вписанное должно менять case;
        byte a=0;
        // Делаем Сканнер для того, чтобы пользователь мог что-то вводить.
        Scanner scanner = new Scanner(System.in);
        // Делаем массив чтобы сюда что-то вписывалось;
        LibraryAllBooks books = new LibraryAllBooks();
        // А это красавец Gson;
        Gson gson = new Gson();
        // Чтение файлов, для того, чтобы вписать/прочитать текстовой файл.
        try
        {
            FileReader reader = new FileReader("./LibraryText.txt");
        }

        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        //Само меню, точнее, её функционал;
        do {
            Menu.mainMenu();
            try {
                a = scanner.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Введите только число из меню!");
                scanner.nextLine();
                continue;
            }
            switch (a) {
                case 1:
                    if (books.getData()== null) {
                        System.out.println("Библиотека пуста, заполните же её!");
                    }
                    else books.getData().forEach(System.out::println);break;
                case 2: //AuthorEntity ==================================
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
                    book.setAuthors(author);
                    book.setPublsihers(publisher);
                    System.out.printf("Введите НАЗВАНИЕ книги: ");
                    book.setTittle(scanner.nextLine());
                    System.out.printf("Введите ГОД ВЫПУСКА книги: ");
                    book.setYear(scanner.nextLine());
                    System.out.printf("Введите РАЗДЕЛ книги (Специальная литература, Хобби, Домашнее хозяйство, Беллетристика и т.д.): ");
                    book.setGenre(scanner.nextLine());
                    System.out.printf("Введите ПРОИСХОЖДЕНИЕ книги: ");
                    book.setHistory(scanner.nextLine());
                    System.out.println(book);
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
                case 3: scanner.nextLine();
                if (books.getData()== null){
                    System.out.println("Библиотека пуста, удалять нечего!");
               break; } else {
                    String deleteBook = scanner.nextLine();
                    List<BookEntity> deleteBooks = new ArrayList<>();
                    for (BookEntity b : books.getData())
                        if (    //Поиск по автору;
                                b.getAuthors().getName().equalsIgnoreCase(deleteBook) ||
                                        b.getAuthors().getSurname().equalsIgnoreCase(deleteBook) ||
                                        b.getAuthors().getLastname().equalsIgnoreCase(deleteBook) ||
                                        //Поиск по издательству;
                                        b.getPublsihers().getCityPublisher().equalsIgnoreCase(deleteBook) ||
                                        b.getPublsihers().getNamePublisher().equalsIgnoreCase(deleteBook) ||
                                        //Поиск по Названию - Году - Жанру;
                                        b.getTittle().equalsIgnoreCase(deleteBook) ||
                                        b.getYear().equalsIgnoreCase(deleteBook) ||
                                        b.getGenre().equalsIgnoreCase(deleteBook)|| b.getHistory().equalsIgnoreCase(deleteBook))
                        {
                            deleteBooks.add(b);
                        }
                    if (deleteBooks.isEmpty()) {
                    System.out.println("Книга не найдена!");
                }
                    else {
                        for (BookEntity b : deleteBooks) {
                            System.out.println("Удалить книгу? = |Да - Удалить, Нет - Отменить удаление.|\n" + b);


                            String k = scanner.nextLine();

                            if (k.equalsIgnoreCase("Да")) {
                                books.getData().remove(b);
                                System.out.println("Книга удалена!");
                            } else {
                                System.out.println("Удаление отмененно!");
                            }

                        }
                    }
                }
                case 4:
                    if (books.getData()== null){
                        System.out.println("Библиотека пуста, искать нечего!");
                    scanner.nextLine();
                        break;} else{System.out.println("Введите данные для поиска КНИГИ: ");
                    List<BookEntity> searchBooks = new ArrayList<>();
                    String textSearch;
                    textSearch = scanner.nextLine();

                    for (BookEntity b : books.getData())
                        if (    //Поиск по автору;
                                b.getAuthors().getName().equalsIgnoreCase(textSearch) ||
                                        b.getAuthors().getSurname().equalsIgnoreCase(textSearch) ||
                                        b.getAuthors().getLastname().equalsIgnoreCase(textSearch) ||
                                        //Поиск по издательству;
                                        b.getPublsihers().getCityPublisher().equalsIgnoreCase(textSearch) ||
                                        b.getPublsihers().getNamePublisher().equalsIgnoreCase(textSearch) ||
                                        //Поиск по Названию - Году - Жанру;
                                        b.getTittle().equalsIgnoreCase(textSearch) ||
                                        b.getYear().equalsIgnoreCase(textSearch) ||
                                        b.getGenre().equalsIgnoreCase(textSearch) ||
                                        b.getHistory().equalsIgnoreCase(textSearch)) {
                            searchBooks.add(b);
                        }
                    if (searchBooks.isEmpty()) {
                        System.out.println("Книга не найдена!");
                    } else {
                        searchBooks.forEach(System.out::println);
                    }
                    break;
                }
                case 5:  try{ File fileForJson = new File("./LibraryText.txt");
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
                case 6: Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ")); break;
                case 7: System.out.println("До свидания, хорошего времени суток!");
                default: System.out.println("Введите цифру меньше или равной 6!");   }
        }
        while (a!=6);
    }
}

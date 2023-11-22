package org.example;
import org.example.libraryEntity.AuthorEntity;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.printf(" (|22.11.2023|)" + "\n -=Крапивин Илья | ИС-3=-" + "\n [Project Library] v0.1");
        int a;
        Scanner scanner = new Scanner(System.in);
        do {
            Menu.mainMenu();
            a = scanner.nextInt();
            switch (a) {
                case 1: ;
                case 2: ;
                case 3: AuthorEntity author = new AuthorEntity();
                scanner.nextInt();
                System.out.printf("Введите ИМЯ автора: ");
                    author.setName(scanner.nextLine());
                System.out.printf("Введите ФАМИЛИЮ автора: ");
                    author.setLastname(scanner.nextLine());

                case 4: ;
                case 5: ;
                case 6: ;
                case 7: ;
            }

        }
        while (a!=7);

        }
    }

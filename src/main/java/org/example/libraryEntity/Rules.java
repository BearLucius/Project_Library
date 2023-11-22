package org.example.libraryEntity;

public class Rules {
    public Rules() {
    }

    public static boolean textCorrect(String number){
        return number.matches("[1-7]{1,8}");

    }
}

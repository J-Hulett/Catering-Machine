package com.techelevator.userIO;

import java.util.Locale;
import java.util.Scanner;

public class UserInput {

    private static Scanner scanner = new Scanner((System.in));

    public static String displayHomeMenu() {


        System.out.println("(D) ------ Display Catering Items ------");
        System.out.println("(P) ------ Purchase Items --------------");
        System.out.println("(E) ------ Exit ------------------------");
        System.out.println();

        System.out.println("Select your option: ");
        String userSelection = scanner.nextLine();
        String formattedSelection = userSelection.trim().toUpperCase();


        switch (formattedSelection){
            case "D" :
                return "list";
            case "P" :
                return "purchase";
            case "E" :
                return "exit";
            default :
                return "invalid";
        }

    }
}

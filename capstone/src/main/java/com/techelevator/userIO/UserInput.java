package com.techelevator.userIO;

import com.techelevator.models.VendingMachine;
import com.techelevator.view.Menu;

import java.util.Locale;
import java.util.Scanner;

public class UserInput {

    private static Scanner scanner = new Scanner((System.in));

    public static String displayHomeMenu() {


        System.out.println("(D) ------ Display Catering Items ------");
        System.out.println("(P) ------ Purchase Items --------------");
        System.out.println("(E) ------ Exit ------------------------");
        UserOutput.emptyLine();

        String formattedSelection = getUserSelection();

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


    public static String displayPurchaseMenu(VendingMachine vendingMachine){
        UserOutput.emptyLine();
        UserOutput.printStarBanner();
        System.out.println("*********************************Purchase Menu*********************************");
        UserOutput.printStarBanner();
        UserOutput.emptyLine();
        System.out.println("(M) ------ Feed Money ------------------");
        System.out.println("(S) ------ Select Item -----------------");
        System.out.println("(F) ------ Finish Transaction ----------");
        UserOutput.emptyLine();
        UserOutput.displayCurrentMoneyProvided(vendingMachine);

        String formattedSelection = getUserSelection();

        switch (formattedSelection){
            case "M":
                return "feed";
            case "S":
                return "select";
            case "F":
                return "finish";
            default:
                return "invalid";
        }

    }

    public static void displayFeedMoneyMenu(VendingMachine vendingMachine){
        UserOutput.emptyLine();
        System.out.println("Select your denomination to deposit -- $1, $5, $10, $20");
        System.out.println("--------- Make sure to include the ($) sign -----------");
        System.out.println("--------- For Example ----- $1 ------------------------");
        UserOutput.emptyLine();
        String moneyFed = getUserSelection();

        switch (moneyFed){
            case "$1":
                vendingMachine.addMoneyToVendingMachine(1.00);
                break;
            case "$5":
                vendingMachine.addMoneyToVendingMachine(5.00);
                break;
            case "$10":
                vendingMachine.addMoneyToVendingMachine(10.00);
                break;
            case "$20":
                vendingMachine.addMoneyToVendingMachine(20.00);
                break;
            default:
                UserOutput.emptyLine();
                System.out.println("Invalid Entry - Please enter a valid amount.");
                UserOutput.emptyLine();
        }

        UserOutput.displayCurrentMoneyProvided(vendingMachine);
    }

    private static String getUserSelection(){
        System.out.println("Select your option: ");
        String userSelection = scanner.nextLine();
        String formattedSelection = userSelection.trim().toUpperCase();

        return formattedSelection;
    }

}

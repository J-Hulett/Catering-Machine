package com.techelevator.userIO;

import com.techelevator.logger.Logger;
import com.techelevator.models.Item;
import com.techelevator.models.VendingMachine;
import com.techelevator.view.Menu;

import javax.sound.midi.Soundbank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class UserInput {


    private static Logger auditLogger = new Logger("Audit.txt");
    private static Scanner scanner = new Scanner((System.in));

    public static String displayHomeMenu(VendingMachine vendingMachine) {
        System.out.println("(D) ------ Display Catering Items ------");
        System.out.println("(P) ------ Purchase Items --------------");
        System.out.println("(E) ------ Exit ------------------------");
        UserOutput.emptyLine();

        String formattedSelection = getUserSelection();

        switch (formattedSelection) {
            case "D":
                return "list";
            case "P":
                return "purchase";
            case "E":
                return "exit";
            case "S":
                return "secret";
            default:
                return "invalid";
        }
    }


    public static String displayPurchaseMenu(VendingMachine vendingMachine) {
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

        switch (formattedSelection) {
            case "M":
                return "feed";
            case "S":
                return "select";
            case "F":
                auditLogger.auditChangeLogger(auditLogger, vendingMachine);
                return "finish";
            default:
                return "invalid";
        }

    }

    public static void displaySelectMenu(VendingMachine vendingMachine) {
        UserOutput.emptyLine();
        UserOutput.printStarBanner();
        System.out.println("*********************************Select an Item********************************");
        UserOutput.printStarBanner();
        UserOutput.emptyLine();
        System.out.println("Input the slot of the item you wish to purchase");
        System.out.println("For example : 'A1' 'B2' ");
        UserOutput.emptyLine();
        UserOutput.displayListOfInventoryOfItems(vendingMachine.getInventoryOfItems());

        String slotSelection = getUserSelection();
        boolean isIn = false;

        for (Item item : vendingMachine.getInventoryOfItems()) {
            if (item.getSlot().equals(slotSelection)) {
                isIn = true;
            }
            if (item.getSlot().equals(slotSelection) && vendingMachine.getTotalMoneyUserFed() < item.getPrice() && isIn) {
                UserOutput.emptyLine();
                System.out.println("Not enough money, please add more money!");
            }
            if (item.getSlot().equals(slotSelection) && item.getQuantity() == 0 && isIn) {
                UserOutput.emptyLine();
                System.out.println("NO LONGER AVAILABLE");
            }
            // create a method for subtracting from total price
            if (item.getSlot().equals(slotSelection) && item.getQuantity() > 0
                    && vendingMachine.getTotalMoneyUserFed() >= item.getPrice() && isIn) {
                item.setQuantity(item.getQuantity() - 1);
                UserOutput.emptyLine();
                auditLogger.auditPurchaseLogger(auditLogger, vendingMachine, item);
                vendingMachine.setTotalMoneyUserFed(vendingMachine.getTotalMoneyUserFed() - item.getPrice());
                System.out.println(item.getName() + " Price: $" + item.getPrice());
                UserOutput.displayItemMessage(item.getType());
            }
        }
        if (!isIn) {
            UserOutput.emptyLine();
            System.out.println("INVALID ENTRY!!!");
        }
    }


    public static void displayFeedMoneyMenu(VendingMachine vendingMachine) {
        UserOutput.emptyLine();
        System.out.println("Select your denomination to deposit -- $1, $5, $10, $20");
        System.out.println("--------- Make sure to include the ($) sign -----------");
        System.out.println("--------- For Example ----- $1 ------------------------");
        UserOutput.emptyLine();
        String moneyFed = getUserSelection();

        switch (moneyFed) {
            case "$1":
                vendingMachine.addMoneyToVendingMachine(1.00);
                String dollar = "$1.00";
                auditLogger.auditMoneyFedLogger(auditLogger, vendingMachine, dollar);
                break;
            case "$5":
                vendingMachine.addMoneyToVendingMachine(5.00);
                String fiveDollar = "$5.00";
                auditLogger.auditMoneyFedLogger(auditLogger, vendingMachine, fiveDollar);
                break;
            case "$10":
                vendingMachine.addMoneyToVendingMachine(10.00);
                String tenDollar = "$10.00";
                auditLogger.auditMoneyFedLogger(auditLogger, vendingMachine, tenDollar);
                break;
            case "$20":
                vendingMachine.addMoneyToVendingMachine(20.00);
                String twentyDollar = "$20.00";
                auditLogger.auditMoneyFedLogger(auditLogger, vendingMachine, twentyDollar);
                break;
            default:
                UserOutput.emptyLine();
                System.out.println("INVALID ENTRY - PLEASE ENTER A VALID AMOUNT!!!");
                UserOutput.emptyLine();
        }
        UserOutput.displayCurrentMoneyProvided(vendingMachine);
    }

    private static String getUserSelection() {
        System.out.println("Select your option: ");
        String userSelection = scanner.nextLine();
        return userSelection.trim().toUpperCase();
    }
}

package com.techelevator.userIO;

import com.techelevator.models.Item;
import com.techelevator.models.VendingMachine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserOutput {
    public static final DecimalFormat money = new DecimalFormat("0.00");




    public static void printStarBanner() {
        System.out.println("*******************************************************************************");
    }

    public static void emptyLine() {
        System.out.println();
    }

    public static void welcomeBanner() {
        printStarBanner();
        System.out.println("******************************Catering Machine 9000****************************");
        printStarBanner();
        emptyLine();
    }

    public static void goodBye(){
        emptyLine();
        printStarBanner();
        System.out.println("*******************************Thank you for Using*****************************");
        System.out.println("******************************Catering Machine 9000****************************");
        printStarBanner();
    }

    public static void displayListOfInventoryOfItems(List<Item> items) {
        for (Item item : items) {
            System.out.println(item.getSlot() + " || " + item.getName() + " || " + item.getPrice());
        }
        emptyLine();
    }

    public static void displayCurrentMoneyProvided(VendingMachine vendingMachine) {
        System.out.println("Current Money Provided: $" + money.format(vendingMachine.getTotalMoneyUserFed()));
    }


    public static void displayItemMessage(String type) {
        if (type.equals("Munchy")) {
            System.out.println("Munchy, Munchy, so Good!");
        } else if (type.equals("Sandwich")) {
            System.out.println("Sandwich So Delicious, Yum!");
        } else if (type.equals("Drink")) {
            System.out.println("Drinky, Drinky, Slurp Slurp!");
        } else if (type.equals("Dessert")) {
            System.out.println("Sugar, Sugar, so Sweet!");
        }
    }

    public static void getChange(double remainingMoney) {
        double one = 1.00;
        double quarter = .25;
        double dime = .10;
        double nickel = .05;
        int countOne = 0;
        int countQuarter = 0;
        int countDime = 0;
        int countNickel = 0;
        double calculatedCount = roundDecimalTo2Places(remainingMoney);


        while (calculatedCount > 0) {
            if (calculatedCount >= one) {
                calculatedCount -= one;
                calculatedCount = roundDecimalTo2Places(calculatedCount);
                countOne++;
            } else if (calculatedCount >= quarter) {
                calculatedCount -= quarter;
                calculatedCount = roundDecimalTo2Places(calculatedCount);
                countQuarter++;
            } else if (calculatedCount >= dime) {
                calculatedCount -= dime;
                calculatedCount = roundDecimalTo2Places(calculatedCount);
                countDime++;
            } else if (calculatedCount >= nickel) {
                calculatedCount -= nickel;
                calculatedCount = roundDecimalTo2Places(calculatedCount);
                countNickel++;
            }
        }
        UserOutput.emptyLine();
        printChange(countOne, countQuarter, countDime, countNickel, remainingMoney);
    }

    public static void printChange(int countOne, int countQuarter, int countDime, int countNickel, double remainingMoney) {
        String changeString = "Your change: $" + money.format(remainingMoney) + "\n";
        if (countOne > 0) {
            changeString += "Dollars($1): " + countOne + "\n";
        }
        if (countQuarter > 0) {
            changeString += "Quarter(s): " + countQuarter + "\n";
        }
        if (countDime > 0) {
            changeString += "Dime(s): " + countDime + "\n";
        }
        if (countNickel > 0) {
            changeString += "Nickel(s): " + countNickel + "\n";
        }
        System.out.println(changeString);
    }

    public static double roundDecimalTo2Places(double count) {
        BigDecimal bdNickel = new BigDecimal(count).setScale(2, RoundingMode.HALF_UP);
        count = bdNickel.doubleValue();
        return count;
    }

    public static String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        LocalDateTime rightNow = LocalDateTime.now();
        return rightNow.format(formatter);
    }

    public static String getTimeForSalesReport() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH-mm-ss a");
        LocalDateTime rightNow = LocalDateTime.now();
        return rightNow.format(formatter);
    }
}


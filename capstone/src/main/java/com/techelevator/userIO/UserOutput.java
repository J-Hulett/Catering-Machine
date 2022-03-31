package com.techelevator.userIO;

import com.techelevator.models.Item;
import com.techelevator.models.VendingMachine;

import java.text.DecimalFormat;
import java.util.List;

public class UserOutput {

    private static final DecimalFormat money = new DecimalFormat("0.00");

    public static void printStarBanner(){
        System.out.println("*******************************************************************************");
    }
    public static void emptyLine(){
        System.out.println();
    }

    public static void welcomeBanner (){
        printStarBanner();
        System.out.println("******************************Catering Machine 9000****************************");
        printStarBanner();
        emptyLine();
    }

    public static void displayListOfInventoryOfItems(List<Item> items){
        for (Item item: items){
            System.out.println(item.getSlot() + " || " + item.getName() + " || " + item.getPrice());
        }
        emptyLine();
    }

    public static void displayCurrentMoneyProvided(VendingMachine vendingMachine){
        System.out.println("Current Money Provided: $" +  money.format(vendingMachine.getTotalMoneyUserFed()));
    }


}

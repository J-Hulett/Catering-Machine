package com.techelevator.userIO;

import com.techelevator.models.Item;
import com.techelevator.models.VendingMachine;

import java.util.List;

public class UserOutput {

    public static void printStarBanner(){
        System.out.println("*******************************************************************************");
    }

    public static void welcomeBanner (){
        printStarBanner();
        System.out.println("******************************Catering Machine 9000****************************");
        printStarBanner();
        System.out.println();
    }

    public static void displayListOfInventoryOfItems(List<Item> items){
        for (Item item: items){
            System.out.println(item.getSlot() + " || " + item.getName() + " || " + item.getPrice());

        }
    }


}

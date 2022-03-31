package com.techelevator.view;

import com.techelevator.models.Item;
import com.techelevator.models.VendingMachine;
import com.techelevator.userIO.UserInput;
import com.techelevator.userIO.UserOutput;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Menu {
    VendingMachine vendingMachine = new VendingMachine();


    public void run() {
        boolean isRunning = true;
		while (isRunning) {
            //  to do -- build out main menu
            UserOutput.welcomeBanner();
            try {
                readFromCateringFile();// Reads file then builds a list
            } catch (IOException e) {
                System.out.println("Test Not successful could not make list");
            }
//        UserOutput.displayListOfInventoryOfItems(vendingMachine.getInventoryOfItems());


            String selection = UserInput.displayHomeMenu();
            if (selection.equals("list")) {
                UserOutput.displayListOfInventoryOfItems(vendingMachine.getInventoryOfItems());
                isRunning = false;
            } else if (selection.equals("purchase")) {
                System.out.println("Purchase");
                isRunning = false;
            } else if (selection.equals("exit")) {
                isRunning = false;
            } else if (selection.equals("invalid")) {
                System.out.println("Invalid selection please select (D, P or E). ");
                System.out.println();
            }
        }
    }




        public List<Item> readFromCateringFile() throws IOException {
        File readFile = new File("catering.csv");
        try {
            Scanner fileReader = new Scanner(readFile);
            while (fileReader.hasNextLine()){
                String currentLine = fileReader.nextLine();
                String [] itemArray = currentLine.split(","); //Split by comma to make the item
                Item item = new Item(itemArray[0], itemArray[1], itemArray[2], Double.parseDouble(itemArray[3]));
                // Made Items parameters
                vendingMachine.addItemToList(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Internal Error - ItemList Not Found");
        }
        return vendingMachine.getInventoryOfItems();
    }

}

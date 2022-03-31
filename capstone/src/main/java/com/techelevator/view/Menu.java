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

            UserOutput.welcomeBanner();

            try {
                readFromCateringFile();// Reads file then builds a list
            } catch (IOException e) {
                System.out.println("Test Not successful could not make list");
            }


            String selection = UserInput.displayHomeMenu();
            if (selection.equals("list")) {
                UserOutput.emptyLine();
                UserOutput.displayListOfInventoryOfItems(vendingMachine.getInventoryOfItems());
            } else if (selection.equals("purchase")) {
                runPurchase();
            } else if (selection.equals("exit")) {
                isRunning = false;
            } else if (selection.equals("invalid")) {
                System.out.println("Invalid selection please select (D, P or E). ");
                UserOutput.emptyLine();
            }
        }
    }

    public void runPurchase(){
        boolean isPurchasing = true;
        while(isPurchasing){
           String selection = UserInput.displayPurchaseMenu(vendingMachine);
            if (selection.equals("feed")){
                runFeed();
            }else if (selection.equals("select")){
                System.out.println("SELECT AN ITEM!!!");
            }else if (selection.equals("finish")){
                UserOutput.emptyLine();
                isPurchasing = false;
            } else if (selection.equals("invalid")){
                UserOutput.emptyLine();
                System.out.println("Invalid selection please select (M, S or F). ");
            }
        }
    }

    public void runFeed(){
            UserInput.displayFeedMoneyMenu(vendingMachine);
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

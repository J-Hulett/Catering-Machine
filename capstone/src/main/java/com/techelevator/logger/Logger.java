package com.techelevator.logger;

import com.techelevator.models.Item;
import com.techelevator.models.VendingMachine;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final DecimalFormat money = new DecimalFormat("0.00");

    private File logFile;
    private PrintWriter writer;

    public Logger(String pathName){

        this.logFile = new File(pathName);   //Makes a new file.
         if(!logFile.exists()){
             try{
                 this.writer = new PrintWriter(this.logFile);
             } catch (FileNotFoundException e){
                 System.out.println("Internal Error - System Will Exit - FileNotFound");
             }
         } else {
             try{
                 this.writer = new PrintWriter(new FileWriter(this.logFile, true));
             } catch (IOException e){
                 System.out.println("Internal Error - System Will Exit - IOException ");
             }
         }
    }

    public void write(String logMessage){
        this.writer.println(logMessage); //Puts it in a buffer.
        this.writer.flush(); // Takes the whole thing and writes it to a file line.
    }

    public void close() throws IOException{
        this.writer.close(); //Close when you're done writing
    }


    public void auditMoneyFedLogger(Logger logger, VendingMachine vendingMachine, String moneyAdded){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        LocalDateTime rightNow = LocalDateTime.now();
        String printTime = rightNow.format(formatter);
        logger.write(printTime + " MONEY FED:        " +moneyAdded + " $" + money.format(vendingMachine.getTotalMoneyUserFed()));
    }

    public void auditChangeLogger(Logger logger, VendingMachine vendingMachine){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        LocalDateTime rightNow = LocalDateTime.now();
        String printTime = rightNow.format(formatter);
        logger.write(printTime + " CHANGE GIVEN:     $" + money.format(vendingMachine.getTotalMoneyUserFed()) + " $0.00");
    }


    public void auditPurchaseLogger(Logger logger, VendingMachine vendingMachine, Item item){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        LocalDateTime rightNow = LocalDateTime.now();
        String printTime = rightNow.format(formatter);
        logger.write(printTime + " " + item.getName() + "     " + item.getSlot() + " $"
                + money.format(vendingMachine.getTotalMoneyUserFed()) + " $"
                + money.format(vendingMachine.getTotalMoneyUserFed() - item.getPrice()));
    }

}

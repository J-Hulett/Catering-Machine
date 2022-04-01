package com.techelevator.userIO;

import com.techelevator.models.Item;
import com.techelevator.models.VendingMachine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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


    public static void displayItemMessage (String type){
        if(type.equals("Munchy")){
            System.out.println("Munchy, Munchy, so Good!");
        }
        else if (type.equals("Sandwich")){
            System.out.println("Sandwich So Delicious, Yum!");
        }
        else if (type.equals("Drink")){
            System.out.println("Drinky, Drinky, Slurp Slurp!");
        }
        else if (type.equals("Dessert")){
            System.out.println("Sugar, Sugar, so Sweet!");
        }
    }

    public static void getChange(double remainingMoney){
        double one = 1.00;
        double quarter = .25;
        double dime = .10;
        double nickel = .05;
        int countOne = 0;
        int countQuarter = 0;
        int countDime = 0;
        int countNickel = 0;
        BigDecimal bd = new BigDecimal(remainingMoney).setScale(2, RoundingMode.HALF_UP);
        double calculatedCount = bd.doubleValue();

        while(calculatedCount > 0){
            if(calculatedCount >= one){
              calculatedCount -= one;
              BigDecimal bdOne = new BigDecimal(calculatedCount).setScale(2,RoundingMode.HALF_UP);
              calculatedCount = bdOne.doubleValue();
                countOne++;
            }
            else if(calculatedCount >= quarter){
                calculatedCount -= quarter;
                BigDecimal bdQuarter = new BigDecimal(calculatedCount).setScale(2,RoundingMode.HALF_UP);
                calculatedCount = bdQuarter.doubleValue();
                countQuarter++;
            }
            else if(calculatedCount >= dime){
                calculatedCount -= dime;
                BigDecimal bdDime = new BigDecimal(calculatedCount).setScale(2,RoundingMode.HALF_UP);
                calculatedCount = bdDime.doubleValue();
                countDime++;
            }
            else if(calculatedCount >= nickel){
                calculatedCount -= nickel;
                BigDecimal bdNickel = new BigDecimal(calculatedCount).setScale(2,RoundingMode.HALF_UP);
                calculatedCount = bdNickel.doubleValue();
                countNickel++;
            }

        }
        UserOutput.emptyLine();
        printChange(countOne, countQuarter, countDime, countNickel);
    }

    public static void printChange(int countOne, int countQuarter, int countDime, int countNickel){
        String changeString = "";
        if (countOne > 0){
            changeString += "$1: " + countOne + " ";
        }
        if (countQuarter > 0){
            changeString += "Quarter(s): " + countQuarter + " ";
        }
        if (countDime > 0){
            changeString += "Dime(s): " + countDime + " ";
        }
        if (countNickel > 0){
            changeString += "Nickel(s): " + countNickel + " ";
        }
        System.out.println(changeString);
    }
}


//        while(countRemaining.compareTo(zero) == 1){
//                if(countRemaining.compareTo(one) == 1 || countRemaining.compareTo(one) == 0){
//                countRemaining.subtract(one);
//                countOne++;
//                }
//                else if(countRemaining.compareTo(quarter) == 1 || countRemaining.compareTo(quarter) == 0){
//                countRemaining.subtract(quarter);
//                countQuarter++;
//                }
//                else if(countRemaining.compareTo(dime) == 1 || countRemaining.compareTo(dime) == 0){
//                countRemaining.subtract(dime);
//                countDime++;
//                }
//                else if(countRemaining.compareTo(nickel) == 1 || countRemaining.compareTo(nickel) == 0){
//                countRemaining.subtract(nickel);
//                countNickel++;
//                }
//
//    BigDecimal one =  new BigDecimal(1.00);
//    BigDecimal quarter = new BigDecimal(.25);
//    BigDecimal dime = new BigDecimal(0.10);
//    BigDecimal nickel = new BigDecimal(0.05);
//    BigDecimal zero = new BigDecimal(0);

//    BigDecimal bd3 = new BigDecimal("1.00").setScale(2, RoundingMode.HALF_UP);
//    double one = bd3.doubleValue();
//    BigDecimal bd4 = new BigDecimal(".25").setScale(2, RoundingMode.HALF_UP);
//    double quarter= bd4.doubleValue();
//    BigDecimal bd1 = new BigDecimal(".10").setScale(2, RoundingMode.HALF_UP);
//    double dime = bd1.doubleValue();
//    BigDecimal bd2 = new BigDecimal(".05").setScale(2, RoundingMode.HALF_UP);
//    double nickel = bd2.doubleValue();

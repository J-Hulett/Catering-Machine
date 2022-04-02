package com.techelevator.OldMethods;

public class OldMethodsNoLongerInUse {

    //    public static void getChange(double remainingMoney) {
//        double one = 1.00;
//        double quarter = .25;
//        double dime = .10;
//        double nickel = .05;
//        int countOne = 0;
//        int countQuarter = 0;
//        int countDime = 0;
//        int countNickel = 0;
//        double calculatedCount = roundDecimalTo2Places(remainingMoney);
//
//
//        while (calculatedCount > 0) {
//            if (calculatedCount >= one) {
//                calculatedCount -= one;
//                calculatedCount = roundDecimalTo2Places(calculatedCount);
//                countOne++;
//            } else if (calculatedCount >= quarter) {
//                calculatedCount -= quarter;
//                calculatedCount = roundDecimalTo2Places(calculatedCount);
//                countQuarter++;
//            } else if (calculatedCount >= dime) {
//                calculatedCount -= dime;
//                calculatedCount = roundDecimalTo2Places(calculatedCount);
//                countDime++;
//            } else if (calculatedCount >= nickel) {
//                calculatedCount -= nickel;
//                calculatedCount = roundDecimalTo2Places(calculatedCount);
//                countNickel++;
//            }
//        }
//        UserOutput.emptyLine();
//        printChange(countOne, countQuarter, countDime, countNickel, remainingMoney);
//    }


    //    public static void printChange(int countOne, int countQuarter, int countDime, int countNickel, double remainingMoney) {
//        String changeString = "Your change: $" + money.format(remainingMoney) + "\n";
//        if (countOne > 0) {
//            changeString += "Dollars($1): " + countOne + "\n";
//        }
//        if (countQuarter > 0) {
//            changeString += "Quarter(s): " + countQuarter + "\n";
//        }
//        if (countDime > 0) {
//            changeString += "Dime(s): " + countDime + "\n";
//        }
//        if (countNickel > 0) {
//            changeString += "Nickel(s): " + countNickel + "\n";
//        }
//        System.out.println(changeString);
//    }


}

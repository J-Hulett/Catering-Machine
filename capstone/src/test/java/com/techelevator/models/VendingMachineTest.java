package com.techelevator.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineTest {
    VendingMachine vendingMachine;

    @Before
    public void setUp() throws Exception {
     vendingMachine = new VendingMachine();
     Item bacon =new Item("A1", "Bacon", "Munchy", 1.50);
     Item orangeCake =new Item("B2", "Orange Cake", "Dessert", 3.00);
     Item doritos =new Item("C3", "Doritos", "Munchy", 1.00);
     Item beer =new Item("D4", "Beer", "Papsi", 0.25);

     vendingMachine.addItemToList(bacon);
     vendingMachine.addItemToList(orangeCake);
     vendingMachine.addItemToList(doritos);
     vendingMachine.addItemToList(beer);

    }

    @Test
    public void addPositiveNumbers(){
        double expected = 20.00;
        vendingMachine.addMoneyToVendingMachine(20.00);
        double actual = vendingMachine.getTotalMoneyUserFed();

        Assert.assertEquals(expected,actual,0.00);
    }

//    @Test
//    public void addPositiveNumbers(){
//        double expected = 20.00;
//        vendingMachine.addMoneyToVendingMachine(20.00);
//        double actual = vendingMachine.getTotalMoneyUserFed();
//
//        Assert.assertEquals(expected,actual,0.00);
//    }

    @Test
    public void makeSure4ItemsInList(){
        int expected = 4;

        int actual = vendingMachine.getInventoryOfItems().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkItemSlots(){
        String expected = "A1";
        String expected1 = "B2";
        String expected2 = "C3";
        String expected3 = "D4";

        String actual = vendingMachine.getInventoryOfItems().get(0).getSlot();
        String actual1 = vendingMachine.getInventoryOfItems().get(1).getSlot();
        String actual2 = vendingMachine.getInventoryOfItems().get(2).getSlot();
        String actual3 = vendingMachine.getInventoryOfItems().get(3).getSlot();

        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2,actual2);
        Assert.assertEquals(expected3,actual3);
    }

    @Test
    public void checkItemName(){
        String expected = "Bacon";
        String expected1 = "Orange Cake";
        String expected2 = "Doritos";
        String expected3 = "Beer";

        String actual = vendingMachine.getInventoryOfItems().get(0).getName();
        String actual1 = vendingMachine.getInventoryOfItems().get(1).getName();
        String actual2 = vendingMachine.getInventoryOfItems().get(2).getName();
        String actual3 = vendingMachine.getInventoryOfItems().get(3).getName();

        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2,actual2);
        Assert.assertEquals(expected3,actual3);
    }

    @Test
    public void checkItemType(){
        String expected = "Munchy";
        String expected1 = "Dessert";
        String expected2 = "Munchy";
        String expected3 = "Papsi";

        String actual = vendingMachine.getInventoryOfItems().get(0).getType();
        String actual1 = vendingMachine.getInventoryOfItems().get(1).getType();
        String actual2 = vendingMachine.getInventoryOfItems().get(2).getType();
        String actual3 = vendingMachine.getInventoryOfItems().get(3).getType();

        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2,actual2);
        Assert.assertEquals(expected3,actual3);
    }

    @Test
    public void checkItemPrice(){
        double expected = 1.50;
        double expected1 = 3.00;
        double expected2 = 1.00;
        double expected3 = 0.25;

        double actual = vendingMachine.getInventoryOfItems().get(0).getPrice();
        double actual1 = vendingMachine.getInventoryOfItems().get(1).getPrice();
        double actual2 = vendingMachine.getInventoryOfItems().get(2).getPrice();
        double actual3 = vendingMachine.getInventoryOfItems().get(3).getPrice();

        assertEquals(expected,actual,0.00);
        assertEquals(expected1, actual1,0.00);
        assertEquals(expected2,actual2, 0.00);
        assertEquals(expected3,actual3, 0.00);
    }

}

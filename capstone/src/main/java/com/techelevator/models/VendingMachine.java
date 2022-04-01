package com.techelevator.models;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private double totalMoneyUserFed = 0.00;
    private List<Item> inventoryOfItems = new ArrayList<>();

    public void addItemToList(Item item) {
        inventoryOfItems.add(item);
    }

    public double getTotalMoneyUserFed() {
        return totalMoneyUserFed;
    }

    public void setTotalMoneyUserFed(double totalMoneyUserFed) {
        this.totalMoneyUserFed = totalMoneyUserFed;
    }

    public List<Item> getInventoryOfItems() {
        return inventoryOfItems;
    }

    public void addMoneyToVendingMachine(double moneyFed) {
        totalMoneyUserFed += moneyFed;
    }
}

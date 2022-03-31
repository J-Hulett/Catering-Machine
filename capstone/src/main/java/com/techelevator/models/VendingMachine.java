package com.techelevator.models;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private double totalMoneyUserFed = 0.00;
    private List<Item> inventoryOfItems = new ArrayList<>();
    private double maximumCashStorage = 1000.00;






    public void addItemToList(Item item){
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

    public void setInventoryOfItems(List<Item> inventoryOfItems) {
        this.inventoryOfItems = inventoryOfItems;
    }

    public double getMaximumCashStorage() {
        return maximumCashStorage;
    }

    public void setMaximumCashStorage(double maximumCashStorage) {
        this.maximumCashStorage = maximumCashStorage;
    }

    public void addMoneyToVendingMachine(double moneyFed){
        totalMoneyUserFed += moneyFed;
    }
}

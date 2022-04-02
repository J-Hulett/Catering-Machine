package com.techelevator.view;

import com.techelevator.models.VendingMachine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {
VendingMachine vendingMachine;

    @Before
    public void setUp() throws Exception {
        vendingMachine = new VendingMachine();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void does_finish_transaction_reset_fed_money_to_zero(){
        //Arrange
        
        //Act

        //Assert
    }
}

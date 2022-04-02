package com.techelevator.userIO;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.*;

public class UserOutputTest {
    public static final DecimalFormat money = new DecimalFormat("0.00");
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testChangeCounter(){
        UserOutput.getChange(20.00);
    }
}

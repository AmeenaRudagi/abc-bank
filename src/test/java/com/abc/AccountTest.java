/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author Carrington
 */
public class AccountTest {

    public AccountTest() {
    }
    
    @Test
    public void testTransfer(){
        Account a1 = new Account(0);
        Account a2 = new Account(0);
        assertEquals(0,a1.sumTransactions(),0);
        a1.deposit(10000);
        a1.Transfer(a2, 5000);
        assertEquals(5000,a1.sumTransactions(),0);
        assertEquals(5000,a2.sumTransactions(),0);
    }

    @Test
    public void testInterestEarned(){
        //creating super saving account
         Account account1 = new Account(3);
         account1.deposit(2000);
         assertEquals(90,account1.interestEarned());
    }

    @Test
    public void testInterestEarned(){
        //creating savings account
         Account account1 = new Account(1);
         account1.deposit(2000);
         assertEquals(3,account1.interestEarned());
    }
}

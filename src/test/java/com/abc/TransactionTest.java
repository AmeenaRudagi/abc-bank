package com.abc;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class TransactionTest {
    @Test
    public void transaction() {
        Transaction t = new Transaction(5);
        assertTrue(t instanceof Transaction);
        Date dateNow = new Date();
        dateNow = Calendar.getInstance().getTime();
        Date transactionDate;
    }
}

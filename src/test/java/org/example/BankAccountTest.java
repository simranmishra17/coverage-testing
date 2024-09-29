package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    public void testInitialBalance() {
        BankAccount account = new BankAccount(100.0);
        assertEquals(100.0, account.getBalance(), 0.0);
    }

    @Test
    public void testNegativeInitialBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-50.0);
        });

        assertEquals("Initial balance cannot be negative.", exception.getMessage());
    }

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount(50.0);
        account.deposit(50.0);
        assertEquals(100.0, account.getBalance(), 0.0);
    }

//    @Test
//    public void testDepositNegativeAmount() {
//        BankAccount account = new BankAccount(50.0);
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            account.deposit(-10.0);
//        });
//        assertEquals("Deposit amount cannot be negative.", exception.getMessage());
//    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(), 0.0);
    }

//    @Test
//    public void testWithdrawMoreThanBalance() {
//        BankAccount account = new BankAccount(50.0);
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            account.withdraw(60.0);
//        });
//        assertEquals("Withdrawal amount exceeds balance.", exception.getMessage());
//    }

//    @Test
//    public void testWithdrawNegativeAmount() {
//        BankAccount account = new BankAccount(100.0);
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            account.withdraw(-10.0);
//        });
//        assertEquals("Withdrawal amount cannot be negative.", exception.getMessage());
//    }
}

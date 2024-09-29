package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void testInitialBalance() {
        BankAccount account = new BankAccount(100.0);
        assertEquals(100.0, account.getBalance(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInitialBalance() {
        new BankAccount(-50.0);
    }

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount(50.0);
        account.deposit(50.0);
        assertEquals(100.0, account.getBalance(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        BankAccount account = new BankAccount(50.0);
        account.deposit(-10.0);
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawMoreThanBalance() {
        BankAccount account = new BankAccount(50.0);
        account.withdraw(60.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmount() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(-10.0);
    }
}

package com.java.interfaces.code.challenge.bank.CC_6_1.test;

import static org.junit.Assert.*;

import com.java.interfaces.code.challenge.bank.CC_6_1.CheckingAccount;
import org.junit.Before;
import org.junit.Test;

public class CheckingAccountTest {

    private CheckingAccount checkingAccount;

    @Before
    public void setup() {
        checkingAccount = new CheckingAccount();
    }

    @Test
    public void testDeposit() {
        checkingAccount.deposit(100);
        checkingAccount.deposit(200);
        // Verify the balance after deposits
        assertEquals(300, checkingAccount.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw_SufficientFunds() {
        checkingAccount.deposit(500);
        checkingAccount.withdraw(200);
        // Verify the balance after withdrawal
        assertEquals(300, checkingAccount.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw_InsufficientFunds() {
        checkingAccount.deposit(100);
        checkingAccount.withdraw(200);
        // Verify that balance remains unchanged
        assertEquals(100, checkingAccount.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawCheck_SufficientFunds() {
        checkingAccount.deposit(500);
        checkingAccount.withdrawCheck(100, 12345);
        // Verify the balance after withdrawing via check
        assertEquals(400, checkingAccount.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawCheck_InsufficientFunds() {
        checkingAccount.deposit(100);
        checkingAccount.withdrawCheck(200, 12345);
        // Verify the balance remains unchanged
        assertEquals(100, checkingAccount.getBalance(), 0.001);
    }

    @Test
    public void testCalculateInterest() {
        checkingAccount.deposit(1000);
        checkingAccount.calculateInterest();
        // Verify that balance remains unchanged (0% interest)
        assertEquals(1000, checkingAccount.getBalance(), 0.001);
    }
}

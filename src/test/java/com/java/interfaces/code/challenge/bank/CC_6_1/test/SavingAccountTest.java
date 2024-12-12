package com.java.interfaces.code.challenge.bank.CC_6_1.test;
import com.java.interfaces.code.challenge.bank.CC_6_1.SavingsAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavingAccountTest {
    private SavingsAccount savingsAccount;

    @Before
    public void setup() {
        savingsAccount = new SavingsAccount();
    }

    @Test
    public void testDeposit() {
        savingsAccount.deposit(500);
        savingsAccount.deposit(1000);
        // Verify the balance after deposits
        assertEquals(1500, savingsAccount.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw_SufficientFunds() {
        savingsAccount.deposit(1000);
        savingsAccount.withdraw(500);
        // Verify the balance after withdrawal
        assertEquals(500, savingsAccount.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw_InsufficientFunds() {
        savingsAccount.deposit(300);
        savingsAccount.withdraw(500);
        // Verify the balance remains unchanged
        assertEquals(300, savingsAccount.getBalance(), 0.001);
    }

    @Test
    public void testCalculateInterest() {
        savingsAccount.deposit(1000);
        savingsAccount.calculateInterest(); // Adds 2% interest
        // Verify the new balance with interest
        assertEquals(1020, savingsAccount.getBalance(), 0.001);
    }

}

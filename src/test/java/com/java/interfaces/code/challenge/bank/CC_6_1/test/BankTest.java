package com.java.interfaces.code.challenge.bank.CC_6_1.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.java.interfaces.code.challenge.bank.CC_6_1.Account;
import com.java.interfaces.code.challenge.bank.CC_6_1.Bank;

import org.junit.Before;
import org.junit.Test;

public class BankTest {

    private Bank bank;

    @Before
    public void setup() {
        bank = new Bank();
    }

    @Test
    public void testAddAccount() {
        Account mockAccount = mock(Account.class); // Mock Account
        bank.addAccount(mockAccount);

        // Verify internal state
        assertEquals(1, bank.getAccounts().size());
        assertTrue(bank.getAccounts().contains(mockAccount));
    }

    @Test
    public void testInteractionsWithAccounts() {
        Account mockAccount = mock(Account.class);
        bank.addAccount(mockAccount);

        // Interact with mock account
        mockAccount.deposit(100);
        mockAccount.withdraw(50);

        // Verify interactions
        verify(mockAccount).deposit(100);
        verify(mockAccount).withdraw(50);
        verifyNoMoreInteractions(mockAccount);
    }
}

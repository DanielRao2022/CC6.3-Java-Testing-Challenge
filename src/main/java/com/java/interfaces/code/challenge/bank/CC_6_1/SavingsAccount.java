/*
 * Author: Bala Ravi
 * Filename: SavingsAccount.java
 * Date: 09/27/2024
 * 
 * Description: Savings Account where the Account interface class methods are implemented.
 * 
 */

package com.java.interfaces.code.challenge.bank.CC_6_1;

public class SavingsAccount implements Account{
	
    private double balance;

    //Start with initial Balance at $0
    public SavingsAccount() {
    	
        this.balance = 0;
        
    }
    
    //Method to Deposit Money in Savings Account
    @Override
    public void deposit(double amount) {
    	
        balance += amount;
        System.out.println("Deposited $" + amount + " to SavingsAccount.");
        
    }

    //Method to withdraw money from Savings Account
    @Override
    public void withdraw(double amount) {
    	
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from SavingsAccount.");
        } else {
            System.out.println("Insufficient funds in SavingsAccount.");
            
        }
    }

    // Method to calculate interest for Savings Account at 2% interest Rate
    @Override
    public void calculateInterest() {
    	
        double interest = balance * 0.02;
        balance += interest;
        System.out.println("Interest of $" + interest + " added to SavingsAccount.");
        
    }

    //Method to view Balance
    @Override
    public void viewBalance() {
    	
        System.out.println("SavingsAccount Balance: $" + balance);
        
    }
    // Method that returns total Balance
    // custom method for JUnit Testing added by -  Daniel
    public double getBalance() {
        return balance;
    }
}

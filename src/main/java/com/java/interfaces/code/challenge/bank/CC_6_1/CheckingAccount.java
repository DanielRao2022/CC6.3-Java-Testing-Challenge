/*
 * Author: Bala Ravi
 * Filename: CheckingAccount.java
 * Date: 09/27/2024
 * 
 * Description: Checkings Account where the Account interface class methods are implemented.
 * 
 */

package com.java.interfaces.code.challenge.bank.CC_6_1;

public class CheckingAccount implements Account{
	
    private double balance;

    // Starts Balance account at $0
    public CheckingAccount() {
    	
        this.balance = 0;
        
    }
    
    // Method to deposit money into Checking Account
    @Override
    public void deposit(double amount) {
    	
        balance += amount;
        System.out.println("Deposited $" + amount + " to CheckingAccount.");
        
    }

    //Method to withdraw money from Checking Account
    @Override
    public void withdraw(double amount) {
    	// Error check if client tries to withdraw more than what is available in their acount
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from CheckingAccount.");
        } 
        else {
            System.out.println("Insufficient funds in CheckingAccount.");
        }
        
    }

    //Method to Calculate interest for Checking. 0% hence no changes in balance
    @Override
    public void calculateInterest() {
    	
        System.out.println("No interest for CheckingAccount.");
        
    }

    //Method to View Balance amount in Account
    @Override
    public void viewBalance() {
    	
        System.out.println("CheckingAccount Balance: $" + balance);
        
    }
    
    // Method to deposit cash
    public void depositCash(double amount) {
    	
        deposit(amount);
        System.out.println("Deposited $" + amount + " cash to CheckingAccount.");
        
    }
    
    // Method to withdraw check with check number
    public void withdrawCheck(double amount, int checkNumber) {
    	
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " via check #" + checkNumber + " from CheckingAccount.");
        }
        else {
            System.out.println("Insufficient funds for check #" + checkNumber + ".");
        }
    }
    // Method that returns total Balance
    // custom method for JUnit Testing added by -  Daniel
    public double getBalance() {
        return balance;
    }
}

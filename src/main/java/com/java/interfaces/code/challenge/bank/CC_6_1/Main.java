/*
 * Author: Bala Ravi
 * Filename: Main.java
 * Date: 09/27/2024
 * 
 * Description: Driver Main Class that demos the functions of the Bank by adding an account
 * Performing transactions in the Saving and Checking Account and outputting the Balance
 * 
 */

package com.java.interfaces.code.challenge.bank.CC_6_1;

public class Main {
	
	public static void main(String[] args) {
		
        Bank bank = new Bank();
        
        // Create a SavingsAccount
        SavingsAccount savingsAccount = new SavingsAccount();
        
        savingsAccount.deposit(500);  // Deposit $500
        savingsAccount.deposit(1000); // Deposit $1000
        savingsAccount.withdraw(200); // Withdraw $200
        savingsAccount.calculateInterest(); // Calculate 2% interest
        savingsAccount.viewBalance(); // View balance
        
        // Add SavingsAccount to bank
        bank.addAccount(savingsAccount);
        
        // Create a CheckingAccount
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.depositCash(1000); // Cash deposit $1000
        checkingAccount.withdraw(600);     // Cash withdraw $600
        checkingAccount.withdrawCheck(100, 12345); // Check withdraw $100 with check number 12345
        checkingAccount.calculateInterest(); // Calculate interest (0%)
        checkingAccount.viewBalance(); // View balance
        
        // Add CheckingAccount to bank
        bank.addAccount(checkingAccount);
    }
}

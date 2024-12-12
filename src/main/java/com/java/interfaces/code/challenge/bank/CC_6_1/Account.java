/*
 * Author: Bala Ravi
 * Filename: Account.java
 * Date: 09/27/2024
 * 
 * Description: Account interface class that hold the empty methods to be implemented in the concrete class
 * 
 */

package com.java.interfaces.code.challenge.bank.CC_6_1;

public interface Account {

    //Empty methods to be impletemented in concrete class
    void deposit(double amount);
	
    void withdraw(double amount);
    
    void calculateInterest();
    
    void viewBalance();
    
}

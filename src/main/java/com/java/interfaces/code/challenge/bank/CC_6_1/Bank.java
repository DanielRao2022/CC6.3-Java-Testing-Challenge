/*
 * Author: Bala Ravi
 * Filename: Bank.java
 * Date: 09/27/2024
 * 
 * Description: Bank Class to hold the account information
 * 
 */

package com.java.interfaces.code.challenge.bank.CC_6_1;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    //Array list 
    private List<Account> accounts;
	
    public Bank() {
    	//create an array list called accounts
        accounts = new ArrayList<>();
        
    }

    //Method that adds an Account to the list
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Method that returns all the accounts in Bank
    // custom method for JUnit Testing added by -  Daniel
    public List<Account> getAccounts(){
        return accounts;
    }

}

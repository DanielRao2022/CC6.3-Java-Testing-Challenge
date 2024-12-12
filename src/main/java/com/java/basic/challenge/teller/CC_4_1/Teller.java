/* Author: Bala Ravi
 * Alias: balaxrav
 * File Name: Teller.java
 * Date: 08/29/2024
 * 
 * Description - Program that tracks the transaction made by customer to each teller in a single line
 * and outputs the result as Customers who visited each teller along with drawer balance at the end 
 * of all transactions. 
 */

package com.java.basic.challenge.teller.CC_4_1;
import java.util.*;


public class Teller {
	
	private List<String> tellerCustomers = new ArrayList<String>();
	//Creates a list to store the customer list that visit each teller
	
	private String name;
	//Name of teller
	
	//Get teller name method
	public String getName() {
		return name;
	}
	
	//Get teller customer list
	public List<String> getTellerCustomers() {
		return tellerCustomers;
	}
	
	//Add to customer list based on teller instance
	public void setTellerCustomers(String customer) {
		tellerCustomers.add(customer);
	}

	//Set name of teller
	public void setName(String name) {
		this.name = name;
	}

	//initial balance in drawer 
	private int balance = 2500;

	//get balance in drawer
	public int getBalance() {
		return balance;
	}
	
	//Add or subtract balance from drawer based on teller instance
	public void setBalance(int balance) {
		this.balance += balance;
	}


	//Method to print out the final results
	public void printDetails(String teller, int balance, List<String> CustomerList) {
		System.out.println(teller + " has a final balance in drawer of $" + balance+"\n");
		System.out.println("The list of people who visited " + teller + " are:\n");
		for (int i=0; i < CustomerList.size(); i++) {
			System.out.println(CustomerList.get(i));
		}
		System.out.println("======================================================");
	}

	
	//main method - Starting point of the program
	public static void main(String[] args) {
		final String[] customers = {
				  "Jennifer Figueroa", 
				  "Heather Mcgee", 
				  "Amanda Schwartz", 
				  "Nicole Yoder",
				  "Melissa Hoffman",
				  "Beatrice Helman",
				  "Louis Sanders",
				  "Catherine Altman",
				  "Ralph Estees",
				  "Samantha Augustine",
				  "Peter Fredricks",
				  "David Alters"
				 };
		
		//Instantiate teller objects, one teller per window
		// two window - two tellers - one line
		Teller teller1 = new Teller();
		Teller teller2 = new Teller();
		
		//Sets teller name - Any name can be given here
		teller1.setName("Teller 1");
		teller2.setName("Teller 2");
		
		
		//for loop to loop over each customer
		for (int customer = 0; customer < customers.length; customer++) {
			int transaction = 0;
			//checks if customer is going to teller 1
			if ((customer+1)%2 ==1) {
				//every 3rd customer subtract $250
				if ((customer+1)%3 ==0) {
					transaction = -250;
					teller1.setBalance(transaction);
					teller1.setTellerCustomers(customers[customer]);
				}
				//Every fifth customer add $475
				else if ((customer+1)%5 ==0) {
					transaction = 475;
					teller1.setBalance(transaction);
					teller1.setTellerCustomers(customers[customer]);
				}
				// Every other customer adds $100
				else{
					transaction = 100;
					teller1.setBalance(transaction);
					teller1.setTellerCustomers(customers[customer]);
				}
				
			}
			else {
				if ((customer+1)%3 ==0) {
					transaction = -250;
					teller2.setBalance(transaction);
					teller2.setTellerCustomers(customers[customer]);
				}
				else if ((customer+1)%5 ==0) {
					transaction = 475;
					teller2.setBalance(transaction);
					teller2.setTellerCustomers(customers[customer]);
				}
				else{
					transaction = 100;
					teller2.setBalance(transaction);
					teller2.setTellerCustomers(customers[customer]);
				}
				
			}
		}
		//System.out.println(teller1.getBalance1());
		//System.out.println(teller1.getTellerOneCustomers());
		
		//prints out the result as per Code Challenge requirements
		teller1.printDetails(teller1.getName(), teller1.getBalance(), teller1.getTellerCustomers());
		teller2.printDetails(teller2.getName(), teller2.getBalance(), teller2.getTellerCustomers());
		
		//Sample Output - 
		/*
		 * Teller 1 has a final balance in drawer of $2775
		 * 
		 * The list of people who visited Teller 1 are:
		 * 
		 * Jennifer Figueroa
		 * Amanda Schwartz
		 * Melissa Hoffman
		 * Louis Sanders
		 * Ralph Estees
		 * Peter Fredricks
		 * 
		 * ======================================================
		 * Teller 2 has a final balance in drawer of $2775
		 * 
		 * The list of people who visited Teller 2 are:
		 * 
		 * Heather Mcgee
		 * Nicole Yoder
		 * Beatrice Helman
		 * Catherine Altman
		 * Samantha Augustine
		 * David Alters
		 * ======================================================
		*/
		
	}

}

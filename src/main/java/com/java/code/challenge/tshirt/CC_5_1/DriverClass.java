/* Author: Bala Ravi
 * Date: 09/12/2024
 * Filename: DriverClass.java
 * 
 * Description: Driver class that will take input from salesperson to process and share the output
 */

package com.java.code.challenge.tshirt.CC_5_1;
import java.util.*;

public class DriverClass {
	
	public static void main(String[] args) {
		//initial CustomTee instance child of TeeShirt
		//Initialize Scanner object
		boolean moreOrders = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to TREE Shirts Inc.");
		CustomTee shirt = new CustomTee();
		
		//While loop to continue as long as customer wants to continue ordering
		
		while (moreOrders) {
		
		//inputting all the required fields and storing them in private variables using the class methods
		
		System.out.print("Enter Order Number >> ");
		
		String orderNumber = scan.nextLine();
		
		//adding value to String list variable so they can use when printing
		shirt.setOrderNumber(orderNumber);
		shirt.addOrders(shirt.getOrderNumber());
		
		System.out.print("Enter Color >> ");
		String color = scan.nextLine();
		
		shirt.setColor(color);
		shirt.addColors(shirt.getColor());
		
		System.out.print("Enter Size (S/M/L/XL/XXL/XXXL) >> ");
		String size = scan.nextLine();
		
		shirt.setSize(size);
		shirt.addSizes(shirt.getSize());
		shirt.setPrice(shirt.updatePrice(size));
		shirt.addPrices(shirt.getPrice());
		
		//additional logic to handle yes or no regardless of case
		System.out.print("Is it custom Tee? (Y/N) ");
		String customTee = scan.nextLine();
		customTee = customTee.toLowerCase();
		if (customTee.equals("y") || customTee.equals("yes")) {
			shirt.setCustomInput(customTee);
		}
		//System.out.println(customTee);
		if (customTee.equals("y") || customTee.equals("yes")) {
			System.out.print("Enter slogan for shirt >> ");
			String customMessage = scan.nextLine();
			shirt.addSlogan(customMessage);
		}
		else {
			shirt.addSlogan("");
		}
		
		System.out.print("Continue (Y/N)? ");
		String keepGoing = scan.nextLine();
		//System.out.println(keepGoing);
		
		//Stops order if customer or user is done adding shirts (End Order) --> Checkout
		if (keepGoing.equals("N") || keepGoing.equals("n") || keepGoing.equals("no")) {
			moreOrders = false;
		}
		}
		scan.close();
		//print function to print the output is desired format
		shirt.printFunction(shirt.getOrderList(), shirt.getColorList(), shirt.getSizeList(), shirt.getPriceList(),shirt.getSlogan());
		System.out.println("Thanks for shopping at TREE Shirts Inc.");
	}

}

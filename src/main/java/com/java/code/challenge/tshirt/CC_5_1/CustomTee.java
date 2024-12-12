/* Author: Bala Ravi
 * Date: 09/12/2024
 * Filename: CustomTee.java
 * 
 * Description: Subclass of superclass TeeShirt.java which processes Custom Message
 */
package com.java.code.challenge.tshirt.CC_5_1;

import java.util.ArrayList;
import java.util.List;

public class CustomTee extends TeeShirt {
	
	//additional variables for CustomTee are for slogan messages both as String and String List
	
	private String customMessage;
	private List<String> slogan = new ArrayList<String>();

	public List<String> getSlogan() {
		return slogan;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}
	
	// Adds slogan to list, no slogan adds empty string so the size is consistent across all lists
	public void addSlogan(String input) {
		slogan.add(input);
	}
	
	//print function to output results at end of Order processing
	public void printFunction(List<String> orderNumber, List<String> color, List<String> size, List<Double> price, List<String> slogan) {
		for (int i = 0; i < orderNumber.size(); i++) {
			System.out.println("Order #" + orderNumber.get(i));
			System.out.println("Description: " + size.get(i) + " "+ color.get(i));
			System.out.println("Price: $" + price.get(i));
			String holder = slogan.get(i);
			
			//Special case to evaluate printing if there is slogan message present
			if(!holder.isEmpty()) {
				System.out.println("Slogan: " + holder);
			}
		}
	}


}

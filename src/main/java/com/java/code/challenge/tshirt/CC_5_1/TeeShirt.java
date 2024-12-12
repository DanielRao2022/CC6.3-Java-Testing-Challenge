/* Author: Bala Ravi
 * Date: 09/12/2024
 * Filename: TeeShirt.java
 * 
 * Description: Class that processes an order for customer by prompting info for Salesperson to create an order
 */

package com.java.code.challenge.tshirt.CC_5_1;
import java.util.*;

public class TeeShirt {
	//initializing private variables to storage values for order processing
	private String orderNumber;
	private String color;
	private String size;
	private boolean custom;
	private double price;
	private String customInput;
	private List<String> orderList = new ArrayList<String>();
	private List<String> colorList = new ArrayList<String>();
	private List<String> sizeList = new ArrayList<String>();
	private List<Double> priceList = new ArrayList<Double>();
	
	//Setting up get and set method for all variables above
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public boolean isCustom() {
		return custom;
	}
	
	public List<String> getOrderList() {
		return orderList;
	}
	public List<String> getColorList() {
		return colorList;
	}
	public List<String> getSizeList() {
		return sizeList;
	}
	public List<Double> getPriceList() {
		return priceList;
	}
	public void setCustom(boolean custom) {
		this.custom = custom;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCustomInput() {
		return customInput;
	}
	public void setCustomInput(String customInput) {
		this.customInput = customInput;
	}
	// Methods that append values into the list variables
	public void addOrders(String input) {
		orderList.add(input);
	}
	
	public void addColors(String input) {
		colorList.add(input);
	}
	
	public void addSizes(String input) {
		sizeList.add(input);
	}
	
	public void addPrices(double input) {
		priceList.add(input);
	}
	
	//Method to update prices of shirt based on size
	public double updatePrice(String size) {
		if (size.equals("XL") || size.equals("XXL") || size.equals("XXXL")) {
			return 22.99;
		}
		else {
			return 19.99;
		}
	}
	
}

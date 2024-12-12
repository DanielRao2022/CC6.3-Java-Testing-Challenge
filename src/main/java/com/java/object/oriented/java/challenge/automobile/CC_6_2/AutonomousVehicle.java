/*
 * Author - Bala Ravi
 * Filename - AutonomousVehicle.java
 * Date - 10/11/2024
 * 
 * Description - Parent class with getters, setters, constructor and final direction methods. 
 */

package com.java.object.oriented.java.challenge.automobile.CC_6_2;

import java.util.List;

public class AutonomousVehicle {
	
	private int autonomyLevel;
	private String make;
	private String model;
	private String color;
	private String direction;
	
	public int getAutonomyLevel() {
		return autonomyLevel;
	}


	public void setAutonomyLevel(int autonomyLevel) {
		this.autonomyLevel = autonomyLevel;
	}
	
	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	// Constructor for AutonomousVehicle class
	public AutonomousVehicle(int autonomyLevel, String make, String model, String color) {
		this.setAutonomyLevel(autonomyLevel);
		this.make = make;
		this.model = model;
		this.color = color;
		this.direction = "N";
	}
	

	// Method to get the final direction based on a series of turns
    public void finalDirection(List<String> turns) {
        String[] directions = {"N", "E", "S", "W"};
        int index = 0; // Start facing North
        for (String turn : turns) {
            if (turn.equals("L")) {
                index = (index - 1 + 4) % 4; // Counter-clockwise turn (left)
            } else if (turn.equals("R")) {
                index = (index + 1) % 4; // Clockwise turn (right)
            }
        }
        this.direction = directions[index];
    }
    
    @Override
    public String toString() {
        return "AutonomousVehicle{" + "autonomyLevel=" + getAutonomyLevel() +", make='" + make + '\'' +
                ", model='" + model + '\'' +", color='" + color + '\'' +", direction='" + direction + '\'' +'}';
	}


}

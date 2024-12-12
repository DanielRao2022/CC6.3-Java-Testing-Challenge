/*
 * Author - Bala Ravi
 * Filename - AutonomousVehicle.java
 * Date - 10/11/2024
 * 
 * Description - Child Tesla class with constructor and toString method.
 */

package com.java.object.oriented.java.challenge.automobile.CC_6_2;

public class Tesla extends AutonomousVehicle{
	
	private String network;
	
	// Constructor for Tesla class
    public Tesla(int autonomyLevel, String model, String color) {
        super(autonomyLevel, "Tesla", model, color);
        this.network = "Autopilot";
    }

    public String getNetwork(){
        return network;
    }

    @Override
    public String toString() {
        return "Tesla{" +
                "network='" + network + '\'' +
                ", autonomyLevel=" + super.getAutonomyLevel() +
                ", make='" + super.getMake() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", direction='" + super.getDirection() + '\'' +
                '}';
    }
}

/*
 * Author - Bala Ravi
 * Filename - AutonomousVehicle.java
 * Date - 10/11/2024
 * 
 * Description - Child GM class with vehicle type, constructor and toString method.
 */

package com.java.object.oriented.java.challenge.automobile.CC_6_2;

import java.util.List;
import java.util.Arrays;

public class GM extends AutonomousVehicle{
	public String vehicleType;
	
    // Constructor for GM class
    public GM(int autonomyLevel, String model, String color, String vehicleType) {
        super(autonomyLevel, "GM", model, color);
        if (isValidVehicleType(vehicleType)) {
            this.vehicleType = vehicleType;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type. Choose from 'pod', 'robotaxi', or 'car'.");
        }
    }
    
    // Method to check if the vehicle type is valid
    private boolean isValidVehicleType(String vehicleType) {
        List<String> validTypes = Arrays.asList("pod", "robotaxi", "car");
        return validTypes.contains(vehicleType.toLowerCase());
    }
    
    @Override
    public String toString() {
        return "GM{" +
                "vehicleType='" + vehicleType + '\'' +
                ", autonomyLevel=" + super.getAutonomyLevel() +
                ", make='" + super.getMake() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", direction='" + super.getDirection() + '\'' +
                '}';
    }
}

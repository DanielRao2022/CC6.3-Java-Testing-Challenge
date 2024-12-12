/*
 * Author - Bala Ravi
 * Filename - AutonomousVehicle.java
 * Date - 10/11/2024
 * 
 * Description - Child Toyota class with is Lyft, constructor and toString method.
 */

package com.java.object.oriented.java.challenge.automobile.CC_6_2;

import java.util.Calendar;

public class Toyota extends AutonomousVehicle{
	
	private boolean isLyft;
	
    // Constructor for Toyota class
    public Toyota(int autonomyLevel, String model, String color) {
        super(autonomyLevel, "Toyota", model, color);
        this.isLyft = isLyftVehicle();
    }
    
    // Method to identify if the current autonomous vehicle is a Lyft vehicle
    private boolean isLyftVehicle() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        // If today is Saturday or Sunday, it's a Lyft vehicle
        return (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);
    }
    
    @Override
    public String toString() {
        return "Toyota{" +
                "isLyft=" + isLyft +
                ", autonomyLevel=" + super.getAutonomyLevel() +
                ", make='" + super.getMake() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", direction='" + super.getDirection() + '\'' +
                '}';
    }

    // custom method to get if its lyft or not.
    public boolean getIsLyft(){
        return isLyft;
    }
}

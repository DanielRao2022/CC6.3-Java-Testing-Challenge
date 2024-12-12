/*
 * Author - Bala Ravi
 * Filename - AutonomousVehicle.java
 * Date - 10/11/2024
 * 
 * Description - Driver function that calls all child classes, and gets each final directions based on instructions provided. 
 */

package com.java.object.oriented.java.challenge.automobile.CC_6_2;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		
		// Instantiate the cars
        Tesla car1 = new Tesla(5, "Model S", "Red");
        Toyota car2 = new Toyota(2, "Corolla", "Blue");
        GM car3 = new GM(3, "Cruise AV", "White", "robotaxi");
        
        // Define turns for each car
        List<String> turnsCar1 = new ArrayList<>(Arrays.asList("L", "L", "L"));
        List<String> turnsCar2 = new ArrayList<>(Arrays.asList("R", "R", "R", "L"));
        List<String> turnsCar3 = new ArrayList<>(Arrays.asList("R", "R", "R", "R"));
        
        // Set the final direction for each car
        car1.finalDirection(turnsCar1);
        car2.finalDirection(turnsCar2);
        car3.finalDirection(turnsCar3);
        
        // Print the details of each car
        System.out.println("Tesla Car makes the following turns: " + turnsCar1);
        System.out.println(car1);
        System.out.println();
        System.out.println("Toyota Car makes the following turns: " + turnsCar1);
        System.out.println(car2);
        System.out.println();
        System.out.println("GM Car makes the following turns: " + turnsCar1);
        System.out.println(car3);

	}

}

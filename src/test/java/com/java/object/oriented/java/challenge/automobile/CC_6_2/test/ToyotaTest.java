package com.java.object.oriented.java.challenge.automobile.CC_6_2.test;

import com.java.object.oriented.java.challenge.automobile.CC_6_2.Toyota;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class ToyotaTest {

    @Test
    public void testToyotaConstructor() {
        // Create a Toyota instance
        Toyota toyota = new Toyota(3, "Corolla", "White");

        // Validate constructor properties
        assertEquals(3, toyota.getAutonomyLevel());
        assertEquals("Toyota", toyota.getMake());
        assertEquals("Corolla", toyota.getModel());
        assertEquals("White", toyota.getColor());
    }

    @Test
    public void testIsLyftVehicle() {
        // Create a Toyota instance
        Toyota toyota = new Toyota(3, "Camry", "Blue");

        // Check whether it is a Lyft vehicle based on the current day
        boolean isLyftExpected = isTodaySaturdayOrSunday();
        assertEquals(isLyftExpected, toyota.getIsLyft());
    }

    // Utility method to calculate if today is Saturday or Sunday
    private boolean isTodaySaturdayOrSunday() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);
    }
}

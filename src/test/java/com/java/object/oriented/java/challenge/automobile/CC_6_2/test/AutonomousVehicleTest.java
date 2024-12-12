package com.java.object.oriented.java.challenge.automobile.CC_6_2.test;

import com.java.object.oriented.java.challenge.automobile.CC_6_2.AutonomousVehicle;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AutonomousVehicleTest {

    @Test
    public void testConstructorInitialization() {
        AutonomousVehicle vehicle = new AutonomousVehicle(5, "Tesla", "Model X", "Black");

        assertEquals(5, vehicle.getAutonomyLevel());
        assertEquals("Tesla", vehicle.getMake());
        assertEquals("Model X", vehicle.getModel());
        assertEquals("Black", vehicle.getColor());
        assertEquals("N", vehicle.getDirection());
    }

    @Test
    public void testFinalDirection() {
        AutonomousVehicle vehicle = new AutonomousVehicle(5, "Tesla", "Model X", "Black");

        List<String> turns = Arrays.asList("L", "L", "R");
        vehicle.finalDirection(turns);

        assertEquals("W", vehicle.getDirection());
    }

    @Test
    public void testFinalDirectionInvalidTurns() {
        AutonomousVehicle vehicle = new AutonomousVehicle(5, "Tesla", "Model X", "Black");

        List<String> turns = Arrays.asList("L", "X", "R", "L");
        vehicle.finalDirection(turns);

        assertEquals("W", vehicle.getDirection()); // Only valid turns should be processed
    }
}

package com.java.object.oriented.java.challenge.automobile.CC_6_2.test;

import com.java.object.oriented.java.challenge.automobile.CC_6_2.Tesla;
import org.junit.Test;
import static org.junit.Assert.*;

public class TeslaTest {

    @Test
    public void testTeslaConstructor() {
        Tesla tesla = new Tesla(5, "Model 3", "Red");

        assertEquals(5, tesla.getAutonomyLevel());
        assertEquals("Tesla", tesla.getMake());
        assertEquals("Model 3", tesla.getModel());
        assertEquals("Red", tesla.getColor());
        assertEquals("Autopilot", tesla.getNetwork());
    }
}


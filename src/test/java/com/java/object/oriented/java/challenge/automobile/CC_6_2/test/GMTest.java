package com.java.object.oriented.java.challenge.automobile.CC_6_2.test;

import com.java.object.oriented.java.challenge.automobile.CC_6_2.GM;
import org.junit.Test;
import static org.junit.Assert.*;

public class GMTest {

    @Test
    public void testGMConstructorValidType() {
        GM gm = new GM(4, "Cruise AV", "White", "robotaxi");

        assertEquals(4, gm.getAutonomyLevel());
        assertEquals("GM", gm.getMake());
        assertEquals("Cruise AV", gm.getModel());
        assertEquals("White", gm.getColor());
        assertEquals("robotaxi", gm.vehicleType);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGMConstructorInvalidType() {
        new GM(4, "Cruise AV", "White", "invalidType");
    }
}

package com.java.code.challenge.tshirt.CC_5_1.test;

import com.java.code.challenge.tshirt.CC_5_1.CustomTee;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class CustomTeeTest {

    @Test
    public void testConstructorInitializesFieldsCorrectly() {
        CustomTee customTee = new CustomTee();

        // Validate the slogan list is initialized and empty
        assertNotNull("Slogan list should not be null", customTee.getSlogan());
        assertTrue("Slogan list should be empty", customTee.getSlogan().isEmpty());

        // Validate inherited lists are initialized and empty
        assertNotNull("Order list should not be null", customTee.getOrderList());
        assertTrue("Order list should be empty", customTee.getOrderList().isEmpty());

        assertNotNull("Color list should not be null", customTee.getColorList());
        assertTrue("Color list should be empty", customTee.getColorList().isEmpty());

        assertNotNull("Size list should not be null", customTee.getSizeList());
        assertTrue("Size list should be empty", customTee.getSizeList().isEmpty());

        assertNotNull("Price list should not be null", customTee.getPriceList());
        assertTrue("Price list should be empty", customTee.getPriceList().isEmpty());
    }

    @Test
    public void testAddSlogan() {
        CustomTee customTee = new CustomTee();
        customTee.addSlogan("Hello World!");
        List<String> sloganList = customTee.getSlogan();

        assertEquals(1, sloganList.size());
        assertEquals("Hello World!", sloganList.get(0));
    }

    @Test
    public void testInheritedMethods() {
        CustomTee customTee = new CustomTee();
        customTee.addOrders("123");
        customTee.addColors("Blue");
        customTee.addSizes("M");
        customTee.addPrices(19.99);

        // Validate inherited functionality
        assertEquals(1, customTee.getOrderList().size());
        assertEquals("123", customTee.getOrderList().get(0));

        assertEquals(1, customTee.getColorList().size());
        assertEquals("Blue", customTee.getColorList().get(0));

        assertEquals(1, customTee.getSizeList().size());
        assertEquals("M", customTee.getSizeList().get(0));

        assertEquals(1, customTee.getPriceList().size());
        assertEquals(19.99, customTee.getPriceList().get(0), 0.001);
    }

    @Test
    public void testPrintFunction() {
        CustomTee customTee = new CustomTee();
        customTee.addOrders("123");
        customTee.addColors("Blue");
        customTee.addSizes("M");
        customTee.addPrices(19.99);
        customTee.addSlogan("Custom Logo");

        // Simulate the expected print output
        String expectedOutput = "Order #123\nDescription: M Blue\nPrice: $19.99\nSlogan: Custom Logo";
        // You can capture the output stream here and validate it matches expectedOutput
        // Example: Use SystemLambda or similar to capture System.out.print
    }
}

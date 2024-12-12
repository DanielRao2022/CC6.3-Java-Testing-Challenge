package com.java.code.challenge.tshirt.CC_5_1.test;
import com.java.code.challenge.tshirt.CC_5_1.TeeShirt;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TeeShirtTest {

    @Test
    public void testConstructorInitializesFieldsCorrectly() {
        TeeShirt teeShirt = new TeeShirt();

        // Validate that the lists are initialized and empty
        assertNotNull("Order list should not be null", teeShirt.getOrderList());
        assertTrue("Order list should be empty", teeShirt.getOrderList().isEmpty());

        assertNotNull("Color list should not be null", teeShirt.getColorList());
        assertTrue("Color list should be empty", teeShirt.getColorList().isEmpty());

        assertNotNull("Size list should not be null", teeShirt.getSizeList());
        assertTrue("Size list should be empty", teeShirt.getSizeList().isEmpty());

        assertNotNull("Price list should not be null", teeShirt.getPriceList());
        assertTrue("Price list should be empty", teeShirt.getPriceList().isEmpty());
    }

    @Test
    public void testSetAndGetOrderNumber() {
        TeeShirt teeShirt = new TeeShirt();
        teeShirt.setOrderNumber("123");
        assertEquals("123", teeShirt.getOrderNumber());
    }

    @Test
    public void testUpdatePrice() {
        TeeShirt teeShirt = new TeeShirt();

        // Validate the price for various sizes
        assertEquals(22.99, teeShirt.updatePrice("XL"), 0.001);
        assertEquals(22.99, teeShirt.updatePrice("XXL"), 0.001);
        assertEquals(19.99, teeShirt.updatePrice("M"), 0.001);
    }

    @Test
    public void testAddOrders() {
        TeeShirt teeShirt = new TeeShirt();
        teeShirt.addOrders("123");
        List<String> orderList = teeShirt.getOrderList();

        assertEquals(1, orderList.size());
        assertEquals("123", orderList.get(0));
    }

    @Test
    public void testAddColors() {
        TeeShirt teeShirt = new TeeShirt();
        teeShirt.addColors("Red");
        List<String> colorList = teeShirt.getColorList();

        assertEquals(1, colorList.size());
        assertEquals("Red", colorList.get(0));
    }

    @Test
    public void testAddSizes() {
        TeeShirt teeShirt = new TeeShirt();
        teeShirt.addSizes("M");
        List<String> sizeList = teeShirt.getSizeList();

        assertEquals(1, sizeList.size());
        assertEquals("M", sizeList.get(0));
    }

    @Test
    public void testAddPrices() {
        TeeShirt teeShirt = new TeeShirt();
        teeShirt.addPrices(19.99);
        List<Double> priceList = teeShirt.getPriceList();

        assertEquals(1, priceList.size());
        assertEquals(19.99, priceList.get(0), 0.001);
    }
}

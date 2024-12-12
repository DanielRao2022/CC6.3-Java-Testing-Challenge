package com.java.basic.challenge.teller.CC_4_1.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.java.basic.challenge.teller.CC_4_1.Teller;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class TellerTest {

    private Teller teller;

    @Before
    public void setUp() {
        // Initialize a new Teller object before each test
        teller = new Teller();
        teller.setName("Test Teller");
    }

    @Test
    public void testSetNameAndGetName() {
        // Test setter and getter for name
        teller.setName("Teller 1");
        assertEquals("Teller 1", teller.getName());
    }

    @Test
    public void testSetAndGetBalance() {
        // Test initial balance
        assertEquals(2500, teller.getBalance());

        // Add to balance
        teller.setBalance(100);
        assertEquals(2600, teller.getBalance()); // Initial balance + 100 = 2600

        // Subtract from balance
        teller.setBalance(-200);
        assertEquals(2400, teller.getBalance()); // 2600 - 200 = 2400
    }

    @Test
    public void testSetAndGetTellerCustomers() {
        // Test adding customers and retrieving the list
        teller.setTellerCustomers("Customer A");
        teller.setTellerCustomers("Customer B");

        List<String> customers = teller.getTellerCustomers();
        assertEquals(2, customers.size());
        assertEquals("Customer A", customers.get(0));
        assertEquals("Customer B", customers.get(1));
    }

    @Test
    public void testPrintDetails() {
        // Redirect system output to test printDetails method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Add dummy customers and set balance
        teller.setTellerCustomers("Customer A");
        teller.setTellerCustomers("Customer B");
        teller.setBalance(100);

        // Print details
        teller.printDetails(teller.getName(), teller.getBalance(), teller.getTellerCustomers());

        // Capture the output and verify
        String expectedOutput = "Test Teller has a final balance in drawer of $2600\n" +
                "\n" +
                "The list of people who visited Test Teller are:\n" +
                "\n" +
                "Customer A\n" +
                "Customer B\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}

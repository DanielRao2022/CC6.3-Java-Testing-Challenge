package com.java.stacks.queues.CC_7_2.test;
import com.java.stacks.queues.CC_7_2.EvenQueueOddStack;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EvenQueueOddStackTest {

    @Test
    public void testProcessNumbersWithMixedInput() {
        int[] input = {2, 3, 4, 5, 6};

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method
        EvenQueueOddStack.processNumbers(input);

        // Expected output
        String expectedOutput =
                "Even numbers in the order entered:\n" +
                        "2 4 6 \n" +
                        "\nSum of all even numbers: 12\n" +
                        "\nOdd numbers in reverse order:\n" +
                        "5 3 \n" +
                        "\nSum of all odd numbers: 8\n";

        // Assert the output
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    public void testProcessNumbersWithAllEven() {
        int[] input = {2, 4, 6, 8, 10};

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method
        EvenQueueOddStack.processNumbers(input);

        // Expected output
        String expectedOutput =
                "Even numbers in the order entered:\n" +
                        "2 4 6 8 10 \n" +
                        "\nSum of all even numbers: 30\n" +
                        "\nOdd numbers in reverse order:\n" +
                        "\n\nSum of all odd numbers: 0\n";

        // Assert the output
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    public void testProcessNumbersWithAllOdd() {
        int[] input = {1, 3, 5, 7, 9};

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method
        EvenQueueOddStack.processNumbers(input);

        // Expected output
        String expectedOutput =
                "Even numbers in the order entered:\n" +
                        "\n" +
                        "\nSum of all even numbers: 0\n" +
                        "\nOdd numbers in reverse order:\n" +
                        "9 7 5 3 1 \n" +
                        "\nSum of all odd numbers: 25\n";

        // Assert the output
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    public void testProcessNumbersWithEmptyInput() {
        int[] input = {};

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method
        EvenQueueOddStack.processNumbers(input);

        // Expected output
        String expectedOutput =
                "Even numbers in the order entered:\n" +
                        "\n" +
                        "\nSum of all even numbers: 0\n" +
                        "\nOdd numbers in reverse order:\n" +
                        "\n" +
                        "\nSum of all odd numbers: 0";

        // Assert the output
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    public void testProcessNumbersWithNegativeNumbers() {
        int[] input = {-2, -3, -4, -5, -6};

        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method
        EvenQueueOddStack.processNumbers(input);

        // Expected output
        String expectedOutput =
                "Even numbers in the order entered:\n" +
                        "-2 -4 -6 \n" +
                        "\nSum of all even numbers: -12\n" +
                        "\nOdd numbers in reverse order:\n" +
                        "-5 -3 \n" +
                        "\nSum of all odd numbers: -8\n";

        // Assert the output
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }
}

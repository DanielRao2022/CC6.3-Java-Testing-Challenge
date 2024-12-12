/*
 * Author - Bala Ravi
 * Date - 10/25/2024
 * Filename - EvenQueueOddStack.java
 *
 * Description - Using Arrays as queues for Even numbers and Stacks for Odd Numbers
 */

package com.java.stacks.queues.CC_7_2;

import java.util.Scanner;

public class EvenQueueOddStack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Accept numbers from the user and store them in String Array

        System.out.println("Enter numbers separated by spaces:");

        String[] input = scanner.nextLine().split(" ");

        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        //Process the stored numbers by calling processNumbers Method

        processNumbers(numbers);
        scanner.close();
    }

    public static void processNumbers(int[] numbers) {

        // Arrays to act as queue for evens and stack for odds

        int[] evenQueue = new int[numbers.length];

        int[] oddStack = new int[numbers.length];

        int evenCount = 0;
        int oddCount = 0;
        int evenSum = 0;
        int oddSum = 0;

        // Separate even and odd numbers, storing them in evenQueue and oddStack

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenQueue[evenCount++] = number;
                evenSum += number;
            } else {
                oddStack[oddCount++] = number;
                oddSum += number;
            }
        }
        //Print all even numbers in the order they were entered
        System.out.println("Even numbers in the order entered:");

        for (int i = 0; i < evenCount; i++) {
            System.out.print(evenQueue[i] + " ");
        }
        System.out.println("\n");

        //Print the sum of all even numbers
        System.out.println("Sum of all even numbers: " + evenSum + "\n");

        //Print all odd numbers in the opposite order they were entered
        System.out.println("Odd numbers in reverse order:");

        for (int i = oddCount - 1; i >= 0; i--) {
            System.out.print(oddStack[i] + " ");
        }

        System.out.println("\n");
        //Print the sum of all odd numbers
        System.out.println("Sum of all odd numbers: " + oddSum);
    }
}

package edu.umsl;
import java.util.InputMismatchException;
import java.util.Scanner;


public class recursivefunction {

    public static void main(String args[]) {
        int nth = 0;
        boolean retry = false;

        do {
            do {
                try {
                    retry = false;
                    System.out.println("Please input a positive integer:");
                    Scanner input = new Scanner(System.in);
                    nth = input.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("That is not an integer.");
                    retry = true;
                }
            } while (retry);
        } while (nth < 0);

        System.out.println("Recursion...");
        int result = recursion(nth);
        System.out.println("Fibonacci Number: " + result);
    }

    public static int recursion(int nth) {
        if (nth <= 1) {
            return nth;
        } else {
            return recursion(nth - 1) + recursion(nth - 2);
        }
    }
}

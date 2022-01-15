package edu.umsl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class runningtime {
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
        long recursionStart = System.currentTimeMillis();
        int recursionResult = recursion(nth);
        System.out.println("Time: " + (System.currentTimeMillis() - recursionStart) + "ms");
        System.out.println("Fibonacci Number: " + recursionResult + "\n");

        System.out.println("Iteration...");
        long iterationStart = System.currentTimeMillis();
        int iterateResult = iterate(nth);
        System.out.println("Time: " + (System.currentTimeMillis() - iterationStart) + "ms");
        System.out.println("Fibonacci Number: " + iterateResult);
    }

    public static int recursion(int nth) {
        if (nth <= 1) {
            return nth;
        } else {
            return recursion(nth - 1) + recursion(nth - 2);
        }
    }

    public static int iterate(int nth) {
        int F = 1;
        int FZero = 0;
        int FOne;
        for (int i = 1; i < nth; i++) {
            FOne = FZero;
            FZero = F;
            F = FOne + FZero;
        }
        return F;
    }
}

package edu.umsl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class fibonacciarrays {
    public static void main(String args[]) {

        boolean retry = false;
        int size = 0;

        do {
            do {
                try {
                    retry = false;
                    System.out.println("Please input a positive number of digits between (2-100):");
                    Scanner input = new Scanner(System.in);
                    size = input.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("That is not an integer.");
                    retry = true;
                }
            } while (retry);
            if (size < 2 || size > 100) {
                System.out.println("Numbers 1 and below and 101 and above are not allowed.");
            }
        } while (size < 2 || size > 100);

        System.out.println("The biggest Fibonacci number that has less than " + size + " digits is " + getBiggestFibonacci(size));
    }

    public static String getBiggestFibonacci(int size) {
        String result = "";
        int n = 0;
        int[] fibonacci;

        if (size == 2){
            result = "8";
            return result;
        }

        while (true) {
            fibonacci = getFibArrays(n, size - 2);

            if (fibonacci[0] != 0) {
                break;
            }
            n++;
        }

        int low = n;
        int[] fibAbove;
        while (true) {
            fibAbove = getFibArrays(n, size - 1);

            if (fibAbove[0] != 0) {
                break;
            }
            n++;
        }

        int high = n;
        for (int i = low; i <= high; i++) {
            int[] f = getFibArrays(i, size - 1);
            if (arrayToString(f).length() >= size) {
                n = i - 1;
                break;
            }
        }

        result = arrayToString(getFibArrays(n, size - 1));
        return result;
    }

    public static int[] getFibArrays(int n, int size) {
        int[] fibArray1 = new int[size];
        int[] fibArray2 = new int[size];
        int[] fibResultArray = new int [size + 1];

        for (int i = 0; i < size; i++) {
            fibArray1[i] = fibArray2[i] = fibResultArray[i] = 0;
        }

        if (n == 0) {
            return (addArrays(fibArray1, fibArray1));
        }

        if (n == 1) {
            fibArray2[size - 1] = 1;
            return (addArrays(fibArray1, fibArray2));
        }

        fibArray2[size - 1] = 1;
        for (int i = 0; i < n - 1; i++) {
            fibResultArray = addArrays(fibArray1, fibArray2);
            fibArray1 = fibArray2;

            int[] fibArray2Temp = new int[fibArray2.length];
            for (int j = 0; j < fibArray2.length; j++) {
                fibArray2Temp[j] = fibResultArray[j + 1];
            }
            fibArray2 = fibArray2Temp;
        }
        return fibResultArray;
    }

    public static int[] addArrays(int[] array1, int[] array2) {
        int size = array1.length;
        int[] arrayTotal = new int[size + 1];
        for (int i = 0; i < size; i++) {
            arrayTotal[i] = 0;
        }

        int  remainder = 0;
        for (int i = size - 1; i >= 0; i--) {
            int temp = array1[i] + array2[i] + remainder;
            arrayTotal[i + 1] = temp % 10;
            remainder = temp / 10;
        }
        arrayTotal[0] = remainder;

        return arrayTotal;
    }

    public static String arrayToString(int[] array) {
        String stringArray = "";
        for (int i = 0; i < array.length; i++) {
            stringArray = stringArray + array[i];
        }

        return stringArray.replaceFirst("^0(?!$)", "");
    }
}
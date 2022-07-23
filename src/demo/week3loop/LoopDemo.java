package demo.week3loop;

import java.util.Arrays;

public class LoopDemo {
    /*
    suppose we have an array, and an int m
    subtract a consecutive part of m elements in the array
    so that the remaining sum is the minimum.
    i.e, find a consecutive part of m elements in the array
    that has the max sum
    return the result of the sum of the array
    after these numbers are subtracted
     */
    static int getResultInefficient(int[] array, int m) {
        int max = 0;
        int sum = 0;
        // inefficient solution (redundant calculations)
        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            int current = 0;
            for (int j = i; j < m; j++) {
                current += array[j];
            }

            max = Math.max(current, max);
        }

        return sum - max;
    }

    static int getResultEfficient(int[] array, int m) {
        int previous = 0;
        // sum first m elements
        for (int i = 0; i < m; i++) {
            previous += array[i];
        }

        int max = previous;
        int sum = previous; // sum of whole array

        for (int i = m; i < array.length; i++) {
            sum += array[i];

            int current = previous + array[i];
            current -= array[i - m];
            max = Math.max(current, max);
        }

        return sum - max;
    }

    // E.g. 1: Get array of squares from 1 (e.g. {1, 4, 9, 16})
    // parameter: length of the array
    static int[] getArrayOfIntSquares(int length) {
        int[] result = new int[length];
        for (int i = 1; i <= result.length; i++) {
            result[i - 1] = i * i;
        }
        // or:
        for (int i = 0; i < result.length; i++) {
            result[i] = (i + 1) * (i + 1);
        }
        return result;
    }

    // E.g. 2: Get the average value of an int array
    static double average(int[] array) {
        double result = 0.0;
        for (int a : array) {
            result += a; // calculate total
        }
        return result / array.length; // average = total / number of elements
    }

    static double averageRecursive(int[] array) {
        if (array.length == 0) return 0.0;
        else {
            int newLength = array.length - 1;
            int[] a = Arrays.copyOf(array, newLength);

            return (array[newLength] + newLength * averageRecursive(a)) / array.length;
        }
    }

    // E.g. 3: Get the maximum value of an int array
    static int maximum(int[] array) {
        int result = array[0];
        for (int a : array) {
            result = Math.max(result, a);
        }
        return result;
    }

    static int maximumRecursive(int[] array) {
        if (array.length == 0)
            return 0;
        else {
            int newLength = array.length - 1;
            int[] a = Arrays.copyOf(array, newLength);
            return Math.max(array[newLength], maximumRecursive(a));
        }
    }

    // E.g. 4: Print reverse of a String
    static void printReverse(String string) {
        for (int i = string.length() - 1; i >= 0; i--) {
            System.out.print(string.charAt(i));
        }
        System.out.println();
    }

    static void printReverseRecursive(String string) {
        if (string.length() != 0) {
            printReverseRecursive(string.substring(1));
            System.out.print(string.charAt(0));
        }
    }

    // E.g. 5: Print a pyramid of * based on the height
    static void printPyramid(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // E.g. 6: Get number of matches of a char in a String
    static int numOfMatches(String string, char ch) {
        int result = 0;
        for (char c : string.toCharArray()) {
            if (c == ch) result++;
        }

        // or:
//        for (int i = 0; i < string.length(); i++){
//            if(string.charAt(i) == ch)
//                result++;
//        }
        return result;
    }

    static int numOfMatchesRecursive(String string, char ch) {
        if (string.length() == 0) return 0;
        else {
            String previousString = string.substring(1);
            return (string.charAt(0) == ch ? 1 : 0)
                    + numOfMatchesRecursive(previousString, ch);
        }
    }

}

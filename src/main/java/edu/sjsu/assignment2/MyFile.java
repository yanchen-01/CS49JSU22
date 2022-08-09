package edu.sjsu.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyFile {

    public static void writePrimes(String inputFile, String outputFile) {
        File input = new File(inputFile);
        // Try-with-resources: don't need to close them manually
        try (Scanner scanner = new Scanner(input);
             PrintWriter writer = new PrintWriter(outputFile)) {

            while (scanner.hasNextLine()) {  // read inputFile line by line
                // for each line
                String current = scanner.nextLine();

                // get each word (separated by a comma)
                Scanner lineScanner = new Scanner(current);
                lineScanner.useDelimiter(",");
                while (lineScanner.hasNext()) {
                    // for each word
                    String word = lineScanner.next();
                    // if it's a prime, write to outputFile
                    if (isPrime(word))
                        writer.println(word);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }

    private static boolean isPrime(String input) {
        try {
            int n = Integer.parseInt(input);
            // Handle the special cases
            if (n <= 0) return false;
            if (n <= 2) return true;

            // Check until sqrt of n is enough.
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) // if find any factor
                    return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

package edu.sjsu.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyCollections {

    public static void printFiles(Queue<File> files) {
        while (!files.isEmpty()) {
            File current = files.poll();
            print(current);
        }
    }

    private static void print(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine())
                System.out.println(scanner.nextLine());

            System.out.println("***");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void downsize(LinkedList<String> employees, int n) {
        ListIterator<String> listIterator = employees.listIterator();
        int index = 0;

        while (listIterator.hasNext()) {
            listIterator.next();
            index++;
            if (index % n == 0)
                listIterator.remove();
        }
    }

    public static boolean isBalanced(String exp) {
        Stack<Character> parentheses = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (c == '(')
                parentheses.push(')');
            else if (c == '[')
                parentheses.push(']');
            else if (c == ')' || c == ']') {
                if (parentheses.isEmpty())
                    return false;
                char top = parentheses.pop();
                if (top != c)
                    return false;
            }
        }
        return parentheses.isEmpty();
    }
}
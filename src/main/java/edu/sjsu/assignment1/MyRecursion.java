package edu.sjsu.assignment1;

public class MyRecursion {

    public static int indexOf(String text, String str) {
        return indexOf(text, str, 0);
    }

    private static int indexOf(String text, String str, int index) {
        if (text.length() < str.length())
            return -1;
        else if (text.startsWith(str))
            return index;
        else
            return indexOf(text.substring(1), str, index + 1);
    }
}

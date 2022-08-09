package edu.sjsu.assignment1;

public class MyTime {

    public static void getTimeDifference(String time1, String time2) {
        // Convert times to minutes in integer
        int t1 = militaryToMinutes(time1);
        int t2 = militaryToMinutes(time2);
        // compute difference
        int difference = t2 - t1;
        // if difference < 0
        //      add 24 hours to the difference
        //      since t2 + 24 - t1 = t2 - t1 + 24
        if (difference < 0)
            difference += 24 * 60; // same as difference = difference + 24

        // separate the difference to hour & minutes
        int hour = difference / 60;
        int minute = difference % 60;
        // printout
        System.out.println(hour + " hour(s) " + minute + " minute(s)");
    }

    private static int militaryToMinutes(String time) {
        // Convert String to integer
        int t = Integer.parseInt(time);
        // Separate hhmm -> h and m
        // e.g., 1155 - > 11 & 55
        int h = t / 100;
        int m = t % 100;
        // minutes = h * 60 + m;
        return h * 60 + m;
    }
}

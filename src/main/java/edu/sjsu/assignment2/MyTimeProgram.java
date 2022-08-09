package edu.sjsu.assignment2;

import java.util.Scanner;

public class MyTimeProgram {

    public static void main(String[] args) {
        while (true) {
            try {
                // take user input
                Time time1 = getInput("first");
                Time time2 = getInput("second");
                // call printTimeDifference
                printTimeDifference(time1, time2);
                System.out.print("Try again? (y/n): ");
                Scanner scanner = new Scanner(System.in);
                if (scanner.nextLine().equals("n"))
                    break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thank you for using");
    }

    /**
     * Helper method to take user input.
     *
     * @param which which time, first or second
     * @return a Time object with hour and minute
     */
    private static Time getInput(String which) {
        // in java it's %, same as ${} in python/javascript
        System.out.printf("Enter the %s time: ", which);
        Scanner scanner = new Scanner(System.in);
        return new Time(scanner.nextLine());
    }

    /**
     * Print the difference between two times.
     *
     * @param myTime1 the first time
     * @param myTime2 the second time
     */
    public static void printTimeDifference(Time myTime1, Time myTime2) {
        int minDiff = myTime2.minute - myTime1.minute;
        int hourDiff = myTime2.hour - myTime1.hour;
        // handle min diff first
        if (minDiff < 0) {
            minDiff += 60;
            hourDiff -= 1;
        }
        // then handle hour diff
        if (hourDiff < 0)
            hourDiff += 24;

        System.out.println(hourDiff + " hour(s) " + minDiff + " minute(s)");
    }

    /**
     * Helper class for Time which includes hour and minute
     */
    private static class Time {
        private final int hour;
        private final int minute;

        /**
         * Construct a time object
         *
         * @param time in military format hhmm
         */
        public Time(String time) {
            if (!time.matches("[0-9]{4}?"))
                throw new IllegalArgumentException("The input must be a 4 digit number");

            String h = time.substring(0, 2);
            this.hour = Integer.parseInt(h);
            if (this.hour <= 0 || this.hour > 24)
                throw new IllegalArgumentException("Hour must be between 0 and 24");

            String m = time.substring(2);
            this.minute = Integer.parseInt(m);
            if (this.minute <= 0 || this.minute > 60)
                throw new IllegalArgumentException("Minute must be between 0 and 60");
        }
    }

}

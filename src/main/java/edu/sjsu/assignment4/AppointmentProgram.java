package edu.sjsu.assignment4;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AppointmentProgram {
    private static final String GOODBYE = "Thank you for using the program. Have a nice day!";
    // Text block - new feature from Java 15
    private static final String MENU = """
            (a) for adding an appointment;
            (d) for deleting an appointment;
            (v) for viewing all appointments;
            (q) for quitting the program
            Please choose an option:\040""";
    private static final Scanner in = new Scanner(System.in);
    private static AppointmentManager manager;
    private static boolean end = false;

    public static void main(String[] args) {
        manager = new AppointmentManager();
        do {
            // argument is for showing menu
            mainScreen(true);
        } while (!end);
        System.out.println(GOODBYE);
    }

    private static void mainScreen(boolean withMenu) {
        if (withMenu)
            System.out.print(MENU);
        else
            System.out.print("Please enter again: ");

        String option = in.nextLine();
        switch (option) {
            case "a" -> addAppointment();
            case "d" -> deleteAppointment();
            case "v" -> manager.printAll();
            case "q" -> end = true;
            default -> {
                System.out.println("Sorry, wrong option!");
                // Don't show menu but ask user to enter again
                mainScreen(false);
            }
        }
    }

    private static void addAppointment() {
        String ERROR = "Sorry, fail to add the appointment: ";
        try {
            System.out.println("Please enter the type (onetime, daily or monthly): ");
            String type = in.nextLine();
            System.out.print("Please enter a description: ");
            String des = in.nextLine();
            System.out.print("Please enter the starting date (yyyy-mm-dd): ");
            LocalDate start = LocalDate.parse(in.nextLine());
            LocalDate end = start;
            if (!type.equals("onetime")) {
                System.out.print("Please enter the ending date (yyyy-mm-dd): ");
                end = LocalDate.parse(in.nextLine());
            }
            if (!manager.addAppointment(type, des, start, end))
                System.out.println(ERROR + "appointment exists");
            else System.out.println("Appointment added!");
        } catch (DateTimeParseException e) {
            System.out.println(ERROR + "wrong date format");
        } catch (IllegalArgumentException e) {
            // Either wrong type or start date is after end date.
            System.out.println(ERROR + e.getMessage());
        }
    }

    private static void deleteAppointment() {
        if (manager.isEmpty()) {
            System.out.println("Sorry, no appointment to delete, " +
                    "please add an appointment first!");
            // Don't show menu but ask user to enter again
            mainScreen(false);
            return;
        }

        while (true) {
            System.out.print("Please enter the description of the appointment you want delete: ");
            String des = in.nextLine();
            if (manager.deleteAppointment(des)) {
                System.out.println("Appointment deleted!");
                break;
            } else
                System.out.println("Sorry, appointment not found! please enter again!");
        }

    }
}
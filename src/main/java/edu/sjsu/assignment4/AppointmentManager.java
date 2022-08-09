package edu.sjsu.assignment4;

import edu.sjsu.assignment3.Appointment;
import edu.sjsu.assignment3.DailyAppointment;
import edu.sjsu.assignment3.MonthlyAppointment;
import edu.sjsu.assignment3.OnetimeAppointment;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.TreeSet;

public class AppointmentManager extends HashSet<Appointment> {
    public boolean addAppointment(String type, String description, LocalDate start, LocalDate end) {
        Appointment appointment = switch (type) {
            case "onetime" -> new OnetimeAppointment(description, start);
            case "daily" -> new DailyAppointment(description, start, end);
            case "monthly" -> new MonthlyAppointment(description, start, end);
            default -> throw new IllegalArgumentException("Wrong type");
        };
        return this.add(appointment);
    }

    public boolean deleteAppointment(String description) {
        // An anonymous class - define and construct object at the same time
        // Only description matters
        Appointment appointment = new Appointment(description, LocalDate.MIN, LocalDate.MAX) {
            @Override
            public boolean occursOn(LocalDate date) {
                return false;
            }
        };

        return this.remove(appointment);
    }

    public void printAll() {
        if (this.isEmpty())
            System.out.println("No any appointment now.");
        else {
            TreeSet<Appointment> appointments = new TreeSet<>(this);
            for (Appointment a : appointments)
                System.out.println(a);
        }
    }
}

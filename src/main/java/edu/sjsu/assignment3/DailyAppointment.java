package edu.sjsu.assignment3;

import java.time.LocalDate;

public class DailyAppointment extends Appointment {
    public DailyAppointment(String description, LocalDate startDate, LocalDate endDate) {
        super(description, startDate, endDate);
    }

    @Override
    public boolean occursOn(LocalDate date) {
        return inBetween(date);
    }

    // toString added for assignment 4 - appointment program
    @Override
    public String toString() {
        return super.toString() + ", daily";
    }
}

package edu.sjsu.assignment3;

import java.time.LocalDate;

public class OnetimeAppointment extends Appointment {
    public OnetimeAppointment(String description, LocalDate startDate) {
        super(description, startDate, startDate);
    }

    @Override
    public boolean occursOn(LocalDate date) {
        return getStartDate().isEqual(date);
    }

    // toString added for assignment 4 - appointment program
    @Override
    public String toString() {
        return super.toString() + ", onetime";
    }
}

package edu.sjsu.assignment3;

import java.time.LocalDate;

public class MonthlyAppointment extends Appointment {
    public MonthlyAppointment(String description, LocalDate startDate, LocalDate endDate) {
        super(description, startDate, endDate);
    }

    @Override
    public boolean occursOn(LocalDate date) {
        return inBetween(date) &&
                date.getDayOfMonth() == this.getStartDate().getDayOfMonth();
    }

    // toString added for assignment 4 - appointment program
    @Override
    public String toString() {
        return super.toString() + ", monthly";
    }
}

package edu.sjsu.assignment3;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Appointment implements Comparable<Appointment>{
    private final String description;
    private final LocalDate startDate;
    private final LocalDate endDate;

    @Override
    public int compareTo(Appointment o) {
        if(!startDate.isEqual(o.startDate))
            return startDate.compareTo(o.startDate);
        else if(!endDate.isEqual(o.endDate))
            return endDate.compareTo(o.endDate);
        else
            return description.compareTo(o.description);
    }

    public Appointment(String description, LocalDate startDate, LocalDate endDate) {
        // Date check added for assignment 4 - appointment program
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("End date should be equal or after start date");
        }
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    protected boolean inBetween(LocalDate date){
        // in between means not outside
        // equivalent to !date.isBefore(startDate) && !date.isAfter(endDate);
        return !(date.isBefore(startDate) || date.isAfter(endDate));
    }

    public abstract boolean occursOn(LocalDate date);

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    // toString added for assignment 4 - appointment program
    @Override
    public String toString() {
        return String.format("%s, from %s to %s", description, startDate, endDate);
    }

    // equals & hashcode Added for assignment 4 - appointment program
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment that))
            return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return description != null ? description.hashCode() : 0;
    }
}

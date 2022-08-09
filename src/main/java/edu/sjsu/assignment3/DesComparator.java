package edu.sjsu.assignment3;

import java.util.Comparator;

public class DesComparator implements Comparator<Appointment> {
    @Override
    public int compare(Appointment o1, Appointment o2) {
        if (!o1.getDescription().equals(o2.getDescription()))
            return o1.getDescription().compareTo(o2.getDescription());
        else if (!o1.getStartDate().equals(o2.getStartDate()))
            return o1.getStartDate().compareTo(o2.getStartDate());
        else return o1.getEndDate().compareTo(o2.getEndDate());
    }
}

package demo.week8others;

import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.optionalusertools.CalendarListener;
import com.github.lgooddatepicker.zinternaltools.CalendarSelectionEvent;
import com.github.lgooddatepicker.zinternaltools.YearMonthChangeEvent;

import javax.swing.*;
import java.time.LocalDate;

/**
 * Same as MavenDemo but using form (Swing UI Designer).
 * <p>Watch <a href="https://youtu.be/72sY8aTZUaM">https://youtu.be/72sY8aTZUaM</a> for
 * how to add a customized component to the form.
 */
public class MavenDemoForm {

    private JPanel panel;
    private CalendarPanel calendar;
    private JTextArea area;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new MavenDemoForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MavenDemoForm() {
        setArea();
        calendar.addCalendarListener(new CalendarListener() {
            @Override
            public void selectedDateChanged(CalendarSelectionEvent calendarSelectionEvent) {
               setArea();
            }

            @Override
            public void yearMonthChanged(YearMonthChangeEvent yearMonthChangeEvent) {

            }
        });
    }

    void setArea(){
        if (calendar.getSelectedDate() == null)
            area.setText("Please select a date.");
        else
            area.setText("Appointments on " + calendar.getSelectedDate() + ": ");
    }

}

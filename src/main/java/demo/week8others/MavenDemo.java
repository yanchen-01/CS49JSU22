package demo.week8others;

import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.optionalusertools.CalendarListener;
import com.github.lgooddatepicker.zinternaltools.CalendarSelectionEvent;
import com.github.lgooddatepicker.zinternaltools.YearMonthChangeEvent;

import javax.swing.*;
import java.awt.*;

/**
 * Uses LGoodDatePicker from <a href="https://mvnrepository.com/artifact/com.github.lgooddatepicker/LGoodDatePicker">https://mvnrepository.com/artifact/com.github.lgooddatepicker/LGoodDatePicker</a>
 * To add the library to the project, either create a Maven project,
 * or right-click the root and choose add Framework Support -> choose Maven.
 * Copy the dependency under &lt;dependencies> tag in the POM.xml file created.
 */
public class MavenDemo {

    // CalendarPanel is a class in LGoodDatePicker library
    static CalendarPanel calendar = new CalendarPanel();
    // Have a text area to display appointments
    static JTextArea area = new JTextArea(0, 30);

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        // Set the textarea to only display text, not editable
        area.setEditable(false);
        // The content of the textarea is based on the selected date on CalendarPanel
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

        // Add calendar & area in one line
        frame.setLayout(new BorderLayout());
        frame.add(calendar, BorderLayout.WEST);
        frame.add(area, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Set the content of the textarea based on the selected date
     */
    static void setArea() {
        if (calendar.getSelectedDate() == null)
            area.setText("Please select a date.");
        else
            area.setText("Appointments on " + calendar.getSelectedDate() + ": ");
    }
}

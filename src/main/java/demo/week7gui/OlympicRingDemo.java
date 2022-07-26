package demo.week7gui;

import javax.swing.*;
import java.awt.*;

public class OlympicRingDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        OlympicRingComponent olympicRingComponent = new OlympicRingComponent(50);
        // Position the component using layout, not define in the component.
        panel.add(new JLabel("An Olympic rings"), BorderLayout.NORTH);
        panel.add(olympicRingComponent, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

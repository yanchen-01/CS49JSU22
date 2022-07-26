package demo.week7gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * A component for simplified Olympics rings which the size can be defined
 */
public class OlympicRingComponent extends JComponent {

    private final int size;
    private final float strokeSize;

    public OlympicRingComponent(int size) {
        this.size = size;
        strokeSize = 0.05f * size;
        // include the stroke size to avoid "cut-off"
        int width = 3 * size + 2 * (int) strokeSize;
        // 3 * size / 2 will be different from 3 / 2 * size
        // since 3 / 2 will always be 1 !
        int height = 3 * size / 2 + 2 * (int) strokeSize;
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color[] colors = {Color.BLUE, Color.YELLOW, Color.BLACK, Color.GREEN, Color.RED};
        for (int i = 0; i < colors.length; i++) {
            // include the stroke size to avoid "cut-off"
            // similarly, i * size / 2 will be different from i / 2 * size
            // because of the overflow
            int xAxis = (int) strokeSize + i * size / 2;
            int yAxis = (int) strokeSize + (i % 2 == 0 ? 0 : size / 2);

            // Graphics2D is the "pen"
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(colors[i]);
            g2.setStroke(new BasicStroke(strokeSize));

            // Approach 1: define shape, then draw shape
            Ellipse2D.Double circle = new Ellipse2D.Double(xAxis, yAxis, size, size);
            g2.draw(circle);

            // Approach 2: draw shape directly
            // g2.drawOval(xAxis, yAxis, size, size);
        }
    }
}

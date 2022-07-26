package demo.week7gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;

/**
 * Same app as {@link GUIDemo} but with a form (Swing UI designer).
 * <p>Differences in implementation:
 * <ul>
 *     <li>fields, methods are non-static except for psvm</li>
 *     <li>So use this to reference the methods instead of class name</li>
 *     <li>Initializing & positioning the components are done in the form</li>
 *     <li>Listeners are attached in the constructor</li>
 * </ul>
 * Others are pretty much the same. See {@link GUIDemo}'s documentation.
 */
public class GUIFormDemo {

    private JPanel panel;
    private JTextField principle;
    private JLabel rate;
    private JSlider rateSlider;
    private JRadioButton r15;
    private JRadioButton r20;
    private JRadioButton r30;
    private JCheckBox checkBox;
    private JButton calBtn;
    private JLabel result;

    public GUIFormDemo() {
        rateSlider.addChangeListener(this::updateRate);
        calBtn.addActionListener(this::calculate);
        addChangeListeners();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Demo App - Mortgage Calculator");
        frame.setContentPane(new GUIFormDemo().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    void updateRate(ChangeEvent e) {
        double current = rateSlider.getValue() / 10.0;
        rate.setText(String.format("Annual Interest Rate: %.1f%%", current));
        reset();
    }

    void addChangeListeners() {
        principle.getDocument().addDocumentListener((DocumentAdapter) this::reset);
        JRadioButton[] loanTerms = {r15, r20, r30};
        for (JRadioButton loanTerm : loanTerms)
            loanTerm.addItemListener(e -> reset());
        checkBox.addItemListener(e -> reset());
    }

    void calculate(ActionEvent e) {
        try {
            double P = Double.parseDouble(principle.getText());
            double R = rateSlider.getValue() / 10.0 / 100 / 12;
            double T = checkBox.isSelected() ? 0.1 * P / 100 : 0.0;
            int N = 12;
            if (r15.isSelected())
                N *= 15;
            else if (r20.isSelected())
                N *= 20;
            else N *= 30;

            double payment = Calculator.calculate(P, R, N, T);
            result.setText(String.format("Monthly payment: $%.2f", payment));
        } catch (Exception ex) {
            result.setText("Something wrong, please check your input.");
        }
    }

    void reset() {
        result.setText("Click Calculate to see monthly payment");
    }

}
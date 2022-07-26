package demo.week7gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * A mortgage calculator with GUI. Used GridBagLayout
 * <ul><li>Components used: <ul>
 *      <li>Labels</li>
 *      <li>Text field</li>
 *      <li>Slider</li>
 *      <li>Radio buttons in a group</li>
 *      <li>Check box</li>
 *      <li>Button</li>
 *      </ul></li>
 *
 *  <li>Listeners used: <ul>
 *      <li>DocumentListener: track changes in text field</li>
 *      <li>ItemListener: track changes in radio buttons/check box</li>
 *      <li>ChangeListener: track changes in slider</li>
 *      <li>ActionListener: respond to a button click</li>
 *      </ul></li>
 * </ul>
 */
public class GUIDemo {
    static JTextField principle;
    static JLabel rate, result;
    static JSlider rateSlider;
    static JRadioButton[] loanTerms;
    static JCheckBox checkBox;
    static JButton calBtn;

    public static void main(String[] args) {
        init();

        JFrame frame = new JFrame("Demo App - Mortgage Calculator");
        JPanel panel = new JPanel(new GridBagLayout());
        layoutPanel(panel);
        frame.add(panel);

        // Show current selection on slider
        rateSlider.addChangeListener(GUIDemo::updateRate);

        calBtn.addActionListener(GUIDemo::calculate);
        addChangeListeners();

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Helper method to update the rate displayed
     * based on the current value of slider.
     * <br> Also reset the result label.
     * <p>(Since the parameter & return type matches
     * the stateChanged method in ChangeListener interface,
     * <br>this method can be passed in as a ChangeListener
     * using method reference operator.)
     *
     * @param e the change event that's detected.
     */
    static void updateRate(ChangeEvent e) {
        double current = rateSlider.getValue() / 10.0;
        rate.setText(String.format("Annual Interest Rate: %.1f%%", current));
        reset();
    }

    /**
     * Helper method to attach listeners to keep track of changes.
     * <br> If anything changed, reset the result label.
     */
    static void addChangeListeners() {
        // See documentation in DocumentAdapter for more details
        principle.getDocument().addDocumentListener((DocumentAdapter) GUIDemo::reset);

        for (JRadioButton loanTerm : loanTerms)
            loanTerm.addItemListener(e -> reset());
        checkBox.addItemListener(e -> reset());
    }

    /**
     * Helper method to calculate result based on user inputs.
     *
     * <p>(Since the parameter & return type matches
     * the actionPerformed method in ActionListener interface,
     * <br>this method can be passed in as a ActionListener
     * using method reference operator.)
     *
     * @param e the action event that's detected.
     */
    static void calculate(ActionEvent e) {
        try {
            // Get principle
            double P = Double.parseDouble(principle.getText());
            // Get monthly rate (annual / 12)
            double R = rateSlider.getValue() / 10.0 / 100 / 12;
            // Get tax (0.1% of principle if selected)
            double T = checkBox.isSelected() ? 0.1 * P / 100 : 0.0;
            // Get number of month
            int N = 12; // 12 months in 1 year
            if (loanTerms[0].isSelected())
                N *= 15;
            else if (loanTerms[1].isSelected())
                N *= 20;
            else N *= 30;

            double payment = Calculator.calculate(P, R, N, T);
            result.setText(String.format("Monthly payment: $%.2f", payment));
        } catch (Exception ex) {
            result.setText("Something wrong, please check your input.");
        }
    }

    /**
     * Helper method to initialize all components.
     */
    static void init() {
        rate = new JLabel("Annual Interest Rate: 10.0%");
        result = new JLabel("Click Calculate to see monthly payment");

        principle = new JTextField();

        // Ranging from 0.0 (%) to 20.0 (%) increasing by 0.1
        // but slider only takes int, so *10, then /10 when getting value.
        rateSlider = new JSlider(0, 200, 100);

        loanTerms = new JRadioButton[3];
        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < loanTerms.length; i++) {
            int num = i == 0 ? 15 : 10 * (i + 1);
            loanTerms[i] = new JRadioButton(num + " years");
            if (i == 0) // set default selection
                loanTerms[i].setSelected(true);
            group.add(loanTerms[i]);

        }

        checkBox = new JCheckBox("Include taxes and fees (0.1%)");
        calBtn = new JButton("Calculate");
    }


    /**
     * Helper method to reset the result label.
     * <p>(Since this method is called in different listeners,
     * can't restrict the parameter.
     * <br>And therefore this method
     * can't be passed in using method reference operator.)
     */
    static void reset() {
        result.setText("Click Calculate to see monthly payment");
    }

    /**
     * Helper method to place all components.
     */
    static void layoutPanel(JPanel panel) {
        // GridBagConstraints defines the position and size
        // of the component that's being placed in a GridBagLayout.
        GridBagConstraints constraint = new GridBagConstraints();
        // Insets are the margin (space) between each component
        Insets largeInset = new Insets(20, 10, 0, 10);
        Insets smallInset = new Insets(5, 10, 0, 10);

        // 1st part - principle
        constraint.insets = smallInset;
        constraint.gridx = 0;
        constraint.gridy = 0;
        panel.add(new JLabel("Principle ($): "), constraint);
        constraint.gridx = 1;
        constraint.gridwidth = 2;
        constraint.fill = GridBagConstraints.HORIZONTAL;
        panel.add(principle, constraint);

        // 2nd part - interest rate
        constraint.insets = largeInset;
        constraint.gridx = 0;
        constraint.gridy++;
        panel.add(rate, constraint);

        constraint.insets = smallInset;
        constraint.gridy++;
        constraint.gridwidth = 3;
        constraint.fill = GridBagConstraints.HORIZONTAL;
        panel.add(rateSlider, constraint);

        // 3rd part: loan term
        constraint.insets = largeInset;
        constraint.gridy++;
        panel.add(new JLabel("Loan Term: "), constraint);
        constraint.insets = smallInset;
        constraint.gridy++;
        constraint.gridwidth = 1;
        for (int i = 0; i < loanTerms.length; i++) {
            constraint.gridx = i;
            panel.add(loanTerms[i], constraint);
        }

        // 4th part: checkbox, button, result
        constraint.gridx = 0;
        constraint.gridwidth = 3;
        constraint.insets = largeInset;
        constraint.gridy++;
        panel.add(checkBox, constraint);
        constraint.gridy++;
        panel.add(calBtn, constraint);
        constraint.gridy++;
        constraint.insets = new Insets(10, 10, 50, 10);
        panel.add(result, constraint);
    }

}
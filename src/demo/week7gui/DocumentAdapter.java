package demo.week7gui;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * An interface that adapts DocumentListener,
 * so that all 3 mandatory methods are doing the same thing.
 * <br> That is, the adapter is a functional interface
 * so that we can use lambda expression when using it.
 */
public interface DocumentAdapter extends DocumentListener {
    /**
     * Respond to any change detected.
     */
    void changed();
    @Override
    default void insertUpdate(DocumentEvent e) {
        changed();
    }

    @Override
    default void removeUpdate(DocumentEvent e) {
        changed();
    }

    @Override
    default void changedUpdate(DocumentEvent e) {
        changed();
    }
}

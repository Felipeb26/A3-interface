package com.batsworks.interfaces.utils;

import javax.swing.*;

public final class Validation {
    Validation() {
        throw new IllegalStateException("Utility class");
    }

    public static void notNull(JTextField... textFields) {
        for (var textField : textFields) {
            var text = textField.getText();
            if (text == null || text.isBlank() || text.isEmpty())
                throw new IllegalStateException("Campo não pode ser nulo");
        }
    }
}

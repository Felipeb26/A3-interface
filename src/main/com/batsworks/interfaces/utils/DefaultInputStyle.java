package main.com.batsworks.interfaces.utils;

import javax.swing.*;
import main.com.batsworks.interfaces.config.styles.FontStyle;

public final class DefaultInputStyle {
	
    DefaultInputStyle() {
        throw new IllegalStateException("Utility class");
    }


    public static void textFieldBound(JTextField textField, int x, int y, int width, int height) {
        textField.setBounds(x, y, width, height);
    }
    public static void textFieldBound(JTextField textField, int x, int y) {
        textField.setBounds(x, y, 179, 30);
    }

    public static void textField(JTextField... textFields) {
        for (var textField : textFields) {
            textField.setFont(new FontStyle("Dialog"));
        }
    }
}

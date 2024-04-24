package com.batsworks.interfaces.utils;

import com.batsworks.interfaces.view.Index;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.function.Function;

public final class Change {

    Change() {
        throw new IllegalStateException("Utility class");
    }

    public static void homeScreen(JButton button, Function<Void, Void> function) {
        button.addActionListener(e -> {
            try {
                function.apply(null);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
    }

    public static void toFrame(JButton button, JFrame initial, Class<? extends JFrame> frame) {
        button.addActionListener(e -> {
            try {
                initial.dispose();
                Class.forName(frame.getName()).getDeclaredConstructor().newInstance();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                new Index();
            }
        });
    }

    public static void controllCloseFrame(JFrame frame, Boolean index) {
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(frame,
                        "Tem certeza que desja fechar essa tela?",
                        "Confirm Close", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    if (Boolean.FALSE.equals(index)) new Index();
                }
            }
        });
    }
}

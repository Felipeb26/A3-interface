package com.batsworks.interfaces.utils;

import com.batsworks.interfaces.service.UsuarioService;
import com.batsworks.interfaces.view.Eventos;
import com.batsworks.interfaces.view.Index;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class Change {

    Change() {
        throw new IllegalStateException("Utility class");
    }

    public static void homeScreen(JButton button, JFrame frame, JTextField user, JTextField pass) {
        button.addActionListener(e -> {
            UsuarioService service = new UsuarioService();
            String email = user.getText();
            String senha = pass.getText();
            try {
                var usuario = service.findUserByLogin(email, senha);
                if (usuario == null) {
                    JOptionPane.showMessageDialog(null, "usuario nao existe ou não encontrado\n verificar senha e email informados!");
                    return;
                }
                if (Boolean.TRUE.equals(usuario.getAdm())) {
                    frame.dispose();
                    new UsuarioService();
                } else if (Boolean.FALSE.equals(usuario.getAdm())) {
                    frame.dispose();
                    new Eventos();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "usuario nao existe ou não encontrado\n verificar senha e email informados!");
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

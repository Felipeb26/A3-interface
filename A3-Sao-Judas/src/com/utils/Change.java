package com.utils;

import com.config.ConexaoDb;
import com.service.UsuarioService;
import com.view.*;
import lombok.Data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Data
public class Change {

	static Connection conn = ConexaoDb.conecta();
	static ResultSet rs;
	static PreparedStatement pst;

	public static void ScreenMain(JButton button, JFrame frame, JTextField user, JTextField pass) {
		button.addActionListener(e -> {
            UsuarioService service = new UsuarioService();
            String name =user.getText();
            String senha =pass.getText();
            try {
                service.findUserByLogin(name, senha).forEach(data ->{
                    if(data.getNome().equals(name) && data.getSenha().equals(senha) && Boolean.TRUE.equals(data.getAdm())) {
                        frame.dispose();
                        new Eventos();
                    }else if(data.getNome().equals(name) && data.getSenha().equals(senha) && Boolean.FALSE.equals(data.getAdm())) {

                        frame.dispose();
                        new UsuariosAdm();
                    }
                    else if(data.getNome().equals("")){
                        System.out.println("usuario nao existe ou incorreto");
                    }
                });
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
        });
	}

	public static void ScreenAddUser(JButton button, JFrame frame) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					new Cadastro();
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		});
	}

	public static void ScreenIndex(JButton button, JFrame frame) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					new Index();
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		});
	}

	public static void ScreenAbout(JButton btnAbout, JFrame frame) {
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					new About();
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		});
	}
	
	public void ScreenCarrinho(JButton btnAbout, JFrame frame) {
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					new Carrinho();
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		});
	}
	
	public static void ScreenLogin(JButton btnAbout, JFrame frame) {
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					new Usuarios();
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		});
	}

	public static void controllCloseFrame(JFrame frame, Boolean index){
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(frame,
						"Are you sure you want to close this window?",
						"Confirm Close", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					frame.dispose();
					if(Boolean.FALSE.equals(index))	new Index();
				}
			}
		});
	}
}

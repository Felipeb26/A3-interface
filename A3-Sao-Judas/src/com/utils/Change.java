package com.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.config.ConexaoDb;
import com.service.UsuarioService;
import com.view.About;
import com.view.Cadastro;
import com.view.Carrinho;
import com.view.Eventos;
import com.view.Index;
import com.view.Usuarios;
import com.view.UsuariosAdm;

import lombok.Data;

@Data
public class Change {

	static Connection conn = ConexaoDb.conecta();
	static ResultSet rs;
	static PreparedStatement pst;

	public static void ScreenMain(JButton button, JFrame frame, JTextField user, JTextField pass) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioService service = new UsuarioService();
				String name =user.getText();
				String senha =pass.getText();
				try {
					service.findUserByLogin(name, senha).forEach(data ->{
						if(data.getNome().equals(name) && data.getSenha().equals(senha) && data.getAdm().equals("A")) {
							frame.dispose();
							new Eventos();
						}else if(data.getNome().equals(name) && data.getSenha().equals(senha) && !data.getAdm().equals("A")) {
							
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

}

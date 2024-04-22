package com.batsworks.interfaces.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.batsworks.interfaces.config.database.ConexaoDb;
import com.batsworks.interfaces.utils.Change;

public class Cadastro {
	
//	static Connection conn = ConexaoDb.conecta();
//	static ResultSet rs;
//	static PreparedStatement pst;
//
//	private static JFrame frame = new JFrame();
//	private static JTextField inputEmail;
//	private static JTextField inputNome;
//	private static JTextField inputSenha;
//	private static JButton btnCadastro = new JButton("CADASTRAR");
//	private JButton btnCancel = new JButton("CANCEL");
//	private JLabel lblNome = new JLabel("NOME");
//	private JLabel lblEmail = new JLabel("EMAIL");
//	private JLabel lblSenha = new JLabel("SENHA");
//	private static JTextField inputIdade;
//	private static JLabel lblIdade;
//	private JTextField inputEndereco;
//
//	public Cadastro() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 701, 550);
//		frame.setResizable(false);
//		frame.getContentPane().setLayout(null);
//		Change.controllCloseFrame(frame, false);
//
//
//		inputEmail = new JTextField();
//		inputEmail.setBounds(502, 225, 150, 30);
//		frame.getContentPane().add(inputEmail);
//		inputEmail.setColumns(10);
//
//		inputNome = new JTextField();
//		inputNome.setBounds(387, 145, 165, 30);
//		frame.getContentPane().add(inputNome);
//		inputNome.setColumns(10);
//
//		inputSenha = new JTextField();
//		inputSenha.setBounds(502, 363, 150, 28);
//		frame.getContentPane().add(inputSenha);
//		inputSenha.setColumns(10);
//
//		lblNome.setBounds(402, 120, 46, 14);
//		frame.getContentPane().add(lblNome);
//
//		lblEmail.setBounds(544, 200, 46, 14);
//		frame.getContentPane().add(lblEmail);
//
//		lblSenha.setBounds(544, 338, 46, 14);
//		frame.getContentPane().add(lblSenha);
//
//		btnCadastro.setBounds(522, 438, 109, 23);
//		frame.getContentPane().add(btnCadastro);
//
//		btnCancel.setBounds(27, 11, 94, 23);
//		frame.getContentPane().add(btnCancel);
//		frame.setVisible(true);
//
//		Change.ScreenIndex(btnCancel, frame);
//
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\felip\\Pictures\\kali.png"));
//		lblNewLabel.setBounds(43, 96, 369, 346);
//		frame.getContentPane().add(lblNewLabel);
//
//		inputIdade = new JTextField();
//		inputIdade.setBounds(580, 145, 72, 30);
//		frame.getContentPane().add(inputIdade);
//		inputIdade.setColumns(10);
//
//		lblIdade = new JLabel("IDADE");
//		lblIdade.setBounds(603, 120, 46, 14);
//		frame.getContentPane().add(lblIdade);
//
//		inputEndereco = new JTextField();
//		inputEndereco.setBounds(502, 297, 150, 30);
//		frame.getContentPane().add(inputEndereco);
//		inputEndereco.setColumns(10);
//
//		JLabel lblEndereco = new JLabel("ENDERECO");
//		lblEndereco.setBounds(544, 272, 72, 14);
//		frame.getContentPane().add(lblEndereco);
//		Cadastrar();
//	}
//
//	public static void Cadastrar() {
//		btnCadastro.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					String mail = inputEmail.getText();
//					String nome = inputNome.getText();
//					String senha = inputSenha.getText();
//					String age = inputIdade.getText();
//					String ende = inputEmail.getText();
//					if (nome.equals("") || senha.equals("") || mail.equals("")) {
//						JOptionPane.showMessageDialog(null, "os campos devem estar preenchidos");
//					} else {
//						String sql = "insert into usuarios (nome, email, senha, idade, endereco) values"
//								+ "(?, ?, ?, ?, ?)";
//						pst = conn.prepareStatement(sql);
//						pst.setString(1, nome);
//						pst.setString(2, mail);
//						pst.setString(3, senha);
//						pst.setInt(4, Integer.parseInt(age));
//						pst.setString(5, ende);
//						pst.execute();
//
//						JOptionPane.showMessageDialog(null, "usuario " + nome + " cadastrado com sucesso!");
//						frame.dispose();
//						new Index();
//					}
//				} catch (Exception ex) {
//					ex.printStackTrace();
//					System.out.println(ex.getMessage());
//				}
//			}
//		});
//	}
}

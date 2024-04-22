package com.batsworks.interfaces.view;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.batsworks.interfaces.config.styles.FontStyle;
import com.batsworks.interfaces.config.styles.RoundBorder;
import com.batsworks.interfaces.utils.Change;

public class Index extends JFrame {

	private static final long serialVersionUID = 1L;
	JFrame frame;
	JTextField inputSenha;
	JTextField inputUsuario;
	JButton buttonLogin;
	JButton btnAbout;
	JLabel lblUsuario;
	JLabel lblSenha;
	JButton btnEsqueciSenha;
	JButton btnCadastro;

	public Index() {
		setBounds(100, 100, 701, 550);

		components(this).parallelStream().forEach(this::add);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);

		Change.controllCloseFrame(this, true);
		Change.ScreenMain(buttonLogin, this, inputUsuario, inputSenha);
		Change.ScreenAbout(btnAbout, this);
		Change.ScreenAddUser(btnCadastro, this);
	}

	private List<? extends JComponent> components(JFrame frame) {
		inputSenha = new JTextField();
		inputUsuario = new JTextField();
		buttonLogin = new JButton("ENTRAR");
		btnAbout = new JButton("about");
		lblUsuario = new JLabel("USUARIO");
		lblSenha = new JLabel("SENHA");
		btnEsqueciSenha = new JButton("esqueci a senha");
		btnCadastro = new JButton("CADASTRAR");

		inputUsuario.setBorder(new RoundBorder());
		inputSenha.setBorder(new RoundBorder());

		lblUsuario.setBounds(107, 281, 81, 25);
		lblSenha.setBounds(107, 333, 81, 50);
		inputSenha.setFont(new FontStyle("Dialog"));

		inputSenha.setBounds(92, 358, 179, 25);
		inputSenha.setColumns(10);
		inputUsuario.setFont(new Font("Dialog", Font.BOLD, 12));

		inputUsuario.setBounds(92, 301, 179, 25);
		inputUsuario.setColumns(10);

		btnAbout.setBounds(593, 11, 69, 23);
		btnEsqueciSenha.setBounds(107, 459, 137, 25);
		btnCadastro.setBounds(117, 422, 113, 25);
		buttonLogin.setBounds(117, 395, 113, 23);

		return List.of(inputSenha, inputUsuario, buttonLogin, btnAbout, lblUsuario, lblSenha, btnEsqueciSenha,
				btnCadastro);
	}
}

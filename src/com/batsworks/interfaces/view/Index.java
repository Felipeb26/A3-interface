package com.batsworks.interfaces.view;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.batsworks.interfaces.utils.Change;
import com.batsworks.interfaces.utils.DefaultInputStyle;

public class Index extends JFrame {

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

		components().parallelStream().forEach(this::add);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);

		Change.homeScreen(buttonLogin, this, inputUsuario, inputSenha);
		Change.toFrame(btnAbout, this, About.class);
		Change.toFrame(btnCadastro, this, Cadastro.class);
	}

	private List<? extends JComponent> components() {
		inputSenha = new JTextField();
		inputUsuario = new JTextField();
		buttonLogin = new JButton("ENTRAR");
		btnAbout = new JButton("about");
		lblUsuario = new JLabel("USUARIO");
		lblSenha = new JLabel("SENHA");
		btnEsqueciSenha = new JButton("esqueci a senha");
		btnCadastro = new JButton("CADASTRAR");


		lblUsuario.setBounds(107, 281, 81, 25);
		lblSenha.setBounds(107, 333, 81, 50);


		btnAbout.setBounds(593, 11, 69, 23);
		btnEsqueciSenha.setBounds(107, 459, 137, 25);
		btnCadastro.setBounds(117, 422, 113, 25);
		buttonLogin.setBounds(117, 395, 113, 23);


		DefaultInputStyle.textFieldBound(inputUsuario, 92, 301);
		DefaultInputStyle.textFieldBound(inputSenha, 92, 358);
		DefaultInputStyle.textField(inputSenha, inputUsuario);
		return List.of(inputSenha, inputUsuario, buttonLogin, btnAbout, lblUsuario, lblSenha, btnEsqueciSenha,
				btnCadastro);
	}


}

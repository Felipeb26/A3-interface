package com.batsworks.interfaces.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.batsworks.interfaces.config.database.CustomRepository;
import com.batsworks.interfaces.model.UsuariosModel;
import com.batsworks.interfaces.utils.Change;
import com.batsworks.interfaces.utils.DefaultInputStyle;
import com.batsworks.interfaces.utils.Validation;

public class Index extends JFrame {

	CustomRepository<UsuariosModel> repository;
	JTextField inputSenha;
	JTextField inputEmail;
	JButton btnAbout;
	JLabel lblUsuario;
	JLabel lblSenha;
	JButton btnEsqueciSenha;
	JButton btnCadastro;
	JButton btnLogin;

	public Index() {
		repository = new CustomRepository<>(UsuariosModel.class, UsuariosModel::rowMapper);
		setBounds(100, 100, 700, 550);
		components();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		Change.toFrame(btnAbout, this, About.class);
		Change.toFrame(btnCadastro, this, Cadastro.class);

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		Validation.onlyLetters(inputEmail);
//		Validation.onlyNumbers(inputSenha);
		Validation.regexInput(inputSenha, "[^a-zA-Z]{4,8}$", lblSenha, "apenas numeros ");
	}

	private void components() {
		inputSenha = new JTextField(8);
		inputEmail = new JTextField("email");
		btnAbout = new JButton("about");
		lblUsuario = new JLabel("USUARIO");
		lblSenha = new JLabel("SENHA");
		btnEsqueciSenha = new JButton("esqueci a senha");
		btnCadastro = new JButton("CADASTRAR");
		getContentPane().setLayout(null);

		lblUsuario.setBounds(107, 264, 81, 25);
		getContentPane().add(lblUsuario);
		lblSenha.setBounds(107, 327, 69, 25);
		getContentPane().add(lblSenha);
		inputEmail.setBounds(107, 287, 179, 30);
		getContentPane().add(inputEmail);
		inputSenha.setBounds(107, 351, 179, 30);
		getContentPane().add(inputSenha);

		btnAbout.setBounds(593, 11, 69, 23);
		getContentPane().add(btnAbout);
		btnEsqueciSenha.setBounds(69, 423, 119, 25);
		getContentPane().add(btnEsqueciSenha);
		btnCadastro.setBounds(192, 423, 113, 25);
		getContentPane().add(btnCadastro);

		btnLogin = new JButton("login".toUpperCase());
		btnLogin.setBounds(148, 394, 89, 23);
		btnLogin.addActionListener(a -> executeLogin());
		getContentPane().add(btnLogin);

		DefaultInputStyle.textField(inputSenha, inputEmail);
	}

	public void executeLogin() {
		try {
			String email = "select * from usuarios where email like '".concat(inputEmail.getText());
			var usuario = repository.custom(email.concat("%' and senha='").concat(inputSenha.getText()).concat("'"));
			if (usuario == null) {
				JOptionPane.showMessageDialog(null,
						"usuario nao existe ou não encontrado\n verificar senha e email informados!");
				return;
			}
			if (Boolean.TRUE.equals(usuario.getAdm())) {
				Change.toFrame(btnAbout, this, UsuariosAdm.class);
			} else if (Boolean.FALSE.equals(usuario.getAdm())) {
				dispose();
				new Eventos();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
					"usuario nao existe ou não encontrado\n verificar senha e email informados!");
		}
	}

}

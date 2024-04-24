package com.batsworks.interfaces.view;

import com.batsworks.interfaces.config.database.CustomRepository;
import com.batsworks.interfaces.model.UsuariosModel;
import com.batsworks.interfaces.utils.Change;
import com.batsworks.interfaces.utils.DefaultInputStyle;

import javax.swing.*;
import java.util.List;

public class Index extends JFrame {

    CustomRepository<UsuariosModel> repository;
    JTextField inputSenha;
    JTextField inputEmail;
    JButton buttonLogin;
    JButton btnAbout;
    JLabel lblUsuario;
    JLabel lblSenha;
    JButton btnEsqueciSenha;
    JButton btnCadastro;

    public Index() {
        repository = new CustomRepository<>(UsuariosModel.class, UsuariosModel::rowMapper);
        setBounds(100, 100, 701, 550);

        components().parallelStream().forEach(this::add);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setVisible(true);
        Change.homeScreen(buttonLogin, this::executeLogin);
        Change.toFrame(btnAbout, this, About.class);
        Change.toFrame(btnCadastro, this, Cadastro.class);
    }


    private List<? extends JComponent> components() {
        inputSenha = new JTextField();
        inputEmail = new JTextField();
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


        DefaultInputStyle.textFieldBound(inputEmail, 92, 301);
        DefaultInputStyle.textFieldBound(inputSenha, 92, 358);
        DefaultInputStyle.textField(inputSenha, inputEmail);
        return List.of(inputSenha, inputEmail, buttonLogin, btnAbout, lblUsuario, lblSenha, btnEsqueciSenha,
                btnCadastro);
    }

    public Void executeLogin(Void unused) {
        try {
            String email = "select * from usuarios where email like '".concat(inputEmail.getText());
            var usuario = repository.custom(email.concat("%' and senha='").concat(inputSenha.getText()).concat("'"));
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "usuario nao existe ou não encontrado\n verificar senha e email informados!");
                return null;
            }
            if (Boolean.TRUE.equals(usuario.getAdm())) {
                Change.toFrame(btnAbout, this, UsuariosAdm.class);
            } else if (Boolean.FALSE.equals(usuario.getAdm())) {
                Change.toFrame(btnAbout, this, Eventos.class);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "usuario nao existe ou não encontrado\n verificar senha e email informados!");
        }
        return null;
    }


}

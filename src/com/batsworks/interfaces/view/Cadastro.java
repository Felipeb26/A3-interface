package com.batsworks.interfaces.view;

import com.batsworks.interfaces.config.database.CustomRepository;
import com.batsworks.interfaces.model.UsuariosModel;
import com.batsworks.interfaces.utils.Change;
import com.batsworks.interfaces.utils.Validation;

import javax.swing.*;

public class Cadastro extends JFrame {

    transient CustomRepository<UsuariosModel> repository;
    JTextField inputIdade;
    JTextField inputEmail;
    JTextField inputNome;
    JTextField inputEndereco;
    JTextField inputSenha;

    public Cadastro() {
        startRepo();

        setBounds(100, 100, 701, 550);
        setResizable(false);
        setLocationRelativeTo(null);
        Change.controllCloseFrame(this, false);
        getContentPane().setLayout(null);


        inputEmail = new JTextField();
        inputEmail.setBounds(387, 218, 165, 30);
        getContentPane().add(inputEmail);
        inputEmail.setColumns(10);

        inputNome = new JTextField();
        inputNome.setBounds(387, 145, 165, 30);
        getContentPane().add(inputNome);
        inputNome.setColumns(10);

        inputSenha = new JTextField();
        inputSenha.setBounds(502, 363, 150, 28);
        getContentPane().add(inputSenha);
        inputSenha.setColumns(10);

        JLabel lblNome = new JLabel("NOME");
        lblNome.setBounds(402, 120, 46, 14);
        getContentPane().add(lblNome);

        JLabel lblEmail = new JLabel("EMAIL");
        lblEmail.setBounds(397, 193, 46, 14);
        getContentPane().add(lblEmail);

        JLabel lblSenha = new JLabel("SENHA");
        lblSenha.setBounds(544, 338, 46, 14);
        getContentPane().add(lblSenha);

        JButton btnCadastro = new JButton("CADASTRAR");
        btnCadastro.setBounds(522, 438, 109, 23);
        getContentPane().add(btnCadastro);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(27, 11, 94, 23);
        getContentPane().add(btnCancel);
        setVisible(true);

        Change.toFrame(btnCancel, this, Index.class);

        inputIdade = new JTextField();
        inputIdade.setBounds(580, 145, 72, 30);
        getContentPane().add(inputIdade);
        inputIdade.setColumns(10);

        JLabel lblIdade = new JLabel("IDADE");
        lblIdade.setBounds(603, 120, 46, 14);
        getContentPane().add(lblIdade);

        inputEndereco = new JTextField();
        inputEndereco.setBounds(388, 278, 264, 28);
        getContentPane().add(inputEndereco);
        inputEndereco.setColumns(10);
        cadastrar(btnCadastro);
        
        JLabel lblNewLabel = new JLabel("endereco");
        lblNewLabel.setBounds(397, 259, 46, 14);
        getContentPane().add(lblNewLabel);
    }


    private void startRepo() {
        repository = new CustomRepository<>(UsuariosModel.class, UsuariosModel::rowMapper);
    }

    public void cadastrar(JButton button) {
        button.addActionListener(e -> {
            try {
                Validation.notNull(inputNome, inputSenha, inputEmail, inputIdade, inputEndereco);
                repository.add(UsuariosModel.builder()
                        .nome(inputNome.getText())
                        .idade(Integer.parseInt(inputIdade.getText()))
                        .email(inputEmail.getText())
                        .endereco(inputEndereco.getText())
                        .senha(inputSenha.getText())
                        .adm(inputNome.getText().contains("felipe"))
                        .build());
                JOptionPane.showMessageDialog(null, "usuario " + inputNome.getText() + " cadastrado com sucesso!");
                Change.toFrame(button, this, Index.class);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o usuario".concat(ex.getMessage()));
            }
        });
    }
}

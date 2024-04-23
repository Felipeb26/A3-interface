package com.batsworks.interfaces.view;

import com.batsworks.interfaces.config.database.CustomRepository;
import com.batsworks.interfaces.model.UsuariosModel;
import com.batsworks.interfaces.utils.Change;

import javax.swing.*;
import java.sql.SQLException;

public class Cadastro extends JFrame {

    transient CustomRepository<UsuariosModel> repository;

    public Cadastro() {
        startRepo();

        setBounds(100, 100, 701, 550);
        setResizable(false);
        getContentPane().setLayout(null);
        Change.controllCloseFrame(this, false);


        JTextField inputEmail = new JTextField();
        inputEmail.setBounds(502, 225, 150, 30);
        getContentPane().add(inputEmail);
        inputEmail.setColumns(10);

        JTextField inputNome = new JTextField();
        inputNome.setBounds(387, 145, 165, 30);
        getContentPane().add(inputNome);
        inputNome.setColumns(10);

        JTextField inputSenha = new JTextField();
        inputSenha.setBounds(502, 363, 150, 28);
        getContentPane().add(inputSenha);
        inputSenha.setColumns(10);

        JLabel lblNome = new JLabel("NOME");
        lblNome.setBounds(402, 120, 46, 14);
        getContentPane().add(lblNome);

        JLabel lblEmail = new JLabel("EMAIL");
        lblEmail.setBounds(544, 200, 46, 14);
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

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\felip\\Pictures\\kali.png"));
        lblNewLabel.setBounds(43, 96, 369, 346);
        getContentPane().add(lblNewLabel);

        JTextField inputIdade = new JTextField();
        inputIdade.setBounds(580, 145, 72, 30);
        getContentPane().add(inputIdade);
        inputIdade.setColumns(10);

        JLabel lblIdade = new JLabel("IDADE");
        lblIdade.setBounds(603, 120, 46, 14);
        getContentPane().add(lblIdade);

        JTextField inputEndereco = new JTextField();
        inputEndereco.setBounds(502, 297, 150, 30);
        getContentPane().add(inputEndereco);
        inputEndereco.setColumns(10);

        JLabel lblEndereco = new JLabel("ENDERECO");
        lblEndereco.setBounds(544, 272, 72, 14);
        getContentPane().add(lblEndereco);
        try {
            cadastrar(btnCadastro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startRepo() {
        repository = new CustomRepository<>(UsuariosModel.class, UsuariosModel::rowMapper);
    }

    public void cadastrar(JButton button) throws SQLException {
        var list = repository.findAll();
        button.addActionListener(e -> {
//            try {
//                String mail = inputEmail.getText();
//                String nome = inputNome.getText();
//                String senha = inputSenha.getText();
//                String age = inputIdade.getText();
//                String ende = inputEmail.getText();
//                Validation.notNull(inputNome, inputSenha, inputEmail, inputIdade, inputEndereco);
//                String sql = "insert into usuarios (nome, email, senha, idade, endereco) values"
//                        + "(?, ?, ?, ?, ?)";
//                pst = conn.prepareStatement(sql);
//                pst.setString(1, nome);
//                pst.setString(2, mail);
//                pst.setString(3, senha);
//                pst.setInt(4, Integer.parseInt(age));
//                pst.setString(5, ende);
//                pst.execute();
//
//                JOptionPane.showMessageDialog(null, "usuario " + nome + " cadastrado com sucesso!");
//                Change.toFrame(button, this, Index.class);
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o usuario: "
//                        .concat(lblNome.getText()).concat(ex.getMessage()));
//            }
        });
    }
}

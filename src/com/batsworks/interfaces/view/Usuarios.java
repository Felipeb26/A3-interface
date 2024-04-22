package com.batsworks.interfaces.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.batsworks.interfaces.model.UsuarioModel;
import com.batsworks.interfaces.service.UsuarioService;
import com.batsworks.interfaces.utils.Change;

public class Usuarios {
    UsuarioModel model = new UsuarioModel();

    JFrame frame = new JFrame();
    JButton carrinho = new JButton("Carrinho icon");
    JButton sairLogin = new JButton("SAIR");
    JTable tableEvento;
    private JTextField inputNome;
    private JTextField inputEmail;
    private JTextField inputSenha;
    private JTextField inputIdade;
    JButton btnVoltar;
    JLabel lblIdade = new JLabel();

    private JTextField inputEndereco;
    JPanel panelTitle;
    UsuarioService service = new UsuarioService();

    public Usuarios() {
        frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 100, 674);
        frame.getContentPane().add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNome.setBounds(201, 162, 60, 30);
        frame.getContentPane().add(lblNome);

        inputNome = new JTextField();
        inputNome.setFont(new Font("Tahoma", Font.BOLD, 14));
        inputNome.setBounds(262, 159, 230, 40);
        frame.getContentPane().add(inputNome);
        inputNome.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEmail.setBounds(201, 351, 60, 30);
        frame.getContentPane().add(lblEmail);

        inputEmail = new JTextField();
        inputEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        inputEmail.setBounds(262, 348, 230, 40);
        frame.getContentPane().add(inputEmail);
        inputEmail.setColumns(10);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSenha.setBounds(201, 418, 60, 30);
        frame.getContentPane().add(lblSenha);

        inputSenha = new JTextField();
        inputSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
        inputSenha.setBounds(262, 415, 230, 40);
        frame.getContentPane().add(inputSenha);
        inputSenha.setColumns(10);

        JLabel lblIDOSO = new JLabel("");
        lblIDOSO.setBounds(540, 60, 46, 14);
        frame.getContentPane().add(lblIDOSO);

        inputIdade = new JTextField();
        inputIdade.setFont(new Font("Tahoma", Font.BOLD, 14));
        inputIdade.setBounds(262, 234, 230, 40);
        frame.getContentPane().add(inputIdade);
        inputIdade.setColumns(10);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblIdade.setBounds(201, 237, 60, 30);
        frame.getContentPane().add(lblIdade);

        JButton btnAtualizar = new JButton("ATUALIZAR");
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Atualizar();
            }
        });
        btnAtualizar.setBounds(540, 562, 99, 23);
        frame.getContentPane().add(btnAtualizar);

        btnVoltar = new JButton("VOLTAR");
        btnVoltar.setBounds(390, 562, 89, 23);
        frame.getContentPane().add(btnVoltar);

        lblIdade = new JLabel("");
        lblIdade.setBounds(549, 162, 90, 50);
        frame.getContentPane().add(lblIdade);
        lblIdade.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblIdade.setPreferredSize(new Dimension(90, 50));

        inputEndereco = new JTextField();
        inputEndereco.setFont(new Font("Tahoma", Font.BOLD, 14));
        inputEndereco.setBounds(262, 296, 230, 40);
        frame.getContentPane().add(inputEndereco);
        inputEndereco.setColumns(10);

        JLabel lblNewLabel = new JLabel("Endereco:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(171, 299, 90, 30);
        frame.getContentPane().add(lblNewLabel);

        panelTitle = new JPanel();
        panelTitle.setBackground(Color.GRAY);
        panelTitle.setBounds(98, -1, 586, 75);
        frame.getContentPane().add(panelTitle);
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("CADASTRO");
        panelTitle.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        Retornar();
        Bring();
        Change.controllCloseFrame(frame, false);
    }

    public void Bring() {
        try {
            service.findAlllUsers().forEach(dado -> {
                inputNome.setText(dado.getNome());
                inputEmail.setText(dado.getEmail());
                inputSenha.setText(dado.getSenha());
                inputEndereco.setText(dado.getEndereco());
                inputIdade.setText(String.valueOf(dado.getIdade()));
                if (dado.getIdade() >= 60) {
                    lblIdade.setText("idoso");
                } else {
                    lblIdade.setText("jovem");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void Retornar() {
        btnVoltar.addActionListener(e -> {
            try {
                frame.dispose();
                new Eventos();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
    }

    public void Atualizar() {
        String nome = inputNome.getText();
        String email = inputEmail.getText();
        String idade = inputIdade.getText();
        String ende = inputEndereco.getText();
        String senha = inputSenha.getText();
        try {
            service.updateUser(nome, email, ende, idade, null, senha, email);
            JOptionPane.showMessageDialog(null, "atualizado com sucesso");
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
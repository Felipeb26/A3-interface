package com.batsworks.interfaces.view;

import com.batsworks.interfaces.config.database.CustomRepository;
import com.batsworks.interfaces.model.UsuariosModel;
import com.batsworks.interfaces.service.CarrinhoService;
import com.batsworks.interfaces.utils.Change;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UsuariosAdm extends JFrame {
    transient CustomRepository<UsuariosModel> repository;

    private JTable tableEvento;
    private JTextField textField;
    JButton btnSair;
    JButton btnUpdate;
    CarrinhoService produtos = new CarrinhoService();
    JButton btnLogin = new JButton("LOGIN");
    JButton btnDelete;

    public UsuariosAdm() {
        Change.controllCloseFrame(this, false);
        setSize(700, 700);
        setResizable(false);
        getContentPane().setLayout(null);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 100, 674);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("label");
        lblNewLabel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblNewLabel_1.setPreferredSize(new Dimension(90, 50));
        panel.add(lblNewLabel_1);

        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogin.setMargin(new Insets(10, 14, 2, 14));
        btnLogin.setPreferredSize(new Dimension(90, 100));
        panel.add(btnLogin);
        btnLogin.addActionListener(e -> new UsuariosAdm());

        JButton btnCadastro = new JButton("ADD");
        btnCadastro.setPreferredSize(new Dimension(90, 100));
        panel.add(btnCadastro);
        btnCadastro.addActionListener(e -> new Cadastro());

        btnUpdate = new JButton("UPDATE");
        btnUpdate.addActionListener(e -> UpdateUser());
        btnUpdate.setPreferredSize(new Dimension(90, 100));
        panel.add(btnUpdate);

        btnDelete = new JButton("DELETE");
        btnDelete.setPreferredSize(new Dimension(90, 100));
        panel.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteUsuario();
            }
        });

        btnSair = new JButton("SAIR");
        btnSair.setPreferredSize(new Dimension(90, 100));
        panel.add(btnSair);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(120, 169, 554, 409);

        tableEvento = new JTable();
        tableEvento.setDragEnabled(true);
        scrollPane.setViewportView(tableEvento);
        tableEvento.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"NOME", "email ", "endereco", "idade", "adm", "senha"}) {
            boolean[] columnEditables = new boolean[]{false, false, false};

            public boolean isCellEditable(int row, int column) {
                return true;
            }
        });




//        model.findAlllUsers().forEach(it -> {
//            DefaultTableModel table = (DefaultTableModel) tableEvento.getModel();
//            Object[] data = {it.getNome(), it.getEmail(), it.getEndereco(), it.getIdade(), it.getAdm(),
//                    it.getSenha()};
//            table.addRow(data);
//        });
        Change.toFrame(btnSair, this, Eventos.class);
    }


    private List<? extends JComponent> components(){

        textField = new JTextField();
        textField.setBounds(150, 31, 320, 40);
        return null;
    }

    private void configureTable(){
        tableEvento.getColumnModel().getColumn(0).setResizable(false);
        tableEvento.getColumnModel().getColumn(1).setResizable(false);
        tableEvento.getColumnModel().getColumn(2).setResizable(false);
        tableEvento.setFillsViewportHeight(true);
        tableEvento.setColumnSelectionAllowed(true);
        tableEvento.setCellSelectionEnabled(true);
    }


    public void UpdateUser() {
        try {
            if (tableEvento.getSelectedRow() != -1) {
                String nome = tableEvento.getValueAt(tableEvento.getSelectedRow(), 0).toString();
                String email = tableEvento.getValueAt(tableEvento.getSelectedRow(), 1).toString();
                String ende = tableEvento.getValueAt(tableEvento.getSelectedRow(), 2).toString();
                String idade = tableEvento.getValueAt(tableEvento.getSelectedRow(), 3).toString();
                Boolean adm = (Boolean) tableEvento.getValueAt(tableEvento.getSelectedRow(), 4);
                String senha = tableEvento.getValueAt(tableEvento.getSelectedRow(), 5).toString();
//                model.updateUser(nome, email, ende, idade, adm, senha, email);
                JOptionPane.showMessageDialog(null, "alterado com sucesso");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUsuario() {
        try {
            if (tableEvento.getSelectedRow() != -1) {
                String email = tableEvento.getValueAt(tableEvento.getSelectedRow(), 1).toString();
                int i = tableEvento.getSelectedRow();
//                model.deleteUser(email);
                ((DefaultTableModel) tableEvento.getModel()).removeRow(i);
                JOptionPane.showMessageDialog(null, "deletado com sucesso");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
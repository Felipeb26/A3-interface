package com.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.service.CarrinhoService;
import com.service.UsuarioService;
import com.utils.Change;

public class UsuariosAdm {
	JFrame frame = new JFrame();
	private JTable tableEvento;
	private JTextField textField;
	JButton btnSair;
	JButton btnUpdate;
	UsuarioService model = new UsuarioService();
	CarrinhoService produtos = new CarrinhoService();
	JButton btnLogin = new JButton("LOGIN");
	JButton btnDelete;

	public UsuariosAdm() {
		Change.controllCloseFrame(frame, false);
		frame.setSize(700, 700);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 100, 674);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel_1.setPreferredSize(new Dimension(90, 50));
		panel.add(lblNewLabel_1);
		

		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setMargin(new Insets(10, 14, 2, 14));
		btnLogin.setPreferredSize(new Dimension(90, 100));
		panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UsuariosAdm();
			}
		});

		JButton btnCadastro = new JButton("ADD");
		btnCadastro.setPreferredSize(new Dimension(90, 100));
		panel.add(btnCadastro);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cadastro();
			}
		});

		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateUser();
			}
		});
		btnUpdate.setPreferredSize(new Dimension(90, 100));
		panel.add(btnUpdate);

		btnDelete = new JButton("DELETE");
		btnDelete.setPreferredSize(new Dimension(90, 100));
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteUser();
			}
		});

		btnSair = new JButton("SAIR");
		btnSair.setPreferredSize(new Dimension(90, 100));
		panel.add(btnSair);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 169, 554, 409);
		frame.getContentPane().add(scrollPane);

		tableEvento = new JTable();
		tableEvento.setDragEnabled(true);
		scrollPane.setViewportView(tableEvento);
		tableEvento.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "NOME", "email ", "endereco", "idade", "adm", "senha" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return true;
			}
		});
		tableEvento.getColumnModel().getColumn(0).setResizable(false);
		tableEvento.getColumnModel().getColumn(1).setResizable(false);
		tableEvento.getColumnModel().getColumn(2).setResizable(false);
		tableEvento.setFillsViewportHeight(true);
		tableEvento.setColumnSelectionAllowed(true);
		tableEvento.setCellSelectionEnabled(true);

		textField = new JTextField();
		textField.setBounds(150, 31, 320, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		model.findAlllUsers().forEach(it -> {
			DefaultTableModel table = (DefaultTableModel) tableEvento.getModel();
			Object[] data = { it.getNome(), it.getEmail(), it.getEndereco(), it.getIdade(), it.getAdm(),
					it.getSenha() };
			table.addRow(data);
		});
		Retornar();
	}

	public void Retornar() {
		btnSair.addActionListener(e -> {
            try {
                frame.dispose();
                new Eventos();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
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
				model.updateUser(nome, email, ende, idade, adm, senha, email);
				JOptionPane.showMessageDialog(null, "alterado com sucesso");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteUser() {
		try {
			if (tableEvento.getSelectedRow() != -1) {
				String email = tableEvento.getValueAt(tableEvento.getSelectedRow(), 1).toString();
				int i =  tableEvento.getSelectedRow();
				model.deleteUser(email);
				((DefaultTableModel) tableEvento.getModel()).removeRow(i);
				JOptionPane.showMessageDialog(null, "deletado com sucesso");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
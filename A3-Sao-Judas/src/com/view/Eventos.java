package com.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.service.CarrinhoService;
import com.service.UsuarioService;
import com.utils.Change;


public class Eventos {
	JFrame frame = new JFrame();
	private JTable tableEvento;
	private JTextField textField;
	
	UsuarioService model = new UsuarioService();
	CarrinhoService produtos = new CarrinhoService();
	JButton carrinho = new JButton("Carrinho icon");
	JButton btnLogin = new JButton("LOGIN");
	
	@SuppressWarnings("serial")
	public Eventos() {
		Change screen = new Change();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setPreferredSize(new Dimension(90, 100));
		panel.add(btnNewButton);

		JButton button = new JButton("New button");
		button.setPreferredSize(new Dimension(90, 100));
		panel.add(button);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setPreferredSize(new Dimension(90, 100));
		panel.add(btnNewButton_3);

		JButton btnSair = new JButton("SAIR");
		btnSair.setPreferredSize(new Dimension(90, 100));
		panel.add(btnSair);

		Change.ScreenIndex(btnSair, frame);
		Change.ScreenLogin(btnLogin, frame);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 169, 554, 409);
		frame.getContentPane().add(scrollPane);
		
		tableEvento = new JTable();
		tableEvento.setDragEnabled(true);
		scrollPane.setViewportView(tableEvento);
		tableEvento.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOME", "descricao ", "valor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		tableEvento.getColumnModel().getColumn(0).setResizable(false);
		tableEvento.getColumnModel().getColumn(1).setResizable(false);
		tableEvento.getColumnModel().getColumn(2).setResizable(false);
		tableEvento.setFillsViewportHeight(true);
		tableEvento.setColumnSelectionAllowed(true);
		tableEvento.setCellSelectionEnabled(true);
		Produtos();
		
		textField = new JTextField();
		textField.setBounds(150, 31, 320, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		carrinho.setBounds(564, 40, 89, 23);
		frame.getContentPane().add(carrinho);
		
		screen.ScreenCarrinho(carrinho, frame);		
	}
	
	public void Produtos() {
		produtos.carrinho().forEach(datas ->{
			produtos.carrinho();
			DefaultTableModel table = (DefaultTableModel) tableEvento.getModel();
			Object[] data = {datas.getNome(), datas.getDescricao(), datas.getValor()};
			table.addRow(data);
		});
	}
	
}

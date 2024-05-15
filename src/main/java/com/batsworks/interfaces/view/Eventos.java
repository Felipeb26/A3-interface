package main.com.batsworks.interfaces.view;

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

import main.com.batsworks.interfaces.config.database.CustomRepository;
import main.com.batsworks.interfaces.model.ProdutosModel;
import main.com.batsworks.interfaces.utils.Change;
import java.awt.BorderLayout;

public class Eventos extends JFrame {
	
	CustomRepository<ProdutosModel> repository;
	private JTable tableEvento;
	private JTextField textField;
	JButton carrinho = new JButton("Carrinho icon");
	JButton btnLogin = new JButton("LOGIN");

	@SuppressWarnings("serial")
	public Eventos() {
		repository = new CustomRepository<>(ProdutosModel.class, ProdutosModel::rowMapper);
		Change.controllCloseFrame(this, false);
		setSize(700, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 100, 674);
		getContentPane().add(panel);
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

		Change.toFrame(btnSair, this, Index.class);
		Change.toFrame(btnLogin, this, Usuarios.class);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 169, 554, 409);
		getContentPane().add(scrollPane);

		tableEvento = new JTable();
		tableEvento.setDragEnabled(true);
		scrollPane.setViewportView(tableEvento);
		tableEvento.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "NOME", "descricao ", "valor" }) {
			final boolean[] columnEditables = new boolean[] { false, false, false };

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
		produtos();

		textField = new JTextField();
		textField.setBounds(136, 26, 354, 42);
		getContentPane().add(textField);
		textField.setColumns(10);
		carrinho.setBackground(new Color(0, 64, 0));

		carrinho.setBounds(582, 25, 79, 43);
		getContentPane().add(carrinho);

		Change.toFrame(carrinho, this, Carrinho.class);
		
	}
	
	public void produtos() {
		try{
			repository.findAll().forEach(datas -> {
				DefaultTableModel table = (DefaultTableModel) tableEvento.getModel();
				Object[] data = { datas.getNome(), datas.getDescricao(), datas.getValor() };
				table.addRow(data);
			});
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}

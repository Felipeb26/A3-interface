package main.com.batsworks.interfaces.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import main.com.batsworks.interfaces.config.database.ConexaoDb;
import main.com.batsworks.interfaces.service.CarrinhoService;
import main.com.batsworks.interfaces.service.UsuarioService;
import main.com.batsworks.interfaces.utils.Change;

public class Carrinho extends JFrame{

	JTable tableEvento;
	JButton btnEventos = new JButton("VOLTAR");
	TableColumn pesoa;
	JScrollPane scrollPane;

	CarrinhoService carrinho = new CarrinhoService();
	UsuarioService service = new UsuarioService();
	static Connection conn = ConexaoDb.conecta();
	static ResultSet rs;
	static PreparedStatement pst;
	private final JScrollPane scrollPane_1 = new JScrollPane();

	@SuppressWarnings("serial")
	public Carrinho() {
		Change.controllCloseFrame(this, false);
		setSize(700, 700);
		setResizable(false);
        setLocationRelativeTo(null);
		setVisible(true);

		btnEventos.setBounds(28, 603, 89, 23);
		getContentPane().add(btnEventos);
		scrollPane_1.setBounds(0, 201, 684, 391);

		getContentPane().add(scrollPane_1);

		tableEvento = new JTable();
		tableEvento.setDragEnabled(true);
		scrollPane_1.setViewportView(tableEvento);
		tableEvento.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "NOME", "descricao ", "valor" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			@Override
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

		carrinho.carrinho().forEach(datas -> {
			DefaultTableModel table = (DefaultTableModel) tableEvento.getModel();
			Object[] data = { datas.getNome(), datas.getDescricao(), datas.getValor() };
			table.addRow(data);
		});

		Retornar();
		
	}

	public void Retornar() {
		btnEventos.addActionListener(e -> {
			try {
				dispose();
				new Eventos();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		});
	}

}

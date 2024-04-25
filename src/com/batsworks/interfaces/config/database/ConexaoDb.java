package com.batsworks.interfaces.config.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class ConexaoDb {

	ConexaoDb() {
		throw new IllegalStateException("Utility class");
	}

	private static Connection conexao;
	private static final String DB_CONFIG = System.getenv("DB_PROPERTIES");
	private static int startup = 0;

	public static Connection conecta() {
		try {
			if (conexao == null || conexao.isClosed()) {
				Properties props = loadProperties();
				String url = props.getProperty("datasource.url");
				Class.forName(props.getProperty("driver"));
				conexao = DriverManager.getConnection(url, props.getProperty("username"),
						props.getProperty("password"));

				if (startup <= 0) {
					startup++;
					PreCompile.executeQuery();
				}
			}
		} catch (SQLException e) {
			Logger.getLogger(ConexaoDb.class.getName()).log(Level.SEVERE, e.getMessage(), e);
			JOptionPane.showMessageDialog(null, "Não foi possivel se comunicar com o banco de dados\n"
					+ "verifique a conexão com internet ou reinicie o dispositivo");
			System.exit(0);
		} catch (Exception e) {
			Logger.getLogger(ConexaoDb.class.getName()).log(Level.SEVERE, e.getMessage(), e);
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
		return conexao;
	}

	private static Properties loadProperties() throws IOException {
		try (FileInputStream fs = new FileInputStream("src/resources/".concat(DB_CONFIG))) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
	}

	public static void desconecta() {
		try {
			conexao.close();
		} catch (SQLException e) {
			Logger.getLogger(ConexaoDb.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public static void desconecta(PreparedStatement stm, ResultSet rs) {
		try {
			closeStatement(stm);
			closeResultSet(rs);
			conexao.close();
		} catch (SQLException e) {
			Logger.getLogger(ConexaoDb.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public static void closeStatement(Statement stm) {
		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				Logger.getLogger(ConexaoDb.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				Logger.getLogger(ConexaoDb.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}
}
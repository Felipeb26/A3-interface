package com.config;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDb {
	
		public Statement stm;
		public ResultSet rs;
		public static Connection conexao;

		public static Connection conecta() {
			if (conexao == null) {
				try {
					Properties props = loadProperties();
					String url = props.getProperty("datasource.url");
					conexao = DriverManager.getConnection(url, props.getProperty("username"), props.getProperty("password"));
				} catch (SQLException e) {
					Logger.getLogger(ConexaoDb.class.getName()).log(Level.SEVERE, e.getMessage(), e);
				}catch (Exception e){
					Logger.getLogger(ConexaoDb.class.getName()).log(Level.SEVERE, e.getMessage(), e);
				}
			}
			return conexao;
		}

		public void desconecta() {
			try {
				conexao.close();
			} catch (SQLException e) {
				Logger.getLogger(ConexaoDb.class.getName()).log(Level.SEVERE, null, e);
			}
		}

		private static Properties loadProperties() {
			try (FileInputStream fs = new FileInputStream("db.properties")) {
				Properties props = new Properties();
				props.load(fs);
				return props;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		}

		public static void closeStatement(Statement stm) {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		public static void closeResultSet(ResultSet rs) {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
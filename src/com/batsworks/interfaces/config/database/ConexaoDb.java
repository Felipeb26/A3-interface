package com.batsworks.interfaces.config.database;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDb {

    public static Connection conexao;

    public static Connection conecta() {
        if (conexao == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("datasource.url");
                conexao = DriverManager.getConnection(url, props.getProperty("username"), props.getProperty("password"));
            } catch (SQLException e) {
                Logger.getLogger(ConexaoDb.class.getName()).log(Level.SEVERE, e.getMessage(), e);
                JOptionPane.showMessageDialog(null, "Não foi possivel se comunicar com o banco de dados\n" +
                        "verifique a conexão com internet ou reinicie o dispositivo");
                System.exit(0);
            } catch (Exception e) {
                Logger.getLogger(ConexaoDb.class.getName()).log(Level.SEVERE, e.getMessage(), e);
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        return conexao;
    }

    private static Properties loadProperties() throws IOException {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
    }


    public void desconecta() {
        try {
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
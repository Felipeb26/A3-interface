package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.config.ConexaoDb;
import com.model.UsuarioModel;

public class UsuarioService {

	Connection conn = ConexaoDb.conecta();
	ResultSet rs;
	PreparedStatement pst;

	public List<UsuarioModel> findAlllUsers() {
		List<UsuarioModel> usuario = new ArrayList<>();
		try {
			String sql = "select * from usuarios";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				UsuarioModel model = UsuarioModel.builder().id(rs.getLong("id")).nome(rs.getString("nome"))
						.idade(rs.getInt("idade")).email(rs.getString("email")).adm(rs.getBoolean("adm"))
						.endereco(rs.getString("endereco")).senha(rs.getString("senha")).build();
				usuario.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public List<UsuarioModel> findUserByLogin(String name, String pass) throws SQLException {
		List<UsuarioModel> usuario = new ArrayList<>();
		String sql = "select * from usuarios where nome like '%s%%' and senha='%s' limit 1";
		String query = String.format(sql, name, pass);
		Statement stm = conn.createStatement();
		rs = stm.executeQuery(query);
		while (rs.next()) {
			UsuarioModel model = UsuarioModel.builder().id(rs.getLong("id")).nome(rs.getString("nome"))
					.idade(rs.getInt("idade")).email(rs.getString("email")).adm(rs.getBoolean("adm"))
					.endereco(rs.getString("endereco")).senha(rs.getString("senha")).build();
			usuario.add(model);
		}
		return usuario;
	}

	public void updateUser(String nome, String email, String ende, String idade, Boolean adm, String senha,
			String param) throws SQLException {
		String sql = "update usuarios set nome='%s', email='%s', endereco='%s', idade=%s, adm=%s, senha='%s' where email='%s'";
		String query = String.format(sql, nome, email, ende, idade, adm, senha, param);
		pst = conn.prepareStatement(query);
		pst.executeUpdate();
	}
	
	public void deleteUser(String email) throws SQLException {
		String sql = "delete from usuarios where email='%s'";
		String query =String.format(sql, email);
		pst =conn.prepareStatement(query);
		pst.execute();
	}
}

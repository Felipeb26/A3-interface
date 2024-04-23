package com.batsworks.interfaces.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.batsworks.interfaces.config.database.ConexaoDb;
import com.batsworks.interfaces.model.UsuariosModel;

public class UsuarioService {

    Connection conn = ConexaoDb.conecta();
    ResultSet rs;
    PreparedStatement pst;

    public List<UsuariosModel> findAlllUsers() {
        List<UsuariosModel> usuario = new ArrayList<>();
        try {
            String sql = "select * from usuarios";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                UsuariosModel model = UsuariosModel.builder().id(rs.getLong("id")).nome(rs.getString("nome"))
                        .idade(rs.getInt("idade")).email(rs.getString("email")).adm(rs.getBoolean("adm"))
                        .endereco(rs.getString("endereco")).senha(rs.getString("senha")).build();
                usuario.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public UsuariosModel findUserByLogin(String name, String pass) throws SQLException {
        String query = String.format("select * from usuarios where email like '%s%%' and senha='%s' limit 1", name, pass);
        pst = conn.prepareStatement(query);
        rs = pst.executeQuery();
        return UsuariosModel.builder().id(rs.getLong("id")).nome(rs.getString("nome"))
                .idade(rs.getInt("idade")).email(rs.getString("email")).adm(rs.getBoolean("adm"))
                .endereco(rs.getString("endereco")).senha(rs.getString("senha")).build();
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
        String query = String.format(sql, email);
        pst = conn.prepareStatement(query);
        pst.execute();
    }
}

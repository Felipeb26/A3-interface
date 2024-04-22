package com.batsworks.interfaces.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.batsworks.interfaces.config.database.ConexaoDb;
import com.batsworks.interfaces.model.ProdutosModel;

public class CarrinhoService {

    static Connection conn = ConexaoDb.conecta();
    static ResultSet rs;
    static PreparedStatement pst;

    public List<ProdutosModel> carrinho() {
        String sql = "select * from produtos";
        List<ProdutosModel> produtos = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ProdutosModel model = ProdutosModel
                        .builder()
                        .id(rs.getLong("id"))
                        .idUsuario("idUsuario")
                        .nome(rs.getString("nome"))
                        .descricao(rs.getString("descricao"))
                        .valor(rs.getBigDecimal("valor"))
                        .build();
                produtos.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public List<ProdutosModel> findProductByUser(String id) throws SQLException {
        List<ProdutosModel> produto = new ArrayList<>();
        String sql = "select * from produtos where idUsuario ='%s'";
        String query = String.format(sql, id);
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(query);
        while (rs.next()) {
            ProdutosModel model = ProdutosModel
                    .builder()
                    .id(rs.getLong("id"))
                    .idUsuario("idUsuario")
                    .nome(rs.getString("nome"))
                    .descricao(rs.getString("descricao"))
                    .valor(rs.getBigDecimal("valor"))
                    .build();
            produto.add(model);
        }
        return produto;
    }
}

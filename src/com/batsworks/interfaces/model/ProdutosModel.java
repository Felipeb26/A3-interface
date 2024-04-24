package com.batsworks.interfaces.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.sql.ResultSet;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosModel {

    private Long id;
    private String idUsuario;
    private String nome;
    private String descricao;
    private BigDecimal valor;

    public static UsuariosModel rowMapper(Object o) {
        try {
            if (o instanceof ResultSet) {
                var rs = (ResultSet) o;
                return UsuariosModel.builder().id(rs.getLong("id")).nome(rs.getString("nome"))
                        .idade(rs.getInt("idade")).email(rs.getString("email")).adm(rs.getBoolean("adm"))
                        .endereco(rs.getString("endereco")).senha(rs.getString("senha")).build();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

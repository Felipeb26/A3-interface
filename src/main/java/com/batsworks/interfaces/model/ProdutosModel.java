package main.com.batsworks.interfaces.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.sql.ResultSet;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosModel {

    private Long id;
    private String idUsuario;
    private String nome;
    private String descricao;
    private BigDecimal valor;

    public static ProdutosModel rowMapper(ResultSet rs) {
        try {
        	return ProdutosModel.builder()
        			.id(rs.getLong("id"))
        			.nome(rs.getString("nome"))
        			.descricao(rs.getString("descricao"))
        			.valor(rs.getBigDecimal("valor"))
        			.build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

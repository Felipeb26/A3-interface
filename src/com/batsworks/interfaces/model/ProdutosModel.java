package com.batsworks.interfaces.model;

import java.math.BigDecimal;
import java.sql.ResultSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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

	public ProdutosModel rowMapper(ResultSet rs) {
		try {
			return ProdutosModel.builder().id(rs.getLong("id"))
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

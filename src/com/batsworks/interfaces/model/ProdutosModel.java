package com.batsworks.interfaces.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

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
}

package com.batsworks.interfaces.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {
	
	private Long id;
	private int idade;
	private String nome;
	private String email;
	private String endereco;
	private String senha;
	private Boolean adm;
}

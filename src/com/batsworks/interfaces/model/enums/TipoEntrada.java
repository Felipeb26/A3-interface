package com.batsworks.interfaces.model.enums;

public enum TipoEntrada {
	
	NUMERO("NUMERO"),
	NOME("NOME"),
	DECIMAL("DECIMAL"),
	EMAIL("EMAIL");
	
	TipoEntrada(String entrada){
		this.entrada = entrada;
	}
	
	private final String entrada;

	public String getEntrada() {
		return this.entrada;
	}
}

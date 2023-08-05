package com.jorgeadammo.sistemas.entity;

public enum EStatus {
	EM_ANDAMENTO("Em Andamento"), 
	HOMOLOGADO("Homologado"),
	NOVO("Novo"),
	ENCERRADO("Encerrado");
	
	private String descricao;
	
	EStatus(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	
}

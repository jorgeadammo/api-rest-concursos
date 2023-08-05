package com.jorgeadammo.sistemas.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BancaDto {
	private Long id;
	private String nome;
	private String apelido;
	private String telefoneFixo;
	private String endereco;
	private boolean ativo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date data;
	
	//
	public BancaDto() {
	}
	
	@Override
	public String toString() {
		return "Banca [id=" + id + ", nome=" + nome + ", apelido=" + apelido
				+ ", telefoneFixo=" + telefoneFixo + ", endereco=" + endereco + ", ativo=" + ativo + ", data=" + data + "]";
	}
	//
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull(message = "Nome é uma informação obrigatória")
	@Length(min = 5, max = 100, message = "Nome deve estar entre 5 e 100 caracteres")
	@NotBlank(message = "Nome é obrigatório.")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotNull(message = "Apelido é uma informação obrigatória")
	@Length(min = 3, max = 50, message = "Apelido deve estar entre 3 e 50 caracteres")
	@NotBlank(message = "Apelido é obrigatório.")
	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}

package com.jorgeadammo.sistemas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(schema="CNCRS", name="BNC_BANCA")
public class Banca implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8648934979891152376L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@ApiModelProperty(notes="ID da banca")
	private Long id;
	
	@Column(name = "NOME", nullable = false, length = 100)
	@ApiModelProperty(notes="Nome da banca")
	private String nome;
	
	@Column(name = "APELIDO", nullable = false, length = 50)
	@ApiModelProperty(notes="Apelido da banca")
	private String apelido;
	
	@Column(name = "TELEFONE", length = 11)
	@ApiModelProperty(notes="Telefone da banca")
	private String telefoneFixo;
	
	@Column(name = "ENDERECO", length = 255)
	@ApiModelProperty(notes="Endereço da banca")
	private String endereco;
	
	@Column(name="ATIVO")
	@ApiModelProperty(notes="Status da banca, se ativo ou não")
	private boolean ativo;
	
	@Column(name="DATA")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonSerialize(using = DateSerializer.class)
	@ApiModelProperty(notes="Data da banca")
	private Date data;
	
	//
	public Banca() {
	}

	public Banca(Long id, String nome, String apelido, String telefoneFixo, String endereco, boolean ativo, Date data) {
		this.id = id;
		this.nome = nome;
		this.apelido = apelido;
		this.telefoneFixo = telefoneFixo;
		this.endereco = endereco;
		this.ativo = ativo;
		this.data = data;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefoneFixo == null) ? 0 : telefoneFixo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banca other = (Banca) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (ativo != other.ativo)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefoneFixo == null) {
			if (other.telefoneFixo != null)
				return false;
		} else if (!telefoneFixo.equals(other.telefoneFixo))
			return false;
		return true;
	}
	
}

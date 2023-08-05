package com.jorgeadammo.sistemas.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(schema="CNCRS", name="FAS_FASE_CONCURSO")
public class Fase implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="FAS_ID")
	private Long id;
	
	@Column(nullable=false, length=100, unique=true, name="FAS_FASE")
	@NotBlank(message = "Fase é uma informação obrigatória.")
	private String faseConcurso;
	
	@Column(length=255, name="FAS_DESC")
	private String descricao;
	
	@Column(nullable=false, updatable=false, name="FAS_DT_HR_INC")
	private Timestamp dt_hr_inc;
	
	@Column(nullable=false, name="FAS_DT_HR_ALT")
	private Timestamp dt_hr_alt;
	
	// Construtor
	public Fase() {
	}
	
	public Fase(String faseConcurso, Timestamp dt_hr_inc, Timestamp dt_hr_alt) {
		this.faseConcurso = faseConcurso;
		this.dt_hr_inc = dt_hr_inc;
		this.dt_hr_alt = dt_hr_alt;
	}

	public String getFaseConcurso() {
		return faseConcurso;
	}

	public void setFaseConcurso(String faseConcurso) {
		this.faseConcurso = faseConcurso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Timestamp getDt_hr_inc() {
		return dt_hr_inc;
	}

	public void setDt_hr_inc(Timestamp dt_hr_inc) {
		this.dt_hr_inc = dt_hr_inc;
	}

	public Timestamp getDt_hr_alt() {
		return dt_hr_alt;
	}

	public void setDt_hr_alt(Timestamp dt_hr_alt) {
		this.dt_hr_alt = dt_hr_alt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((dt_hr_alt == null) ? 0 : dt_hr_alt.hashCode());
		result = prime * result
				+ ((dt_hr_inc == null) ? 0 : dt_hr_inc.hashCode());
		result = prime * result
				+ ((faseConcurso == null) ? 0 : faseConcurso.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Fase other = (Fase) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dt_hr_alt == null) {
			if (other.dt_hr_alt != null)
				return false;
		} else if (!dt_hr_alt.equals(other.dt_hr_alt))
			return false;
		if (dt_hr_inc == null) {
			if (other.dt_hr_inc != null)
				return false;
		} else if (!dt_hr_inc.equals(other.dt_hr_inc))
			return false;
		if (faseConcurso == null) {
			if (other.faseConcurso != null)
				return false;
		} else if (!faseConcurso.equals(other.faseConcurso))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}

/*
CREATE TABLE CONCURSOS.FAS_FASE_CONCURSO
(
FAS_ID int PRIMARY KEY NOT NULL IDENTITY,
FAS_FASE varchar(100) NOT NULL,
FAS_DESC varchar(255),
FAS_DT_HR_INC timestamp NOT NULL,
FAS_DT_HR_ALT timestamp NOT NULL
);commit;
--
CREATE UNIQUE INDEX PK_FAS ON CONCURSOS.FAS_FASE_CONCURSO(FAS_ID); commit; -- N�o pode repetir o id
CREATE UNIQUE INDEX U_FAS_FASE ON CONCURSOS.FAS_FASE_CONCURSO(FAS_FASE); commit; -- N�o pode repetir a fase

*/
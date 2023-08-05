package com.jorgeadammo.sistemas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(schema="CNCRS", name="CNC_CONCURSO")
public class Concurso extends PersistentEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false, length=255, unique=true, name="CNC_TIT_CONCURSO")
	private String titulo;
	
	@Column(nullable=false, length=4, name="CNC_ANO")
	private String ano;
	
	@Column(length=100, name="CNC_ENTE_CONCURSO")
	private String ente;
	
	@Column(length=255, name="CNC_DESC_CONCURSO")
	private String descricao;
	
	@Column(nullable=false, length=50, name="CNC_TIP_ESFERA")
	private String tipoEsfera;
	
	@Column(length=2, name="CNC_UF")
	private String uf;
	
	@Column(length=50, name="CNC_ADMIN")
	private String admin;
	
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class)
	@Column(nullable=false, name="CNC_DT_INSC_INI")
	private Date dt_insc_ini;
	
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class)
	@Column(nullable=false, name="CNC_DT_INSC_FIM")
	private Date dt_insc_fim;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonSerialize(using = DateSerializer.class)
	@Column(name="CNC_DT_PG_BLOQ")
	private Date dt_pg_bloq;
	
	@Column(length=50, name="CNC_FORMATO")
	private String formato;
	
	@Column(length=50, name="CNC_REGIME")
	private String regime;
	
	@Column(name="CNC_ATIVO")
	private Boolean ativo;
	
	@Column(length=100, name="CNC_LINK_CONCURSO")
	private String link;
	
	@Column(length=100, name="CNC_EDITAL_PRINC")
	private String edital;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonSerialize(using = DateSerializer.class)
	@Column(name="CNC_DT_EDITAL")
	private Date dt_edital;
		
	@ManyToOne
	@JoinColumn(name="BNC_ID")
	private Banca banca;
	
	/*
	@ManyToOne
	@JoinColumn(nullable=false, name="STA_ID")
	private Status status;
	*/
	
	//@ManyToOne
	//@JoinColumn(nullable=false)
	@Enumerated(EnumType.STRING)
	private EStatus estatus;
	
	//
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getEnte() {
		return ente;
	}
	public void setEnte(String ente) {
		this.ente = ente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipoEsfera() {
		return tipoEsfera;
	}
	public void setTipoEsfera(String tipoEsfera) {
		this.tipoEsfera = tipoEsfera;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public Date getDt_insc_ini() {
		return dt_insc_ini;
	}
	public void setDt_insc_ini(Date dt_insc_ini) {
		this.dt_insc_ini = dt_insc_ini;
	}
	public Date getDt_insc_fim() {
		return dt_insc_fim;
	}
	public void setDt_insc_fim(Date dt_insc_fim) {
		this.dt_insc_fim = dt_insc_fim;
	}
	public Date getDt_pg_bloq() {
		return dt_pg_bloq;
	}
	public void setDt_pg_bloq(Date dt_pg_bloq) {
		this.dt_pg_bloq = dt_pg_bloq;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getRegime() {
		return regime;
	}
	public void setRegime(String regime) {
		this.regime = regime;
	}
	public Boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getEdital() {
		return edital;
	}
	public void setEdital(String edital) {
		this.edital = edital;
	}
	public Date getDt_edital() {
		return dt_edital;
	}
	public void setDt_edital(Date dt_edital) {
		this.dt_edital = dt_edital;
	}
	public Banca getBanca() {
		return banca;
	}
	public void setBanca(Banca banca) {
		this.banca = banca;
	}
	public EStatus getStatus() {
		return estatus;
	}
	public void setStatus(EStatus estatus) {
		this.estatus = estatus;
	}
	//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((banca == null) ? 0 : banca.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dt_edital == null) ? 0 : dt_edital.hashCode());
		result = prime * result + ((dt_insc_fim == null) ? 0 : dt_insc_fim.hashCode());
		result = prime * result + ((dt_insc_ini == null) ? 0 : dt_insc_ini.hashCode());
		result = prime * result + ((dt_pg_bloq == null) ? 0 : dt_pg_bloq.hashCode());
		result = prime * result + ((edital == null) ? 0 : edital.hashCode());
		result = prime * result + ((ente == null) ? 0 : ente.hashCode());
		result = prime * result + ((formato == null) ? 0 : formato.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((regime == null) ? 0 : regime.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((tipoEsfera == null) ? 0 : tipoEsfera.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concurso other = (Concurso) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (banca == null) {
			if (other.banca != null)
				return false;
		} else if (!banca.equals(other.banca))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dt_edital == null) {
			if (other.dt_edital != null)
				return false;
		} else if (!dt_edital.equals(other.dt_edital))
			return false;
		if (dt_insc_fim == null) {
			if (other.dt_insc_fim != null)
				return false;
		} else if (!dt_insc_fim.equals(other.dt_insc_fim))
			return false;
		if (dt_insc_ini == null) {
			if (other.dt_insc_ini != null)
				return false;
		} else if (!dt_insc_ini.equals(other.dt_insc_ini))
			return false;
		if (dt_pg_bloq == null) {
			if (other.dt_pg_bloq != null)
				return false;
		} else if (!dt_pg_bloq.equals(other.dt_pg_bloq))
			return false;
		if (edital == null) {
			if (other.edital != null)
				return false;
		} else if (!edital.equals(other.edital))
			return false;
		if (ente == null) {
			if (other.ente != null)
				return false;
		} else if (!ente.equals(other.ente))
			return false;
		if (formato == null) {
			if (other.formato != null)
				return false;
		} else if (!formato.equals(other.formato))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (regime == null) {
			if (other.regime != null)
				return false;
		} else if (!regime.equals(other.regime))
			return false;
		if (estatus != other.estatus)
			return false;
		if (tipoEsfera == null) {
			if (other.tipoEsfera != null)
				return false;
		} else if (!tipoEsfera.equals(other.tipoEsfera))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
		
}


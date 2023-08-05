package com.jorgeadammo.sistemas.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jorgeadammo.sistemas.entity.Banca;
import com.jorgeadammo.sistemas.entity.EStatus;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ConcursoDto {
	
	private String titulo;
	private String ano;
	private String ente;
	private String descricao;
	private String tipoEsfera;
	private String uf;
	private String admin;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dt_insc_ini;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dt_insc_fim;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dt_pg_bloq;
	private String formato;
	private String regime;
	private boolean ativo;
	private String link;
	private String edital;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dt_edital;
	//
	// @JsonDeserialize(as = Banca.class)
	private Banca banca;
	private EStatus estatus;	
	//
	private Long id; // persistente
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date inclusion; // persistente
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date lastEdition; // persistente
	private String includedBy; // persistente
	private String editedBy; // persistente
	//
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@NotBlank(message = "Título é uma informação obrigatória.")
	@Length(min = 10, max = 255, message = "Nome deve estar entre 10 e 255 caracteres")
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@NotBlank(message = "Ano é uma informação obrigatória.")
	@Length(min = 4, max = 4, message = "Ano deve ter 4 caracteres")
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
	@Length(max = 255, message = "Nome deve ter no máx. 255 caracteres")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Length(max = 50, message = "Tipo esfera deve ter no máx. 50 caracteres")
	@NotBlank(message = "Tipo esfera é uma informação obrigatória.")
	public String getTipoEsfera() {
		return tipoEsfera;
	}
	public void setTipoEsfera(String tipoEsfera) {
		this.tipoEsfera = tipoEsfera;
	}
	@Length(min = 2, max = 2, message = "UF deve ter 2 caracteres")
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	@Length(max = 50, message = "Admin deve ter no máx. 50 caracteres")
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	@NotNull(message = "Data inscrição início é uma informação obrigatória.")
	public Date getDt_insc_ini() {
		return dt_insc_ini;
	}
	public void setDt_insc_ini(Date dt_insc_ini) {
		this.dt_insc_ini = dt_insc_ini;
	}
	@NotNull(message = "Data inscrição fim é uma informação obrigatória.")
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
	public Date getInclusion() {
		return inclusion;
	}
	public void setInclusion(Date inclusion) {
		this.inclusion = inclusion;
	}
	public Date getLastEdition() {
		return lastEdition;
	}
	public void setLastEdition(Date lastEdition) {
		this.lastEdition = lastEdition;
	}
	public String getIncludedBy() {
		return includedBy;
	}
	public void setIncludedBy(String includedBy) {
		this.includedBy = includedBy;
	}
	public String getEditedBy() {
		return editedBy;
	}
	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}

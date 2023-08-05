package com.jorgeadammo.sistemas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(schema="CNCRS", name="CCN_CARGO_CONCURSO")
public class Cargo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="CCN_ID")
	private Long id;
	
	@Column(nullable=false, length=100, unique=true, name="CCN_CARGO")
	@NotBlank(message = "Cargo é uma informação obrigatória.")
	@Size(min=7, max=50)
	private String cargoConcurso;
	
	@Column(nullable=false, length=100, name="CCN_NIVEL")
	@NotBlank(message = "Nível é uma informação obrigatória.")
	private String nivel;
	
	@Column(length=100, name="CCN_FUNCAO")
	private String funcao;
	
	@Lob
	@Column(length=5000, name="CCN_DESCRICAO_CARGO")
	private java.lang.String descricao;
	
	@Lob
	@Column(length=5000, name="CCN_REQUISITO_CARGO")
	private java.lang.String requisito;
	
	@Column(precision=7, scale=2, name="CCN_REMUNERACAO_CARGO")
	private BigDecimal remuneracao;
	
	@Column(length=255, name="CCN_DET_REMUNERACAO")
	private String detRemuneracao;
	
	@Column(length=255, name="CCN_JORNADA_CARGO")
	private String jornada;
	
	@Lob
	@Column(length=5000, name="CCN_OBSERVACAO")
	private java.lang.String observacao;
	
	@Column(precision=5, scale=2, name="CCN_VALOR_BLOQUETO")
	private BigDecimal valorBloqueto;
	
	@Column(name="CCN_VG_GERAL_TOT")
	private Integer vgGeral;
	
	@Column(name="CCN_VG_AMP_CONC")
	private Integer vgAmp;
	
	@Column(name="CCN_VG_PNE_CONC")
	private Integer vgPne;
	
	@Column(name="CCN_VG_PRT_CONC")
	private Integer vgPrt;
	
	@Column(name="CCN_VG_CAD_RESERVA")
	private Integer vgCad;
	
	@Column(name="CCN_BLOQUETO_PAGO")
	private Boolean bloquetoPg;
	
	@Column(name="CCN_CONFIRMADA_INSCRICAO")
	private Boolean confirmInsc;
	
	@Column(length=2, name="CCN_LC_PROVA_UF")
	private String provaUf;
	
	@Column(length=150, name="CCN_LC_PROVA_MUN")
	private String provaMun;
	
	@Column(length=2, name="CCN_LC_VG_UF")
	private String vgUf;
	
	@Column(length=150, name="CCN_LC_VG_MUN")
	private String vgMun;
	
	@Column(nullable=false, updatable=false, name="CCN_DATA_HR_INC")
	private Timestamp dt_hr_inc;
	
	@Column(nullable=false, name="CCN_DATA_HR_ALT")
	private Timestamp dt_hr_alt;
	
	@ManyToOne
	@JoinColumn(name="CNC_ID")
	private Concurso concurso;
	
	//
	
	@ManyToMany
	@JoinTable(name="H_CAF_CARGO_FASE", joinColumns={@JoinColumn(name="CCN_ID", 
	referencedColumnName="CCN_ID")}, inverseJoinColumns={@JoinColumn(name=
	"FAS_ID")})
	private List<Fase> fase = new ArrayList<Fase>();

	
	// Construtor
	
	public Cargo() {
	}
	
	public Cargo(String cargoConcurso, String nivel, Timestamp dt_hr_inc, Timestamp dt_hr_alt) {
		this.cargoConcurso = cargoConcurso;
		this.nivel = nivel;
		this.dt_hr_inc = dt_hr_inc;
		this.dt_hr_alt = dt_hr_alt;
	}

	public String getCargoConcurso() {
		return cargoConcurso;
	}

	public void setCargoConcurso(String cargoConcurso) {
		this.cargoConcurso = cargoConcurso;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public java.lang.String getDescricao() {
		return descricao;
	}

	public void setDescricao(java.lang.String descricao) {
		this.descricao = descricao;
	}

	public java.lang.String getRequisito() {
		return requisito;
	}

	public void setRequisito(java.lang.String requisito) {
		this.requisito = requisito;
	}

	public BigDecimal getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(BigDecimal remuneracao) {
		this.remuneracao = remuneracao;
	}

	public String getDetRemuneracao() {
		return detRemuneracao;
	}

	public void setDetRemuneracao(String detRemuneracao) {
		this.detRemuneracao = detRemuneracao;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public java.lang.String getObservacao() {
		return observacao;
	}

	public void setObservacao(java.lang.String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValorBloqueto() {
		return valorBloqueto;
	}

	public void setValorBloqueto(BigDecimal valorBloqueto) {
		this.valorBloqueto = valorBloqueto;
	}

	public Integer getVgGeral() {
		return vgGeral;
	}

	public void setVgGeral(Integer vgGeral) {
		this.vgGeral = vgGeral;
	}

	public Integer getVgAmp() {
		return vgAmp;
	}

	public void setVgAmp(Integer vgAmp) {
		this.vgAmp = vgAmp;
	}

	public Integer getVgPne() {
		return vgPne;
	}

	public void setVgPne(Integer vgPne) {
		this.vgPne = vgPne;
	}

	public Integer getVgPrt() {
		return vgPrt;
	}

	public void setVgPrt(Integer vgPrt) {
		this.vgPrt = vgPrt;
	}

	public Integer getVgCad() {
		return vgCad;
	}

	public void setVgCad(Integer vgCad) {
		this.vgCad = vgCad;
	}

	public Boolean getBloquetoPg() {
		return bloquetoPg;
	}

	public void setBloquetoPg(Boolean bloquetoPg) {
		this.bloquetoPg = bloquetoPg;
	}

	public Boolean getConfirmInsc() {
		return confirmInsc;
	}

	public void setConfirmInsc(Boolean confirmInsc) {
		this.confirmInsc = confirmInsc;
	}

	public String getProvaUf() {
		return provaUf;
	}

	public void setProvaUf(String provaUf) {
		this.provaUf = provaUf;
	}

	public String getProvaMun() {
		return provaMun;
	}

	public void setProvaMun(String provaMun) {
		this.provaMun = provaMun;
	}

	public String getVgUf() {
		return vgUf;
	}

	public void setVgUf(String vgUf) {
		this.vgUf = vgUf;
	}

	public String getVgMun() {
		return vgMun;
	}

	public void setVgMun(String vgMun) {
		this.vgMun = vgMun;
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

	public Concurso getConcurso() {
		return concurso;
	}

	public void setConcurso(Concurso concurso) {
		this.concurso = concurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bloquetoPg == null) ? 0 : bloquetoPg.hashCode());
		result = prime * result
				+ ((cargoConcurso == null) ? 0 : cargoConcurso.hashCode());
		result = prime * result
				+ ((concurso == null) ? 0 : concurso.hashCode());
		result = prime * result
				+ ((confirmInsc == null) ? 0 : confirmInsc.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((detRemuneracao == null) ? 0 : detRemuneracao.hashCode());
		result = prime * result
				+ ((dt_hr_alt == null) ? 0 : dt_hr_alt.hashCode());
		result = prime * result
				+ ((dt_hr_inc == null) ? 0 : dt_hr_inc.hashCode());
		result = prime * result + ((fase == null) ? 0 : fase.hashCode());
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jornada == null) ? 0 : jornada.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result
				+ ((provaMun == null) ? 0 : provaMun.hashCode());
		result = prime * result + ((provaUf == null) ? 0 : provaUf.hashCode());
		result = prime * result
				+ ((remuneracao == null) ? 0 : remuneracao.hashCode());
		result = prime * result
				+ ((requisito == null) ? 0 : requisito.hashCode());
		result = prime * result
				+ ((valorBloqueto == null) ? 0 : valorBloqueto.hashCode());
		result = prime * result + ((vgAmp == null) ? 0 : vgAmp.hashCode());
		result = prime * result + ((vgCad == null) ? 0 : vgCad.hashCode());
		result = prime * result + ((vgGeral == null) ? 0 : vgGeral.hashCode());
		result = prime * result + ((vgMun == null) ? 0 : vgMun.hashCode());
		result = prime * result + ((vgPne == null) ? 0 : vgPne.hashCode());
		result = prime * result + ((vgPrt == null) ? 0 : vgPrt.hashCode());
		result = prime * result + ((vgUf == null) ? 0 : vgUf.hashCode());
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
		Cargo other = (Cargo) obj;
		if (bloquetoPg == null) {
			if (other.bloquetoPg != null)
				return false;
		} else if (!bloquetoPg.equals(other.bloquetoPg))
			return false;
		if (cargoConcurso == null) {
			if (other.cargoConcurso != null)
				return false;
		} else if (!cargoConcurso.equals(other.cargoConcurso))
			return false;
		if (concurso == null) {
			if (other.concurso != null)
				return false;
		} else if (!concurso.equals(other.concurso))
			return false;
		if (confirmInsc == null) {
			if (other.confirmInsc != null)
				return false;
		} else if (!confirmInsc.equals(other.confirmInsc))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (detRemuneracao == null) {
			if (other.detRemuneracao != null)
				return false;
		} else if (!detRemuneracao.equals(other.detRemuneracao))
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
		if (fase == null) {
			if (other.fase != null)
				return false;
		} else if (!fase.equals(other.fase))
			return false;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jornada == null) {
			if (other.jornada != null)
				return false;
		} else if (!jornada.equals(other.jornada))
			return false;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (provaMun == null) {
			if (other.provaMun != null)
				return false;
		} else if (!provaMun.equals(other.provaMun))
			return false;
		if (provaUf == null) {
			if (other.provaUf != null)
				return false;
		} else if (!provaUf.equals(other.provaUf))
			return false;
		if (remuneracao == null) {
			if (other.remuneracao != null)
				return false;
		} else if (!remuneracao.equals(other.remuneracao))
			return false;
		if (requisito == null) {
			if (other.requisito != null)
				return false;
		} else if (!requisito.equals(other.requisito))
			return false;
		if (valorBloqueto == null) {
			if (other.valorBloqueto != null)
				return false;
		} else if (!valorBloqueto.equals(other.valorBloqueto))
			return false;
		if (vgAmp == null) {
			if (other.vgAmp != null)
				return false;
		} else if (!vgAmp.equals(other.vgAmp))
			return false;
		if (vgCad == null) {
			if (other.vgCad != null)
				return false;
		} else if (!vgCad.equals(other.vgCad))
			return false;
		if (vgGeral == null) {
			if (other.vgGeral != null)
				return false;
		} else if (!vgGeral.equals(other.vgGeral))
			return false;
		if (vgMun == null) {
			if (other.vgMun != null)
				return false;
		} else if (!vgMun.equals(other.vgMun))
			return false;
		if (vgPne == null) {
			if (other.vgPne != null)
				return false;
		} else if (!vgPne.equals(other.vgPne))
			return false;
		if (vgPrt == null) {
			if (other.vgPrt != null)
				return false;
		} else if (!vgPrt.equals(other.vgPrt))
			return false;
		if (vgUf == null) {
			if (other.vgUf != null)
				return false;
		} else if (!vgUf.equals(other.vgUf))
			return false;
		return true;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Fase> getFase() {
		return fase;
	}

	public void setFase(List<Fase> fase) {
		this.fase = fase;
	}
	

}


/*

CCN_ID int PRIMARY KEY NOT NULL IDENTITY,
CCN_CARGO varchar(100) NOT NULL,
CCN_NIVEL varchar(100) NOT NULL,
CCN_FUNCAO varchar(100),
CCN_DESCRICAO_CARGO clob(5000),
CCN_REQUISITO_CARGO clob(5000),
CCN_REMUNERACAO_CARGO decimal(7,2),
CCN_DET_REMUNERACAO varchar(255),  
CCN_JORNADA_CARGO varchar(255),  
CCN_OBSERVACAO clob(5000),
CCN_VALOR_BLOQUETO decimal(5,2),
CCN_VG_GERAL_TOT int,
CCN_VG_AMP_CONC int,
CCN_VG_PNE_CONC int,
CCN_VG_PRT_CONC int,
CCN_VG_CAD_RESERVA int,
CCN_BLOQUETO_PAGO int,
CCN_CONFIRMADA_INSCRICAO int,
CCN_LC_PROVA_UF varchar(2), 
CCN_LC_PROVA_MUN varchar(150), 
CCN_LC_VG_UF varchar(2), 
CCN_LC_VG_MUN varchar(150), 
CCN_DATA_HR_INC timestamp NOT NULL,
CCN_DATA_HR_ALT timestamp NOT NULL,
CNC_ID int NOT NULL,
   	FOREIGN KEY(CNC_ID) 
   	REFERENCES CONCURSOS.CNC_CONCURSO(CNC_ID)
*/

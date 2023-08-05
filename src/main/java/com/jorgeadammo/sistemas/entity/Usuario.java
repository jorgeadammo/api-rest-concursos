package com.jorgeadammo.sistemas.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="CNCRS", name="USR_USUARIO")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="USR_ID")
	private Long id;
	
	@org.hibernate.annotations.NaturalId
	@NotBlank(message = "CPF é uma informação obrigatória.")
	@Column(nullable=false, length=11, unique=true, name="USR_CPF")
	@Size(min=11, max=11)
	private String cpfLogin;
	
	@NotBlank(message = "Senha é uma informação obrigatória.")
	@Column(nullable=false, length=8, name="USR_PWD")
	@Size(min=6, max=8)
	private String pwdSenha;
	
	@Column(nullable=false, name="USR_DT_NASC")
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Data nascimento é uma informação obrigatória.")
	private Date nascimento;
	
	@Column(nullable=false, length=100, name="USR_NOME")
	@NotBlank(message = "Nome é uma informação obrigatória.")
	private String nome;
	
	@Column(length=100, name="USR_MAE_NOME")
	private String nomeMae;
	
	@Column(length=100, name="USR_PAI_NOME")
	private String nomePai;
	
	@Column(nullable=false, length=30, name="USR_IDENT_NR")
	@NotBlank(message = "Nmr identidade é uma informação obrigatória.")
	private String identNr;
	
	@Column(nullable=false, length=100, name="USR_IDENT_ORG")
	@NotBlank(message = "Org identidade é uma informação obrigatória.")
	private String identOrg;
	
	@Column(nullable=false, length=2, name="USR_IDENT_UF")
	@NotBlank(message = "UF identidade é uma informação obrigatória.")
	private String identUf;
	
	@Column(length=100, name="USR_IDENT_DT")
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date identDt;
	
	@Column(nullable=false, length=10, name="USR_SEXO")
	@NotBlank(message = "Sexo é uma informação obrigatória.")
	private String sexo;
	
	@Column(length=20, name="USR_EST_CV")
	private String estCivil;
	
	@Column(length=50, name="USR_ESCOLA")
	private String escolaridade;
	
	@Column(length=30, name="USR_TELEFONE_FX")
	private String telefoneFx;
	
	@Column(nullable=false, length=30, name="USR_TELEFONE_CEL")
	@NotBlank(message = "Celular é uma informação obrigatória.")
	private String telefoneCel;
	
	@Column(nullable=false, length=100, name="USR_EMAIL")
	@NotBlank(message = "E-mail é uma informação obrigatória.")
	private String email;
	
	@Column(nullable=false, length=8, name="USR_END_CEP")
	@NotBlank(message = "CEP é uma informação obrigatória.")
	private String endCep;
	
	@Column(nullable=false, length=2, name="USR_END_UF")
	@NotBlank(message = "UF endereço é uma informação obrigatória.")
	private String endUf;
	
	@Column(nullable=false, length=150, name="USR_END_MUN")
	@NotBlank(message = "Município é uma informação obrigatória.")
	private String endMun;
	
	@Column(nullable=false, length=150, name="USR_END_BAI")
	@NotBlank(message = "Bairro é uma informação obrigatória.")
	private String endBairro;
	
	@Column(nullable=false, length=150, name="USR_END_LOGR")
	@NotBlank(message = "Logradouro é uma informação obrigatória.")
	private String endLog;
	
	@Column(length=150, name="USR_END_COMP")
	private String endComp;
	
	@Column(nullable=false, updatable=false, name="USR_DT_HR_INC")
	private Timestamp dt_hr_inc;
	
	@Column(nullable=false, name="USR_DT_HR_ALT")
	private Timestamp dt_hr_alt;
	
	@Column(length=20, name="USR_IDIOMA")
	private String idioma;
	
	@Column(name="USR_ATV")
	private boolean ativo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpfLogin() {
		return cpfLogin;
	}
	public void setCpfLogin(String cpfLogin) {
		this.cpfLogin = cpfLogin;
	}
	public String getPwdSenha() {
		return pwdSenha;
	}
	public void setPwdSenha(String pwdSenha) {
		this.pwdSenha = pwdSenha;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getIdentNr() {
		return identNr;
	}
	public void setIdentNr(String identNr) {
		this.identNr = identNr;
	}
	public String getIdentOrg() {
		return identOrg;
	}
	public void setIdentOrg(String identOrg) {
		this.identOrg = identOrg;
	}
	public String getIdentUf() {
		return identUf;
	}
	public void setIdentUf(String identUf) {
		this.identUf = identUf;
	}
	public Date getIdentDt() {
		return identDt;
	}
	public void setIdentDt(Date identDt) {
		this.identDt = identDt;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstCivil() {
		return estCivil;
	}
	public void setEstCivil(String estCivil) {
		this.estCivil = estCivil;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getTelefoneFx() {
		return telefoneFx;
	}
	public void setTelefoneFx(String telefoneFx) {
		this.telefoneFx = telefoneFx;
	}
	public String getTelefoneCel() {
		return telefoneCel;
	}
	public void setTelefoneCel(String telefoneCel) {
		this.telefoneCel = telefoneCel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndCep() {
		return endCep;
	}
	public void setEndCep(String endCep) {
		this.endCep = endCep;
	}
	public String getEndUf() {
		return endUf;
	}
	public void setEndUf(String endUf) {
		this.endUf = endUf;
	}
	public String getEndMun() {
		return endMun;
	}
	public void setEndMun(String endMun) {
		this.endMun = endMun;
	}
	public String getEndBairro() {
		return endBairro;
	}
	public void setEndBairro(String endBairro) {
		this.endBairro = endBairro;
	}
	public String getEndLog() {
		return endLog;
	}
	public void setEndLog(String endLog) {
		this.endLog = endLog;
	}
	public String getEndComp() {
		return endComp;
	}
	public void setEndComp(String endComp) {
		this.endComp = endComp;
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
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result
				+ ((cpfLogin == null) ? 0 : cpfLogin.hashCode());
		result = prime * result
				+ ((dt_hr_alt == null) ? 0 : dt_hr_alt.hashCode());
		result = prime * result
				+ ((dt_hr_inc == null) ? 0 : dt_hr_inc.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((endBairro == null) ? 0 : endBairro.hashCode());
		result = prime * result + ((endCep == null) ? 0 : endCep.hashCode());
		result = prime * result + ((endComp == null) ? 0 : endComp.hashCode());
		result = prime * result + ((endLog == null) ? 0 : endLog.hashCode());
		result = prime * result + ((endMun == null) ? 0 : endMun.hashCode());
		result = prime * result + ((endUf == null) ? 0 : endUf.hashCode());
		result = prime * result
				+ ((escolaridade == null) ? 0 : escolaridade.hashCode());
		result = prime * result
				+ ((estCivil == null) ? 0 : estCivil.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identDt == null) ? 0 : identDt.hashCode());
		result = prime * result + ((identNr == null) ? 0 : identNr.hashCode());
		result = prime * result
				+ ((identOrg == null) ? 0 : identOrg.hashCode());
		result = prime * result + ((identUf == null) ? 0 : identUf.hashCode());
		result = prime * result + ((idioma == null) ? 0 : idioma.hashCode());
		result = prime * result
				+ ((nascimento == null) ? 0 : nascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeMae == null) ? 0 : nomeMae.hashCode());
		result = prime * result + ((nomePai == null) ? 0 : nomePai.hashCode());
		result = prime * result
				+ ((pwdSenha == null) ? 0 : pwdSenha.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result
				+ ((telefoneCel == null) ? 0 : telefoneCel.hashCode());
		result = prime * result
				+ ((telefoneFx == null) ? 0 : telefoneFx.hashCode());
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
		Usuario other = (Usuario) obj;
		if (ativo != other.ativo)
			return false;
		if (cpfLogin == null) {
			if (other.cpfLogin != null)
				return false;
		} else if (!cpfLogin.equals(other.cpfLogin))
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endBairro == null) {
			if (other.endBairro != null)
				return false;
		} else if (!endBairro.equals(other.endBairro))
			return false;
		if (endCep == null) {
			if (other.endCep != null)
				return false;
		} else if (!endCep.equals(other.endCep))
			return false;
		if (endComp == null) {
			if (other.endComp != null)
				return false;
		} else if (!endComp.equals(other.endComp))
			return false;
		if (endLog == null) {
			if (other.endLog != null)
				return false;
		} else if (!endLog.equals(other.endLog))
			return false;
		if (endMun == null) {
			if (other.endMun != null)
				return false;
		} else if (!endMun.equals(other.endMun))
			return false;
		if (endUf == null) {
			if (other.endUf != null)
				return false;
		} else if (!endUf.equals(other.endUf))
			return false;
		if (escolaridade == null) {
			if (other.escolaridade != null)
				return false;
		} else if (!escolaridade.equals(other.escolaridade))
			return false;
		if (estCivil == null) {
			if (other.estCivil != null)
				return false;
		} else if (!estCivil.equals(other.estCivil))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identDt == null) {
			if (other.identDt != null)
				return false;
		} else if (!identDt.equals(other.identDt))
			return false;
		if (identNr == null) {
			if (other.identNr != null)
				return false;
		} else if (!identNr.equals(other.identNr))
			return false;
		if (identOrg == null) {
			if (other.identOrg != null)
				return false;
		} else if (!identOrg.equals(other.identOrg))
			return false;
		if (identUf == null) {
			if (other.identUf != null)
				return false;
		} else if (!identUf.equals(other.identUf))
			return false;
		if (idioma == null) {
			if (other.idioma != null)
				return false;
		} else if (!idioma.equals(other.idioma))
			return false;
		if (nascimento == null) {
			if (other.nascimento != null)
				return false;
		} else if (!nascimento.equals(other.nascimento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeMae == null) {
			if (other.nomeMae != null)
				return false;
		} else if (!nomeMae.equals(other.nomeMae))
			return false;
		if (nomePai == null) {
			if (other.nomePai != null)
				return false;
		} else if (!nomePai.equals(other.nomePai))
			return false;
		if (pwdSenha == null) {
			if (other.pwdSenha != null)
				return false;
		} else if (!pwdSenha.equals(other.pwdSenha))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (telefoneCel == null) {
			if (other.telefoneCel != null)
				return false;
		} else if (!telefoneCel.equals(other.telefoneCel))
			return false;
		if (telefoneFx == null) {
			if (other.telefoneFx != null)
				return false;
		} else if (!telefoneFx.equals(other.telefoneFx))
			return false;
		return true;
	}

}


/*
 * 
 * CREATE TABLE CONCURSOS.USR_USUARIO
(
USR_ID int PRIMARY KEY NOT NULL IDENTITY,
USR_CPF varchar(11) NOT NULL,
USR_DT_NASC date NOT NULL,
USR_NOME varchar(100) NOT NULL,
USR_MAE_NOME varchar(100),
USR_PAI_NOME varchar(100),
USR_IDENT_NR varchar(30) NOT NULL,
USR_IDENT_ORG varchar(100) NOT NULL,
USR_IDENT_UF varchar(2) NOT NULL,
USR_IDENT_DT date NOT NULL,
USR_SEXO varchar(10) NOT NULL,
USR_EST_CV varchar(20),
USR_ESCOLA varchar(50),
USR_TELEFONE_FX varchar(30),
USR_TELEFONE_CEL varchar(30) NOT NULL,
USR_EMAIL varchar(100) NOT NULL,
USR_END_CEP varchar(8) NOT NULL,
USR_END_UF varchar(2) NOT NULL,
USR_END_MUN varchar(150) NOT NULL,
USR_END_BAI varchar(150) NOT NULL,
USR_END_LOGR varchar(150) NOT NULL,
USR_END_COMP varchar(150), 
USR_PWD varchar(8) NOT NULL,
USR_DT_HR_INC timestamp NOT NULL,
USR_DT_HR_ALT timestamp NOT NULL,
);commit;
--
CREATE UNIQUE INDEX PK_USR ON CONCURSOS.USR_USUARIO(USR_ID); -- N�o pode repetir o id
CREATE UNIQUE INDEX U_USR_CPF ON CONCURSOS.USR_USUARIO(USR_CPF); -- N�o pode repetir o cpf
 * 
 */


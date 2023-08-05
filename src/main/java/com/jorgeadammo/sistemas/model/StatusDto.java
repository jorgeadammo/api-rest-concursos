package com.jorgeadammo.sistemas.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

public class StatusDto {
	
	@Id
	@GeneratedValue
	@Column(name="STA_ID")
	private Long id;
	
	@NotBlank(message = "Status é uma informação obrigatória.")
	@Column(length=100, nullable=false, unique=true, name="STA_STATUS")
	private String concursoStatus;
	
	@Column(length=255, name="STA_DESC")
	private String descricao;
	
	@Column(nullable=false, updatable=false, name="STA_DT_HR_INC")
	private Timestamp dt_hr_inc;
	
	@Column(nullable=false, name="STA_DT_HR_ALT")
	private Timestamp dt_hr_alt;

}

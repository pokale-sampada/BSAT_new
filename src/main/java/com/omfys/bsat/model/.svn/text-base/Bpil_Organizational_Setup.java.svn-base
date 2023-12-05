package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_ORG_CONFIG_STP")
public class Bpil_Organizational_Setup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_ORG_CONFIG_STP_SEQ", allocationSize = 1)
	
	@Column(name ="ORG_ID")
	private int org_id;
	
	@Column(name = "TIN_NUMBER")
	private int tin_number;
	
	@Column(name = "ENTITY_NAME")
	private String entity_name;
	
	@Column(name = "LOGO")
	private byte[] logo;
	
	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date;

	@Column(name = "LAST_UPDATED_BY", updatable = true)
	private int last_updated_by;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());
}

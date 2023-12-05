package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_LOOKUP_VALUES")

public class Bpil_LookupValues 
{
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
//	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_LOOKUP_VALUES_SEQ", allocationSize = 1)
	
	@Column(name = "LOOKUP_CODE")
	private String lookup_code;
	
	@Column(name = "MEANING")
	private String meaning;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "LOOKUP_TYPE")
	private String lookup_type;

	@Column(name = "ACTIVE_START_DATE")
	private Date active_start_date;

	@Column(name = "ACTIVE_END_DATE")
	private Date active_end_date;

	@Column(name = "ENABLED_FLAG")
	private String enabled_flag;

	@Column(name = "CREATED_BY")
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE")
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_UPDATE_DATE")
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());

}


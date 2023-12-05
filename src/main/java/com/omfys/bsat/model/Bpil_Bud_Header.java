package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_BUD_HEADER")
public class Bpil_Bud_Header {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@Column(name = "BUD_HID")
	private int bud_hid;
	
	@Column(name = "BUD_TYPE")
	private String bud_type;
	
	@Column(name = "BUD_STATUS")
	private String bud_status;
	
	@Column(name = "BUD_TOTAMT")
	private float bud_totamt;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "UPDATION_DATE" , updatable = false)
	private Date updation_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "CREATED_BY")
	private int created_by;
	
	@Column(name = "UPDATED_BY")
	private int updated_by;
	
	@Column(name = "APPROVED_BY")
	private int approved_by;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "APPROVED_DATE" , updatable = false)
	private Date approved_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "BUD_YEAR")
	private int bud_year;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "BUD_SDATE" , updatable = false)
	private Date bud_sdate;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "BUD_EDATE" , updatable = false)
	private Date bud_edate;
	
	@Column(name = "APPROVAL_STATUS")
	private String approval_status;
	
	@Column(name = "REMITT_AMT")
	private float remitt_amt;
	
	@Column(name = "COMMENTS")
	private String comments;
}

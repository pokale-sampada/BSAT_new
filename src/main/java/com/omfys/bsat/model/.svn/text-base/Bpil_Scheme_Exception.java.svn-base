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
@Table(name = "BPIL_SCHEME_EXCEPTION")
public class Bpil_Scheme_Exception {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_SCHEME_EXCEPTION_S", allocationSize = 1) 
	@Column(name = "EXCP_ID")
	private int excp_id;

	@Column(name = "SCHEME_ID")
	private int scheme_id;

	@Column(name = "EXCEPTION")
	private String exception;
	
	@Column(name = "SCHEME_CODE")
	private String scheme_code;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());

	public Bpil_Scheme_Exception(int excp_id, int scheme_id, String exception, Date creation_date) {
		super();
		this.excp_id = excp_id;
		this.scheme_id = scheme_id;
		this.exception = exception;
		this.creation_date = creation_date;
	}

	@Override
	public String toString() {
		return "Bpil_Reward_Exception [excp_id=" + excp_id + ", scheme_id=" + scheme_id + ", exception=" + exception
				+ ", creation_date=" + creation_date + "]";
	}

	public Bpil_Scheme_Exception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getScheme_code() {
		return scheme_code;
	}

	public void setScheme_code(String scheme_code) {
		this.scheme_code = scheme_code;
	}
	
	

}

package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_DEPOT_MASTER")
public class Bpil_Depot_Master {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(name="course_seq", sequenceName="BPIL_DEPOT_MASTER_SEQ", allocationSize=1)
	
	@Column(name = "ORCL_ORGN_ID")
	private int depot_id;
	
	@Column(name = "DEPOT_CODE")
	private String depot_code;
	
	@Column(name = "REGN")
	private String regn;
	
	@Column(name = "DEPOT_NAME")
	private String depot_name;

	@Column(name = "ADDRESS_LINE1")
	private String address_line1;
	
	@Column(name = "ADDRESS_LINE2")
	private String address_line2;
	
	@Column(name = "ADDRESS_LINE3")
	private String address_line3;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "PIN_CODE")
	private String pin_code;
	
	@Column(name = "EMAIL_ADDRESS")
	private String email_address;
	
	@Column(name = "DSR_REGN")
	private String dsr_regn;

	@Column(name = "CREATED_BY")
	private int created_by;
	
	@Column(name = "CREATION_DATE")
	private Date creation_date;
	
	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;
	
	@Column(name = "LAST_UPDATE_DATE")
	private Date last_update_date;

}

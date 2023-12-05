package com.omfys.bsat.model;

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
@Table(name = "BPIL_SCHEME_CUST_TYPES")
public class Bpil_Scheme_Cust_Types {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_SCHEME_CUST_TYPES_S", allocationSize = 1)
	
	@Column(name = "SCHEME_CUST_TYPE_ID")
	private int scheme_cust_type_id;
		
	@Column(name = "SCHEME_ID")
	private int scheme_id;
	
		
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CUST_TYPE")
	private String cust_type;

}

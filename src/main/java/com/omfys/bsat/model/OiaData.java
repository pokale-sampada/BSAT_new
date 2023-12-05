package com.omfys.bsat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "OIADATA")
public class OiaData implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_USERS_LOGIN_S", allocationSize = 1) 
	@Column(name = "ID")
	private int id;


	@Column(name = "SCHEME_CODE")
	private String scheme_code;
	
	@Column(name = "OPA_URL")
	private String opa_url;

	

	
	
	

}

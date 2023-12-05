package com.omfys.bsat.model;

import java.io.Serializable;
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
@Table(name = "BPIL_USERS")
public class Bpil_Users_Autofill implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_USERS_SEQ", allocationSize = 1)
	@Column(name = "USER_ID" , updatable = false)
	private int user_id;
	
	@Column(name = "PROFILE_ID" , updatable = false)
	private int profile_id;

	@Column(name = "USER_NAME" , updatable = false)
	private String user_name;	
	
	@Column(name = "ATTRIBUTE1", updatable = false)
	private String source;	

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USER_TYPE", updatable = false)
	private String user_type;
	
	@Column(name = "FIRST_NAME", updatable = false)
	private String first_name;
	
	@Column(name = "MIDDLE_NAME", updatable = false)
	private String middle_name;

	@Column(name = "LAST_NAME", updatable = false)
	private String last_name;

	@Column(name = "CONTACT_NUMBER", updatable = false)
	private String contact_number;
	
	@Column(name = "EMAIL_ADDRESS", updatable = false)
	private String email_address;

	@Column(name = "START_DATE", updatable = false)
	private Date start_date;
	
	@Column(name = "END_DATE", updatable = false)
	private Date end_date;

	@Column(name = "IS_ACTIVE", updatable = false)
	private String is_active;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_LOGIN", updatable = false)
	private Date last_login= new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_UPDATE_DATE")
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "ATTRIBUTE2")
	private Date attribute2= new java.sql.Date(new java.util.Date().getTime());

}

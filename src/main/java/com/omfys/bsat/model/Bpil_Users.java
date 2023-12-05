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
public class Bpil_Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_USERS_S", allocationSize = 1) //change by pramila size 10 to 1

	@Column(name = "USER_ID")
	private int user_id;
	
	@Column(name = "PROFILE_ID")
	private int profile_id;

	@Column(name = "SUPERVISOR_ID")
	private int supervisor_id;	
	
	@Column(name = "USER_NAME")
	private String user_name;	
	
	@Column(name = "ATTRIBUTE1")
	private String source;	

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USER_TYPE")
	private String user_type;
	
	@Column(name = "REGION_CODE")
	private String region_code;
	
	@Column(name = "DEPOT_CODE")
	private String depot_code;
	
	@Column(name = "PMG_ML_GROUP")
	private String pmg_ml_group;
	
	@Column(name = "MENU_GROUP_ID")
	private int menu_group_id;
	
	@Column(name = "FIRST_NAME")
	private String first_name;
	
	@Column(name = "MIDDLE_NAME")
	private String middle_name;

	@Column(name = "LAST_NAME")
	private String last_name;

	@Column(name = "CONTACT_NUMBER")
	private String contact_number;
	
	@Column(name = "EMAIL_ADDRESS")
	private String email_address;

	@Column(name = "START_DATE")
	private Date start_date;
	
	@Column(name = "END_DATE")
	private Date end_date;

	@Column(name = "IS_ACTIVE")
	private String is_active;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_LOGIN")
	private Date last_login= new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "CREATED_BY")
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_UPDATE_DATE" , updatable = true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "ATTRIBUTE2")
	private Date attribute2= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "ACTIVE_DIRECTORY_ID")
	private String active_directory_id;
	
	@Column(name = "TERR_CODE")
	private String terr_code;
	
	
	

	@Override
	public String toString() {
		return "Bpil_Users [user_id=" + user_id + ", user_name=" + user_name + ", active_directoty_id="
				+ active_directory_id + "]";
	}

	public Bpil_Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bpil_Users(int user_id, int profile_id, int supervisor_id, String user_name, String source, String password,
			String user_type, String region_code, String depot_code, String pmg_ml_group, int menu_group_id,
			String first_name, String middle_name, String last_name, String contact_number, String email_address,
			Date start_date, Date end_date, String is_active, Date last_login, int created_by, Date creation_date,
			int last_updated_by, Date last_update_date, Date attribute2, String active_directory_id, String terr_code) {
		super();
		this.user_id = user_id;
		this.profile_id = profile_id;
		this.supervisor_id = supervisor_id;
		this.user_name = user_name;
		this.source = source;
		this.password = password;
		this.user_type = user_type;
		this.region_code = region_code;
		this.depot_code = depot_code;
		this.pmg_ml_group = pmg_ml_group;
		this.menu_group_id = menu_group_id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.contact_number = contact_number;
		this.email_address = email_address;
		this.start_date = start_date;
		this.end_date = end_date;
		this.is_active = is_active;
		this.last_login = last_login;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
		this.attribute2 = attribute2;
		this.active_directory_id = active_directory_id;
		this.terr_code = terr_code;
	}
	
	

	
}

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
@Table(name = "SYSADMIN_USERS")
public class SysAdmin_Users implements Serializable {

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
private String menu_group_id;

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

}
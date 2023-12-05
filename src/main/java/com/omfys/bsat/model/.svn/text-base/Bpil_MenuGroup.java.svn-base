package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_MENU_GROUP")
public class Bpil_MenuGroup{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_MENU_GROUP_S", allocationSize = 1)
	
	@Column(name = "MENU_GROUP_ID")
	private int menu_group_id;
	
	@Column(name = "USER_ACC_ID")
	public int user_acc_id;	
	
	@Column(name = "GROUP_NAME")
	private String group_name;
	
	@Column(name = "GROUP_DESCRIPTION")
	private String group_description;

	@Column(name = "ACTIVE")
	private String active;

	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	@Column(name = "GROUP_START_DATE")
	private Date group_start_date;
	
	@Transient
	private String group_start_date1;
	
	@Transient
	private String group_end_date1;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	@Column(name = "GROUP_END_DATE")
	private Date group_end_date;

	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_UPDATE_DATE" , updatable = true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
}

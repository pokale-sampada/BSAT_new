package com.omfys.bsat.model;
import javax.persistence.Transient;
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
@Table(name = "BPIL_MENU_HEADER")

public class Bpil_Menu_Header implements Serializable
{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_MENU_HEADER_S", allocationSize = 1)
	
	@Column(name = "MENU_HEADER_ID")
	private int menu_header_id;
	
	@Column(name = "MENU_GROUP_ID")
	private int menu_group_id;
	
	@Column(name = "USER_ACC_ID")
	public int user_acc_id;	
	
	@Column(name = "HEADER_NAME")
	private String header_name;
	
	@Column(name = "HEADER_ICON")	
	private String header_icon;
	
	@Column(name = "HEADER_ACTIVE")	
	private String header_active;
	
	@Column(name = "ACTION_NAME")	
	private String action_name;
	
	@Column(name = "ORDER_ID")
	public int order_id;	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	@Column(name = "HEADER_START_DATE")
	public Date header_start_date;	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	@Column(name = "HEADER_END_DATE")
	public Date header_end_date;
	
	@Transient
	public String header_start_date1;	

	@Transient
	public String header_end_date1;	
	
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


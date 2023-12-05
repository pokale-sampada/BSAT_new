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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_SUBMENU_LINES")
public class Bpil_SubMenu_Line implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_SUBMENU_LINES_S", allocationSize = 1)
	
	@Column(name = "SUBMENU_LINE_ID")
	private int submenu_line_id;
	
	@Column(name = "MENU_LINE_ID")
	private int menu_line_id;

	@Column(name = "USER_ACC_ID")
	public int user_acc_id;		
		
	@Column(name = "SUBMENULINE_NAME")
	private String submenuline_name;
	
	@Transient
	private String function_action_name;
	
	@Transient
	private String ATTRIBUTE1;

	@Column(name = "CREATED_BY")
	public int created_by;	
	
	@Column(name = "LAST_UPDATED_BY")
	public int last_updated_by;	
	
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE")
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_UPDATE_DATE")
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "LINE_ICON")
	private String line_icon;
	
	@Column(name = "ACTIVE")
	private String subline_active;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LINE_START_DATE")
	private Date subline_start_date= new java.sql.Date(new java.util.Date().getTime());
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LINE_END_DATE")
	private Date subline_end_date= new java.sql.Date(new java.util.Date().getTime());	
	
	@Column(name = "ORDER_ID")
	public int order_id;	
	
	@Column(name = "MENU_SUB_LINE_ID")
	private int menu_sub_line_id;

	@Column(name = "ACTION_NAME")
	private String subMenu_action_name;

}

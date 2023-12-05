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
@Table(name = "BPIL_MENU_FUNC_REG")
public class Bpil_Menu_FunRegi {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_MENU_FUNC_REG_S", allocationSize = 1)

	@Column(name = "MENU_FUNCTION_ID")
	private int menu_function_id;
	
	@Column(name = "MENU_LINE_ID")
	private int menu_line_id;
	
	@Column(name = "USER_ACC_ID")
	public int user_acc_id;	
		
	@Column(name = "FUNCTION_NAME")
	private String function_name;
	
	@Column(name = "FUNCTION_CTRLR_NAME")
	private String function_ctrlr_name;
	
	@Column(name = "FUNCTION_ACTION_NAME")
	private String function_action_name;
	
	@Column(name = "FUN_START_DATE")
	private Date fun_start_date;
	
	@Column(name = "FUN_END_DATE")
	private Date fun_end_date;
	
	@Column(name = "ACTIVE")
	private String active;

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

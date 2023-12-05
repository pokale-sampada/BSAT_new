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
@Table(name = "BPIL_REPORT_FUNC_REG")
public class Bpil_Report_FunRegi {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_REPORT_FUNC_REG_S", allocationSize = 1)
	
	@Column(name = "REPORT_FUNCTION_ID")
	private int report_function_id;
	
	@Column(name = "REPORT_LINE_ID")
	private int report_line_id;
	
	@Column(name = "USER_ACC_ID")
	public int user_acc_id;	
		
	@Column(name = "REP_FUNCTION_NAME")
	private String rep_function_name;
	
	@Column(name = "REP_FUNCTION_CTRLR_NAME")
	private String rep_function_ctrlr_name;
	
	@Column(name = "REP_FUNCTION_ACTION_NAME")
	private String rep_function_action_name;
	
	@Column(name = "REP_START_DATE")
	private Date rep_start_date;
	
	@Column(name = "REP_END_DATE")
	private Date rep_end_date;
	
	@Column(name = "ACTIVE")
	private String active;

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
	
	@Transient
	String line_name;
	
}

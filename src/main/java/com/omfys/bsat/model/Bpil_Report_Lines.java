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
@Table(name = "BPIL_REPORT_LINES")
public class Bpil_Report_Lines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_REPORT_LINES_S", allocationSize = 1)

	@Column(name = "REPORT_LINE_ID")
	private int report_line_id;
	
	@Column(name = "REPORT_HEADER_ID")
	private int report_header_id;

	@Column(name = "USER_ACC_ID")
	public int user_acc_id;		
		
	@Column(name = "LINE_NAME")
	private String line_name;

	@Column(name = "LINE_ICON")
	private String line_icon;
	
	@Column(name = "ACTIVE")
	private String active1;

	@Column(name = "LINE_START_DATE")
	private Date line_start_date;
	
	@Column(name = "LINE_END_DATE")
	private Date line_end_date;	
	
	@Column(name = "ORDER_ID")
	public int order_id;	
	
	@Column(name = "REPORT_SUB_LINE_ID")
	private int report_sub_line_id;
	
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
	
}

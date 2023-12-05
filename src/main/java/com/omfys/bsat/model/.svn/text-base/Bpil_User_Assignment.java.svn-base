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
@Table(name = "BPIL_USER_ASSIGNMENTS")
public class Bpil_User_Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_USER_ASSIGNMENTS_S", allocationSize = 1)
	
	
	@Column(name = "USER_ASSIGNMENT_ID")
	private int user_assignment_id;
	
	@Column(name = "USER_ID")
	private int user_id;
	
	@Column(name = "MENU_GROUP_ID")
	private int menu_group_id;
	
	@Column(name = "REPORT_GROUP_ID")
	private int report_group_id;
	
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

	@Column(name = "ATTRIBUTE1")
	private String attribute1;
				
}

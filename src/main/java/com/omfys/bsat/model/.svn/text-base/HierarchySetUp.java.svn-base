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
@Table(name = "BPIL_APRL_HIERARCHY")

public class HierarchySetUp 
{
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_APRL_HIERARCHY_SEQ", allocationSize = 1)
	@Column(name = "WF_HIERARCHY_ID")
	private int wf_hierarchy_id;
	@Column(name = "USER_ID")

	private int user_id;	
	@Column(name = "APPROVER_LEVEL")

	private String approver_level;
	@Column(name = "APR_ORDER")
	private int apr_order;
	@Column(name = "TO_VALUE")

	private int to_value;
	@Column(name = "CREATED_BY")

	private int created_by;
	@Column(name = "CREATION_DATE")


	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());
	@Column(name = "LAST_UPDATED_BY")

	private int last_updated_by;
	@Column(name = "LAST_UPDATE_DATE")

	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	@Column(name = "ATTRIBUTE1")

	private String attribute1;
	@Column(name = "ATTRIBUTE2")

	private String attribute2;
	@Column(name = "ATTRIBUTE3")	
	private String attribute3;
	
//	private String user_name;
//
//
//	public String getUser_name() {
//		return user_name;
//	}
//	public void setUser_name(String user_name) {
//		this.user_name = user_name;
//	}
	
}


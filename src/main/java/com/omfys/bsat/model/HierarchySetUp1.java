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
public class HierarchySetUp1 
{
	
	private int wf_hierarchy_id;

	private int user_id;	

	private String approver_level;
	private int apr_order;

	private int to_value;

	private int created_by;

	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());

	private int last_updated_by;

	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());

	private String attribute1;

	private String attribute2;
	private String attribute3;
	
	private String user_name;
	
}


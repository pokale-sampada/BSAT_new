package com.omfys.bsat.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TEST_TABLE")
public class Test_Table {
	
	@Id
	private String emp_id;	
	private String emp_first_name;
	private String emp_last_name;	
	private String email;
	private String emp_code;
	private String creation_date;
	private String basic_salary;
	private String gross_salary;
	private String ctc;
	private String companyname;
	private String createdby;
	private String creationdate;
	private String status;
	private String poamount;
	private String potentialopp;
	
}

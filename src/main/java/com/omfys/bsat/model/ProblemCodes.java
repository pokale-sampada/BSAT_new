/*package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "KOEL_PROBLEM_CODES")

public class ProblemCodes 
{

	@Id
	@Column(name = "PROBLEM_CODE")
	String problem_code;
	
	@Column(name = "PROBLEM_DESC")
	String problem_desc;

	@Column(name = "CREATED_BY",updatable=false)
	private int created_by;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE", updatable=false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_UPDATE_DATE")
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "ATTRIBUTE1")
	private String attribute1;
	
	@Column(name = "ATTRIBUTE2")
	private String attribute2;
	
	@Column(name = "ATTRIBUTE3")
	private String attribute3;
	
	@Column(name = "ATTRIBUTE4")
	private String attribute4;
	
	public ProblemCodes()
	{
		
	}

	public ProblemCodes(String id, String tagName) {
		this.problem_code = id;
		this.problem_desc = tagName;
	}
	
	
	
	public String getProblem_code() {
		return problem_code;
	}
	public void setProblem_code(String problem_code) {
		this.problem_code = problem_code;
	}
	public String getProblem_desc() {
		return problem_desc;
	}
	public void setProblem_desc(String problem_desc) {
		this.problem_desc = problem_desc;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public int getLast_updated_by() {
		return last_updated_by;
	}
	public void setLast_updated_by(int last_updated_by) {
		this.last_updated_by = last_updated_by;
	}
	public Date getLast_update_date() {
		return last_update_date;
	}
	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}
	public String getAttribute1() {
		return attribute1;
	}
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	public String getAttribute2() {
		return attribute2;
	}
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	public String getAttribute3() {
		return attribute3;
	}
	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}
	public String getAttribute4() {
		return attribute4;
	}
	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	
		
}

*/
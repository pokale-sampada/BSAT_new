/*package com.springmvc.model;

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
@Table(name = "KOEL_RESOLUTION_CODES")

public class ResolutionCodes 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "KOEL_RSL_CODE_S", allocationSize = 1)
	
	@Column(name = "RESOLUTION_CODE_ID")
	private int resolution_code_id ;
	
	@Column(name = "RESOLUTION_CODE")
	private String resolution_code;
	
	@Column(name = "RESOLUTION_DESC")
	private String resolution_desc;
	
	@Column(name = "MTTR_CLASSIFICATION")
	private String mttr_classification;
	
	@Column(name = "TYPE_OF_DEFECT")
	private String type_of_defect;
	
	@Column(name = "PROBLEM_CODE")
	private String problem_code;
	
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
	
	@Column(name = "ATTRIBUTE5")
	private String attribute5;
	
	
	public int getResolution_code_id() {
		return resolution_code_id;
	}
	public void setResolution_code_id(int resolution_code_id) {
		this.resolution_code_id = resolution_code_id;
	}
	public String getResolution_code() {
		return resolution_code;
	}
	public void setResolution_code(String resolution_code) {
		this.resolution_code = resolution_code;
	}
	public String getResolution_desc() {
		return resolution_desc;
	}
	public void setResolution_desc(String resolution_desc) {
		this.resolution_desc = resolution_desc;
	}
	public String getMttr_classification() {
		return mttr_classification;
	}
	public void setMttr_classification(String mttr_classification) {
		this.mttr_classification = mttr_classification;
	}
	public String getType_of_defect() {
		return type_of_defect;
	}
	public void setType_of_defect(String type_of_defect) {
		this.type_of_defect = type_of_defect;
	}
	public String getProblem_code() {
		return problem_code;
	}
	public void setProblem_code(String problem_code) {
		this.problem_code = problem_code;
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
	public String getAttribute5() {
		return attribute5;
	}
	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}
	
	
		
}

*/
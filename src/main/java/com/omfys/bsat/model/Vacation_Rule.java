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

@Entity
@Table(name="KOEL_WF_VACATION_RULE")
public class Vacation_Rule {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "KOEL_WF_VACATION_S", allocationSize = 1)
	
	@Column(name = "VACATION_RULE_ID")
	private int vacation_rule_id;
	
	@Column(name = "FROM_USER_ID")
	private int from_user_id;
	
	@Column(name = "TO_USER_NAME")
	private String to_user_name;
	
	@Column(name = "TO_USER_ID")
	private int to_user_id;
	
	@Column(name = "FROM_DATE")
	private Date from_date;
	
	@Column(name = "TO_DATE")
	private Date to_date;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "RULE_TYPE")
	private String rule_type;
	
	@Column(name = "CREATED_BY")
	private int created_by;
	
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "ATTRIBUTE1")
	private String attribute1;
	
	@Column(name = "ATTRIBUTE2")
	private String attribute2;
	
	@Column(name = "ATTRIBUTE3")
	private String attribute3;

	public Vacation_Rule(int data, String data1) {
		this.to_user_id = data;
		this.to_user_name = data1;
	}
	
	public Vacation_Rule() {}
	
	public int getVacation_rule_id() {
		return vacation_rule_id;
	}

	public void setVacation_rule_id(int vacation_rule_id) {
		this.vacation_rule_id = vacation_rule_id;
	}

	public int getFrom_user_id() {
		return from_user_id;
	}

	public void setFrom_user_id(int from_user_id) {
		this.from_user_id = from_user_id;
	}

	public int getTo_user_id() {
		return to_user_id;
	}

	public void setTo_user_id(int to_user_id) {
		this.to_user_id = to_user_id;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRule_type() {
		return rule_type;
	}

	public void setRule_type(String rule_type) {
		this.rule_type = rule_type;
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

	public String getTo_user_name() {
		return to_user_name;
	}

	public void setTo_user_name(String to_user_name) {
		this.to_user_name = to_user_name;
	}

	
}

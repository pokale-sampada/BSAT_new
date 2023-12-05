package com.omfys.bsat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_TERR_MASTER")
public class Bpil_Terr_Master implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ORCL_TERR_ID")
	private Integer orcl_terr_id;

	@Column(name = "REGN")
	private String regn;

	@Column(name = "DEPOT_CODE")
	private String depot_code;

	@Column(name = "TERR_CODE")
	private String terr_code;

	@Column(name = "TERR_NAME")
	private String terr_name;

	@Column(name = "EMP_CODE")
	private String emp_code;

	@Column(name = "GRADE")
	private String grade;

	@Column(name = "FUNC")
	private String func;

	@Column(name = "SUB_FUNC")
	private String sub_func;

	@Column(name = "CREATED_BY")
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date = new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());

	public Integer getOrcl_terr_id() {
		return orcl_terr_id;
	}

	public void setOrcl_terr_id(Integer orcl_terr_id) {
		this.orcl_terr_id = orcl_terr_id;
	}

	public String getRegn() {
		return regn;
	}

	public void setRegn(String regn) {
		this.regn = regn;
	}

	public String getDepot_code() {
		return depot_code;
	}

	public void setDepot_code(String depot_code) {
		this.depot_code = depot_code;
	}

	public String getTerr_code() {
		return terr_code;
	}

	public void setTerr_code(String terr_code) {
		this.terr_code = terr_code;
	}

	public String getTerr_name() {
		return terr_name;
	}

	public void setTerr_name(String terr_name) {
		this.terr_name = terr_name;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

	public String getSub_func() {
		return sub_func;
	}

	public void setSub_func(String sub_func) {
		this.sub_func = sub_func;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Bpil_Terr_Master [orcl_terr_id=" + orcl_terr_id + ", regn=" + regn + ", depot_code=" + depot_code
				+ ", terr_code=" + terr_code + ", terr_name=" + terr_name + ", emp_code=" + emp_code + ", grade="
				+ grade + ", func=" + func + ", sub_func=" + sub_func + ", created_by=" + created_by
				+ ", creation_date=" + creation_date + ", last_updated_by=" + last_updated_by + ", last_update_date="
				+ last_update_date + "]";
	}

	public Bpil_Terr_Master(Integer orcl_terr_id, String regn, String depot_code, String terr_code, String terr_name,
			String emp_code, String grade, String func, String sub_func, int created_by, Date creation_date,
			int last_updated_by, Date last_update_date) {
		super();
		this.orcl_terr_id = orcl_terr_id;
		this.regn = regn;
		this.depot_code = depot_code;
		this.terr_code = terr_code;
		this.terr_name = terr_name;
		this.emp_code = emp_code;
		this.grade = grade;
		this.func = func;
		this.sub_func = sub_func;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
	}

	public Bpil_Terr_Master() {
		super();
		// TODO Auto-generated constructor stub
	}

}

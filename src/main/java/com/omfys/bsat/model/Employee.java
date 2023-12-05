package com.omfys.bsat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	private int ID;
	private String EMP_ID;
	private String CREATED_BY;
	private String EMAIL;
	private String EMP_CODE;
	private String NAME;
	private String DESCRIPTION;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getEMP_ID() {
		return EMP_ID;
	}
	public void setEMP_ID(String eMP_ID) {
		EMP_ID = eMP_ID;
	}
	public String getCREATED_BY() {
		return CREATED_BY;
	}
	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getEMP_CODE() {
		return EMP_CODE;
	}
	public void setEMP_CODE(String eMP_CODE) {
		EMP_CODE = eMP_CODE;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", EMP_ID=" + EMP_ID + ", CREATED_BY=" + CREATED_BY + ", EMAIL=" + EMAIL
				+ ", EMP_CODE=" + EMP_CODE + ", NAME=" + NAME + ", DESCRIPTION=" + DESCRIPTION + "]";
	}
	
	
	
	

}

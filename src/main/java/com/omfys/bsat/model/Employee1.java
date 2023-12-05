package com.omfys.bsat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Employee")
public class Employee1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private String NAME;
	private String CITY;
	
	public Employee1() {
		super();
		
	}
	public Employee1(int id, String name, String city) {
		super();
		this.ID = id;
		this.NAME = name;
		this.CITY = city;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	
	
	
}

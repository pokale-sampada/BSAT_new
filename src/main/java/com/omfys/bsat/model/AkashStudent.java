package com.omfys.bsat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AKASHSTUDENT")
public class AkashStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AID;
	private String NAME;
	private String ADDRESS;
	private String CITY;
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	
	
	public AkashStudent(int aID, String nAME, String aDDRESS, String cITY) {
		super();
		AID = aID;
		NAME = nAME;
		ADDRESS = aDDRESS;
		CITY = cITY;
	}
	public int getAID() {
		return AID;
	}
	public void setAID(int aID) {
		AID = aID;
	}
	public AkashStudent() {
		super();
	}
	

}

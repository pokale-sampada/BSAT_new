package com.omfys.bsat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AKASHREGISTER")
public class AkashRegister {

	@Id
	private int ID;
	private String NAME;
	private String ADDRESS;
	private String MOBILE;
	private String CITY;
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
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getMOBILE() {
		return MOBILE;
	}
	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public AkashRegister(int iD, String nAME, String aDDRESS, String mOBILE, String cITY) {
		super();
		ID = iD;
		NAME = nAME;
		ADDRESS = aDDRESS;
		MOBILE = mOBILE;
		CITY = cITY;
	}
	public AkashRegister() {
		super();
	}
	
}

package com.omfys.bsat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EmpFile")
public class EmpFile {
	
	
//	 @ManyToOne
//	 @JoinColumn(name = "ID")
//	 private Employee employee;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int ID;
	private byte[] FILEATTACH;
	private long FSIZE;
	private String FTYPE;
	
	public EmpFile() {
		super();
		
	}
	public EmpFile(int iD, byte[] fILEATTACH, long fSIZE, String fTYPE) {
		super();
		
		ID = iD;
		FILEATTACH = fILEATTACH;
		FSIZE = fSIZE;
		FTYPE = fTYPE;
	}

	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public byte[] getFILEATTACH() {
		return FILEATTACH;
	}

	public void setFILEATTACH(byte[] fILEATTACH) {
		FILEATTACH = fILEATTACH;
	}

	public long getFSIZE() {
		return FSIZE;
	}

	public void setFSIZE(long fSIZE) {
		FSIZE = fSIZE;
	}

	public String getFTYPE() {
		return FTYPE;
	}

	public void setFTYPE(String fTYPE) {
		FTYPE = fTYPE;
	}
	
	

}

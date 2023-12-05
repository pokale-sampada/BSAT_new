package com.omfys.bsat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FILEUPLOAD")
public class FileUpload {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int FID;
	private String FNAME;
	private int ID;
	private byte[] FILEATTACH;
	private long FSIZE;
	private String FTYPE;
	public String getFNAME() {
		return FNAME;
	}
	public void setFNAME(String fNAME) {
		FNAME = fNAME;
	}
	public int getFID() {
		return FID;
	}
	public void setFID(int fID) {
		FID = fID;
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
	public FileUpload(String fNAME, int fID, int iD, byte[] fILEATTACH, long fSIZE, String fTYPE) {
		super();
		FNAME = fNAME;
		FID = fID;
		ID = iD;
		FILEATTACH = fILEATTACH;
		FSIZE = fSIZE;
		FTYPE = fTYPE;
	}
	public FileUpload() {
		super();
	}
	
	
	
}

package com.omfys.bsat.model;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table(name = "BPIL_MENU")
public class BPIL_MENU {
	@Id
	private int USER_ID;
	private String MENU_HEADER_ID;
	private String SUBMENU;
	public BPIL_MENU() {
		super();
	}
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getMENU_HEADER_ID() {
		return MENU_HEADER_ID;
	}
	public void setMENU_HEADER_ID(String mENU_HEADER_ID) {
		MENU_HEADER_ID = mENU_HEADER_ID;
	}

	@Override
	public String toString() {
		return "BPIL_MENU [USER_ID=" + USER_ID + ", MENU_HEADER_ID=" + MENU_HEADER_ID + ", SUBMENU=" + SUBMENU + "]";
	}
	public String getSUBMENU() {
		return SUBMENU;
	}
	public void setSUBMENU(String sUBMENU) {
		SUBMENU = sUBMENU;
	}

	
}

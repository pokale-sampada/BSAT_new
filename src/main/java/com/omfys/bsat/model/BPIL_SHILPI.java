package com.omfys.bsat.model;

public class BPIL_SHILPI {
	private int MENU_HEADER_ID;
	private String USER_TYPE;
	public BPIL_SHILPI() {
		super();
	}
	public int getMENU_HEADER_ID() {
		return MENU_HEADER_ID;
	}
	public void setMENU_HEADER_ID(int mENU_HEADER_ID) {
		MENU_HEADER_ID = mENU_HEADER_ID;
	}
	public String getUSER_TYPE() {
		return USER_TYPE;
	}
	public void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}
	@Override
	public String toString() {
		return "BPIL_SHILPI [MENU_HEADER_ID=" + MENU_HEADER_ID + ", USER_TYPE=" + USER_TYPE + "]";
	}

}

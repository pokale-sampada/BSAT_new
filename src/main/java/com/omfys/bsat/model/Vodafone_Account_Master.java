package com.omfys.bsat.model;

import java.io.Serializable;

public class Vodafone_Account_Master implements Serializable {

	private int a_id;
	private String account_code;
	private String segment;
	private String hq_circle;
	private String acc_type;
	private String account_manager;
	private String asm;
	private String segment_head;

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getAccount_code() {
		return account_code;
	}

	public void setAccount_code(String account_code) {
		this.account_code = account_code;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getHq_circle() {
		return hq_circle;
	}

	public void setHq_circle(String hq_circle) {
		this.hq_circle = hq_circle;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public String getAccount_manager() {
		return account_manager;
	}

	public void setAccount_manager(String account_manager) {
		this.account_manager = account_manager;
	}

	public String getAsm() {
		return asm;
	}

	public void setAsm(String asm) {
		this.asm = asm;
	}

	public String getSegment_head() {
		return segment_head;
	}

	public void setSegment_head(String segment_head) {
		this.segment_head = segment_head;
	}

	public Vodafone_Account_Master() {
		super();
		// TODO Auto-generated constructor stub
	}

}

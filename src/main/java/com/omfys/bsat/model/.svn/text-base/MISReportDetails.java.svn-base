package com.omfys.bsat.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class MISReportDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int scheme_id;
	private String scheme_name;
	private double scheme_outflow;
	private String scheme_code;

	@Override
	public String toString() {
		return "MISReportDetails [scheme_id=" + scheme_id + ", scheme_name=" + scheme_name + ", scheme_outflow="
				+ scheme_outflow + ", scheme_code=" + scheme_code + "]";
	}

	public MISReportDetails(int scheme_id, String scheme_name, double scheme_outflow, String scheme_code) {
		super();
		this.scheme_id = scheme_id;
		this.scheme_name = scheme_name;
		this.scheme_outflow = scheme_outflow;
		this.scheme_code = scheme_code;
	}

	public MISReportDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}

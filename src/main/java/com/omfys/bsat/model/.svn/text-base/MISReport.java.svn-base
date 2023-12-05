package com.omfys.bsat.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class MISReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String regn;
	private String depot;
	private String cust_code;
	private String cust_name;
	private String cust_club;
	private double ly_vol;
	private double ty_vol;
	private double vol_gr;
	private double ly_val;
	private double ty_val;
	private double val_gr;
	private double total_scheme_outflow;
	private String depot_code;

	@Override
	public String toString() {
		return "MISReport [regn=" + regn + ", depot=" + depot + ", cust_code=" + cust_code + ", cust_name=" + cust_name
				+ ", cust_club=" + cust_club + ", ly_vol=" + ly_vol + ", ty_vol=" + ty_vol + ", vol_gr=" + vol_gr
				+ ", ly_val=" + ly_val + ", ty_val=" + ty_val + ", val_gr=" + val_gr + ", total_scheme_outflow="
				+ total_scheme_outflow + ", depot_code=" + depot_code + "]";
	}

	public MISReport(String regn, String depot, String cust_code, String cust_name, String cust_club, double ly_vol,
			double ty_vol, double vol_gr, double ly_val, double ty_val, double val_gr, double total_scheme_outflow,
			String depot_code) {
		super();
		this.regn = regn;
		this.depot = depot;
		this.cust_code = cust_code;
		this.cust_name = cust_name;
		this.cust_club = cust_club;
		this.ly_vol = ly_vol;
		this.ty_vol = ty_vol;
		this.vol_gr = vol_gr;
		this.ly_val = ly_val;
		this.ty_val = ty_val;
		this.val_gr = val_gr;
		this.total_scheme_outflow = total_scheme_outflow;
		this.depot_code = depot_code;
	}

	public MISReport() {
		super();
		// TODO Auto-generated constructor stub
	}

}

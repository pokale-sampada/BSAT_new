package com.omfys.bsat.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class GiftCountReport implements Serializable {

	private static final long serialVersionUID = 1L;

	private String scheme_name;
	private String scheme_code;
	private String depot;
	private String reward;
	private int total;

	@Override
	public String toString() {
		return "GiftCountReport [scheme_name=" + scheme_name + ", scheme_code=" + scheme_code + ", depot=" + depot
				+ ", reward=" + reward + ", total=" + total + "]";
	}

	public GiftCountReport(String scheme_name, String scheme_code, String depot, String reward, int total) {
		super();
		this.scheme_name = scheme_name;
		this.scheme_code = scheme_code;
		this.depot = depot;
		this.reward = reward;
		this.total = total;
	}

	public GiftCountReport() {
		super();
		// TODO Auto-generated constructor stub
	}

}

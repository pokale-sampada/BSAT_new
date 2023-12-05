package com.omfys.bsat.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class PRDLINEWISEReport implements Serializable {

	private String region;
	private String depot;
	private String product;
	private float volume;
	private float value;
	private Date trxdate;
	private String trxdate1;
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDepot() {
		return depot;
	}

	public void setDepot(String depot) {
		this.depot = depot;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
	public Date getTrxdate() {
		return trxdate;
	}

	public void setTrxdate(Date trxdate) {
		this.trxdate = trxdate;
	}

	
	public String getTrxdate1() {
		return trxdate1;
	}

	public void setTrxdate1(String trxdate1) {
		this.trxdate1 = trxdate1;
	}

	@Override
	public String toString() {
		return "PRDLINEWISEReport [region=" + region + ", depot=" + depot + ", product=" + product + ", volume="
				+ volume + ", value=" + value + "]";
	}

	public PRDLINEWISEReport(String region, String depot, String product, float volume, float value) {
		super();
		this.region = region;
		this.depot = depot;
		this.product = product;
		this.volume = volume;
		this.value = value;
	}

	public PRDLINEWISEReport() {
		super();
		// TODO Auto-generated constructor stub
	}

}

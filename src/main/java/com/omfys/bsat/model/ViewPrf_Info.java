package com.omfys.bsat.model;

import java.sql.Date;

public class ViewPrf_Info {
	
	private String instance_num;
	private int distributor_id;
	private String distributor_name;
	private String country_code;
	private String genset_app_code;
	private int genset_sr_number;
	private String engine_app_code;
	private int engine_sr_number;
	private Long invoice_number;
	private Date invoice_date;
	private Date installation_date;
	private Date commissioning_date;
	private String customer_name;
	private int alternator_sr_number;
	private String type;
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getInvoice_date() {
		return invoice_date;
	}

	public void setInvoice_date(Date invoice_date) {
		this.invoice_date = invoice_date;
	}

	public String getInstance_num() {
		return instance_num;
	}

	public void setInstance_num(String instance_num) {
		this.instance_num = instance_num;
	}

	public int getDistributor_id() {
		return distributor_id;
	}

	public void setDistributor_id(int distributor_id) {
		this.distributor_id = distributor_id;
	}

	public String getDistributor_name() {
		return distributor_name;
	}

	public void setDistributor_name(String distributor_name) {
		this.distributor_name = distributor_name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getGenset_app_code() {
		return genset_app_code;
	}

	public void setGenset_app_code(String genset_app_code) {
		this.genset_app_code = genset_app_code;
	}

	public int getGenset_sr_number() {
		return genset_sr_number;
	}

	public void setGenset_sr_number(int genset_sr_number) {
		this.genset_sr_number = genset_sr_number;
	}

	public String getEngine_app_code() {
		return engine_app_code;
	}

	public void setEngine_app_code(String engine_app_code) {
		this.engine_app_code = engine_app_code;
	}

	public int getEngine_sr_number() {
		return engine_sr_number;
	}

	public void setEngine_sr_number(int engine_sr_number) {
		this.engine_sr_number = engine_sr_number;
	}

	public Long getInvoice_number() {
		return invoice_number;
	}

	public void setInvoice_number(Long invoice_number) {
		this.invoice_number = invoice_number;
	}

	public Date getInstallation_date() {
		return installation_date;
	}

	public void setInstallation_date(Date installation_date) {
		this.installation_date = installation_date;
	}

	public Date getCommissioning_date() {
		return commissioning_date;
	}

	public void setCommissioning_date(Date commissioning_date) {
		this.commissioning_date = commissioning_date;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getAlternator_sr_number() {
		return alternator_sr_number;
	}

	public void setAlternator_sr_number(int alternator_sr_number) {
		this.alternator_sr_number = alternator_sr_number;
	}

	
}

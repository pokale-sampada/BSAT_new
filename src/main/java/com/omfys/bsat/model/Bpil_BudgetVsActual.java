package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_BUDGETVSACTUAL")
public class Bpil_BudgetVsActual {

	@Id
	private int id;
	
	@Column(name = "S_DATE")
	private Date s_date;
	
	@Column(name = "VOLUME_BTC_GBP")
	private double volume_btc_gbp;
	
	@Column(name = "VOLUME_GBP")
	private double volume_gbp;
	
	@Column(name = "VOLUME_BTC_EUR")
	private double volume_btc_eur;
	
	@Column(name = "VOLUME_EUR")
	private double volume_eur;
	
	@Column(name = "VOLUME_BTC_USD")
	private double budget_value;
	
	@Column(name = "VOLUME_USD")
	private double actual_value;
	
}

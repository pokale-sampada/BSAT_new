package com.omfys.bsat.model;

import java.io.Serializable;
import java.util.Date;

public class MaxLife_RDC_TRANSACTION implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int transaction_id;
	private Date transaction_date;
	private int transaction_mtd_actual;
	private int transaction_base_fyc;
	private int agent_id;

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public int getTransaction_mtd_actual() {
		return transaction_mtd_actual;
	}

	public void setTransaction_mtd_actual(int transaction_mtd_actual) {
		this.transaction_mtd_actual = transaction_mtd_actual;
	}

	public int getTransaction_base_fyc() {
		return transaction_base_fyc;
	}

	public void setTransaction_base_fyc(int transaction_base_fyc) {
		this.transaction_base_fyc = transaction_base_fyc;
	}

	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}

	@Override
	public String toString() {
		return "MaxLife_RDC_TRANSACTION [transaction_id=" + transaction_id + ", transaction_date=" + transaction_date
				+ ", transaction_mtd_actual=" + transaction_mtd_actual + ", transaction_base_fyc="
				+ transaction_base_fyc + ", agent_id=" + agent_id + "]";
	}

	public MaxLife_RDC_TRANSACTION(int transaction_id, Date transaction_date, int transaction_mtd_actual,
			int transaction_base_fyc, int agent_id) {
		super();
		this.transaction_id = transaction_id;
		this.transaction_date = transaction_date;
		this.transaction_mtd_actual = transaction_mtd_actual;
		this.transaction_base_fyc = transaction_base_fyc;
		this.agent_id = agent_id;
	}

	public MaxLife_RDC_TRANSACTION() {
		super();
		// TODO Auto-generated constructor stub
	}

}

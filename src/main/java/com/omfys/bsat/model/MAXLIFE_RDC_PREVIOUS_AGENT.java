package com.omfys.bsat.model;

import java.io.Serializable;
import java.sql.Date;

public class MAXLIFE_RDC_PREVIOUS_AGENT implements Serializable {

	private int id;
	private int agent_id;
	private int previous_ytd_target;
	private int previous_ytd_vintage;
	private int previous_ytd_acual;
	private String month;
	private int previous_already_paid;
	private String previous_proactivity_status;

	public String getPrevious_proactivity_status() {
		return previous_proactivity_status;
	}

	public void setPrevious_proactivity_status(String previous_proactivity_status) {
		this.previous_proactivity_status = previous_proactivity_status;
	}

	public String getMonth() {
		return month;
	}

	public int getPrevious_already_paid() {
		return previous_already_paid;
	}

	public void setPrevious_already_paid(int previous_already_paid) {
		this.previous_already_paid = previous_already_paid;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}

	public int getPrevious_ytd_target() {
		return previous_ytd_target;
	}

	public void setPrevious_ytd_target(int previous_ytd_target) {
		this.previous_ytd_target = previous_ytd_target;
	}

	public int getPrevious_ytd_vintage() {
		return previous_ytd_vintage;
	}

	public void setPrevious_ytd_vintage(int previous_ytd_vintage) {
		this.previous_ytd_vintage = previous_ytd_vintage;
	}

	public int getPrevious_ytd_acual() {
		return previous_ytd_acual;
	}

	public void setPrevious_ytd_acual(int previous_ytd_acual) {
		this.previous_ytd_acual = previous_ytd_acual;
	}

	@Override
	public String toString() {
		return "MAXLIFE_RDC_PREVIOUS_AGENT [id=" + id + ", agent_id=" + agent_id + ", previous_ytd_target="
				+ previous_ytd_target + ", previous_ytd_vintage=" + previous_ytd_vintage + ", previous_ytd_acual="
				+ previous_ytd_acual + ", month=" + month + "]";
	}

	public MAXLIFE_RDC_PREVIOUS_AGENT(int id, int agent_id, int previous_ytd_target, int previous_ytd_vintage,
			int previous_ytd_acual, String month) {
		super();
		this.id = id;
		this.agent_id = agent_id;
		this.previous_ytd_target = previous_ytd_target;
		this.previous_ytd_vintage = previous_ytd_vintage;
		this.previous_ytd_acual = previous_ytd_acual;
		this.month = month;
	}

	public MAXLIFE_RDC_PREVIOUS_AGENT() {
		super();
		// TODO Auto-generated constructor stub
	}

}

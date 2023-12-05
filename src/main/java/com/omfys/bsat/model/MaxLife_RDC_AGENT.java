package com.omfys.bsat.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class MaxLife_RDC_AGENT implements Serializable {

	private int id;
	private int transaction_id;
	private int agent_id;
	private Date agent_doj;
	private int agent_base_fyc;
	private int agent_already_paid;
	private String agent_status;
	private int agent_mtd_actual;
	private float agent_itd_vintage;
	private float agent_ytd_vintage;
	private float agent_mtd_target;
	private float agent_ytd_target;
	private int agent_ytd_actual;
	private String proactivity_status;
	private int ytd_proactive_count;
	private float multiplying_factor;
	private float gross_payout;
	private float net_payout;
	private int aadm_id;
	private String agent_last_proactive_status;

	public String getAgent_last_proactive_status() {
		return agent_last_proactive_status;
	}

	public void setAgent_last_proactive_status(String agent_last_proactive_status) {
		this.agent_last_proactive_status = agent_last_proactive_status;
	}

	private List<MAXLIFE_RDC_PREVIOUS_AGENT> previous_agents;
	private List<MaxLife_RDC_TRANSACTION> agent_transactions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}

	public Date getAgent_doj() {
		return agent_doj;
	}

	public void setAgent_doj(Date agent_doj) {
		this.agent_doj = agent_doj;
	}

	public int getAgent_base_fyc() {
		return agent_base_fyc;
	}

	public void setAgent_base_fyc(int agent_base_fyc) {
		this.agent_base_fyc = agent_base_fyc;
	}

	public int getAgent_already_paid() {
		return agent_already_paid;
	}

	public void setAgent_already_paid(int agent_already_paid) {
		this.agent_already_paid = agent_already_paid;
	}

	public String getAgent_status() {
		return agent_status;
	}

	public void setAgent_status(String agent_status) {
		this.agent_status = agent_status;
	}

	public int getAgent_mtd_actual() {
		return agent_mtd_actual;
	}

	public void setAgent_mtd_actual(int agent_mtd_actual) {
		this.agent_mtd_actual = agent_mtd_actual;
	}

	public float getAgent_itd_vintage() {
		return agent_itd_vintage;
	}

	public void setAgent_itd_vintage(float agent_itd_vintage) {
		this.agent_itd_vintage = agent_itd_vintage;
	}

	public float getAgent_ytd_vintage() {
		return agent_ytd_vintage;
	}

	public void setAgent_ytd_vintage(float agent_ytd_vintage) {
		this.agent_ytd_vintage = agent_ytd_vintage;
	}

	public float getAgent_mtd_target() {
		return agent_mtd_target;
	}

	public void setAgent_mtd_target(float agent_mtd_target) {
		this.agent_mtd_target = agent_mtd_target;
	}

	public float getAgent_ytd_target() {
		return agent_ytd_target;
	}

	public void setAgent_ytd_target(float agent_ytd_target) {
		this.agent_ytd_target = agent_ytd_target;
	}

	public int getAgent_ytd_actual() {
		return agent_ytd_actual;
	}

	public void setAgent_ytd_actual(int agent_ytd_actual) {
		this.agent_ytd_actual = agent_ytd_actual;
	}

	public String getProactivity_status() {
		return proactivity_status;
	}

	public void setProactivity_status(String proactivity_status) {
		this.proactivity_status = proactivity_status;
	}

	public int getYtd_proactive_count() {
		return ytd_proactive_count;
	}

	public void setYtd_proactive_count(int ytd_proactive_count) {
		this.ytd_proactive_count = ytd_proactive_count;
	}

	public float getMultiplying_factor() {
		return multiplying_factor;
	}

	public void setMultiplying_factor(float multiplying_factor) {
		this.multiplying_factor = multiplying_factor;
	}

	public float getGross_payout() {
		return gross_payout;
	}

	public void setGross_payout(float gross_payout) {
		this.gross_payout = gross_payout;
	}

	public float getNet_payout() {
		return net_payout;
	}

	public void setNet_payout(float net_payout) {
		this.net_payout = net_payout;
	}

	public int getAadm_id() {
		return aadm_id;
	}

	public void setAadm_id(int aadm_id) {
		this.aadm_id = aadm_id;
	}

	public List<MAXLIFE_RDC_PREVIOUS_AGENT> getPrevious_agents() {
		return previous_agents;
	}

	public void setPrevious_agents(List<MAXLIFE_RDC_PREVIOUS_AGENT> previous_agents) {
		this.previous_agents = previous_agents;
	}

	public List<MaxLife_RDC_TRANSACTION> getAgent_transactions() {
		return agent_transactions;
	}

	public void setAgent_transactions(List<MaxLife_RDC_TRANSACTION> agent_transactions) {
		this.agent_transactions = agent_transactions;
	}

	@Override
	public String toString() {
		return "MaxLife_RDC_AGENT [id=" + id + ", transaction_id=" + transaction_id + ", agent_id=" + agent_id
				+ ", agent_doj=" + agent_doj + ", agent_base_fyc=" + agent_base_fyc + ", agent_already_paid="
				+ agent_already_paid + ", agent_status=" + agent_status + ", agent_mtd_actual=" + agent_mtd_actual
				+ ", agent_itd_vintage=" + agent_itd_vintage + ", agent_ytd_vintage=" + agent_ytd_vintage
				+ ", agent_mtd_target=" + agent_mtd_target + ", agent_ytd_target=" + agent_ytd_target
				+ ", agent_ytd_actual=" + agent_ytd_actual + ", proactivity_status=" + proactivity_status
				+ ", ytd_proactive_count=" + ytd_proactive_count + ", multiplying_factor=" + multiplying_factor
				+ ", gross_payout=" + gross_payout + ", net_payout=" + net_payout + ", aadm_id=" + aadm_id
				+ ", previous_agents=" + previous_agents + ", agent_transactions=" + agent_transactions + "]";
	}

	public MaxLife_RDC_AGENT(int id, int transaction_id, int agent_id, Date agent_doj, int agent_base_fyc,
			int agent_already_paid, String agent_status, int agent_mtd_actual, float agent_itd_vintage,
			float agent_ytd_vintage, float agent_mtd_target, float agent_ytd_target, int agent_ytd_actual,
			String proactivity_status, int ytd_proactive_count, float multiplying_factor, float gross_payout,
			float net_payout, int aadm_id, List<MAXLIFE_RDC_PREVIOUS_AGENT> previous_agents,
			List<MaxLife_RDC_TRANSACTION> agent_transactions) {
		super();
		this.id = id;
		this.transaction_id = transaction_id;
		this.agent_id = agent_id;
		this.agent_doj = agent_doj;
		this.agent_base_fyc = agent_base_fyc;
		this.agent_already_paid = agent_already_paid;
		this.agent_status = agent_status;
		this.agent_mtd_actual = agent_mtd_actual;
		this.agent_itd_vintage = agent_itd_vintage;
		this.agent_ytd_vintage = agent_ytd_vintage;
		this.agent_mtd_target = agent_mtd_target;
		this.agent_ytd_target = agent_ytd_target;
		this.agent_ytd_actual = agent_ytd_actual;
		this.proactivity_status = proactivity_status;
		this.ytd_proactive_count = ytd_proactive_count;
		this.multiplying_factor = multiplying_factor;
		this.gross_payout = gross_payout;
		this.net_payout = net_payout;
		this.aadm_id = aadm_id;
		this.previous_agents = previous_agents;
		this.agent_transactions = agent_transactions;
	}

	public MaxLife_RDC_AGENT() {
		super();
		// TODO Auto-generated constructor stub
	}

}

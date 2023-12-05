package com.omfys.bsat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MaxLife_RDC_AADM implements Serializable {

	private int aadm_id;

	private int agent_id;

	private List<MaxLife_RDC_AGENT> agents = new ArrayList<>();

	public int getAadm_id() {
		return aadm_id;
	}

	public void setAadm_id(int aadm_id) {
		this.aadm_id = aadm_id;
	}

	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}

	@Override
	public String toString() {
		return "MaxLife_RDC_AADM [aadm_id=" + aadm_id + ", agent_id=" + agent_id + "]";
	}

	public MaxLife_RDC_AADM(int aadm_id, int agent_id) {
		super();
		this.aadm_id = aadm_id;
		this.agent_id = agent_id;
	}

	public List<MaxLife_RDC_AGENT> getAgents() {
		return agents;
	}

	public void setAgents(List<MaxLife_RDC_AGENT> agents) {
		this.agents = agents;
	}

	public MaxLife_RDC_AADM() {
		super();
		// TODO Auto-generated constructor stub
	}

}

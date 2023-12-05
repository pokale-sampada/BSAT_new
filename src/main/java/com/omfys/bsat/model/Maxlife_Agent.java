package com.omfys.bsat.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Maxlife_Agent {
	
	private Integer ID;
	private Integer AG_ID;
	private Integer ADM_ID;
	private Integer AGENT_ID;
	private Date AGENT_DOJ;
	private String AGENT_STATUS;
	private Integer AGENT_MTD;
	private Integer AGENT_NOP;
	private Float AGENT_QR;
	private Date AGENT_SECOND_MONTH;
	private Integer AGENT_VINTAGE_PERIOD;
	private Float AGENT_WFYP;
	private String month;
	
	
	
	
	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	private List<Maxlife_Transaction> Agent_Transaction;


	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public Integer getAG_ID() {
		return AG_ID;
	}


	public void setAG_ID(Integer aG_ID) {
		AG_ID = aG_ID;
	}


	public Integer getADM_ID() {
		return ADM_ID;
	}


	public void setADM_ID(Integer aDM_ID) {
		ADM_ID = aDM_ID;
	}


	public Integer getAGENT_ID() {
		return AGENT_ID;
	}


	public void setAGENT_ID(Integer aGENT_ID) {
		AGENT_ID = aGENT_ID;
	}


	public Date getAGENT_DOJ() {
		return AGENT_DOJ;
	}


	public void setAGENT_DOJ(Date aGENT_DOJ) {
		AGENT_DOJ = aGENT_DOJ;
	}


	public String getAGENT_STATUS() {
		return AGENT_STATUS;
	}


	public void setAGENT_STATUS(String aGENT_STATUS) {
		AGENT_STATUS = aGENT_STATUS;
	}


	public Integer getAGENT_MTD() {
		return AGENT_MTD;
	}


	public void setAGENT_MTD(Integer aGENT_MTD) {
		AGENT_MTD = aGENT_MTD;
	}


	public Integer getAGENT_NOP() {
		return AGENT_NOP;
	}


	public void setAGENT_NOP(Integer aGENT_NOP) {
		AGENT_NOP = aGENT_NOP;
	}


	public Float getAGENT_QR() {
		return AGENT_QR;
	}


	public void setAGENT_QR(Float aGENT_QR) {
		AGENT_QR = aGENT_QR;
	}


	public Date getAGENT_SECOND_MONTH() {
		return AGENT_SECOND_MONTH;
	}


	public void setAGENT_SECOND_MONTH(Date aGENT_SECOND_MONTH) {
		AGENT_SECOND_MONTH = aGENT_SECOND_MONTH;
	}


	public Integer getAGENT_VINTAGE_PERIOD() {
		return AGENT_VINTAGE_PERIOD;
	}


	public void setAGENT_VINTAGE_PERIOD(Integer aGENT_VINTAGE_PERIOD) {
		AGENT_VINTAGE_PERIOD = aGENT_VINTAGE_PERIOD;
	}


	public Float getAGENT_WFYP() {
		return AGENT_WFYP;
	}


	public void setAGENT_WFYP(Float aGENT_WFYP) {
		AGENT_WFYP = aGENT_WFYP;
	}


	public List<Maxlife_Transaction> getAgent_Transaction() {
		return Agent_Transaction;
	}


	public void setAgent_Transaction(List<Maxlife_Transaction> agent_Transaction) {
		Agent_Transaction = agent_Transaction;
	}
	
	
	
		
	

}

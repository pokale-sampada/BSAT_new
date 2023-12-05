package com.omfys.bsat.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Maxlife_Adm {

	private Integer ID;
	private Integer ADM_ID;
	private Date ADM_JOINING_DATE;
	private String ADM_NAME;
	private Date ADM_PROMOTION_DATE;
	private String ADM_ROLE;
	private String ADM_LOCATION;
	private Integer ADM_TERMINATED_COUNT;
	private Integer ADM_ACTUAL_MTD_ACTIVE_MM;
	private Integer ADM_ACTUAL_NOP;
	private Integer ADM_ACTUAL_QR;
	private Float ADM_ACTUAL_WFYP;
	private Integer ADM_EXPECTED_MTD_ACTIVE_MM;
	private Integer ADM_EXPECTED_NOP;
	private Integer ADM_EXPECTED_QR;
	private Float ADM_EXPECTED_WFYP;
	private Float ADM_MTD_ACTIVE_MM_GPA;
	private Float ADM_MTD_ACTIVE_MM_PERCENTAGE;
	private Float ADM_NOP_GPA;
	private Float ADM_NOP_PERCENTAGE;
	private Float ADM_QR_GPA;
	private Float ADM_QR_PERCENTAGE;
	private Float ADM_VINTAGE_PERIOD;
	private Float ADM_WEIGHTED_PERCENTAGE;
	private Float ADM_WTD_VALUE_MTD_ACTIVE_MM;
	private Float ADM_WEIGHTED_VALUE_NOP;
	private Float ADM_WEIGHTED_VALUE_QR;
	private Float ADM_WEIGHTED_VALUE_WFYP;
	private Float ADM_WFYP_GPA;
	private Float ADM_WFYP_PERCENTAGE;
	private Float ADM_TOTAL_GPA_SCORE;
	private String location;

	

	public String getADM_LOCATION() {
		return ADM_LOCATION;
	}


	public void setADM_LOCATION(String aDM_LOCATION) {
		ADM_LOCATION = aDM_LOCATION;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	private List<Maxlife_Agent> Adm_Agent;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getADM_ID() {
		return ADM_ID;
	}

	public void setADM_ID(Integer aDM_ID) {
		ADM_ID = aDM_ID;
	}

	public Date getADM_JOINING_DATE() {
		return ADM_JOINING_DATE;
	}

	public void setADM_JOINING_DATE(Date aDM_JOINING_DATE) {
		ADM_JOINING_DATE = aDM_JOINING_DATE;
	}

	public String getADM_NAME() {
		return ADM_NAME;
	}

	public void setADM_NAME(String aDM_NAME) {
		ADM_NAME = aDM_NAME;
	}

	public Date getADM_PROMOTION_DATE() {
		return ADM_PROMOTION_DATE;
	}

	public void setADM_PROMOTION_DATE(Date aDM_PROMOTION_DATE) {
		ADM_PROMOTION_DATE = aDM_PROMOTION_DATE;
	}

	public String getADM_ROLE() {
		return ADM_ROLE;
	}

	public void setADM_ROLE(String aDM_ROLE) {
		ADM_ROLE = aDM_ROLE;
	}

	public Integer getADM_TERMINATED_COUNT() {
		return ADM_TERMINATED_COUNT;
	}

	public void setADM_TERMINATED_COUNT(Integer aDM_TERMINATED_COUNT) {
		ADM_TERMINATED_COUNT = aDM_TERMINATED_COUNT;
	}

	public Integer getADM_ACTUAL_MTD_ACTIVE_MM() {
		return ADM_ACTUAL_MTD_ACTIVE_MM;
	}

	public void setADM_ACTUAL_MTD_ACTIVE_MM(Integer aDM_ACTUAL_MTD_ACTIVE_MM) {
		ADM_ACTUAL_MTD_ACTIVE_MM = aDM_ACTUAL_MTD_ACTIVE_MM;
	}

	public Integer getADM_ACTUAL_NOP() {
		return ADM_ACTUAL_NOP;
	}

	public void setADM_ACTUAL_NOP(Integer aDM_ACTUAL_NOP) {
		ADM_ACTUAL_NOP = aDM_ACTUAL_NOP;
	}

	public Integer getADM_ACTUAL_QR() {
		return ADM_ACTUAL_QR;
	}

	public void setADM_ACTUAL_QR(Integer aDM_ACTUAL_QR) {
		ADM_ACTUAL_QR = aDM_ACTUAL_QR;
	}

	public Float getADM_ACTUAL_WFYP() {
		return ADM_ACTUAL_WFYP;
	}

	public void setADM_ACTUAL_WFYP(Float aDM_ACTUAL_WFYP) {
		ADM_ACTUAL_WFYP = aDM_ACTUAL_WFYP;
	}

	public Integer getADM_EXPECTED_MTD_ACTIVE_MM() {
		return ADM_EXPECTED_MTD_ACTIVE_MM;
	}

	public void setADM_EXPECTED_MTD_ACTIVE_MM(Integer aDM_EXPECTED_MTD_ACTIVE_MM) {
		ADM_EXPECTED_MTD_ACTIVE_MM = aDM_EXPECTED_MTD_ACTIVE_MM;
	}

	public Integer getADM_EXPECTED_NOP() {
		return ADM_EXPECTED_NOP;
	}

	public void setADM_EXPECTED_NOP(Integer aDM_EXPECTED_NOP) {
		ADM_EXPECTED_NOP = aDM_EXPECTED_NOP;
	}

	public Integer getADM_EXPECTED_QR() {
		return ADM_EXPECTED_QR;
	}

	public void setADM_EXPECTED_QR(Integer aDM_EXPECTED_QR) {
		ADM_EXPECTED_QR = aDM_EXPECTED_QR;
	}

	public Float getADM_EXPECTED_WFYP() {
		return ADM_EXPECTED_WFYP;
	}

	public void setADM_EXPECTED_WFYP(Float aDM_EXPECTED_WFYP) {
		ADM_EXPECTED_WFYP = aDM_EXPECTED_WFYP;
	}

	public Float getADM_MTD_ACTIVE_MM_GPA() {
		return ADM_MTD_ACTIVE_MM_GPA;
	}

	public void setADM_MTD_ACTIVE_MM_GPA(Float aDM_MTD_ACTIVE_MM_GPA) {
		ADM_MTD_ACTIVE_MM_GPA = aDM_MTD_ACTIVE_MM_GPA;
	}

	public Float getADM_MTD_ACTIVE_MM_PERCENTAGE() {
		return ADM_MTD_ACTIVE_MM_PERCENTAGE;
	}

	public void setADM_MTD_ACTIVE_MM_PERCENTAGE(Float aDM_MTD_ACTIVE_MM_PERCENTAGE) {
		ADM_MTD_ACTIVE_MM_PERCENTAGE = aDM_MTD_ACTIVE_MM_PERCENTAGE;
	}

	public Float getADM_NOP_GPA() {
		return ADM_NOP_GPA;
	}

	public void setADM_NOP_GPA(Float aDM_NOP_GPA) {
		ADM_NOP_GPA = aDM_NOP_GPA;
	}

	public Float getADM_NOP_PERCENTAGE() {
		return ADM_NOP_PERCENTAGE;
	}

	public void setADM_NOP_PERCENTAGE(Float aDM_NOP_PERCENTAGE) {
		ADM_NOP_PERCENTAGE = aDM_NOP_PERCENTAGE;
	}

	public Float getADM_QR_GPA() {
		return ADM_QR_GPA;
	}

	public void setADM_QR_GPA(Float aDM_QR_GPA) {
		ADM_QR_GPA = aDM_QR_GPA;
	}

	public Float getADM_QR_PERCENTAGE() {
		return ADM_QR_PERCENTAGE;
	}

	public void setADM_QR_PERCENTAGE(Float aDM_QR_PERCENTAGE) {
		ADM_QR_PERCENTAGE = aDM_QR_PERCENTAGE;
	}

	public Float getADM_VINTAGE_PERIOD() {
		return ADM_VINTAGE_PERIOD;
	}

	public void setADM_VINTAGE_PERIOD(Float aDM_VINTAGE_PERIOD) {
		ADM_VINTAGE_PERIOD = aDM_VINTAGE_PERIOD;
	}

	public Float getADM_WEIGHTED_PERCENTAGE() {
		return ADM_WEIGHTED_PERCENTAGE;
	}

	public void setADM_WEIGHTED_PERCENTAGE(Float aDM_WEIGHTED_PERCENTAGE) {
		ADM_WEIGHTED_PERCENTAGE = aDM_WEIGHTED_PERCENTAGE;
	}

	public Float getADM_WTD_VALUE_MTD_ACTIVE_MM() {
		return ADM_WTD_VALUE_MTD_ACTIVE_MM;
	}

	public void setADM_WTD_VALUE_MTD_ACTIVE_MM(Float aDM_WTD_VALUE_MTD_ACTIVE_MM) {
		ADM_WTD_VALUE_MTD_ACTIVE_MM = aDM_WTD_VALUE_MTD_ACTIVE_MM;
	}

	public Float getADM_WEIGHTED_VALUE_NOP() {
		return ADM_WEIGHTED_VALUE_NOP;
	}

	public void setADM_WEIGHTED_VALUE_NOP(Float aDM_WEIGHTED_VALUE_NOP) {
		ADM_WEIGHTED_VALUE_NOP = aDM_WEIGHTED_VALUE_NOP;
	}

	public Float getADM_WEIGHTED_VALUE_QR() {
		return ADM_WEIGHTED_VALUE_QR;
	}

	public void setADM_WEIGHTED_VALUE_QR(Float aDM_WEIGHTED_VALUE_QR) {
		ADM_WEIGHTED_VALUE_QR = aDM_WEIGHTED_VALUE_QR;
	}

	public Float getADM_WEIGHTED_VALUE_WFYP() {
		return ADM_WEIGHTED_VALUE_WFYP;
	}

	public void setADM_WEIGHTED_VALUE_WFYP(Float aDM_WEIGHTED_VALUE_WFYP) {
		ADM_WEIGHTED_VALUE_WFYP = aDM_WEIGHTED_VALUE_WFYP;
	}

	public Float getADM_WFYP_GPA() {
		return ADM_WFYP_GPA;
	}

	public void setADM_WFYP_GPA(Float aDM_WFYP_GPA) {
		ADM_WFYP_GPA = aDM_WFYP_GPA;
	}

	public Float getADM_WFYP_PERCENTAGE() {
		return ADM_WFYP_PERCENTAGE;
	}

	public void setADM_WFYP_PERCENTAGE(Float aDM_WFYP_PERCENTAGE) {
		ADM_WFYP_PERCENTAGE = aDM_WFYP_PERCENTAGE;
	}

	public Float getADM_TOTAL_GPA_SCORE() {
		return ADM_TOTAL_GPA_SCORE;
	}

	public void setADM_TOTAL_GPA_SCORE(Float aDM_TOTAL_GPA_SCORE) {
		ADM_TOTAL_GPA_SCORE = aDM_TOTAL_GPA_SCORE;
	}

	public List<Maxlife_Agent> getAdm_Agent() {
		return Adm_Agent;
	}

	public void setAdm_Agent(List<Maxlife_Agent> adm_Agent) {
		Adm_Agent = adm_Agent;
	}

}

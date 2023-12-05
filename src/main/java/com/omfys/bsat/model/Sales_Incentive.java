package com.omfys.bsat.model;

import java.io.Serializable;

public class Sales_Incentive implements Serializable {

	private int id;
	private int actual_basic_pay;
	private String emp_name;
	private String department;
	private int processed_basic_average_pay;
	private float basic_proportion;
	private String designation;
	private int flat_incentive;
	private float quarterly_performance_rating_by_hod;
	private float performance_proportion;
	private int performance_incentive;
	private int additional_incentive;
	private int total_payable;
	private int brokrage_days;

	private int total_kitty_amount;
	private int final_flat_incentive;
	private int final_performance_incentive;
	private int final_additional_incentive;

	public int getTotal_kitty_amount() {
		return total_kitty_amount;
	}

	public void setTotal_kitty_amount(int total_kitty_amount) {
		this.total_kitty_amount = total_kitty_amount;
	}

	public int getFinal_flat_incentive() {
		return final_flat_incentive;
	}

	public void setFinal_flat_incentive(int final_flat_incentive) {
		this.final_flat_incentive = final_flat_incentive;
	}

	public int getFinal_performance_incentive() {
		return final_performance_incentive;
	}

	public void setFinal_performance_incentive(int final_performance_incentive) {
		this.final_performance_incentive = final_performance_incentive;
	}

	public int getFinal_additional_incentive() {
		return final_additional_incentive;
	}

	public void setFinal_additional_incentive(int final_additional_incentive) {
		this.final_additional_incentive = final_additional_incentive;
	}

	public int getBrokrage_days() {
		return brokrage_days;
	}

	public void setBrokrage_days(int brokrage_days) {
		this.brokrage_days = brokrage_days;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActual_basic_pay() {
		return actual_basic_pay;
	}

	public void setActual_basic_pay(int actual_basic_pay) {
		this.actual_basic_pay = actual_basic_pay;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getProcessed_basic_average_pay() {
		return processed_basic_average_pay;
	}

	public void setProcessed_basic_average_pay(int processed_basic_average_pay) {
		this.processed_basic_average_pay = processed_basic_average_pay;
	}

	public float getBasic_proportion() {
		return basic_proportion;
	}

	public void setBasic_proportion(float basic_proportion) {
		this.basic_proportion = basic_proportion;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getFlat_incentive() {
		return flat_incentive;
	}

	public void setFlat_incentive(int flat_incentive) {
		this.flat_incentive = flat_incentive;
	}

	public float getQuarterly_performance_rating_by_hod() {
		return quarterly_performance_rating_by_hod;
	}

	public void setQuarterly_performance_rating_by_hod(float quarterly_performance_rating_by_hod) {
		this.quarterly_performance_rating_by_hod = quarterly_performance_rating_by_hod;
	}

	public float getPerformance_proportion() {
		return performance_proportion;
	}

	public void setPerformance_proportion(float performance_proportion) {
		this.performance_proportion = performance_proportion;
	}

	public int getPerformance_incentive() {
		return performance_incentive;
	}

	public void setPerformance_incentive(int performance_incentive) {
		this.performance_incentive = performance_incentive;
	}

	public int getAdditional_incentive() {
		return additional_incentive;
	}

	public void setAdditional_incentive(int additional_incentive) {
		this.additional_incentive = additional_incentive;
	}

	public int getTotal_payable() {
		return total_payable;
	}

	public void setTotal_payable(int total_payable) {
		this.total_payable = total_payable;
	}

}

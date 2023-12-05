/**
 * 
 */
package com.omfys.bsat.model;


/**
 * @author Omfys
 *
 */
public class EurekaLevel1TransactionModel {

	// l0 varibles
	private String l0HrDesignation;
	private int empId;
	private int transactionCycle;

	// l0
	private String materialCode;
	private int adjustableScaleQuantity;
	private int finalNetValue;
	private int actualScaleQuantity;

	// l1 variables
	private String l1HrDesignation;
	private String budgetSaleGroup;
	private int level1EmpId;
	private int level1TransactionCycle;

	// l1 transaction
	private String l1MterialCode;
	private String l1MterialGrp;
	private int l1finalNetValue;
	private int l1AdjustableScaleQuantity;
	private String levell1SaleGroup;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getL0HrDesignation() {
		return l0HrDesignation;
	}

	public void setL0HrDesignation(String l0HrDesignation) {
		this.l0HrDesignation = l0HrDesignation;
	}

	public String getL1HrDesignation() {
		return l1HrDesignation;
	}

	public void setL1HrDesignation(String l1HrDesignation) {
		this.l1HrDesignation = l1HrDesignation;
	}

	public int getTransactionCycle() {
		return transactionCycle;
	}

	public void setTransactionCycle(int transactionCycle) {
		this.transactionCycle = transactionCycle;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getL1MterialGrp() {
		return l1MterialGrp;
	}

	public void setL1MterialGrp(String l1MterialGrp) {
		this.l1MterialGrp = l1MterialGrp;
	}

	public int getAdjustableScaleQuantity() {
		return adjustableScaleQuantity;
	}

	public void setAdjustableScaleQuantity(int adjustableScaleQuantity) {
		this.adjustableScaleQuantity = adjustableScaleQuantity;
	}

	public int getFinalNetValue() {
		return finalNetValue;
	}

	public void setFinalNetValue(int finalNetValue) {
		this.finalNetValue = finalNetValue;
	}

	public int getActualScaleQuantity() {
		return actualScaleQuantity;
	}

	public void setActualScaleQuantity(int actualScaleQuantity) {
		this.actualScaleQuantity = actualScaleQuantity;
	}

	public String getBudgetSaleGroup() {
		return budgetSaleGroup;
	}

	public void setBudgetSaleGroup(String budgetSaleGroup) {
		this.budgetSaleGroup = budgetSaleGroup;
	}

	public int getLevel1EmpId() {
		return level1EmpId;
	}

	public void setLevel1EmpId(int level1EmpId) {
		this.level1EmpId = level1EmpId;
	}

	public int getLevel1TransactionCycle() {
		return level1TransactionCycle;
	}

	public void setLevel1TransactionCycle(int level1TransactionCycle) {
		this.level1TransactionCycle = level1TransactionCycle;
	}

	public String getL1MterialCode() {
		return l1MterialCode;
	}

	public void setL1MterialCode(String l1MterialCode) {
		this.l1MterialCode = l1MterialCode;
	}

	public int getL1finalNetValue() {
		return l1finalNetValue;
	}

	public void setL1finalNetValue(int l1finalNetValue) {
		this.l1finalNetValue = l1finalNetValue;
	}

	public int getL1AdjustableScaleQuantity() {
		return l1AdjustableScaleQuantity;
	}

	public void setL1AdjustableScaleQuantity(int l1AdjustableScaleQuantity) {
		this.l1AdjustableScaleQuantity = l1AdjustableScaleQuantity;
	}

	public String getLevell1SaleGroup() {
		return levell1SaleGroup;
	}

	public void setLevell1SaleGroup(String levell1SaleGroup) {
		this.levell1SaleGroup = levell1SaleGroup;
	}

	

}

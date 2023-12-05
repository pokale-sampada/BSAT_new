/**
 * 
 */
package com.omfys.bsat.model;


/**
 * @author Omfys
 *
 */
public class EurekaTransactionMaster {

	private String materialCode;
	private int adjustableScaleQuantity;
	private int actualScaleQuantity;
	private int finalNetSales;
	private int transactionCycle;
	private int empId;
	private int salesOffice;
	private String salesGroup;
	private String billType;
	private String createdDate;
	private String salesType;
	private int year;
	private int orderNo;
	private int docRefer;

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public int getAdjustableScaleQuantity() {
		return adjustableScaleQuantity;
	}

	public void setAdjustableScaleQuantity(int adjustableScaleQuantity) {
		this.adjustableScaleQuantity = adjustableScaleQuantity;
	}

	public int getActualScaleQuantity() {
		return actualScaleQuantity;
	}

	public void setActualScaleQuantity(int actualScaleQuantity) {
		this.actualScaleQuantity = actualScaleQuantity;
	}

	public int getFinalNetSales() {
		return finalNetSales;
	}

	public void setFinalNetSales(int finalNetSales) {
		this.finalNetSales = finalNetSales;
	}

	public int getTransactionCycle() {
		return transactionCycle;
	}

	public void setTransactionCycle(int transactionCycle) {
		this.transactionCycle = transactionCycle;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getSalesOffice() {
		return salesOffice;
	}

	public void setSalesOffice(int salesOffice) {
		this.salesOffice = salesOffice;
	}

	public String getSalesGroup() {
		return salesGroup;
	}

	public void setSalesGroup(String salesGroup) {
		this.salesGroup = salesGroup;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getSalesType() {
		return salesType;
	}

	public void setSalesType(String salesType) {
		this.salesType = salesType;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getDocRefer() {
		return docRefer;
	}

	public void setDocRefer(int docRefer) {
		this.docRefer = docRefer;
	}

}

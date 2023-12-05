package com.omfys.bsat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_DEALERS_REST")
public class Bpil_Dealers_Rest {
	
	@Id
	@Column(name = "ID")
	int ID;
	
	@Column(name = "REGN")
	String REGN;
	
	@Column(name = "DEPOT_CODE")
	String DEPOT_CODE;
	
	@Column(name = "DEPOT_NAME")
	String DEPOT_NAME;
	
	@Column(name = "BILL_TO_ID")
	int BILL_TO_ID;
	
	@Column(name = "DLR_AC_NO")
	String DLR_AC_NO;
	
	@Column(name = "DLR_AC_NAME")
	String DLR_AC_NAME;
	
	@Column(name = "DLR_CAT")
	String DLR_CAT;
	
	@Column(name = "CUST_TYPE")
	String CUST_TYPE;
	
	@Column(name = "TERR_CODE")
	String TERR_CODE;
	
	@Column(name = "SCHEME_ID")
	String SCHEME_ID;

}

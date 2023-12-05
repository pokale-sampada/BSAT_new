package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_PRODUCTS_REST")
public class Bpil_Products_Rest {
	
	@Id
	@Column(name = "ID")
	int ID;
	
	@Column(name = "BILL_TO_ID")
	int BILL_TO_ID;
	
	@Column(name = "PRD_CAT")
	String PRD_CAT;
	
	@Column(name = "PRD_CODE")
	String PRD_CODE;
	
	@Column(name = "SHD_CODE")
	String SHD_CODE;
	
	@Column(name = "PRD_UOM")
	String PRD_UOM;
	
	@Column(name = "PACK_SIZE")
	int PACK_SIZE;
	
	@Column(name = "SLS_TRX_DATE")
	Date SLS_TRX_DATE;
	
	@Column(name = "SLS_VOL")
    int SLS_VOL;
	
	@Column(name = "SLS_FNL_VOL")
    int SLS_FNL_VOL;
	
	@Column(name = "SLS_VAL")
    int SLS_VAL;
	
	@Column(name = "SLS_VOL_RW")
    int SLS_VOL_RW;
	
	@Column(name = "SLS_FNL_VOL_RW")
    int SLS_FNL_VOL_RW;
	
	@Column(name = "SLS_VAL_RW")
    int SLS_VAL_RW;
	
	@Column(name = "SCHEME_ID")
	String SCHEME_ID;
	
}

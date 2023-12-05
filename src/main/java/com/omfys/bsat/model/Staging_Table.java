package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_OPA_STG_TRX_DETAILS")

public class Staging_Table {


	@Id
	@Column(name = "REGN")
	private String regn;
	
	@Column(name = "DEPO_NAME")
	private String depo_name;

	@Column(name = "TERR_CODE")
	private int terr_code;
	
	@Column(name = "TERR_NAME")
	private String terr_name;
	
	@Column(name = "PRNT_CODE")
	private String prnt_code;
	
	@Column(name = "CUST_NAME")
	private String cust_name;
	
	@Column(name = "DLR_CAT")
	private String dlr_cat;
	
	@Column(name = "DLR_RET")
	private String dlr_ret;
	
	@Column(name = "DLR_SO")
	private String dlr_so;
	
	@Column(name = "SDLR_CNT")
	private int sdlr_cnt;

	@Column(name = "CHILD_CODE")
	private int child_code;
	

	@Column(name = "CUST_TYPE")
	private String cust_type;
	
	@Column(name = "PRD_GRP")
	private String prd_grp;
	
	@Column(name = "PRD_CAT")
	private String prd_cat;
	
	@Column(name = "PRODUCT")
	private String product;
	
	@Column(name = "SHADE")
	private String shade;
	
	@Column(name = "DOC_DATE")
	private Date doc_date;
	
	@Column(name = "PACK_SIZE")
	private String pack_size;
	
	@Column(name = "PRD_VOLUME")
	private int prd_volume;
	
	@Column(name = "PRD_FNL_VOLUME")
	private int prd_fnl_volume;
	
	@Column(name = "PRD_VALUE")
	private int prd_value;
	
	@Column(name = "PRD_VOL_RW")
	private int prd_vol_rw;
	
	@Column(name = "PRD_FNL_VOL_RW")
	private int prd_fnl_vol_rw;
	
	@Column(name = "PRD_SALES_VAL_RW")
	private int prd_sales_val_rw;
	
	@Column(name = "LYTY")
	private int lyty;
	
	@Column(name = "CREATED_BY")
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_UPDATE_DATE" , updatable = true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());

}

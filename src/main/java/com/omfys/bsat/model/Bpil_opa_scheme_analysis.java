package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_OPA_SCHEME_ANALYSIS")
public class Bpil_opa_scheme_analysis
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_OPA_SCHEME_ANALYSIS_S", allocationSize = 1)

	
	@Column(name = "OPA_ANALYSIS_ID")
	private int opa_analysis_id;	
	
	@Column(name = "SCHEME_ID")
	private int scheme_id;	
	
	@Column(name = "TERR_CODE")
	private String terr_code;
	
	@Column(name = "REGN")
	private String regn;
	
	@Column(name = "DEPOT")
	private String depot;
	
	@Column(name = "DLR_BILL_TO")
	private int dlr_bill_to;
	
	@Column(name = "DLR_AC_NO")
	private String dlr_ac_no;
	
	@Column(name = "DLR_NAME")
	private String dlr_name;
	
	@Column(name = "DLR_CAT")
	private String dlr_cat;	

	@Column(name = "DLR_TYPE")
	private String dlr_type;
	
	@Column(name = "REWARD_SECTION")
	private String reward_section;
	
	@Column(name = "REWARD_TYPE")
	private String reward_type;
	
	@Column(name = "PRODUCT")
	private String product;
	
	@Column(name = "UNIT")
	private String unit;	

	@Column(name = "REWARD_DATE")
	private Date reward_date;	

	@Column(name = "REWARD_LY")
	private int reward_ly;	

	@Column(name = "REWARD_TARGET")
	private int reward_target;	

	@Column(name = "REWARD_TY")
	private int reward_ty;	

	@Column(name = "ADDITIONAL")
	private int additional;	

	@Column(name = "BASE_TOTAL")
	private int base_total;	

	@Column(name = "NEXT_TGT_PENDING")
	private int next_tgt_pending;
	
	@Column(name = "ADJUSTMENTS")
	private float adjustments;
	
	@Column(name = "CONVERTED_CN_VALUE")
	private int converted_cn_value;
	
	@Column(name = "REWARD_STATUS")
	private String reward_status;
	
	@Column(name = "ADJUSTMENT_REASON")
	private String adjustment_reason;
	
	@Column(name = "GIFT_TO_CN_FLAG")
	private String gift_to_cn_flag;
	
	@Column(name = "INTERFACE_STATUS")
	private String interface_status;

	@Column(name = "REWARD_TOTAL")
	private int reward_total;
	
	@Column(name = "ATTRIBUTE1")
	private String attribute1;
	
	@Transient
	private String reward_date1;	
	
}

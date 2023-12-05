package com.omfys.bsat.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_OPA_RW_ANALYSIS_RW")
public class Bpil_Opa_Rw_Analysis_Rw {

	@EmbeddedId
    private Bpil_Opa_Rw_Analysis_Rw_Id id;
	
//	@Id
	@Column(name = "OPA_RW_AN_REWARD_ID", insertable = false,updatable = false)
	private Integer opa_analysis_id;

	@Column(name = "OPA_RW_AN_DEALER_ID")
	private String opa_rw_an_dealer_id;

	@Column(name = "REWARD_SCHEME_ID", insertable = false,updatable = false)
	private Integer scheme_id;

	@Column(name = "REWARD_DLR_REGN")
	private String regn;

	@Column(name = "REWARD_DLR_DEPOT")
	private String depot;

	@Column(name = "REWARD_DLR_TERR_CODE")
	private String terr_code;

	@Column(name = "REWARD_DLR_CODE")
	private String dlr_ac_no;

	@Column(name = "REWARD_DLR_CAT")
	private String dlr_cat;

	@Column(name = "REWARD_DLR_BILL_TO")
	private Integer dlr_bill_to;

	@Column(name = "REWARD_DLR_TYPE")
	private String dlr_type;

	@Column(name = "REWARD_DLR_NAME")
	private String dlr_name;

	@Column(name = "REWARD_SECTION")
	private String reward_section;

	@Column(name = "REWARD_TYPE")
	private String reward_type;

	@Column(name = "REWARD_PRODUCT")
	private String product;

	@Column(name = "REWARD_UNIT")
	private String unit;

	@Column(name = "REWARD_DATE")
	private Date reward_date;

	@Column(name = "REWARD_LY")
	private Integer reward_ly;

	@Column(name = "REWARD_TARGET")
	private Integer reward_target;

	@Column(name = "REWARD_TY")
	private Integer reward_ty;

	@Column(name = "REWARD_ADDITIONAL")
	private Integer additional;

	@Column(name = "REWARD_BASE_TOTAL")
	private Integer base_total;

	@Column(name = "REWARD_Q_STATUS")
	private String reward_status;

	@Column(name = "REWARD_TOTAL")
	private Integer reward_total;

	@Column(name = "REWARD_ADJUSTMENTS")
	private float adjustments;

	@Column(name = "REWARD_ADJUSTMENT_REASON")
	private String adjustment_reason;

	@Column(name = "REWARD_NEXT_TGT")
	private Integer next_tgt_pending;

	@Column(name = "REWARD_GIFT_ID")
	private String reward_gift_id;

	@Column(name = "REWARD_GIFT_TO_CN")
	private String gift_to_cn_flag;

	@Column(name = "REWARD_CONVERTED_CN")
	private Integer converted_cn_value;

	@Column(name = "REWARD_I_STATUS")
	private String interface_status;

	@Column(name = "REWARD_LAST_UPDATE")
	private Date reward_last_update;

	@Column(name = "ATTRIBUTE1")
	private String attribute1;

	@Column(name = "ATTRIBUTE2")
	private String attribute2;

	@Column(name = "ATTRIBUTE3")
	private String attribute3;

	@Column(name = "REWARD_DLR_STATE")
	private String state;

	@Column(name = "REWARD_DLR_TERR_NAME")
	private String terr_name;

	@Column(name = "REWARD_DESCRIPTION")
	private String reward_description;

	@Column(name = "REWARD_SUP_CODE")
	private String sup_code;

	@Column(name = "REWARD_SUP_NAME")
	private String sup_name;
	
	@Column(name = "REWARD_COLOR")
	private String reward_color;
	
	@Column(name = "DOC_FILE")
	private byte[] doc_file;
	
	@Column(name = "DOC_TITLE")
	private String doc_title;
	
	@Transient
	private CommonsMultipartFile doc_file2;

	@Transient
	List<Bpil_Opa_Rw_Analysis_Rw> info;

	@Transient
	private String checkapr;

	@Transient
	private String scheme_name;

	@Transient
	private String rewardDate;
	
	@Transient
	private String reward_date1;

	@Transient
	private String reward_last_update1;

}

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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_SCHEME_PRODUCT_OUTFLOW")
public class Bpil_Scheme_Product_Outflow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_SCHEME_PRODUCT_OUTFLOW_S", allocationSize = 1)
	
	@Column(name = "SCH_PRD_DTLS_ID")
	private int sch_prd_outflow_unique_id;
		
	@Column(name = "SCHEME_ID")
	private int scheme_id;
	
//	@Column(name = "SCH_PRODUCT_ID")
//	private int sch_product_id;
		
//	@Column(name = "SCH_PRODUCT_CODE")
//	private String sch_product_code;
	
	@Column(name = "SCH_PRD_LINE_TYPE")
	private String sch_prd_line_type;
	
	@Column(name = "SCH_PRD_VALUE")
	private String sch_prd_value;
	
	@Column(name = "LLY_VOL")
	private float lly_vol;
	
	@Transient
	private float lly_vol_div;
	
	@Column(name = "LLY_VAL")
	private float lly_val;
	
	@Transient
	private float lly_val_div;
	
	@Column(name = "LY_VOL")
	private float ly_vol;
	
	@Transient
	private float ly_vol_div;
	
	@Column(name = "LY_VAL")
	private float ly_val;
	
	@Transient
	private float ly_val_div;
	
	@Column(name = "SPREAD_TGT_VOL")
	private float spread_tgt_vol;
	
	@Column(name = "SPREAD_TGT_VAL")
	private float spread_tgt_val;
	
	@Column(name = "SPREAD_MTD_LY_VOL")
	private int spread_mtd_ly_vol;
	
	@Column(name = "SPREAD_MTD_LY_VAL")
	private int spread_mtd_ly_val;
	
	@Column(name = "PROJ_GRWTH_VOL_PCT")
	private float proj_grwth_vol_pct;
	
	@Column(name = "PROJ_GRWTH_VAL_PCT")
	private float proj_grwth_val_pct;
	
	@Column(name = "PROJ_GRWTH_SPD_PCT")
	private float proj_grwth_spd_pct;
	
	@Column(name = "PROJ_TY_VOL")
	private float proj_ty_vol;
	
	@Transient
	private float proj_ty_vol_div;
	
	@Column(name = "PROJ_TY_VAL")
	private float proj_ty_val;
	
	@Transient
	private float proj_ty_val_div;
	
	@Column(name = "SPREAD_MTD_TY_TGT_VOL")
	private int spread_mtd_ty_tgt_vol;
	
	@Column(name = "SPREAD_MTD_TY_TGT_VAL")
	private int spread_mtd_ty_tgt_val;
	
	@Column(name = "WT_AVG")
	private float wt_avg;
	
	@Column(name = "TOTAL_PRD_BDGT")
	private float total_prd_bdgt;
	
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

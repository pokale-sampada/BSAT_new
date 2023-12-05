package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_SCHEME_PRODUCT_DETAILS")
public class Bpil_Scheme_Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_SCHEME_PRODUCT_DETAILS_S", allocationSize = 1)
	
	@Column(name = "SCH_PRD_DTLS_ID")
	private int sch_prd_unique_id;
		
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
	
	@Column(name = "SCH_PRD_EXCEPTIONS")
	private String sch_prd_exceptions;
	
//	@Column(name = "SCH_PRODUCT_DESC")
//	private String sch_product_desc;
	
	@Column(name = "REVISION")
	private int revision;
	
	@Column(name = "VOL_GRWTH_PCT")
	private float vol_grwth_pct;
	
	@Column(name = "VAL_GRWTH_PCT")
	private float val_grwth_pct;
	
	@Column(name = "SPREAD_PCT")
	private float spread_pct;
	
	@Column(name = "SPEND_PER_LTR")
	private float spend_per_ltr;
	
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

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
@Table(name = "BPIL_SCHEME_IT_PRD_DETAILS")
public class Bpil_Scheme_IT_Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_SCHEME_IT_PRD_DETAILS_S", allocationSize = 1)
	
	@Column(name = "SCH_IT_PRD_DTLS_ID")
	private int sch_it_prd_dtls_id;
		
	@Column(name = "SCHEME_ID")
	private int scheme_id;
	
//	@Column(name = "SCH_PRODUCT_ID")
//	private int sch_product_id;
		
	@Column(name = "SCH_PRD_CODE")
	private String sch_prd_code;
	
	@Column(name = "SCH_PRD_GRP")
	private String sch_prd_grp;
	
	@Column(name = "SCH_PRD_CAT")
	private String sch_prd_cat;
	
	@Column(name = "SCH_PRD_CAT_DESC")
	private String sch_prd_cat_desc;
	
//	@Column(name = "SCH_PRODUCT_DESC")
//	private String sch_product_desc;
	
	@Column(name = "REVISION")
	private int revision;
	
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

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
@Table(name = "BPIL_SCHEME_BENEFIT_DETAILS")
public class Bpil_Scheme_Benefit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(name="course_seq", sequenceName="BPIL_SCHEME_BENEFIT_DETAILS_S", allocationSize=1)
	
	@Column(name = "SCH_DETAILS_ID")
	private int sch_details_id;
		
	@Column(name = "SCHEME_ID")
	private int scheme_id;
	
	@Column(name = "GIFT_GROUP")
	private String gift_group;
	
	@Column(name = "GIFT_ID")
	private int gift_id;
	
	@Column(name = "SCH_GIFT_CODE")
	private String sch_gift_code;

	@Column(name = "GIFT_EFFECTIVE_PRICE")
	private float gift_effective_price;
	
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
	
	@Column(name = "REVISION")
	private int revision;
	
	@Column(name = "ATTRIBUTE1")
	private String attribute1;
	
}

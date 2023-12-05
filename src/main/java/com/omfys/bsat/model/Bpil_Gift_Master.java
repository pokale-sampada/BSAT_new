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
@Table(name = "BPIL_GIFT_MASTER")
public class Bpil_Gift_Master
{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(name="course_seq", sequenceName="BPIL_GIFT_MASTER_S", allocationSize=1)
	
	@Column(name = "GIFT_ID")
	private int gift_id;
	
	@Column(name = "GIFT_CODE")
	private String gift_code;
	
	@Column(name = "GIFT_GROUP")
	private String gift_group;
	
	@Column(name = "GIFT_BRAND_NAME")
	private String gift_brand_name;
	
	@Column(name = "GIFT_NAME")
	private String gift_name;

	@Column(name = "GIFT_DESCRIPTION")
	private String gift_description;
	
	@Column(name = "GIFT_UOM")
	private String gift_uom;
	
	@Column(name = "EXT_INT_CODE")
	private String ext_int_code;
	
	@Column(name = "EFFECTIVE_PRICE")
	private int effective_price;
	
	@Column(name = "PERISHABLE_FLAG")
	private String perishable_flag;
	
	@Column(name = "DISCOUNTED_FLAG")
	private String discounted_flag;
	
	@Column(name = "WEBSTORE_FLAG")
	private String webstore_flag;
	
	@Column(name = "ACTIVE_FLAG")
	private String active_flag;
	
	@Column(name = "ATTRIBUTE1")
	private String attribute1;
	
	@Column(name = "ATTRIBUTE2")
	private String attribute2;
	
	@Column(name = "CREATED_BY", updatable = false)
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

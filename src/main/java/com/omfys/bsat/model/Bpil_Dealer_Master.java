package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_DEALER_MASTER")
public class Bpil_Dealer_Master {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(name="course_seq", sequenceName="BPIL_DEALER_MASTER_SEQ", allocationSize=1)
	@Column(name = "ORCL_DLR_ID")
	private int orcl_dlr_id;
	
	@Column(name = "DLR_AC_NO")
	private int dealer_code;
	
	@Column(name = "DLR_AC_NAME")
	private String dealer_name;
	
	@Column(name = "CUST_TYPE")
	private int customer_type;
	
	@Column(name = "DEPOT_CODE")
	private String depot_code;

	@Column(name = "PRIMARY_FLAG")
	private String primary_flag;

	@Column(name = "TERR_CODE")
	private String territory_code;
	
	@Column(name = "BILL_TO_ID")
	private int pri_bill_to_id;
	
	@Column(name = "DLR_CAT")
	private String gold_silver_code;
	
	//@Column(name = "ACTIVE_FLAG")
	//private String active_flag;
	
	@Column(name = "USER_ID")
	private int user_id;
	
	@Column(name = "ADDRESS_LINE1")
	private String address_line_1;
	
	@Column(name = "ADDRESS_LINE2")
	private String address_line_2;
	
	@Column(name = "ADDRESS_LINE3")
	private String address_line_3;

	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "PIN_CODE")
	private String pin_code;
	
	@Column(name = "CREATED_BY")
	private int created_by;
	
	@Column(name = "CREATION_DATE")
	private Date creation_date;
	
	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;
	
	@Column(name = "LAST_UPDATE_DATE")
	private Date last_update_date;

}

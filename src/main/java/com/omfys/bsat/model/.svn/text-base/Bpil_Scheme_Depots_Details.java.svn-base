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
@Table(name = "BPIL_SCHEME_DEPOT_DETAILS")
public class Bpil_Scheme_Depots_Details {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(name="course_seq", sequenceName="BPIL_SCHEME_DEPOT_DETAILS_S", allocationSize=1)
	
	@Column(name = "SCH_DEPOT_DTLS_ID")
	private int sch_depot_dtls_id;
	
	@Column(name = "SCHEME_ID")
	private int scheme_id;
	
	/*@Column(name = "SCHEME_CODE")
	private String scheme_code;*/
	
	@Column(name = "SCH_REGN")
	private String sch_regn;
	
	@Column(name = "SCH_DEPOT_ID")
	private int sch_depot_id;
	
	@Column(name = "SCH_DEPOT_CODE")
	private String sch_depot_code;

	@Column(name = "SCH_DEPOT_NAME")
	private String sch_depot_name;
	
	@Column(name = "REVISION")
	private int revision;
	
	/*@Column(name = "GIFT_ID")
	private int gift_id;
	
	@Column(name = "GIFT_CODE")
	private String gift_code;*/
	
	@Column(name = "CREATED_BY")
	private int created_by;
	
	@Column(name = "CREATION_DATE")
	private Date creation_date;
	
	@Column(name = "LAST_UPDATED_BY")
	private int LAST_UPDATED_BY;
	
	@Column(name = "LAST_UPDATE_DATE")
	private Date last_update_date;

	/*public int getGift_id() {
		return gift_id;
	}

	public void setGift_id(int gift_id) {
		this.gift_id = gift_id;
	}

	public String getGift_code() {
		return gift_code;
	}

	public void setGift_code(String gift_code) {
		this.gift_code = gift_code;
	}
*/
}

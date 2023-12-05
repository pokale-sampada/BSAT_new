package com.omfys.bsat.model;

import java.io.Serializable;
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
@Table(name = "BPIL_DEALER_MASTER_DEMO")
public class DEALERMASTERDEMO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bpil_product_dealer_demo_seq")
	@SequenceGenerator(name = "bpil_product_dealer_demo_seq", sequenceName = "BPIL_DEALER_MASTER_DEMO_S", allocationSize = 1)

	@Column(name = "DLR_ID")
	private int dlr_id;

	@Column(name = "DLR_AC_NO")
	private int dlr_ac_no;

	@Column(name = "DLR_AC_NAME")
	private String dlr_ac_name;

	@Column(name = "BILL_TO")
	private int bill_to;

	@Column(name = "CUST_TYPE")
	private String cust_type;

	@Column(name = "DEPOT_CODE")
	private String depot_code;

	@Column(name = "DLR_CAT")
	private String dlr_cat;

	@Column(name = "ADDRESS_LINE")
	private String address_line;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "PINCODE")
	private int pincode;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CONTACT")
	private int contact;

	@Column(name = "CREATION_DATE")
	private Date creation_date;

	@Column(name = "LAST_UPDATED_DATE")
	private Date last_updated_date;

	
	@Override
	public String toString() {
		return "DEALERMASTERDEMO [dlr_id=" + dlr_id + ", dlr_ac_no=" + dlr_ac_no + ", dlr_ac_name=" + dlr_ac_name
				+ ", bill_to=" + bill_to + ", cust_type=" + cust_type + ", depot_code=" + depot_code + ", dlr_cat="
				+ dlr_cat + ", address_line=" + address_line + ", city=" + city + ", state=" + state + ", country="
				+ country + ", pincode=" + pincode + ", email=" + email + ", contact=" + contact + ", creation_date="
				+ creation_date + ", last_updated_date=" + last_updated_date + "]";
	}

	public DEALERMASTERDEMO(int dlr_id, int dlr_ac_no, String dlr_ac_name, int bill_to, String cust_type,
			String depot_code, String dlr_cat, String address_line, String city, String state, String country,
			int pincode, String email, int contact, Date creation_date, Date last_updated_date) {
		super();
		this.dlr_id = dlr_id;
		this.dlr_ac_no = dlr_ac_no;
		this.dlr_ac_name = dlr_ac_name;
		this.bill_to = bill_to;
		this.cust_type = cust_type;
		this.depot_code = depot_code;
		this.dlr_cat = dlr_cat;
		this.address_line = address_line;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.email = email;
		this.contact = contact;
		this.creation_date = creation_date;
		this.last_updated_date = last_updated_date;
	}

	public DEALERMASTERDEMO() {
		super();
		// TODO Auto-generated constructor stub
	}

}

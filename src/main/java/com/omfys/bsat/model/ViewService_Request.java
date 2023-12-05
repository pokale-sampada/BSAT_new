package com.omfys.bsat.model;

import java.util.Date;

import lombok.Data;

@Data
public class ViewService_Request {
	private int service_request_number;
	private String service_request_date;
	private String complaint_date;
	private String resolution_date;
	private String service_request_status;
	private String customer_name;
	private String country_code;
	private String attribute1;
//instance Details

	private String instance_num;
	private String genset_app_code;
	private Integer genset_sr_number;
	private String engine_app_code;
	private int engine_sr_number;
	private int alternator_sr_number;

	private String installation_date;

	private String commissioning_date;

//Distributor	
	private String serviced_by;
	private String registered_by;
//Customer
	private int customer_id;
	private String customer_segment;
	private String bill_address_line1;
	private String bill_address_line2;
	private String bill_address_line3;
	private String bill_city;
	private String bill_province;
	private String bill_country;
	private String bill_zip_code;
	private String bill_email_address;
	private String bill_primary_contact_number;
	private String bill_alt_contact_number;

//Customer_Site
	private int customer_site_id;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String country;
	private String zip_code;
	private String pri_contact_number;
	private String alt_contact_number;
	private String email_address;

	// SR_Header
	private int service_request_id;
	private String service_request_type;
	private String attended_date;
	private String prev_running_hours;
	private String curr_running_hours;
	private String problem_code;
	private String problem_description;
	private String resolution_code;
	private String resolution_description;
	private String resolution_hours;
	private int total_expense_amount;
	private int total_accepted_amount;
	private String comments;
	private int distributor_id;
	private String problem_name;
	private String resolution_name;
	
	// SR_Line
	private int service_request_line_id;
	private String line_item_type;
	private String line_item_code;
	private String line_item_description;
	private String uom_code;
	private String currency_code;
	private String unit_price;
	private String quantity;
	private String total_line_amount;
	private int dist_accepted_percent;
	private int koel_accepted_percent;
	private double dist_accepted_amount;
	private double koel_accepted_line_amt;
	private String include_in_claim_flag;

}

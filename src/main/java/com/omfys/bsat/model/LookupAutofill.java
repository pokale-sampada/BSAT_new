package com.omfys.bsat.model;

import java.util.Date;

import lombok.Data;

@Data
public class LookupAutofill 
{
	private String lookup_type;
	private String active_start_date;
	private String active_end_date;
	private String enabled_flag;
	private int created_by;
	private String creation_date;
	private int last_updated_by;
	private String last_update_date;
	
	private String lookup_code;
	private String meaning;
	private String description;
	
	// for roles and access
	private int user_role_assignment_id;
	private int user_id;
	private String role;
	private String enable_flag;
	private String end_date;
	
	//menu register
	private int main_menu_id;
	private String main_menu_name;
	private String main_menu_action_name;
	private String main_menu_icon;
	
	//function register
	private int menu_id;
	private String menu_name;
	private int function_id;
	private String function_name;
	private String function_action_name;
	private String f_enable_flag;
	private String f_end_date;
	
	//report group header
	private int report_group_header_id;
	private String report_name;
	private String gr_description;
	private String header_active;
	private String header_start_date;
	private String header_end_date;
	
	//vacation rule
	private int vacation_rule_id;
	private int to_user_id;
	private String from_date;
	private String to_date;
	private String status;
	private String rule_type;
		
}

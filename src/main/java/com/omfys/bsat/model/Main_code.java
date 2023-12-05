package com.omfys.bsat.model;

import lombok.Data;

@Data
public class Main_code {

	private String list_header_id;
	private String list_name;
	
	private int depot_code;
	
	private String depot_name;
	
	public Main_code(String list_header_id, String list_name) {
		this.list_header_id = list_header_id;
		this.list_name = list_name;
	}
	
	public Main_code() {}

}

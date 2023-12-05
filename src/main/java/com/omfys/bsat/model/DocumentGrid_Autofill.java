package com.omfys.bsat.model;

import java.util.Date;

import lombok.Data;

@Data
public class DocumentGrid_Autofill {
	
	private int document_id;
	private String file_description;
	private String file_name;
	private String active_start_date;
	private String active_end_date;
	
}

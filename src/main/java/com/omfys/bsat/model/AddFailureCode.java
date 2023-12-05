package com.omfys.bsat.model;

import java.util.Date;

import lombok.Data;

@Data
public class AddFailureCode 
{
	private String parent_code;
	private String child_code;
	private String description;
	private String code_type;
	private int failure_ccid;

}

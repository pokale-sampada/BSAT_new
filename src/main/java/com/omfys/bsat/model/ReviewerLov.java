package com.omfys.bsat.model;

import lombok.Data;

@Data
public class ReviewerLov {


	private int user_id;
	private String name;
	
	public ReviewerLov(int user_id, String name) {
		this.user_id = user_id;
		this.name = name;
	}
	
	public ReviewerLov() {}

}
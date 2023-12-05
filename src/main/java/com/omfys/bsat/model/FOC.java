package com.omfys.bsat.model;

import lombok.Data;

@Data
public class FOC {

	private String SKU;
	private String description;

	@Override
	public String toString() {
		return "FOC [SKU=" + SKU + ", description=" + description + "]";
	}

	public FOC(String sKU, String description) {
		super();
		SKU = sKU;
		this.description = description;
	}

	public FOC() {
		super();
		// TODO Auto-generated constructor stub
	}

}

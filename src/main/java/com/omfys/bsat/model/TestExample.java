package com.omfys.bsat.model;

import lombok.Data;

@Data
public class TestExample {
	
	private int customer_id;
	private int sales_order_id;
	private int so_line_total;
	private String customer_company;
	private String res_line_status;
	private String status;

}

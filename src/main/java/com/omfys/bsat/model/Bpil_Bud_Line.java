package com.omfys.bsat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_BUD_LINE")
public class Bpil_Bud_Line {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@Column(name = "BUD_LID")
	private int bud_lid;
	
	@Column(name = "BUD_HID")
	private int bud_hid;
	
	@Column(name = "PRD_CAT")
	private String prd_cat;
	
	@Column(name = "BUD_AMT")
	private float bud_amt;
	
	@Column(name = "STATUS")
	private char status;

}

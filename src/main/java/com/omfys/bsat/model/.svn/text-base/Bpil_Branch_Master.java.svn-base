package com.omfys.bsat.model;

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
@Table(name = "BPIL_BRANCH_MASTER")
public class Bpil_Branch_Master {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(name="course_seq", sequenceName="BPIL_BRANCH_MASTER_SEQ", allocationSize=1)
	
	@Column(name = "BRANCH_ID")
	private int branch_id;
	
	@Column(name = "REGION_ID")
	private int region_id;
	
	@Column(name = "BRANCH_CODE")
	private String branch_code;
	
	@Column(name = "BRANCH_DESC")
	private String branch_desc;

}

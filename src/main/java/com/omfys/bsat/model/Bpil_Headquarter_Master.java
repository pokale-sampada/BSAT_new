package com.omfys.bsat.model;

import java.io.Serializable;

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
@Table(name = "BPIL_HEADQUARTER_MASTER")
public class Bpil_Headquarter_Master implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_seq")
	@SequenceGenerator(name = "region_seq", sequenceName = "BPIL_HEADQUARTER_SEQ", allocationSize = 1)

	@Column(name = "HEADQUARTER_ID")
	private int headquarter_id;

	@Column(name = "HEADQUARTER_CODE")
	private String headquarter_code;

	@Column(name = "HEADQUARTER_NAME")
	private String headquarter_name;

	@Column(name = "IS_ACTIVE")
	private String is_active;
	
}

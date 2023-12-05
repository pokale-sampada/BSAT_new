package com.omfys.bsat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_USER_PROFILES")
public class Bpil_User_Profiles implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_USER_PROFILES_S", allocationSize = 1)
	
	@Column(name = "profile_id")
	private int profile_id;
	@Column(name = "profile_name")
	private String profile_name;
	@Column(name = "description")
	private String description;
	@Column(name = "user_type")
	private String user_type;
	@Column(name = "is_active")
	private String  is_active;
	@Column(name = "created_by")
	private int created_by;
	@DateTimeFormat(pattern = "dd/MMM/yyyy")
	@Column(name = "creation_date")
	private Date creation_date;
	@Column(name = "last_updated_by")
	private int last_updated_by;
	@DateTimeFormat(pattern = "dd/MMM/yyyy")
	@Column(name = "last_update_date")
	private Date last_update_date;
	@Column(name = "attribute1")
	private String attribute1;
	@Column(name = "attribute2")
	private String attribute2;
	@Column(name = "attribute3")
	private String attribute3;
	@Column(name = "attribute4")
	private String attribute4;
	@Column(name = "attribute5")
	private String attribute5;
	@Column(name = "mapping")
	private String mapping;
	
}

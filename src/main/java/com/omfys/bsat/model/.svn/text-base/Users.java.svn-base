package com.omfys.bsat.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "USERS")
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE")
	private String role;

	@DateTimeFormat(pattern = "dd/MMM/yyyy")
	@Column(name = "CREATED_DATE")
	private Date datecreated;

	@Column(name = "CREATED_TIME")
	private String timecreated;

}

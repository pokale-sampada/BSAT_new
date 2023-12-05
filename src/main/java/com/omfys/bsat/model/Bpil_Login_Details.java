package com.omfys.bsat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_USER_LOGIN_DETAILS")
public class Bpil_Login_Details implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_USERS_LOGIN_S", allocationSize = 1) 
	@Column(name = "BPIL_LOGIN_DETAILS_ID")
	private int bpil_login_details_id;

	@ManyToOne
	@JoinColumn(name = "BPIL_USER_ID")
	private Bpil_Users bpil_user_id;

	@Column(name = "BPIL_MONTH")
	private String month;

	@Column(name = "BPIL_LOGIN_COUNT")
	private int login_count;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Bpil_Login_Details [bpil_login_details_id=" + bpil_login_details_id + ", bpil_user_id=" + bpil_user_id
				+ ", month=" + month + ", login_count=" + login_count + "]";
	}

	public Bpil_Login_Details(int bpil_login_details_id, Bpil_Users bpil_user_id, String month, int login_count) {
		super();
		this.bpil_login_details_id = bpil_login_details_id;
		this.bpil_user_id = bpil_user_id;
		this.month = month;
		this.login_count = login_count;
	}

	public Bpil_Login_Details() {
		super();
	}

}

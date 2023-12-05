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
@Table(name = "BPIL_BSAT_DEFAULTS")
public class Bpil_Bsat_Defaults implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_USERS_S", allocationSize = 1)

	@Column(name = "ID")
	private int id;

	@Column(name = "REDEMPTION_DATE")
	private String redemption_date;

	@Column(name = "FREEZE_DATE")
	private String freeze_date;

	@Column(name = "INTERFACE_DATE")
	private String interface_date;

	public Bpil_Bsat_Defaults(int id, String redemption_date, String freeze_date, String interface_date) {
		super();
		this.id = id;
		this.redemption_date = redemption_date;
		this.freeze_date = freeze_date;
		this.interface_date = interface_date;
	}

	@Override
	public String toString() {
		return "Bpil_Bsat_Defaults [id=" + id + ", redemption_date=" + redemption_date + ", freeze_date=" + freeze_date
				+ ", interface_date=" + interface_date + "]";
	}

	public Bpil_Bsat_Defaults() {
		super();
		// TODO Auto-generated constructor stub
	}

}

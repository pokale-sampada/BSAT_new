package com.omfys.bsat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_FIN_YEAR")
public class Bpil_Fin_Year {

//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
//	@SequenceGenerator(name="course_seq", sequenceName="BPIL_FIN_YEAR_SEQ", allocationSize=1)
//
//	
//	@Column(name = "FIN_YEAR_ID")
//	private int fin_year_id;
	
	@Id
	@Column(name = "FIN_YEAR")
	private int fin_year;
	
	@Column(name = "NO_OF_WEEKS")
	private int no_of_weeks;
	
	@Column(name = "START_DATE")
	private Date start_date;
	
	@Column(name = "END_DATE")
	private Date end_date;
	
	@Transient
	private String start_date1;
	
	@Transient
	private String end_date1;
	
	@Column(name = "CURRENT_YR_FLAG")
	private String current_yr_flag;
	
	@Column(name = "CREATED_BY")
	private int created_by;
	
	@Column(name = "ACTIVE_FLAG")
	private String active_flag;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_UPDATE_DATE", updatable = false)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
}

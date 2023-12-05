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

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_SCHEME_DOCS")
public class Bpil_Scheme_Doc {
		
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(name="course_seq", sequenceName="BPIL_SCHEME_DOCS_S", allocationSize=1)
	
	@Column(name = "SCHEME_DOC_ID")
	private int scheme_doc_id;
	
	@Column(name = "SCHEME_ID")
	private int scheme_id;
	
	@Column(name = "DOC_SRL_NO")
	private int doc_srl_no;
	
	@Column(name = "DOC_TYPE")
	private String doc_type;

	@Column(name = "DOC_TITLE")
	private String doc_title;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "DOC_UPLOAD_DATE" , updatable = true)
	private Date doc_upload_date = new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "ACTIVE_FLAG")
	private String active_flag;

	@Column(name = "DOC_FILE")
	private byte[] doc_file;
		
	@Column(name = "COMMENTS")
	private String comments;
	
	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "LAST_UPDATE_DATE" , updatable = true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Transient
	private String doc_upload_date1;

	@Column(name = "REVISION")
	private int revision; 
	
}

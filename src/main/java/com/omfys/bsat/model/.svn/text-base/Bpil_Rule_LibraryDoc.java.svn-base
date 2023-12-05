package com.omfys.bsat.model;

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
@Table(name = "BPIL_RULE_LIBRARY_DOCS")
public class Bpil_Rule_LibraryDoc {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(name="course_seq", sequenceName="BPIL_RULE_LIBRARY_DOCS_S", allocationSize=1)
	
	@Column(name = "RULE_DOC_ID")
	private int doc_id;
	
	@Column(name = "RULE_ID")
	private int rule_id;	

	@Column(name = "RULE_DOC_FILE")
	private byte[] doc_file;
	
	@Column(name = "RULE_DOC_NAME")
	private String doc_name;
	
	@Column(name = "RULE_DOC_TYPE")
	private String doc_type;
	
	@Column(name = "RULE_DOC_SIZE")
	private long doc_size;
	
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

}

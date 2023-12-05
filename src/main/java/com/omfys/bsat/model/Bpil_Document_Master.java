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
@Table(name = "BPIL_DOCUMENT_MASTER")
public class Bpil_Document_Master {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(name="course_seq", sequenceName="BPIL_DOCUMENT_MASTER_SEQ", allocationSize=1)
	
	@Column(name = "DOCUMENT_ID")
	private int document_id;
	
	@Column(name = "FILE_DESCRIPTION")
	private String file_description;
	
	@Column(name = "FILE_NAME")
	private String file_name;
	
	@Column(name = "FILE_TYPE")
	private String file_type;
	
	@Column(name = "FILE_SIZE")
	private Long file_size;
	
	@Column(name = "DOC_FILE")
	private byte[] doc_file;	
	
	@Column(name = "ACTIVE_START_DATE")
	private Date active_start_date;
		
	@Column(name = "ACTIVE_END_DATE")
	private Date active_end_date;
	
	@Column(name = "CREATED_BY")
	private int created_by;
	
	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date = new java.sql.Date(new java.util.Date().getTime());
		
	@Column(name = "LAST_UPDATE_DATE" , updatable = false)
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());

}

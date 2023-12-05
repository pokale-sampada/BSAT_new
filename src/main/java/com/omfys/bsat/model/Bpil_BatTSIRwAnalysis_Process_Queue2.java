package com.omfys.bsat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BPIL_RW_TSI_ANALYSIS_QUEUE2")
public class Bpil_BatTSIRwAnalysis_Process_Queue2 {

	@Id
	@Column(name = "RW_ANALYSIS_QUEUE_ID")
	private int rw_analysis_queue_id;
	
	@Column(name = "PROCESS_TYPE")
	private String process_type;
	
	@Column(name = "SCHEME_ID")
	private int scheme_id;	
	
	@Column(name = "SCHEME_CODE")
	private String scheme_code;
	
	@Column(name = "SCHEME_NAME")
	private String scheme_name;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "ATTRIBUTE1")
	private String attribute1;

	@Column(name = "ATTRIBUTE2")
	private String attribute2;
	
	@Column(name = "ATTRIBUTE3")
	private String attribute3;
	
	@Column(name = "ATTRIBUTE4")
	private String attribute4;
	
	@Column(name = "ATTRIBUTE5")
	private String attribute5;

}

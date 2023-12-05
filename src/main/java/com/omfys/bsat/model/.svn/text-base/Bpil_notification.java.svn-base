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

import lombok.Data;


@Data
@Entity
@Table(name = "BPIL_WF_NOTIFICATIONS")
public class Bpil_notification
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(name="course_seq", sequenceName="BPIL_WF_NOTIFICATIONS_S", allocationSize=1)

	@Column(name = "WF_NOTIFICATION_ID")
	private int wf_notification_id;
	
	@Column(name = "SCHEME_ID")
	private int scheme_id;
	
	@Column(name = "WF_INSTANCE_ID")
	private int wf_instance_id;
	
	@Column(name = "USER_ID")
	private int user_id;
	
	@Column(name = "CREATED_BY")
	private int created_by;
	
	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;
	
	
	@Column(name = "CREATION_DATE")
	private Date creation_date;
	
	@Column(name = "LAST_UPDATE_DATE")
	private Date last_update_date;
	
	@Column(name = "WF_NOTIFICATION_MSG")
	private String wf_notification_msg;
	
	@Column(name = "COMMENTS")
	private String comments;
	
	@Column(name = "ACTION")
	private String action;
	
	@Column(name = "STATUS")
	private String status;

}

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
@Table(name = "BPIL_SUB_MENU")
public class Bpil_Sub_Menu implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_SUB_MENU_S", allocationSize = 1)
	
	@Column(name = "sub_menu_id")
	private int sub_menu_id;
	@Column(name = "main_menu_id")
	private int main_menu_id;
	@Column(name = "sub_menu_name")
	private String sub_menu_name;
	@Column(name = "sub_menu_ctrlr_name")
	private String sub_menu_ctrlr_name;
	@Column(name = "sub_menu_action_name")
	private String sub_menu_action_name;
	@Column(name = "sub_menu_icon")
	private String sub_menu_icon;
	@Column(name = "created_by")
	private int created_by;
	@DateTimeFormat(pattern = "dd/mmm/yyyy")
	@Column(name = "creation_date")
	private Date creation_date;
	@Column(name = "last_updated_by")
	private int last_updated_by;
	@DateTimeFormat(pattern = "dd/mmm/yyyy")
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
	
}

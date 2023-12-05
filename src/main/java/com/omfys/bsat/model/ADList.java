package com.omfys.bsat.model;

import java.util.Comparator;

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
@Table(name = "ADLIST")
public class ADList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "BPIL_USERS_S", allocationSize = 1)

	@Column(name = "ID")
	private int id;

	@Column(name = "AD_ID")
	private String ad_id;

	public static Comparator<ADList> getAD()
	{
		Comparator<ADList> comp = new Comparator<ADList>(){
		     @Override
		     public int compare(ADList s1, ADList s2)
		     {
		         return s1.ad_id.compareTo(s2.ad_id);
		     }        
		 };
		 return comp;
	}

}

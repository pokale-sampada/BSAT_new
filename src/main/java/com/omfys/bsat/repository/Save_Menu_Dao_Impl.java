package com.omfys.bsat.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.omfys.bsat.model.BPIL_MENU;

@Repository("Save_Menu_Dao")
public class Save_Menu_Dao_Impl implements Save_Menu_Dao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	@Autowired
	private MenuGroupDao menudao;

	@Transactional
	public int savemenu(BPIL_MENU menugroup)
	{
		System.out.println(" in daoimpl");

		hibernateTemplate.saveOrUpdate(menugroup);
		return menugroup.getUSER_ID();
	}
	}



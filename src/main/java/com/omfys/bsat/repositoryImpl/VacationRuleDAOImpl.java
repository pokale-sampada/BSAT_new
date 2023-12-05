package com.omfys.bsat.repositoryImpl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Vacation_Rule;
import com.omfys.bsat.repository.VacationRuleDAO;

import oracle.jdbc.OracleTypes;

@Repository("VacationRuleDao")
public class VacationRuleDAOImpl implements VacationRuleDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private TilesConfiguration hibernateConfiguration;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
}

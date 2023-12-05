package com.omfys.bsat.repositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_Fin_Year;
import com.omfys.bsat.model.New_Scheme_mstr;
import com.omfys.bsat.repository.Fin_Year_Dao;


@Repository("Fin_Year_Dao")

public class Fin_Year_Dao_Impl implements Fin_Year_Dao
{

	@Autowired
	private TilesConfiguration hibernateConfiguration;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional
	public ArrayList<Bpil_Fin_Year> showall(Bpil_Fin_Year f) 
	
	{
	
		String sql = "SELECT FIN_YEAR,NO_OF_WEEKS,START_DATE,END_DATE,CURRENT_YR_FLAG,ACTIVE_FLAG FROM BPIL_FIN_YEAR ";
		
		List<Bpil_Fin_Year> dml = jdbcTemplate.query(sql, new RowMapper<Bpil_Fin_Year>() {

			@Override
			public Bpil_Fin_Year mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_Fin_Year a = new Bpil_Fin_Year();
	
				a.setFin_year(rs.getInt("FIN_YEAR"));
				a.setNo_of_weeks(rs.getInt("NO_OF_WEEKS"));
				
				
				if(rs.getDate("START_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("START_DATE"));
					a.setStart_date1(dateStr1);	
				
					try {
						System.out.println(ser1.parse(rs.getString("START_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}
				
				if(rs.getDate("END_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("END_DATE"));
					a.setEnd_date1(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("END_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}		
					
				a.setCurrent_yr_flag(rs.getString("CURRENT_YR_FLAG"));
				a.setActive_flag(rs.getString("ACTIVE_FLAG"));
				return a;
			}
			
		});
		
		return (ArrayList<Bpil_Fin_Year>) dml;
	}

	
	
	
	
	
	
	
	@Transactional
	@Override
	public void savefin(Bpil_Fin_Year f) 
	{
		System.out.println("------>in fin year dao impl");
		
		//hibernateTemplate.save(f);
		hibernateTemplate.saveOrUpdate(f);
		System.out.println("---------->in save ");
	}

	
	
	
	
	
	
	@Transactional
	@Override
	public ArrayList<Bpil_Fin_Year> showreadonly(int fin_year) 
	{
String hql = "SELECT FIN_YEAR,NO_OF_WEEKS,START_DATE,END_DATE,CURRENT_YR_FLAG,ACTIVE_FLAG FROM BPIL_FIN_YEAR where fin_year="+fin_year;
		
		List<Bpil_Fin_Year> list = jdbcTemplate.query(hql, new RowMapper<Bpil_Fin_Year>() {

			@Override
			public Bpil_Fin_Year mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_Fin_Year a = new Bpil_Fin_Year();
	
				a.setFin_year(rs.getInt("FIN_YEAR"));
				a.setNo_of_weeks(rs.getInt("NO_OF_WEEKS"));
				
				
				if(rs.getDate("START_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("START_DATE"));
					System.out.println("----------------------start date--------------------->"+dateStr1);
					a.setStart_date1(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("START_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}
				
				if(rs.getDate("END_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("END_DATE"));
					a.setEnd_date1(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("END_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}		
					
				a.setCurrent_yr_flag(rs.getString("CURRENT_YR_FLAG"));
				a.setActive_flag(rs.getString("ACTIVE_FLAG"));
				return a;
			}
			
		});
		
		return (ArrayList<Bpil_Fin_Year>) list;
	}
}




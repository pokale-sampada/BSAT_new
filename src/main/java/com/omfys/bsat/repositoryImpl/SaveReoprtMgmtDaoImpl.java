package com.omfys.bsat.repositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.repository.SaveReoprtMgmtDao;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_ReportGroup;
import com.omfys.bsat.model.Bpil_Report_FunRegi;
import com.omfys.bsat.model.Bpil_Report_Header;
import com.omfys.bsat.model.Bpil_Report_Lines;


@Repository("SaveReoprtMgmtDao")

public class SaveReoprtMgmtDaoImpl implements SaveReoprtMgmtDao {

	
	@Autowired
	HibernateTemplate hibernatetemplate;

	@Autowired
	private TilesConfiguration hibernateConfiguration;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public int savedata(Bpil_ReportGroup kwm_users)
	{
		hibernatetemplate.saveOrUpdate(kwm_users);
		
		return 1;
	}
	
	/////// header
	@Transactional
	public int savedata1(Bpil_Report_Header kwm_users)
	{
			kwm_users.setHeader_icon("menu-icon fa fa-tachometer");
						
			hibernatetemplate.saveOrUpdate(kwm_users);
		
		return kwm_users.getReport_header_id();
	}
	
	//line 
	@Transactional
	public int savedata2(int id,String[] report_line_id,String[] line_status,String[] line_name)
	{
		int infonum=0;
		for(int i=0;i<line_status.length;i++)
		{
			Bpil_Report_Lines brl=new Bpil_Report_Lines();
			
				if(report_line_id[i].length()>0 && line_status[i]!=null)
				{
					infonum = Integer.parseInt(report_line_id[i]);
				}
				else
				{
					infonum = brl.getReport_line_id();
				}
				brl.setReport_header_id(id);
				brl.setReport_line_id(infonum);
				brl.setLine_name(line_name[i]);
				brl.setActive1(line_status[i]);
				brl.setLine_icon("menu-icon fa-newspaper-o");
				
				hibernatetemplate.saveOrUpdate(brl);
				
		}
		return 1;
	}
	
	// function registration
	@Transactional
	public int savedata3(String[] report_function_id,String[] report_line_id,String[] rep_function_name,
			String[] rep_function_action_name,String[] line_status)
	{
		
		int infonum=0;
		for(int i=0;i<rep_function_name.length;i++)
		{
			Bpil_Report_FunRegi brl=new Bpil_Report_FunRegi();
			
				if(report_function_id[i].length()>0 && report_function_id[i]!=null)
				{
					infonum = Integer.parseInt(report_function_id[i]);
				}
				else
				{
					infonum = brl.getReport_function_id();
				}
				brl.setReport_line_id(Integer.parseInt(report_line_id[i]));
				brl.setReport_function_id(infonum);
				brl.setRep_function_name(rep_function_name[i]);
				brl.setRep_function_action_name(rep_function_action_name[i]);
				brl.setActive(line_status[i]);			
				
				hibernatetemplate.saveOrUpdate(brl);
				
		}
		return 1;
	}
	
	
	/// grid autofill 
	public List<Bpil_ReportGroup> grid1()
	{
		String sql = "SELECT REPORT_GROUP_ID,GROUP_NAME,ACTIVE,GROUP_START_DATE,GROUP_END_DATE FROM BPIL_REPORT_GROUP ";
		List<Bpil_ReportGroup> listContact = jdbcTemplate.query(sql, new RowMapper<Bpil_ReportGroup>() {

			@Override
			public Bpil_ReportGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_ReportGroup aContact = new Bpil_ReportGroup();
	
				aContact.setReport_group_id(rs.getInt("REPORT_GROUP_ID"));
				aContact.setGroup_name(rs.getString("GROUP_NAME"));
				aContact.setActive(rs.getString("ACTIVE"));
				
				if(rs.getDate("GROUP_START_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("GROUP_START_DATE"));
					aContact.setGroup_start_date1(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("GROUP_START_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}
				
				if(rs.getDate("GROUP_END_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("GROUP_END_DATE"));
					aContact.setGroup_end_date1(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("GROUP_END_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}		
						
				
				return aContact;
			}
			
		});
		
		return listContact;
	}
	
	public List<Bpil_Report_Header> grid2()
	{
		String sql = "SELECT REPORT_HEADER_ID,REPORT_GROUP_ID,HEADER_NAME,ACTIVE,HEADER_START_DATE,HEADER_END_DATE FROM BPIL_REPORT_HEADER ";
		List<Bpil_Report_Header> listContact = jdbcTemplate.query(sql, new RowMapper<Bpil_Report_Header>() {

			@Override
			public Bpil_Report_Header mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_Report_Header aContact = new Bpil_Report_Header();
	
				aContact.setReport_header_id(rs.getInt("REPORT_HEADER_ID"));
				aContact.setReport_group_id(rs.getInt("REPORT_GROUP_ID"));
				aContact.setHeader_name(rs.getString("HEADER_NAME"));
				aContact.setActive(rs.getString("ACTIVE"));
				
				if(rs.getDate("HEADER_START_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("HEADER_START_DATE"));
					aContact.setHeader_start_date1(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("HEADER_START_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}
				
				if(rs.getDate("HEADER_END_DATE")!=null)
				{
					DateFormat ser11 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr11 = ser11.format(rs.getDate("HEADER_END_DATE"));
					aContact.setHeader_end_date1(dateStr11);	
					try {
						System.out.println(ser11.parse(rs.getString("HEADER_END_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}	
						
				
				return aContact;
			}
			
		});
		
		return listContact;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	public Bpil_ReportGroup groupautofill(int id)
	{
				
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Bpil_ReportGroup Company_bean =  (Bpil_ReportGroup) session.load(Bpil_ReportGroup.class, id);
		
	 DateFormat cre12 = new SimpleDateFormat("dd-MM-yyyy");
		 String dateStr2 = cre12.format(Company_bean.getGroup_start_date());
		 Company_bean.setGroup_start_date1(dateStr2);	
		  try {
		 System.out.println(cre12.parse(Company_bean.getGroup_start_date1()));
		 } catch (ParseException e) {
		 	e.printStackTrace();
		 }
		  
		  DateFormat cre1 = new SimpleDateFormat("dd-MM-yyyy");
			 String dateStr = cre1.format(Company_bean.getGroup_end_date());
			 Company_bean.setGroup_end_date1(dateStr);	
			  try {
			 System.out.println(cre1.parse(Company_bean.getGroup_end_date1()));
			 } catch (ParseException e) {
			 	e.printStackTrace();
			 }
		  
				tx.commit();
				System.out.println("Company_bean in dao="+Company_bean);
				session.close();
				return Company_bean;
		
	}
	
	public Bpil_Report_Header headerautofill(int id)
	{
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Bpil_Report_Header Company_bean =  (Bpil_Report_Header) session.load(Bpil_Report_Header.class, id);
		
		DateFormat cre12 = new SimpleDateFormat("dd-MM-yyyy");
		 String dateStr2 = cre12.format(Company_bean.getHeader_start_date());
		 Company_bean.setHeader_start_date1(dateStr2);	
		  try {
		 System.out.println(cre12.parse(Company_bean.getHeader_start_date1()));
		 } catch (ParseException e) {
		 	e.printStackTrace();
		 }
		  
		  DateFormat cre1 = new SimpleDateFormat("dd-MM-yyyy");
			 String dateStr = cre1.format(Company_bean.getHeader_end_date());
			 Company_bean.setHeader_end_date1(dateStr);	
			  try {
			 System.out.println(cre1.parse(Company_bean.getHeader_end_date1()));
			 } catch (ParseException e) {
			 	e.printStackTrace();
			 }
		  
				tx.commit();
				System.out.println("Company_bean in dao="+Company_bean);
				session.close();
				return Company_bean;
		
	}
	public 	ArrayList<Bpil_Report_Lines> lineautofill(int id)
	{
		ArrayList<Bpil_Report_Lines> dml = (ArrayList<Bpil_Report_Lines>) hibernatetemplate.find("from Bpil_Report_Lines where report_header_id=?",id);
		return dml;
	}
}

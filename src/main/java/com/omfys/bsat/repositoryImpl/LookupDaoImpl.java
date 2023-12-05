package com.omfys.bsat.repositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.omfys.bsat.repository.LookupDao;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_Lookup;
import com.omfys.bsat.model.Bpil_Lookup;
import com.omfys.bsat.model.Bpil_LookupValues;
import com.omfys.bsat.model.LookupAutofill;


@Repository("LookupDao")

public class LookupDaoImpl implements LookupDao
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
	public String save_lookup(Bpil_Lookup lookup) {
		hibernateTemplate.saveOrUpdate(lookup);
		return lookup.getLookup_type();
	}

	HttpServletRequest request;
	
	@Override
	@Transactional
	public int save_lookupvalues(int user_id,int count,String lookup_type, String[] lookup_code, String[] meaning, String[] description,
			String[] active_start_date, String[] active_end_date)
	{
		
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
//			String query = "Delete from Bpil_LookupValues where lookup_type = :lookup_type";
//			Query sql = session.createQuery(query);
//			sql.setParameter("lookup_type", lookup_type);
//			sql.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		for (int i = 0; i < count; i++)
		{		
				Bpil_LookupValues val = new Bpil_LookupValues();
				
				if(lookup_code[i]!= null && lookup_code[i].length()>0)
				{					
					
				val.setLookup_type(lookup_type);
				val.setLookup_code(lookup_code[i]);
				val.setMeaning(meaning[i]);	
				val.setDescription(description[i]);	
			
				if(active_start_date[i]!=null)
				{
				 Date start_date = null;
			           try {
			        	   start_date = new SimpleDateFormat("dd-MM-yyyy").parse(active_start_date[i]);
			           } catch (ParseException e) {

			               e.printStackTrace();
			           } 			         
			           val.setActive_start_date(start_date);
				}	
				
				if(!active_end_date[i].equals(""))
				{
					System.out.println("End date in look up : "+active_end_date[i]);
				 Date end_date = null;
			           try {
			        	   end_date = new SimpleDateFormat("dd-MM-yyyy").parse(active_end_date[i]);
			           } catch (ParseException e) {

			               e.printStackTrace();
			           } 			         
			           val.setActive_end_date(end_date);
				}					
				
						val.setCreated_by(user_id);
						val.setLast_updated_by(user_id);
						val.setEnabled_flag("Y"); 
						
						hibernateTemplate.saveOrUpdate(val);
				}
		}
				
		return 1;
	}

	/////////////////////////////////////////////////////////////autofill//////////////////////////////
	@Override
	public List<Bpil_Lookup> listLookUp(String tagName) 
	{
		System.out.println("strat of implementation"+tagName);
		
		List<Map> rows = (ArrayList) jdbcTemplate.queryForList("SELECT LOOKUP_TYPE,ACTIVE_START_DATE,"
				+ "ACTIVE_END_DATE FROM BPIL_LOOKUP_TYPE WHERE LOOKUP_TYPE= ?",new Object[] {tagName});
		List<Bpil_Lookup> lookup_Autofill_list = new ArrayList<Bpil_Lookup>();
		
		for(Map row : rows){
			Bpil_Lookup Autofilllist  = new Bpil_Lookup();	
			
			Autofilllist.setLookup_type((row.get("LOOKUP_TYPE").toString()));
						
		
			
			lookup_Autofill_list.add(Autofilllist);
		}
		System.out.println("end of implementation"+tagName);

			return lookup_Autofill_list;

	}

	////////////////////////////////////////////////

	@Override
	public List<LookupAutofill> lookuplist() {
		
		String sql="SELECT LOOKUP_TYPE,ACTIVE_START_DATE,ACTIVE_END_DATE FROM BPIL_LOOKUP_TYPE";	

List<LookupAutofill> lookuplist = jdbcTemplate.query(sql, new RowMapper<LookupAutofill>() {

			@Override
			public LookupAutofill mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				System.out.println("in dao impl");

				LookupAutofill aContact = new LookupAutofill();
	
				aContact.setLookup_type(rs.getString("LOOKUP_TYPE"));
				
				DateFormat cre1 = new SimpleDateFormat("dd-MM-yyyy");
				String dateStr = cre1.format(rs.getString("ACTIVE_START_DATE"));
				aContact.setActive_start_date(dateStr);	
				try {
					
					Date dc = cre1.parse(rs.getString("ACTIVE_START_DATE").toString());
				} catch (ParseException e) {
						e.printStackTrace();
				}
				
				
				DateFormat cre3 = new SimpleDateFormat("dd-MM-yyyy");
				String dateStr3 = cre3.format(rs.getString("ACTIVE_END_DATE"));
				aContact.setActive_end_date(dateStr3);
				try {
					Date dc1 = cre1.parse(rs.getString("ACTIVE_END_DATE").toString());
				} catch (ParseException e) {			
					e.printStackTrace();
				}
			
				//aContact.setActive_start_date(rs.getString("ACTIVE_START_DATE"));
				//aContact.setActive_end_date(rs.getString("ACTIVE_END_DATE"));
				
				System.out.println(rs.getString("LOOKUP_TYPE"));

				return aContact;
			}
			
		});
		
		return lookuplist;
	}
	
	
	/*
	
	@Override
	public List<LookupAutofill> lookuplist1() {
		
		String sql="SELECT LOOKUP_TYPE,ACTIVE_START_DATE,ACTIVE_END_DATE FROM KOEL_LOOKUP_TYPE";	

List<LookupAutofill> lookuplist = jdbcTemplate.query(sql, new RowMapper<LookupAutofill>() {

			@Override
		public LookupAutofill mapRow(ResultSet rs, int rowNum) throws SQLException {
				
			
				LookupAutofill aContact = new LookupAutofill();
	
				aContact.setLookup_type(rs.getString("LOOKUP_TYPE"));
				
//				DateFormat cre1 = new SimpleDateFormat("dd-MM-yyyy");
//				String dateStr = cre1.format(rs.getString("ACTIVE_START_DATE"));
//				aContact.setActive_start_date(dateStr);	
//				try {
//					
//					Date dc = cre1.parse(rs.getString("ACTIVE_START_DATE"));
//				} catch (ParseException e) {
//						e.printStackTrace();
//				}
//				
//				
//				DateFormat cre3 = new SimpleDateFormat("dd-MM-yyyy");
//				String dateStr3 = cre3.format(rs.getString("ACTIVE_END_DATE"));
//				aContact.setActive_end_date(dateStr3);
//				try {
//					Date dc1 = cre1.parse(rs.getString("ACTIVE_END_DATE"));
//				} catch (ParseException e) {			
//					e.printStackTrace();
//				}
			
				aContact.setActive_start_date(rs.getString("ACTIVE_START_DATE"));
				aContact.setActive_end_date(rs.getString("ACTIVE_END_DATE"));
				return aContact;
			}
			
		});
		
		return lookuplist;
	}
*/
	
	@Override
	public List<LookupAutofill> lookuplist1() {
		
		String sql="SELECT LOOKUP_TYPE,ACTIVE_START_DATE,ACTIVE_END_DATE FROM BPIL_LOOKUP_TYPE";	

		List<LookupAutofill> lookuplist = jdbcTemplate.query(sql, new RowMapper<LookupAutofill>() {

			@Override
		public LookupAutofill mapRow(ResultSet rs, int rowNum) throws SQLException {
				
			
				LookupAutofill aContact = new LookupAutofill();
	
				aContact.setLookup_type(rs.getString("LOOKUP_TYPE"));
				
				if(rs.getDate("ACTIVE_START_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("ACTIVE_START_DATE"));
					aContact.setActive_start_date(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("ACTIVE_START_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}
				
				if(rs.getDate("ACTIVE_END_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("ACTIVE_END_DATE"));
					aContact.setActive_end_date(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("ACTIVE_END_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}
				
//				DateFormat cre1 = new SimpleDateFormat("dd-MM-yyyy");
//				String dateStr = cre1.format(rs.getString("ACTIVE_START_DATE"));
//				aContact.setActive_start_date(dateStr);	
//				try {
//					
//					Date dc = cre1.parse(rs.getString("ACTIVE_START_DATE"));
//				} catch (ParseException e) {
//						e.printStackTrace();
//				
//				
//				
//				DateFormat cre3 = new SimpleDateFormat("dd-MM-yyyy");
//				String dateStr3 = cre3.format(rs.getString("ACTIVE_END_DATE"));
//				aContact.setActive_end_date(dateStr3);
//				try {
//					Date dc1 = cre1.parse(rs.getString("ACTIVE_END_DATE"));
//				} catch (ParseException e) {			
//					e.printStackTrace();
//				}
			
			//	aContact.setActive_start_date(rs.getDate("ACTIVE_START_DATE"));
			//	aContact.setActive_end_date(rs.getDate("ACTIVE_END_DATE"));
				return aContact;
			}
			
		});
		
		return lookuplist;
	}
	
	@Override
	public List<LookupAutofill> lookup1(String s1) 
	{
		String sql="SELECT LOOKUP_TYPE,ACTIVE_START_DATE,ACTIVE_END_DATE FROM BPIL_LOOKUP_TYPE WHERE LOOKUP_TYPE = '"+s1+"' ";
		
		List<LookupAutofill> header_autofill = jdbcTemplate.query(sql, new RowMapper<LookupAutofill>() {

			@Override
			public LookupAutofill mapRow(ResultSet rs, int rowNum) throws SQLException {
								
				LookupAutofill header_data = new LookupAutofill();
				
				header_data.setLookup_type(rs.getString("LOOKUP_TYPE"));	
				
				
				if(rs.getDate("ACTIVE_START_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("ACTIVE_START_DATE"));
					header_data.setActive_start_date(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("ACTIVE_START_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}
				
				if(rs.getDate("ACTIVE_END_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("ACTIVE_END_DATE"));
					header_data.setActive_end_date(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("ACTIVE_END_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}					
				return header_data;
			}
			
		});
		
		return header_autofill;
		
	}	
	
	
/*
	@Override
	public List<LookupAutofill> lookup1(String s1) 
	{
		List<Map> rows = (ArrayList) jdbcTemplate.queryForList("SELECT LOOKUP_TYPE,ACTIVE_START_DATE,ACTIVE_END_DATE FROM KOEL_LOOKUP_TYPE WHERE LOOKUP_TYPE= ?",new Object[] {s1});
		List<LookupAutofill> Lookup_Autofill_list = new ArrayList<LookupAutofill>();
		
		for(Map row : rows){
			LookupAutofill Autofilllist  = new LookupAutofill();	
			
			Autofilllist.setLookup_type((row.get("LOOKUP_TYPE").toString()));			
		
			DateFormat cre1 = new SimpleDateFormat("dd-MM-yyyy");
			String dateStr = cre1.format(row.get("ACTIVE_START_DATE"));
			Autofilllist.setActive_start_date(dateStr);	
			try {
				
				Date dc = cre1.parse(row.get("ACTIVE_START_DATE").toString());
			} catch (ParseException e) {
					e.printStackTrace();
			}
			
			String dateStr3=null;
			DateFormat cre3 = new SimpleDateFormat("dd-MM-yyyy");
			if(row.get("ACTIVE_END_DATE")!=null)
			{
				 dateStr3 = cre3.format(row.get("ACTIVE_END_DATE"));
			}
			
			Autofilllist.setActive_end_date(dateStr3);
			
		
			Lookup_Autofill_list.add(Autofilllist);
		}

			return Lookup_Autofill_list;
	
	}*/


	@Override
	public List<LookupAutofill> lookup2(String s1)
	{
		
		String sql="SELECT KVL.LOOKUP_CODE,KVL.MEANING,KVL.DESCRIPTION,KVL.ACTIVE_START_DATE,KVL.ACTIVE_END_DATE FROM BPIL_LOOKUP_TYPE KLT,BPIL_LOOKUP_VALUES KVL WHERE KVL.LOOKUP_TYPE=KLT.LOOKUP_TYPE AND KVL.LOOKUP_TYPE='"+s1+"' ";
		
		List<LookupAutofill> Grid1_List_autofill = jdbcTemplate.query(sql, new RowMapper<LookupAutofill>() {

			@Override
			public LookupAutofill mapRow(ResultSet rs, int rowNum) throws SQLException {
								
				LookupAutofill Grid1_data = new LookupAutofill();
				
				Grid1_data.setLookup_code(rs.getString("LOOKUP_CODE"));			
				Grid1_data.setMeaning(rs.getString("MEANING"));	
				Grid1_data.setDescription(rs.getString("DESCRIPTION"));	
				
				if(rs.getDate("ACTIVE_START_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("ACTIVE_START_DATE"));
					Grid1_data.setActive_start_date(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("ACTIVE_START_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}
				
				if(rs.getDate("ACTIVE_END_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("ACTIVE_END_DATE"));
					Grid1_data.setActive_end_date(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("ACTIVE_END_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}
				
				return Grid1_data;
			}
			
		});
		
		return Grid1_List_autofill;
		
	}	
	
		
		
/*	@Override
	public List<LookupAutofill> lookup2(String s1)
	{		
		List<Map> rows = (ArrayList) jdbcTemplate.queryForList("SELECT KVL.LOOKUP_CODE,KVL.MEANING,KVL.DESCRIPTION,KVL.ACTIVE_START_DATE,KVL.ACTIVE_END_DATE FROM KOEL_LOOKUP_TYPE KLT,KOEL_LOOKUP_VALUES KVL WHERE KVL.LOOKUP_TYPE=KLT.LOOKUP_TYPE AND KVL.LOOKUP_TYPE=?",new Object[] {s1});
		List<LookupAutofill> Lookup_Autofill_list = new ArrayList<LookupAutofill>();
		
		for(Map row : rows){			
			LookupAutofill Autofilllist  = new LookupAutofill();	
			
			Autofilllist.setLookup_code((row.get("LOOKUP_CODE").toString()));			
			Autofilllist.setMeaning((row.get("MEANING").toString()));	
			Autofilllist.setDescription((row.get("DESCRIPTION").toString()));		
				
			DateFormat cre1 = new SimpleDateFormat("dd-MM-yyyy");
			String dateStr = cre1.format(row.get("ACTIVE_START_DATE"));
			Autofilllist.setActive_start_date(dateStr);	
			try {
				
				Date dc = cre1.parse(row.get("ACTIVE_START_DATE").toString());
			} catch (ParseException e) {
					e.printStackTrace();
			}		
			
			DateFormat cre3 = new SimpleDateFormat("dd-MM-yyyy");
			String dateStr3=null;
			if(row.get("ACTIVE_END_DATE")!=null)
			{
				dateStr3 = cre3.format(row.get("ACTIVE_END_DATE"));
			}
			 
			Autofilllist.setActive_end_date(dateStr3);	
			
			Lookup_Autofill_list.add(Autofilllist);
		}
			return Lookup_Autofill_list;
	
	}*/
	


}

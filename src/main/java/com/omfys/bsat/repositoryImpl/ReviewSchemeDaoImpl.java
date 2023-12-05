package com.omfys.bsat.repositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.repository.ReviewSchemeDao;
import com.omfys.bsat.model.New_Scheme_mstr;

@Repository("ReviewSchemeDao")




public class ReviewSchemeDaoImpl implements ReviewSchemeDao
{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public ArrayList<New_Scheme_mstr> showreviwe(int user_id, int profile_id, String PMG_ML_Group)
	{		
		ArrayList<New_Scheme_mstr> dml = new ArrayList<New_Scheme_mstr>();
		
		if(profile_id == 6){
		
//		String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE CREATED_BY = "+ user_id +" AND ( ACTIVE_FLAG='Review' OR ACTIVE_FLAG='Provisioned')";
		
		String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,SCHEME_TYPE,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE SCHEME_BUSINESS_LINE = '"+ PMG_ML_Group +"' AND ( ACTIVE_FLAG='Review' OR ACTIVE_FLAG='Provisioned')";
		
		dml = (ArrayList<New_Scheme_mstr>) jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>()
				{

					@Override
					public New_Scheme_mstr mapRow(ResultSet rs, int num) throws SQLException 
					{
						New_Scheme_mstr aContact = new New_Scheme_mstr();

						aContact.setScheme_id(rs.getInt("SCHEME_ID"));
						aContact.setScheme_code(rs.getString("SCHEME_CODE"));
						aContact.setScheme_name(rs.getString("SCHEME_NAME"));
						aContact.setScheme_type(rs.getString("SCHEME_TYPE"));
						aContact.setActive_flag(rs.getString("ACTIVE_FLAG"));
					
						if(rs.getDate("START_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("START_DATE"));
							aContact.setStart_date1(dateStr1);	
//							try {
//								System.out.println(ser1.parse(rs.getString("START_DATE")));
//							} catch (ParseException e) {
//									e.printStackTrace();
//							}
						}
						
						if(rs.getDate("END_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("END_DATE"));
							aContact.setEnd_date1(dateStr1);	
//							try {
//								System.out.println(ser1.parse(rs.getString("END_DATE")));
//							} catch (ParseException e) {
//									e.printStackTrace();
//							}
						}		
								
						return aContact;
					}
					
					
				}); 
		
	
		} else
			if(profile_id == 3){

				String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,SCHEME_TYPE,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE ( ACTIVE_FLAG='Review' OR ACTIVE_FLAG='Provisioned')";
				
				dml = (ArrayList<New_Scheme_mstr>) jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>()
						{

							@Override
							public New_Scheme_mstr mapRow(ResultSet rs, int num) throws SQLException 
							{
								New_Scheme_mstr aContact = new New_Scheme_mstr();

								aContact.setScheme_id(rs.getInt("SCHEME_ID"));
								aContact.setScheme_code(rs.getString("SCHEME_CODE"));
								aContact.setScheme_name(rs.getString("SCHEME_NAME"));
								aContact.setScheme_type(rs.getString("SCHEME_TYPE"));
								aContact.setActive_flag(rs.getString("ACTIVE_FLAG"));
							
								if(rs.getDate("START_DATE")!=null)
								{
									DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
									String dateStr1 = ser1.format(rs.getDate("START_DATE"));
									aContact.setStart_date1(dateStr1);	
//									try {
//										System.out.println(ser1.parse(rs.getString("START_DATE")));
//									} catch (ParseException e) {
//											e.printStackTrace();
//									}
								}
								
								if(rs.getDate("END_DATE")!=null)
								{
									DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
									String dateStr1 = ser1.format(rs.getDate("END_DATE"));
									aContact.setEnd_date1(dateStr1);	
//									try {
//										System.out.println(ser1.parse(rs.getString("END_DATE")));
//									} catch (ParseException e) {
//											e.printStackTrace();
//									}
								}		
										
								return aContact;
							}
							
							
						}); 
				
				

			}
		return dml;
		
	}
	
	@Override
	public ArrayList<New_Scheme_mstr> showlaunchscheme(int user_id, int profile_id, String PMG_ML_Group) {
		// TODO Auto-generated method stub
		
		ArrayList<New_Scheme_mstr> dml = new ArrayList<New_Scheme_mstr>();
		
		if(profile_id == 6){
//		String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE CREATED_BY = "+ user_id +" AND ACTIVE_FLAG='Ready To Launch'";
		
		String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE SCHEME_BUSINESS_LINE = '"+ PMG_ML_Group +"' AND ACTIVE_FLAG='Ready To Launch'";
		
		dml = (ArrayList<New_Scheme_mstr>) jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>()
				{

					@Override
					public New_Scheme_mstr mapRow(ResultSet rs, int num) throws SQLException 
					{
						New_Scheme_mstr aContact = new New_Scheme_mstr();

						aContact.setScheme_id(rs.getInt("SCHEME_ID"));
						aContact.setScheme_code(rs.getString("SCHEME_CODE"));
						aContact.setScheme_name(rs.getString("SCHEME_NAME"));
						aContact.setActive_flag(rs.getString("ACTIVE_FLAG"));
					
						if(rs.getDate("START_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("START_DATE"));
							aContact.setStart_date1(dateStr1);	
//							try {
//								System.out.println(ser1.parse(rs.getString("START_DATE")));
//							} catch (ParseException e) {
//									e.printStackTrace();
//							}
						}
						
						if(rs.getDate("END_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("END_DATE"));
							aContact.setEnd_date1(dateStr1);	
//							try {
//								System.out.println(ser1.parse(rs.getString("END_DATE")));
//							} catch (ParseException e) {
//									e.printStackTrace();
//							}
						}		
								
						return aContact;
					}
					
					
				}); 
		} else
			if(profile_id == 3){

				String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE ACTIVE_FLAG='Ready To Launch'";
				
				dml = (ArrayList<New_Scheme_mstr>) jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>()
						{

							@Override
							public New_Scheme_mstr mapRow(ResultSet rs, int num) throws SQLException 
							{
								New_Scheme_mstr aContact = new New_Scheme_mstr();

								aContact.setScheme_id(rs.getInt("SCHEME_ID"));
								aContact.setScheme_code(rs.getString("SCHEME_CODE"));
								aContact.setScheme_name(rs.getString("SCHEME_NAME"));
								aContact.setActive_flag(rs.getString("ACTIVE_FLAG"));
							
								if(rs.getDate("START_DATE")!=null)
								{
									DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
									String dateStr1 = ser1.format(rs.getDate("START_DATE"));
									aContact.setStart_date1(dateStr1);	
//									try {
//										System.out.println(ser1.parse(rs.getString("START_DATE")));
//									} catch (ParseException e) {
//											e.printStackTrace();
//									}
								}
								
								if(rs.getDate("END_DATE")!=null)
								{
									DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
									String dateStr1 = ser1.format(rs.getDate("END_DATE"));
									aContact.setEnd_date1(dateStr1);	
//									try {
//										System.out.println(ser1.parse(rs.getString("END_DATE")));
//									} catch (ParseException e) {
//											e.printStackTrace();
//									}
								}		
										
								return aContact;
							}
							
							
						}); 

			}
		
		return dml;
	}



	@Override
	public ArrayList<New_Scheme_mstr> autofillreviwe(String scheme_id) 
	{
		
		
				return null;
	}

	@Override
	public ArrayList<New_Scheme_mstr> Fin_Pending_list(int user_id, int profile_id, String PMG_ML_Group) {
		// TODO Auto-generated method stub
		
		ArrayList<New_Scheme_mstr> dml = new ArrayList<New_Scheme_mstr>();
		
		if(profile_id == 6){
		
//			String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE CREATED_BY = "+ user_id +" AND ACTIVE_FLAG='Fin Analysis Pending'";
			
			String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE SCHEME_BUSINESS_LINE = '"+ PMG_ML_Group +"' AND ACTIVE_FLAG='Fin Analysis Pending'";
		
		dml = (ArrayList<New_Scheme_mstr>) jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>()
				{

					@Override
					public New_Scheme_mstr mapRow(ResultSet rs, int num) throws SQLException 
					{
						New_Scheme_mstr aContact = new New_Scheme_mstr();

						aContact.setScheme_id(rs.getInt("SCHEME_ID"));
						aContact.setScheme_code(rs.getString("SCHEME_CODE"));
						aContact.setScheme_name(rs.getString("SCHEME_NAME"));
						aContact.setActive_flag(rs.getString("ACTIVE_FLAG"));
					
						if(rs.getDate("START_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("START_DATE"));
							aContact.setStart_date1(dateStr1);	
//							try {
//								System.out.println(ser1.parse(rs.getString("START_DATE")));
//							} catch (ParseException e) {
//									e.printStackTrace();
//							}
						}
						
						if(rs.getDate("END_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("END_DATE"));
							aContact.setEnd_date1(dateStr1);	
//							try {
//								System.out.println(ser1.parse(rs.getString("END_DATE")));
//							} catch (ParseException e) {
//									e.printStackTrace();
//							}
						}		
								
						return aContact;
					}
					
					
				}); 
		
		} else
		
		if(profile_id == 3){

			String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE  ACTIVE_FLAG='Fin Analysis Pending'";
			
			dml = (ArrayList<New_Scheme_mstr>) jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>()
					{

						@Override
						public New_Scheme_mstr mapRow(ResultSet rs, int num) throws SQLException 
						{
							New_Scheme_mstr aContact = new New_Scheme_mstr();

							aContact.setScheme_id(rs.getInt("SCHEME_ID"));
							aContact.setScheme_code(rs.getString("SCHEME_CODE"));
							aContact.setScheme_name(rs.getString("SCHEME_NAME"));
							aContact.setActive_flag(rs.getString("ACTIVE_FLAG"));
						
							if(rs.getDate("START_DATE")!=null)
							{
								DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
								String dateStr1 = ser1.format(rs.getDate("START_DATE"));
								aContact.setStart_date1(dateStr1);	
//								try {
//									System.out.println(ser1.parse(rs.getString("START_DATE")));
//								} catch (ParseException e) {
//										e.printStackTrace();
//								}
							}
							
							if(rs.getDate("END_DATE")!=null)
							{
								DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
								String dateStr1 = ser1.format(rs.getDate("END_DATE"));
								aContact.setEnd_date1(dateStr1);	
//								try {
//									System.out.println(ser1.parse(rs.getString("END_DATE")));
//								} catch (ParseException e) {
//										e.printStackTrace();
//								}
							}		
									
							return aContact;
						}
						
						
					}); 

		}
		
		return dml;
	}

	@Override
	public ArrayList<New_Scheme_mstr> Rewpro_Pending_list(int user_id, int profile_id) {
		// TODO Auto-generated method stub
		
	ArrayList<New_Scheme_mstr> dml = new ArrayList<New_Scheme_mstr>();
		
		if(profile_id == 6){
String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE CREATED_BY = "+user_id + " AND ACTIVE_FLAG='Reward Processing Pending'";
		
		dml = (ArrayList<New_Scheme_mstr>) jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>()
				{

					@Override
					public New_Scheme_mstr mapRow(ResultSet rs, int num) throws SQLException 
					{
						New_Scheme_mstr aContact = new New_Scheme_mstr();

						aContact.setScheme_id(rs.getInt("SCHEME_ID"));
						aContact.setScheme_code(rs.getString("SCHEME_CODE"));
						aContact.setScheme_name(rs.getString("SCHEME_NAME"));
						aContact.setActive_flag(rs.getString("ACTIVE_FLAG"));
					
						if(rs.getDate("START_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("START_DATE"));
							aContact.setStart_date1(dateStr1);	
//							try {
//								System.out.println(ser1.parse(rs.getString("START_DATE")));
//							} catch (ParseException e) {
//									e.printStackTrace();
//							}
						}
						
						if(rs.getDate("END_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("END_DATE"));
							aContact.setEnd_date1(dateStr1);	
//							try {
//								System.out.println(ser1.parse(rs.getString("END_DATE")));
//							} catch (ParseException e) {
//									e.printStackTrace();
//							}
						}		
								
						return aContact;
					}
					
					
				}); 
		} else
			
			if(profile_id == 3){
				String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE  ACTIVE_FLAG='Reward Processing Pending'";
				
				dml = (ArrayList<New_Scheme_mstr>) jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>()
						{

							@Override
							public New_Scheme_mstr mapRow(ResultSet rs, int num) throws SQLException 
							{
								New_Scheme_mstr aContact = new New_Scheme_mstr();

								aContact.setScheme_id(rs.getInt("SCHEME_ID"));
								aContact.setScheme_code(rs.getString("SCHEME_CODE"));
								aContact.setScheme_name(rs.getString("SCHEME_NAME"));
								aContact.setActive_flag(rs.getString("ACTIVE_FLAG"));
							
								if(rs.getDate("START_DATE")!=null)
								{
									DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
									String dateStr1 = ser1.format(rs.getDate("START_DATE"));
									aContact.setStart_date1(dateStr1);	
//									try {
//										System.out.println(ser1.parse(rs.getString("START_DATE")));
//									} catch (ParseException e) {
//											e.printStackTrace();
//									}
								}
								
								if(rs.getDate("END_DATE")!=null)
								{
									DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
									String dateStr1 = ser1.format(rs.getDate("END_DATE"));
									aContact.setEnd_date1(dateStr1);	
//									try {
//										System.out.println(ser1.parse(rs.getString("END_DATE")));
//									} catch (ParseException e) {
//											e.printStackTrace();
//									}
								}		
										
								return aContact;
							}
							
							
						}); 
			
				
			}
		
		return dml;
	}

	@Override
	public ArrayList<New_Scheme_mstr> Rew_Sch_Freeze_list(int user_id, int profile_id) {
		// TODO Auto-generated method stub
		ArrayList<New_Scheme_mstr> dml = new ArrayList<New_Scheme_mstr>();
		
			
			if(profile_id == 3){
				String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE ACTIVE_FLAG = 'Freezed' AND  EXTRACT(MONTH FROM REDEMPTION_DATE) = EXTRACT(MONTH FROM SYSDATE)";
				
				dml = (ArrayList<New_Scheme_mstr>) jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>()
						{

							@Override
							public New_Scheme_mstr mapRow(ResultSet rs, int num) throws SQLException 
							{
								New_Scheme_mstr aContact = new New_Scheme_mstr();

								aContact.setScheme_id(rs.getInt("SCHEME_ID"));
								aContact.setScheme_code(rs.getString("SCHEME_CODE"));
								aContact.setScheme_name(rs.getString("SCHEME_NAME"));
								aContact.setActive_flag(rs.getString("ACTIVE_FLAG"));
							
								if(rs.getDate("START_DATE")!=null)
								{
									DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
									String dateStr1 = ser1.format(rs.getDate("START_DATE"));
									aContact.setStart_date1(dateStr1);	
//									try {
//										System.out.println(ser1.parse(rs.getString("START_DATE")));
//									} catch (ParseException e) {
//											e.printStackTrace();
//									}
								}
								
								if(rs.getDate("END_DATE")!=null)
								{
									DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
									String dateStr1 = ser1.format(rs.getDate("END_DATE"));
									aContact.setEnd_date1(dateStr1);	
//									try {
//										System.out.println(ser1.parse(rs.getString("END_DATE")));
//									} catch (ParseException e) {
//											e.printStackTrace();
//									}
								}		
										
								return aContact;
							}
							
							
						}); 
			
				
			}
		
		return dml;
	}

	@Override
	public ArrayList<New_Scheme_mstr> Rew_Sch_Close_list(int user_id, int profile_id) {
		// TODO Auto-generated method stub
ArrayList<New_Scheme_mstr> dml = new ArrayList<New_Scheme_mstr>();
		
			
			if(profile_id == 3){
				String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE  ACTIVE_FLAG = 'Closed' AND  EXTRACT(MONTH FROM REDEMPTION_DATE) = EXTRACT(MONTH FROM SYSDATE)";
				
				dml = (ArrayList<New_Scheme_mstr>) jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>()
						{

							@Override
							public New_Scheme_mstr mapRow(ResultSet rs, int num) throws SQLException 
							{
								New_Scheme_mstr aContact = new New_Scheme_mstr();

								aContact.setScheme_id(rs.getInt("SCHEME_ID"));
								aContact.setScheme_code(rs.getString("SCHEME_CODE"));
								aContact.setScheme_name(rs.getString("SCHEME_NAME"));
								aContact.setActive_flag(rs.getString("ACTIVE_FLAG"));
							
								if(rs.getDate("START_DATE")!=null)
								{
									DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
									String dateStr1 = ser1.format(rs.getDate("START_DATE"));
									aContact.setStart_date1(dateStr1);	
//									try {
//										System.out.println(ser1.parse(rs.getString("START_DATE")));
//									} catch (ParseException e) {
//											e.printStackTrace();
//									}
								}
								
								if(rs.getDate("END_DATE")!=null)
								{
									DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
									String dateStr1 = ser1.format(rs.getDate("END_DATE"));
									aContact.setEnd_date1(dateStr1);	
//									try {
//										System.out.println(ser1.parse(rs.getString("END_DATE")));
//									} catch (ParseException e) {
//											e.printStackTrace();
//									}
								}		
										
								return aContact;
							}
							
							
						}); 
			
				
			}
		
		return dml;
	}

	

	
}
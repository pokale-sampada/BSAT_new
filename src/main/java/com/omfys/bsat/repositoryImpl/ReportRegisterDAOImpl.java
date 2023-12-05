package com.omfys.bsat.repositoryImpl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.omfys.bsat.repository.ReportRegisterDAO;
import com.omfys.bsat.model.HierarchySetUp;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.LookupAutofill;

import com.omfys.bsat.model.Vacation_Rule;

import oracle.jdbc.OracleTypes;

@Repository("ReportRegisterDAO")
public class ReportRegisterDAOImpl implements ReportRegisterDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private TilesConfiguration hibernateConfiguration;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<LookupAutofill> get_functions_list() {
		String sql = "SELECT FUNCTION_ID, FUNCTION_NAME, FUNCTION_ACTION_NAME, ENABLE_FLAG, END_DATE FROM BPIL_FUNC_REGISTER";
		List<LookupAutofill> function_list = jdbcTemplate.query(sql, new RowMapper<LookupAutofill>() {
					@Override
					public LookupAutofill mapRow(ResultSet rs, int rowNum) throws SQLException {
						LookupAutofill funcs = new LookupAutofill();
						System.out.println("sdsfgsdfgdfgdfg");
						
						funcs.setFunction_id(rs.getInt("FUNCTION_ID"));
						funcs.setFunction_name(rs.getString("FUNCTION_NAME"));
						funcs.setFunction_action_name(rs.getString("FUNCTION_ACTION_NAME"));
						funcs.setF_enable_flag(rs.getString("ENABLE_FLAG"));
						//funcs.setEnd_date(rs.getDate("END_DATE"));
						
						if(rs.getDate("END_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("END_DATE"));
							funcs.setF_end_date(dateStr1);	
							try {
								System.out.println(ser1.parse(rs.getString("END_DATE")));
							} catch (ParseException e) {
									e.printStackTrace();
							}
						}
						System.out.println("kdsjfksdjf   "+funcs.getFunction_id());
						
						
						return funcs;
					}
					
				});
				
				return function_list;
	}
	
	
	@Override
	public List<LookupAutofill> get_group_reports() {
		String sql = "SELECT REPORT_GROUP_HEADER_ID, REPORT_NAME, DESCRIPTION, HEADER_ACTIVE, HEADER_START_DATE, HEADER_END_DATE FROM BPIL_REPORT_GROUP_HEADER";
		List<LookupAutofill> group_list = jdbcTemplate.query(sql, new RowMapper<LookupAutofill>() {
					@Override
					public LookupAutofill mapRow(ResultSet rs, int rowNum) throws SQLException {
						LookupAutofill grps = new LookupAutofill();
						//System.out.println("sdsfgsdfgdfgdfg");
						
						grps.setReport_group_header_id(rs.getInt("REPORT_GROUP_HEADER_ID"));
						grps.setReport_name(rs.getString("REPORT_NAME"));
						grps.setGr_description(rs.getString("DESCRIPTION"));
						grps.setHeader_active(rs.getString("HEADER_ACTIVE"));
						if(rs.getDate("HEADER_START_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("HEADER_START_DATE"));
							grps.setHeader_start_date(dateStr1);	
							try {
								System.out.println(ser1.parse(rs.getString("HEADER_START_DATE")));
							} catch (ParseException e) {
									e.printStackTrace();
							}
						}
						
						if(rs.getDate("HEADER_END_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("HEADER_END_DATE"));
							grps.setHeader_end_date(dateStr1);	
							try {
								System.out.println(ser1.parse(rs.getString("HEADER_END_DATE")));
							} catch (ParseException e) {
									e.printStackTrace();
							}
						}
						//grps.setHeader_start_date(rs.getDate("HEADER_START_DATE"));
						//grps.setHeader_end_date(rs.getDate("HEADER_END_DATE"));
						
						//System.out.println("kdsjfksdjf   "+grps.getHeader_active());
						
						
						return grps;
					}
					
				});
				
				return group_list;
	}


	@Override
	public List<LookupAutofill> view_grp_report(int g_id) {
		String sql = "SELECT REPORT_GROUP_HEADER_ID, REPORT_NAME, DESCRIPTION, HEADER_ACTIVE, HEADER_START_DATE, HEADER_END_DATE FROM BPIL_REPORT_GROUP_HEADER WHERE REPORT_GROUP_HEADER_ID = "+g_id+"";
		List<LookupAutofill> group_list = jdbcTemplate.query(sql, new RowMapper<LookupAutofill>() {
					@Override
					public LookupAutofill mapRow(ResultSet rs, int rowNum) throws SQLException {
						LookupAutofill grps = new LookupAutofill();
						//System.out.println("sdsfgsdfgdfgdfg");
						
						grps.setReport_group_header_id(rs.getInt("REPORT_GROUP_HEADER_ID"));
						grps.setReport_name(rs.getString("REPORT_NAME"));
						grps.setGr_description(rs.getString("DESCRIPTION"));
						grps.setHeader_active(rs.getString("HEADER_ACTIVE"));
						if(rs.getDate("HEADER_START_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("HEADER_START_DATE"));
							grps.setHeader_start_date(dateStr1);	
							try {
								System.out.println(ser1.parse(rs.getString("HEADER_START_DATE")));
							} catch (ParseException e) {
									e.printStackTrace();
							}
						}
						
						if(rs.getDate("HEADER_END_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("HEADER_END_DATE"));
							grps.setHeader_end_date(dateStr1);	
							try {
								System.out.println(ser1.parse(rs.getString("HEADER_END_DATE")));
							} catch (ParseException e) {
									e.printStackTrace();
							}
						}
//						grps.setHeader_start_date(rs.getDate("HEADER_START_DATE"));
//						grps.setHeader_end_date(rs.getDate("HEADER_END_DATE"));
						
						//System.out.println("kdsjfksdjf single  "+grps.getHeader_active());
						
						
						return grps;
					}
					
				});
				
				return group_list;
	}


	

	@Override
	public List<LookupAutofill> view_funtion(int f_id) {
		String sql ="SELECT KFR.FUNCTION_ID, KFR.MENU_ID, KMR.MAIN_MENU_NAME, KFR.FUNCTION_NAME, KFR.FUNCTION_ACTION_NAME, KFR.ENABLE_FLAG, KFR.END_DATE FROM BPIL_MENU_REGISTER KMR, BPIL_FUNC_REGISTER KFR WHERE KMR.MAIN_MENU_ID = KFR.MENU_ID AND KFR.FUNCTION_ID = "+f_id+"";
		List<LookupAutofill> Function_List = jdbcTemplate.query(sql , new RowMapper<LookupAutofill>() {

					@Override
					public LookupAutofill mapRow(ResultSet rs, int rowNum) throws SQLException {
						LookupAutofill funcs = new LookupAutofill();
						
						funcs.setMenu_id(rs.getInt("MENU_ID"));
						funcs.setMenu_name(rs.getString("MAIN_MENU_NAME"));
						funcs.setFunction_id(rs.getInt("FUNCTION_ID"));
						funcs.setFunction_name(rs.getString("FUNCTION_NAME"));
						funcs.setFunction_action_name(rs.getString("FUNCTION_ACTION_NAME"));
						funcs.setF_enable_flag(rs.getString("ENABLE_FLAG"));
						if(rs.getDate("END_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("END_DATE"));
							funcs.setF_end_date(dateStr1);	
							try {
								System.out.println(ser1.parse(rs.getString("END_DATE")));
							} catch (ParseException e) {
									e.printStackTrace();
							}
						}
						
						return funcs;
					}
					
				});
				
				return Function_List;
	}


	@Override
	@Transactional
	public int addVacationRule(Vacation_Rule vacation_rule) {
		vacation_rule.getVacation_rule_id();
		hibernateTemplate.saveOrUpdate(vacation_rule);
		System.out.println("vaction id  "+vacation_rule.getVacation_rule_id());
		return 1;
	}


	
	
}

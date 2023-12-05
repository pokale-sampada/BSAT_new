package com.omfys.bsat.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.omfys.bsat.model.Bpil_BudgetVsActual;
import com.omfys.bsat.model.Bpil_BudgetVsActualDto;
import com.omfys.bsat.model.Bpil_Dealer_Master;
import com.omfys.bsat.model.Bpil_Opa_Sch_Analysis_Rw;
import com.omfys.bsat.model.Employee;
import com.omfys.bsat.model.EmployeeList;
import com.omfys.bsat.model.New_Scheme_mstr;
import com.omfys.bsat.model.SysAdmin_Users;

@Controller
public class APIController {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Autowired
	JdbcTemplate jdbcTemplate;

	Date sysdate = new java.sql.Date(new java.util.Date().getTime());
	long daydif1 = 0;

	@RequestMapping(value = "/getSchemeNames", method = RequestMethod.GET)
	public void getSchemeNames(HttpServletRequest request, Model model, HttpServletResponse response) {
		try {

			String json = null;
			
			ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
					"from New_Scheme_mstr where   active_flag = 'Active' and scheme_type <> 'TSI' order by scheme_id");

			json = new Gson().toJson(dml);
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getDealerInfo", method = RequestMethod.GET)
	public void getDealerInfo(HttpServletRequest request, Model model, HttpServletResponse response, @RequestParam(value = "bill_to_id") int bill_to_id) {
		try {

			String json = null;
			
//			ArrayList<Bpil_Dealer_Master> dml = (ArrayList<Bpil_Dealer_Master>) hibernateTemplate.find(
//					"from Bpil_Dealer_Master where pri_bill_to_id = "+bill_to_id+" and primary_flag = 'Y'");
			
			String sql = "select DLR_AC_NO, DLR_AC_NAME, BILL_TO_ID, DEPOT_CODE " + " from BPIL_DEALER_MASTER_NEW where"
					+ " BILL_TO_ID = " + bill_to_id + " And PRIMARY_FLAG = 'Y'" + " ORDER BY  DLR_AC_NAME" ;

			List<Bpil_Dealer_Master> dml = jdbcTemplate.query(sql, new RowMapper<Bpil_Dealer_Master>() {

				@Override
				public Bpil_Dealer_Master mapRow(ResultSet rs, int rowNum) throws SQLException {
					Bpil_Dealer_Master aContact = new Bpil_Dealer_Master();

					aContact.setDealer_code(Integer.parseInt(rs.getString("DLR_AC_NO")));
					aContact.setDealer_name((rs.getString("DLR_AC_NAME")));
					aContact.setPri_bill_to_id((rs.getInt("BILL_TO_ID")));
					aContact.setDepot_code((rs.getString("DEPOT_CODE")));

					return aContact;
				}

			});

			if(dml.isEmpty()){
				json = new Gson().toJson(null);
			}else{
				json = new Gson().toJson(dml.get(0));
			}
			
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getPayoutDetails", method = RequestMethod.GET)
	public void getPayoutDetails(HttpServletRequest request, Model model, HttpServletResponse response, @RequestParam(value = "deptnm") String deptnm,
			@RequestParam(value = "schnm") String schnm, @RequestParam(value = "bill_to_id") String bill_to_id) {
		try {

			String json = null;
			
//			String sql = "SELECT * FROM BPIL_OPA_SCH_ANALYSIS_RW WHERE  REWARD_SCHEME_ID = '" + schnm + "' "
//					+ " AND ( SUBSTR(OPA_SCH_AN_DEALER_ID,-3) = NVL('" + deptnm + "', SUBSTR(OPA_SCH_AN_DEALER_ID,-3)) OR "
//					+ "SUBSTR(OPA_SCH_AN_TSI_ID,-3) = NVL('" + deptnm + "', SUBSTR(OPA_SCH_AN_TSI_ID,-3)) OR "
//					+ "SUBSTR(OPA_SCH_AN_SUP_ID,-3) = NVL('" + deptnm + "', SUBSTR(OPA_SCH_AN_SUP_ID,-3)) OR "
//					+ "SUBSTR(OPA_SCH_AN_DM_ID,-3) = NVL('" + deptnm + "', SUBSTR(OPA_SCH_AN_DM_ID,-3)) ) "
//					+ "AND REWARD_SECTION <> 'FNL_SCH_EXCP' " + " ORDER BY RW_SORT, OPA_SCH_AN_REWARD_ID";
			
			String sql = "SELECT * FROM BPIL_OPA_SCH_ANALYSIS_RW " + " WHERE REWARD_SCHEME_ID = '" + schnm + "'  "
					+ " AND SUBSTR(OPA_SCH_AN_DEALER_ID,-3) = '" + deptnm + "' " + " AND OPA_SCH_AN_DEALER_ID = '"
					+ bill_to_id + "" + deptnm + "' " + " AND REWARD_SECTION <> 'FNL_SCH_EXCP' "
					+ " order by OPA_SCH_AN_REWARD_ID";

			List<Bpil_Opa_Sch_Analysis_Rw> dml = jdbcTemplate.query(sql, new RowMapper<Bpil_Opa_Sch_Analysis_Rw>() {

				@Override
				public Bpil_Opa_Sch_Analysis_Rw mapRow(ResultSet rs, int rowNum) throws SQLException {
					Bpil_Opa_Sch_Analysis_Rw aContact = new Bpil_Opa_Sch_Analysis_Rw();

					aContact.setReward_total(rs.getInt("REWARD_TOTAL"));

					aContact.setOpa_analysis_id(rs.getInt("OPA_SCH_AN_REWARD_ID"));
					aContact.setScheme_id(rs.getInt("REWARD_SCHEME_ID"));
					aContact.setRegn(rs.getString("REWARD_DLR_REGN"));
					aContact.setState(rs.getString("REWARD_DLR_STATE"));
					aContact.setDepot(rs.getString("REWARD_DLR_DEPOT"));
					aContact.setSup_code(rs.getString("REWARD_SUP_CODE"));
					aContact.setSup_name(rs.getString("REWARD_SUP_NAME"));
					aContact.setTerr_code(rs.getString("REWARD_DLR_TERR_CODE"));
					aContact.setTerr_name(rs.getString("REWARD_DLR_TERR_NAME"));
					aContact.setDlr_ac_no(rs.getString("REWARD_DLR_CODE"));
					aContact.setDlr_cat(rs.getString("REWARD_DLR_CAT"));
					aContact.setDlr_bill_to(rs.getInt("REWARD_DLR_BILL_TO"));
					aContact.setDlr_type(rs.getString("REWARD_DLR_TYPE"));
					aContact.setDlr_name(rs.getString("REWARD_DLR_NAME"));
					aContact.setReward_section(rs.getString("REWARD_SECTION"));
					aContact.setReward_type(rs.getString("REWARD_TYPE"));
					aContact.setProduct(rs.getString("REWARD_PRODUCT"));
					aContact.setUnit(rs.getString("REWARD_UNIT"));
					aContact.setReward_date(rs.getDate("REWARD_DATE"));

					if (rs.getDate("REWARD_DATE") != null) {
						DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
						String dateStr1 = ser1.format(rs.getDate("REWARD_DATE"));
						aContact.setReward_date1(dateStr1);
					}

					aContact.setReward_ly(rs.getInt("REWARD_LY"));
					aContact.setReward_target(rs.getInt("REWARD_TARGET"));
					aContact.setReward_ty(rs.getInt("REWARD_TY"));
					aContact.setAdditional(rs.getInt("REWARD_ADDITIONAL"));
					aContact.setBase_total(rs.getInt("REWARD_BASE_TOTAL"));
					aContact.setReward_status(rs.getString("REWARD_Q_STATUS"));
					aContact.setReward_description(rs.getString("REWARD_DESCRIPTION"));
					aContact.setReward_total(rs.getInt("REWARD_TOTAL"));
					aContact.setNext_tgt_pending(rs.getInt("REWARD_NEXT_TGT"));
					aContact.setGift_to_cn_flag(rs.getString("REWARD_GIFT_TO_CN"));
					aContact.setConverted_cn_value(rs.getInt("REWARD_CONVERTED_CN"));
					aContact.setInterface_status(rs.getString("REWARD_I_STATUS"));
					aContact.setReward_color(rs.getString("REWARD_COLOR"));

					aContact.setReward_last_update(rs.getDate("REWARD_LAST_UPDATE"));

					if (rs.getDate("REWARD_LAST_UPDATE") != null) {
						DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
						String dateStr1 = ser1.format(rs.getTimestamp("REWARD_LAST_UPDATE"));
						aContact.setReward_last_update1(dateStr1);
					}

					return aContact;
				}

			});

			json = new Gson().toJson(dml);
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getSalesData", method = RequestMethod.GET)
	public void getSalesData(HttpServletRequest request, Model model, HttpServletResponse response) {
		try {

			String json = null;
			
			String sql = "SELECT S_DATE,VOLUME_EUR,VOLUME_USD FROM BPIL_BUDGETVSACTUAL";

			/*List<Bpil_BudgetVsActual> data_list = new ArrayList<Bpil_BudgetVsActual>();
			ArrayList<Bpil_BudgetVsActual> dml = (ArrayList<Bpil_BudgetVsActual>) hibernateTemplate.find(
					"from Bpil_BudgetVsActual"
					+ "");*/
			List<Bpil_BudgetVsActualDto> dml = jdbcTemplate.query(sql, new RowMapper<Bpil_BudgetVsActualDto>() {

				@Override
				public Bpil_BudgetVsActualDto mapRow(ResultSet rs, int rowNum) throws SQLException {
					Bpil_BudgetVsActualDto dataobj = new Bpil_BudgetVsActualDto();
					dataobj.setS_date(rs.getDate("S_DATE"));
					dataobj.setBudget_value(rs.getDouble("VOLUME_USD"));
					dataobj.setActual_value(rs.getDouble("VOLUME_EUR"));
					//data_list.add(dataobj);
					return dataobj;
				}
			});

			json = new Gson().toJson(dml);
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getBudSalesData", method = RequestMethod.GET)
	public void getSalesData(HttpServletRequest request, Model model, HttpServletResponse response,@RequestParam(value = "from_date") String from_date, @RequestParam(value = "to_date") String to_date) {
		try {

			String json = null;
			
			String sql = "SELECT S_DATE,VOLUME_EUR,VOLUME_USD FROM BPIL_BUDGETVSACTUAL WHERE S_DATE BETWEEN "+"'"+from_date+"'"+" and "+"'"+to_date+"'";

			/*List<Bpil_BudgetVsActual> data_list = new ArrayList<Bpil_BudgetVsActual>();
			ArrayList<Bpil_BudgetVsActual> dml = (ArrayList<Bpil_BudgetVsActual>) hibernateTemplate.find(
					"from Bpil_BudgetVsActual"
					+ "");*/
			List<Bpil_BudgetVsActualDto> dml = jdbcTemplate.query(sql, new RowMapper<Bpil_BudgetVsActualDto>() {

				@Override
				public Bpil_BudgetVsActualDto mapRow(ResultSet rs, int rowNum) throws SQLException {
					Bpil_BudgetVsActualDto dataobj = new Bpil_BudgetVsActualDto();
					dataobj.setS_date(rs.getDate("S_DATE"));
					dataobj.setBudget_value(rs.getDouble("VOLUME_USD"));
					dataobj.setActual_value(rs.getDouble("VOLUME_EUR"));
					//data_list.add(dataobj);
					return dataobj;
				}
			});

			json = new Gson().toJson(dml);
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/getUserContact", method = RequestMethod.GET)
	public void getUserContact(HttpServletRequest request, Model model, HttpServletResponse response, @RequestParam(value = "user_id") int user_id) {
		try {

			String json = null;
			
//			ArrayList<Bpil_Dealer_Master> dml = (ArrayList<Bpil_Dealer_Master>) hibernateTemplate.find(
//					"from Bpil_Dealer_Master where pri_bill_to_id = "+bill_to_id+" and primary_flag = 'Y'");
			
			String sql ="select CONTACT_NUMBER from SYSADMIN_USERS where USER_ID="+user_id+"";
//			String sql1 ="SELECT CONTACT_NUMBER FROM SYSADMIN_USERS " + " WHERE USER_ID = '" + USER_ID + "'
			List<SysAdmin_Users> dml = jdbcTemplate.query(sql, new RowMapper<SysAdmin_Users>() {

				@Override
				public SysAdmin_Users mapRow(ResultSet rs, int rowNum) throws SQLException {
					SysAdmin_Users aContact = new SysAdmin_Users();
					 aContact.setContact_number(rs.getString("CONTACT_NUMBER"));
					return aContact;
				}

			});
			if(dml.isEmpty()){
				json = new Gson().toJson(null);
			}else{
				json = new Gson().toJson(dml.get(0));
			}
			
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Transactional
	@RequestMapping(value = "/tkt", method = RequestMethod.GET)
	public void tkt(HttpServletRequest request, Model model, HttpServletResponse response) {
	System.out.println("inside tkt contoller----------------");
	
	
	try {
		URL url = new URL("https://demo.omfysgroup.com/mindsconnect_uat/employeeDetails");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		System.out.println("All Well 1");
		int responsecode = conn.getResponseCode();
		if (responsecode != 200) {
			System.out.println("All  not Well 1");
			throw new RuntimeException("HttpResponseCode: " + responsecode);
		} else {
			System.out.println("All Well 2");
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			System.out.println("output from server");
			String output;
			ObjectMapper mapper = new ObjectMapper();
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				
				  String jsonData = "{\"languages\" : [{\"name\": \"Java\", \"description\":"  
			                + " \" Java is a class-based high-level programming language that"  
			                + " follows the OOPs concepts.\"},{\"name\": \"Javascript\","  
			                + "\"description\": \"JavaScript is also a high-level, often "  
			                + "just-in-time compiled, and multi-paradigm programming language."  
			                + "\"},{\"name\": \"Python\",\"description\": \"Python is another "  
			                + "high-level, interpreted and general-purpose programming language."  
			                + "\"}]}";  
				JSONObject jsnobject = new JSONObject(jsonData);
				System.out.println("JSON Object");  
		        System.out.println(jsnobject);
		        //Getting languages JSON array from the JSON object  
		        JSONArray jsonArray = jsnobject.getJSONArray("languages");  
		        //Printing JSON array  
		        System.out.println("JSON Array");  
		        System.out.println(jsonArray);
		        Employee e=new Employee();
		        EmployeeList el=new EmployeeList();
		        int length = jsonArray.length();
		        System.out.println(length+"         length of jsonArray");
		        for (Object object : jsonArray) {
		        	 for(int i=0;i<length;i++)  
		             {  
		                  System.out.println("object["+i+"] = " +jsonArray.getJSONObject(i).getString("name")); 
		                  
		                  e.setID(2);
		                  e.setEMP_ID("23");
		                  e.setCREATED_BY("1");
		                  e.setEMAIL("amit.k@omfysgroup.com");
		                  e.setEMP_CODE("OMI-0085"); 
		                  e.setNAME(jsonArray.getJSONObject(i).getString("name"));
		                  e.setDESCRIPTION(jsonArray.getJSONObject(i).getString("description"));        
		             } 
		        	System.out.println("After");
		        	
		        		
				}
		        System.out.println(e.toString());
		        try {
					hibernateTemplate.save(e);
					  System.out.println("oooooooooooooooooooooooo");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        System.out.println("------------------------------");	
	
				
			}
			 String userDataJSON = "[{\"emp_id\":\"21\",\"created_by\": \"1\",\"creation_date\":\"2019-06-03 15:20:47.97\"},"
                     + "{\"email\": \"amit.k@omfysgroup.com\",\"emp_code\":\"OMI-0085\",\"emp_first_name\": \"Pratik\"}]";
			   
				
//			List<Employee> emplist = mapper.readValue(output, new TypeReference<List<Employee>>() {});
//			System.out.println(emplist.toString());
			conn.disconnect();

		}
	}

	catch (Exception e) {
		e.printStackTrace();
	}

	}


}

package com.omfys.bsat.controller;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Vacation_Rule;

import com.omfys.bsat.service.VacationRuleService;

import oracle.jdbc.OracleTypes;

@Controller
public class VacationRuleController {
	@Autowired
	VacationRuleService serviceVacationService;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private TilesConfiguration hibernateConfiguration;
	
	@Autowired
	private SessionFactory sessionFactory;
	
//	@RequestMapping("/vacationrule")
//	public ModelAndView newsetup(HttpServletRequest request, ModelMap map, Model model) {
//		
//		Vacation_Rule vacationRule = new Vacation_Rule();
//		 map.addAttribute("vacationRule",vacationRule);
//		 
//		 int user_id = (Integer) request.getSession().getAttribute("userid");
//		 System.out.println("Vacation Rule   "+user_id);
//		 List<Vacation_Rule> vacation_list = serviceVacationService.view_vacation(user_id);
//		 map.addAttribute("vacation_list",vacation_list);
//		
//		return new ModelAndView("VacationRule");
//	}
	
//	 @RequestMapping(value = "/loadUsers", method = RequestMethod.GET)
//     public
//     @ResponseBody
//     List<Vacation_Rule> loadUserName(HttpServletRequest request, HttpServletResponse response)  {
//    	 List<Vacation_Rule> users = new ArrayList<>();
//    	 String json = null;
//    	 CallableStatement cStmt;
//    	 try {
//    		 
//    		 cStmt = hibernateConfiguration.dataSource().getConnection().prepareCall("{call KOEL_SP_USER_LIST(?)}");
//    	        cStmt.registerOutParameter(1, OracleTypes.CURSOR);
//    	        ResultSet result = cStmt.executeQuery();
//    	       
//    	 		ResultSet rs1 = (ResultSet) cStmt.getObject(1);
//    	 		while (rs1.next()) {
//    	 			int data = rs1.getInt(1);
//    				String data1 = rs1.getString(2);
//    				users.add(new Vacation_Rule(data, data1));
//    	 		}
//    	        } catch (SQLException e) {
//    	        e.printStackTrace();
//    	        }
//    	        catch (Exception e) {
//    	        System.out.println(e.getMessage());
//    	        }
//    	 	for (Vacation_Rule vc : users) {
//				System.out.println(vc.getTo_user_id() + " data" + vc.getTo_user_name());
//			}				
//			
//	
//			return users;
//     }
	 
	 
//	 @RequestMapping(value = "/newVacationRule", method = RequestMethod.POST)
//		public ModelAndView saveVacationRule(@ModelAttribute Vacation_Rule vacationRule, BindingResult resultVacation_Rule, 
//				ModelMap map, HttpServletRequest request) throws ParseException
//	 {
//		 int rule=0;
//		 String kwm_user = (String) request.getSession().getAttribute("kwm_user");		
//			if (kwm_user != null) {
//				
//				 int user_id = (Integer) request.getSession().getAttribute("userid");
//				 
//			//	int logged_in  = Integer.parseInt(kwm_user);
//				
//				vacationRule.setFrom_user_id(user_id);
//										
//				String rule_type = request.getParameter("rule_type");
//				String status=request.getParameter("status");
//				int user_to=Integer.parseInt(request.getParameter("to_user_id"));
//				
//				vacationRule.setRule_type(rule_type);
//				vacationRule.setStatus(status);
//				vacationRule.setTo_user_id(user_to);
//		
//				Date fromdate= new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("from_date"));
//				vacationRule.setFrom_date(fromdate);
//				
//				Date todate= new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("to_date"));
//				vacationRule.setTo_date(todate);
//				
//				vacationRule.setLast_updated_by(user_id);
//				vacationRule.setCreated_by(user_id);
//				
//				rule = serviceVacationService.addVacationRule(vacationRule);
//				System.out.println(""+rule);
//				
//			}
//			int user_id = (Integer) request.getSession().getAttribute("userid");
//			List<Vacation_Rule> vacation_list = serviceVacationService.view_vacation(user_id);
//			 map.addAttribute("vacation_list",vacation_list);
//		 return new ModelAndView("VacationRule");
//	 }
	 
	 //////////////////////////////////////// Menu Group-Pramila /////////////////////////////////
	 
	
	 
}
	


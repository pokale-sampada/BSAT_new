package com.omfys.bsat.controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.omfys.bsat.repository.SaveReoprtMgmtDao;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_MenuGroup;
import com.omfys.bsat.model.Bpil_ReportGroup;
import com.omfys.bsat.model.Bpil_Report_FunRegi;
import com.omfys.bsat.model.Bpil_Report_Header;
import com.omfys.bsat.model.Bpil_Report_Lines;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.Useraccess_userlist;
import com.omfys.bsat.service.BpilLoginService;
import java.util.Date;
import oracle.jdbc.OracleTypes;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
@Controller
public class SaveReoprtMgmtController {

	@Autowired
	SaveReoprtMgmtDao savereoprtmgmt;
	
	@Autowired
	 private HibernateTemplate  hibernateTemplate; 
	
	/*------------------------------------- Report Group  -----------------------------------------------------*/

	//open report group grid
	@RequestMapping("/reportgroup")		
	public ModelAndView reportgroup(HttpServletRequest request,Model model) {
	List<Bpil_ReportGroup> dml = savereoprtmgmt.grid1();

		model.addAttribute("rep_grp_list",dml);
		 return new ModelAndView("Bpil_ReportGroupGrid");
		//return new ModelAndView("SchemeRequest");
	}
	
	
//save report group
	
	@RequestMapping("/newreportgroup")		
	public ModelAndView newreportgroup(HttpServletRequest request, ModelMap map,Model model) {
				
		 return new ModelAndView("Bpil_ReportGroup");		
	}
			
	@RequestMapping(value = "/save_reportgroup", method = RequestMethod.POST)
	public ModelAndView save_reportgroup(@ModelAttribute("Bpil_ReportGroup") Bpil_ReportGroup kwm_users,
			BindingResult resultkwm_users ,	HttpServletRequest request,Model model) {
		
		int user_id = (Integer) request.getSession().getAttribute("userid");	
		
		Date startdate = null;
		try {
			if (!request.getParameter("group_start_date").equals("")) {
				startdate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("group_start_date"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date enddate = null;
		try {
			if (!request.getParameter("group_end_date").equals("")) {
				enddate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("group_end_date"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		kwm_users.setGroup_start_date(startdate);
		kwm_users.setGroup_end_date(enddate);
		kwm_users.setCreated_by(user_id);
		kwm_users.setLast_updated_by(user_id);
			int id = savereoprtmgmt.savedata(kwm_users);
		
		// return new ModelAndView("Bpil_ReportGroup");
			return new ModelAndView("redirect:/reportgroup");
		
	}
	
	//for update autofill
	@RequestMapping("/updatereportgroup")		
	public ModelAndView updatereportgroup(@RequestParam(value="report_group_id") String report_group_id,HttpServletRequest request,Model model) {
	
		int grp_id = Integer.parseInt(report_group_id);
		Bpil_ReportGroup dml = savereoprtmgmt.groupautofill(grp_id);
		
		model.addAttribute("JSON",dml);
		
		 return new ModelAndView("Bpil_ReportGroup");		
	}
/*-------------------------------------Save menu header & line(main menu & sub menu) -----------------------------------------------------*/

	//open menu header report grid
		@RequestMapping("/reportheaderline")		
		public ModelAndView reportheaderline(HttpServletRequest request,Model model) {
			List<Bpil_Report_Header> dml = savereoprtmgmt.grid2();

			model.addAttribute("rep_grp_list",dml);
			 return new ModelAndView("ReportHeaderLineGrid");		
		}
		
	
	//save menu header line

	@RequestMapping("/newreportheaderline")
	public ModelAndView ReportHeaderLine(HttpServletRequest request, ModelMap map,Model model) {
				
		 return new ModelAndView("ReportHeaderLine");		
	}
	//load group id
	
	
	@RequestMapping(value = "/getgroupid", method = RequestMethod.GET)
	public void getgroupid(HttpServletRequest request,Model model,HttpServletResponse response) {
								
		 	try {
		 		
	ArrayList<Bpil_ReportGroup> dml = (ArrayList<Bpil_ReportGroup>) hibernateTemplate.find("from Bpil_ReportGroup");
			 
			 String json = null;
			 
			 json = new Gson().toJson(dml);
			 response.setContentType("application/json");
			 response.getWriter().write(json);
			 } catch (IOException e) {
			 	e.printStackTrace();
			 }
		
	}
	@RequestMapping(value = "/save_reportheaderline", method = RequestMethod.POST)
	public ModelAndView save_reportheaderline(@ModelAttribute("Bpil_Report_Header") Bpil_Report_Header kwm_users,
			BindingResult resultkwm_users1 ,HttpServletRequest request,Model model) {
		
		int user_id = (Integer) request.getSession().getAttribute("userid");	
		
		Date startdate = null;
		try {
			if (!request.getParameter("header_start_date").equals("")) {
				startdate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("header_start_date"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date enddate = null;
		try {
			if (!request.getParameter("header_end_date").equals("")) {
				enddate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("header_end_date"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		kwm_users.setHeader_start_date(startdate);
		kwm_users.setHeader_end_date(enddate);
		kwm_users.setCreated_by(user_id);
		kwm_users.setLast_updated_by(user_id);
		
				int id = savereoprtmgmt.savedata1(kwm_users);
				System.out.println("header id="+id);
				
				
			String[] report_line_id = request.getParameterValues("report_line_id");
			String[] line_status  = request.getParameterValues("line_status");
			String[] line_name  = request.getParameterValues("line_name");
			
			int id1 = savereoprtmgmt.savedata2(id,report_line_id,line_status,line_name);
				
		// return new ModelAndView("ReportHeaderLine");
			return new ModelAndView("redirect:/reportheaderline");
	}
	
	//for update autofill
		@RequestMapping("/updatereportheader")		
		public ModelAndView updatereportheader(@RequestParam(value="report_header_id") String report_header_id,HttpServletRequest request,Model model) {
		
			int grp_id = Integer.parseInt(report_header_id);
			Bpil_Report_Header dml = savereoprtmgmt.headerautofill(grp_id);
			ArrayList<Bpil_Report_Lines> line= savereoprtmgmt.lineautofill(grp_id);
			
			int line_id = dml.getReport_group_id();
			ArrayList<Bpil_ReportGroup> linedata = (ArrayList<Bpil_ReportGroup>) hibernateTemplate.find("from Bpil_ReportGroup where report_group_id=?",line_id);

			String line_name =linedata.get(0).getGroup_name();
			
			model.addAttribute("group_name",line_name);
			
			
			model.addAttribute("JSON",dml);
			model.addAttribute("rep_grp_list",line);
			
			 return new ModelAndView("ReportHeaderLine");		
		}
	/*-------------------------------------function register ---------------------------------------------------------------*/
	
	
	//open report function grid
			@RequestMapping("/reportfunction")		
			public ModelAndView reportfunction(HttpServletRequest request,Model model) {
				ArrayList<Bpil_Report_FunRegi> dml = (ArrayList<Bpil_Report_FunRegi>) hibernateTemplate.find("from Bpil_Report_FunRegi");

				model.addAttribute("rep_grp_list",dml);
				 return new ModelAndView("ReportFunctionGrid");		
			}
			
//save	
	@RequestMapping("/newreportfunction")
		public ModelAndView newreportfunction(HttpServletRequest request, ModelMap map,Model model) {
					
			 return new ModelAndView("ReportFunction");		
		}
		
		@RequestMapping(value = "/save_reportfunction", method = RequestMethod.POST)
		public ModelAndView save_reportfunction(HttpServletRequest request,Model model) {
			int user_id = (Integer) request.getSession().getAttribute("userid");	
							
				String[] report_function_id = request.getParameterValues("report_function_id");
				String[] report_line_id  = request.getParameterValues("report_line_id");
				String[] rep_function_name  = request.getParameterValues("rep_function_name");
				String[] rep_function_action_name  = request.getParameterValues("rep_function_action_name");
				String[] line_status  = request.getParameterValues("line_status");

				
				int id1 = savereoprtmgmt.savedata3(report_function_id,report_line_id,rep_function_name,rep_function_action_name,line_status);
					
			// return new ModelAndView("ReportFunction");
				return new ModelAndView("redirect:/reportfunction");
		}
		
		@RequestMapping(value = "/loadsubmenuname", method = RequestMethod.GET)
		public void loadsubmenuname(HttpServletRequest request,Model model,HttpServletResponse response) {
									
			 	try {
			 		
		ArrayList<Bpil_Report_Lines> dml = (ArrayList<Bpil_Report_Lines>) hibernateTemplate.find("from Bpil_Report_Lines");
				 
				 String json = null;
				 
				 json = new Gson().toJson(dml);
				 response.setContentType("application/json");
				 response.getWriter().write(json);
				 } catch (IOException e) {
				 	e.printStackTrace();
				 }
			
		}
		
		//for update autofill
		@RequestMapping("/updatereportfunction")		
		public ModelAndView updatereportfunction(@RequestParam(value="report_function_id") String report_function_id,HttpServletRequest request,Model model) {
		
			int id = Integer.parseInt(report_function_id);
			
			ArrayList<Bpil_Report_FunRegi> dml = (ArrayList<Bpil_Report_FunRegi>) hibernateTemplate.find("from Bpil_Report_FunRegi where report_function_id=?",id);

			int line_id=dml.get(0).getReport_line_id();
			ArrayList<Bpil_Report_Lines> linedata = (ArrayList<Bpil_Report_Lines>) hibernateTemplate.find("from Bpil_Report_Lines where report_line_id=?",line_id);

			String line_name =linedata.get(0).getLine_name();
			model.addAttribute("rep_grp_list",dml);
			model.addAttribute("line_name",line_name);
			
			 return new ModelAndView("ReportFunction");		
		}
}

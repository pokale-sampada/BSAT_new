package com.omfys.bsat.controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import com.omfys.bsat.repository.HierarchySetUpDao;
import com.omfys.bsat.repository.MenuRegisterDao;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.HierarchySetUp;
import com.omfys.bsat.model.HierarchySetUp1;


import com.omfys.bsat.service.LookUpService;

//import org.apache.lucene.search.FieldCache.IntParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HierarchySetUpController {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private HierarchySetUpDao contactDAO;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	private TilesConfiguration hibernateConfiguration;

	@RequestMapping(value="/hierarchysetup")
	public ModelAndView hierarchysetup(ModelAndView model,ModelMap map) throws IOException
	{

		HierarchySetUp1 hierarchysetup=new HierarchySetUp1();
		map.addAttribute("hierarchysetup",hierarchysetup);		
		List<HierarchySetUp1> HierarchySetUp_list = contactDAO.HierarchySetUp_List1();
		map.addAttribute("HierarchySetUp_list",HierarchySetUp_list);
		model.setViewName("HierarchySetUp");
		return new ModelAndView("HierarchySetUp");
		
	}

	
	/*
	@Transactional
	@RequestMapping(value = "/updatehierarchy", method = RequestMethod.POST)
	public ModelAndView updatehierarchy(@ModelAttribute MenuRegister menuregister, BindingResult result, 
			ModelMap map, HttpServletRequest request) throws ParseException
	{

		
		 String hid[] = request.getParameterValues("wf_hierarchy_id");
		 String aprorder[] =request.getParameterValues("apr_order");
		 int rowcount=hid.length;
			System.out.println("Rowcount  "+rowcount);
			
			for (int i = 0; i < rowcount; i++) {
				
				HierarchySetUp SR = new HierarchySetUp();
					SR.setWf_hierarchy_id(Integer.parseInt(hid[i]));
					SR.setApr_order(Integer.parseInt(aprorder[i]));
					 String query="update KOEL_APRL_HIERARCHY set APR_ORDER="+SR.getApr_order()+" where WF_HIERARCHY_ID="+SR.getWf_hierarchy_id()+""; 

					jdbcTemplate.update(query);
				}
			


		return new ModelAndView("redirect:callorder");
		
	
	}
	
	@Transactional
	@RequestMapping(value = "/callorder", method = RequestMethod.GET)
	public ModelAndView updatehierarchy1(@ModelAttribute MenuRegister menuregister, BindingResult result, 
			ModelMap map, HttpServletRequest request) throws ParseException
	{

		


	 		CallableStatement cStmt;
	 		try {
	 		cStmt = hibernateConfiguration.dataSource().getConnection().prepareCall("{call KOEL_UPDATE_HIERARCHY()}");
	 		
	 		cStmt.executeQuery();
	 		}
	 		 catch (SQLException e) {
	 		e.printStackTrace();
	 		System.out.println(e);
	 		}
	 		catch (Exception e) {
	 		System.out.println(e.getMessage());
	 		}

		return new ModelAndView("redirect:hierarchysetup");
		
	
	}*/
	
	@Transactional
	@RequestMapping(value = "/addhierarchy", method = RequestMethod.POST)
	public ModelAndView savehierarchy(@ModelAttribute HierarchySetUp hierarchysetup, BindingResult result, 
			ModelMap map, HttpServletRequest request) throws ParseException
	{
		
		int user_id = (Integer) request.getSession().getAttribute("userid");
		hierarchysetup.setCreated_by(user_id);
		hierarchysetup.setLast_updated_by(user_id);

		hibernateTemplate.save(hierarchysetup);

		return new ModelAndView("redirect:callorder");
		
	
	}
	//deletehierachy?Hierarchy_Id
	
	@Transactional
	@RequestMapping(value = "/deletehierachy", method = RequestMethod.GET)
	public ModelAndView deletehierarchy(@ModelAttribute HierarchySetUp hierarchysetup, BindingResult result, 
			ModelMap map, HttpServletRequest request) throws ParseException
	{
		int Hierarchy_Id = Integer.parseInt(request.getParameter("Hierarchy_Id"));
		
		System.out.println("hierarchy id is "+Hierarchy_Id);
		 String query="DELETE FROM KOEL_APRL_HIERARCHY WHERE WF_HIERARCHY_ID ="+Hierarchy_Id+""; 

			jdbcTemplate.update(query);
		

		//hibernateTemplate.save(hierarchysetup);

		return new ModelAndView("redirect:callorder");
		
	
	}
	
}
	

	


package com.omfys.bsat.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
import com.omfys.bsat.repository.SchemeMasterDao;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_Gift_Master;
import com.omfys.bsat.model.Bpil_LookupValues;
import com.omfys.bsat.model.Bpil_User_ProfileId_List;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.New_Scheme_mstr;

@Controller
public class NewSchemeRewardController {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	SchemeMasterDao schememasterdao;

	@Autowired
	private TilesConfiguration hibernateConfiguration;

	@RequestMapping(value = "/schemerewardgrid")
	public ModelAndView schemerewardgrid(HttpServletRequest request,Model model,HttpServletResponse response) 
	{
		
		ArrayList<Bpil_Gift_Master> dml = (ArrayList<Bpil_Gift_Master>) hibernateTemplate.find("from Bpil_Gift_Master ORDER BY gift_group");
		model.addAttribute("giftmasterlist",dml);
		
		return new ModelAndView("schemerewardgrid");
	}
	
	@RequestMapping("/giftdetails")
	public ModelAndView giftdetails(@RequestParam(value="gift_id") String gift_id, ModelMap map,Model model,HttpServletRequest request)
	{
		ArrayList<Bpil_Gift_Master> dml = (ArrayList<Bpil_Gift_Master>) hibernateTemplate.find("from Bpil_Gift_Master where gift_id = '"+gift_id+"'");

		Bpil_Gift_Master gift = dml.get(0);
		
		model.addAttribute("JSON",gift);
		
		
		return new ModelAndView("NewSchemeReward");
	}
	
	@RequestMapping(value = "/schemereward")
	public ModelAndView sub1() 
	{
		return new ModelAndView("NewSchemeReward");
	}
	
	@RequestMapping(value = "/schemereward1")
	public ModelAndView sub2() 
	{
		return new ModelAndView("NewSchemeReward1");
	}
	
	
	@Transactional
	@RequestMapping(value = "/save_scheme_reward",method=RequestMethod.POST)
	public ModelAndView save_scheme_reward(@ModelAttribute("Bpil_Gift_Master") Bpil_Gift_Master bpil_gift_master,BindingResult result,HttpServletRequest request ) 
	{
		int user_id = (Integer) request.getSession().getAttribute("userid");
		bpil_gift_master.setExt_int_code("INTERNAL");
		bpil_gift_master.setPerishable_flag("N");
		bpil_gift_master.setDiscounted_flag("N");
		bpil_gift_master.setWebstore_flag("N");
		bpil_gift_master.setActive_flag("Y");
		bpil_gift_master.setCreated_by(user_id);
		bpil_gift_master.setLast_updated_by(user_id);
		hibernateTemplate.saveOrUpdate(bpil_gift_master);
		return new ModelAndView("redirect:/schemerewardgrid");
	}
	
	@Transactional
	@RequestMapping(value = "/save_scheme_reward1",method=RequestMethod.POST)
	public ModelAndView save_scheme_reward1(@ModelAttribute("Bpil_Gift_Master") Bpil_Gift_Master bpil_gift_master,BindingResult result,HttpServletRequest request,ModelMap map,Model model ) 
	{
		int user_id = (Integer) request.getSession().getAttribute("userid");
		bpil_gift_master.setExt_int_code("INTERNAL");
		bpil_gift_master.setPerishable_flag("N");
		bpil_gift_master.setDiscounted_flag("N");
		bpil_gift_master.setWebstore_flag("N");
		bpil_gift_master.setActive_flag("Y");
		bpil_gift_master.setCreated_by(user_id);
		bpil_gift_master.setLast_updated_by(user_id);
		hibernateTemplate.saveOrUpdate(bpil_gift_master);
		
		return new ModelAndView("redirect:/schemereward1");
	}
	
	
	@RequestMapping(value = "/loadgiftgroup", method = RequestMethod.GET)
	public void loadschemedata(HttpServletRequest request,Model model,HttpServletResponse response) {
								
		 	try {
	ArrayList<Bpil_LookupValues> dml = (ArrayList<Bpil_LookupValues>) hibernateTemplate.find("from Bpil_LookupValues where lookup_type='GIFT_GROUP'");
			 
	System.out.println("sizeeeeeeeeeeeeeeeeeeeeeeeeeeeeee "+dml.size());
			 String json = null;
			 
			 json = new Gson().toJson(dml);
			 response.setContentType("application/json");
			 response.getWriter().write(json);
			 } catch (IOException e) {
			 	e.printStackTrace();
			 }
		
	}
}

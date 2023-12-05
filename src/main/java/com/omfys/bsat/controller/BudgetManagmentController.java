package com.omfys.bsat.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BudgetManagmentController {
	@Autowired
	HibernateTemplate HibernateTemplate;

	@RequestMapping("/budgetmanagment")
	public ModelAndView budgetManagment(HttpServletRequest request, Model model, ModelMap map) {
		return new ModelAndView("BudgetManagment");
	}
	@RequestMapping("/newbudget")
	public ModelAndView newbudget(HttpServletRequest request, Model model, ModelMap map) {
		return new ModelAndView("newbudget");
	}
}

package com.omfys.bsat.controller;

import java.io.IOException;
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
import javax.transaction.Transactional;

import com.google.gson.Gson;
import com.omfys.bsat.repository.MenuRegisterDao;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.LookupAutofill;


import com.omfys.bsat.model.User_pref;
import com.omfys.bsat.service.LookUpService;
import com.omfys.bsat.service.MenuRegisterService;

import oracle.jdbc.OracleTypes;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MenuRegisterController {

	@Autowired
	LookUpService lookUpService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private TilesConfiguration hibernateConfiguration;
	
	@Autowired
	private MenuRegisterService menuRegisterService;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	
}		

	

	


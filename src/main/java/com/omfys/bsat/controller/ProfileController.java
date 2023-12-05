package com.omfys.bsat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import com.omfys.bsat.model.Bpil_Users;
//import com.springmvc.model.PRF_Autofill;

import com.omfys.bsat.service.UserProfileService;

/**
 * This controller routes accesses to the application to the appropriate hanlder
 * methods.
 * 
 * @author www.codejava.net
 *
 */
@Controller
public class ProfileController {

//	@Autowired
//	AutofillSRservice autofillSRservice;

	@Autowired
	UserProfileService userprofileservice;

	@RequestMapping("/Profile")
	public ModelAndView helloWorld(HttpServletRequest request, Model model, ModelMap map) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");

			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");
				if (kwm_user != null) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					List<Bpil_Users> Pend_req = userprofileservice.getUserData(user_id);

					model.addAttribute("User_Details", Pend_req);

					return new ModelAndView("User_Profile");
				} else {
					return new ModelAndView("redirect:logout");
				}

			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
			/* Login Checking Code Ends */
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	@RequestMapping("/userworkbench")
	public ModelAndView helloWorld1(HttpServletRequest request, Model model, ModelMap map) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");
			Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");
				if (kwm_user != null) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					List<Bpil_Users> Pend_req1 = userprofileservice.getUsers();

					model.addAttribute("listuserdetails", Pend_req1);
				}

				return new ModelAndView("User_workbench");

			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
			/* Login Checking Code Ends */
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	@RequestMapping("/activeuser")
	public ModelAndView useractive(HttpServletRequest request, Model model, ModelMap map) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");

			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");
				if (kwm_user != null) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					// int user_id=1;
					String s1 = "A";

					int id = Integer.parseInt(request.getParameter("user_id"));
					System.out.println("controller id" + id);

					Bpil_Users k = new Bpil_Users();

					String Pend_req = userprofileservice.updateuser(user_id, id, s1);

					System.out.println("msg" + Pend_req);

					List<Bpil_Users> Pend_req1 = userprofileservice.getUsers();

					model.addAttribute("listuserdetails", Pend_req1);
					model.addAttribute("displayresult", Pend_req);
				}
				return new ModelAndView("User_workbench");

			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
			/* Login Checking Code Ends */
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	@RequestMapping("/deactiveuser")
	public ModelAndView userdeactive(HttpServletRequest request, Model model, ModelMap map) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");
			
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");
				if (kwm_user != null) {

					int user_id = (Integer) request.getSession().getAttribute("userid");
					String s1 = "D";
					// int user_id=1;
					int id = Integer.parseInt(request.getParameter("user_id"));
					System.out.println("controller id" + id);

					Bpil_Users k = new Bpil_Users();

					String Pend_req = userprofileservice.updateuser(user_id, id, s1);
					System.out.println("msg" + Pend_req);
					List<Bpil_Users> Pend_req1 = userprofileservice.getUsers();

					model.addAttribute("listuserdetails", Pend_req1);
					model.addAttribute("displayresult", Pend_req);
				}

				return new ModelAndView("User_workbench");

			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
			/* Login Checking Code Ends */
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

}

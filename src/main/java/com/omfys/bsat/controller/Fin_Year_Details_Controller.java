package com.omfys.bsat.controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.google.gson.Gson;
import com.omfys.bsat.repository.Fin_Year_Dao;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_Fin_Year;
import com.omfys.bsat.model.Bpil_Menu_Header;
import com.omfys.bsat.model.Bpil_User_ProfileId_List;
import com.omfys.bsat.model.Bpil_Users;

import oracle.jdbc.OracleTypes;

@Controller
public class Fin_Year_Details_Controller {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private TilesConfiguration hibernateConfiguration;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private Fin_Year_Dao fin;

	@RequestMapping(value = "/fin_year")
	public ModelAndView fin(Bpil_Fin_Year f, ModelMap map, Model model, HttpServletRequest request) {
		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					ArrayList<Bpil_Fin_Year> dml = fin.showall(f);
					model.addAttribute("dml", dml);
					return new ModelAndView("Fin_Year");
				} else {
					return new ModelAndView("unauthorizedattempt");
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

	@RequestMapping(value = "/new_fin")
	public ModelAndView new_fin(Bpil_Fin_Year f, ModelMap map, Model model, HttpServletResponse res,
			HttpServletRequest request) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					return new ModelAndView("New_Fin_Year");
				} else {
					return new ModelAndView("unauthorizedattempt");
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

	@RequestMapping(value = "/save_fin_year")
	public ModelAndView save_fin(@ModelAttribute(value = "Bpil_Fin_Year") Bpil_Fin_Year f, BindingResult result,
			ModelMap map, Model model, HttpServletResponse res, HttpServletRequest request) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					String date = request.getParameter("start_date");

					Date startdate = null;
					try {
						if (!request.getParameter("start_date").equals("")) {
							startdate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("start_date"));
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}

					Date enddate = null;
					try {
						if (!request.getParameter("end_date").equals("")) {
							enddate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("end_date"));
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}

					f.setStart_date(startdate);
					f.setEnd_date(enddate);

					if (request.getParameter("current_yr_flag").equals("Y")) {
						String query = "update BPIL_FIN_YEAR set CURRENT_YR_FLAG='N' where CURRENT_YR_FLAG='Y'";
						jdbcTemplate.update(query);
					}

					int weeks = 0;
					if ((!request.getParameter("start_date").equals(""))
							&& (!request.getParameter("end_date").equals(""))) {
						try {
							String query = " SELECT (TRUNC(TO_DATE('" + request.getParameter("end_date")
									+ "', 'yyyy/MM/dd'),'d') - TRUNC(TO_DATE('" + request.getParameter("start_date")
									+ "', 'yyyy/MM/dd'),'d'))/7 FROM DUAL";
							PreparedStatement ps;

							ps = hibernateConfiguration.dataSource().getConnection().prepareStatement(query);

							ResultSet rs = ps.executeQuery();

							while (rs.next()) {

								weeks = rs.getInt(1);
							}

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					f.setNo_of_weeks(weeks);

					fin.savefin(f);

					return new ModelAndView("redirect:/fin_year");
				} else {
					return new ModelAndView("unauthorizedattempt");
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

	@RequestMapping(value = "/read_only") // @RequestParam(value="scheme_id") String scheme_id
	public ModelAndView readonly_fin(@RequestParam(value = "fin_year") int fin_year, ModelMap map, Model model,
			HttpServletResponse res, HttpServletRequest request) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
						ArrayList<Bpil_Fin_Year> list = fin.showreadonly(fin_year);
						model.addAttribute("list", list);
						return new ModelAndView("ReadOnly_Fin_Year");
					} else {
						return new ModelAndView("unauthorizedattempt");
					}
				} else {
					return new ModelAndView("unauthorizedattempt");
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

	@RequestMapping(value = "/loadweeks", method = RequestMethod.GET)
	public void loadweeks(@RequestParam(value = "start_date") String start_date,
			@RequestParam(value = "end_date") String end_date, HttpServletRequest request, Model model,
			HttpServletResponse response, ModelMap map) throws ParseException, SQLException, IOException {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					try {

						int diff = 0;
						String query = " SELECT (TRUNC(TO_DATE('" + end_date + "', 'yyyy/MM/dd'),'d') - TRUNC(TO_DATE('"
								+ start_date + "', 'yyyy/MM/dd'),'d'))/7 FROM DUAL";
						PreparedStatement ps = hibernateConfiguration.dataSource().getConnection()
								.prepareStatement(query);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {

							diff = rs.getInt(1);
						}

						String json = null;
						System.out.println("line");

						json = new Gson().toJson(diff);
						response.setContentType("application/json");
						response.getWriter().write(json);

					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					response.getWriter().write("Please log in");
				}

			} else {

				response.getWriter().write("Please log in");
			}
			/* Login Checking Code Ends */
		} catch (NullPointerException e) {
			response.getWriter().write("Please log in");
		}

	}
	@RequestMapping(value = "/save_finYear")
	public ModelAndView save_finYear(@ModelAttribute(value = "Bpil_Fin_Year") Bpil_Fin_Year f, BindingResult result,
			ModelMap map, Model model, HttpServletResponse res, HttpServletRequest request) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					String date = request.getParameter("start_date");

					Date startdate = null;
					try {
						if (!request.getParameter("start_date").equals("")) {
							startdate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("start_date"));
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}

					Date enddate = null;
					try {
						if (!request.getParameter("end_date").equals("")) {
							enddate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("end_date"));
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}

					f.setStart_date(startdate);
					f.setEnd_date(enddate);

					if (request.getParameter("current_yr_flag").equals("Y")) {
						String query = "update BPIL_FIN_YEAR set CURRENT_YR_FLAG='N' where CURRENT_YR_FLAG='Y'";
						jdbcTemplate.update(query);
					}

					int weeks = 0;
					if ((!request.getParameter("start_date").equals(""))
							&& (!request.getParameter("end_date").equals(""))) {
						try {
							String query = " SELECT (TRUNC(TO_DATE('" + request.getParameter("end_date")
									+ "', 'yyyy/MM/dd'),'d') - TRUNC(TO_DATE('" + request.getParameter("start_date")
									+ "', 'yyyy/MM/dd'),'d'))/7 FROM DUAL";
							PreparedStatement ps;

							ps = hibernateConfiguration.dataSource().getConnection().prepareStatement(query);

							ResultSet rs = ps.executeQuery();

							while (rs.next()) {

								weeks = rs.getInt(1);
							}

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					f.setNo_of_weeks(weeks);

					fin.savefin(f);

					return new ModelAndView("redirect:/admin");
				} else {
					return new ModelAndView("unauthorizedattempt");
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

}

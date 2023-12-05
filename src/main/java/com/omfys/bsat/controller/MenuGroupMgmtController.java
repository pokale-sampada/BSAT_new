package com.omfys.bsat.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.omfys.bsat.repository.MenuGroupDao;
import com.omfys.bsat.repository.MenuGroupMgmtDao;
import com.omfys.bsat.model.Bpil_Bsat_Defaults;
import com.omfys.bsat.model.Bpil_MenuGroup;
import com.omfys.bsat.model.Bpil_Menu_FunRegi;
import com.omfys.bsat.model.Bpil_Menu_Header;
import com.omfys.bsat.model.Bpil_Menu_Line;
import com.omfys.bsat.model.Bpil_SubMenu_Line;
import com.omfys.bsat.model.Bpil_User_ProfileId_List;
import com.omfys.bsat.model.Bpil_Users;

@Controller
public class MenuGroupMgmtController {

	@Autowired
	private MenuGroupMgmtDao menugrpdao;

	@Autowired
	private MenuGroupDao menudao;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@RequestMapping("/menugroupgrid")
	public ModelAndView menugroupgrid(HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					List<Bpil_MenuGroup> menugroup_list = menugrpdao.menugroupgrid();

					model.addAttribute("menu_grp_list", menugroup_list);

					return new ModelAndView("MenuGroupGrid");
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

	@RequestMapping("/newmenugroup")
	public ModelAndView newmenugroup(HttpServletRequest request, ModelMap map, Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					return new ModelAndView("MenuGroup");
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

	@RequestMapping(value = "/save_menugroup", method = RequestMethod.POST)
	public ModelAndView save_menugroup(@ModelAttribute("Bpil_MenuGroup") Bpil_MenuGroup menuGroup,
			BindingResult bindingResult, HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					int user_id = (Integer) request.getSession().getAttribute("userid");

					Date startdate = null;

					try {
						if (!request.getParameter("group_start_date").equals("")) {

							System.out.println(request.getParameter("group_start_date"));
							startdate = new SimpleDateFormat("yyyy-MM-dd")
									.parse(request.getParameter("group_start_date"));
//											System.out.println(startdate);
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Date enddate = null;

					try {
						if (!request.getParameter("group_end_date").equals("")) {
							System.out.println(request.getParameter("group_end_date"));
							enddate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("group_end_date"));
//											System.out.println(enddate);
						}
					} catch (ParseException e) {
						// TODO: handle exception
						e.printStackTrace();
					}

					menuGroup.setGroup_start_date(startdate);
					menuGroup.setGroup_end_date(enddate);
					menuGroup.setCreated_by(user_id);
					menuGroup.setLast_updated_by(user_id);

					int menugroupid = menugrpdao.savemenugroup(menuGroup);

					return new ModelAndView("redirect:/menumanagement");
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

	@RequestMapping("/updatemenugroup")
	public ModelAndView updatemenugroup(@RequestParam(value = "menu_group_id") String menu_group_id,
			HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					int menugrp_id = Integer.parseInt(menu_group_id);
					Bpil_MenuGroup menuGroup = menugrpdao.menugroupautofill(menugrp_id);

					model.addAttribute("JSON", menuGroup);

					return new ModelAndView("MenuGroup");
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

	@RequestMapping("/menuheadergrid")
	public ModelAndView menuheadergrid(HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					List<Bpil_Menu_Header> menu_Headers = menugrpdao.menuheadergrid();

					model.addAttribute("menu_Header_list", menu_Headers);

					return new ModelAndView("MenuHeaderGrid");
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

	@RequestMapping("/newmenuheaderline")
	public ModelAndView newmenuheaderline(HttpServletRequest request, ModelMap map, Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					return new ModelAndView("MenuHeaderLine");
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

	@RequestMapping(value = "/loadmenugroup", method = RequestMethod.GET)
	public void loadmenugroupname(HttpServletRequest request, Model model, HttpServletResponse response) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {

					ArrayList<Bpil_MenuGroup> menuGroups = (ArrayList<Bpil_MenuGroup>) hibernateTemplate
							.find("from Bpil_MenuGroup");

					String json = null;

					json = new Gson().toJson(menuGroups);
					response.setContentType("application/json");
					try {
						response.getWriter().write(json);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					response.setContentType("Please log in");
				}

			} else {
				response.setContentType("Please log in");
			}
			/* Login Checking Code Ends */
		} catch (NullPointerException e) {
			response.setContentType("Please log in");
		}

	}

	@RequestMapping(value = "/save_menuHeaderLine", method = RequestMethod.POST)
	public ModelAndView save_menuHeaderLine(@ModelAttribute("Bpil_Menu_Header") Bpil_Menu_Header menu_Header,
			BindingResult result, HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					int user_id = (Integer) request.getSession().getAttribute("userid");

					Date startdate = null;

					try {
						if (!request.getParameter("header_start_date").equals("")) {

							startdate = new SimpleDateFormat("yyyy-MM-dd")
									.parse(request.getParameter("header_start_date"));
//											System.out.println(startdate);
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Date enddate = null;

					try {
						if (!request.getParameter("header_end_date").equals("")) {
							enddate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("header_end_date"));
//											System.out.println(enddate);
						}
					} catch (ParseException e) {
						// TODO: handle exception
						e.printStackTrace();
					}

					menu_Header.setHeader_start_date(startdate);
					menu_Header.setHeader_end_date(enddate);
					menu_Header.setCreated_by(user_id);
					menu_Header.setLast_updated_by(user_id);

					int menu_header_id = menugrpdao.savemenuheader(menu_Header);

					String[] menu_line_id = request.getParameterValues("menu_line_id");
					String[] line_status = request.getParameterValues("active");
					String[] line_name = request.getParameterValues("line_name");
					String[] action_name = request.getParameterValues("line_action_name");

					if (request.getParameterValues("line_name") != null) {

						int menulineid = menugrpdao.savemenulines(menu_header_id, menu_line_id, line_status, line_name,
								action_name, user_id);

					}

					return new ModelAndView("redirect:/menuheadergrid");
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

	@RequestMapping("/updatemenuheaderline")
	public ModelAndView updatemenuheaderline(@RequestParam(value = "menu_header_id") String menu_header_id,
			HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					int menuheader_id = Integer.parseInt(menu_header_id);

					Bpil_Menu_Header menu_Header = menugrpdao.menuheaderautofill(menuheader_id);

					ArrayList<Bpil_Menu_Line> menu_Lines = menugrpdao.menulineautofill(menuheader_id);

					model.addAttribute("JSON", menu_Header);
					model.addAttribute("menulines", menu_Lines);

					return new ModelAndView("MenuHeaderLine");
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

	@RequestMapping("/menufunctiongrid")
	public ModelAndView menufunctiongrid(HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					ArrayList<Bpil_Menu_FunRegi> menu_Functions = (ArrayList<Bpil_Menu_FunRegi>) hibernateTemplate
							.find("from Bpil_Menu_FunRegi");

					model.addAttribute("menu_func_list", menu_Functions);

					return new ModelAndView("MenuFunctionGrid");
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

	@RequestMapping("/defaultoptions")
	public ModelAndView defaultoption(HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {
				System.out.println("Hii i am in outer if block---------------------");

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					System.out.println("Hii i am in inner if block---------------------------");
					Bpil_Bsat_Defaults defaults = menudao.getDefaults();

					model.addAttribute("redemption_date", defaults.getRedemption_date());
					model.addAttribute("freeze_date", defaults.getFreeze_date());
					model.addAttribute("interface_date", defaults.getInterface_date());

					return new ModelAndView("DefaultOptions");
				} else {
					System.out.println("Hii i am in  inner else block---------------------------");
					return new ModelAndView("unauthorizedattempt");
				}

			} else {
				System.out.println("Hii i am in outer else block----------------------------------");
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

	@RequestMapping("/setDefaultOptions")
	public ModelAndView setDefaultOptions(HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					String redemption_date = request.getParameter("redemption_date");
					String freeze_date = request.getParameter("freeze_date");
					String interface_date = request.getParameter("interface_date");
					String redemption_day = redemption_date.substring(0, 2);
					String freeze_day = freeze_date.substring(0, 2);
					String interface_day = interface_date.substring(0, 2);
					System.out.println("redemption_day " + redemption_day + " freeze_day " + freeze_day
							+ " interfaec_day " + interface_day);

					Bpil_Bsat_Defaults defaults = menudao.getDefaults();
					defaults.setRedemption_date(redemption_day);
					defaults.setFreeze_date(freeze_day);
					defaults.setInterface_date(interface_day);

					menudao.saveDefaults(defaults);
					model.addAttribute("redemption_date", defaults.getRedemption_date());
					model.addAttribute("freeze_date", defaults.getFreeze_date());
					model.addAttribute("interface_date", defaults.getInterface_date());

					return new ModelAndView("DefaultOptions");
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

	@RequestMapping("/newmenufunction")
	public ModelAndView newmenufunction(HttpServletRequest request, ModelMap map, Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					return new ModelAndView("MenuFunction");
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

	@RequestMapping(value = "/loadmenuline", method = RequestMethod.GET)
	public void loadmenuline(HttpServletRequest request, Model model, HttpServletResponse response) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					ArrayList<Bpil_Menu_Line> menu_Lines = (ArrayList<Bpil_Menu_Line>) hibernateTemplate
							.find("from Bpil_Menu_Line");

					String json = null;

					json = new Gson().toJson(menu_Lines);
					response.setContentType("application/json");
					try {
						response.getWriter().write(json);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					response.setContentType("Please log in");
				}

			} else {
				response.setContentType("Please log in");
			}
			/* Login Checking Code Ends */
		} catch (NullPointerException e) {
			response.setContentType("Please log in");
		}

	}

	@RequestMapping(value = "/save_menufunction", method = RequestMethod.POST)
	public ModelAndView save_menufunction(HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					int user_id = (Integer) request.getSession().getAttribute("userid");

					String[] menu_function_id = request.getParameterValues("menu_function_id");
					String[] menu_line_id = request.getParameterValues("menu_line_id");
					String[] function_name = request.getParameterValues("function_name");
					String[] function_action_name = request.getParameterValues("function_action_name");
					String[] line_status = request.getParameterValues("line_status");

					int functionid = menugrpdao.savemenufunctions(menu_function_id, menu_line_id, function_name,
							function_action_name, line_status);

					return new ModelAndView("redirect:/menufunctiongrid");
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

	@RequestMapping("/updatemenufunction")
	public ModelAndView updatemenufunction(@RequestParam(value = "menu_function_id") String menu_function_id,
			HttpServletRequest request, Model model,ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					System.out.println("Hii ---------------------------------------"+menu_function_id);
					int menu_functionid = Integer.parseInt(menu_function_id);

					ArrayList<Bpil_Menu_FunRegi> menu_Functions = (ArrayList<Bpil_Menu_FunRegi>) hibernateTemplate
							.find("from Bpil_Menu_FunRegi where menu_function_id ="+ menu_functionid);
					System.out.println("Hii ---------------------------------------"+menu_function_id);
					int menu_line_id = menu_Functions.get(0).getMenu_line_id();
					ArrayList<Bpil_Menu_Line> menu_Lines = (ArrayList<Bpil_Menu_Line>) hibernateTemplate
							.find("from Bpil_Menu_Line where menu_line_id = "+ menu_line_id);

					String line_name = menu_Lines.get(0).getLine_name();

					model.addAttribute("menu_func_list", menu_Functions);
					model.addAttribute("line_name", line_name);
					System.out.println("Hii ---------------------------------------"+menu_function_id);
					return new ModelAndView("MenuFunction");
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
	@RequestMapping("/menulinegrid")
	public ModelAndView menulinegrid(HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					ArrayList<Bpil_Menu_Line> menu_Lines = (ArrayList<Bpil_Menu_Line>) hibernateTemplate
							.find("from Bpil_Menu_Line");
					model.addAttribute("menu_line_list", menu_Lines);

					return new ModelAndView("MenuLineGrid");
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
	@RequestMapping("/menumanagement")
	public ModelAndView menumanagement(HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					//List<Bpil_MenuGroup> menugroup_list = menugrpdao.menugroupgrid();

					//model.addAttribute("menu_grp_list", menugroup_list);

					return new ModelAndView("MenuManagement");
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
	@RequestMapping(value = "/save_menuHeader", method = RequestMethod.POST)
	public ModelAndView save_menuHeader(@ModelAttribute("Bpil_Menu_Header") Bpil_Menu_Header menu_Header,
			BindingResult result, HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					int user_id = (Integer) request.getSession().getAttribute("userid");

					Date startdate = null;

					try {
						if (!request.getParameter("header_start_date").equals("")) {

							startdate = new SimpleDateFormat("yyyy-MM-dd")
									.parse(request.getParameter("header_start_date"));
//											System.out.println(startdate);
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Date enddate = null;

					try {
						if (!request.getParameter("header_end_date").equals("")) {
							enddate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("header_end_date"));
//											System.out.println(enddate);
						}
					} catch (ParseException e) {
						// TODO: handle exception
						e.printStackTrace();
					}

					menu_Header.setHeader_start_date(startdate);
					menu_Header.setHeader_end_date(enddate);
					menu_Header.setCreated_by(user_id);
					menu_Header.setLast_updated_by(user_id);

					int menu_header_id = menugrpdao.savemenuheader(menu_Header);

					return new ModelAndView("redirect:/menumanagement");
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
	@RequestMapping(value = "/loadmenuheaders", method = RequestMethod.GET)
	public void loadmenuheaders(@RequestParam(value = "menu_group_id") int menu_group_id,HttpServletRequest request, Model model, HttpServletResponse response) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {

					ArrayList<Bpil_Menu_Header> menuHeaders = (ArrayList<Bpil_Menu_Header>) hibernateTemplate
							.find("from Bpil_Menu_Header where menu_group_id = "+menu_group_id+"and header_active = 'Y'");

					String json = null;

					json = new Gson().toJson(menuHeaders);
					response.setContentType("application/json");
					try {
						response.getWriter().write(json);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					response.setContentType("Please log in");
				}

			} else {
				response.setContentType("Please log in");
			}
			/* Login Checking Code Ends */
		} catch (NullPointerException e) {
			response.setContentType("Please log in");
		}

	}
	@RequestMapping(value = "/save_menuLine", method = RequestMethod.POST)
	public ModelAndView save_menuLine(@ModelAttribute("Bpil_Menu_Line") Bpil_Menu_Line menu_line,
			BindingResult result, HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		System.out.println("In save method");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					int user_id = (Integer) request.getSession().getAttribute("userid");

					Date startdate = null;

					try {
						if (!request.getParameter("line_start_date").equals("")) {

							startdate = new SimpleDateFormat("yyyy-MM-dd")
									.parse(request.getParameter("line_start_date"));
//											System.out.println(startdate);
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Date enddate = null;

					try {
						if (!request.getParameter("line_end_date").equals("")) {
							enddate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("line_end_date"));
//											System.out.println(enddate);
						}
					} catch (ParseException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					menu_line.setActive(request.getParameter("line_active"));
					menu_line.setLine_start_date(startdate);
					menu_line.setLine_end_date(enddate);
					menu_line.setCreated_by(user_id);
					menu_line.setLast_updated_by(user_id);
					int menu_line_id = menugrpdao.savemenuline(menu_line);

					return new ModelAndView("redirect:/menumanagement");
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
	@RequestMapping(value = "/save_submenuLine", method = RequestMethod.POST)
	public ModelAndView save_submenuLine(@ModelAttribute("Bpil_SubMenu_Line") Bpil_SubMenu_Line submenu_line,
			BindingResult result, HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		System.out.println("In save method");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					int user_id = (Integer) request.getSession().getAttribute("userid");

					Date startdate = null;

					try {
						if (!request.getParameter("subline_start_date").equals("")) {

							startdate = new SimpleDateFormat("yyyy-MM-dd")
									.parse(request.getParameter("subline_start_date"));
//											System.out.println(startdate);
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Date enddate = null;

					try {
						if (!request.getParameter("subline_end_date").equals("")) {
							enddate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("subline_end_date"));
//											System.out.println(enddate);
						}
					} catch (ParseException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					submenu_line.setSubline_active(request.getParameter("subline_active"));
					submenu_line.setSubline_start_date(startdate);
					submenu_line.setSubline_end_date(enddate);
					submenu_line.setCreated_by(user_id);
					submenu_line.setLast_updated_by(user_id);
					int menu_line_id = menugrpdao.savesubmenuline(submenu_line);

					return new ModelAndView("redirect:/menumanagement");
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
	@RequestMapping(value = "/loadmenulines", method = RequestMethod.GET)
	public void loadmenulines(@RequestParam(value = "menu_header_id") int menu_header_id,HttpServletRequest request, Model model, HttpServletResponse response) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {

					ArrayList<Bpil_Menu_Line> menuLines = (ArrayList<Bpil_Menu_Line>) hibernateTemplate
							.find("from Bpil_Menu_Line where menu_header_id = "+menu_header_id+"and active = 'Y'");

					String json = null;

					json = new Gson().toJson(menuLines);
					response.setContentType("application/json");
					try {
						response.getWriter().write(json);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					response.setContentType("Please log in");
				}

			} else {
				response.setContentType("Please log in");
			}
			/* Login Checking Code Ends */
		} catch (NullPointerException e) {
			response.setContentType("Please log in");
		}

	}

}

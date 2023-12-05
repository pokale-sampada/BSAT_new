package com.omfys.bsat.controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.ADList;
import com.omfys.bsat.model.Bpil_Login_Details;
import com.omfys.bsat.model.Bpil_Menu_Header;
import com.omfys.bsat.model.Bpil_Menu_Line;
import com.omfys.bsat.model.Bpil_User_ProfileId_List;
import com.omfys.bsat.model.Bpil_User_Profiles;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.Bpil_notification;
import com.omfys.bsat.model.BudgetVsActual;
import com.omfys.bsat.model.EmpFile;
import com.omfys.bsat.model.Employee1;
import com.omfys.bsat.model.New_Scheme_mstr;
import com.omfys.bsat.model.SmsPojo;
import com.omfys.bsat.model.Student;
import com.omfys.bsat.repository.DashbordDAO;
import com.omfys.bsat.repository.SchemeMasterDao;
//import com.springmvc.model.News_Login;
import com.omfys.bsat.service.BpilLoginService;
import com.omfys.bsat.service.UserRegistrationService;

import oracle.jdbc.OracleTypes;

@Controller
public class BpilLoginController {

	@Autowired
	UserRegistrationService userregi;

	@Autowired
	BpilLoginService bpilLoginService;

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	TilesConfiguration hibernateConfiguration;

	@Autowired
	Environment environment;

	@Autowired
	SchemeMasterDao schememasterdao;

	@Autowired
	DashbordDAO dashborddao;

	@Autowired
	CallOPA_RewardsAnalysis callopa_rewardsanalysis;

//	@Autowired
//	OPASchemeAnalysisTrigger opaschemeanalysistrigger;

	Date sysdate = new java.sql.Date(new java.util.Date().getTime());
	long daydif1 = 0;

	@RequestMapping(value = "/{datefilter}")
	public ModelAndView datefilter() {

		return new ModelAndView("datefilter");
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ModelAndView ResourceNotFound(@PathVariable("name") final String name, HttpServletRequest request,
			ModelMap map, Model model) {
		if (name.equals("null"))
			throw new ResourceNotFoundException();
		return new ModelAndView("error_404");
	}

	@RequestMapping(value = "/showschemedetails", method = RequestMethod.GET)
	public ModelAndView ShowDetails(@PathVariable("name") final String name, HttpServletRequest request, ModelMap map,
			Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		try {
			if (loginString.equals("Y")) {
				return new ModelAndView("SchemeDetails");
			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	@RequestMapping("/")
	public ModelAndView welcome(HttpServletRequest request, ModelMap map, Model model) {

		HttpSession session = request.getSession();

		String kwm_user = (String) request.getSession().getAttribute("kwm_user");
		if (kwm_user != null) {
			kwm_user = (String) request.getSession().getAttribute("kwm_user");
			String username = (String) request.getSession().getAttribute("username");
			Integer userid = (Integer) request.getSession().getAttribute("userid");
			Integer profile_id = (Integer) request.getSession().getAttribute("profileid");

			Date passworddate = (Date) request.getSession().getAttribute("passworddate");
			Date sysdate1 = new java.sql.Date(new java.util.Date().getTime());
//			System.out.println("Password date:" + passworddate);
//			System.out.println("system date:" + sysdate1);

			int profileid = profile_id;
			System.out.println(profileid);

			if (profileid == 1) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:dealer");

			} else if (profileid == 2) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:depo");

			} else if (profileid == 3) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:it");

			} else if (profileid == 5) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:region");

			} else if (profileid == 8) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:TSI");

			} else if (profileid == 6) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:marketing");

			} else if (profileid == 7) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:marketingsupervisor");

			} else {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:admin");

			}

		} else {

			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("berger login");
			return new ModelAndView("login");
		}
	}

	@RequestMapping("/home")
	public ModelAndView schememaster_home_icon(HttpServletRequest request, ModelMap map, Model model) {

		HttpSession session = request.getSession();

		String kwm_user = (String) request.getSession().getAttribute("kwm_user");
		if (kwm_user != null) {
			kwm_user = (String) request.getSession().getAttribute("kwm_user");
			String username = (String) request.getSession().getAttribute("username");
			Integer userid = (Integer) request.getSession().getAttribute("userid");
			Integer profile_id = (Integer) request.getSession().getAttribute("profileid");

			Date passworddate = (Date) request.getSession().getAttribute("passworddate");
			Date sysdate1 = new java.sql.Date(new java.util.Date().getTime());
//			System.out.println("Password date:" + passworddate);
//			System.out.println("system date:" + sysdate1);

			int profileid = profile_id;
			System.out.println(profileid);

			if (profileid == 1) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:dealer");

			} else if (profileid == 2) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:depo");

			} else if (profileid == 3) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:it");

			} else if (profileid == 5) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:region");

			} else if (profileid == 8) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:TSI");

			} else if (profileid == 6) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:marketing");

			} else if (profileid == 7) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:marketingsupervisor");

			} else if (profileid == 8) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:na_approver");

			} else if (profileid == 9) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:rg_approver");

			} else if (profileid == 10) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:br_approver");

			} else if (profileid == 11) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:hq_approver");

			} else {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:admin");

			}

		} else {

			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("berger login");
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping("/omfyslogin")
	public ModelAndView wslogin(HttpServletRequest request, ModelMap map, Model model) {

		HttpSession session = request.getSession();

		String kwm_user = (String) request.getSession().getAttribute("kwm_user");

		/*
		 * boolean isSessionActiveFlag = isUserLogin(request); if (isSessionActiveFlag)
		 * {
		 */
		System.out.println("In Session checking method if block");
		if (kwm_user != null) {
			kwm_user = (String) request.getSession().getAttribute("kwm_user");
			String username = (String) request.getSession().getAttribute("username");
			Integer userid = (Integer) request.getSession().getAttribute("userid");
			Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
			System.out.println("Password:" + request.getSession().getAttribute("password"));

			int profileid = profile_id;
			System.out.println(profileid);

			if (profileid == 1) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:dealer");

			} else if (profileid == 2) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:depo");

			} else if (profileid == 3) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:it");

			} else if (profileid == 5) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:region");

			} else if (profileid == 8) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:TSI");

			} else if (profileid == 6) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:marketing");

			} else if (profileid == 7) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:marketingsupervisor");

			} else {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:newportal");

			}

		} else {

			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	@RequestMapping(value = "/berger_login", method = RequestMethod.GET)
	public ModelAndView getLoginForm2(ModelMap map) {

		Bpil_Users kwm_users = new Bpil_Users();

		map.addAttribute("kwm_users", kwm_users);

		System.out.println("Berger Login------>1");

		return new ModelAndView("login");
	}

	@RequestMapping(value = "/berger_login", method = RequestMethod.POST)
	public ModelAndView getLoginForm5(HttpServletRequest request, @ModelAttribute("kwm_users") Bpil_Users kwm_users,
			BindingResult resultkwm_users, final RedirectAttributes re, ModelMap map, Model model) {

		boolean ADFlag = false;
		boolean loginFlag = false;

		String kwm_user = (String) request.getSession().getAttribute("kwm_user");

		if (kwm_user == null) {

			System.out.println("berger login details " + kwm_users.getUser_name() + " " + kwm_users.getPassword());

			Bpil_Users Kwm_User = bpilLoginService.getUserByADID(kwm_users.getUser_name());

			if (Kwm_User == null) {
				// BSAT AUTHENTICATION

				List<Bpil_Users> Kwm_Userslist = bpilLoginService.getUser(kwm_users);
				if (Kwm_Userslist != null && Kwm_Userslist.size() > 0) {
					Kwm_User = (Bpil_Users) Kwm_Userslist.get(0);
					loginFlag = true;
					request.getSession().setAttribute("loginflag", "Y");
				} else {
					request.getSession().setAttribute("loginflag", "N");
				}
			} else {
				// Active Directory Authentication

				if (!(Kwm_User.getActive_directory_id() == null)) {
					try {
						List<ADList> ADList = new ArrayList<ADList>();
						ADList = bpilLoginService.getActiveDirectoryUserList(kwm_users.getUser_name(),
								kwm_users.getPassword());

						Iterator<ADList> itr = ADList.iterator();
						while (itr.hasNext()) {
							ADList ADName = itr.next();
							if (ADName.getAd_id().equals(Kwm_User.getActive_directory_id())) {
								ADFlag = true;
								loginFlag = true;
								System.out.println("Active Directory Authenticated");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			request.getSession().setAttribute("password", kwm_users.getPassword());
			

			if (Kwm_User != null && loginFlag == true) {
				System.out.println("list doa " + Kwm_User.getUser_id() + " " + Kwm_User.getUser_name() + " "
						+ kwm_users.getPassword());

				// Set last login date and count

				// this takes current date
				Calendar c = Calendar.getInstance();
				// this takes current month's first date
				c.set(Calendar.DAY_OF_MONTH, 1);

				Date currentDate = new Date();

				String month = new String();

				int month1 = Calendar.getInstance().get(Calendar.MONTH);
				month1 = month1 + 1;
				month = month1 + "/" + c.get(Calendar.YEAR);
				System.out.println(month);

				Bpil_Login_Details loginDetails = new Bpil_Login_Details();

				if (currentDate == c.getTime()) {
					loginDetails.setBpil_user_id(Kwm_User);
					loginDetails.setLogin_count(1);
					loginDetails.setMonth(month);

					schememasterdao.addLoginCount(loginDetails);

				} else {
					loginDetails = schememasterdao.getLoginCount(Kwm_User.getUser_id(), month);
					if (loginDetails == null) {
						loginDetails = new Bpil_Login_Details();

						loginDetails.setBpil_user_id(Kwm_User);
						loginDetails.setLogin_count(1);
						loginDetails.setMonth(month);

						schememasterdao.addLoginCount(loginDetails);
					} else {
						int count = loginDetails.getLogin_count() + 1;
						loginDetails.setLogin_count(count);
					}

					schememasterdao.updateLoginCount(loginDetails);
				}

				// Set last login date
				Kwm_User.setLast_login(new java.sql.Date(new java.util.Date().getTime()));
				schememasterdao.updateUser(Kwm_User);

				HttpSession session = request.getSession(true);

				session.setAttribute("kwm_user", Kwm_User.getUser_name());

				// Any scheme remains in WIP for more than 30 days needs to be discarded

				LocalDate now = LocalDate.now();
				LocalDate thirty = now.minusDays(30);
				DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-uuuu");
				String thirtydaysbefore = thirty.format(formatters);

				int rowsaffected = jdbcTemplate.update(
						"update Bpil_scheme_master set ACTIVE_FLAG = 'Inactive' where CREATION_DATE < (ADD_MONTHS(TO_DATE('"
								+ thirtydaysbefore
								+ "','DD-MM-YYYY'),0)) and (ACTIVE_FLAG = 'Incomplete' OR ACTIVE_FLAG = 'Cancel' OR ACTIVE_FLAG = 'Rejected')");

				System.out.println("rowsaffected " + rowsaffected);

				List<New_Scheme_mstr> schemes = (List<New_Scheme_mstr>) hibernateTemplate
						.find("from New_Scheme_mstr where active_flag = 'Inactive' AND mail_flag = 'N'");
				Iterator<New_Scheme_mstr> itr = schemes.iterator();
				while (itr.hasNext()) {
					New_Scheme_mstr scheme = itr.next();

					CallableStatement cStmt1;
					try {
						cStmt1 = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
						cStmt1.setInt(1, Kwm_User.getCreated_by());
						cStmt1.setInt(2, scheme.getScheme_id());
						cStmt1.setString(3, "SIN");
						cStmt1.setString(4, "Scheme " + scheme.getScheme_code() + " discarded");
						cStmt1.registerOutParameter(5, Types.VARCHAR);
						ResultSet result = cStmt1.executeQuery();
						String flag = cStmt1.getString(5);
						System.out.println("scheme discard mail flag " + flag);

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}

//	//AUTOMATE Scheme for Redemption, Freeze and Interface				
//				ArrayList<New_Scheme_mstr> active = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("select sm from New_Scheme_mstr sm where sm.active_flag = 'Active'");
//				
//				ArrayList<New_Scheme_mstr> processed = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("select sm from New_Scheme_mstr sm where sm.active_flag = 'Processed'");
//
//				ArrayList<New_Scheme_mstr> freezed = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("select sm from New_Scheme_mstr sm where sm.active_flag = 'Freezed'");
//				
//				ArrayList<Bpil_Bsat_Defaults> automatedays = (ArrayList<Bpil_Bsat_Defaults>) hibernateTemplate
//						.find("select sm from Bpil_Bsat_Defaults sm");
//				
//		//Checking for Active schemes
//			if(active.isEmpty()){
//				System.out.println("No active schemes");
//			}else{
//				try{
//					Iterator<New_Scheme_mstr> itr = active.iterator();
//					while(itr.hasNext()){
//						New_Scheme_mstr sm = itr.next();
//						
//						Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//						String s = formatter.format(sm.getRedemption_date());
//						String redemption_date = s.substring(0, 7)+"-"+automatedays.get(0).getRedemption_date();
//						System.out.println("redemption date "+redemption_date);
//						DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//						Date date = format.parse(redemption_date);
//						if(date.before(currentDate) && date.getMonth() == currentDate.getMonth()){
//							System.out.println("sm date : "+date);
//							System.out.println("current date : "+currentDate);
//							System.out.println("sm id : "+sm.getScheme_id());
//							
//		//Calling SP to add entry into QUEUE for reward analysis			
//							CallableStatement cStmt;
//							try {
//							cStmt = hibernateConfiguration.dataSource()
//									.getConnection().prepareCall("{call BPIL_RW_ANALYSIS_QUEUE_ENTRY(?)}");
//							
//							cStmt.setInt(1,sm.getScheme_id());		
//							ResultSet rs1 = cStmt.executeQuery();
//								 	
//							} catch (SQLException e) {
//							e.printStackTrace();
//							}
//							catch (Exception e) {
//							System.out.println(e.getMessage());
//							} 
//							System.out.println(""+sm.getScheme_id());
//							}
//						}
//				}catch(Exception e){
//					e.printStackTrace();
//				}
//			}
//				
//				
//	//Checking for Processed schemes
//			if(processed.isEmpty()){
//				System.out.println("No Processed schemes");
//			}else{
//				try{
//					Iterator<New_Scheme_mstr> itr = processed.iterator();
//					while(itr.hasNext()){
//						New_Scheme_mstr sm = itr.next();
//						
//						Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//						String s = formatter.format(sm.getRedemption_date());
//						int freeze_month = Integer.parseInt(s.substring(5,7));
//						freeze_month = freeze_month + 1;
//						String freeze_date = s.substring(0, 4)+"-"+freeze_month+"-"+automatedays.get(0).getFreeze_date();
//						System.out.println("freez date "+freeze_date);
//						DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//						Date date = format.parse(freeze_date);
//						if(date.before(currentDate) && date.getMonth() == currentDate.getMonth()){
//								System.out.println("sm date : "+date);
//								System.out.println("current date : "+currentDate);
//								System.out.println("sm id : "+sm.getScheme_id());
//								
//						//Changing the status of processed schemes to freezed
//								String query2="update BPIL_SCHEME_MASTER set active_flag='Freezed' WHERE scheme_id='"+sm.getScheme_id()+"'";				
//								jdbcTemplate.update(query2);
//							}
//						}
//				}catch(Exception e){
//					e.printStackTrace();
//				}
//			}
//				
//					
//	//Checking for Freezed schemes
//			if(freezed.isEmpty()){
//				System.out.println("No freezed schemes");
//			}else{
//				try{
//					Iterator<New_Scheme_mstr> itr = freezed.iterator();
//					while(itr.hasNext()){
//						New_Scheme_mstr sm = itr.next();
//						
//						Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//						String s = formatter.format(sm.getRedemption_date());
//						int close_month = Integer.parseInt(s.substring(5,7));
//						close_month = close_month + 1;
//						String close_date = s.substring(0, 4)+"-"+close_month+"-"+automatedays.get(0).getInterface_date();
//						System.out.println("close date "+close_date);
//						DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//						Date date = format.parse(close_date);
//						if(date.before(currentDate) && date.getMonth() == currentDate.getMonth()){
//								System.out.println("sm date : "+date);
//								System.out.println("current date : "+currentDate);
//								System.out.println("sm id : "+sm.getScheme_id());
//								
//						//Calling SP for interfacing scheme
//								CallableStatement cStmt;
//								try {
//								cStmt = hibernateConfiguration.dataSource()
//										.getConnection().prepareCall("{call BPIL_RW_AN_CLOSE_SCH(?)}");
//								
//								
//								cStmt.setInt(1,sm.getScheme_id());
//								ResultSet result = cStmt.executeQuery();
//									 	
//								} catch (SQLException e) {
//								e.printStackTrace();
//								}
//								catch (Exception e) {
//								System.out.println(e.getMessage());
//								} 
//							}
//						}
//				}catch(Exception e){
//					e.printStackTrace();
//				}
//			}

//				int count = 0;
//				Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet) {
//
//					if (t.getName().equals("mailTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count++;
//					}
//				}
//				if (count == 0) {
//					MailTrigger mv = new MailTrigger(hibernateConfiguration);
//					Thread t1 = new Thread(mv);
//					t1.setName("mailTrigger_dev");
//					t1.start();
//					System.out.println("mailTrigger_dev Thread Created...");
//				}
//
//				int count1 = 0;
//				Set<Thread> threadSet1 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet1) {
//
//					if (t.getName().equals("OPASchemeAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count1++;
//					}
//				}
//				if (count1 == 0) {
//					OPASchemeAnalysisTrigger opaschtrig = new OPASchemeAnalysisTrigger(hibernateConfiguration,
//							hibernateTemplate, jdbcTemplate, callopa_rewardsanalysis);
//					Thread t1 = new Thread(opaschtrig);
//					t1.setName("OPASchemeAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPASchemeAnalysisTrigger_dev Thread Created...");
//				}
//				
//				int count2 = 0;
//				Set<Thread> threadSet2 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet2) {
//
//					if (t.getName().equals("OPABatchFinancialAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count2++;
//					}
//				}
//				if (count2 == 0) {
//					OPABatchFinancialAnalysisTrigger OPABatFinAnaTrig = new OPABatchFinancialAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatFinAnaTrig);
//					t1.setName("OPABatchFinancialAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPABatchFinancialAnalysisTrigger_dev Thread Created...");
//				}
//
//				int count3 = 0;
//				Set<Thread> threadSet3 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet3) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count3++;
//					}
//				}
//				if (count3 == 0) {
//					OPABatchSchemeAnalysisTrigger OPABatSchAnaTrig = new OPABatchSchemeAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig);
//					t1.setName("OPABatchSchemeAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger_dev Thread Created...");
//				}
//
//				int count4 = 0;
//				Set<Thread> threadSet4 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet4) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger2_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count4++;
//					}
//				}
//				if (count4 == 0) {
//					OPABatchSchemeAnalysisTrigger2 OPABatSchAnaTrig2 = new OPABatchSchemeAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig2);
//					t1.setName("OPABatchSchemeAnalysisTrigger2_dev");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger2_dev Thread Created...");
//				}
//				
//				int count5 = 0;
//				Set<Thread> threadSet5 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet5) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count5++;
//					}
//				}
//				if (count5 == 0) {
//					OPABatchRewardAnalysisTrigger OPABatRewAnaTrig = new OPABatchRewardAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig);
//					t1.setName("OPABatchRewardAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger_dev Thread Created...");
//				}
//				
//				int count6 = 0;
//				Set<Thread> threadSet6 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet6) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger2_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count6++;
//					}
//				}
//				if (count6 == 0) {
//					OPABatchRewardAnalysisTrigger2 OPABatRewAnaTrig2 = new OPABatchRewardAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig2);
//					t1.setName("OPABatchRewardAnalysisTrigger2_dev");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger2_dev Thread Created...");
//				}
//
//				int count7 = 0;
//				Set<Thread> threadSet7 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet7) {
//
//					if (t.getName().equals("OPABatchTSIFinancialAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count7++;
//					}
//				}
//				if (count7 == 0) {
//					OPABatchTSIFinancialAnalysisTrigger OPABatTSIFinAnaTrig = new OPABatchTSIFinancialAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSIFinAnaTrig);
//					t1.setName("OPABatchTSIFinancialAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPABatchTSIFinancialAnalysisTrigger_dev Thread Created...");
//				}
//
//				int count8 = 0;
//				Set<Thread> threadSet8 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet8) {
//
//					if (t.getName().equals("OPABatchTSISchemeAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count8++;
//					}
//				}
//				if (count8 == 0) {
//					OPABatchTSISchemeAnalysisTrigger OPABatTSISchAnaTrig = new OPABatchTSISchemeAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSISchAnaTrig);
//					t1.setName("OPABatchTSISchemeAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPABatchTSISchemeAnalysisTrigger_dev Thread Created...");
//				}
//
//				int count9 = 0;
//				Set<Thread> threadSet9 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet9) {
//
//					if (t.getName().equals("OPABatchTSISchemeAnalysisTrigger2_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count9++;
//					}
//				}
//				if (count9 == 0) {
//					OPABatchTSISchemeAnalysisTrigger2 OPABatTSISchAnaTrig2 = new OPABatchTSISchemeAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSISchAnaTrig2);
//					t1.setName("OPABatchTSISchemeAnalysisTrigger2_dev");
//					t1.start();
//					System.out.println("OPABatchTSISchemeAnalysisTrigger2_dev Thread Created...");
//				}
//
//				int count10 = 0;
//				Set<Thread> threadSet10 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet10) {
//
//					if (t.getName().equals("OPABatchTSIRewardAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count10++;
//					}
//				}
//				if (count10 == 0) {
//					OPABatchTSIRewardAnalysisTrigger OPABatTSIRewAnaTrig = new OPABatchTSIRewardAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSIRewAnaTrig);
//					t1.setName("OPABatchTSIRewardAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPABatchTSIRewardAnalysisTrigger_dev Thread Created...");
//				}
//				
//				int count11 = 0;
//				Set<Thread> threadSet11 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet11) {
//
//					if (t.getName().equals("OPABatchTSIRewardAnalysisTrigger2_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count11++;
//					}
//				}
//				if (count11 == 0) {
//					OPABatchTSIRewardAnalysisTrigger2 OPABatTSIRewAnaTrig2 = new OPABatchTSIRewardAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSIRewAnaTrig2);
//					t1.setName("OPABatchTSIRewardAnalysisTrigger2_dev");
//					t1.start();
//					System.out.println("OPABatchTSIRewardAnalysisTrigger2_dev Thread Created...");
//				}
//				
//				int count12 = 0;
//				Set<Thread> threadSet12 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet12) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger3_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count12++;
//					}
//				}
//				if (count12 == 0) {
//					OPABatchSchemeAnalysisTrigger3 OPABatSchAnaTrig3 = new OPABatchSchemeAnalysisTrigger3(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig3);
//					t1.setName("OPABatchSchemeAnalysisTrigger3_dev");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger3_dev Thread Created...");
//				}
//				
//				int count13 = 0;
//				Set<Thread> threadSet13 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet13) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger4_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count13++;
//					}
//				}
//				if (count13 == 0) {
//					OPABatchSchemeAnalysisTrigger4 OPABatSchAnaTrig4 = new OPABatchSchemeAnalysisTrigger4(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig4);
//					t1.setName("OPABatchSchemeAnalysisTrigger4_dev");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger4_dev Thread Created...");
//				}
//				
//				int count14 = 0;
//				Set<Thread> threadSet14 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet14) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger5_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count14++;
//					}
//				}
//				if (count14 == 0) {
//					OPABatchSchemeAnalysisTrigger5 OPABatSchAnaTrig5 = new OPABatchSchemeAnalysisTrigger5(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig5);
//					t1.setName("OPABatchSchemeAnalysisTrigger5_dev");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger5_dev Thread Created...");
//				}
//				
//				int count15 = 0;
//				Set<Thread> threadSet15 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet15) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger3_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count15++;
//					}
//				}
//				if (count15 == 0) {
//					OPABatchRewardAnalysisTrigger3 OPABatRewAnaTrig3 = new OPABatchRewardAnalysisTrigger3(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig3);
//					t1.setName("OPABatchRewardAnalysisTrigger3_dev");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger3_dev Thread Created...");
//				}
//				
//				int count16 = 0;
//				Set<Thread> threadSet16 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet16) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger4_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count16++;
//					}
//				}
//				if (count16 == 0) {
//					OPABatchRewardAnalysisTrigger4 OPABatRewAnaTrig4 = new OPABatchRewardAnalysisTrigger4(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig4);
//					t1.setName("OPABatchRewardAnalysisTrigger4_dev");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger4_dev Thread Created...");
//				}
//				
//				int count17 = 0;
//				Set<Thread> threadSet17 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet17) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger5_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count17++;
//					}
//				}
//				if (count17 == 0) {
//					OPABatchRewardAnalysisTrigger5 OPABatRewAnaTrig5 = new OPABatchRewardAnalysisTrigger5(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig5);
//					t1.setName("OPABatchRewardAnalysisTrigger5_dev");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger5_dev Thread Created...");
//				}

//				int count = 0;
//				Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet) {
//
//					if (t.getName().equals("mailTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count++;
//					}
//				}
//				if (count == 0) {
//					MailTrigger mv = new MailTrigger(hibernateConfiguration);
//					Thread t1 = new Thread(mv);
//					t1.setName("mailTrigger");
//					t1.start();
//					System.out.println("mailTrigger Thread Created...");
//				}
//
//				int count1 = 0;
//				Set<Thread> threadSet1 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet1) {
//
//					if (t.getName().equals("OPASchemeAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count1++;
//					}
//				}
//				if (count1 == 0) {
//					OPASchemeAnalysisTrigger opaschtrig = new OPASchemeAnalysisTrigger(hibernateConfiguration,
//							hibernateTemplate, jdbcTemplate, callopa_rewardsanalysis);
//					Thread t1 = new Thread(opaschtrig);
//					t1.setName("OPASchemeAnalysisTrigger");
//					t1.start();
//					System.out.println("OPASchemeAnalysisTrigger Thread Created...");
//				}
//
//				int count2 = 0;
//				Set<Thread> threadSet2 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet2) {
//
//					if (t.getName().equals("OPABatchFinancialAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count2++;
//					}
//				}
//				if (count2 == 0) {
//					OPABatchFinancialAnalysisTrigger OPABatFinAnaTrig = new OPABatchFinancialAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatFinAnaTrig);
//					t1.setName("OPABatchFinancialAnalysisTrigger");
//					t1.start();
//					System.out.println("OPABatchFinancialAnalysisTrigger Thread Created...");
//				}
//
//				int count3 = 0;
//				Set<Thread> threadSet3 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet3) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count3++;
//					}
//				}
//				if (count3 == 0) {
//					OPABatchSchemeAnalysisTrigger OPABatSchAnaTrig = new OPABatchSchemeAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig);
//					t1.setName("OPABatchSchemeAnalysisTrigger");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger Thread Created...");
//				}
//
//				int count4 = 0;
//				Set<Thread> threadSet4 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet4) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger2")) {
//						System.out.println("Thread : " + t.getName());
//						count4++;
//					}
//				}
//				if (count4 == 0) {
//					OPABatchSchemeAnalysisTrigger2 OPABatSchAnaTrig2 = new OPABatchSchemeAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig2);
//					t1.setName("OPABatchSchemeAnalysisTrigger2");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger2 Thread Created...");
//				}
//
//				int count5 = 0;
//				Set<Thread> threadSet5 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet5) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count5++;
//					}
//				}
//				if (count5 == 0) {
//					OPABatchRewardAnalysisTrigger OPABatRewAnaTrig = new OPABatchRewardAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig);
//					t1.setName("OPABatchRewardAnalysisTrigger");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger Thread Created...");
//				}
//				
//				int count6 = 0;
//				Set<Thread> threadSet6 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet6) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger2")) {
//						System.out.println("Thread : " + t.getName());
//						count6++;
//					}
//				}
//				if (count6 == 0) {
//					OPABatchRewardAnalysisTrigger2 OPABatRewAnaTrig2 = new OPABatchRewardAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig2);
//					t1.setName("OPABatchRewardAnalysisTrigger2");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger2 Thread Created...");
//				}
//
//				int count7 = 0;
//				Set<Thread> threadSet7 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet7) {
//
//					if (t.getName().equals("OPABatchTSIFinancialAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count7++;
//					}
//				}
//				if (count7 == 0) {
//					OPABatchTSIFinancialAnalysisTrigger OPABatTSIFinAnaTrig = new OPABatchTSIFinancialAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSIFinAnaTrig);
//					t1.setName("OPABatchTSIFinancialAnalysisTrigger");
//					t1.start();
//					System.out.println("OPABatchTSIFinancialAnalysisTrigger Thread Created...");
//				}
//				
//				int count8 = 0;
//				Set<Thread> threadSet8 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet8) {
//
//					if (t.getName().equals("OPABatchTSISchemeAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count8++;
//					}
//				}
//				if (count8 == 0) {
//					OPABatchTSISchemeAnalysisTrigger OPABatTSISchAnaTrig = new OPABatchTSISchemeAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSISchAnaTrig);
//					t1.setName("OPABatchTSISchemeAnalysisTrigger");
//					t1.start();
//					System.out.println("OPABatchTSISchemeAnalysisTrigger Thread Created...");
//				}
//
//				int count9 = 0;
//				Set<Thread> threadSet9 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet9) {
//
//					if (t.getName().equals("OPABatchTSISchemeAnalysisTrigger2")) {
//						System.out.println("Thread : " + t.getName());
//						count9++;
//					}
//				}
//				if (count9 == 0) {
//					OPABatchTSISchemeAnalysisTrigger2 OPABatTSISchAnaTrig2 = new OPABatchTSISchemeAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSISchAnaTrig2);
//					t1.setName("OPABatchTSISchemeAnalysisTrigger2");
//					t1.start();
//					System.out.println("OPABatchTSISchemeAnalysisTrigger2 Thread Created...");
//				}
//
//				int count10 = 0;
//				Set<Thread> threadSet10 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet10) {
//
//					if (t.getName().equals("OPABatchTSIRewardAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count10++;
//					}
//				}
//				if (count10 == 0) {
//					OPABatchTSIRewardAnalysisTrigger OPABatTSIRewAnaTrig = new OPABatchTSIRewardAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSIRewAnaTrig);
//					t1.setName("OPABatchTSIRewardAnalysisTrigger");
//					t1.start();
//					System.out.println("OPABatchTSIRewardAnalysisTrigger Thread Created...");
//				}
//				
//				int count11 = 0;
//				Set<Thread> threadSet11 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet11) {
//
//					if (t.getName().equals("OPABatchTSIRewardAnalysisTrigger2")) {
//						System.out.println("Thread : " + t.getName());
//						count11++;
//					}
//				}
//				if (count11 == 0) {
//					OPABatchTSIRewardAnalysisTrigger2 OPABatTSIRewAnaTrig2 = new OPABatchTSIRewardAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSIRewAnaTrig2);
//					t1.setName("OPABatchTSIRewardAnalysisTrigger2");
//					t1.start();
//					System.out.println("OPABatchTSIRewardAnalysisTrigger2 Thread Created...");
//				}
//				
//				int count12 = 0;
//				Set<Thread> threadSet12 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet12) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger3")) {
//						System.out.println("Thread : " + t.getName());
//						count12++;
//					}
//				}
//				if (count12 == 0) {
//					OPABatchSchemeAnalysisTrigger3 OPABatSchAnaTrig3 = new OPABatchSchemeAnalysisTrigger3(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig3);
//					t1.setName("OPABatchSchemeAnalysisTrigger3");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger3 Thread Created...");
//				}
//				
//				int count13 = 0;
//				Set<Thread> threadSet13 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet13) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger4")) {
//						System.out.println("Thread : " + t.getName());
//						count13++;
//					}
//				}
//				if (count13 == 0) {
//					OPABatchSchemeAnalysisTrigger4 OPABatSchAnaTrig4 = new OPABatchSchemeAnalysisTrigger4(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig4);
//					t1.setName("OPABatchSchemeAnalysisTrigger4");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger4 Thread Created...");
//				}
//				
//				int count14 = 0;
//				Set<Thread> threadSet14 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet14) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger5")) {
//						System.out.println("Thread : " + t.getName());
//						count14++;
//					}
//				}
//				if (count14 == 0) {
//					OPABatchSchemeAnalysisTrigger5 OPABatSchAnaTrig5 = new OPABatchSchemeAnalysisTrigger5(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig5);
//					t1.setName("OPABatchSchemeAnalysisTrigger5");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger5 Thread Created...");
//				}
//				
//				int count15 = 0;
//				Set<Thread> threadSet15 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet15) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger3")) {
//						System.out.println("Thread : " + t.getName());
//						count15++;
//					}
//				}
//				if (count15 == 0) {
//					OPABatchRewardAnalysisTrigger3 OPABatRewAnaTrig3 = new OPABatchRewardAnalysisTrigger3(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig3);
//					t1.setName("OPABatchRewardAnalysisTrigger3");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger3 Thread Created...");
//				}
//				
//				int count16 = 0;
//				Set<Thread> threadSet16 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet16) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger4")) {
//						System.out.println("Thread : " + t.getName());
//						count16++;
//					}
//				}
//				if (count16 == 0) {
//					OPABatchRewardAnalysisTrigger4 OPABatRewAnaTrig4 = new OPABatchRewardAnalysisTrigger4(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig4);
//					t1.setName("OPABatchRewardAnalysisTrigger4");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger4_dev Thread Created...");
//				}
//				
//				int count17 = 0;
//				Set<Thread> threadSet17 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet17) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger5")) {
//						System.out.println("Thread : " + t.getName());
//						count17++;
//					}
//				}
//				if (count17 == 0) {
//					OPABatchRewardAnalysisTrigger5 OPABatRewAnaTrig5 = new OPABatchRewardAnalysisTrigger5(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig5);
//					t1.setName("OPABatchRewardAnalysisTrigger5");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger5 Thread Created...");
//				}

//				System.out.println("Last name" + Kwm_User.getLast_name());
//				System.out.println("First name" + Kwm_User.getFirst_name());
				if (Kwm_User.getLast_name() != null && Kwm_User.getFirst_name() != null) {
					session.setAttribute("username", Kwm_User.getLast_name() + " " + Kwm_User.getFirst_name());
				} else {
					session.setAttribute("username", Kwm_User.getUser_name());
				}

				session.setAttribute("userid", Kwm_User.getUser_id());

				System.out.println("userid " + Kwm_User.getUser_id());
				session.setAttribute("profileid", Kwm_User.getProfile_id());
				session.setAttribute("PMG_ML_grp", Kwm_User.getPmg_ml_group());

				session.setAttribute("passworddate", Kwm_User.getAttribute2());

//				Date passworddate = (Date) request.getSession().getAttribute("passworddate");
//				Date sysdate = new java.sql.Date(new java.util.Date().getTime());
//				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//				String passworddate1 = format.format(passworddate);
//				String sysdate1 = format.format(sysdate);
//
//				Date d1 = null;
//				Date d2 = null;
//				long diffDays = 0;
//				try {
//					d1 = format.parse(passworddate1);
//					d2 = format.parse(sysdate1);
//
//					// in milliseconds
//					long diff = d2.getTime() - d1.getTime();
//
//					diffDays = diff / (24 * 60 * 60 * 1000);
//
//					System.out.println(diffDays + " days, ");
//					session.setAttribute("datecount", diffDays);
//					System.out.println("set date count ..............................");
//
//					long datecount = (long) request.getSession().getAttribute("datecount");
//
//					System.out.println(datecount + " Date count ");
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				Integer profile_id1 = (Integer) request.getSession().getAttribute("profileid");
//				daydif1 = (long) request.getSession().getAttribute("datecount");
//				if (daydif1 >= 31 && profile_id1 != 4) {
//
//					Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
//					if (profile_id != null) {
//						int profileid = profile_id;
//						System.out.println(profileid);
//						List<Bpil_Main_Menu> menu_group = bpilLoginService.getMenuGroup(profileid);
//						for (Bpil_Main_Menu mg : menu_group) {
//							System.out.println(mg.getMain_menu_id() + " " + mg.getMain_menu_name());
//							System.out.println("submenu" + Integer.toString(mg.getMain_menu_id()));
//							List<Bpil_Sub_Menu> menu_line = bpilLoginService.getSubMenuLine(mg.getMain_menu_id());
//							for (Bpil_Sub_Menu ml : menu_line) {
//								System.out.println(
//										ml.getSub_menu_id() + " " + ml.getMain_menu_id() + " " + ml.getSub_menu_name());
//							}
//							session.removeAttribute("submenu" + Integer.toString(mg.getMain_menu_id()));
//						}
//						session.removeAttribute("menus");
//					}
//					session.removeAttribute("kwm_user");
//					session.removeAttribute("username");
//					session.removeAttribute("userid");
//					session.removeAttribute("profileid");
//					session.removeAttribute("datecount");
//					session.removeAttribute("passworddate");
//					session.invalidate();
//					System.out.println("session destroyrd");
//					map.addAttribute("kwm_users", kwm_users);
//					System.out.println("wasib login");
//
//					model.addAttribute("diffDays", diffDays);
//					return new ModelAndView("login");
////					return new ModelAndView("redirect:logout");
//
//				}

				session.setMaxInactiveInterval(-1);

				re.addFlashAttribute("kwm_user", Kwm_User);
				int profileid = Kwm_User.getProfile_id();
				System.out.println(profileid);

				if ((Kwm_User.getUser_type().equals("Admin")) || Kwm_User.getUser_type().equals("Region")
						|| Kwm_User.getUser_type().equals("Dealer") || Kwm_User.getUser_type().equals("Marketing")
						|| Kwm_User.getUser_type().equals("Depo") || Kwm_User.getUser_type().equals("IT")
						|| Kwm_User.getUser_type().equals("Supervisor") || Kwm_User.getUser_type().equals("TSI")) {

//					List<Bpil_Main_Menu> menu_group = bpilLoginService.get_user_main_menu(Kwm_User.getUser_id());
//
//					for (Bpil_Main_Menu mg : menu_group) {
//						System.out.println(mg.getMain_menu_id() + " " + mg.getMain_menu_name());
//
//						List<Bpil_Sub_Menu> menu_line = bpilLoginService.get_user_sub_menu(mg.getMain_menu_id(),
//								mg.getMenu_type());
//
//						for (Bpil_Sub_Menu ml : menu_line) {
//
//							System.out.println(
//									ml.getSub_menu_id() + " " + ml.getMain_menu_id() + " " + ml.getSub_menu_name());
//
//						}
//
//						if (menu_line.isEmpty()) {
//
//						} else {
//
//							System.out.println("submenu" + Integer.toString(mg.getMain_menu_id()));
//
//							session.setAttribute("submenu" + Integer.toString(mg.getMain_menu_id()), menu_line);
//
//						}
//					}
//
//					session.setAttribute("menus", menu_group);					 

					Integer userid = (Integer) request.getSession().getAttribute("userid");

					List<Bpil_Menu_Header> menu_group = bpilLoginService.getMenuGroup1(userid);
					for (Bpil_Menu_Header mg : menu_group) {
//						System.out.println("menus" + mg.getMenu_header_id() + " " + mg.getHeader_name() + " "
//								+ mg.getAction_name());
                     System.out.println("Running menu line 2----------------00000000099999");
						List<Bpil_Menu_Line> menu_line = bpilLoginService.getMenuLine2(userid,mg.getMenu_header_id());

						for (Bpil_Menu_Line ml : menu_line) {

//							System.out.println("submenu" + ml.getMenu_line_id() + " " + ml.getMenu_header_id() + " "
//									+ ml.getLine_name() + " " + ml.getAction_name());

						}

						if (menu_line.isEmpty()) {

						} else {

//							System.out.println("submenu" + Integer.toString(mg.getMenu_header_id()));

							session.setAttribute("submenu" + Integer.toString(mg.getMenu_header_id()), menu_line);

						}

					}

					session.setAttribute("menus", menu_group);
					if (menu_group != null && menu_group.size() > 0) {
						String activemenuid = Integer.toString(menu_group.get(0).getMenu_header_id());
						session.setAttribute("activemenu", activemenuid);
					}

				}

//				else if (Kwm_User.getUser_type().equals("Admin")) {
//					System.out.println("in else admin");
//					List<Bpil_Main_Menu> menu_group = bpilLoginService.getMenuGroup(Kwm_User.getProfile_id());
//
//					for (Bpil_Main_Menu mg : menu_group) {
//						System.out.println(mg.getMain_menu_id() + " " + mg.getMain_menu_name());
//
//						List<Bpil_Sub_Menu> menu_line = bpilLoginService.getSubMenuLine(mg.getMain_menu_id());
//
//						for (Bpil_Sub_Menu ml : menu_line) {
//
//							System.out.println(
//									ml.getSub_menu_id() + " " + ml.getMain_menu_id() + " " + ml.getSub_menu_name());
//
//						}
//
//						if (menu_line.isEmpty()) {
//
//						} else {
//
//							System.out.println("submenu" + Integer.toString(mg.getMain_menu_id()));
//
//							session.setAttribute("submenu" + Integer.toString(mg.getMain_menu_id()), menu_line);
//
//						}
//					}
//					session.setAttribute("menus", menu_group);
//				}				

				else {
					Integer userid = (Integer) request.getSession().getAttribute("userid");

					List<Bpil_Menu_Header> menu_group = bpilLoginService.getMenuGroup1(userid);

					for (Bpil_Menu_Header mg : menu_group) {
//						System.out.println("menus" + mg.getMenu_header_id() + " " + mg.getHeader_name() + " "
//								+ mg.getAction_name());

						List<Bpil_Menu_Line> menu_line = bpilLoginService.getMenuLine2(userid,mg.getMenu_header_id());

						for (Bpil_Menu_Line ml : menu_line) {

//							System.out.println("submenu" + ml.getMenu_line_id() + " " + ml.getMenu_header_id() + " "
//									+ ml.getLine_name() + " " + ml.getAction_name());

						}

						if (menu_line.isEmpty()) {

						} else {

//							System.out.println("submenu" + Integer.toString(mg.getMenu_header_id()));

							session.setAttribute("submenu" + Integer.toString(mg.getMenu_header_id()), menu_line);

						}

					}

					session.setAttribute("menus", menu_group);
					if (menu_group != null && menu_group.size() > 0) {
						String activemenuid = Integer.toString(menu_group.get(0).getMenu_header_id());
						session.setAttribute("activemenu", activemenuid);
					}

				}
				
				
				  HashMap<String, String> mapp = new HashMap<>();
	    			String sql = "";
	    			
	    					sql = "select distinct profile_id,mapping from BPIL_USER_PROFILES";
	    			
	    					List<Bpil_User_Profiles> kwm_menu_groups = jdbcTemplate.query(sql, new RowMapper<Bpil_User_Profiles>() {
	    			
	    						@Override
	    						public Bpil_User_Profiles mapRow(ResultSet rs, int rowNum) throws SQLException {
	    							Bpil_User_Profiles kwm_menu_group = new Bpil_User_Profiles();
	    							kwm_menu_group.setProfile_id(rs.getInt("PROFILE_ID"));
	    							kwm_menu_group.setMapping(rs.getString("MAPPING"));
	    							return kwm_menu_group;
	    						}
	    					});
	    			
				   System.out.println(kwm_menu_groups.toString()+"00000000000Akash---------------------");
	    				for ( Bpil_User_Profiles i : kwm_menu_groups)
	    				{
							mapp.put(Integer.toString(i.getProfile_id()),i.getMapping());
	    				}
				        for (String i : mapp.keySet()) {
				        System.out.println("key-redirect ruunning- menu line 2------------------************: " + i + " value: " + mapp.get(i));
				        if (profileid == Integer.parseInt(i)){
				        	System.out.println("Hashmap redirect working");
				        	return new ModelAndView("redirect:"+ mapp.get(i));
				        }
				    					        		
				      }
				        int user_id = (Integer) request.getSession().getAttribute("userid");
						daydif1 = 0;

						return new ModelAndView("redirect:admin");
	    		

//				if (profileid == 1) {
//
//					int user_id = (Integer) request.getSession().getAttribute("userid");
//
//					return new ModelAndView("redirect:dealer");
				

//				} else if (profileid == 2) {
//
//					int user_id = (Integer) request.getSession().getAttribute("userid");
//
//					return new ModelAndView("redirect:depo");
//
//				} else if (profileid == 3) {
//
//					int user_id = (Integer) request.getSession().getAttribute("userid");
//
//					return new ModelAndView("redirect:it");
//
//				} else if (profileid == 5) {
//
//					int user_id = (Integer) request.getSession().getAttribute("userid");
//
//					return new ModelAndView("redirect:region");
//
//				} else if (profileid == 12) {
//
//					int user_id = (Integer) request.getSession().getAttribute("userid");
//
//					return new ModelAndView("redirect:TSI");
//
//				} else if (profileid == 6) {
//
//					int user_id = (Integer) request.getSession().getAttribute("userid");
//
//					return new ModelAndView("redirect:marketing");
//
//				} else if (profileid == 7) {
//
//					int user_id = (Integer) request.getSession().getAttribute("userid");
//
//					return new ModelAndView("redirect:marketingsupervisor");
//
//				} else if (profileid == 8) {
//
//					int user_id = (Integer) request.getSession().getAttribute("userid");
//
//					return new ModelAndView("redirect:na_approver");
//
//				} else if (profileid == 9) {
//
//					int user_id = (Integer) request.getSession().getAttribute("userid");
//
//					return new ModelAndView("redirect:rg_approver");
//
//				} else if (profileid == 10) {
//
//					int user_id = (Integer) request.getSession().getAttribute("userid");
//
//					return new ModelAndView("redirect:br_approver");
//
//				} else if (profileid == 11) {
//
//					int user_id = (Integer) request.getSession().getAttribute("userid");
//
//					return new ModelAndView("redirect:hq_approver");
//
//			}
				

//					int count = 0;
//					Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
//					for (Thread t : threadSet) {
//
//						if (t.getName().equals("mailTrigger")) {
//							System.out.println("Thread : " + t.getName());
//							count++;
//						}
//					}
//					if (count == 0) {
//						MailTrigger mv = new MailTrigger(hibernateConfiguration);
//						Thread t1 = new Thread(mv);
//						t1.setName("mailTrigger");
//						t1.start();
//						System.out.println("Thread Created...");
//					}
//					System.out.println("admindashboard");

			

			} else {

				map.addAttribute("kwm_users", kwm_users);
				return new ModelAndView("login", "message", "Please check your credentials...");
			}

		} else {

			kwm_user = (String) request.getSession().getAttribute("kwm_user");
			String username = (String) request.getSession().getAttribute("username");
			Integer userid = (Integer) request.getSession().getAttribute("userid");
			Integer profile_id = (Integer) request.getSession().getAttribute("profileid");

			int profileid = profile_id;
			System.out.println(profileid);
			if (profileid == 1) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:dealer");

			} else if (profileid == 2) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:depo");

			} else if (profileid == 3) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:it");

			} else if (profileid == 5) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:region");

			} else if (profileid == 8) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:TSI");

			} else if (profileid == 6) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:marketing");

			} else if (profileid == 7) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:marketingsupervisor");

			} else if (profileid == 8) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:na_approver");

			} else if (profileid == 9) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:rg_approver");

			} else if (profileid == 10) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:br_approver");

			} else if (profileid == 11) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:hq_approver");

			} else {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:admin");

			}

		}
		

	}

	@RequestMapping(value = "/berger_login5", method = RequestMethod.POST)
	public ModelAndView getLoginForm(HttpServletRequest request, @ModelAttribute("kwm_users") Bpil_Users kwm_users,
			BindingResult resultkwm_users, final RedirectAttributes re, ModelMap map, Model model) throws SQLException {

		boolean ADFlag = false;
		boolean loginFlag = false;

		String kwm_user = (String) request.getSession().getAttribute("kwm_user");

		if (kwm_user == null) {

			System.out.println("berger login details " + kwm_users.getUser_name() + " " + kwm_users.getPassword());

			Bpil_Users Kwm_User = bpilLoginService.getUserByADID(kwm_users.getUser_name());

			if (Kwm_User == null) {
				// BSAT AUTHENTICATION

				List<Bpil_Users> Kwm_Userslist = bpilLoginService.getUser(kwm_users);
				if (Kwm_Userslist != null && Kwm_Userslist.size() > 0) {
					Kwm_User = (Bpil_Users) Kwm_Userslist.get(0);
					loginFlag = true;
					request.getSession().setAttribute("loginflag", "Y");
				} else {
					request.getSession().setAttribute("loginflag", "N");
				}
			} else {
				// Active Directory Authentication

				if (!(Kwm_User.getActive_directory_id() == null)) {
					try {
						List<ADList> ADList = new ArrayList<ADList>();
						ADList = bpilLoginService.getActiveDirectoryUserList(kwm_users.getUser_name(),
								kwm_users.getPassword());

						Iterator<ADList> itr = ADList.iterator();
						while (itr.hasNext()) {
							ADList ADName = itr.next();
							if (ADName.getAd_id().equals(Kwm_User.getActive_directory_id())) {
								ADFlag = true;
								loginFlag = true;
								System.out.println("Active Directory Authenticated");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			request.getSession().setAttribute("password", kwm_users.getPassword());

			if (Kwm_User != null && loginFlag == true) {
				System.out.println("list doa " + Kwm_User.getUser_id() + " " + Kwm_User.getUser_name() + " "
						+ kwm_users.getPassword());

				// Set last login date and count

				// this takes current date
				Calendar c = Calendar.getInstance();
				// this takes current month's first date
				c.set(Calendar.DAY_OF_MONTH, 1);

				Date currentDate = new Date();

				String month = new String();

				int month1 = Calendar.getInstance().get(Calendar.MONTH);
				month1 = month1 + 1;
				month = month1 + "/" + c.get(Calendar.YEAR);
				System.out.println(month);

				Bpil_Login_Details loginDetails = new Bpil_Login_Details();

				if (currentDate == c.getTime()) {
					loginDetails.setBpil_user_id(Kwm_User);
					loginDetails.setLogin_count(1);
					loginDetails.setMonth(month);

					schememasterdao.addLoginCount(loginDetails);

				} else {
					loginDetails = schememasterdao.getLoginCount(Kwm_User.getUser_id(), month);
					if (loginDetails == null) {
						loginDetails = new Bpil_Login_Details();

						loginDetails.setBpil_user_id(Kwm_User);
						loginDetails.setLogin_count(1);
						loginDetails.setMonth(month);

						schememasterdao.addLoginCount(loginDetails);
					} else {
						int count = loginDetails.getLogin_count() + 1;
						loginDetails.setLogin_count(count);
					}

					schememasterdao.updateLoginCount(loginDetails);
				}

				// Set last login date
				Kwm_User.setLast_login(new java.sql.Date(new java.util.Date().getTime()));
				schememasterdao.updateUser(Kwm_User);

				HttpSession session = request.getSession(true);

				session.setAttribute("kwm_user", Kwm_User.getUser_name());

				// Any scheme remains in WIP for more than 30 days needs to be discarded

				LocalDate now = LocalDate.now();
				LocalDate thirty = now.minusDays(30);
				DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-uuuu");
				String thirtydaysbefore = thirty.format(formatters);

				int rowsaffected = jdbcTemplate.update(
						"update Bpil_scheme_master set ACTIVE_FLAG = 'Inactive' where CREATION_DATE < (ADD_MONTHS(TO_DATE('"
								+ thirtydaysbefore
								+ "','DD-MM-YYYY'),0)) and (ACTIVE_FLAG = 'Incomplete' OR ACTIVE_FLAG = 'Cancel' OR ACTIVE_FLAG = 'Rejected')");

				System.out.println("rowsaffected " + rowsaffected);

				List<New_Scheme_mstr> schemes = (List<New_Scheme_mstr>) hibernateTemplate
						.find("from New_Scheme_mstr where active_flag = 'Inactive' AND mail_flag = 'N'");
				Iterator<New_Scheme_mstr> itr = schemes.iterator();
				while (itr.hasNext()) {
					New_Scheme_mstr scheme = itr.next();

					CallableStatement cStmt1;
					try {
						cStmt1 = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
						cStmt1.setInt(1, Kwm_User.getCreated_by());
						cStmt1.setInt(2, scheme.getScheme_id());
						cStmt1.setString(3, "SIN");
						cStmt1.setString(4, "Scheme " + scheme.getScheme_code() + " discarded");
						cStmt1.registerOutParameter(5, Types.VARCHAR);
						ResultSet result = cStmt1.executeQuery();
						String flag = cStmt1.getString(5);
						System.out.println("scheme discard mail flag " + flag);

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}

//	//AUTOMATE Scheme for Redemption, Freeze and Interface				
//				ArrayList<New_Scheme_mstr> active = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("select sm from New_Scheme_mstr sm where sm.active_flag = 'Active'");
//				
//				ArrayList<New_Scheme_mstr> processed = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("select sm from New_Scheme_mstr sm where sm.active_flag = 'Processed'");
//
//				ArrayList<New_Scheme_mstr> freezed = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("select sm from New_Scheme_mstr sm where sm.active_flag = 'Freezed'");
//				
//				ArrayList<Bpil_Bsat_Defaults> automatedays = (ArrayList<Bpil_Bsat_Defaults>) hibernateTemplate
//						.find("select sm from Bpil_Bsat_Defaults sm");
//				
//		//Checking for Active schemes
//			if(active.isEmpty()){
//				System.out.println("No active schemes");
//			}else{
//				try{
//					Iterator<New_Scheme_mstr> itr = active.iterator();
//					while(itr.hasNext()){
//						New_Scheme_mstr sm = itr.next();
//						
//						Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//						String s = formatter.format(sm.getRedemption_date());
//						String redemption_date = s.substring(0, 7)+"-"+automatedays.get(0).getRedemption_date();
//						System.out.println("redemption date "+redemption_date);
//						DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//						Date date = format.parse(redemption_date);
//						if(date.before(currentDate) && date.getMonth() == currentDate.getMonth()){
//							System.out.println("sm date : "+date);
//							System.out.println("current date : "+currentDate);
//							System.out.println("sm id : "+sm.getScheme_id());
//							
//		//Calling SP to add entry into QUEUE for reward analysis			
//							CallableStatement cStmt;
//							try {
//							cStmt = hibernateConfiguration.dataSource()
//									.getConnection().prepareCall("{call BPIL_RW_ANALYSIS_QUEUE_ENTRY(?)}");
//							
//							cStmt.setInt(1,sm.getScheme_id());		
//							ResultSet rs1 = cStmt.executeQuery();
//								 	
//							} catch (SQLException e) {
//							e.printStackTrace();
//							}
//							catch (Exception e) {
//							System.out.println(e.getMessage());
//							} 
//							System.out.println(""+sm.getScheme_id());
//							}
//						}
//				}catch(Exception e){
//					e.printStackTrace();
//				}
//			}
//				
//				
//	//Checking for Processed schemes
//			if(processed.isEmpty()){
//				System.out.println("No Processed schemes");
//			}else{
//				try{
//					Iterator<New_Scheme_mstr> itr = processed.iterator();
//					while(itr.hasNext()){
//						New_Scheme_mstr sm = itr.next();
//						
//						Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//						String s = formatter.format(sm.getRedemption_date());
//						int freeze_month = Integer.parseInt(s.substring(5,7));
//						freeze_month = freeze_month + 1;
//						String freeze_date = s.substring(0, 4)+"-"+freeze_month+"-"+automatedays.get(0).getFreeze_date();
//						System.out.println("freez date "+freeze_date);
//						DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//						Date date = format.parse(freeze_date);
//						if(date.before(currentDate) && date.getMonth() == currentDate.getMonth()){
//								System.out.println("sm date : "+date);
//								System.out.println("current date : "+currentDate);
//								System.out.println("sm id : "+sm.getScheme_id());
//								
//						//Changing the status of processed schemes to freezed
//								String query2="update BPIL_SCHEME_MASTER set active_flag='Freezed' WHERE scheme_id='"+sm.getScheme_id()+"'";				
//								jdbcTemplate.update(query2);
//							}
//						}
//				}catch(Exception e){
//					e.printStackTrace();
//				}
//			}
//				
//					
//	//Checking for Freezed schemes
//			if(freezed.isEmpty()){
//				System.out.println("No freezed schemes");
//			}else{
//				try{
//					Iterator<New_Scheme_mstr> itr = freezed.iterator();
//					while(itr.hasNext()){
//						New_Scheme_mstr sm = itr.next();
//						
//						Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//						String s = formatter.format(sm.getRedemption_date());
//						int close_month = Integer.parseInt(s.substring(5,7));
//						close_month = close_month + 1;
//						String close_date = s.substring(0, 4)+"-"+close_month+"-"+automatedays.get(0).getInterface_date();
//						System.out.println("close date "+close_date);
//						DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//						Date date = format.parse(close_date);
//						if(date.before(currentDate) && date.getMonth() == currentDate.getMonth()){
//								System.out.println("sm date : "+date);
//								System.out.println("current date : "+currentDate);
//								System.out.println("sm id : "+sm.getScheme_id());
//								
//						//Calling SP for interfacing scheme
//								CallableStatement cStmt;
//								try {
//								cStmt = hibernateConfiguration.dataSource()
//										.getConnection().prepareCall("{call BPIL_RW_AN_CLOSE_SCH(?)}");
//								
//								
//								cStmt.setInt(1,sm.getScheme_id());
//								ResultSet result = cStmt.executeQuery();
//									 	
//								} catch (SQLException e) {
//								e.printStackTrace();
//								}
//								catch (Exception e) {
//								System.out.println(e.getMessage());
//								} 
//							}
//						}
//				}catch(Exception e){
//					e.printStackTrace();
//				}
//			}

//				int count = 0;
//				Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet) {
//
//					if (t.getName().equals("mailTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count++;
//					}
//				}
//				if (count == 0) {
//					MailTrigger mv = new MailTrigger(hibernateConfiguration);
//					Thread t1 = new Thread(mv);
//					t1.setName("mailTrigger_dev");
//					t1.start();
//					System.out.println("mailTrigger_dev Thread Created...");
//				}
//
//				int count1 = 0;
//				Set<Thread> threadSet1 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet1) {
//
//					if (t.getName().equals("OPASchemeAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count1++;
//					}
//				}
//				if (count1 == 0) {
//					OPASchemeAnalysisTrigger opaschtrig = new OPASchemeAnalysisTrigger(hibernateConfiguration,
//							hibernateTemplate, jdbcTemplate, callopa_rewardsanalysis);
//					Thread t1 = new Thread(opaschtrig);
//					t1.setName("OPASchemeAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPASchemeAnalysisTrigger_dev Thread Created...");
//				}
//				
//				int count2 = 0;
//				Set<Thread> threadSet2 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet2) {
//
//					if (t.getName().equals("OPABatchFinancialAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count2++;
//					}
//				}
//				if (count2 == 0) {
//					OPABatchFinancialAnalysisTrigger OPABatFinAnaTrig = new OPABatchFinancialAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatFinAnaTrig);
//					t1.setName("OPABatchFinancialAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPABatchFinancialAnalysisTrigger_dev Thread Created...");
//				}
//
//				int count3 = 0;
//				Set<Thread> threadSet3 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet3) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count3++;
//					}
//				}
//				if (count3 == 0) {
//					OPABatchSchemeAnalysisTrigger OPABatSchAnaTrig = new OPABatchSchemeAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig);
//					t1.setName("OPABatchSchemeAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger_dev Thread Created...");
//				}
//
//				int count4 = 0;
//				Set<Thread> threadSet4 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet4) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger2_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count4++;
//					}
//				}
//				if (count4 == 0) {
//					OPABatchSchemeAnalysisTrigger2 OPABatSchAnaTrig2 = new OPABatchSchemeAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig2);
//					t1.setName("OPABatchSchemeAnalysisTrigger2_dev");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger2_dev Thread Created...");
//				}
//				
//				int count5 = 0;
//				Set<Thread> threadSet5 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet5) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count5++;
//					}
//				}
//				if (count5 == 0) {
//					OPABatchRewardAnalysisTrigger OPABatRewAnaTrig = new OPABatchRewardAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig);
//					t1.setName("OPABatchRewardAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger_dev Thread Created...");
//				}
//				
//				int count6 = 0;
//				Set<Thread> threadSet6 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet6) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger2_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count6++;
//					}
//				}
//				if (count6 == 0) {
//					OPABatchRewardAnalysisTrigger2 OPABatRewAnaTrig2 = new OPABatchRewardAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig2);
//					t1.setName("OPABatchRewardAnalysisTrigger2_dev");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger2_dev Thread Created...");
//				}
//
//				int count7 = 0;
//				Set<Thread> threadSet7 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet7) {
//
//					if (t.getName().equals("OPABatchTSIFinancialAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count7++;
//					}
//				}
//				if (count7 == 0) {
//					OPABatchTSIFinancialAnalysisTrigger OPABatTSIFinAnaTrig = new OPABatchTSIFinancialAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSIFinAnaTrig);
//					t1.setName("OPABatchTSIFinancialAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPABatchTSIFinancialAnalysisTrigger_dev Thread Created...");
//				}
//
//				int count8 = 0;
//				Set<Thread> threadSet8 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet8) {
//
//					if (t.getName().equals("OPABatchTSISchemeAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count8++;
//					}
//				}
//				if (count8 == 0) {
//					OPABatchTSISchemeAnalysisTrigger OPABatTSISchAnaTrig = new OPABatchTSISchemeAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSISchAnaTrig);
//					t1.setName("OPABatchTSISchemeAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPABatchTSISchemeAnalysisTrigger_dev Thread Created...");
//				}
//
//				int count9 = 0;
//				Set<Thread> threadSet9 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet9) {
//
//					if (t.getName().equals("OPABatchTSISchemeAnalysisTrigger2_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count9++;
//					}
//				}
//				if (count9 == 0) {
//					OPABatchTSISchemeAnalysisTrigger2 OPABatTSISchAnaTrig2 = new OPABatchTSISchemeAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSISchAnaTrig2);
//					t1.setName("OPABatchTSISchemeAnalysisTrigger2_dev");
//					t1.start();
//					System.out.println("OPABatchTSISchemeAnalysisTrigger2_dev Thread Created...");
//				}
//
//				int count10 = 0;
//				Set<Thread> threadSet10 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet10) {
//
//					if (t.getName().equals("OPABatchTSIRewardAnalysisTrigger_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count10++;
//					}
//				}
//				if (count10 == 0) {
//					OPABatchTSIRewardAnalysisTrigger OPABatTSIRewAnaTrig = new OPABatchTSIRewardAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSIRewAnaTrig);
//					t1.setName("OPABatchTSIRewardAnalysisTrigger_dev");
//					t1.start();
//					System.out.println("OPABatchTSIRewardAnalysisTrigger_dev Thread Created...");
//				}
//				
//				int count11 = 0;
//				Set<Thread> threadSet11 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet11) {
//
//					if (t.getName().equals("OPABatchTSIRewardAnalysisTrigger2_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count11++;
//					}
//				}
//				if (count11 == 0) {
//					OPABatchTSIRewardAnalysisTrigger2 OPABatTSIRewAnaTrig2 = new OPABatchTSIRewardAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSIRewAnaTrig2);
//					t1.setName("OPABatchTSIRewardAnalysisTrigger2_dev");
//					t1.start();
//					System.out.println("OPABatchTSIRewardAnalysisTrigger2_dev Thread Created...");
//				}
//				
//				int count12 = 0;
//				Set<Thread> threadSet12 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet12) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger3_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count12++;
//					}
//				}
//				if (count12 == 0) {
//					OPABatchSchemeAnalysisTrigger3 OPABatSchAnaTrig3 = new OPABatchSchemeAnalysisTrigger3(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig3);
//					t1.setName("OPABatchSchemeAnalysisTrigger3_dev");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger3_dev Thread Created...");
//				}
//				
//				int count13 = 0;
//				Set<Thread> threadSet13 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet13) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger4_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count13++;
//					}
//				}
//				if (count13 == 0) {
//					OPABatchSchemeAnalysisTrigger4 OPABatSchAnaTrig4 = new OPABatchSchemeAnalysisTrigger4(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig4);
//					t1.setName("OPABatchSchemeAnalysisTrigger4_dev");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger4_dev Thread Created...");
//				}
//				
//				int count14 = 0;
//				Set<Thread> threadSet14 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet14) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger5_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count14++;
//					}
//				}
//				if (count14 == 0) {
//					OPABatchSchemeAnalysisTrigger5 OPABatSchAnaTrig5 = new OPABatchSchemeAnalysisTrigger5(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig5);
//					t1.setName("OPABatchSchemeAnalysisTrigger5_dev");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger5_dev Thread Created...");
//				}
//				
//				int count15 = 0;
//				Set<Thread> threadSet15 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet15) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger3_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count15++;
//					}
//				}
//				if (count15 == 0) {
//					OPABatchRewardAnalysisTrigger3 OPABatRewAnaTrig3 = new OPABatchRewardAnalysisTrigger3(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig3);
//					t1.setName("OPABatchRewardAnalysisTrigger3_dev");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger3_dev Thread Created...");
//				}
//				
//				int count16 = 0;
//				Set<Thread> threadSet16 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet16) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger4_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count16++;
//					}
//				}
//				if (count16 == 0) {
//					OPABatchRewardAnalysisTrigger4 OPABatRewAnaTrig4 = new OPABatchRewardAnalysisTrigger4(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig4);
//					t1.setName("OPABatchRewardAnalysisTrigger4_dev");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger4_dev Thread Created...");
//				}
//				
//				int count17 = 0;
//				Set<Thread> threadSet17 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet17) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger5_dev")) {
//						System.out.println("Thread : " + t.getName());
//						count17++;
//					}
//				}
//				if (count17 == 0) {
//					OPABatchRewardAnalysisTrigger5 OPABatRewAnaTrig5 = new OPABatchRewardAnalysisTrigger5(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig5);
//					t1.setName("OPABatchRewardAnalysisTrigger5_dev");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger5_dev Thread Created...");
//				}

//				int count = 0;
//				Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet) {
//
//					if (t.getName().equals("mailTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count++;
//					}
//				}
//				if (count == 0) {
//					MailTrigger mv = new MailTrigger(hibernateConfiguration);
//					Thread t1 = new Thread(mv);
//					t1.setName("mailTrigger");
//					t1.start();
//					System.out.println("mailTrigger Thread Created...");
//				}
//
//				int count1 = 0;
//				Set<Thread> threadSet1 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet1) {
//
//					if (t.getName().equals("OPASchemeAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count1++;
//					}
//				}
//				if (count1 == 0) {
//					OPASchemeAnalysisTrigger opaschtrig = new OPASchemeAnalysisTrigger(hibernateConfiguration,
//							hibernateTemplate, jdbcTemplate, callopa_rewardsanalysis);
//					Thread t1 = new Thread(opaschtrig);
//					t1.setName("OPASchemeAnalysisTrigger");
//					t1.start();
//					System.out.println("OPASchemeAnalysisTrigger Thread Created...");
//				}
//
//				int count2 = 0;
//				Set<Thread> threadSet2 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet2) {
//
//					if (t.getName().equals("OPABatchFinancialAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count2++;
//					}
//				}
//				if (count2 == 0) {
//					OPABatchFinancialAnalysisTrigger OPABatFinAnaTrig = new OPABatchFinancialAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatFinAnaTrig);
//					t1.setName("OPABatchFinancialAnalysisTrigger");
//					t1.start();
//					System.out.println("OPABatchFinancialAnalysisTrigger Thread Created...");
//				}
//
//				int count3 = 0;
//				Set<Thread> threadSet3 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet3) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count3++;
//					}
//				}
//				if (count3 == 0) {
//					OPABatchSchemeAnalysisTrigger OPABatSchAnaTrig = new OPABatchSchemeAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig);
//					t1.setName("OPABatchSchemeAnalysisTrigger");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger Thread Created...");
//				}
//
//				int count4 = 0;
//				Set<Thread> threadSet4 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet4) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger2")) {
//						System.out.println("Thread : " + t.getName());
//						count4++;
//					}
//				}
//				if (count4 == 0) {
//					OPABatchSchemeAnalysisTrigger2 OPABatSchAnaTrig2 = new OPABatchSchemeAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig2);
//					t1.setName("OPABatchSchemeAnalysisTrigger2");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger2 Thread Created...");
//				}
//
//				int count5 = 0;
//				Set<Thread> threadSet5 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet5) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count5++;
//					}
//				}
//				if (count5 == 0) {
//					OPABatchRewardAnalysisTrigger OPABatRewAnaTrig = new OPABatchRewardAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig);
//					t1.setName("OPABatchRewardAnalysisTrigger");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger Thread Created...");
//				}
//				
//				int count6 = 0;
//				Set<Thread> threadSet6 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet6) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger2")) {
//						System.out.println("Thread : " + t.getName());
//						count6++;
//					}
//				}
//				if (count6 == 0) {
//					OPABatchRewardAnalysisTrigger2 OPABatRewAnaTrig2 = new OPABatchRewardAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig2);
//					t1.setName("OPABatchRewardAnalysisTrigger2");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger2 Thread Created...");
//				}
//
//				int count7 = 0;
//				Set<Thread> threadSet7 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet7) {
//
//					if (t.getName().equals("OPABatchTSIFinancialAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count7++;
//					}
//				}
//				if (count7 == 0) {
//					OPABatchTSIFinancialAnalysisTrigger OPABatTSIFinAnaTrig = new OPABatchTSIFinancialAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSIFinAnaTrig);
//					t1.setName("OPABatchTSIFinancialAnalysisTrigger");
//					t1.start();
//					System.out.println("OPABatchTSIFinancialAnalysisTrigger Thread Created...");
//				}
//				
//				int count8 = 0;
//				Set<Thread> threadSet8 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet8) {
//
//					if (t.getName().equals("OPABatchTSISchemeAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count8++;
//					}
//				}
//				if (count8 == 0) {
//					OPABatchTSISchemeAnalysisTrigger OPABatTSISchAnaTrig = new OPABatchTSISchemeAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSISchAnaTrig);
//					t1.setName("OPABatchTSISchemeAnalysisTrigger");
//					t1.start();
//					System.out.println("OPABatchTSISchemeAnalysisTrigger Thread Created...");
//				}
//
//				int count9 = 0;
//				Set<Thread> threadSet9 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet9) {
//
//					if (t.getName().equals("OPABatchTSISchemeAnalysisTrigger2")) {
//						System.out.println("Thread : " + t.getName());
//						count9++;
//					}
//				}
//				if (count9 == 0) {
//					OPABatchTSISchemeAnalysisTrigger2 OPABatTSISchAnaTrig2 = new OPABatchTSISchemeAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSISchAnaTrig2);
//					t1.setName("OPABatchTSISchemeAnalysisTrigger2");
//					t1.start();
//					System.out.println("OPABatchTSISchemeAnalysisTrigger2 Thread Created...");
//				}
//
//				int count10 = 0;
//				Set<Thread> threadSet10 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet10) {
//
//					if (t.getName().equals("OPABatchTSIRewardAnalysisTrigger")) {
//						System.out.println("Thread : " + t.getName());
//						count10++;
//					}
//				}
//				if (count10 == 0) {
//					OPABatchTSIRewardAnalysisTrigger OPABatTSIRewAnaTrig = new OPABatchTSIRewardAnalysisTrigger(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSIRewAnaTrig);
//					t1.setName("OPABatchTSIRewardAnalysisTrigger");
//					t1.start();
//					System.out.println("OPABatchTSIRewardAnalysisTrigger Thread Created...");
//				}
//				
//				int count11 = 0;
//				Set<Thread> threadSet11 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet11) {
//
//					if (t.getName().equals("OPABatchTSIRewardAnalysisTrigger2")) {
//						System.out.println("Thread : " + t.getName());
//						count11++;
//					}
//				}
//				if (count11 == 0) {
//					OPABatchTSIRewardAnalysisTrigger2 OPABatTSIRewAnaTrig2 = new OPABatchTSIRewardAnalysisTrigger2(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatTSIRewAnaTrig2);
//					t1.setName("OPABatchTSIRewardAnalysisTrigger2");
//					t1.start();
//					System.out.println("OPABatchTSIRewardAnalysisTrigger2 Thread Created...");
//				}
//				
//				int count12 = 0;
//				Set<Thread> threadSet12 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet12) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger3")) {
//						System.out.println("Thread : " + t.getName());
//						count12++;
//					}
//				}
//				if (count12 == 0) {
//					OPABatchSchemeAnalysisTrigger3 OPABatSchAnaTrig3 = new OPABatchSchemeAnalysisTrigger3(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig3);
//					t1.setName("OPABatchSchemeAnalysisTrigger3");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger3 Thread Created...");
//				}
//				
//				int count13 = 0;
//				Set<Thread> threadSet13 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet13) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger4")) {
//						System.out.println("Thread : " + t.getName());
//						count13++;
//					}
//				}
//				if (count13 == 0) {
//					OPABatchSchemeAnalysisTrigger4 OPABatSchAnaTrig4 = new OPABatchSchemeAnalysisTrigger4(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig4);
//					t1.setName("OPABatchSchemeAnalysisTrigger4");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger4 Thread Created...");
//				}
//				
//				int count14 = 0;
//				Set<Thread> threadSet14 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet14) {
//
//					if (t.getName().equals("OPABatchSchemeAnalysisTrigger5")) {
//						System.out.println("Thread : " + t.getName());
//						count14++;
//					}
//				}
//				if (count14 == 0) {
//					OPABatchSchemeAnalysisTrigger5 OPABatSchAnaTrig5 = new OPABatchSchemeAnalysisTrigger5(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatSchAnaTrig5);
//					t1.setName("OPABatchSchemeAnalysisTrigger5");
//					t1.start();
//					System.out.println("OPABatchSchemeAnalysisTrigger5 Thread Created...");
//				}
//				
//				int count15 = 0;
//				Set<Thread> threadSet15 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet15) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger3")) {
//						System.out.println("Thread : " + t.getName());
//						count15++;
//					}
//				}
//				if (count15 == 0) {
//					OPABatchRewardAnalysisTrigger3 OPABatRewAnaTrig3 = new OPABatchRewardAnalysisTrigger3(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig3);
//					t1.setName("OPABatchRewardAnalysisTrigger3");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger3 Thread Created...");
//				}
//				
//				int count16 = 0;
//				Set<Thread> threadSet16 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet16) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger4")) {
//						System.out.println("Thread : " + t.getName());
//						count16++;
//					}
//				}
//				if (count16 == 0) {
//					OPABatchRewardAnalysisTrigger4 OPABatRewAnaTrig4 = new OPABatchRewardAnalysisTrigger4(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig4);
//					t1.setName("OPABatchRewardAnalysisTrigger4");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger4_dev Thread Created...");
//				}
//				
//				int count17 = 0;
//				Set<Thread> threadSet17 = Thread.getAllStackTraces().keySet();
//				for (Thread t : threadSet17) {
//
//					if (t.getName().equals("OPABatchRewardAnalysisTrigger5")) {
//						System.out.println("Thread : " + t.getName());
//						count17++;
//					}
//				}
//				if (count17 == 0) {
//					OPABatchRewardAnalysisTrigger5 OPABatRewAnaTrig5 = new OPABatchRewardAnalysisTrigger5(
//							hibernateConfiguration, hibernateTemplate, jdbcTemplate, environment);
//					Thread t1 = new Thread(OPABatRewAnaTrig5);
//					t1.setName("OPABatchRewardAnalysisTrigger5");
//					t1.start();
//					System.out.println("OPABatchRewardAnalysisTrigger5 Thread Created...");
//				}

//				System.out.println("Last name" + Kwm_User.getLast_name());
//				System.out.println("First name" + Kwm_User.getFirst_name());
				if (Kwm_User.getLast_name() != null && Kwm_User.getFirst_name() != null) {
					session.setAttribute("username", Kwm_User.getLast_name() + " " + Kwm_User.getFirst_name());
				} else {
					session.setAttribute("username", Kwm_User.getUser_name());
				}

				session.setAttribute("userid", Kwm_User.getUser_id());

				System.out.println("userid " + Kwm_User.getUser_id());
				session.setAttribute("profileid", Kwm_User.getProfile_id());
				session.setAttribute("PMG_ML_grp", Kwm_User.getPmg_ml_group());

				session.setAttribute("passworddate", Kwm_User.getAttribute2());

//				Date passworddate = (Date) request.getSession().getAttribute("passworddate");
//				Date sysdate = new java.sql.Date(new java.util.Date().getTime());
//				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//				String passworddate1 = format.format(passworddate);
//				String sysdate1 = format.format(sysdate);
//
//				Date d1 = null;
//				Date d2 = null;
//				long diffDays = 0;
//				try {
//					d1 = format.parse(passworddate1);
//					d2 = format.parse(sysdate1);
//
//					// in milliseconds
//					long diff = d2.getTime() - d1.getTime();
//
//					diffDays = diff / (24 * 60 * 60 * 1000);
//
//					System.out.println(diffDays + " days, ");
//					session.setAttribute("datecount", diffDays);
//					System.out.println("set date count ..............................");
//
//					long datecount = (long) request.getSession().getAttribute("datecount");
//
//					System.out.println(datecount + " Date count ");
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				Integer profile_id1 = (Integer) request.getSession().getAttribute("profileid");
//				daydif1 = (long) request.getSession().getAttribute("datecount");
//				if (daydif1 >= 31 && profile_id1 != 4) {
//
//					Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
//					if (profile_id != null) {
//						int profileid = profile_id;
//						System.out.println(profileid);
//						List<Bpil_Main_Menu> menu_group = bpilLoginService.getMenuGroup(profileid);
//						for (Bpil_Main_Menu mg : menu_group) {
//							System.out.println(mg.getMain_menu_id() + " " + mg.getMain_menu_name());
//							System.out.println("submenu" + Integer.toString(mg.getMain_menu_id()));
//							List<Bpil_Sub_Menu> menu_line = bpilLoginService.getSubMenuLine(mg.getMain_menu_id());
//							for (Bpil_Sub_Menu ml : menu_line) {
//								System.out.println(
//										ml.getSub_menu_id() + " " + ml.getMain_menu_id() + " " + ml.getSub_menu_name());
//							}
//							session.removeAttribute("submenu" + Integer.toString(mg.getMain_menu_id()));
//						}
//						session.removeAttribute("menus");
//					}
//					session.removeAttribute("kwm_user");
//					session.removeAttribute("username");
//					session.removeAttribute("userid");
//					session.removeAttribute("profileid");
//					session.removeAttribute("datecount");
//					session.removeAttribute("passworddate");
//					session.invalidate();
//					System.out.println("session destroyrd");
//					map.addAttribute("kwm_users", kwm_users);
//					System.out.println("wasib login");
//
//					model.addAttribute("diffDays", diffDays);
//					return new ModelAndView("login");
////					return new ModelAndView("redirect:logout");
//
//				}

				session.setMaxInactiveInterval(-1);

				re.addFlashAttribute("kwm_user", Kwm_User);
				int profileid = Kwm_User.getProfile_id();
				System.out.println(profileid);

				if ((Kwm_User.getUser_type().equals("Admin")) || Kwm_User.getUser_type().equals("Region")
						|| Kwm_User.getUser_type().equals("Dealer") || Kwm_User.getUser_type().equals("Marketing")
						|| Kwm_User.getUser_type().equals("Depo") || Kwm_User.getUser_type().equals("IT")
						|| Kwm_User.getUser_type().equals("Supervisor") || Kwm_User.getUser_type().equals("TSI")) {

//					List<Bpil_Main_Menu> menu_group = bpilLoginService.get_user_main_menu(Kwm_User.getUser_id());
//
//					for (Bpil_Main_Menu mg : menu_group) {
//						System.out.println(mg.getMain_menu_id() + " " + mg.getMain_menu_name());
//
//						List<Bpil_Sub_Menu> menu_line = bpilLoginService.get_user_sub_menu(mg.getMain_menu_id(),
//								mg.getMenu_type());
//
//						for (Bpil_Sub_Menu ml : menu_line) {
//
//							System.out.println(
//									ml.getSub_menu_id() + " " + ml.getMain_menu_id() + " " + ml.getSub_menu_name());
//
//						}
//
//						if (menu_line.isEmpty()) {
//
//						} else {
//
//							System.out.println("submenu" + Integer.toString(mg.getMain_menu_id()));
//
//							session.setAttribute("submenu" + Integer.toString(mg.getMain_menu_id()), menu_line);
//
//						}
//					}
//
//					session.setAttribute("menus", menu_group);					 

					Integer userid = (Integer) request.getSession().getAttribute("userid");

					List<Bpil_Menu_Header> menu_group = bpilLoginService.getMenuGroup1(userid);
					for (Bpil_Menu_Header mg : menu_group) {
//						System.out.println("menus" + mg.getMenu_header_id() + " " + mg.getHeader_name() + " "
//								+ mg.getAction_name());

						List<Bpil_Menu_Line> menu_line = bpilLoginService.getMenuLine(mg.getMenu_header_id());

						for (Bpil_Menu_Line ml : menu_line) {

//							System.out.println("submenu" + ml.getMenu_line_id() + " " + ml.getMenu_header_id() + " "
//									+ ml.getLine_name() + " " + ml.getAction_name());

						}

						if (menu_line.isEmpty()) {

						} else {

//							System.out.println("submenu" + Integer.toString(mg.getMenu_header_id()));

							session.setAttribute("submenu" + Integer.toString(mg.getMenu_header_id()), menu_line);

						}

					}

					session.setAttribute("menus", menu_group);
					if (menu_group != null && menu_group.size() > 0) {
						String activemenuid = Integer.toString(menu_group.get(0).getMenu_header_id());
						session.setAttribute("activemenu", activemenuid);
					}

				}

//				else if (Kwm_User.getUser_type().equals("Admin")) {
//					System.out.println("in else admin");
//					List<Bpil_Main_Menu> menu_group = bpilLoginService.getMenuGroup(Kwm_User.getProfile_id());
//
//					for (Bpil_Main_Menu mg : menu_group) {
//						System.out.println(mg.getMain_menu_id() + " " + mg.getMain_menu_name());
//
//						List<Bpil_Sub_Menu> menu_line = bpilLoginService.getSubMenuLine(mg.getMain_menu_id());
//
//						for (Bpil_Sub_Menu ml : menu_line) {
//
//							System.out.println(
//									ml.getSub_menu_id() + " " + ml.getMain_menu_id() + " " + ml.getSub_menu_name());
//
//						}
//
//						if (menu_line.isEmpty()) {
//
//						} else {
//
//							System.out.println("submenu" + Integer.toString(mg.getMain_menu_id()));
//
//							session.setAttribute("submenu" + Integer.toString(mg.getMain_menu_id()), menu_line);
//
//						}
//					}
//					session.setAttribute("menus", menu_group);
//				}				

				else {
					Integer userid = (Integer) request.getSession().getAttribute("userid");

					List<Bpil_Menu_Header> menu_group = bpilLoginService.getMenuGroup1(userid);

					for (Bpil_Menu_Header mg : menu_group) {
//						System.out.println("menus" + mg.getMenu_header_id() + " " + mg.getHeader_name() + " "
//								+ mg.getAction_name());

						List<Bpil_Menu_Line> menu_line = bpilLoginService.getMenuLine(mg.getMenu_header_id());

						for (Bpil_Menu_Line ml : menu_line) {

//							System.out.println("submenu" + ml.getMenu_line_id() + " " + ml.getMenu_header_id() + " "
//									+ ml.getLine_name() + " " + ml.getAction_name());

						}

						if (menu_line.isEmpty()) {

						} else {

//							System.out.println("submenu" + Integer.toString(mg.getMenu_header_id()));

							session.setAttribute("submenu" + Integer.toString(mg.getMenu_header_id()), menu_line);

						}

					}

					session.setAttribute("menus", menu_group);
					if (menu_group != null && menu_group.size() > 0) {
						String activemenuid = Integer.toString(menu_group.get(0).getMenu_header_id());
						session.setAttribute("activemenu", activemenuid);
					}

				}
              
                HashMap<String, String> mapp = new HashMap<>();
    			String sql = "";
    			
    					sql = "select distinct profile_id,mapping from BPIL_USER_PROFILES";
    			
    					List<Bpil_User_Profiles> kwm_menu_groups = jdbcTemplate.query(sql, new RowMapper<Bpil_User_Profiles>() {
    			
    						@Override
    						public Bpil_User_Profiles mapRow(ResultSet rs, int rowNum) throws SQLException {
    							Bpil_User_Profiles kwm_menu_group = new Bpil_User_Profiles();
    							kwm_menu_group.setProfile_id(rs.getInt("PROFILE_ID"));
    							kwm_menu_group.setMapping(rs.getString("MAPPING"));
    							return kwm_menu_group;
    						}
    					});
    			
			   
    				for ( Bpil_User_Profiles i : kwm_menu_groups)
    				{
						mapp.put(Integer.toString(i.getProfile_id()),i.getMapping());
    				}
			        for (String i : mapp.keySet()) {
			        System.out.println("key-redirect ruunning-------------------************: " + i + " value: " + mapp.get(i));
			      }
    		
    			 
    			  
    			  
    			    
    			    
    			   
				if (profileid == 1) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					return new ModelAndView("redirect:dealer");

				} else if (profileid == 2) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					return new ModelAndView("redirect:depo");

				} else if (profileid == 3) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					return new ModelAndView("redirect:it");

				} else if (profileid == 5) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					return new ModelAndView("redirect:region");

				} else if (profileid == 12) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					return new ModelAndView("redirect:TSI");

				} else if (profileid == 6) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					return new ModelAndView("redirect:marketing");

				} else if (profileid == 7) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					return new ModelAndView("redirect:marketingsupervisor");

				} else if (profileid == 8) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					return new ModelAndView("redirect:na_approver");

				} else if (profileid == 9) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					return new ModelAndView("redirect:rg_approver");

				} else if (profileid == 10) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					return new ModelAndView("redirect:br_approver");

				} else if (profileid == 11) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					return new ModelAndView("redirect:hq_approver");

				} else {

					int user_id = (Integer) request.getSession().getAttribute("userid");

//					int count = 0;
//					Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
//					for (Thread t : threadSet) {
//
//						if (t.getName().equals("mailTrigger")) {
//							System.out.println("Thread : " + t.getName());
//							count++;
//						}
//					}
//					if (count == 0) {
//						MailTrigger mv = new MailTrigger(hibernateConfiguration);
//						Thread t1 = new Thread(mv);
//						t1.setName("mailTrigger");
//						t1.start();
//						System.out.println("Thread Created...");
//					}
//					System.out.println("admindashboard");

					daydif1 = 0;

					return new ModelAndView("redirect:admin");

				}

			} else {

				map.addAttribute("kwm_users", kwm_users);
				return new ModelAndView("login", "message", "Please check your credentials...");
			}

		} else {

			kwm_user = (String) request.getSession().getAttribute("kwm_user");
			String username = (String) request.getSession().getAttribute("username");
			Integer userid = (Integer) request.getSession().getAttribute("userid");
			Integer profile_id = (Integer) request.getSession().getAttribute("profileid");

			int profileid = profile_id;
			System.out.println(profileid);
			if (profileid == 1) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:dealer");

			} else if (profileid == 2) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:depo");

			} else if (profileid == 3) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:it");

			} else if (profileid == 5) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:region");

			} else if (profileid == 8) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:TSI");

			} else if (profileid == 6) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:marketing");

			} else if (profileid == 7) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:marketingsupervisor");

			} else if (profileid == 8) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:na_approver");

			} else if (profileid == 9) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:rg_approver");

			} else if (profileid == 10) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:br_approver");

			} else if (profileid == 11) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:hq_approver");

			} else {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				return new ModelAndView("redirect:admin");

			}

		}

	}

	@RequestMapping("/dealer")
	public ModelAndView dealer(HttpServletRequest request, ModelMap map, Model model, New_Scheme_mstr scheme) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		try {
			if (loginString.equals("Y")) {
				System.out.println("into dealer -----");
				HttpSession session = request.getSession();
//				session.setMaxInactiveInterval(1 * 900);

				String history = "abc";
				model.addAttribute("history", history);

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");
				int userid = (Integer) request.getSession().getAttribute("userid");
				if (kwm_user != null) {

					int profile_id = (Integer) request.getSession().getAttribute("profileid");

					ArrayList<New_Scheme_mstr> list = dashborddao.active_scheme(profile_id, userid);

					System.out.println("dealer");
					model.addAttribute("list", list);
					model.addAttribute("daydif1", daydif1);

					return new ModelAndView("dealerdashboard");
				}
				return new ModelAndView("redirect:logout");
			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	@RequestMapping("/depo")
	public ModelAndView sales(HttpServletRequest request, ModelMap map, Model model) {
		String loginString = (String) request.getSession().getAttribute("loginflag");
		
		System.out.println("The redirect page depo");
		try {
			if (loginString.equals("Y")) {
				HttpSession session = request.getSession();
//				session.setMaxInactiveInterval(1 * 900);

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");
				if (kwm_user != null) {

					int user_id = (Integer) request.getSession().getAttribute("userid");
					
					ArrayList<Bpil_Users> b_user_list = (ArrayList<Bpil_Users>) hibernateTemplate.find(
							"from Bpil_Users where user_id = "+user_id+"");
					String depot_code=b_user_list.get(0).getDepot_code();
					
					System.out.println("The depo mapping depot code "+depot_code);
					

					ArrayList<New_Scheme_mstr> al1 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where (sm.active_flag = 'Incomplete' or sm.active_flag = 'Cancel' or sm.active_flag = 'Rejected') and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and bu.user_id = "+ user_id);
					int incomplete = al1.size();
					
					
					

					ArrayList<New_Scheme_mstr> al11 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Pending for Approval' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and bu.user_id = "
									+ user_id );
					int approvalpending = al11.size();

					ArrayList<New_Scheme_mstr> al2 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Requested' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and bu.user_id = "
									+ user_id );
					int requested = al2.size();

					ArrayList<New_Scheme_mstr> al7 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Review' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and bu.user_id = "
									+ user_id );
					int review = al7.size();

					ArrayList<New_Scheme_mstr> al8 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Provisioned' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and bu.user_id = "
									+ user_id );
					int provisioned = al8.size();

					ArrayList<New_Scheme_mstr> al9 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Ready To Launch' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and bu.user_id = "
									+ user_id );
					int launch = al9.size();

					ArrayList<New_Scheme_mstr> al = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Active' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and bu.user_id = "
									+ user_id );
					int active = al.size();
					

					/*
					 * List<New_Scheme_mstr>
					 * nw_list=al.stream().filter(p->p.getAppl_depot_code().contains("021")).collect
					 * (Collectors.toList()); System.out.println("nw_list size "+nw_list.size());
					 * for(int i=0;i<nw_list.size();i++) {
					 * System.out.println("The scheme id"+nw_list.get(i).getScheme_id());
					 * 
					 * }
					 */

					ArrayList<New_Scheme_mstr> al5 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Ready For Redemption' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and bu.user_id = "
									+ user_id );
					int redemptionReady = al5.size();

					ArrayList<New_Scheme_mstr> al6 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Processed' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and bu.user_id = "
									+ user_id );
					int processed = al6.size();

					ArrayList<New_Scheme_mstr> al3 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Freezed' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and bu.user_id = "
									+ user_id );
					int freezed = al3.size();

					ArrayList<New_Scheme_mstr> al4 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Closed' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and bu.user_id = "
									+ user_id );
					int closed = al4.size();

					model.addAttribute("incomplete", incomplete);
					model.addAttribute("approvalpending", approvalpending);
					model.addAttribute("requested", requested);
					model.addAttribute("review", review);
					model.addAttribute("provisioned", provisioned);
					model.addAttribute("launch", launch);
					model.addAttribute("active", active);
					model.addAttribute("redemptionReady", redemptionReady);
					model.addAttribute("processed", processed);
					model.addAttribute("freezed", freezed);
					model.addAttribute("closed", closed);
					model.addAttribute("daydif1", daydif1);

					return new ModelAndView("depodashboard");

				} else {
					return new ModelAndView("redirect:logout");
				}
			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	@RequestMapping("/region")
	public ModelAndView approver(HttpServletRequest request, ModelMap map, Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		try {
			if (loginString.equals("Y")) {
				HttpSession session = request.getSession();
//			session.setMaxInactiveInterval(1 * 900);

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");

				if (kwm_user != null) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					ArrayList<New_Scheme_mstr> al1 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select distinct sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where (sm.active_flag = 'Incomplete' or sm.active_flag = 'Cancel' or sm.active_flag = 'Rejected') and sm.scheme_id = sd.scheme_id and sd.sch_regn = bu.region_code and bu.user_id = "
									+ user_id);
					int incomplete = al1.size();

					ArrayList<New_Scheme_mstr> al11 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select distinct sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Pending for Approval' and sm.scheme_id = sd.scheme_id and sd.sch_regn = bu.region_code and bu.user_id = "
									+ user_id);
					int approvalpending = al11.size();

					ArrayList<New_Scheme_mstr> al2 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select distinct sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Requested' and sm.scheme_id = sd.scheme_id and sd.sch_regn = bu.region_code and bu.user_id = "
									+ user_id);
					int requested = al2.size();

					ArrayList<New_Scheme_mstr> al7 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select distinct sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Review' and sm.scheme_id = sd.scheme_id and sd.sch_regn = bu.region_code and bu.user_id = "
									+ user_id);
					int review = al7.size();

					ArrayList<New_Scheme_mstr> al8 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select distinct sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Provisioned' and sm.scheme_id = sd.scheme_id and sd.sch_regn = bu.region_code and bu.user_id = "
									+ user_id);
					int provisioned = al8.size();

					ArrayList<New_Scheme_mstr> al9 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select distinct sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Ready To Launch' and sm.scheme_id = sd.scheme_id and sd.sch_regn = bu.region_code and bu.user_id = "
									+ user_id);
					int launch = al9.size();

					ArrayList<New_Scheme_mstr> al = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select distinct sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Active' and sm.scheme_id = sd.scheme_id and sd.sch_regn = bu.region_code and bu.user_id = "
									+ user_id);
					int active = al.size();

					ArrayList<New_Scheme_mstr> al5 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select distinct sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Ready For Redemption' and sm.scheme_id = sd.scheme_id and sd.sch_regn = bu.region_code and bu.user_id = "
									+ user_id);
					int redemptionReady = al5.size();

					ArrayList<New_Scheme_mstr> al6 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select distinct sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Processed' and sm.scheme_id = sd.scheme_id and sd.sch_regn = bu.region_code and bu.user_id = "
									+ user_id);
					int processed = al6.size();

					ArrayList<New_Scheme_mstr> al3 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select distinct sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Freezed' and sm.scheme_id = sd.scheme_id and sd.sch_regn = bu.region_code and bu.user_id = "
									+ user_id);
					int freezed = al3.size();

					ArrayList<New_Scheme_mstr> al4 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select distinct sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Users bu where sm.active_flag = 'Closed' and sm.scheme_id = sd.scheme_id and sd.sch_regn = bu.region_code and bu.user_id = "
									+ user_id);
					int closed = al4.size();

					model.addAttribute("incomplete", incomplete);
					model.addAttribute("approvalpending", approvalpending);
					model.addAttribute("requested", requested);
					model.addAttribute("review", review);
					model.addAttribute("provisioned", provisioned);
					model.addAttribute("launch", launch);
					model.addAttribute("active", active);
					model.addAttribute("redemptionReady", redemptionReady);
					model.addAttribute("processed", processed);
					model.addAttribute("freezed", freezed);
					model.addAttribute("closed", closed);

					model.addAttribute("daydif1", daydif1);
					return new ModelAndView("regiondashboard");

				} else {
					return new ModelAndView("redirect:logout");
				}
			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	@RequestMapping("/TSI")
	public ModelAndView TSIapprover(HttpServletRequest request, ModelMap map, Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		try {
			if (loginString.equals("Y")) {
				HttpSession session = request.getSession();
//			session.setMaxInactiveInterval(1 * 900);

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");

				if (kwm_user != null) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					ArrayList<New_Scheme_mstr> al1 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Terr_Master tm, Bpil_Users bu where (sm.active_flag = 'Incomplete' or sm.active_flag = 'Cancel' or sm.active_flag = 'Rejected') and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and tm.depot_code = bu.depot_code and tm.terr_code = bu.terr_code and  bu.user_id = "
									+ user_id);
					int incomplete = al1.size();

					ArrayList<New_Scheme_mstr> al11 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Terr_Master tm, Bpil_Users bu where sm.active_flag = 'Pending for Approval' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and tm.depot_code = bu.depot_code and tm.terr_code = bu.terr_code and bu.user_id = "
									+ user_id);
					int approvalpending = al11.size();

					ArrayList<New_Scheme_mstr> al2 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Terr_Master tm, Bpil_Users bu where sm.active_flag = 'Requested' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and tm.depot_code = bu.depot_code and tm.terr_code = bu.terr_code and bu.user_id = "
									+ user_id);
					int requested = al2.size();

					ArrayList<New_Scheme_mstr> al7 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Terr_Master tm, Bpil_Users bu where sm.active_flag = 'Review' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and tm.depot_code = bu.depot_code and tm.terr_code = bu.terr_code and bu.user_id = "
									+ user_id);
					int review = al7.size();

					ArrayList<New_Scheme_mstr> al8 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Terr_Master tm, Bpil_Users bu where sm.active_flag = 'Provisioned' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and tm.depot_code = bu.depot_code and tm.terr_code = bu.terr_code and bu.user_id = "
									+ user_id);
					int provisioned = al8.size();

					ArrayList<New_Scheme_mstr> al9 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Terr_Master tm, Bpil_Users bu where sm.active_flag = 'Ready To Launch' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and tm.depot_code = bu.depot_code and tm.terr_code = bu.terr_code and bu.user_id = "
									+ user_id);
					int launch = al9.size();

					ArrayList<New_Scheme_mstr> al = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Terr_Master tm, Bpil_Users bu where sm.active_flag = 'Active' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and tm.depot_code = bu.depot_code and tm.terr_code = bu.terr_code and bu.user_id = "
									+ user_id);
					int active = al.size();

					ArrayList<New_Scheme_mstr> al5 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Terr_Master tm, Bpil_Users bu where sm.active_flag = 'Ready For Redemption' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and tm.depot_code = bu.depot_code and tm.terr_code = bu.terr_code and bu.user_id = "
									+ user_id);
					int redemptionReady = al5.size();

					ArrayList<New_Scheme_mstr> al6 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Terr_Master tm, Bpil_Users bu where sm.active_flag = 'Processed' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and tm.depot_code = bu.depot_code and tm.terr_code = bu.terr_code and bu.user_id = "
									+ user_id);
					int processed = al6.size();

					ArrayList<New_Scheme_mstr> al3 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Terr_Master tm, Bpil_Users bu where sm.active_flag = 'Freezed' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and tm.depot_code = bu.depot_code and tm.terr_code = bu.terr_code and bu.user_id = "
									+ user_id);
					int freezed = al3.size();

					ArrayList<New_Scheme_mstr> al4 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Scheme_Depots_Details sd, Bpil_Terr_Master tm, Bpil_Users bu where sm.active_flag = 'Closed' and sm.scheme_id = sd.scheme_id and sd.sch_depot_code = bu.depot_code and tm.depot_code = bu.depot_code and tm.terr_code = bu.terr_code and bu.user_id = "
									+ user_id);
					int closed = al4.size();

					model.addAttribute("incomplete", incomplete);
					model.addAttribute("approvalpending", approvalpending);
					model.addAttribute("requested", requested);
					model.addAttribute("review", review);
					model.addAttribute("provisioned", provisioned);
					model.addAttribute("launch", launch);
					model.addAttribute("active", active);
					model.addAttribute("redemptionReady", redemptionReady);
					model.addAttribute("processed", processed);
					model.addAttribute("freezed", freezed);
					model.addAttribute("closed", closed);

					model.addAttribute("daydif1", daydif1);
					return new ModelAndView("TSIdashboard");

				} else {
					return new ModelAndView("redirect:logout");
				}
			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	@RequestMapping("/admin")
	public ModelAndView admin(HttpServletRequest request, ModelMap map, Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		System.out.println("Admin Profile ID :- " + Bpil_User_ProfileId_List.ADMIN_PROFILE_ID);
		System.out.println("Profile ID :- " + profile_id);
		try {
			if (loginString.equals("Y")) {
				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					HttpSession session = request.getSession();
//					session.setMaxInactiveInterval(1 * 900);

					String kwm_user = (String) request.getSession().getAttribute("kwm_user");
					if (kwm_user != null) {

						int user_id = (Integer) request.getSession().getAttribute("userid");

						String PMG_ML_Group = (String) request.getSession().getAttribute("PMG_ML_grp");

//						ArrayList<New_Scheme_mstr> doc_line = schememasterdao.masterautofill(profile_id, user_id, PMG_ML_Group);
//						model.addAttribute("schememaster", doc_line);

						ArrayList<New_Scheme_mstr> al1 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
								"from New_Scheme_mstr where active_flag='Incomplete' or active_flag = 'Cancel' or active_flag = 'Rejected'");
						int incomplete = al1.size();

						ArrayList<New_Scheme_mstr> al11 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Pending for Approval'");
						int approvalpending = al11.size();

						ArrayList<New_Scheme_mstr> al2 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Requested'");
						int requested = al2.size();

						ArrayList<New_Scheme_mstr> al7 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Review'");
						int review = al7.size();

						ArrayList<New_Scheme_mstr> al8 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Provisioned'");
						int provisioned = al8.size();

						ArrayList<New_Scheme_mstr> al9 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Ready To Launch'");
						int launch = al9.size();

						ArrayList<New_Scheme_mstr> al = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Active'");
						int active = al.size();

						ArrayList<New_Scheme_mstr> al5 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Ready For Redemption'");
						int redemptionReady = al5.size();

						ArrayList<New_Scheme_mstr> al6 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Processed'");
						int processed = al6.size();

						ArrayList<New_Scheme_mstr> al3 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Freezed'");
						int freezed = al3.size();

						ArrayList<New_Scheme_mstr> al4 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Closed'");
						int closed = al4.size();

						model.addAttribute("incomplete", incomplete);
						model.addAttribute("approvalpending", approvalpending);
						model.addAttribute("requested", requested);
						model.addAttribute("review", review);
						model.addAttribute("provisioned", provisioned);
						model.addAttribute("launch", launch);
						model.addAttribute("active", active);
						model.addAttribute("redemptionReady", redemptionReady);
						model.addAttribute("processed", processed);
						model.addAttribute("freezed", freezed);
						model.addAttribute("closed", closed);
						model.addAttribute("daydif1", daydif1);

						return new ModelAndView("admindashboard");
					} else {
						return new ModelAndView("redirect:logout");
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
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	@RequestMapping("/it")
	public ModelAndView IT(HttpServletRequest request, ModelMap map, Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		System.out.println("Profile id is :-" + profile_id);
		try {
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.IT_PROFILE_ID) {
					HttpSession session = request.getSession();
//					session.setMaxInactiveInterval(1 * 900);

					String kwm_user = (String) request.getSession().getAttribute("kwm_user");
					if (kwm_user != null) {

						int user_id = (Integer) request.getSession().getAttribute("userid");

						ArrayList<New_Scheme_mstr> al1 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
								"from New_Scheme_mstr where active_flag='Incomplete' or active_flag = 'Cancel' or active_flag = 'Rejected'");
						int incomplete = al1.size();

						ArrayList<New_Scheme_mstr> al2 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Requested'");
						int requested = al2.size();

						ArrayList<New_Scheme_mstr> al11 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Pending for Approval'");
						int approvalpending = al11.size();

						ArrayList<New_Scheme_mstr> al7 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Review'");
						int review = al7.size();

						ArrayList<New_Scheme_mstr> al8 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Provisioned'");
						int provisioned = al8.size();

						ArrayList<New_Scheme_mstr> al9 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Ready To Launch'");
						int launch = al9.size();

						ArrayList<New_Scheme_mstr> al = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Active'");
						int active = al.size();

						ArrayList<New_Scheme_mstr> al5 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Ready For Redemption'");
						int redemptionReady = al5.size();

						ArrayList<New_Scheme_mstr> al6 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Processed'");
						int processed = al6.size();

						ArrayList<New_Scheme_mstr> al3 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Freezed'");
						int freezed = al3.size();

						ArrayList<New_Scheme_mstr> al4 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where active_flag='Closed'");
						int closed = al4.size();

						model.addAttribute("incomplete", incomplete);
						model.addAttribute("approvalpending", approvalpending);
						model.addAttribute("requested", requested);
						model.addAttribute("review", review);
						model.addAttribute("provisioned", provisioned);
						model.addAttribute("launch", launch);
						model.addAttribute("active", active);
						model.addAttribute("redemptionReady", redemptionReady);
						model.addAttribute("processed", processed);
						model.addAttribute("freezed", freezed);
						model.addAttribute("closed", closed);
						model.addAttribute("daydif1", daydif1);

						// Budget Vs Actual Report

						List<BudgetVsActual> dml = new ArrayList<>();
						CallableStatement cStmt;
						try {
							cStmt = hibernateConfiguration.dataSource().getConnection()
									.prepareCall("{call BPIL_BUDGET_VS_ACTUAL_RW(?,?)}");
							cStmt.setInt(1, Integer.parseInt("1628"));
							cStmt.registerOutParameter(2, OracleTypes.CURSOR);
							ResultSet result = cStmt.executeQuery();
							ResultSet rs1 = (ResultSet) cStmt.getObject(2);
							while (rs1.next()) {
								BudgetVsActual aContact = new BudgetVsActual();

								aContact.setReport_month(rs1.getString(1));
								aContact.setMl_business_line(rs1.getString(2));
								aContact.setScheme_code(rs1.getString(3));
								aContact.setScheme_name(rs1.getString(4));
								aContact.setBudget(rs1.getFloat(5));
								aContact.setExpense_before_exception(rs1.getFloat(6));
								aContact.setExpense_after_exception(rs1.getFloat(7));
								aContact.setVariance_from_budget_before_exception(rs1.getFloat(8));
								aContact.setVariance_from_budget_after_exception(rs1.getFloat(9));

								dml.add(aContact);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

						List<BudgetVsActual> dml2 = new ArrayList<>();
						CallableStatement cStmt2;
						try {
							cStmt2 = hibernateConfiguration.dataSource().getConnection()
									.prepareCall("{call BPIL_BUDGET_VS_ACTUAL_RW(?,?)}");
							cStmt2.setInt(1, Integer.parseInt("1734"));
							cStmt2.registerOutParameter(2, OracleTypes.CURSOR);
							ResultSet result = cStmt2.executeQuery();
							ResultSet rs1 = (ResultSet) cStmt2.getObject(2);
							while (rs1.next()) {
								BudgetVsActual aContact = new BudgetVsActual();

								aContact.setReport_month(rs1.getString(1));
								aContact.setMl_business_line(rs1.getString(2));
								aContact.setScheme_code(rs1.getString(3));
								aContact.setScheme_name(rs1.getString(4));
								aContact.setBudget(rs1.getFloat(5));
								aContact.setExpense_before_exception(rs1.getFloat(6));
								aContact.setExpense_after_exception(rs1.getFloat(7));
								aContact.setVariance_from_budget_before_exception(rs1.getFloat(8));
								aContact.setVariance_from_budget_after_exception(rs1.getFloat(9));

								dml2.add(aContact);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

						System.out.println("budget " + dml.get(0).getBudget() + " 1734 " + dml2.get(0).getBudget()
								+ " 1628 " + dml.get(0).getExpense_after_exception() + " 1734 "
								+ dml2.get(0).getExpense_after_exception());
						model.addAttribute("Budget1", Math.round(dml.get(0).getBudget()));
						model.addAttribute("Actual1", Math.round(dml.get(0).getExpense_after_exception()));
						model.addAttribute("Budget2", Math.round(dml2.get(0).getBudget()));
						model.addAttribute("Actual2", Math.round(dml2.get(0).getExpense_after_exception()));

						return new ModelAndView("itdashboard");
					} else {
						return new ModelAndView("redirect:logout");
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
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	@RequestMapping("/marketing")
	public ModelAndView marketing(HttpServletRequest request, ModelMap map, Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		try {
			if (loginString.equals("Y")) {
				HttpSession session = request.getSession();
//			session.setMaxInactiveInterval(1 * 900);

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");
				if (kwm_user != null) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					Integer profile_id = (Integer) request.getSession().getAttribute("profileid");

					String PMG_ML_Group = (String) request.getSession().getAttribute("PMG_ML_grp");

					ArrayList<New_Scheme_mstr> doc_line = schememasterdao.masterautofill(profile_id, user_id,
							PMG_ML_Group);
					model.addAttribute("schememaster", doc_line);

//				ArrayList<New_Scheme_mstr> al1 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("from New_Scheme_mstr where active_flag='Incomplete' and created_by = " + user_id);
//				int incomplete = al1.size();
					//
//				ArrayList<New_Scheme_mstr> al11 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("from New_Scheme_mstr where active_flag='Pending for Approval' and created_by = " + user_id);
//				int approvalpending = al11.size();
					//
//				ArrayList<New_Scheme_mstr> al2 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("from New_Scheme_mstr where active_flag='Requested' and created_by = " + user_id);
//				int requested = al2.size();
					//
//				ArrayList<New_Scheme_mstr> al7 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("from New_Scheme_mstr where active_flag='Review' and created_by = " + user_id);
//				int review = al7.size();
					//
//				ArrayList<New_Scheme_mstr> al8 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("from New_Scheme_mstr where active_flag='Provisioned' and created_by = " + user_id);
//				int provisioned = al8.size();
					//
//				ArrayList<New_Scheme_mstr> al9 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("from New_Scheme_mstr where active_flag='Ready To Launch' and created_by = " + user_id);
//				int launch = al9.size();
					//
//				ArrayList<New_Scheme_mstr> al = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("from New_Scheme_mstr where active_flag='Active' and created_by = " + user_id);
//				int active = al.size();
					//
//				ArrayList<New_Scheme_mstr> al5 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("from New_Scheme_mstr where active_flag='Ready For Redemption' and created_by = " + user_id);
//				int redemptionReady = al5.size();
					//
//				ArrayList<New_Scheme_mstr> al6 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("from New_Scheme_mstr where active_flag='Processed' and created_by = " + user_id);
//				int processed = al6.size();
					//
//				ArrayList<New_Scheme_mstr> al3 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("from New_Scheme_mstr where active_flag='Freezed' and created_by = " + user_id);
//				int freezed = al3.size();
					//
//				ArrayList<New_Scheme_mstr> al4 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
//						.find("from New_Scheme_mstr where active_flag='Closed' and created_by = " + user_id);
//				int closed = al4.size();

					ArrayList<New_Scheme_mstr> al1 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"from New_Scheme_mstr where (active_flag='Incomplete' or active_flag = 'Cancel' or active_flag = 'Rejected') and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int incomplete = al1.size();

					ArrayList<New_Scheme_mstr> al11 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"from New_Scheme_mstr where active_flag='Pending for Approval' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int approvalpending = al11.size();

					ArrayList<New_Scheme_mstr> al2 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Requested' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int requested = al2.size();

					ArrayList<New_Scheme_mstr> al7 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Review' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int review = al7.size();

					ArrayList<New_Scheme_mstr> al8 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Provisioned' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int provisioned = al8.size();

					ArrayList<New_Scheme_mstr> al9 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"from New_Scheme_mstr where active_flag='Ready To Launch' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int launch = al9.size();

					ArrayList<New_Scheme_mstr> al = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Active' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int active = al.size();

					ArrayList<New_Scheme_mstr> al5 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"from New_Scheme_mstr where active_flag='Ready For Redemption' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int redemptionReady = al5.size();

					ArrayList<New_Scheme_mstr> al6 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Processed' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int processed = al6.size();

					ArrayList<New_Scheme_mstr> al3 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Freezed' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int freezed = al3.size();

					ArrayList<New_Scheme_mstr> al4 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Closed' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int closed = al4.size();

					// dash board notification
					List<Bpil_notification> DashbordApprover_List = dashborddao.DashbordApprover_List(user_id);
					int len = DashbordApprover_List.size();
					model.addAttribute("DashbordApprover", DashbordApprover_List);
					model.addAttribute("len", len);

					model.addAttribute("incomplete", incomplete);
					model.addAttribute("approvalpending", approvalpending);
					model.addAttribute("requested", requested);
					model.addAttribute("review", review);
					model.addAttribute("provisioned", provisioned);
					model.addAttribute("launch", launch);
					model.addAttribute("active", active);
					model.addAttribute("redemptionReady", redemptionReady);
					model.addAttribute("processed", processed);
					model.addAttribute("freezed", freezed);
					model.addAttribute("closed", closed);
					model.addAttribute("daydif1", daydif1);

					return new ModelAndView("marketingdashboard");
				} else {
					return new ModelAndView("redirect:logout");
				}
			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	@RequestMapping("/marketingsupervisor")
	public ModelAndView marketingsupervisor(HttpServletRequest request, ModelMap map, Model model) {
		String loginString = (String) request.getSession().getAttribute("loginflag");
		try {
			if (loginString.equals("Y")) {
				HttpSession session = request.getSession();
//			session.setMaxInactiveInterval(1 * 900);

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");
				if (kwm_user != null) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					Integer profile_id = (Integer) request.getSession().getAttribute("profileid");

					String PMG_ML_Group = (String) request.getSession().getAttribute("PMG_ML_grp");

					ArrayList<New_Scheme_mstr> doc_line = schememasterdao.masterautofill(profile_id, user_id,
							PMG_ML_Group);
					model.addAttribute("schememaster", doc_line);

					ArrayList<New_Scheme_mstr> al1 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where (sm.active_flag = 'Incomplete' or sm.active_flag = 'Cancel' or sm.active_flag = 'Rejected') and sm.created_by = bu.user_id and bu.supervisor_id = "
									+ user_id);
					int incomplete = al1.size();

					ArrayList<New_Scheme_mstr> al11 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Pending for Approval' and sm.created_by = bu.user_id and bu.supervisor_id = "
									+ user_id);
					int approvalpending = al11.size();

					ArrayList<New_Scheme_mstr> al2 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Requested' and sm.created_by = bu.user_id and bu.supervisor_id = "
									+ user_id);
					int requested = al2.size();

					ArrayList<New_Scheme_mstr> al7 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Review' and sm.created_by = bu.user_id and bu.supervisor_id = "
									+ user_id);
					int review = al7.size();

					ArrayList<New_Scheme_mstr> al8 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Provisioned' and sm.created_by = bu.user_id and bu.supervisor_id = "
									+ user_id);
					int provisioned = al8.size();

					ArrayList<New_Scheme_mstr> al9 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Ready To Launch' and sm.created_by = bu.user_id and bu.supervisor_id = "
									+ user_id);
					int launch = al9.size();

					ArrayList<New_Scheme_mstr> al = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Active' and sm.created_by = bu.user_id and bu.supervisor_id = "
									+ user_id);
					int active = al.size();

					ArrayList<New_Scheme_mstr> al5 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Ready For Redemption' and sm.created_by = bu.user_id and bu.supervisor_id = "
									+ user_id);
					int redemptionReady = al5.size();

					ArrayList<New_Scheme_mstr> al6 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Processed' and sm.created_by = bu.user_id and bu.supervisor_id = "
									+ user_id);
					int processed = al6.size();

					ArrayList<New_Scheme_mstr> al3 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Freezed' and sm.created_by = bu.user_id and bu.supervisor_id = "
									+ user_id);
					int freezed = al3.size();

					ArrayList<New_Scheme_mstr> al4 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Closed' and sm.created_by = bu.user_id and bu.supervisor_id = "
									+ user_id);
					int closed = al4.size();

					// dash board notification
					List<Bpil_notification> DashbordApprover_List = dashborddao.DashbordApprover_List(user_id);
					int len = DashbordApprover_List.size();
					model.addAttribute("DashbordApprover", DashbordApprover_List);
					model.addAttribute("len", len);

					model.addAttribute("incomplete", incomplete);
					model.addAttribute("approvalpending", approvalpending);
					model.addAttribute("requested", requested);
					model.addAttribute("review", review);
					model.addAttribute("provisioned", provisioned);
					model.addAttribute("launch", launch);
					model.addAttribute("active", active);
					model.addAttribute("redemptionReady", redemptionReady);
					model.addAttribute("processed", processed);
					model.addAttribute("freezed", freezed);
					model.addAttribute("closed", closed);
					model.addAttribute("daydif1", daydif1);

					return new ModelAndView("supervisordashboard");
				} else {
					return new ModelAndView("redirect:logout");
				}
			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	/// HQ Dashboard

	@RequestMapping("/hq_approver")
	public ModelAndView hq_approver(HttpServletRequest request, ModelMap map, Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		try {
			if (loginString.equals("Y")) {
				HttpSession session = request.getSession();

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");
				if (kwm_user != null) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					Integer profile_id = (Integer) request.getSession().getAttribute("profileid");

					String PMG_ML_Group = (String) request.getSession().getAttribute("PMG_ML_grp");

					ArrayList<New_Scheme_mstr> doc_line = schememasterdao.masterautofill(profile_id, user_id,
							PMG_ML_Group);
					model.addAttribute("schememaster", doc_line);

					ArrayList<New_Scheme_mstr> al1 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where (sm.active_flag = 'Incomplete' or sm.active_flag = 'Cancel' or sm.active_flag = 'Rejected') and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int incomplete = al1.size();

					ArrayList<New_Scheme_mstr> al11 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Pending for HQ Approval' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int approvalpending = al11.size();

					ArrayList<New_Scheme_mstr> al2 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Requested' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int requested = al2.size();

					ArrayList<New_Scheme_mstr> al7 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Review' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int review = al7.size();

					ArrayList<New_Scheme_mstr> al8 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Provisioned' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int provisioned = al8.size();

					ArrayList<New_Scheme_mstr> al9 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Ready To Launch' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int launch = al9.size();

					ArrayList<New_Scheme_mstr> al = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Active' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int active = al.size();

					ArrayList<New_Scheme_mstr> al5 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Ready For Redemption' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int redemptionReady = al5.size();

					ArrayList<New_Scheme_mstr> al6 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Processed' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int processed = al6.size();

					ArrayList<New_Scheme_mstr> al3 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Freezed' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int freezed = al3.size();

					ArrayList<New_Scheme_mstr> al4 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Closed' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int closed = al4.size();

					// dash board notification
					List<Bpil_notification> DashbordApprover_List = dashborddao.DashbordApprover_List(user_id);
					int len = DashbordApprover_List.size();
					model.addAttribute("DashbordApprover", DashbordApprover_List);
					model.addAttribute("len", len);

					model.addAttribute("incomplete", incomplete);
					model.addAttribute("approvalpending", approvalpending);
					model.addAttribute("requested", requested);
					model.addAttribute("review", review);
					model.addAttribute("provisioned", provisioned);
					model.addAttribute("launch", launch);
					model.addAttribute("active", active);
					model.addAttribute("redemptionReady", redemptionReady);
					model.addAttribute("processed", processed);
					model.addAttribute("freezed", freezed);
					model.addAttribute("closed", closed);
					model.addAttribute("daydif1", daydif1);

					return new ModelAndView("hq_approver");
				} else {
					return new ModelAndView("redirect:logout");
				}
			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	// NA Dahboard

	@RequestMapping("/na_approver")
	public ModelAndView na_approver(HttpServletRequest request, ModelMap map, Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		try {
			if (loginString.equals("Y")) {
				HttpSession session = request.getSession();

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");
				if (kwm_user != null) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					Integer profile_id = (Integer) request.getSession().getAttribute("profileid");

					String PMG_ML_Group = (String) request.getSession().getAttribute("PMG_ML_grp");

					ArrayList<New_Scheme_mstr> doc_line = schememasterdao.masterautofill(profile_id, user_id,
							PMG_ML_Group);
					model.addAttribute("schememaster", doc_line);

					ArrayList<New_Scheme_mstr> al1 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where (sm.active_flag = 'Incomplete' or sm.active_flag = 'Cancel' or sm.active_flag = 'Rejected') and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int incomplete = al1.size();

					ArrayList<New_Scheme_mstr> al11 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Pending for NA Approval' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int approvalpending = al11.size();

					ArrayList<New_Scheme_mstr> al2 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Requested' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int requested = al2.size();

					ArrayList<New_Scheme_mstr> al7 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Review' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int review = al7.size();

					ArrayList<New_Scheme_mstr> al8 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Provisioned' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int provisioned = al8.size();

					ArrayList<New_Scheme_mstr> al9 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Ready To Launch' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int launch = al9.size();

					ArrayList<New_Scheme_mstr> al = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Active' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int active = al.size();

					ArrayList<New_Scheme_mstr> al5 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Ready For Redemption' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int redemptionReady = al5.size();

					ArrayList<New_Scheme_mstr> al6 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Processed' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int processed = al6.size();

					ArrayList<New_Scheme_mstr> al3 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Freezed' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int freezed = al3.size();

					ArrayList<New_Scheme_mstr> al4 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Closed' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int closed = al4.size();

					// dash board notification
					List<Bpil_notification> DashbordApprover_List = dashborddao.DashbordApprover_List(user_id);
					int len = DashbordApprover_List.size();
					model.addAttribute("DashbordApprover", DashbordApprover_List);
					model.addAttribute("len", len);

					model.addAttribute("incomplete", incomplete);
					model.addAttribute("approvalpending", approvalpending);
					model.addAttribute("requested", requested);
					model.addAttribute("review", review);
					model.addAttribute("provisioned", provisioned);
					model.addAttribute("launch", launch);
					model.addAttribute("active", active);
					model.addAttribute("redemptionReady", redemptionReady);
					model.addAttribute("processed", processed);
					model.addAttribute("freezed", freezed);
					model.addAttribute("closed", closed);
					model.addAttribute("daydif1", daydif1);

					return new ModelAndView("na_approver");
				} else {
					return new ModelAndView("redirect:logout");
				}
			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	// RG Dahboard

	@RequestMapping("/rg_approver")
	public ModelAndView rg_approver(HttpServletRequest request, ModelMap map, Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		try {
			if (loginString.equals("Y")) {
				HttpSession session = request.getSession();

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");
				if (kwm_user != null) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					System.out.println(user_id + " --------------------------------------------------------");

					Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
					System.out.println(profile_id + " --------------------------------------------------------");

					String PMG_ML_Group = (String) request.getSession().getAttribute("PMG_ML_grp");
					System.out.println(PMG_ML_Group + " --------------------------------------------------------");

					ArrayList<New_Scheme_mstr> doc_line = schememasterdao.masterautofill(profile_id, user_id,
							PMG_ML_Group);

					model.addAttribute("schememaster", doc_line);
					ArrayList<New_Scheme_mstr> al1 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"from New_Scheme_mstr where (active_flag='Incomplete' or active_flag = 'Cancel' or active_flag = 'Rejected') and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int incomplete = al1.size();
					System.out.println(incomplete + " --------------------------------------------------------");
					ArrayList<New_Scheme_mstr> al11 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"from New_Scheme_mstr where active_flag='Pending for Approval' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int approvalpending = al11.size();

					System.out.println(approvalpending + " --------------------------------------------------------");
					ArrayList<New_Scheme_mstr> al2 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Requested' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int requested = al2.size();
					System.out.println(requested + " --------------------------------------------------------");
					ArrayList<New_Scheme_mstr> al7 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Review' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int review = al7.size();
					System.out.println(review + " --------------------------------------------------------");
					ArrayList<New_Scheme_mstr> al8 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Provisioned' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int provisioned = al8.size();
					System.out.println(provisioned + " --------------------------------------------------------");
					ArrayList<New_Scheme_mstr> al9 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"from New_Scheme_mstr where active_flag='Ready To Launch' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int launch = al9.size();
					System.out.println(launch + " --------------------------------------------------------");
					ArrayList<New_Scheme_mstr> al = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Active' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int active = al.size();
					System.out.println(active + " --------------------------------------------------------");
					ArrayList<New_Scheme_mstr> al5 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"from New_Scheme_mstr where active_flag='Ready For Redemption' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int redemptionReady = al5.size();

					ArrayList<New_Scheme_mstr> al6 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Processed' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int processed = al6.size();

					ArrayList<New_Scheme_mstr> al3 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Freezed' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int freezed = al3.size();

					ArrayList<New_Scheme_mstr> al4 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where active_flag='Closed' and scheme_business_line = '"
									+ PMG_ML_Group + "'");
					int closed = al4.size();

					// dash board notification
					List<Bpil_notification> DashbordApprover_List = dashborddao.DashbordApprover_List(user_id);
					int len = DashbordApprover_List.size();
					model.addAttribute("DashbordApprover", DashbordApprover_List);
					model.addAttribute("len", len);

					model.addAttribute("incomplete", incomplete);
					model.addAttribute("approvalpending", approvalpending);
					model.addAttribute("requested", requested);
					model.addAttribute("review", review);
					model.addAttribute("provisioned", provisioned);
					model.addAttribute("launch", launch);
					model.addAttribute("active", active);
					model.addAttribute("redemptionReady", redemptionReady);
					model.addAttribute("processed", processed);
					model.addAttribute("freezed", freezed);
					model.addAttribute("closed", closed);
					model.addAttribute("daydif1", daydif1);

					return new ModelAndView("rg_approver");
				} else {
					return new ModelAndView("redirect:logout");
				}
			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	// BR Dahboard

	@RequestMapping("/br_approver")
	public ModelAndView br_approver(HttpServletRequest request, ModelMap map, Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		try {
			if (loginString.equals("Y")) {
				HttpSession session = request.getSession();

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");
				if (kwm_user != null) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					Integer profile_id = (Integer) request.getSession().getAttribute("profileid");

					String PMG_ML_Group = (String) request.getSession().getAttribute("PMG_ML_grp");

					ArrayList<New_Scheme_mstr> doc_line = schememasterdao.masterautofill(profile_id, user_id,
							PMG_ML_Group);
					model.addAttribute("schememaster", doc_line);

					ArrayList<New_Scheme_mstr> al1 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where (sm.active_flag = 'Incomplete' or sm.active_flag = 'Cancel' or sm.active_flag = 'Rejected') and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int incomplete = al1.size();

					ArrayList<New_Scheme_mstr> al11 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Pending for BR Approval' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int approvalpending = al11.size();

					ArrayList<New_Scheme_mstr> al2 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Requested' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);

					int requested = al2.size();

					ArrayList<New_Scheme_mstr> al7 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Review' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int review = al7.size();

					ArrayList<New_Scheme_mstr> al8 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Provisioned' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int provisioned = al8.size();

					ArrayList<New_Scheme_mstr> al9 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Ready To Launch' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int launch = al9.size();

					ArrayList<New_Scheme_mstr> al = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Active' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int active = al.size();

					ArrayList<New_Scheme_mstr> al5 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Ready For Redemption' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int redemptionReady = al5.size();

					ArrayList<New_Scheme_mstr> al6 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Processed' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int processed = al6.size();

					ArrayList<New_Scheme_mstr> al3 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Freezed' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int freezed = al3.size();

					ArrayList<New_Scheme_mstr> al4 = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find(
							"select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag = 'Closed' and sm.created_by = bu.user_id and bu.user_id = "
									+ user_id);
					int closed = al4.size();

					// dash board notification
					List<Bpil_notification> DashbordApprover_List = dashborddao.DashbordApprover_List(user_id);
					int len = DashbordApprover_List.size();
					model.addAttribute("DashbordApprover", DashbordApprover_List);
					model.addAttribute("len", len);

					model.addAttribute("incomplete", incomplete);
					model.addAttribute("approvalpending", approvalpending);
					model.addAttribute("requested", requested);
					model.addAttribute("review", review);
					model.addAttribute("provisioned", provisioned);
					model.addAttribute("launch", launch);
					model.addAttribute("active", active);
					model.addAttribute("redemptionReady", redemptionReady);
					model.addAttribute("processed", processed);
					model.addAttribute("freezed", freezed);
					model.addAttribute("closed", closed);
					model.addAttribute("daydif1", daydif1);

					return new ModelAndView("br_approver");
				} else {
					return new ModelAndView("redirect:logout");
				}
			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return new ModelAndView("login");
			}
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return new ModelAndView("login");
		}

	}

	@RequestMapping(value = "/menuactive", method = RequestMethod.GET)
	public void menuactive(@RequestParam(value = "menu_header_id") String menu_header_id, HttpServletRequest request,
			Model model, HttpServletResponse response) {
		try {
			request.getSession().setAttribute("activemenu", menu_header_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/getmenuactive", method = RequestMethod.GET)
	public String getmenuactive(HttpServletRequest request, Model model, HttpServletResponse response) {
		String loginString = (String) request.getSession().getAttribute("loginflag");
		System.out.println("getmenuactive::" + loginString);
		try {
			if (loginString.equals("Y")) {
				String menuid = (String) request.getSession().getAttribute("activemenu");

				String json = null;

				json = new Gson().toJson(menuid);
				response.setContentType("application/json");
				response.getWriter().write(json);
				return json;
			} else {
				response.sendRedirect("unauthorizedattempt");
			}

		} catch (IOException e) {
			return "unauthorizedattempt";
		} catch (NullPointerException e) {
			return "unauthorizedattempt";
		}
		return "login";
	}

	@RequestMapping("/logout")
	public ModelAndView LogoutForm(HttpServletRequest request, ModelMap map, Model model) {
		HttpSession session = request.getSession();

		Integer user_id = (Integer) request.getSession().getAttribute("userid");

		if (user_id != null) {
			int userid = user_id;
			System.out.println(userid);

			List<Bpil_Menu_Header> menu_group = bpilLoginService.getMenuGroup1(userid);
			for (Bpil_Menu_Header mg : menu_group) {
//				System.out.println(
//						"menus" + mg.getMenu_header_id() + " " + mg.getHeader_name() + " " + mg.getAction_name());

				List<Bpil_Menu_Line> menu_line = bpilLoginService.getMenuLine(mg.getMenu_header_id());

				for (Bpil_Menu_Line ml : menu_line) {

//					System.out.println("submenu" + ml.getMenu_line_id() + " " + ml.getMenu_header_id() + " "
//							+ ml.getLine_name() + " " + ml.getAction_name());

				}

				if (menu_line.isEmpty()) {

				} else {

//					System.out.println("submenu" + Integer.toString(mg.getMenu_header_id()));

					session.removeAttribute("submenu" + Integer.toString(mg.getMenu_header_id()));

				}

			}

			session.removeAttribute("menus");

		}

//		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
//
//		if (profile_id != null) {
//			int profileid = profile_id;
//			System.out.println(profileid);
//
//			List<Bpil_Main_Menu> menu_group = bpilLoginService.getMenuGroup(profileid);
//
//			for (Bpil_Main_Menu mg : menu_group) {
//				System.out.println(mg.getMain_menu_id() + " " + mg.getMain_menu_name());
//
//				System.out.println("submenu" + Integer.toString(mg.getMain_menu_id()));
//
//				List<Bpil_Sub_Menu> menu_line = bpilLoginService.getSubMenuLine(mg.getMain_menu_id());
//
//				for (Bpil_Sub_Menu ml : menu_line) {
//
//					System.out.println(ml.getSub_menu_id() + " " + ml.getMain_menu_id() + " " + ml.getSub_menu_name());
//
//				}
//				session.removeAttribute("submenu" + Integer.toString(mg.getMain_menu_id()));
//
//			}
//			session.removeAttribute("menus");
//
//		}

		session.removeAttribute("kwm_user");
		session.removeAttribute("username");
		session.removeAttribute("userid");
		session.removeAttribute("profileid");

//		request.getSession(false);

		session.invalidate();
		System.out.println("session destroyrd");
		Bpil_Users kwm_users = new Bpil_Users();
		map.addAttribute("kwm_users", kwm_users);

		return new ModelAndView("login");

	}

	@RequestMapping("sessionInvalid")
	public ModelAndView sessionInvalid(HttpServletRequest request, ModelMap map) {

		Bpil_Users kwm_users = new Bpil_Users();
		map.addAttribute("kwm_users", kwm_users);

		return new ModelAndView("login");
	}

	@RequestMapping("/hello")
	public ModelAndView hello(HttpServletRequest request, Model model, ModelMap map) {
		System.out.println("inside hello method-----------------------------------------------------");

		List<Bpil_Users> arr = new ArrayList<Bpil_Users>();
		arr = schememasterdao.getall();
		for (Bpil_Users student : arr) {
			System.out.println(student); // Will invoke overrided `toString()` method
			System.out.println(student.getSupervisor_id() + "-----------------------------------"); // Will invoke
																									// overrided
																									// `toString()`
																									// method
		}
		model.addAttribute("data", arr);

		return new ModelAndView("hello");
	}

//	@RequestMapping("/submenu")
//	public void sessionInvalid2(HttpServletRequest request, ModelMap map, @RequestParam(value = "name") String sid,
//			HttpServletResponse response) {
//
//		System.out.println("Hi ....thi s is call from sumenu");
//		System.out.println("-------------------------Submenu is" + sid);
//
//		// HttpSession session = request.getSession();
//		String sql = "";
//
//		sql = "select distinct mh.MENU_HEADER_ID from BPIL_MENU_HEADER mh, BPIL_MENU_GROUP mg, BPIL_USERS us "
//				+ " where  mh.MENU_GROUP_ID = mg.MENU_GROUP_ID and mg.MENU_GROUP_ID =  us.MENU_GROUP_ID ORDER BY MENU_HEADER_ID ASC";
//
//		List<Bpil_Menu_Header> kwm_menu_groups = jdbcTemplate.query(sql, new RowMapper<Bpil_Menu_Header>() {
//
//			@Override
//			public Bpil_Menu_Header mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Bpil_Menu_Header kwm_menu_group = new Bpil_Menu_Header();
//				kwm_menu_group.setMenu_header_id(rs.getInt("MENU_HEADER_ID"));
//				return kwm_menu_group;
//			}
//		});
//		HashMap<String, List<Bpil_Menu_Line>> map1 = new HashMap<>();
//		for (Bpil_Menu_Header mg : kwm_menu_groups) {
//			List<Bpil_Menu_Line> menu_line = bpilLoginService.getMenuLine(mg.getMenu_header_id());
//			if (menu_line.size() > 0) {
//
//				// session.setAttribute("submenu2" + Integer.toString(mg.getMenu_header_id()),
//				// menu_line);
//				map1.put("submenu2" + Integer.toString(mg.getMenu_header_id()), menu_line);
//
//			}
//
//		}
//
//		List<String> subb = new ArrayList<String>();
//		if (map1.containsKey("submenu2" + sid)) {
//			List<Bpil_Menu_Line> mgls = new ArrayList<Bpil_Menu_Line>();
//
//			mgls = map1.get("submenu2" + sid);
//
//			for (Bpil_Menu_Line mgl : mgls) {
//				subb.add(mgl.getLine_name());
//
//			}
//		}
//		System.out.println(subb.toString());
//		String json = null;
//		json = new Gson().toJson(subb);
//		response.setContentType("application/json");
//		try {
//			response.getWriter().write(json);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
	@RequestMapping("/submenu")
	public void sessionInvalid2(HttpServletRequest request, ModelMap map, @RequestParam(value = "name") String sid,
			HttpServletResponse response) throws IOException {

		System.out.println("Hi ....thi s is call from sumenu");
		System.out.println("-------------------------Submenu is" + sid);

		// HttpSession session = request.getSession();
//		String sql = "";
//
//		sql = "select distinct mh.MENU_HEADER_ID from BPIL_MENU_HEADER mh, BPIL_MENU_GROUP mg, BPIL_USERS us "
//				+ " where  mh.MENU_GROUP_ID = mg.MENU_GROUP_ID and mg.MENU_GROUP_ID =  us.MENU_GROUP_ID ORDER BY MENU_HEADER_ID ASC";
//
//		List<Bpil_Menu_Header> kwm_menu_groups = jdbcTemplate.query(sql, new RowMapper<Bpil_Menu_Header>() {
//
//			@Override
//			public Bpil_Menu_Header mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Bpil_Menu_Header kwm_menu_group = new Bpil_Menu_Header();
//				kwm_menu_group.setMenu_header_id(rs.getInt("MENU_HEADER_ID"));
//				return kwm_menu_group;
//			}
//		});
		HashMap<String, List<Bpil_Menu_Line>> map1 = new HashMap<>();
	
			List<Bpil_Menu_Line> menu_line = bpilLoginService.getMenuLine(Integer.parseInt(sid));
			if (menu_line.size() > 0) {

				// session.setAttribute("submenu2" + Integer.toString(mg.getMenu_header_id()),
				// menu_line);
				map1.put("submenu2" + sid, menu_line);

			}

		

		List<String> subb = new ArrayList<String>();
		List<String> subb1 = new ArrayList<String>();
		HashMap<Integer,String> att = new HashMap<Integer,String>();

		if (map1.containsKey("submenu2" + sid)) {
			List<Bpil_Menu_Line> mgls = new ArrayList<Bpil_Menu_Line>();

			mgls = map1.get("submenu2" + sid);

			for (Bpil_Menu_Line mgl : mgls) {
				att.put(mgl.getMenu_line_id(),mgl.getLine_name());
				//subb.add(mgl.getLine_name());
				//subb.add(Integer.toString(mgl.getMenu_line_id()));
				//subb1.add(Integer.toString(mgl.getMenu_line_id()));

			}
		}
		System.out.println(att.toString());
		
		
		  String json = null;
		  json = new Gson().toJson(att);
		  System.out.println(json);
		  response.setContentType("application/json");
		   try {
		  response.getWriter().write(json); } catch (IOException e) {  e.printStackTrace(); }
		 
		/*
		 * String json = null; JSONObject list1 = new JSONObject();
		 * list1.put("name",subb); list1.put("id",subb1);
		 * response.setContentType("application/json"); try {
		 * response.getWriter().write(list1.toJSONString());
		 * //response.getWriter().write(subb.toString()); } catch (IOException e) {
		 * e.printStackTrace(); } System.out.println(subb1.toString());
		 */

	}

	@RequestMapping(value = "/updatestudent", method = RequestMethod.POST)
	public ModelAndView updatestudent(@ModelAttribute Student s, HttpServletRequest request, Model model,
			ModelMap map) {
		System.out.println("inside updatestudent method-----------------------------------------------------");
		schememasterdao.getall2(s);
		List<Student> arr = (List<Student>) hibernateTemplate.find("from Student");
		model.addAttribute("data", arr);

		return new ModelAndView("updatestudent");

	}

	@RequestMapping("student")
	public ModelAndView student3(@ModelAttribute Student s, HttpServletRequest request, Model model, ModelMap map) {
		return new ModelAndView("student");

	}

	@RequestMapping("fetchstudent/id")
	public ModelAndView fetchStudent(HttpServletRequest request, ModelMap map, @RequestParam(value = "id") int id,
			Model m) {
		List<Student> arr = (List<Student>) hibernateTemplate.find("from Student where Id=?", id);
		m.addAttribute("stu", arr.get(0));

		System.out.println(id + "----------------------------");
		return new ModelAndView("updatestudent");

	}

	@Transactional
	@RequestMapping("fetchemployee")
	public ModelAndView employee(@RequestParam(value = "fileToUpload") CommonsMultipartFile[] FILEATTACH,
			HttpServletRequest req, ModelMap map, Model model) {
		System.out.println("inside employee method-----------------------------------------------------");
		System.out.println("save data hit----");
		EmpFile ef = new EmpFile();
		String name = req.getParameter("name");
		String city = req.getParameter("city");
		Employee1 e = new Employee1();

		e.setNAME(name);
		e.setCITY(city);
		hibernateTemplate.save(e);
//       int id=e.getID();
//       ef.setFID(id);
		for (CommonsMultipartFile mf : FILEATTACH) {
			try {
				ef.setFILEATTACH(mf.getBytes());
				ef.setFSIZE(mf.getSize());
				ef.setFTYPE(mf.getContentType());
				System.out.println(mf.getOriginalFilename() + "------------------------------------");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			hibernateTemplate.saveOrUpdate(ef);
		}
		System.out.println(name + "----------------");
		return new ModelAndView("fetchemployee");
	}

	@RequestMapping("employee")
	public ModelAndView employeefile(HttpServletRequest request, ModelMap map) {

		return new ModelAndView("employee");
	}

	@PostMapping("/mobileno")
	public String sendOTP(@RequestBody SmsPojo sms) {
		System.out.println("inside____________________________");
		try {
			System.out.println(sms.getPhoneNo());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Successfully OTP Sent To Your Mobile Number";
	}

	@RequestMapping(value = "/testmenu")
	public void testmenu(ModelMap map, Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("name") int name) throws IOException {

		System.out.println("you are in ------------ /testmenu");
		HttpSession session = request.getSession();
		// List<Bpil_Menu_Header> menu_group = null;
		System.out.println(name);
		String kwm_user = (String) request.getSession().getAttribute("kwm_user");
		List<Bpil_Menu_Header> kwm_menu_groups = new ArrayList<Bpil_Menu_Header>();
		if (kwm_user != null) {
			String username = (String) request.getSession().getAttribute("username");
			int user_id = (Integer) request.getSession().getAttribute("userid");

			String sql = "select distinct mh.MENU_HEADER_ID,mh.HEADER_NAME from BPIL_MENU_HEADER mh, BPIL_MENU_GROUP mg, BPIL_USERS us "
					+ " where  mh.MENU_GROUP_ID = " + name + " and mg.MENU_GROUP_ID =  " + name + " "
					+ " ORDER BY MENU_HEADER_ID ASC";

			kwm_menu_groups = jdbcTemplate.query(sql, new RowMapper<Bpil_Menu_Header>() {

				@Override
				public Bpil_Menu_Header mapRow(ResultSet rs, int rowNum) throws SQLException {
					Bpil_Menu_Header kwm_menu_group = new Bpil_Menu_Header();

					kwm_menu_group.setMenu_header_id(rs.getInt("MENU_HEADER_ID"));
					kwm_menu_group.setHeader_name(rs.getString("HEADER_NAME"));
					// kwm_menu_group.setAction_name(rs.getString("ACTION_NAME"));

					return kwm_menu_group;
				}
			});

		}
		 
		
		String json = null;
		System.out.println("you are in ------------ ---------------------------------------------"
				+ kwm_menu_groups.get(0).getHeader_name());
		System.out.println("you are in ------------ ---------------------------------------------"
				+ kwm_menu_groups.get(0).getMenu_header_id());
		System.out.println("you are in ------------ ---------------------------------------------"
				+ kwm_menu_groups.get(1).getHeader_name());
		System.out.println("you are in ------------ ---------------------------------------------"
				+ kwm_menu_groups.get(1).getMenu_header_id());
		json = new Gson().toJson(kwm_menu_groups);
		response.setContentType("application/json");
		response.getWriter().write(json);

	}

	
	@RequestMapping(value = "/testproduct")
	public void getproductname(ModelMap map, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("you are in ------------ /testproduct");
		HttpSession session = request.getSession();	
		String name="";
		String kwm_user = (String) request.getSession().getAttribute("kwm_user");
		List<Bpil_Menu_Header> kwm_menu_groups = new ArrayList<Bpil_Menu_Header>();
		if (kwm_user != null) {
			String username = (String) request.getSession().getAttribute("username");
			int user_id = (Integer) request.getSession().getAttribute("userid");

			String sql = "select distinct mh.MENU_HEADER_ID,mh.HEADER_NAME from BPIL_MENU_HEADER mh, BPIL_MENU_GROUP mg, BPIL_USERS us "
					+ " where  mh.MENU_GROUP_ID = " + name + " and mg.MENU_GROUP_ID =  " + name + " "
					+ " ORDER BY MENU_HEADER_ID ASC";
			
		

			kwm_menu_groups = jdbcTemplate.query(sql, new RowMapper<Bpil_Menu_Header>() {

				@Override
				public Bpil_Menu_Header mapRow(ResultSet rs, int rowNum) throws SQLException {
					Bpil_Menu_Header kwm_menu_group = new Bpil_Menu_Header();

					kwm_menu_group.setMenu_header_id(rs.getInt("MENU_HEADER_ID"));
					kwm_menu_group.setHeader_name(rs.getString("HEADER_NAME"));
					// kwm_menu_group.setAction_name(rs.getString("ACTION_NAME"));

					return kwm_menu_group;
				}
			});

		}
		 
		
		String json = null;
		System.out.println("you are in ------------ ---------------------------------------------"
				+ kwm_menu_groups.get(0).getHeader_name());
		System.out.println("you are in ------------ ---------------------------------------------"
				+ kwm_menu_groups.get(0).getMenu_header_id());
		System.out.println("you are in ------------ ---------------------------------------------"
				+ kwm_menu_groups.get(1).getHeader_name());
		System.out.println("you are in ------------ ---------------------------------------------"
				+ kwm_menu_groups.get(1).getMenu_header_id());
		json = new Gson().toJson(kwm_menu_groups);
		response.setContentType("application/json");
		response.getWriter().write(json);

	}


}

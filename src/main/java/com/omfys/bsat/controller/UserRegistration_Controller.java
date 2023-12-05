package com.omfys.bsat.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
import com.omfys.bsat.repository.SchemeMasterDao;
import com.omfys.bsat.repository.UserRegistrationDao;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.LookupAutofill;
import com.omfys.bsat.model.New_Scheme_mstr;
import com.omfys.bsat.model.SysAdmin_Users;
import com.omfys.bsat.model.ADList;
import com.omfys.bsat.model.BPIL_MENU;
import com.omfys.bsat.model.BPIL_SHILPI;
import com.omfys.bsat.model.Bpil_LookupValues;

import com.omfys.bsat.model.Bpil_User_Assignment;
import com.omfys.bsat.model.Bpil_User_ProfileId_List;
import com.omfys.bsat.model.Bpil_User_Role_Assignment;
import com.omfys.bsat.model.User_pref;
import com.omfys.bsat.service.BpilLoginService;
import com.omfys.bsat.service.UserRegistrationService;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Controller
public class UserRegistration_Controller {

	@Autowired
	UserRegistrationService userregi;

	@Autowired
	BpilLoginService wasibLoginService;

	@Autowired
	private MenuGroupDao menudao;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public static final String ALGORITHM = "AES";
	public static final String KEY = "1Hbfh667adfDEJ78";

	/*
	 * @RequestMapping("/userregistration") public ModelAndView
	 * DocumentLoad(ModelMap map, Model model, HttpServletRequest request) {
	 * 
	 * String loginString = (String) request.getSession().getAttribute("loginflag");
	 * Integer profile_id = (Integer)
	 * request.getSession().getAttribute("profileid");
	 * System.out.println("------------------inside userregistration conroller");
	 * try { Login Checking Code Start if (loginString.equals("Y")) {
	 * 
	 * if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) { String
	 * kwm_user = (String) request.getSession().getAttribute("kwm_user");
	 * 
	 * String password = (String) request.getSession().getAttribute("password");
	 * Bpil_Users user = userregi.getUserByUsername(kwm_user);
	 * 
	 * String adUsername = user.getActive_directory_id();
	 * 
	 * // for Omfys network // if(adUsername == null){ // adUsername =
	 * "Sushant.Kamble"; // password = "Omfys@123"; // }
	 * 
	 * // for Berger network if (adUsername == null) { adUsername = "harsup";
	 * System.out.println("inside null block"); password = "berger@123"; }
	 * 
	 * if (kwm_user != null) { System.out.println("autofill");
	 * System.out.println("inside null block"); Bpil_Users userreg = new
	 * Bpil_Users(); List<ADList> ADList =
	 * wasibLoginService.getActiveDirectoryUserList(adUsername, password);
	 * List<ADList> toRemove = new ArrayList<ADList>();
	 * 
	 * // Removing used AD Id's List<Bpil_Users> users =
	 * wasibLoginService.getNonADUserList();
	 * 
	 * Iterator<ADList> itr = ADList.iterator(); while (itr.hasNext()) { ADList ad =
	 * itr.next(); Iterator<Bpil_Users> itr2 = users.iterator(); while
	 * (itr2.hasNext()) { Bpil_Users usr = itr2.next(); if
	 * (usr.getActive_directory_id().equals(ad.getAd_id())) { toRemove.add(ad); } }
	 * }
	 * 
	 * ADList.removeAll(toRemove); map.addAttribute("ADList", ADList);
	 * map.addAttribute("userreg", userreg); }
	 * 
	 * return new ModelAndView("NewUserRegistration"); } else {
	 * System.out.println("-----------after jsp"); return new
	 * ModelAndView("unauthorizedattempt"); }
	 * 
	 * } else { Bpil_Users kwm_users = new Bpil_Users();
	 * map.addAttribute("kwm_users", kwm_users);
	 * System.out.println("Here ------> berger login"); // Cursor comes // to here
	 * return new ModelAndView("login"); } Login Checking Code Ends } catch
	 * (NullPointerException e) { Bpil_Users kwm_users = new Bpil_Users();
	 * map.addAttribute("kwm_users", kwm_users);
	 * System.out.println("Here ------> berger login"); // Cursor comes to // here
	 * return new ModelAndView("login"); }
	 * 
	 * }
	 */

	@RequestMapping("/userregistration")
	public ModelAndView DocumentLoad(ModelMap map, Model model, HttpServletRequest request) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		System.out.println("------------------inside userregistration conroller");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					String kwm_user = (String) request.getSession().getAttribute("kwm_user");

					String password = (String) request.getSession().getAttribute("password");
					Bpil_Users user = userregi.getUserByUsername(kwm_user);

					String adUsername = user.getActive_directory_id();

					// for Omfys network
					// if(adUsername == null){
					// adUsername = "Sushant.Kamble";
					// password = "Omfys@123";
					// }

					// for Berger network
					if (adUsername == null) {
						adUsername = "harsup";
						System.out.println("inside null block");
						password = "berger@123";
					}

					if (kwm_user != null) {
						System.out.println("autofill");
						System.out.println("inside null block");
						Bpil_Users userreg = new Bpil_Users();
						List<ADList> ADList = wasibLoginService.getActiveDirectoryUserList(adUsername, password);
						List<ADList> toRemove = new ArrayList<ADList>();

						// Removing used AD Id's
						List<Bpil_Users> users = wasibLoginService.getNonADUserList();

						Iterator<ADList> itr = ADList.iterator();
						while (itr.hasNext()) {
							ADList ad = itr.next();
							Iterator<Bpil_Users> itr2 = users.iterator();
							while (itr2.hasNext()) {
								Bpil_Users usr = itr2.next();
								if (usr.getActive_directory_id().equals(ad.getAd_id())) {
									toRemove.add(ad);
								}
							}
						}

						ADList.removeAll(toRemove);
						map.addAttribute("ADList", ADList);
						map.addAttribute("userreg", userreg);
						
					}
					System.out.println("-----------New User------------------------ jsp");
					return new ModelAndView("NewUserRegistration");
				} else {
					System.out.println("-----------after jsp");
					return new ModelAndView("unauthorizedattempt");
				}

			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes
																	// to here
				return new ModelAndView("login");
			}
			/* Login Checking Code Ends */
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to
																// here
			return new ModelAndView("login");
		}

	}

	@Transactional
	@RequestMapping(value = "/NewRegistration", method = RequestMethod.POST)
	public ModelAndView saveServiceRequest(@ModelAttribute Bpil_Users Koel_user, BindingResult resultKoel_user,
			Model model, ModelMap map, HttpServletRequest request) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");

		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					int user_id = (Integer) request.getSession().getAttribute("userid");

					System.out.println("user " + Koel_user.getUser_id());

					Date start_date = null;
					if (request.getParameter("start_date") != null && request.getParameter("start_date") != "") {
						try {
							start_date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("start_date"));
						} catch (ParseException e) {

							e.printStackTrace();
						}
					}
					Date end_date = null;
					if (request.getParameter("end_date") != null && request.getParameter("end_date") != "") {
						try {
							end_date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("end_date"));
						} catch (ParseException e) {

							e.printStackTrace();
						}
					}
					String user_name = request.getParameter("user_name");

					String password = request.getParameter("password");

					if (password != null) {
						Key key = null;
						Cipher cipher = null;
						try {
							key = generateKey();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						try {
							cipher = Cipher.getInstance(UserRegistration_Controller.ALGORITHM);
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchPaddingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							cipher.init(Cipher.ENCRYPT_MODE, key);
						} catch (InvalidKeyException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						byte[] encryptedByteValue = null;
						try {
							encryptedByteValue = cipher.doFinal(password.getBytes("utf-8"));
						} catch (IllegalBlockSizeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BadPaddingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String encryptedValue = new BASE64Encoder().encode(encryptedByteValue);

						System.out.println("encrypted pass" + encryptedValue);

						Koel_user.setPassword(encryptedValue);
					}

					String user_ststus = request.getParameter("user_status");
					System.out.println(user_ststus+"iiiiiiiiiiiiiiiiiiiiiiii");
					  if (user_ststus !=null) { user_ststus = "Y"; }
					  
					  
					String first_name = request.getParameter("first_name");
					String middle_name = request.getParameter("middle_name");
					String last_name = request.getParameter("last_name");
					String contact_number = request.getParameter("contact_number");
					String email_address = request.getParameter("email_address");
					String profile_id1 = request.getParameter("profile_id");
					String user_type = request.getParameter("user_type");
					String menu_group_id = request.getParameter("menu_group_id");
					String supervisor_id = request.getParameter("supervisor_id");
					String region_code = request.getParameter("region_code");
					String depot_code = request.getParameter("depot_code");
					String active_directory_id = request.getParameter("active_directory_id");
					String terr_code = request.getParameter("terr_code");

					Koel_user.setUser_name(user_name);
					// Koel_user.setPassword("Welcome@123");
					Koel_user.setFirst_name(first_name);
					Koel_user.setMiddle_name(middle_name);
					Koel_user.setLast_name(last_name);
					Koel_user.setContact_number(contact_number);
					Koel_user.setEmail_address(email_address);

					Koel_user.setStart_date(start_date);
					Koel_user.setEnd_date(end_date);
					Koel_user.setCreated_by(user_id);
					Koel_user.setLast_updated_by(user_id);
					// Koel_user.setIs_active("N");
					Koel_user.setIs_active(user_ststus);
					if (profile_id1 != "") {
						Koel_user.setProfile_id(Integer.parseInt(profile_id1));
					}
					Koel_user.setUser_type(user_type);
					if (menu_group_id != "") {
						Koel_user.setMenu_group_id(Integer.parseInt(menu_group_id));
					}
					if (supervisor_id != "") {
						Koel_user.setSupervisor_id(Integer.parseInt(supervisor_id));
					}
					Koel_user.setRegion_code(region_code);
					Koel_user.setDepot_code(depot_code);
					Koel_user.setActive_directory_id(active_directory_id);
					if (terr_code != null) {
						Koel_user.setTerr_code(terr_code);
					}

					int id = 0;
					if (request.getParameter("user_id") != "") {
						id = Integer.parseInt(request.getParameter("user_id"));
						System.out.println(request.getParameter("user_id") + "------------------olduserid");
					}

					int newuserId = userregi.CreateUser(Koel_user, id);

					System.out.println(newuserId + "           -----------------newuserId");
					System.out.println("newuserId " + newuserId);	
					String str[] = request.getParameterValues("sel_menu");
					System.out.println(str.toString()+" str "+str.length);
					String str2[] = request.getParameterValues("mySelect");// string separate by ,
					System.out.println(str2.toString()+" str2 "+str.length);
					System.out.println(str2+"878--------------submenu---------------------------------------*******************");
					System.out.println("_________--------------------------------------"+str2.length);
					String str1 = "";
					String str3 = "";
					BPIL_MENU menu=new BPIL_MENU();
					
					Set<String> set = new HashSet<>();
					for(int j = 0; j< str.length; j ++){
						set.add(str[j]);
					}
					
					Set<String> set2 = new HashSet<>();
					for(int j = 0; j< str2.length; j ++){
						set2.add(str2[j]);
					}
					System.out.println("Submenu selected is ----------------------------++++++ : "+set2.toString());
					System.out.println("Set : "+set.toString());
					
					int line =0;
					int line2 =0;
					if(request.getParameterValues("sel_menu") != null ){
						System.out.println("not null sel_menu------------");
						Iterator<String> itr = set.iterator();
						while(itr.hasNext()){
							String s = itr.next();
							str1+=s;
							
						    if(line<set.size()-1) // Avoiding the last comma
						    {
						    	str1+=",";
						    }
						    line++;
						}
						
						
						Iterator<String> itr2 = set2.iterator();
						while(itr2.hasNext()){
							String s = itr2.next();
							str3+=s;
							
						    if(line2<set2.size()-1) // Avoiding the last comma
						    {
						    	str3+=",";
						    }
						    line2++;
						}
						
						menu.setMENU_HEADER_ID(str1);
						menu.setSUBMENU(str3);
						
						menu.setUSER_ID(newuserId);
						
						System.out.println("data before saved to database -------------- ");
						hibernateTemplate.saveOrUpdate(menu);
						System.out.println(menu.toString());
						System.out.println("data saved to database successfully");

					System.out.println("data updated ");
					
					String s="success";
					map.addAttribute("success", s);
					return new ModelAndView("NewUserRegistration");
				} else {
					return new ModelAndView("unauthorizedattempt");
				}

			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes
				
																	// to here
				return new ModelAndView("login");
			}
			/* Login Checking Code Ends */

		}
		}catch (NullPointerException e) {
			e.printStackTrace();
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here2 ------> berger login"); // Cursor comes to
																// here
			return new ModelAndView("login");
		}
		System.out.println("Here3 ------> berger login");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/FindUserPresence", method = RequestMethod.GET)
	public void findUser(@RequestParam(value = "UserName") String user_name, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String loginString = (String) request.getSession().getAttribute("loginflag");

		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				try {

					System.out.println("in controller");

					List<Bpil_Users> userlist = new ArrayList<Bpil_Users>();
					String json = null;
					System.out.println("user name " + user_name);

					userlist = userregi.SearchUser(user_name);

					User_pref usr_pref = new User_pref();

					for (int i = 0; i < userlist.size(); i++)

					{

						Date start = userlist.get(0).getStart_date();
						Date end = userlist.get(0).getEnd_date();

						// java.util.Date date = new Date("Sat Dec 01 00:00:00
						// GMT
						// 2012");
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						String format = null;
						if (start != null) {
							format = formatter.format(start);
						}
						String format1 = null;
						if (end != null) {
							format1 = formatter.format(end);
						}
						usr_pref.setUser_id(userlist.get(0).getUser_id());

						usr_pref.setName(userlist.get(0).getUser_name());
						// usr_pref.setPassword(userlist.get(0).getPassword());

						Key key = null;
						try {
							key = generateKey();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Cipher cipher = null;
						try {
							cipher = Cipher.getInstance(ForgotPasswordController.ALGORITHM);
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchPaddingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							cipher.init(Cipher.DECRYPT_MODE, key);
						} catch (InvalidKeyException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						byte[] decryptedValue64 = null;
						try {
							decryptedValue64 = new BASE64Decoder().decodeBuffer(userlist.get(0).getPassword());
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						byte[] decryptedByteValue = null;
						try {
							decryptedByteValue = cipher.doFinal(decryptedValue64);
						} catch (IllegalBlockSizeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BadPaddingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String decryptedValue = null;
						try {
							decryptedValue = new String(decryptedByteValue, "utf-8");
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						usr_pref.setPassword(decryptedValue);
						System.out.println("user name = " + user_name + " password = " + decryptedValue);
						usr_pref.setUserstatus(userlist.get(0).getIs_active());
						if (start != null) {
							usr_pref.setStart_date(format);
						}
						if (end != null) {
							usr_pref.setEnd_date(format1);
						}

						usr_pref.setFirst_name(userlist.get(0).getFirst_name());
						usr_pref.setMiddle_name(userlist.get(0).getMiddle_name());
						usr_pref.setLast_name(userlist.get(0).getLast_name());
						usr_pref.setContact_number(userlist.get(0).getContact_number());
						usr_pref.setEmail_address(userlist.get(0).getEmail_address());
						usr_pref.setProfile_id(userlist.get(0).getProfile_id());
						usr_pref.setUser_type(userlist.get(0).getUser_type());
						// usr_pref.setUserstatus(userlist.get(0).getIs_active());
						System.out.println("in controller : status" + userlist.get(0).getIs_active());

					}

					json = new Gson().toJson(usr_pref);

					response.setContentType("application/json");
					response.getWriter().write(json);
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {
				response.getWriter().write("");
			}
			/* Login Checking Code Ends */
		} catch (NullPointerException e) {
			response.getWriter().write("");
		}

	}

	/////////////////////////////////////////////////// password encription
	/////////////////////////////////////////////////// //////////////////////////////////

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(UserRegistration_Controller.KEY.getBytes(), UserRegistration_Controller.ALGORITHM);
		return key;
	}

	// decryption code

	// public static String decrypt(String value) throws Exception
	// {
	// Key key = generateKey();
	// Cipher cipher = Cipher.getInstance(AESCrypt.ALGORITHM);
	// cipher.init(Cipher.DECRYPT_MODE, key);
	// byte [] decryptedValue64 = new BASE64Decoder().decodeBuffer(value);
	// byte [] decryptedByteValue = cipher.doFinal(decryptedValue64);
	// String decryptedValue = new String(decryptedByteValue,"utf-8");
	// return decryptedValue;
	//
	// }

	@RequestMapping("/usermaster")
	public ModelAndView schememaster(ModelMap map, Model model, HttpServletRequest request) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {

					String kwm_user = (String) request.getSession().getAttribute("kwm_user");

					if (kwm_user != null) {
						List<Bpil_Users> users = userregi.getAllUsers();
						model.addAttribute("usermaster", users);
					}
					return new ModelAndView("UserMaster");

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

	@RequestMapping("/userdetails")
	public ModelAndView userdetails(@RequestParam(value = "username") String username, ModelMap map, Model model,
			HttpServletRequest request) {

		String loginString = (String) request.getSession().getAttribute("loginflag");

		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				Bpil_Users user = userregi.getUserByUsername(username);

				String kwm_user = (String) request.getSession().getAttribute("kwm_user");
				String password = (String) request.getSession().getAttribute("password");

				Bpil_Users loggedInUser = userregi.getUserByUsername(kwm_user);
				String adUsername = loggedInUser.getActive_directory_id();

				// for omfys network
				// if(adUsername == null){
				// adUsername = "Sushant.Kamble";
				// password = "Omfys@123";
				// }

				// for Berger network
				if (adUsername == null) {
					adUsername = "harsup";
					password = "berger@123";
				}

				if (user != null) {
					model.addAttribute("user1", user);

					List<ADList> ADList = wasibLoginService.getActiveDirectoryUserList(adUsername, password);

					List<ADList> toRemove = new ArrayList<ADList>();

					// Removing used AD Id's
					List<Bpil_Users> users = wasibLoginService.getNonADUserList();

					Iterator<ADList> itr = ADList.iterator();
					while (itr.hasNext()) {
						ADList ad = itr.next();
						Iterator<Bpil_Users> itr2 = users.iterator();
						while (itr2.hasNext()) {
							Bpil_Users usr = itr2.next();
							if (usr.getActive_directory_id().equals(ad.getAd_id())) {
								toRemove.add(ad);
							}
						}
					}

					ADList.removeAll(toRemove);
					map.addAttribute("ADList", ADList);
				}
				return new ModelAndView("UpdateUserProfile");

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

	@Transactional
	@RequestMapping(value = "/UpdateUserProfile", method = RequestMethod.POST)
	public ModelAndView updateUserProfile(@ModelAttribute Bpil_Users Koel_user, BindingResult resultKoel_user,
			Model model, ModelMap map, HttpServletRequest request) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {

					String username = request.getParameter("user_name");
					String active_directory_id = request.getParameter("active_directory_id");
					String is_active = request.getParameter("user_status1");

					String kwm_user = (String) request.getSession().getAttribute("kwm_user");
					String password = (String) request.getSession().getAttribute("password");

					Bpil_Users loggedInUser = userregi.getUserByUsername(kwm_user);

					boolean flag = false;
					Bpil_Users user = userregi.getUserByUsername(username);

					String adUsername = loggedInUser.getActive_directory_id();

					// for Omfys network
					// if(adUsername == null){
					// adUsername = "Sushant.Kamble";
					// password = "Omfys@123";
					// }

					// for Berger network
					if (adUsername == null) {
						adUsername = "harsup";
						password = "berger@123";
					}

					if (user != null) {
						user.setActive_directory_id(active_directory_id);
						user.setIs_active(is_active);

						flag = userregi.updateUser(user);

						user = userregi.getUserByUsername(username);
						model.addAttribute("user1", user);

						List<ADList> ADList = wasibLoginService.getActiveDirectoryUserList(adUsername, password);

						List<ADList> toRemove = new ArrayList<ADList>();

						// Removing used AD Id's
						List<Bpil_Users> users = wasibLoginService.getNonADUserList();

						Iterator<ADList> itr = ADList.iterator();
						while (itr.hasNext()) {
							ADList ad = itr.next();
							Iterator<Bpil_Users> itr2 = users.iterator();
							while (itr2.hasNext()) {
								Bpil_Users usr = itr2.next();
								if (usr.getActive_directory_id().equals(ad.getAd_id())) {
									toRemove.add(ad);
								}
							}
						}

						ADList.removeAll(toRemove);
						map.addAttribute("ADList", ADList);
					}

					return new ModelAndView("UpdateUserProfile");

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
	
	@RequestMapping("/berger")
	public ModelAndView berger(ModelMap map,Model model,HttpServletRequest request) {
		System.out.println("you are in ------------ /berger");
		
		
		return new ModelAndView("berger");
	}
}

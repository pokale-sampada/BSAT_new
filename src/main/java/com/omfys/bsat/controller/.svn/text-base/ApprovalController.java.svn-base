package com.omfys.bsat.controller;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.omfys.bsat.repository.SchemeMasterDao;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_User_ProfileId_List;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.New_Scheme_mstr;

@Controller
public class ApprovalController {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	SchemeMasterDao schememasterdao;

	@Autowired
	private TilesConfiguration hibernateConfiguration;

	@RequestMapping(value = "/approvalaction", method = RequestMethod.GET)
	public ModelAndView getLoginForm2(@RequestParam(value = "scheme_id") String scheme_id,
			@RequestParam(value = "wf_notification_id") String wf_notification_id, HttpServletRequest request,
			Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				int schemeid = Integer.parseInt(scheme_id);
				int wfnotificationid = Integer.parseInt(wf_notification_id);

				int user_id = (Integer) request.getSession().getAttribute("userid");

				New_Scheme_mstr mstr = schememasterdao.schemeautofill(schemeid);

				System.out.println("aaaaaaaaaaaaaaa=" + mstr.getScheme_code());
				model.addAttribute("JSON", mstr);
				model.addAttribute("scheme_id", schemeid);
				model.addAttribute("wf_notification_id", wfnotificationid);

				return new ModelAndView("ApprovalPopup");

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

	@RequestMapping(value = "/submitApproval", method = RequestMethod.POST)
	public ModelAndView submitApproval(HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");

		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				int schemeid = Integer.parseInt(request.getParameter("scheme_id"));
				String comments = request.getParameter("comments");

				String action = request.getParameter("action");

				String msg = null;
				if (action.equals("Approve")) {
					String act = "A";
					CallableStatement cStmt;
					try {
						cStmt = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_WF_ENGINE(?,?,?,?,?)}");

						cStmt.setInt(1, schemeid);
						cStmt.setInt(2, user_id);
						cStmt.setString(3, act);
						cStmt.setString(4, comments);
						cStmt.registerOutParameter(5, Types.VARCHAR);
						ResultSet rs1 = cStmt.executeQuery();

						msg = cStmt.getString(5);
						System.out.println("msg is=" + msg);

						ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where scheme_id=" + schemeid);
						String schemecode = dml.get(0).getScheme_code();
						int createdby = dml.get(0).getCreated_by();
						ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate
								.find("from Bpil_Users where user_id=" + createdby);
						String createdby1 = dml1.get(0).getUser_name();

						CallableStatement cStmt2;

						cStmt2 = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

						cStmt2.setInt(1, createdby);
						cStmt2.setInt(2, schemeid);
						cStmt2.setString(3, "A2P");
						cStmt2.setString(4, "Scheme " + schemecode + " Approved by Supervisor");
						cStmt2.registerOutParameter(5, Types.VARCHAR);
						ResultSet result = cStmt2.executeQuery();
						String flag = cStmt2.getString(5);
						System.out.println("scheme Approved mail flag " + flag);

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} else if (action.equals("Reject")) {
					String act = "R";
					CallableStatement cStmt;
					try {
						cStmt = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_WF_ENGINE(?,?,?,?,?)}");

						cStmt.setInt(1, schemeid);
						cStmt.setInt(2, user_id);
						cStmt.setString(3, act);
						cStmt.setString(4, comments);
						cStmt.registerOutParameter(5, Types.VARCHAR);
						ResultSet rs1 = cStmt.executeQuery();

						msg = cStmt.getString(5);
						System.out.println("msg is=" + msg);

						ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where scheme_id=" + schemeid);
						String schemecode = dml.get(0).getScheme_code();
						int createdby = dml.get(0).getCreated_by();
						ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate
								.find("from Bpil_Users where user_id=" + createdby);
						String createdby1 = dml1.get(0).getUser_name();

						CallableStatement cStmt2;

						cStmt2 = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

						cStmt2.setInt(1, createdby);
						cStmt2.setInt(2, schemeid);
						cStmt2.setString(3, "A2P");
						cStmt2.setString(4, "Scheme " + schemecode + " Rejected by Supervisor");
						cStmt2.registerOutParameter(5, Types.VARCHAR);
						ResultSet result = cStmt2.executeQuery();
						String flag = cStmt2.getString(5);
						System.out.println("scheme Rejected mail flag " + flag);

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {
					String act = "N";
					CallableStatement cStmt;
					try {
						cStmt = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_WF_ENGINE(?,?,?,?,?)}");

						cStmt.setInt(1, schemeid);
						cStmt.setInt(2, user_id);
						cStmt.setString(3, act);
						cStmt.setString(4, comments);
						cStmt.registerOutParameter(5, Types.VARCHAR);
						ResultSet rs1 = cStmt.executeQuery();

						msg = cStmt.getString(5);
						System.out.println("msg is=" + msg);

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				model.addAttribute("scheme_id", schemeid);
				model.addAttribute("message", msg);
				return new ModelAndView("ApprovalPopup");

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

	@RequestMapping(value = "/submitSchemeApproval", method = RequestMethod.POST)
	public ModelAndView submitSchemeApproval(HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");

		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				int schemeid = Integer.parseInt(request.getParameter("scheme_id"));
				String comments = request.getParameter("comments");

				String action = request.getParameter("action");

				String msg = null;
				if (action.equals("Approve")) {
					String act = "A";

					ArrayList<New_Scheme_mstr> dml1 = (ArrayList<New_Scheme_mstr>) hibernateTemplate
							.find("from New_Scheme_mstr where scheme_id=" + schemeid);

					if (dml1.get(0).getScheme_type().equals("National")
							&& dml1.get(0).getActive_flag().equals("Pending for HQ Approval")) {
						CallableStatement cStmt;
						try {
							cStmt = hibernateConfiguration.dataSource().getConnection()
									.prepareCall("{call BSATV2_WF_ENGINE(?,?,?,?,?,?)}");

							cStmt.setInt(1, schemeid);
							cStmt.setInt(2, user_id);
							cStmt.setString(3, act);
							cStmt.setString(4, comments);
							cStmt.setString(5, "Requested");
							cStmt.registerOutParameter(6, Types.VARCHAR);
							ResultSet rs1 = cStmt.executeQuery();

							msg = cStmt.getString(6);
							System.out.println("msg is=" + msg);

							ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
									.find("from New_Scheme_mstr where scheme_id=" + schemeid);
							String schemecode = dml.get(0).getScheme_code();
							int createdby = dml.get(0).getCreated_by();
							ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
									.find("from Bpil_Users where user_id=" + createdby);
							String createdby1 = dml2.get(0).getUser_name();

							CallableStatement cStmt2;

							cStmt2 = hibernateConfiguration.dataSource().getConnection()
									.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

							cStmt2.setInt(1, createdby);
							cStmt2.setInt(2, schemeid);
							cStmt2.setString(3, "A2P");
							cStmt2.setString(4, "Scheme " + schemecode + " Approved by Head Quarter");
							cStmt2.registerOutParameter(5, Types.VARCHAR);
							ResultSet result = cStmt2.executeQuery();
							String flag = cStmt2.getString(5);
							System.out.println("scheme Approved mail flag " + flag);

						} catch (SQLException e) {
							e.printStackTrace();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					} else if (dml1.get(0).getScheme_type().equals("Regional")) {
						if (dml1.get(0).getScheme_level().equals("Level1")) {
							CallableStatement cStmt;
							try {
								cStmt = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BSATV2_WF_ENGINE(?,?,?,?,?,?)}");

								cStmt.setInt(1, schemeid);
								cStmt.setInt(2, user_id);
								cStmt.setString(3, act);
								cStmt.setString(4, comments);
								cStmt.setString(5, "Requested");
								cStmt.registerOutParameter(6, Types.VARCHAR);
								ResultSet rs1 = cStmt.executeQuery();

								msg = cStmt.getString(6);
								System.out.println("msg is=" + msg);

								ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
										.find("from New_Scheme_mstr where scheme_id=" + schemeid);
								String schemecode = dml.get(0).getScheme_code();
								int createdby = dml.get(0).getCreated_by();
								ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
										.find("from Bpil_Users where user_id=" + createdby);
								String createdby1 = dml2.get(0).getUser_name();

								CallableStatement cStmt2;

								cStmt2 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

								cStmt2.setInt(1, createdby);
								cStmt2.setInt(2, schemeid);
								cStmt2.setString(3, "A2P");
								cStmt2.setString(4, "Scheme " + schemecode + " Approved by National");
								cStmt2.registerOutParameter(5, Types.VARCHAR);
								ResultSet result = cStmt2.executeQuery();
								String flag = cStmt2.getString(5);
								System.out.println("scheme Approved mail flag " + flag);

							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						} else if (dml1.get(0).getScheme_level().equals("Level2")
								&& dml1.get(0).getActive_flag().equals("Pending for NA Approval")) {

							CallableStatement cStmt;
							try {
								cStmt = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BSATV2_WF_ENGINE(?,?,?,?,?,?)}");

								cStmt.setInt(1, schemeid);
								cStmt.setInt(2, user_id);
								cStmt.setString(3, act);
								cStmt.setString(4, comments);
								cStmt.setString(5, "Pending for HQ Approval");
								cStmt.registerOutParameter(6, Types.VARCHAR);
								ResultSet rs1 = cStmt.executeQuery();

								msg = cStmt.getString(6);
								System.out.println("msg is=" + msg);

								ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
										.find("from New_Scheme_mstr where scheme_id=" + schemeid);
								String schemecode = dml.get(0).getScheme_code();
								int createdby = dml.get(0).getCreated_by();
								ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
										.find("from Bpil_Users where user_id=" + createdby);
								String createdby1 = dml2.get(0).getUser_name();

								CallableStatement cStmt2;

								cStmt2 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

								cStmt2.setInt(1, createdby);
								cStmt2.setInt(2, schemeid);
								cStmt2.setString(3, "A2P");
								cStmt2.setString(4, "Scheme " + schemecode + " Approved by National");
								cStmt2.registerOutParameter(5, Types.VARCHAR);
								ResultSet result = cStmt2.executeQuery();
								String flag = cStmt2.getString(5);
								System.out.println("scheme Approved mail flag " + flag);

							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}

							String schemecode = dml1.get(0).getScheme_code();
							int createdby = dml1.get(0).getCreated_by();
							String status = dml1.get(0).getActive_flag();
							ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
									.find("from Bpil_Users where user_id=" + createdby);
							String createdby1 = dml2.get(0).getUser_name();

							ArrayList<Bpil_Users> dml3 = (ArrayList<Bpil_Users>) hibernateTemplate
									.find("from Bpil_Users where user_name='HeadQuarter'");
							int HQApprover = dml3.get(0).getUser_id();

							DateFormat ser1 = new SimpleDateFormat("dd-MMM-yyyy");
							String dateStr1 = ser1.format(new Date());

							System.out.println("Submition date = " + dateStr1);
							String query = "update BPIL_SCHEME_MASTER set active_flag='Pending for HQ Approval', submission_date = '"
									+ dateStr1 + "'  WHERE scheme_id='" + schemeid + "'";
							jdbcTemplate.update(query);
							System.out.println(".............................." + schemeid);

							CallableStatement cStmt1;
							try {
								cStmt1 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BSATV2_WF_NOTIFICATION_ENTRY(?,?,?,?)}");

								cStmt1.setInt(1, createdby);
								cStmt1.setInt(2, schemeid);
								cStmt1.setInt(3, HQApprover);
								cStmt1.registerOutParameter(4, Types.VARCHAR);
								ResultSet rs1 = cStmt1.executeQuery();

								String str111 = cStmt1.getString(4);
								System.out.println("msg is=" + str111);

								CallableStatement cStmt2;

								cStmt2 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

								cStmt2.setInt(1, createdby);
								cStmt2.setInt(2, schemeid);
								cStmt2.setString(3, "SA");
								cStmt2.setString(4, "Scheme " + schemecode + " Submited for Approval to Head Quarter");
								cStmt2.registerOutParameter(5, Types.VARCHAR);
								ResultSet result = cStmt2.executeQuery();
								String flag = cStmt2.getString(5);
								System.out.println("scheme approval mail flag " + flag);

							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						} else if (dml1.get(0).getScheme_level().equals("Level2")
								&& dml1.get(0).getActive_flag().equals("Pending for HQ Approval")) {
							CallableStatement cStmt;
							try {
								cStmt = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BSATV2_WF_ENGINE(?,?,?,?,?,?)}");

								cStmt.setInt(1, schemeid);
								cStmt.setInt(2, user_id);
								cStmt.setString(3, act);
								cStmt.setString(4, comments);
								cStmt.setString(5, "Requested");
								cStmt.registerOutParameter(6, Types.VARCHAR);
								ResultSet rs1 = cStmt.executeQuery();

								msg = cStmt.getString(6);
								System.out.println("msg is=" + msg);

								ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
										.find("from New_Scheme_mstr where scheme_id=" + schemeid);
								String schemecode = dml.get(0).getScheme_code();
								int createdby = dml.get(0).getCreated_by();
								ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
										.find("from Bpil_Users where user_id=" + createdby);
								String createdby1 = dml2.get(0).getUser_name();

								CallableStatement cStmt2;

								cStmt2 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

								cStmt2.setInt(1, createdby);
								cStmt2.setInt(2, schemeid);
								cStmt2.setString(3, "A2P");
								cStmt2.setString(4, "Scheme " + schemecode + " Approved by Head Quarter");
								cStmt2.registerOutParameter(5, Types.VARCHAR);
								ResultSet result = cStmt2.executeQuery();
								String flag = cStmt2.getString(5);
								System.out.println("scheme Approved mail flag " + flag);

							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
					} else if (dml1.get(0).getScheme_type().equals("Branch")) {
						if (dml1.get(0).getScheme_level().equals("Level1")
								&& dml1.get(0).getActive_flag().equals("Pending for RG Approval")) {
							CallableStatement cStmt;
							try {
								cStmt = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BSATV2_WF_ENGINE(?,?,?,?,?,?)}");

								cStmt.setInt(1, schemeid);
								cStmt.setInt(2, user_id);
								cStmt.setString(3, act);
								cStmt.setString(4, comments);
								cStmt.setString(5, "Requested");
								cStmt.registerOutParameter(6, Types.VARCHAR);
								ResultSet rs1 = cStmt.executeQuery();

								msg = cStmt.getString(6);
								System.out.println("msg is=" + msg);

								ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
										.find("from New_Scheme_mstr where scheme_id=" + schemeid);
								String schemecode = dml.get(0).getScheme_code();
								int createdby = dml.get(0).getCreated_by();
								ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
										.find("from Bpil_Users where user_id=" + createdby);
								String createdby1 = dml2.get(0).getUser_name();

								CallableStatement cStmt2;

								cStmt2 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

								cStmt2.setInt(1, createdby);
								cStmt2.setInt(2, schemeid);
								cStmt2.setString(3, "A2P");
								cStmt2.setString(4, "Scheme " + schemecode + " Approved by Regional");
								cStmt2.registerOutParameter(5, Types.VARCHAR);
								ResultSet result = cStmt2.executeQuery();
								String flag = cStmt2.getString(5);
								System.out.println("scheme Approved mail flag " + flag);

							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						} else if (dml1.get(0).getScheme_level().equals("Level2")
								&& dml1.get(0).getActive_flag().equals("Pending for RG Approval")) {

							CallableStatement cStmt;
							try {
								cStmt = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BSATV2_WF_ENGINE(?,?,?,?,?,?)}");

								cStmt.setInt(1, schemeid);
								cStmt.setInt(2, user_id);
								cStmt.setString(3, act);
								cStmt.setString(4, comments);
								cStmt.setString(5, "Pending for NA Approval");
								cStmt.registerOutParameter(6, Types.VARCHAR);
								ResultSet rs1 = cStmt.executeQuery();

								msg = cStmt.getString(6);
								System.out.println("msg is=" + msg);

								ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
										.find("from New_Scheme_mstr where scheme_id=" + schemeid);
								String schemecode = dml.get(0).getScheme_code();
								int createdby = dml.get(0).getCreated_by();
								ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
										.find("from Bpil_Users where user_id=" + createdby);
								String createdby1 = dml2.get(0).getUser_name();

								CallableStatement cStmt2;

								cStmt2 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

								cStmt2.setInt(1, createdby);
								cStmt2.setInt(2, schemeid);
								cStmt2.setString(3, "A2P");
								cStmt2.setString(4, "Scheme " + schemecode + " Approved by Regional");
								cStmt2.registerOutParameter(5, Types.VARCHAR);
								ResultSet result = cStmt2.executeQuery();
								String flag = cStmt2.getString(5);
								System.out.println("scheme Approved mail flag " + flag);

							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}

							String schemecode = dml1.get(0).getScheme_code();
							int createdby = dml1.get(0).getCreated_by();
							String status = dml1.get(0).getActive_flag();
							ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
									.find("from Bpil_Users where user_id=" + createdby);
							String createdby1 = dml2.get(0).getUser_name();

							ArrayList<Bpil_Users> dml3 = (ArrayList<Bpil_Users>) hibernateTemplate
									.find("from Bpil_Users where user_name='National'");
							int HQApprover = dml3.get(0).getUser_id();

							DateFormat ser1 = new SimpleDateFormat("dd-MMM-yyyy");
							String dateStr1 = ser1.format(new Date());

							System.out.println("Submition date = " + dateStr1);
							String query = "update BPIL_SCHEME_MASTER set active_flag='Pending for NA Approval', submission_date = '"
									+ dateStr1 + "'  WHERE scheme_id='" + schemeid + "'";
							jdbcTemplate.update(query);
							System.out.println(".............................." + schemeid);

							CallableStatement cStmt1;
							try {
								cStmt1 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BSATV2_WF_NOTIFICATION_ENTRY(?,?,?,?)}");

								cStmt1.setInt(1, createdby);
								cStmt1.setInt(2, schemeid);
								cStmt1.setInt(3, HQApprover);
								cStmt1.registerOutParameter(4, Types.VARCHAR);
								ResultSet rs1 = cStmt1.executeQuery();

								String str111 = cStmt1.getString(4);
								System.out.println("msg is=" + str111);

								CallableStatement cStmt2;

								cStmt2 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

								cStmt2.setInt(1, createdby);
								cStmt2.setInt(2, schemeid);
								cStmt2.setString(3, "SA");
								cStmt2.setString(4, "Scheme " + schemecode + " Submited for Approval to National");
								cStmt2.registerOutParameter(5, Types.VARCHAR);
								ResultSet result = cStmt2.executeQuery();
								String flag = cStmt2.getString(5);
								System.out.println("scheme approval mail flag " + flag);

							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						} else if (dml1.get(0).getScheme_level().equals("Level2")
								&& dml1.get(0).getActive_flag().equals("Pending for NA Approval")) {
							CallableStatement cStmt;
							try {
								cStmt = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BSATV2_WF_ENGINE(?,?,?,?,?,?)}");

								cStmt.setInt(1, schemeid);
								cStmt.setInt(2, user_id);
								cStmt.setString(3, act);
								cStmt.setString(4, comments);
								cStmt.setString(5, "Requested");
								cStmt.registerOutParameter(6, Types.VARCHAR);
								ResultSet rs1 = cStmt.executeQuery();

								msg = cStmt.getString(6);
								System.out.println("msg is=" + msg);

								ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
										.find("from New_Scheme_mstr where scheme_id=" + schemeid);
								String schemecode = dml.get(0).getScheme_code();
								int createdby = dml.get(0).getCreated_by();
								ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
										.find("from Bpil_Users where user_id=" + createdby);
								String createdby1 = dml2.get(0).getUser_name();

								CallableStatement cStmt2;

								cStmt2 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

								cStmt2.setInt(1, createdby);
								cStmt2.setInt(2, schemeid);
								cStmt2.setString(3, "A2P");
								cStmt2.setString(4, "Scheme " + schemecode + " Approved by National");
								cStmt2.registerOutParameter(5, Types.VARCHAR);
								ResultSet result = cStmt2.executeQuery();
								String flag = cStmt2.getString(5);
								System.out.println("scheme Approved mail flag " + flag);

							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						} else if (dml1.get(0).getScheme_level().equals("Level3")
								&& dml1.get(0).getActive_flag().equals("Pending for RG Approval")) {

							CallableStatement cStmt;
							try {
								cStmt = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BSATV2_WF_ENGINE(?,?,?,?,?,?)}");

								cStmt.setInt(1, schemeid);
								cStmt.setInt(2, user_id);
								cStmt.setString(3, act);
								cStmt.setString(4, comments);
								cStmt.setString(5, "Pending for NA Approval");
								cStmt.registerOutParameter(6, Types.VARCHAR);
								ResultSet rs1 = cStmt.executeQuery();

								msg = cStmt.getString(6);
								System.out.println("msg is=" + msg);

								ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
										.find("from New_Scheme_mstr where scheme_id=" + schemeid);
								String schemecode = dml.get(0).getScheme_code();
								int createdby = dml.get(0).getCreated_by();
								ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
										.find("from Bpil_Users where user_id=" + createdby);
								String createdby1 = dml2.get(0).getUser_name();

								CallableStatement cStmt2;

								cStmt2 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

								cStmt2.setInt(1, createdby);
								cStmt2.setInt(2, schemeid);
								cStmt2.setString(3, "A2P");
								cStmt2.setString(4, "Scheme " + schemecode + " Approved by Regional");
								cStmt2.registerOutParameter(5, Types.VARCHAR);
								ResultSet result = cStmt2.executeQuery();
								String flag = cStmt2.getString(5);
								System.out.println("scheme Approved mail flag " + flag);

							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}

							String schemecode = dml1.get(0).getScheme_code();
							int createdby = dml1.get(0).getCreated_by();
							String status = dml1.get(0).getActive_flag();
							ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
									.find("from Bpil_Users where user_id=" + createdby);
							String createdby1 = dml2.get(0).getUser_name();

							ArrayList<Bpil_Users> dml3 = (ArrayList<Bpil_Users>) hibernateTemplate
									.find("from Bpil_Users where user_name='National'");
							int HQApprover = dml3.get(0).getUser_id();

							DateFormat ser1 = new SimpleDateFormat("dd-MMM-yyyy");
							String dateStr1 = ser1.format(new Date());

							System.out.println("Submition date = " + dateStr1);
							String query = "update BPIL_SCHEME_MASTER set active_flag='Pending for NA Approval', submission_date = '"
									+ dateStr1 + "'  WHERE scheme_id='" + schemeid + "'";
							jdbcTemplate.update(query);
							System.out.println(".............................." + schemeid);

							CallableStatement cStmt1;
							try {
								cStmt1 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BSATV2_WF_NOTIFICATION_ENTRY(?,?,?,?)}");

								cStmt1.setInt(1, createdby);
								cStmt1.setInt(2, schemeid);
								cStmt1.setInt(3, HQApprover);
								cStmt1.registerOutParameter(4, Types.VARCHAR);
								ResultSet rs1 = cStmt1.executeQuery();

								String str111 = cStmt1.getString(4);
								System.out.println("msg is=" + str111);

								CallableStatement cStmt2;

								cStmt2 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

								cStmt2.setInt(1, createdby);
								cStmt2.setInt(2, schemeid);
								cStmt2.setString(3, "SA");
								cStmt2.setString(4, "Scheme " + schemecode + " Submited for Approval to National");
								cStmt2.registerOutParameter(5, Types.VARCHAR);
								ResultSet result = cStmt2.executeQuery();
								String flag = cStmt2.getString(5);
								System.out.println("scheme approval mail flag " + flag);

							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						} else if (dml1.get(0).getScheme_level().equals("Level3")
								&& dml1.get(0).getActive_flag().equals("Pending for NA Approval")) {

							CallableStatement cStmt;
							try {
								cStmt = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BSATV2_WF_ENGINE(?,?,?,?,?,?)}");

								cStmt.setInt(1, schemeid);
								cStmt.setInt(2, user_id);
								cStmt.setString(3, act);
								cStmt.setString(4, comments);
								cStmt.setString(5, "Pending for HQ Approval");
								cStmt.registerOutParameter(6, Types.VARCHAR);
								ResultSet rs1 = cStmt.executeQuery();

								msg = cStmt.getString(6);
								System.out.println("msg is=" + msg);

								ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
										.find("from New_Scheme_mstr where scheme_id=" + schemeid);
								String schemecode = dml.get(0).getScheme_code();
								int createdby = dml.get(0).getCreated_by();
								ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
										.find("from Bpil_Users where user_id=" + createdby);
								String createdby1 = dml2.get(0).getUser_name();

								CallableStatement cStmt2;

								cStmt2 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

								cStmt2.setInt(1, createdby);
								cStmt2.setInt(2, schemeid);
								cStmt2.setString(3, "A2P");
								cStmt2.setString(4, "Scheme " + schemecode + " Approved by National");
								cStmt2.registerOutParameter(5, Types.VARCHAR);
								ResultSet result = cStmt2.executeQuery();
								String flag = cStmt2.getString(5);
								System.out.println("scheme Approved mail flag " + flag);

							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}

							String schemecode = dml1.get(0).getScheme_code();
							int createdby = dml1.get(0).getCreated_by();
							String status = dml1.get(0).getActive_flag();
							ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
									.find("from Bpil_Users where user_id=" + createdby);
							String createdby1 = dml2.get(0).getUser_name();

							ArrayList<Bpil_Users> dml3 = (ArrayList<Bpil_Users>) hibernateTemplate
									.find("from Bpil_Users where user_name='HeadQuarter'");
							int HQApprover = dml3.get(0).getUser_id();

							DateFormat ser1 = new SimpleDateFormat("dd-MMM-yyyy");
							String dateStr1 = ser1.format(new Date());

							System.out.println("Submition date = " + dateStr1);
							String query = "update BPIL_SCHEME_MASTER set active_flag='Pending for HQ Approval', submission_date = '"
									+ dateStr1 + "'  WHERE scheme_id='" + schemeid + "'";
							jdbcTemplate.update(query);
							System.out.println(".............................." + schemeid);

							CallableStatement cStmt1;
							try {
								cStmt1 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BSATV2_WF_NOTIFICATION_ENTRY(?,?,?,?)}");

								cStmt1.setInt(1, createdby);
								cStmt1.setInt(2, schemeid);
								cStmt1.setInt(3, HQApprover);
								cStmt1.registerOutParameter(4, Types.VARCHAR);
								ResultSet rs1 = cStmt1.executeQuery();

								String str111 = cStmt1.getString(4);
								System.out.println("msg is=" + str111);

								CallableStatement cStmt2;

								cStmt2 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

								cStmt2.setInt(1, createdby);
								cStmt2.setInt(2, schemeid);
								cStmt2.setString(3, "SA");
								cStmt2.setString(4, "Scheme " + schemecode + " Submited for Approval to Head Quarter");
								cStmt2.registerOutParameter(5, Types.VARCHAR);
								ResultSet result = cStmt2.executeQuery();
								String flag = cStmt2.getString(5);
								System.out.println("scheme approval mail flag " + flag);

							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						} else if (dml1.get(0).getScheme_level().equals("Level3")
								&& dml1.get(0).getActive_flag().equals("Pending for HQ Approval")) {
							CallableStatement cStmt;
							try {
								cStmt = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BSATV2_WF_ENGINE(?,?,?,?,?,?)}");

								cStmt.setInt(1, schemeid);
								cStmt.setInt(2, user_id);
								cStmt.setString(3, act);
								cStmt.setString(4, comments);
								cStmt.setString(5, "Requested");
								cStmt.registerOutParameter(6, Types.VARCHAR);
								ResultSet rs1 = cStmt.executeQuery();

								msg = cStmt.getString(6);
								System.out.println("msg is=" + msg);

								ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
										.find("from New_Scheme_mstr where scheme_id=" + schemeid);
								String schemecode = dml.get(0).getScheme_code();
								int createdby = dml.get(0).getCreated_by();
								ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
										.find("from Bpil_Users where user_id=" + createdby);
								String createdby1 = dml2.get(0).getUser_name();

								CallableStatement cStmt2;

								cStmt2 = hibernateConfiguration.dataSource().getConnection()
										.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

								cStmt2.setInt(1, createdby);
								cStmt2.setInt(2, schemeid);
								cStmt2.setString(3, "A2P");
								cStmt2.setString(4, "Scheme " + schemecode + " Approved by Head Quarter");
								cStmt2.registerOutParameter(5, Types.VARCHAR);
								ResultSet result = cStmt2.executeQuery();
								String flag = cStmt2.getString(5);
								System.out.println("scheme Approved mail flag " + flag);

							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
					} else {
						CallableStatement cStmt;
						try {
							cStmt = hibernateConfiguration.dataSource().getConnection()
									.prepareCall("{call BPIL_WF_ENGINE(?,?,?,?,?)}");

							cStmt.setInt(1, schemeid);
							cStmt.setInt(2, user_id);
							cStmt.setString(3, act);
							cStmt.setString(4, comments);
							cStmt.registerOutParameter(5, Types.VARCHAR);
							ResultSet rs1 = cStmt.executeQuery();

							msg = cStmt.getString(5);
							System.out.println("msg is=" + msg);

							ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
									.find("from New_Scheme_mstr where scheme_id=" + schemeid);
							String schemecode = dml.get(0).getScheme_code();
							int createdby = dml.get(0).getCreated_by();
							ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate
									.find("from Bpil_Users where user_id=" + createdby);
							String createdby1 = dml2.get(0).getUser_name();

							CallableStatement cStmt2;

							cStmt2 = hibernateConfiguration.dataSource().getConnection()
									.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

							cStmt2.setInt(1, createdby);
							cStmt2.setInt(2, schemeid);
							cStmt2.setString(3, "A2P");
							cStmt2.setString(4, "Scheme " + schemecode + " Approved by Supervisor");
							cStmt2.registerOutParameter(5, Types.VARCHAR);
							ResultSet result = cStmt2.executeQuery();
							String flag = cStmt2.getString(5);
							System.out.println("scheme Approved mail flag " + flag);

						} catch (SQLException e) {
							e.printStackTrace();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}

				} else if (action.equals("Reject")) {
					String act = "R";
					CallableStatement cStmt;
					try {
						cStmt = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_WF_ENGINE(?,?,?,?,?)}");

						cStmt.setInt(1, schemeid);
						cStmt.setInt(2, user_id);
						cStmt.setString(3, act);
						cStmt.setString(4, comments);
						cStmt.registerOutParameter(5, Types.VARCHAR);
						ResultSet rs1 = cStmt.executeQuery();

						msg = cStmt.getString(5);
						System.out.println("msg is=" + msg);

						ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where scheme_id=" + schemeid);
						String schemecode = dml.get(0).getScheme_code();
						int createdby = dml.get(0).getCreated_by();
						ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate
								.find("from Bpil_Users where user_id=" + createdby);
						String createdby1 = dml1.get(0).getUser_name();

						CallableStatement cStmt2;

						cStmt2 = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

						cStmt2.setInt(1, createdby);
						cStmt2.setInt(2, schemeid);
						cStmt2.setString(3, "A2P");
						cStmt2.setString(4, "Scheme " + schemecode + " Rejected by Supervisor");
						cStmt2.registerOutParameter(5, Types.VARCHAR);
						ResultSet result = cStmt2.executeQuery();
						String flag = cStmt2.getString(5);
						System.out.println("scheme Rejected mail flag " + flag);

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {
					String act = "N";
					CallableStatement cStmt;
					try {
						cStmt = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_WF_ENGINE(?,?,?,?,?)}");

						cStmt.setInt(1, schemeid);
						cStmt.setInt(2, user_id);
						cStmt.setString(3, act);
						cStmt.setString(4, comments);
						cStmt.registerOutParameter(5, Types.VARCHAR);
						ResultSet rs1 = cStmt.executeQuery();

						msg = cStmt.getString(5);
						System.out.println("msg is=" + msg);

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				model.addAttribute("scheme_id", schemeid);
				model.addAttribute("message", msg);
				return new ModelAndView("redirect:/pendingschemeapproval");
//					return new ModelAndView("ApprovalPopup");

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

	@RequestMapping(value = "/submitITSchemeApproval", method = RequestMethod.POST)
	public ModelAndView submitITSchemeApproval(HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				int schemeid = Integer.parseInt(request.getParameter("scheme_id"));
				String comments = request.getParameter("comments");

				String action = request.getParameter("action");

				New_Scheme_mstr mstr = schememasterdao.schemeautofill(schemeid);

				Bpil_Users user = schememasterdao.getUserById(mstr.getCreated_by());

				String msg = null;
				if (action.equals("Approve")) {
					String act = "A";
					CallableStatement cStmt;
					try {
						cStmt = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_WF_ENGINE(?,?,?,?,?)}");

						cStmt.setInt(1, schemeid);
						cStmt.setInt(2, user.getSupervisor_id());
						cStmt.setString(3, act);
						cStmt.setString(4, comments);
						cStmt.registerOutParameter(5, Types.VARCHAR);
						ResultSet rs1 = cStmt.executeQuery();

						msg = cStmt.getString(5);
						System.out.println("msg is=" + msg);

						ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where scheme_id=" + schemeid);
						String schemecode = dml.get(0).getScheme_code();
						int createdby = dml.get(0).getCreated_by();
						ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate
								.find("from Bpil_Users where user_id=" + createdby);
						String createdby1 = dml1.get(0).getUser_name();

						CallableStatement cStmt2;

						cStmt2 = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

						cStmt2.setInt(1, createdby);
						cStmt2.setInt(2, schemeid);
						cStmt2.setString(3, "A2P");
						cStmt2.setString(4, "Scheme " + schemecode + " Approved by IT Admin");
						cStmt2.registerOutParameter(5, Types.VARCHAR);
						ResultSet result = cStmt2.executeQuery();
						String flag = cStmt2.getString(5);
						System.out.println("scheme Approved mail flag " + flag);

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} else if (action.equals("Reject")) {
					String act = "R";
					CallableStatement cStmt;
					try {
						cStmt = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_WF_ENGINE(?,?,?,?,?)}");

						cStmt.setInt(1, schemeid);
						cStmt.setInt(2, user.getSupervisor_id());
						cStmt.setString(3, act);
						cStmt.setString(4, comments);
						cStmt.registerOutParameter(5, Types.VARCHAR);
						ResultSet rs1 = cStmt.executeQuery();

						msg = cStmt.getString(5);
						System.out.println("msg is=" + msg);

						ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where scheme_id=" + schemeid);
						String schemecode = dml.get(0).getScheme_code();
						int createdby = dml.get(0).getCreated_by();
						ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate
								.find("from Bpil_Users where user_id=" + createdby);
						String createdby1 = dml1.get(0).getUser_name();

						CallableStatement cStmt2;

						cStmt2 = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");

						cStmt2.setInt(1, createdby);
						cStmt2.setInt(2, schemeid);
						cStmt2.setString(3, "A2P");
						cStmt2.setString(4, "Scheme " + schemecode + " Rejected by IT Admin");
						cStmt2.registerOutParameter(5, Types.VARCHAR);
						ResultSet result = cStmt2.executeQuery();
						String flag = cStmt2.getString(5);
						System.out.println("scheme Rejected mail flag " + flag);

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {
					String act = "N";
					CallableStatement cStmt;
					try {
						cStmt = hibernateConfiguration.dataSource().getConnection()
								.prepareCall("{call BPIL_WF_ENGINE(?,?,?,?,?)}");

						cStmt.setInt(1, schemeid);
						cStmt.setInt(2, user_id);
						cStmt.setString(3, act);
						cStmt.setString(4, comments);
						cStmt.registerOutParameter(5, Types.VARCHAR);
						ResultSet rs1 = cStmt.executeQuery();

						msg = cStmt.getString(5);
						System.out.println("msg is=" + msg);

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				model.addAttribute("scheme_id", schemeid);
				model.addAttribute("message", msg);
				return new ModelAndView("redirect:/pendingITschemeapproval");
//					return new ModelAndView("ApprovalPopup");

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

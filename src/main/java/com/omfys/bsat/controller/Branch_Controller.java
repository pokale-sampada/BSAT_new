package com.omfys.bsat.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_Branch_Master;
import com.omfys.bsat.model.Bpil_Region_Master;
import com.omfys.bsat.model.Sales_Incentive;
import com.omfys.bsat.model.Test_Table;
import com.omfys.bsat.model.Vodafone_Account_Master;
import com.omfys.bsat.model.Vodafone_Rewards;

@Controller
public class Branch_Controller {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private TilesConfiguration hibernateConfiguration;

	@Autowired
	HibernateTemplate HibernateTemplate;

	
	@RequestMapping("/Branch_List")
	public ModelAndView Branch_List(HttpServletRequest request, Model model) {

		ArrayList<Bpil_Branch_Master> dml = (ArrayList<Bpil_Branch_Master>) HibernateTemplate
				.find("from Bpil_Branch_Master");

		model.addAttribute("dml", dml);

		return new ModelAndView("Branch_Master");

	}
	
	@RequestMapping("/calculateincentive")
	public ModelAndView calculateincentive(HttpServletRequest request, Model model) {

             System.out.println("in side calculateincentive........");
             ArrayList<Test_Table> dml = (ArrayList<Test_Table>) HibernateTemplate
 					.find("from Test_Table");
             
         	for(Test_Table t:dml)
         	{
         		System.out.println(t.getEmp_code());
         		int ctc=Integer.parseInt(t.getCtc()); 
         		int basic=(ctc*10)/4;
         		String s=String.valueOf(basic); 
         		t.setBasic_salary(s);
         		int total=Integer.parseInt(t.getPoamount());         		
                int variable= (total*2)/100 ;     		        
         		String sbasic=String.valueOf(variable); 
         		t.setGross_salary(sbasic);
         		
         	}
         	System.out.println(dml.toString());
         	model.addAttribute("test",dml);
         

		return new ModelAndView("calculateincentive");

	}
	
	

	@RequestMapping("/create_branch")
	public ModelAndView create_branch(HttpServletRequest request, Model model) {

		return new ModelAndView("create_New_branch");

	}

	@RequestMapping(value = "/getRegion", method = RequestMethod.GET)
	public void getRegion(HttpServletRequest request, Model model, HttpServletResponse response) {

		try {

			ArrayList<Bpil_Region_Master> dml = (ArrayList<Bpil_Region_Master>) HibernateTemplate
					.find("from Bpil_Region_Master");

			System.out.println(" dml --- >>" + dml.get(0).getRegion_code());

			String json = null;

			json = new Gson().toJson(dml);
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Transactional
	@RequestMapping("/save_Branch")
	public ModelAndView save_Branch(HttpServletRequest request,
			@ModelAttribute("Bpil_Branch_Master") Bpil_Branch_Master master, Model model) {

		System.out.println("----master------>>" + master.getBranch_desc());

		HibernateTemplate.saveOrUpdate(master);

		return new ModelAndView("redirect:/Branch_List"); // Branch_Master

	}

	@Transactional
	@RequestMapping("/save_new_Branch")
	public ModelAndView save_new_Branch(HttpServletRequest request, Model model) {

		String region = request.getParameter("region_id");
		String branch_code = request.getParameter("branch_code");
		String branch_name = request.getParameter("branch_desc");

		Bpil_Branch_Master bm = new Bpil_Branch_Master();
		bm.setRegion_id(Integer.parseInt(region));
		bm.setBranch_code(branch_code);
		bm.setBranch_desc(branch_name);

		HibernateTemplate.saveOrUpdate(bm);

		return new ModelAndView("redirect:/Branch_List"); // Branch_Master

	}

	@Transactional
	@RequestMapping("/update_branch")
	public ModelAndView update_branch(@RequestParam(value = "branch_id") String branch_id, HttpServletRequest request,
			@ModelAttribute("Bpil_Branch_Master") Bpil_Branch_Master master, Model model) {

		int b_id = Integer.parseInt(branch_id);

		ArrayList<Bpil_Branch_Master> dml = (ArrayList<Bpil_Branch_Master>) HibernateTemplate
				.find("from Bpil_Branch_Master where branch_id=?", b_id);
		model.addAttribute("list", dml);

		ArrayList<Bpil_Region_Master> brm = (ArrayList<Bpil_Region_Master>) HibernateTemplate
				.find("from Bpil_Region_Master where region_id=?", dml.get(0).getRegion_id());
		model.addAttribute("brm", brm);

		return new ModelAndView("create_branch"); // Branch_Master

	}

	@RequestMapping(value = "/showVodafoneSchAnReportSoap")
	public ModelAndView showVodafoneSchAnReportSoap(HttpServletRequest request, Model model,
			HttpServletResponse response, @RequestParam(value = "month") String month) {

		String schopawebserviceUrl = "https://iflictest1.custhelp.com/determinations-server/assess/soap/generic/12.2.1/Vodafone__POC?wsdl";
		System.out.println("in Vodafone scheme");
		System.out.println("Month " + month);

		List<Vodafone_Rewards> rewards_list = new ArrayList<>();
		List<Vodafone_Rewards> rewards_list_q = new ArrayList<>();

		String sql_vodafone_account_master = "select distinct (ACCOUNT_MANAGER) from VODAFONE_ACCOUNT_MASTER";

		List<Vodafone_Account_Master> account_master_list = jdbcTemplate.query(sql_vodafone_account_master,
				new RowMapper<Vodafone_Account_Master>() {

					@Override
					public Vodafone_Account_Master mapRow(ResultSet rs, int rowNum) throws SQLException {
						Vodafone_Account_Master account_master = new Vodafone_Account_Master();

						account_master.setAccount_manager(rs.getString("ACCOUNT_MANAGER"));

						return account_master;
					}

				});
		int count = 0;
		for (Vodafone_Account_Master account_master : account_master_list) {
			count++;
			System.out.println("in Vodafone Account " + count);

			Vodafone_Rewards rewards = new Vodafone_Rewards();
			rewards.setTarget_payout(1000);
			rewards.setEmp_code(0);
			rewards.setEmp_name(account_master.getAccount_manager());
			rewards.setRole("Account Manager");
			rewards.setEmp_status("BAU");
			rewards.setCircle("AP");
			rewards.setMonth(month);

			// previous cum tgt and ach rev
			String prev_month = "";
			if (month.equals("MAY19")) {
				prev_month = "APR19";
			}
			if (month.equals("JUN19")) {
				prev_month = "MAY19";
			}

			String sql_vodafone_pre = "select * from VODAFONE_REWARD where EMP_NAME = '"
					+ account_master.getAccount_manager() + "'" + " and month = '" + prev_month + "'";

			List<Vodafone_Rewards> vodafone_pre = jdbcTemplate.query(sql_vodafone_pre,
					new RowMapper<Vodafone_Rewards>() {

						@Override
						public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
							Vodafone_Rewards rewards = new Vodafone_Rewards();

							rewards.setP1_cum_tgt(rs.getFloat("P1_CUM_TGT"));
							rewards.setP1_cum_ach(rs.getFloat("P1_CUM_ACH"));

							rewards.setP2_mb_cum_tgt(rs.getFloat("P2_MOB_CUM_TGT"));
							rewards.setP2_mb_cum_ach(rs.getFloat("P2_MOB_CUM_ACH"));

							rewards.setP2_fld_cum_tgt(rs.getFloat("P2_FLD_CUM_TGT"));
							rewards.setP2_fld_cum_ach(rs.getFloat("P2_FLD_CUM_ACH"));

							rewards.setP2_flv_cum_tgt(rs.getFloat("P2_FLV_CUM_TGT"));
							rewards.setP2_flv_cum_ach(rs.getFloat("P2_FLV_CUM_ACH"));

							rewards.setP2_iot_cum_tgt(rs.getFloat("P2_IOT_CUM_TGT"));
							rewards.setP2_iot_cum_ach(rs.getFloat("P2_IOT_CUM_ACH"));

							rewards.setP2_cloud_cum_tgt(rs.getFloat("P2_CLD_CUM_TGT"));
							rewards.setP2_cloud_cum_ach(rs.getFloat("P2_CLD_CUM_ACH"));

							rewards.setP3_seg1_cum_tgt(rs.getFloat("P3_SEG1_CUM_TGT"));
							rewards.setP3_seg1_cum_ach(rs.getFloat("P3_SEG1_CUM_ACH"));

							rewards.setP3_seg2_cum_tgt(rs.getFloat("P3_SEG2_CUM_TGT"));
							rewards.setP3_seg2_cum_ach(rs.getFloat("P3_SEG2_CUM_ACH"));

							return rewards;
						}

					});

			// parameter1 revenue
			String sql_vodafone_rev = "select sum(REV) REV from VODAFONE_REVENUE_MASTER where ACCOUNT_MANAGER = '"
					+ account_master.getAccount_manager() + "'" + " and month = '" + month + "'";

			List<Vodafone_Rewards> vodafone_rev = jdbcTemplate.query(sql_vodafone_rev,
					new RowMapper<Vodafone_Rewards>() {

						@Override
						public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
							Vodafone_Rewards rewards = new Vodafone_Rewards();

							rewards.setP1_monthly_ach(rs.getInt("REV"));

							return rewards;
						}

					});

			if (month.equals("APR19")) {
				rewards.setRange("M1");

				rewards.setP1_cum_tgt(0);
				rewards.setP1_cum_ach(0);

				rewards.setP2_mb_cum_tgt(0);
				rewards.setP2_mb_cum_ach(0);

				rewards.setP2_flv_cum_tgt(0);
				rewards.setP2_flv_cum_ach(0);

				rewards.setP2_fld_cum_tgt(0);
				rewards.setP2_fld_cum_ach(0);

				rewards.setP2_iot_cum_tgt(0);
				rewards.setP2_iot_cum_ach(0);

				rewards.setP2_cloud_cum_tgt(0);
				rewards.setP2_cloud_cum_ach(0);

				rewards.setP3_seg1_cum_tgt(0);
				rewards.setP3_seg1_cum_ach(0);

				rewards.setP3_seg2_cum_tgt(0);
				rewards.setP3_seg2_cum_ach(0);

				if (account_master.getAccount_manager().equals("Sindhu")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP1_monthly_tgt(11);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP1_monthly_tgt(6);
				}
			}
			if (month.equals("MAY19")) {
				rewards.setRange("M2");

				if (!vodafone_pre.isEmpty()) {
					rewards.setP1_cum_tgt(vodafone_pre.get(0).getP1_cum_tgt());
					rewards.setP1_cum_ach(vodafone_pre.get(0).getP1_cum_tgt());

					rewards.setP2_mb_cum_tgt(vodafone_pre.get(0).getP2_mb_cum_tgt());
					rewards.setP2_mb_cum_ach(vodafone_pre.get(0).getP2_mb_cum_tgt());

					rewards.setP2_fld_cum_tgt(vodafone_pre.get(0).getP2_fld_cum_tgt());
					rewards.setP2_fld_cum_ach(vodafone_pre.get(0).getP2_fld_cum_tgt());

					rewards.setP2_flv_cum_tgt(vodafone_pre.get(0).getP2_flv_cum_tgt());
					rewards.setP2_flv_cum_ach(vodafone_pre.get(0).getP2_flv_cum_tgt());

					rewards.setP2_iot_cum_tgt(vodafone_pre.get(0).getP2_iot_cum_tgt());
					rewards.setP2_iot_cum_ach(vodafone_pre.get(0).getP2_iot_cum_tgt());

					rewards.setP2_cloud_cum_tgt(vodafone_pre.get(0).getP2_cloud_cum_tgt());
					rewards.setP2_cloud_cum_ach(vodafone_pre.get(0).getP2_cloud_cum_tgt());

					rewards.setP3_seg1_cum_tgt(vodafone_pre.get(0).getP3_seg1_cum_tgt());
					rewards.setP3_seg1_cum_ach(vodafone_pre.get(0).getP3_seg1_cum_tgt());

					rewards.setP3_seg2_cum_tgt(vodafone_pre.get(0).getP3_seg2_cum_tgt());
					rewards.setP3_seg2_cum_ach(vodafone_pre.get(0).getP3_seg2_cum_tgt());
				}

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP1_monthly_tgt(10);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP1_monthly_tgt(6);
				}
			}
			if (month.equals("JUN19")) {
				rewards.setRange("M3");

				if (!vodafone_pre.isEmpty()) {
					rewards.setP1_cum_tgt(vodafone_pre.get(0).getP1_cum_tgt());
					rewards.setP1_cum_ach(vodafone_pre.get(0).getP1_cum_tgt());

					rewards.setP2_mb_cum_tgt(vodafone_pre.get(0).getP2_mb_cum_tgt());
					rewards.setP2_mb_cum_ach(vodafone_pre.get(0).getP2_mb_cum_tgt());

					rewards.setP2_fld_cum_tgt(vodafone_pre.get(0).getP2_fld_cum_tgt());
					rewards.setP2_fld_cum_ach(vodafone_pre.get(0).getP2_fld_cum_tgt());

					rewards.setP2_flv_cum_tgt(vodafone_pre.get(0).getP2_flv_cum_tgt());
					rewards.setP2_flv_cum_ach(vodafone_pre.get(0).getP2_flv_cum_tgt());

					rewards.setP2_iot_cum_tgt(vodafone_pre.get(0).getP2_iot_cum_tgt());
					rewards.setP2_iot_cum_ach(vodafone_pre.get(0).getP2_iot_cum_tgt());

					rewards.setP2_cloud_cum_tgt(vodafone_pre.get(0).getP2_cloud_cum_tgt());
					rewards.setP2_cloud_cum_ach(vodafone_pre.get(0).getP2_cloud_cum_tgt());

					rewards.setP3_seg1_cum_tgt(vodafone_pre.get(0).getP3_seg1_cum_tgt());
					rewards.setP3_seg1_cum_ach(vodafone_pre.get(0).getP3_seg1_cum_tgt());

					rewards.setP3_seg2_cum_tgt(vodafone_pre.get(0).getP3_seg2_cum_tgt());
					rewards.setP3_seg2_cum_ach(vodafone_pre.get(0).getP3_seg2_cum_tgt());
				}

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP1_monthly_tgt(10);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP1_monthly_tgt(6);
				}
			}

			rewards.setP1_monthly_ach(vodafone_rev.get(0).getP1_monthly_ach());

			// parameter2 mobility
			String sql_vodafone_mobility = "select sum(REV) REV from VODAFONE_REVENUE_MASTER where ACCOUNT_MANAGER = '"
					+ account_master.getAccount_manager() + "'" + " and month = '" + month
					+ "' and PRODUCT = 'Mobility'";

			List<Vodafone_Rewards> vodafone_mobility = jdbcTemplate.query(sql_vodafone_mobility,
					new RowMapper<Vodafone_Rewards>() {

						@Override
						public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
							Vodafone_Rewards rewards = new Vodafone_Rewards();

							rewards.setP2_mb_monthly_ach(rs.getInt("REV"));

							return rewards;
						}

					});

			if (month.equals("APR19")) {

				if (account_master.getAccount_manager().equals("Sindhu")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP2_mb_monthly_tgt(1);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP2_mb_monthly_tgt(0);
				}
			}
			if (month.equals("MAY19")) {
				rewards.setRange("M2");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP2_mb_monthly_tgt(1);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP2_mb_monthly_tgt(0);
				}
			}
			if (month.equals("JUN19")) {
				rewards.setRange("M3");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP2_mb_monthly_tgt(1);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP2_mb_monthly_tgt(0);
				}
			}

			rewards.setP2_mb_monthly_ach(vodafone_mobility.get(0).getP2_mb_monthly_ach());

			// parameter2 FLD
			String sql_vodafone_fld = "select sum(REV) REV from VODAFONE_REVENUE_MASTER where ACCOUNT_MANAGER = '"
					+ account_master.getAccount_manager() + "'" + " and month = '" + month + "' and PRODUCT = 'FLD'";

			List<Vodafone_Rewards> vodafone_fld = jdbcTemplate.query(sql_vodafone_fld,
					new RowMapper<Vodafone_Rewards>() {

						@Override
						public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
							Vodafone_Rewards rewards = new Vodafone_Rewards();

							rewards.setP2_fld_monthly_ach(rs.getInt("REV"));

							return rewards;
						}

					});

			if (month.equals("APR19")) {

				if (account_master.getAccount_manager().equals("Sindhu")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP2_fld_monthly_tgt(3);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP2_fld_monthly_tgt(4);
				}
			}
			if (month.equals("MAY19")) {
				rewards.setRange("M2");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP2_fld_monthly_tgt(3);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP2_fld_monthly_tgt(4);
				}
			}
			if (month.equals("JUN19")) {
				rewards.setRange("M3");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP2_fld_monthly_tgt(4);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP2_fld_monthly_tgt(4);
				}
			}
			rewards.setP2_fld_monthly_ach(vodafone_fld.get(0).getP2_fld_monthly_ach());

			// parameter2 FLV
			String sql_vodafone_flv = "select sum(REV) REV from VODAFONE_REVENUE_MASTER where ACCOUNT_MANAGER = '"
					+ account_master.getAccount_manager() + "'" + " and month = '" + month + "' and PRODUCT = 'FLV'";

			List<Vodafone_Rewards> vodafone_flv = jdbcTemplate.query(sql_vodafone_flv,
					new RowMapper<Vodafone_Rewards>() {

						@Override
						public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
							Vodafone_Rewards rewards = new Vodafone_Rewards();

							rewards.setP2_flv_monthly_ach(rs.getInt("REV"));

							return rewards;
						}

					});

			if (month.equals("APR19")) {

				if (account_master.getAccount_manager().equals("Sindhu")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP2_flv_monthly_tgt(0);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP2_flv_monthly_tgt(1);
				}
			}
			if (month.equals("MAY19")) {
				rewards.setRange("M2");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP2_flv_monthly_tgt(1);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP2_flv_monthly_tgt(1);
				}
			}
			if (month.equals("JUN19")) {
				rewards.setRange("M3");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP2_flv_monthly_tgt(1);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP2_flv_monthly_tgt(1);
				}
			}

			rewards.setP2_flv_monthly_ach(vodafone_flv.get(0).getP2_flv_monthly_ach());

			// parameter2 IOT
			String sql_vodafone_iot = "select sum(REV) REV from VODAFONE_REVENUE_MASTER where ACCOUNT_MANAGER = '"
					+ account_master.getAccount_manager() + "'" + " and month = '" + month + "' and PRODUCT = 'IOT'";

			List<Vodafone_Rewards> vodafone_iot = jdbcTemplate.query(sql_vodafone_iot,
					new RowMapper<Vodafone_Rewards>() {

						@Override
						public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
							Vodafone_Rewards rewards = new Vodafone_Rewards();

							rewards.setP2_iot_monthly_ach(rs.getInt("REV"));

							return rewards;
						}

					});

			if (month.equals("APR19")) {

				if (account_master.getAccount_manager().equals("Sindhu")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP2_iot_monthly_tgt(0);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP2_iot_monthly_tgt(0);
				}
			}
			if (month.equals("MAY19")) {
				rewards.setRange("M2");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP2_iot_monthly_tgt(0);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP2_iot_monthly_tgt(0);
				}
			}
			if (month.equals("JUN19")) {
				rewards.setRange("M3");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP2_iot_monthly_tgt(0);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP2_iot_monthly_tgt(0);
				}
			}
			rewards.setP2_iot_monthly_ach(vodafone_iot.get(0).getP2_iot_monthly_ach());

			// parameter2 Cloud
			String sql_vodafone_cloud = "select sum(REV) REV from VODAFONE_REVENUE_MASTER where ACCOUNT_MANAGER = '"
					+ account_master.getAccount_manager() + "'" + " and month = '" + month + "' and PRODUCT = 'CLOUD'";

			List<Vodafone_Rewards> vodafone_cloud = jdbcTemplate.query(sql_vodafone_cloud,
					new RowMapper<Vodafone_Rewards>() {

						@Override
						public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
							Vodafone_Rewards rewards = new Vodafone_Rewards();

							rewards.setP2_cloud_monthly_ach(rs.getInt("REV"));

							return rewards;
						}

					});

			if (month.equals("APR19")) {

				if (account_master.getAccount_manager().equals("Sindhu")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP2_cloud_monthly_tgt(0);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP2_cloud_monthly_tgt(0);
				}
			}
			if (month.equals("MAY19")) {
				rewards.setRange("M2");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP2_cloud_monthly_tgt(0);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP2_cloud_monthly_tgt(0);
				}
			}
			if (month.equals("JUN19")) {
				rewards.setRange("M3");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP2_cloud_monthly_tgt(0);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP2_cloud_monthly_tgt(0);
				}
			}
			rewards.setP2_cloud_monthly_ach(vodafone_cloud.get(0).getP2_cloud_monthly_ach());

			// parameter3 Segment1
			String sql_vodafone_segment1 = "select sum(REV) REV from VODAFONE_REVENUE_MASTER where ACCOUNT_MANAGER = '"
					+ account_master.getAccount_manager() + "'" + " and month = '" + month + "' and PRODUCT = 'CLOUD'";

			List<Vodafone_Rewards> vodafone_segment1 = jdbcTemplate.query(sql_vodafone_segment1,
					new RowMapper<Vodafone_Rewards>() {

						@Override
						public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
							Vodafone_Rewards rewards = new Vodafone_Rewards();

							rewards.setP3_seg1_monthly_ach(rs.getInt("REV"));

							return rewards;
						}

					});

			if (month.equals("APR19")) {

				if (account_master.getAccount_manager().equals("Sindhu")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP3_seg1_monthly_tgt(1);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP3_seg1_monthly_tgt(1);
				}
			}
			if (month.equals("MAY19")) {
				rewards.setRange("M2");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP3_seg1_monthly_tgt(1);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP3_seg1_monthly_tgt(1);
				}
			}
			if (month.equals("JUN19")) {
				rewards.setRange("M3");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP3_seg1_monthly_tgt(1);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP3_seg1_monthly_tgt(1);
				}
			}
			rewards.setP3_seg1_monthly_ach(vodafone_segment1.get(0).getP3_seg1_monthly_ach());

			// parameter3 Segment2
			String sql_vodafone_segment2 = "select sum(REV) REV from VODAFONE_REVENUE_MASTER where ACCOUNT_MANAGER = '"
					+ account_master.getAccount_manager() + "'" + " and month = '" + month + "' and PRODUCT = 'CLOUD'";

			List<Vodafone_Rewards> vodafone_segment2 = jdbcTemplate.query(sql_vodafone_segment2,
					new RowMapper<Vodafone_Rewards>() {

						@Override
						public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
							Vodafone_Rewards rewards = new Vodafone_Rewards();

							rewards.setP3_seg1_monthly_ach(rs.getInt("REV"));

							return rewards;
						}

					});

			if (month.equals("APR19")) {

				if (account_master.getAccount_manager().equals("Sindhu")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP3_seg2_monthly_tgt(0);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					System.out.println("acc name " + account_master.getAccount_manager());
					rewards.setP3_seg2_monthly_tgt(0);
				}
			}
			if (month.equals("MAY19")) {
				rewards.setRange("M2");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP3_seg2_monthly_tgt(0);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP3_seg2_monthly_tgt(0);
				}
			}
			if (month.equals("JUN19")) {
				rewards.setRange("M3");

				if (account_master.getAccount_manager().equals("Sindhu")) {
					rewards.setP3_seg2_monthly_tgt(0);
				}
				if (account_master.getAccount_manager().equals("Vasudeva Reddy S")) {
					rewards.setP3_seg2_monthly_tgt(0);
				}
			}
			rewards.setP3_seg2_monthly_ach(vodafone_segment2.get(0).getP3_seg2_monthly_ach());

			rewards_list.add(rewards);

		}

		Date Sd = new Date();
		System.out.println("Start call to webservice" + Sd);

//		maxlife_Adms = 
		call_vodafone_schopasoap_webservice(rewards_list, schopawebserviceUrl, request, month);

		Date Ed = new Date();
		System.out.println("End call to webservice" + Ed);

		System.out.println("Total time : Sw " + Sd + " Ew " + Ed);

		List<Vodafone_Rewards> rewards = new ArrayList<>();
		for (Vodafone_Rewards reward : rewards_list) {
			rewards.add(reward);

			try {

				Statement statement = hibernateConfiguration.getjdbcTemplate().getDataSource().getConnection()
						.createStatement();
				statement.executeUpdate("INSERT INTO VODAFONE_REWARD " + "VALUES (VODAFONE_REWARD_SEQ.NEXTVAL, '"
						+ reward.getRange() + "', '" + reward.getCircle() + "', '" + reward.getEmp_name() + "', "
						+ reward.getEmp_code() + ", '" + reward.getRole() + "', '" + reward.getEmp_status() + "', '"
						+ reward.getMonth() + "'," + reward.getTarget_payout() + "," + reward.getP1_monthly_tgt() + ","
						+ reward.getP1_monthly_ach() + "," + reward.getP1_cum_tgt() + "," + reward.getP1_cum_ach() + ","
						+ reward.getP1_monthly_ach_per() + "," + reward.getP1_cum_ach_per() + "," + reward.getP1_mtd()
						+ "," + reward.getP1_ytd() + "," + reward.getP1_weightage() + ","
						+ reward.getP2_mb_monthly_tgt() + "," + reward.getP2_mb_monthly_ach() + ","
						+ reward.getP2_mb_cum_tgt() + "," + reward.getP2_mb_cum_ach() + ","
						+ reward.getP2_mb_monthly_ach_per() + "," + reward.getP2_mb_cum_ach_per() + ","
						+ reward.getP2_fld_monthly_tgt() + "," + reward.getP2_fld_monthly_ach() + ","
						+ reward.getP2_fld_cum_tgt() + "," + reward.getP2_fld_cum_ach() + ","
						+ reward.getP2_fld_monthly_ach_per() + "," + reward.getP2_fld_cum_ach_per() + ","
						+ reward.getP2_flv_monthly_tgt() + "," + reward.getP2_flv_monthly_ach() + ","
						+ reward.getP2_flv_cum_tgt() + "," + reward.getP2_flv_cum_ach() + ","
						+ reward.getP2_flv_monthly_ach_per() + "," + reward.getP2_flv_cum_ach_per() + ","
						+ reward.getP2_iot_monthly_tgt() + "," + reward.getP2_iot_monthly_ach() + ","
						+ reward.getP2_iot_cum_tgt() + "," + reward.getP2_iot_cum_ach() + ","
						+ reward.getP2_iot_monthly_ach_per() + "," + reward.getP2_iot_cum_ach_per() + ","
						+ reward.getP2_cloud_monthly_tgt() + "," + reward.getP2_cloud_monthly_ach() + ","
						+ reward.getP2_cloud_cum_tgt() + "," + reward.getP2_cloud_cum_ach() + ","
						+ reward.getP2_monthly_ach() + "," + reward.getP2_cum_ach() + "," + reward.getP2_mtd() + ","
						+ reward.getP2_ytd() + "," + reward.getP2_weightage() + "," + reward.getP3_seg1_monthly_tgt()
						+ "," + reward.getP3_seg1_monthly_ach() + "," + reward.getP3_seg1_cum_tgt() + ","
						+ reward.getP3_seg1_cum_ach() + "," + reward.getP3_seg1_monthly_ach_per() + ","
						+ reward.getP3_seg1_cum_ach_per() + "," + reward.getP3_seg2_monthly_tgt() + ","
						+ reward.getP3_seg2_monthly_ach() + "," + reward.getP3_seg2_cum_tgt() + ","
						+ reward.getP3_seg2_cum_ach() + "," + reward.getP3_seg2_monthly_ach_per() + ","
						+ reward.getP3_seg2_cum_ach_per() + "," + reward.getP3_monthly_ach() + ","
						+ reward.getP3_cum_ach() + "," + reward.getP3_mtd() + "," + reward.getP3_ytd() + ","
						+ reward.getP3_weightage() + "," + reward.getOverall_ach() + "," + reward.getP1_qtd_payout()
						+ "," + reward.getP1_ytd_payout() + "," + reward.getP2_qtd_payout() + ","
						+ reward.getP2_ytd_payout() + "," + reward.getP3_qtd_payout() + "," + reward.getP3_ytd_payout()
						+ "," + reward.getTotal_payout_sip() + "," + reward.getFinal_payout_amt() + ","
						+ reward.getP2_cloud_monthly_ach() + "," + reward.getP2_cloud_cum_ach() + ")");
				statement.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Run for quarter
		if (month.equals("JUN19")) {
			int count1 = 0;
			for (Vodafone_Account_Master account_master : account_master_list) {
				count1++;
				System.out.println("in Vodafone Account " + count1);

				Vodafone_Rewards rewards_q1 = new Vodafone_Rewards();
				rewards_q1.setTarget_payout(3000);
				rewards_q1.setEmp_code(0);
				rewards_q1.setEmp_name(account_master.getAccount_manager());
				rewards_q1.setRole("Account Manager");
				rewards_q1.setEmp_status("BAU");
				rewards_q1.setCircle("AP");
				rewards_q1.setMonth(month);

				// previous cum tgt and ach rev

				String sql_vodafone_pre = "select * from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " and month = '" + month + "'";

				List<Vodafone_Rewards> vodafone_pre = jdbcTemplate.query(sql_vodafone_pre,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP1_cum_tgt(rs.getFloat("P1_CUM_TGT"));
								rewards.setP1_cum_ach(rs.getFloat("P1_CUM_ACH"));

								rewards.setP2_mb_cum_tgt(rs.getFloat("P2_MOB_CUM_TGT"));
								rewards.setP2_mb_cum_ach(rs.getFloat("P2_MOB_CUM_ACH"));

								rewards.setP2_fld_cum_tgt(rs.getFloat("P2_FLD_CUM_TGT"));
								rewards.setP2_fld_cum_ach(rs.getFloat("P2_FLD_CUM_ACH"));

								rewards.setP2_flv_cum_tgt(rs.getFloat("P2_FLV_CUM_TGT"));
								rewards.setP2_flv_cum_ach(rs.getFloat("P2_FLV_CUM_ACH"));

								rewards.setP2_iot_cum_tgt(rs.getFloat("P2_IOT_CUM_TGT"));
								rewards.setP2_iot_cum_ach(rs.getFloat("P2_IOT_CUM_ACH"));

								rewards.setP2_cloud_cum_tgt(rs.getFloat("P2_CLD_CUM_TGT"));
								rewards.setP2_cloud_cum_ach(rs.getFloat("P2_CLD_CUM_ACH"));

								rewards.setP3_seg1_cum_tgt(rs.getFloat("P3_SEG1_CUM_TGT"));
								rewards.setP3_seg1_cum_ach(rs.getFloat("P3_SEG1_CUM_ACH"));

								rewards.setP3_seg2_cum_tgt(rs.getFloat("P3_SEG2_CUM_TGT"));
								rewards.setP3_seg2_cum_ach(rs.getFloat("P3_SEG2_CUM_ACH"));

								return rewards;
							}

						});

				// parameter1 revenue
				String sql_vodafone_rev = "select sum(P1_MONTHLY_TGT) p1_monthly_tgt from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + "";

				List<Vodafone_Rewards> vodafone_rev = jdbcTemplate.query(sql_vodafone_rev,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP1_monthly_tgt(rs.getInt("p1_monthly_tgt"));

								return rewards;
							}

						});

				String sql_vodafone_rev_ach = "select sum(P1_MONTHLY_ACH) p1_monthly_ach from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'";

				List<Vodafone_Rewards> vodafone_rev_ach = jdbcTemplate.query(sql_vodafone_rev_ach,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP1_monthly_ach(rs.getInt("p1_monthly_ach"));

								return rewards;
							}

						});

				if (month.equals("JUN19")) {
					rewards_q1.setRange("Q1");

					if (!vodafone_pre.isEmpty()) {
						rewards_q1.setP1_cum_tgt(vodafone_pre.get(0).getP1_cum_tgt());
						rewards_q1.setP1_cum_ach(vodafone_pre.get(0).getP1_cum_tgt());

						rewards_q1.setP2_mb_cum_tgt(vodafone_pre.get(0).getP2_mb_cum_tgt());
						rewards_q1.setP2_mb_cum_ach(vodafone_pre.get(0).getP2_mb_cum_tgt());

						rewards_q1.setP2_fld_cum_tgt(vodafone_pre.get(0).getP2_fld_cum_tgt());
						rewards_q1.setP2_fld_cum_ach(vodafone_pre.get(0).getP2_fld_cum_tgt());

						rewards_q1.setP2_flv_cum_tgt(vodafone_pre.get(0).getP2_flv_cum_tgt());
						rewards_q1.setP2_flv_cum_ach(vodafone_pre.get(0).getP2_flv_cum_tgt());

						rewards_q1.setP2_iot_cum_tgt(vodafone_pre.get(0).getP2_iot_cum_tgt());
						rewards_q1.setP2_iot_cum_ach(vodafone_pre.get(0).getP2_iot_cum_tgt());

						rewards_q1.setP2_cloud_cum_tgt(vodafone_pre.get(0).getP2_cloud_cum_tgt());
						rewards_q1.setP2_cloud_cum_ach(vodafone_pre.get(0).getP2_cloud_cum_tgt());

						rewards_q1.setP3_seg1_cum_tgt(vodafone_pre.get(0).getP3_seg1_cum_tgt());
						rewards_q1.setP3_seg1_cum_ach(vodafone_pre.get(0).getP3_seg1_cum_tgt());

						rewards_q1.setP3_seg2_cum_tgt(vodafone_pre.get(0).getP3_seg2_cum_tgt());
						rewards_q1.setP3_seg2_cum_ach(vodafone_pre.get(0).getP3_seg2_cum_tgt());
					}

				}

				rewards_q1.setP1_monthly_tgt(vodafone_rev.get(0).getP1_monthly_tgt());
				rewards_q1.setP1_monthly_ach(vodafone_rev_ach.get(0).getP1_monthly_ach());

				// parameter2 mobility
				String sql_vodafone_mobility = "select sum(P2_MOB_MONTHLY_TGT) p2_mob_monthly_tgt from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_mobility = jdbcTemplate.query(sql_vodafone_mobility,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP2_mb_monthly_tgt(rs.getInt("p2_mob_monthly_tgt"));

								return rewards;
							}

						});

				String sql_vodafone_mobility_ach = "select sum(P2_MOB_MONTHLY_ACH) p2_mob_monthly_ach from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_mobility_ach = jdbcTemplate.query(sql_vodafone_mobility_ach,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP2_mb_monthly_ach(rs.getInt("p2_mob_monthly_ach"));

								return rewards;
							}

						});

				if (month.equals("JUN19")) {
					rewards_q1.setRange("Q1");
				}

				rewards_q1.setP2_mb_monthly_tgt(vodafone_mobility.get(0).getP2_mb_monthly_tgt());
				rewards_q1.setP2_mb_monthly_ach(vodafone_mobility_ach.get(0).getP2_mb_monthly_ach());

				// parameter2 FLD
				String sql_vodafone_fld = "select sum(P2_FLD_MONTHLY_TGT) p2_fld_monthly_tgt from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_fld = jdbcTemplate.query(sql_vodafone_fld,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP2_fld_monthly_tgt(rs.getInt("p2_fld_monthly_tgt"));

								return rewards;
							}

						});

				String sql_vodafone_fld_ach = "select sum(P2_FLD_MONTHLY_ACH) p2_fld_monthly_ach from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_fld_ach = jdbcTemplate.query(sql_vodafone_fld_ach,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP2_fld_monthly_ach(rs.getInt("p2_fld_monthly_ach"));

								return rewards;
							}

						});

				if (month.equals("JUN19")) {
					rewards_q1.setRange("Q1");
				}

				rewards_q1.setP2_fld_monthly_tgt(vodafone_fld.get(0).getP2_fld_monthly_tgt());
				rewards_q1.setP2_fld_monthly_ach(vodafone_fld_ach.get(0).getP2_fld_monthly_ach());

				// parameter2 FLV
				String sql_vodafone_flv = "select sum(P2_FLV_MONTHLY_TGT) p2_flv_monthly_tgt from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_flv = jdbcTemplate.query(sql_vodafone_flv,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP2_flv_monthly_tgt(rs.getInt("p2_flv_monthly_tgt"));

								return rewards;
							}

						});

				String sql_vodafone_flv_ach = "select sum(P2_FLV_MONTHLY_ACH) p2_flv_monthly_ach from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_flv_ach = jdbcTemplate.query(sql_vodafone_flv_ach,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP2_flv_monthly_ach(rs.getInt("p2_flv_monthly_ach"));

								return rewards;
							}

						});

				if (month.equals("JUN19")) {
					rewards_q1.setRange("Q1");
				}

				rewards_q1.setP2_flv_monthly_tgt(vodafone_flv.get(0).getP2_flv_monthly_tgt());
				rewards_q1.setP2_flv_monthly_ach(vodafone_flv_ach.get(0).getP2_flv_monthly_ach());

				// parameter2 iot
				String sql_vodafone_iot = "select sum(P2_IOT_MONTHLY_TGT) p2_iot_monthly_tgt from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_iot = jdbcTemplate.query(sql_vodafone_iot,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP2_iot_monthly_tgt(rs.getInt("p2_iot_monthly_tgt"));

								return rewards;
							}

						});

				String sql_vodafone_iot_ach = "select sum(P2_IOT_MONTHLY_ACH) p2_iot_monthly_ach from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_iot_ach = jdbcTemplate.query(sql_vodafone_iot_ach,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP2_iot_monthly_ach(rs.getInt("p2_iot_monthly_ach"));

								return rewards;
							}

						});

				if (month.equals("JUN19")) {
					rewards_q1.setRange("Q1");
				}

				rewards_q1.setP2_iot_monthly_tgt(vodafone_iot.get(0).getP2_iot_monthly_tgt());
				rewards_q1.setP2_iot_monthly_ach(vodafone_iot_ach.get(0).getP2_iot_monthly_ach());

				// parameter2 cloud
				String sql_vodafone_cld = "select sum(P2_CLD_MONTHLY_TGT) p2_cld_monthly_tgt from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_cld = jdbcTemplate.query(sql_vodafone_cld,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP2_cloud_monthly_tgt(rs.getInt("p2_cld_monthly_tgt"));

								return rewards;
							}

						});

				String sql_vodafone_cld_ach = "select sum(P2_CLD_MONTHLY_ACH) p2_cld_monthly_ach from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_cld_ach = jdbcTemplate.query(sql_vodafone_cld_ach,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP2_cloud_monthly_ach(rs.getInt("p2_cld_monthly_ach"));

								return rewards;
							}

						});

				if (month.equals("JUN19")) {
					rewards_q1.setRange("Q1");
				}

				rewards_q1.setP2_cloud_monthly_tgt(vodafone_cld.get(0).getP2_cloud_monthly_tgt());
				rewards_q1.setP2_cloud_monthly_ach(vodafone_cld_ach.get(0).getP2_cloud_monthly_ach());

				// parameter3 seg1
				String sql_vodafone_seg1 = "select sum(P3_SEG1_MONTHLY_TGT) p3_seg1_monthly_tgt from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_seg1 = jdbcTemplate.query(sql_vodafone_seg1,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP3_seg1_monthly_tgt(rs.getInt("p3_seg1_monthly_tgt"));

								return rewards;
							}

						});

				String sql_vodafone_seg1_ach = "select sum(P3_SEG1_MONTHLY_ACH) p3_seg1_monthly_ach from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_seg1_ach = jdbcTemplate.query(sql_vodafone_seg1_ach,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP3_seg1_monthly_ach(rs.getInt("p3_seg1_monthly_ach"));

								return rewards;
							}

						});

				if (month.equals("JUN19")) {
					rewards_q1.setRange("Q1");
				}

				rewards_q1.setP3_seg1_monthly_tgt(vodafone_seg1.get(0).getP3_seg1_monthly_tgt());
				rewards_q1.setP3_seg1_monthly_ach(vodafone_seg1_ach.get(0).getP3_seg1_monthly_ach());

				// parameter3 seg2
				String sql_vodafone_seg2 = "select sum(P3_SEG2_MONTHLY_TGT) p3_seg2_monthly_tgt from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_seg2 = jdbcTemplate.query(sql_vodafone_seg2,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP3_seg2_monthly_tgt(rs.getInt("p3_seg2_monthly_tgt"));

								return rewards;
							}

						});

				String sql_vodafone_seg2_ach = "select sum(P3_SEG2_MONTHLY_ACH) p3_seg2_monthly_ach from VODAFONE_REWARD where EMP_NAME = '"
						+ account_master.getAccount_manager() + "'" + " ";

				List<Vodafone_Rewards> vodafone_seg2_ach = jdbcTemplate.query(sql_vodafone_seg2_ach,
						new RowMapper<Vodafone_Rewards>() {

							@Override
							public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
								Vodafone_Rewards rewards = new Vodafone_Rewards();

								rewards.setP3_seg2_monthly_ach(rs.getInt("p3_seg2_monthly_ach"));

								return rewards;
							}

						});

				if (month.equals("JUN19")) {
					rewards_q1.setRange("Q1");
				}

				rewards_q1.setP3_seg2_monthly_tgt(vodafone_seg2.get(0).getP3_seg2_monthly_tgt());
				rewards_q1.setP3_seg2_monthly_ach(vodafone_seg2_ach.get(0).getP3_seg2_monthly_ach());

				rewards_list_q.add(rewards_q1);

			}

			Date Sd1 = new Date();
			System.out.println("Start call to webservice" + Sd1);

//					maxlife_Adms = 
			call_vodafone_schopasoap_webservice(rewards_list_q, schopawebserviceUrl, request, month);

			Date Ed1 = new Date();
			System.out.println("End call to webservice" + Ed1);

			System.out.println("Total time : Sw " + Sd1 + " Ew " + Ed1);

			List<Vodafone_Rewards> rewards_q = new ArrayList<>();
			for (Vodafone_Rewards reward : rewards_list_q) {
				rewards.add(reward);

				try {

					Statement statement = hibernateConfiguration.getjdbcTemplate().getDataSource().getConnection()
							.createStatement();
					statement.executeUpdate("INSERT INTO VODAFONE_REWARD " + "VALUES (VODAFONE_REWARD_SEQ.NEXTVAL, '"
							+ reward.getRange() + "', '" + reward.getCircle() + "', '" + reward.getEmp_name() + "', "
							+ reward.getEmp_code() + ", '" + reward.getRole() + "', '" + reward.getEmp_status() + "', '"
							+ reward.getMonth() + "'," + reward.getTarget_payout() + "," + reward.getP1_monthly_tgt()
							+ "," + reward.getP1_monthly_ach() + "," + reward.getP1_cum_tgt() + ","
							+ reward.getP1_cum_ach() + "," + reward.getP1_monthly_ach_per() + ","
							+ reward.getP1_cum_ach_per() + "," + reward.getP1_mtd() + "," + reward.getP1_ytd() + ","
							+ reward.getP1_weightage() + "," + reward.getP2_mb_monthly_tgt() + ","
							+ reward.getP2_mb_monthly_ach() + "," + reward.getP2_mb_cum_tgt() + ","
							+ reward.getP2_mb_cum_ach() + "," + reward.getP2_mb_monthly_ach_per() + ","
							+ reward.getP2_mb_cum_ach_per() + "," + reward.getP2_fld_monthly_tgt() + ","
							+ reward.getP2_fld_monthly_ach() + "," + reward.getP2_fld_cum_tgt() + ","
							+ reward.getP2_fld_cum_ach() + "," + reward.getP2_fld_monthly_ach_per() + ","
							+ reward.getP2_fld_cum_ach_per() + "," + reward.getP2_flv_monthly_tgt() + ","
							+ reward.getP2_flv_monthly_ach() + "," + reward.getP2_flv_cum_tgt() + ","
							+ reward.getP2_flv_cum_ach() + "," + reward.getP2_flv_monthly_ach_per() + ","
							+ reward.getP2_flv_cum_ach_per() + "," + reward.getP2_iot_monthly_tgt() + ","
							+ reward.getP2_iot_monthly_ach() + "," + reward.getP2_iot_cum_tgt() + ","
							+ reward.getP2_iot_cum_ach() + "," + reward.getP2_iot_monthly_ach_per() + ","
							+ reward.getP2_iot_cum_ach_per() + "," + reward.getP2_cloud_monthly_tgt() + ","
							+ reward.getP2_cloud_monthly_ach() + "," + reward.getP2_cloud_cum_tgt() + ","
							+ reward.getP2_cloud_cum_ach() + "," + reward.getP2_monthly_ach() + ","
							+ reward.getP2_cum_ach() + "," + reward.getP2_mtd() + "," + reward.getP2_ytd() + ","
							+ reward.getP2_weightage() + "," + reward.getP3_seg1_monthly_tgt() + ","
							+ reward.getP3_seg1_monthly_ach() + "," + reward.getP3_seg1_cum_tgt() + ","
							+ reward.getP3_seg1_cum_ach() + "," + reward.getP3_seg1_monthly_ach_per() + ","
							+ reward.getP3_seg1_cum_ach_per() + "," + reward.getP3_seg2_monthly_tgt() + ","
							+ reward.getP3_seg2_monthly_ach() + "," + reward.getP3_seg2_cum_tgt() + ","
							+ reward.getP3_seg2_cum_ach() + "," + reward.getP3_seg2_monthly_ach_per() + ","
							+ reward.getP3_seg2_cum_ach_per() + "," + reward.getP3_monthly_ach() + ","
							+ reward.getP3_cum_ach() + "," + reward.getP3_mtd() + "," + reward.getP3_ytd() + ","
							+ reward.getP3_weightage() + "," + reward.getOverall_ach() + "," + reward.getP1_qtd_payout()
							+ "," + reward.getP1_ytd_payout() + "," + reward.getP2_qtd_payout() + ","
							+ reward.getP2_ytd_payout() + "," + reward.getP3_qtd_payout() + ","
							+ reward.getP3_ytd_payout() + "," + reward.getTotal_payout_sip() + ","
							+ reward.getFinal_payout_amt() + "," + reward.getP2_cloud_monthly_ach() + ","
							+ reward.getP2_cloud_cum_ach() + ")");
					statement.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		String sql = "select * from vodafone_reward where emp_name IN (select emp_name from vodafone_reward group by emp_name)order by emp_name,range";

		List<Vodafone_Rewards> final_rewards = jdbcTemplate.query(sql, new RowMapper<Vodafone_Rewards>() {

			@Override
			public Vodafone_Rewards mapRow(ResultSet rs, int rowNum) throws SQLException {
				Vodafone_Rewards rewards = new Vodafone_Rewards();
				rewards.setRw_id(rs.getInt("RW_ID"));
				rewards.setRange(rs.getString("RANGE"));
				rewards.setCircle(rs.getString("CIRCLE"));
				rewards.setEmp_name(rs.getString("EMP_NAME"));
				rewards.setEmp_code(rs.getInt("EMP_CODE"));
				rewards.setRole(rs.getString("ROLE"));
				rewards.setEmp_status(rs.getString("EMP_STATUS"));
				rewards.setMonth(rs.getString("MONTH"));
				rewards.setTarget_payout(rs.getInt("TARGET_PAYOUT"));

				rewards.setP1_monthly_tgt(rs.getInt("P1_MONTHLY_TGT"));
				rewards.setP1_monthly_ach(rs.getInt("P1_MONTHLY_ACH"));
				rewards.setP1_cum_tgt(rs.getFloat("P1_CUM_TGT"));
				rewards.setP1_cum_ach(rs.getFloat("P1_CUM_ACH"));
				rewards.setP1_monthly_ach_per(rs.getFloat("P1_PER_MONTH_ACH"));
				rewards.setP1_cum_ach_per(rs.getFloat("P1_PER_CUM_ACH"));
				rewards.setP1_mtd(rs.getFloat("P1_PAYOUT_MTD"));
				rewards.setP1_ytd(rs.getFloat("P1_PAYOUT_YTD"));
				rewards.setP1_weightage(rs.getFloat("P1_WEIGHTAGE"));

				rewards.setP2_mb_monthly_tgt(rs.getInt("P2_MOB_MONTHLY_TGT"));
				rewards.setP2_mb_monthly_ach(rs.getInt("P2_MOB_MONTHLY_ACH"));
				rewards.setP2_mb_cum_tgt(rs.getFloat("P2_MOB_CUM_TGT"));
				rewards.setP2_mb_cum_ach(rs.getFloat("P2_MOB_CUM_ACH"));
				rewards.setP2_mb_monthly_ach_per(rs.getFloat("P2_PER_MOB_MONTH_ACH"));
				rewards.setP2_mb_cum_ach_per(rs.getFloat("P2_MOB_PER_CUM_ACH"));

				rewards.setP2_fld_monthly_tgt(rs.getInt("P2_FLD_MONTHLY_TGT"));
				rewards.setP2_fld_monthly_ach(rs.getInt("P2_FLD_MONTHLY_ACH"));
				rewards.setP2_fld_cum_tgt(rs.getFloat("P2_FLD_CUM_TGT"));
				rewards.setP2_fld_cum_ach(rs.getFloat("P2_FLD_CUM_ACH"));
				rewards.setP2_fld_monthly_ach_per(rs.getFloat("P2_FLD_PER_MONTH_ACH"));
				rewards.setP2_fld_cum_ach_per(rs.getFloat("P2_FLD_PER_CUM_ACH"));

				rewards.setP2_flv_monthly_tgt(rs.getInt("P2_FLV_MONTHLY_TGT"));
				rewards.setP2_flv_monthly_ach(rs.getInt("P2_FLV_MONTHLY_ACH"));
				rewards.setP2_flv_cum_tgt(rs.getFloat("P2_FLV_CUM_TGT"));
				rewards.setP2_flv_cum_ach(rs.getFloat("P2_FLV_CUM_ACH"));
				rewards.setP2_flv_monthly_ach_per(rs.getFloat("P2_FLV_PER_MONTH_ACH"));
				rewards.setP2_flv_cum_ach_per(rs.getFloat("P2_FLV_PER_CUM_ACH"));

				rewards.setP2_iot_monthly_tgt(rs.getInt("P2_IOT_MONTHLY_TGT"));
				rewards.setP2_iot_monthly_ach(rs.getInt("P2_IOT_MONTHLY_ACH"));
				rewards.setP2_iot_cum_tgt(rs.getFloat("P2_IOT_CUM_TGT"));
				rewards.setP2_iot_cum_ach(rs.getFloat("P2_IOT_CUM_ACH"));
				rewards.setP2_iot_monthly_ach_per(rs.getFloat("P2_IOT_PER_MONTH_ACH"));
				rewards.setP2_iot_cum_ach_per(rs.getFloat("P2_IOT_PER_CUM_ACH"));

				rewards.setP2_cloud_monthly_tgt(rs.getInt("P2_CLD_MONTHLY_TGT"));
				rewards.setP2_cloud_monthly_ach(rs.getInt("P2_CLD_MONTHLY_ACH"));
				rewards.setP2_cloud_cum_tgt(rs.getFloat("P2_CLD_CUM_TGT"));
				rewards.setP2_cloud_cum_ach(rs.getFloat("P2_CLD_CUM_ACH"));
				rewards.setP2_cloud_monthly_ach_per(rs.getFloat("P2_CLD_PER_MONTH_ACH"));
				rewards.setP2_cloud_cum_ach_per(rs.getFloat("P2_CLD_PER_CUM_ACH"));

				rewards.setP2_monthly_ach(rs.getFloat("P2_TOT_PER_MONTH_ACH"));
				rewards.setP2_cum_ach(rs.getFloat("P2_TOT_PER_CUM_ACH"));
				rewards.setP2_mtd(rs.getFloat("P2_TOT_PAYOUT_MTD"));
				rewards.setP2_ytd(rs.getFloat("P2_TOT_PAYOUT_YTD"));
				rewards.setP2_weightage(rs.getFloat("P2_TOT_WEIGHTAGE"));

				rewards.setP3_seg1_monthly_tgt(rs.getInt("P3_SEG1_MONTHLY_TGT"));
				rewards.setP3_seg1_monthly_ach(rs.getInt("P3_SEG1_MONTHLY_ACH"));
				rewards.setP3_seg1_cum_tgt(rs.getFloat("P3_SEG1_CUM_TGT"));
				rewards.setP3_seg1_cum_ach(rs.getFloat("P3_SEG1_CUM_ACH"));
				rewards.setP3_seg1_monthly_ach_per(rs.getFloat("P3_SEG1_PER_MONTH_ACH"));
				rewards.setP3_seg1_cum_ach_per(rs.getFloat("P3_SEG1_PER_CUM_ACH"));

				rewards.setP3_seg2_monthly_tgt(rs.getInt("P3_SEG2_MONTHLY_TGT"));
				rewards.setP3_seg2_monthly_ach(rs.getInt("P3_SEG2_MONTHLY_ACH"));
				rewards.setP3_seg2_cum_tgt(rs.getFloat("P3_SEG2_CUM_TGT"));
				rewards.setP3_seg2_cum_ach(rs.getFloat("P3_SEG2_CUM_ACH"));
				rewards.setP3_seg2_monthly_ach_per(rs.getFloat("P3_SEG2_PER_MONTH_ACH"));
				rewards.setP3_seg2_cum_ach_per(rs.getFloat("P3_SEG2_PER_CUM_ACH"));

				rewards.setP3_monthly_ach(rs.getFloat("P3_TOT_PER_MONTH_ACH"));
				rewards.setP3_cum_ach(rs.getFloat("P3_TOT_PER_CUM_ACH"));
				rewards.setP3_mtd(rs.getFloat("P3_TOT_PAYOUT_MTD"));
				rewards.setP3_ytd(rs.getFloat("P3_TOT_PAYOUT_YTD"));
				rewards.setP3_weightage(rs.getFloat("P3_TOT_WEIGHTAGE"));

				rewards.setP1_qtd_payout(rs.getInt("P1_QTD_PAYOUT"));
				rewards.setP1_ytd_payout(rs.getInt("P1_YTD_PAYOUT"));
				rewards.setP2_qtd_payout(rs.getInt("P2_QTD_PAYOUT"));
				rewards.setP2_ytd_payout(rs.getInt("P2_YTD_PAYOUT"));

				rewards.setP3_qtd_payout(rs.getInt("P3_QTD_PAYOUT"));
				rewards.setP3_ytd_payout(rs.getInt("P3_YTD_PAYOUT"));
				rewards.setOverall_ach(rs.getFloat("OVERALL_ACH"));

				rewards.setTotal_payout_sip(rs.getInt("TOT_PAYOUT_SIP"));
				rewards.setFinal_payout_amt(rs.getInt("FINAL_PAYOUT_AMT"));

				return rewards;
			}

		});

		model.addAttribute("Info_grid", final_rewards);

		HttpSession session = request.getSession();
		session.setAttribute("rewards", final_rewards);

		return new ModelAndView("VodafoneSchemeAnalysis");
	}

//	public List<Maxlife_Adm> 
	public void call_vodafone_schopasoap_webservice(List<Vodafone_Rewards> rewards_list, String schopawebserviceUrl,
			HttpServletRequest request, String month) {
		// TODO Auto-generated method stub

		// Create SOAP Connection

		try {
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();

			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			// Send SOAP Message to SOAP Server
			// final String url =
			// "https://omfys-opa.custhelp.com/determinations-server/assess/soap/generic/12.2.1/BPIL__Seal__O__Prime__November__Dhamaka__Offer?wsdl";
			final String url = schopawebserviceUrl;
			SOAPMessage soapRequest = createvodafone_schSOAPRequest(rewards_list, month);

			TransformerFactory transformerFactoryReq = TransformerFactory.newInstance();
			Transformer transformerReq = transformerFactoryReq.newTransformer();
			Source sourceContentReq = soapRequest.getSOAPPart().getContent();

			String reqxmlpath = request.getServletContext().getRealPath("/WEB-INF/classes/com/report");

			System.out.println("xmlpath = " + reqxmlpath);

			StreamResult resultReq = new StreamResult(new FileOutputStream(new File(reqxmlpath + "\\soaprequest.xml")));
			transformerReq.transform(sourceContentReq, resultReq);

			SOAPMessage soapResponse = soapConnection.call(soapRequest, url);

			TransformerFactory transformerFactoryResp = TransformerFactory.newInstance();
			Transformer transformerResp = transformerFactoryResp.newTransformer();
			Source sourceContentResp = soapResponse.getSOAPPart().getContent();

			StreamResult resultResp = new StreamResult(
					new FileOutputStream(new File(reqxmlpath + "\\soapresponse.xml")));
			transformerResp.transform(sourceContentResp, resultResp);

			// Process the SOAP Response
//			 maxlife_Adms = 
			printvodafone_schSOAPResponse(soapRequest, soapResponse, rewards_list, request);

			soapConnection.close();

		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		return maxlife_Adms;

	}

	private SOAPMessage createvodafone_schSOAPRequest(List<Vodafone_Rewards> rewards_list, String month)
			throws SOAPException, IOException {
		// TODO Auto-generated method stub

		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		final String serverURI = "http://oracle.com/determinations/server/12.2.1/rulebase/assess/types";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("typ", serverURI);

		SOAPFactory soapFactory = SOAPFactory.newInstance();

		System.out.println("SOAP Envelope");

		// SOAP Header
		SOAPHeader soapHeader = envelope.getHeader();

		final String seqHeader = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
		Name headerName = soapFactory.createName("Security", "o", seqHeader);

		SOAPHeaderElement headerElement = soapHeader.addHeaderElement(headerName);
		headerElement.setMustUnderstand(true);

		final String Username = "omfys";
		final String Password = "Omfys@123";

		SOAPElement soapUserToken = headerElement.addChildElement("UsernameToken", "o");
		SOAPElement sopaUser = soapUserToken.addChildElement("Username", "o");
		sopaUser.addTextNode(Username);
		SOAPElement sopaPass = soapUserToken.addChildElement("Password", "o");
		sopaPass.addTextNode(Password);

		SOAPHeader header = soapMessage.getSOAPHeader();
		SOAPBody body = soapMessage.getSOAPBody();

		System.out.println("SOAP Header");

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();

		SOAPElement soapBodyElem = soapBody.addChildElement("assess-request", "typ");

		System.out.println("SOAP Body");

		SOAPElement config = soapBodyElem.addChildElement("config", "typ");

		SOAPElement outcome = config.addChildElement("outcome", "typ");

		ArrayList<String> outcome_entity_type = new ArrayList<String>();

		outcome_entity_type.add("the_employee");

		ArrayList<String> Employee_outcome = new ArrayList<String>();

		for (String outcome_entity : outcome_entity_type) {

			if (outcome_entity.equals("the_employee")) {
				Employee_outcome.add("the_employee_range");
				Employee_outcome.add("the_employee_circle");
				Employee_outcome.add("the_employee_name");
				Employee_outcome.add("the_employee_code");
				Employee_outcome.add("the_employee_role");
				Employee_outcome.add("the_employee_status");
				Employee_outcome.add("the_employee_on_target_payout");

				Employee_outcome.add("the_employee_P1_Revenue_TGT");
				Employee_outcome.add("the_employee_P1_Revenue_ACH");

				Employee_outcome.add("the_employee_P1_Revenue_Previous_CUM_TGT");
				Employee_outcome.add("the_employee_P1_Revenue_CUM_TGT");
				Employee_outcome.add("the_employee_P1_Revenue_Previous_CUM_ACH");
				Employee_outcome.add("the_employee_P1_Revenue_CUM_ACH");
				Employee_outcome.add("the_employee_P1_Revenue_percent_ACH");
				Employee_outcome.add("the_employee_P1_Revenue_percent_CUM");
				Employee_outcome.add("the_employee_p1_Revenue_payout_slab_MTD");
				Employee_outcome.add("the_employee_P1_Revenue_payout_slab_YTD");
				Employee_outcome.add("the_employee_P1_Revenue_weightage");

				Employee_outcome.add("the_employee_p2_TGT_for_MobilityOB");
				Employee_outcome.add("the_employee_p2_ACH_for_MobilityOB");

				Employee_outcome.add("the_employee_p2_Previous_CUM_TGT_for_MobilityOB");
				Employee_outcome.add("the_employee_p2_CUM_TGT_for_MobilityOB");
				Employee_outcome.add("the_employee_p2_Previous_CUM_ACH_for_MobilityOB");
				Employee_outcome.add("the_employee_p2_CUM_ACH_for_MobilityOB");
				Employee_outcome.add("the_employee_p2_percent_ACH_for_MobilityOB");
				Employee_outcome.add("the_employee_p2_percent_CUM_for_MobilityOB");

				Employee_outcome.add("the_employee_p2_TGT_for_FLDOB");
				Employee_outcome.add("the_employee_p2_ACH_for_FLDOB");

				Employee_outcome.add("the_employee_p2_Previous_CUM_TGT_for_FLDOB");
				Employee_outcome.add("the_employee_p2_CUM_TGT_for_FLDOB");
				Employee_outcome.add("the_employee_p2_Previous_CUM_ACH_for_FLDOB");
				Employee_outcome.add("the_employee_p2_CUM_ACH_for_FLDOB");
				Employee_outcome.add("the_employee_p2_percent_ACH_for_FLDOB");
				Employee_outcome.add("the_employee_p2_percent_CUM_for_FLDOB");

				Employee_outcome.add("the_employee_p2_TGT_for_FLVOB");
				Employee_outcome.add("the_employee_p2_ACH_for_FLVOB");

				Employee_outcome.add("the_employee_p2_Previous_CUM_TGT_for_FLVOB");
				Employee_outcome.add("the_employee_p2_CUM_TGT_for_FLVOB");
				Employee_outcome.add("the_employee_p2_Previous_CUM_ACH_for_FLVOB");
				Employee_outcome.add("the_employee_p2_CUM_ACH_for_FLVOB");
				Employee_outcome.add("the_employee_p2_percent_ACH_for_FLVOB");
				Employee_outcome.add("the_employee_p2_percent_CUM_for_FLVOB");

				Employee_outcome.add("the_employee_p2_TGT_for_IOT");
				Employee_outcome.add("the_employee_p2_ACH_for_IOT");

				Employee_outcome.add("the_employee_p2_Previous_CUM_TGT_for_IOT");
				Employee_outcome.add("the_employee_p2_CUM_TGT_for_IOT");
				Employee_outcome.add("the_employee_p2_Previous_CUM_ACH_for_IOT");
				Employee_outcome.add("the_employee_p2_CUM_ACH_for_IOT");
				Employee_outcome.add("the_employee_p2_percent_ACH_for_IOT");
				Employee_outcome.add("the_employee_p2_percent_CUM_for_IOT");

				Employee_outcome.add("the_employee_p2_TGT_for_CloudOB");
				Employee_outcome.add("the_employee_p2_ACH_for_CloudOB");

				Employee_outcome.add("the_employee_p2_Previous_CUM_TGT_for_CloudOB");
				Employee_outcome.add("the_employee_p2_CUM_TGT_for_CloudOB");
				Employee_outcome.add("the_employee_p2_Previous_CUM_ACH_for_CloudOB");
				Employee_outcome.add("the_employee_p2_CUM_ACH_for_CloudOB");
				Employee_outcome.add("the_employee_p2_percent_ACH_for_CloudOB");
				Employee_outcome.add("the_employee_p2_percent_CUM_for_CloudOB");

				Employee_outcome.add("the_employee_total_of_p2_percent_ACH");
				Employee_outcome.add("the_employee_total_of_p2_percent_CUM");
				Employee_outcome.add("the_employee_total_of_p2_payout_slab_MTD");
				Employee_outcome.add("the_employee_total_of_p2_payout_slab_YTD");
				Employee_outcome.add("the_employee_total_of_p2_weightage");

				Employee_outcome.add("the_employee_p3_TGT_for_segment1");
				Employee_outcome.add("the_employee_p3_ACH_for_segment1");

				Employee_outcome.add("the_employee_p3_Previous_CUM_TGT_for_segment1");
				Employee_outcome.add("the_employee_p3_CUM_TGT_for_segment1");
				Employee_outcome.add("the_employee_p3_Previous_CUM_ACH_for_segment1");
				Employee_outcome.add("the_employee_p3_CUM_ACH_for_segment1");
				Employee_outcome.add("the_employee_p3_percent_ACH_for_segment1");
				Employee_outcome.add("the_employee_p3_percent_CUM_for_segment1");

				Employee_outcome.add("the_employee_p3_TGT_for_segment2");
				Employee_outcome.add("the_employee_p3_ACH_for_segment2");

				Employee_outcome.add("the_employee_p3_Previous_CUM_TGT_for_segment2");
				Employee_outcome.add("the_employee_p3_CUM_TGT_for_segment2");
				Employee_outcome.add("the_employee_p3_Previous_CUM_ACH_for_segment2");
				Employee_outcome.add("the_employee_p3_CUM_ACH_for_segment2");
				Employee_outcome.add("the_employee_p3_percent_ACH_for_segment2");
				Employee_outcome.add("the_employee_p3_percent_CUM_for_segment2");

				Employee_outcome.add("the_employee_total_of_p3_percent_ACH");
				Employee_outcome.add("the_employee_total_of_p3_percent_CUM");
				Employee_outcome.add("the_employee_total_of_p3_payout_slab_MTD");
				Employee_outcome.add("the_employee_total_of_p3_payout_slab_YTD");
				Employee_outcome.add("the_employee_total_of_p3_weightage");

				Employee_outcome.add("the_employee_Overall_Achmnt_weighted_Avg");
				Employee_outcome.add("the_employee_final_QTD_payout_for_p1");
				Employee_outcome.add("the_employee_final_YTD_payout_for_p1");
				Employee_outcome.add("the_employee_final_QTD_payout_for_p2");
				Employee_outcome.add("the_employee_final_YTD_payout_for_p2");
				Employee_outcome.add("the_employee_final_QTD_payout_for_p3");
				Employee_outcome.add("the_employee_final_YTD_payout_for_p3");

				Employee_outcome.add("the_employee_total_payout_for_SIP");
				Employee_outcome.add("the_employee_final_payout_with_capping_300_percent");

				SOAPElement entity = outcome.addChildElement("entity", "typ");
				entity.addAttribute(soapFactory.createName("id"), outcome_entity);

				for (String employee_att : Employee_outcome) {
					System.out.println("employee_att outcome att = " + employee_att);

					SOAPElement entityoutcome = entity.addChildElement("attribute-outcome", "typ");
					entityoutcome.addAttribute(soapFactory.createName("id"), employee_att);
					entityoutcome.addAttribute(soapFactory.createName("known-outcome-style"), "value-only");
					entityoutcome.addAttribute(soapFactory.createName("unknown-outcome-style"), "value-only");
				}

			}
		}

		ArrayList<String> employee_instances = new ArrayList<String>();

		ArrayList<String> employee_attributes = new ArrayList<String>();
		ArrayList<String> employee_attributes_type = new ArrayList<String>();
		ArrayList<String> employee_attributes_value = new ArrayList<String>();

		employee_attributes.add("the_employee_range");
		employee_attributes.add("the_employee_circle");
		employee_attributes.add("the_employee_name");
		employee_attributes.add("the_employee_code");
		employee_attributes.add("the_employee_role");
		employee_attributes.add("the_employee_status");
		employee_attributes.add("the_employee_on_target_payout");

		employee_attributes.add("the_employee_P1_Revenue_TGT");
		employee_attributes.add("the_employee_P1_Revenue_ACH");

		employee_attributes.add("the_employee_P1_Revenue_Previous_CUM_TGT");
		employee_attributes.add("the_employee_P1_Revenue_Previous_CUM_ACH");

		employee_attributes.add("the_employee_p2_TGT_for_MobilityOB");
		employee_attributes.add("the_employee_p2_ACH_for_MobilityOB");

		employee_attributes.add("the_employee_p2_Previous_CUM_TGT_for_MobilityOB");
		employee_attributes.add("the_employee_p2_Previous_CUM_ACH_for_MobilityOB");

		employee_attributes.add("the_employee_p2_TGT_for_FLDOB");
		employee_attributes.add("the_employee_p2_ACH_for_FLDOB");

		employee_attributes.add("the_employee_p2_Previous_CUM_TGT_for_FLDOB");
		employee_attributes.add("the_employee_p2_Previous_CUM_ACH_for_FLDOB");

		employee_attributes.add("the_employee_p2_TGT_for_FLVOB");
		employee_attributes.add("the_employee_p2_ACH_for_FLVOB");

		employee_attributes.add("the_employee_p2_Previous_CUM_TGT_for_FLVOB");
		employee_attributes.add("the_employee_p2_Previous_CUM_ACH_for_FLVOB");

		employee_attributes.add("the_employee_p2_TGT_for_IOT");
		employee_attributes.add("the_employee_p2_ACH_for_IOT");

		employee_attributes.add("the_employee_p2_Previous_CUM_TGT_for_IOT");
		employee_attributes.add("the_employee_p2_Previous_CUM_ACH_for_IOT");

		employee_attributes.add("the_employee_p2_TGT_for_CloudOB");
		employee_attributes.add("the_employee_p2_ACH_for_CloudOB");

		employee_attributes.add("the_employee_p2_Previous_CUM_TGT_for_CloudOB");
		employee_attributes.add("the_employee_p2_Previous_CUM_ACH_for_CloudOB");

		employee_attributes.add("the_employee_p3_TGT_for_segment1");
		employee_attributes.add("the_employee_p3_ACH_for_segment1");

		employee_attributes.add("the_employee_p3_Previous_CUM_TGT_for_segment1");
		employee_attributes.add("the_employee_p3_Previous_CUM_ACH_for_segment1");

		employee_attributes.add("the_employee_p3_TGT_for_segment2");
		employee_attributes.add("the_employee_p3_ACH_for_segment2");

		employee_attributes.add("the_employee_p3_Previous_CUM_TGT_for_segment2");
		employee_attributes.add("the_employee_p3_Previous_CUM_ACH_for_segment2");

		employee_attributes_type.add("text-val");
		employee_attributes_type.add("text-val");
		employee_attributes_type.add("text-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("text-val");
		employee_attributes_type.add("text-val");
		employee_attributes_type.add("number-val");

		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");

		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");

		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");

		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");

		int employeeid = 0;

		SOAPElement globalinstance = soapBodyElem.addChildElement("global-instance", "typ");

		SOAPElement globalattribute = globalinstance.addChildElement("attribute", "typ");
		globalattribute.addAttribute(soapFactory.createName("id"), "the_month_name");
		SOAPElement globalattributeattributeDataType = globalattribute.addChildElement("text-val", "typ");
		globalattributeattributeDataType.addTextNode(month);

		System.out.println("global_attributes = " + "MONTH");

		SOAPElement employee_entity = globalinstance.addChildElement("entity", "typ");
		employee_entity.addAttribute(soapFactory.createName("id"), "the_employee");

		System.out.println("Employee_entity");

		employee_instances.clear();

		for (Vodafone_Rewards rewards : rewards_list) {
			employeeid++;
			rewards.setRw_id(employeeid);
			employee_instances.add(Integer.toString(rewards.getRw_id()));

		}

		for (int k = 0; k < employee_instances.size(); k++) {

			SOAPElement employee_entity_instance = employee_entity.addChildElement("instance", "typ");
			employee_entity_instance.addAttribute(soapFactory.createName("id"), employee_instances.get(k));

			System.out.println("employee_instances = " + employee_instances.get(k));

			employee_attributes_value.clear();

			Vodafone_Rewards rewards = rewards_list.get(k);

			employee_attributes_value.add(rewards.getRange());
			employee_attributes_value.add(rewards.getCircle());
			employee_attributes_value.add(rewards.getEmp_name());
			employee_attributes_value.add(Integer.toString(rewards.getEmp_code()));
			employee_attributes_value.add(rewards.getRole());
			employee_attributes_value.add(rewards.getEmp_status());
			employee_attributes_value.add(Integer.toString(rewards.getTarget_payout()));

			employee_attributes_value.add(Integer.toString(rewards.getP1_monthly_tgt()));
			employee_attributes_value.add(Integer.toString(rewards.getP1_monthly_ach()));
			employee_attributes_value.add(Float.toString(rewards.getP1_cum_tgt()));
			employee_attributes_value.add(Float.toString(rewards.getP1_cum_ach()));

			employee_attributes_value.add(Integer.toString(rewards.getP2_mb_monthly_tgt()));
			employee_attributes_value.add(Integer.toString(rewards.getP2_mb_monthly_ach()));
			employee_attributes_value.add(Float.toString(rewards.getP2_mb_cum_tgt()));
			employee_attributes_value.add(Float.toString(rewards.getP2_mb_cum_ach()));

			employee_attributes_value.add(Integer.toString(rewards.getP2_fld_monthly_tgt()));
			employee_attributes_value.add(Integer.toString(rewards.getP2_fld_monthly_ach()));
			employee_attributes_value.add(Float.toString(rewards.getP2_fld_cum_tgt()));
			employee_attributes_value.add(Float.toString(rewards.getP2_fld_cum_ach()));

			employee_attributes_value.add(Integer.toString(rewards.getP2_flv_monthly_tgt()));
			employee_attributes_value.add(Integer.toString(rewards.getP2_flv_monthly_ach()));
			employee_attributes_value.add(Float.toString(rewards.getP2_flv_cum_tgt()));
			employee_attributes_value.add(Float.toString(rewards.getP2_flv_cum_ach()));

			employee_attributes_value.add(Integer.toString(rewards.getP2_iot_monthly_tgt()));
			employee_attributes_value.add(Integer.toString(rewards.getP2_iot_monthly_ach()));
			employee_attributes_value.add(Float.toString(rewards.getP2_iot_cum_tgt()));
			employee_attributes_value.add(Float.toString(rewards.getP2_iot_cum_ach()));

			employee_attributes_value.add(Integer.toString(rewards.getP2_cloud_monthly_tgt()));
			employee_attributes_value.add(Integer.toString(rewards.getP2_cloud_monthly_ach()));
			employee_attributes_value.add(Float.toString(rewards.getP2_cloud_cum_tgt()));
			employee_attributes_value.add(Float.toString(rewards.getP2_cloud_cum_ach()));

			employee_attributes_value.add(Integer.toString(rewards.getP3_seg1_monthly_tgt()));
			employee_attributes_value.add(Integer.toString(rewards.getP3_seg1_monthly_ach()));
			employee_attributes_value.add(Float.toString(rewards.getP3_seg1_cum_tgt()));
			employee_attributes_value.add(Float.toString(rewards.getP3_seg1_cum_ach()));

			employee_attributes_value.add(Integer.toString(rewards.getP3_seg2_monthly_tgt()));
			employee_attributes_value.add(Integer.toString(rewards.getP3_seg2_monthly_ach()));
			employee_attributes_value.add(Float.toString(rewards.getP3_seg2_cum_tgt()));
			employee_attributes_value.add(Float.toString(rewards.getP3_seg2_cum_ach()));

			for (int i = 0; i < employee_attributes.size(); i++) {

				SOAPElement attribute = employee_entity_instance.addChildElement("attribute", "typ");
				attribute.addAttribute(soapFactory.createName("id"), employee_attributes.get(i));
				SOAPElement attributeDataType = attribute.addChildElement(employee_attributes_type.get(i), "typ");
				attributeDataType.addTextNode(employee_attributes_value.get(i));

				System.out.println("employee_attributes = " + employee_attributes.get(i));

			}
		}

		final String SOAPAction = "http://oracle.com/determinations/server/12.2.1/rulebase/types/Assess";

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", SOAPAction);

		soapMessage.saveChanges();

		/* Print the request message */
		System.out.print("Request SOAP Message = ");
		soapMessage.writeTo(System.out);
		System.out.println();

		return soapMessage;

	}

	private void printvodafone_schSOAPResponse(SOAPMessage soapRequest, SOAPMessage soapResponse,
			List<Vodafone_Rewards> rewards_list, HttpServletRequest request) throws SOAPException, TransformerException,
			ParserConfigurationException, SAXException, IOException, XPathExpressionException, ParseException {
		// TODO Auto-generated method stub

		TransformerFactory transformerFactoryReq = TransformerFactory.newInstance();
		Transformer transformerReq = transformerFactoryReq.newTransformer();
		Source sourceContentReq = soapRequest.getSOAPPart().getContent();

		System.out.print("\nRequest SOAP Message = ");
		StreamResult resultReq = new StreamResult(System.out);
		transformerReq.transform(sourceContentReq, resultReq);

		String reqxmlpath = request.getServletContext().getRealPath("/WEB-INF/classes/com/report");

		System.out.println("\nxmlpath = " + reqxmlpath);

		StreamResult resultReq3 = new StreamResult(new FileOutputStream(new File(reqxmlpath + "\\soaprequest.xml")));
		transformerReq.transform(sourceContentReq, resultReq3);

		ByteArrayOutputStream osReq = new ByteArrayOutputStream();

		StreamResult resultReq2 = new StreamResult(osReq);
		transformerReq.transform(sourceContentReq, resultReq2);

		String xmlReq = new String(osReq.toByteArray(), "UTF-8");

		System.out.println("\n");
		System.out.println(xmlReq);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();

		System.out.print("\nResponse SOAP Message = ");
		StreamResult result = new StreamResult(System.out);
		transformer.transform(sourceContent, result);

		StreamResult result3 = new StreamResult(new FileOutputStream(new File(reqxmlpath + "\\soapresponse.xml")));
		transformer.transform(sourceContent, result3);

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		StreamResult result2 = new StreamResult(os);
		transformer.transform(sourceContent, result2);

		String xml = new String(os.toByteArray(), "UTF-8");

		System.out.println("\n");
		System.out.println(xml);

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		Document xmlDocument = builder.parse(new ByteArrayInputStream(xml.getBytes()));

		XPath xPath = XPathFactory.newInstance().newXPath();

		ArrayList<String> outcome_entity_type = new ArrayList<String>();

		outcome_entity_type.add("the_employee");

		ArrayList<String> Employee_outcome = new ArrayList<String>();
		ArrayList<String> Employee_outcome_value = new ArrayList<String>();

		for (String outcome_entity : outcome_entity_type) {
			if (outcome_entity.equals("the_employee")) {

				Employee_outcome.add("the_employee_range");
				Employee_outcome.add("the_employee_circle");
				Employee_outcome.add("the_employee_name");
				Employee_outcome.add("the_employee_code");
				Employee_outcome.add("the_employee_role");
				Employee_outcome.add("the_employee_status");
				Employee_outcome.add("the_employee_on_target_payout");

				Employee_outcome.add("the_employee_P1_Revenue_TGT");
				Employee_outcome.add("the_employee_P1_Revenue_ACH");

				Employee_outcome.add("the_employee_P1_Revenue_Previous_CUM_TGT");
				Employee_outcome.add("the_employee_P1_Revenue_CUM_TGT");
				Employee_outcome.add("the_employee_P1_Revenue_Previous_CUM_ACH");
				Employee_outcome.add("the_employee_P1_Revenue_CUM_ACH");
				Employee_outcome.add("the_employee_P1_Revenue_percent_ACH");
				Employee_outcome.add("the_employee_P1_Revenue_percent_CUM");
				Employee_outcome.add("the_employee_p1_Revenue_payout_slab_MTD");
				Employee_outcome.add("the_employee_P1_Revenue_payout_slab_YTD");
				Employee_outcome.add("the_employee_P1_Revenue_weightage");

				Employee_outcome.add("the_employee_p2_TGT_for_MobilityOB");
				Employee_outcome.add("the_employee_p2_ACH_for_MobilityOB");

				Employee_outcome.add("the_employee_p2_Previous_CUM_TGT_for_MobilityOB");
				Employee_outcome.add("the_employee_p2_CUM_TGT_for_MobilityOB");
				Employee_outcome.add("the_employee_p2_Previous_CUM_ACH_for_MobilityOB");
				Employee_outcome.add("the_employee_p2_CUM_ACH_for_MobilityOB");
				Employee_outcome.add("the_employee_p2_percent_ACH_for_MobilityOB");
				Employee_outcome.add("the_employee_p2_percent_CUM_for_MobilityOB");

				Employee_outcome.add("the_employee_p2_TGT_for_FLDOB");
				Employee_outcome.add("the_employee_p2_ACH_for_FLDOB");

				Employee_outcome.add("the_employee_p2_Previous_CUM_TGT_for_FLDOB");
				Employee_outcome.add("the_employee_p2_CUM_TGT_for_FLDOB");
				Employee_outcome.add("the_employee_p2_Previous_CUM_ACH_for_FLDOB");
				Employee_outcome.add("the_employee_p2_CUM_ACH_for_FLDOB");
				Employee_outcome.add("the_employee_p2_percent_ACH_for_FLDOB");
				Employee_outcome.add("the_employee_p2_percent_CUM_for_FLDOB");

				Employee_outcome.add("the_employee_p2_TGT_for_FLVOB");
				Employee_outcome.add("the_employee_p2_ACH_for_FLVOB");

				Employee_outcome.add("the_employee_p2_Previous_CUM_TGT_for_FLVOB");
				Employee_outcome.add("the_employee_p2_CUM_TGT_for_FLVOB");
				Employee_outcome.add("the_employee_p2_Previous_CUM_ACH_for_FLVOB");
				Employee_outcome.add("the_employee_p2_CUM_ACH_for_FLVOB");
				Employee_outcome.add("the_employee_p2_percent_ACH_for_FLVOB");
				Employee_outcome.add("the_employee_p2_percent_CUM_for_FLVOB");

				Employee_outcome.add("the_employee_p2_TGT_for_IOT");
				Employee_outcome.add("the_employee_p2_ACH_for_IOT");

				Employee_outcome.add("the_employee_p2_Previous_CUM_TGT_for_IOT");
				Employee_outcome.add("the_employee_p2_CUM_TGT_for_IOT");
				Employee_outcome.add("the_employee_p2_Previous_CUM_ACH_for_IOT");
				Employee_outcome.add("the_employee_p2_CUM_ACH_for_IOT");
				Employee_outcome.add("the_employee_p2_percent_ACH_for_IOT");
				Employee_outcome.add("the_employee_p2_percent_CUM_for_IOT");

				Employee_outcome.add("the_employee_p2_TGT_for_CloudOB");
				Employee_outcome.add("the_employee_p2_ACH_for_CloudOB");

				Employee_outcome.add("the_employee_p2_Previous_CUM_TGT_for_CloudOB");
				Employee_outcome.add("the_employee_p2_CUM_TGT_for_CloudOB");
				Employee_outcome.add("the_employee_p2_Previous_CUM_ACH_for_CloudOB");
				Employee_outcome.add("the_employee_p2_CUM_ACH_for_CloudOB");
				Employee_outcome.add("the_employee_p2_percent_ACH_for_CloudOB");
				Employee_outcome.add("the_employee_p2_percent_CUM_for_CloudOB");

				Employee_outcome.add("the_employee_total_of_p2_percent_ACH");
				Employee_outcome.add("the_employee_total_of_p2_percent_CUM");
				Employee_outcome.add("the_employee_total_of_p2_payout_slab_MTD");
				Employee_outcome.add("the_employee_total_of_p2_payout_slab_YTD");
				Employee_outcome.add("the_employee_total_of_p2_weightage");

				Employee_outcome.add("the_employee_p3_TGT_for_segment1");
				Employee_outcome.add("the_employee_p3_ACH_for_segment1");

				Employee_outcome.add("the_employee_p3_Previous_CUM_TGT_for_segment1");
				Employee_outcome.add("the_employee_p3_CUM_TGT_for_segment1");
				Employee_outcome.add("the_employee_p3_Previous_CUM_ACH_for_segment1");
				Employee_outcome.add("the_employee_p3_CUM_ACH_for_segment1");
				Employee_outcome.add("the_employee_p3_percent_ACH_for_segment1");
				Employee_outcome.add("the_employee_p3_percent_CUM_for_segment1");

				Employee_outcome.add("the_employee_p3_TGT_for_segment2");
				Employee_outcome.add("the_employee_p3_ACH_for_segment2");

				Employee_outcome.add("the_employee_p3_Previous_CUM_TGT_for_segment2");
				Employee_outcome.add("the_employee_p3_CUM_TGT_for_segment2");
				Employee_outcome.add("the_employee_p3_Previous_CUM_ACH_for_segment2");
				Employee_outcome.add("the_employee_p3_CUM_ACH_for_segment2");
				Employee_outcome.add("the_employee_p3_percent_ACH_for_segment2");
				Employee_outcome.add("the_employee_p3_percent_CUM_for_segment2");

				Employee_outcome.add("the_employee_total_of_p3_percent_ACH");
				Employee_outcome.add("the_employee_total_of_p3_percent_CUM");
				Employee_outcome.add("the_employee_total_of_p3_payout_slab_MTD");
				Employee_outcome.add("the_employee_total_of_p3_payout_slab_YTD");
				Employee_outcome.add("the_employee_total_of_p3_weightage");

				Employee_outcome.add("the_employee_Overall_Achmnt_weighted_Avg");
				Employee_outcome.add("the_employee_final_QTD_payout_for_p1");
				Employee_outcome.add("the_employee_final_YTD_payout_for_p1");
				Employee_outcome.add("the_employee_final_QTD_payout_for_p2");
				Employee_outcome.add("the_employee_final_YTD_payout_for_p2");
				Employee_outcome.add("the_employee_final_QTD_payout_for_p3");
				Employee_outcome.add("the_employee_final_YTD_payout_for_p3");

				Employee_outcome.add("the_employee_total_payout_for_SIP");
				Employee_outcome.add("the_employee_final_payout_with_capping_300_percent");

			}
		}

		ArrayList<String> employee_instances = new ArrayList<String>();

		employee_instances.clear();

		for (Vodafone_Rewards rewards : rewards_list) {
			employee_instances.add(Integer.toString(rewards.getRw_id()));

		}

		for (int j = 0; j < employee_instances.size(); j++) {

			Employee_outcome_value.clear();

			Vodafone_Rewards rewards = rewards_list.get(j);

			for (String employee_att : Employee_outcome) {
				System.out.println("employee instances : " + employee_instances.get(j));
				String xmlpath = "/Envelope/Body/assess-response/global-instance/entity/instance[@id='"
						+ employee_instances.get(j) + "']/attribute";
				String expression = xmlpath + "[@id='" + employee_att + "']";
				System.out.println(expression);

				String employee_value = xPath.compile(expression).evaluate(xmlDocument);
				Employee_outcome_value.add(employee_value);

				System.out.println(employee_att + " = " + employee_value);

				// p1
				if (employee_att.equals("the_employee_P1_Revenue_CUM_TGT")) {
					rewards.setP1_cum_tgt(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_P1_Revenue_CUM_ACH")) {
					rewards.setP1_cum_ach(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_P1_Revenue_percent_CUM")) {
					rewards.setP1_cum_ach_per(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_P1_Revenue_percent_ACH")) {
					rewards.setP1_monthly_ach_per(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p1_Revenue_payout_slab_MTD")) {
					rewards.setP1_mtd(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_P1_Revenue_payout_slab_YTD")) {
					rewards.setP1_ytd(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_P1_Revenue_weightage")) {
					rewards.setP1_weightage(new BigDecimal(employee_value).floatValue());

				}

				// p2 mobility
				else if (employee_att.equals("the_employee_p2_CUM_TGT_for_MobilityOB")) {
					rewards.setP2_mb_cum_tgt(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_CUM_ACH_for_MobilityOB")) {
					rewards.setP2_mb_cum_ach(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_percent_ACH_for_MobilityOB")) {
					rewards.setP2_mb_monthly_ach_per(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_percent_CUM_for_MobilityOB")) {
					rewards.setP2_mb_cum_ach_per(new BigDecimal(employee_value).floatValue());

				}

				// p2 fld
				else if (employee_att.equals("the_employee_p2_CUM_TGT_for_FLDOB")) {
					rewards.setP2_fld_cum_tgt(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_CUM_ACH_for_FLDOB")) {
					rewards.setP2_fld_cum_ach(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_percent_ACH_for_FLDOB")) {
					rewards.setP2_fld_monthly_ach_per(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_percent_CUM_for_FLDOB")) {
					rewards.setP2_fld_cum_ach_per(new BigDecimal(employee_value).floatValue());

				}

				// p2 flv
				else if (employee_att.equals("the_employee_p2_CUM_TGT_for_FLVOB")) {
					rewards.setP2_flv_cum_tgt(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_CUM_ACH_for_FLVOB")) {
					rewards.setP2_flv_cum_ach(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_percent_ACH_for_FLVOB")) {
					rewards.setP2_flv_monthly_ach_per(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_percent_CUM_for_FLVOB")) {
					rewards.setP2_flv_cum_ach_per(new BigDecimal(employee_value).floatValue());

				}

				// p2 iot
				else if (employee_att.equals("the_employee_p2_CUM_TGT_for_IOT")) {
					rewards.setP2_iot_cum_tgt(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_CUM_ACH_for_IOT")) {
					rewards.setP2_iot_cum_ach(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_percent_ACH_for_IOT")) {
					rewards.setP2_iot_monthly_ach_per(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_percent_CUM_for_IOT")) {
					rewards.setP2_iot_cum_ach_per(new BigDecimal(employee_value).floatValue());

				}

				// p2 iot
				else if (employee_att.equals("the_employee_p2_CUM_TGT_for_CloudOB")) {
					rewards.setP2_cloud_cum_tgt(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_CUM_ACH_for_CloudOB")) {
					rewards.setP2_cloud_cum_ach(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_percent_ACH_for_CloudOB")) {
					rewards.setP2_cloud_monthly_ach_per(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p2_percent_CUM_for_CloudOB")) {
					rewards.setP2_cloud_cum_ach_per(new BigDecimal(employee_value).floatValue());

				}

				else if (employee_att.equals("the_employee_total_of_p2_percent_ACH")) {
					rewards.setP2_monthly_ach(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_total_of_p2_percent_CUM")) {
					rewards.setP2_cum_ach(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_total_of_p2_payout_slab_MTD")) {
					rewards.setP2_mtd(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_total_of_p2_payout_slab_YTD")) {
					rewards.setP2_ytd(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_total_of_p2_weightage")) {
					rewards.setP2_weightage(new BigDecimal(employee_value).floatValue());

				}

				// p3 seg1
				else if (employee_att.equals("the_employee_p3_CUM_TGT_for_segment1")) {
					rewards.setP3_seg1_cum_tgt(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p3_CUM_ACH_for_segment1")) {
					rewards.setP3_seg1_cum_ach(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p3_percent_ACH_for_segment1")) {
					rewards.setP3_seg1_monthly_ach_per(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p3_percent_CUM_for_segment1")) {
					rewards.setP3_seg1_cum_ach_per(new BigDecimal(employee_value).floatValue());

				}

				// p3 seg2
				else if (employee_att.equals("the_employee_p3_CUM_TGT_for_segment2")) {
					rewards.setP3_seg2_cum_tgt(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p3_CUM_ACH_for_segment2")) {
					rewards.setP3_seg2_cum_ach(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p3_percent_ACH_for_segment2")) {
					rewards.setP3_seg2_monthly_ach_per(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_p3_percent_CUM_for_segment2")) {
					rewards.setP3_seg2_cum_ach_per(new BigDecimal(employee_value).floatValue());

				}

				else if (employee_att.equals("the_employee_total_of_p3_percent_ACH")) {
					rewards.setP3_monthly_ach(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_total_of_p3_percent_CUM")) {
					rewards.setP3_monthly_ach(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_total_of_p3_payout_slab_MTD")) {
					rewards.setP3_mtd(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_total_of_p3_payout_slab_YTD")) {
					rewards.setP3_ytd(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_total_of_p3_weightage")) {
					rewards.setP3_weightage(new BigDecimal(employee_value).floatValue());

				}

				// final
				else if (employee_att.equals("the_employee_Overall_Achmnt_weighted_Avg")) {
					rewards.setOverall_ach(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("the_employee_final_QTD_payout_for_p1")) {
					rewards.setP1_qtd_payout(new BigDecimal(employee_value).intValue());

				} else if (employee_att.equals("the_employee_final_YTD_payout_for_p1")) {
					rewards.setP1_ytd_payout(new BigDecimal(employee_value).intValue());

				} else if (employee_att.equals("the_employee_final_QTD_payout_for_p2")) {
					rewards.setP2_qtd_payout(new BigDecimal(employee_value).intValue());

				} else if (employee_att.equals("the_employee_final_YTD_payout_for_p2")) {
					rewards.setP2_ytd_payout(new BigDecimal(employee_value).intValue());

				} else if (employee_att.equals("the_employee_final_QTD_payout_for_p3")) {
					rewards.setP3_qtd_payout(new BigDecimal(employee_value).intValue());

				} else if (employee_att.equals("the_employee_final_YTD_payout_for_p3")) {
					rewards.setP3_ytd_payout(new BigDecimal(employee_value).intValue());

				} else if (employee_att.equals("the_employee_total_payout_for_SIP")) {
					rewards.setTotal_payout_sip(new BigDecimal(employee_value).intValue());

				} else if (employee_att.equals("the_employee_final_payout_with_capping_300_percent")) {
					rewards.setFinal_payout_amt(new BigDecimal(employee_value).intValue());

				}
			}

		}

	}

	@RequestMapping(value = "/showSalesSchAnReportSoap")
	public ModelAndView showSalesSchAnReportSoap(HttpServletRequest request, Model model, HttpServletResponse response,
			@RequestParam(value = "scheme_name") String scheme_name) {

		String schopawebserviceUrl = "https://iflictest1.custhelp.com/determinations-server/assess/soap/generic/12.2.1/Incentive__Scheme?wsdl";
		System.out.println("in Geojit scheme");

		Sales_Incentive final_incentives = new Sales_Incentive();

		String sql_sales_rewards = "select * from SALES_INCENTIVE";

		List<Sales_Incentive> rewards_list = jdbcTemplate.query(sql_sales_rewards, new RowMapper<Sales_Incentive>() {

			@Override
			public Sales_Incentive mapRow(ResultSet rs, int rowNum) throws SQLException {
				Sales_Incentive sales = new Sales_Incentive();

				sales.setEmp_name(rs.getString("EMP_NAME"));
				sales.setId(rs.getInt("ID"));
				sales.setActual_basic_pay(rs.getInt("ACTUAL_BASIC_PAY"));
				sales.setProcessed_basic_average_pay(rs.getInt("PROCESSED_AVERAGE_BASIC_PAY"));
				sales.setDepartment(rs.getString("DEPARTMENT"));
				sales.setDesignation(rs.getString("DESIGNATION"));
				sales.setBrokrage_days(rs.getInt("BROKRAGE_DAYS"));

				return sales;
			}

		});

		Date Sd = new Date();
		System.out.println("Start call to webservice" + Sd);

		call_sales_schopasoap_webservice(rewards_list, final_incentives, schopawebserviceUrl, request);

		Date Ed = new Date();
		System.out.println("End call to webservice" + Ed);

		System.out.println("Total time : Sw " + Sd + " Ew " + Ed);

		model.addAttribute("Info_grid", rewards_list);
		model.addAttribute("Final_Incentives", final_incentives);

		HttpSession session = request.getSession();
		session.setAttribute("rewards", rewards_list);
		session.setAttribute("Final_Incentives", final_incentives);

		return new ModelAndView("SalesSchemeAnalysis");
	}

//	public List<Sales> 
	public void call_sales_schopasoap_webservice(List<Sales_Incentive> rewards_list, Sales_Incentive final_incentives,
			String schopawebserviceUrl, HttpServletRequest request) {
		// TODO Auto-generated method stub

		// Create SOAP Connection

		try {
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();

			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			// Send SOAP Message to SOAP Server
			// final String url =
			// "https://omfys-opa.custhelp.com/determinations-server/assess/soap/generic/12.2.1/BPIL__Seal__O__Prime__November__Dhamaka__Offer?wsdl";
			final String url = schopawebserviceUrl;
			SOAPMessage soapRequest = createsales_schSOAPRequest(rewards_list, final_incentives);

			TransformerFactory transformerFactoryReq = TransformerFactory.newInstance();
			Transformer transformerReq = transformerFactoryReq.newTransformer();
			Source sourceContentReq = soapRequest.getSOAPPart().getContent();

			String reqxmlpath = request.getServletContext().getRealPath("/WEB-INF/classes/com/report");

			System.out.println("xmlpath = " + reqxmlpath);

			StreamResult resultReq = new StreamResult(new FileOutputStream(new File(reqxmlpath + "\\soaprequest.xml")));
			transformerReq.transform(sourceContentReq, resultReq);

			SOAPMessage soapResponse = soapConnection.call(soapRequest, url);

			TransformerFactory transformerFactoryResp = TransformerFactory.newInstance();
			Transformer transformerResp = transformerFactoryResp.newTransformer();
			Source sourceContentResp = soapResponse.getSOAPPart().getContent();

			StreamResult resultResp = new StreamResult(
					new FileOutputStream(new File(reqxmlpath + "\\soapresponse.xml")));
			transformerResp.transform(sourceContentResp, resultResp);

			// Process the SOAP Response
//			 maxlife_Adms = 
			printsales_schSOAPResponse(soapRequest, soapResponse, rewards_list, final_incentives, request);

			soapConnection.close();

		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		return maxlife_Adms;

	}

	private SOAPMessage createsales_schSOAPRequest(List<Sales_Incentive> rewards_list, Sales_Incentive final_incentives)
			throws SOAPException, IOException {
		// TODO Auto-generated method stub

		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		final String serverURI = "http://oracle.com/determinations/server/12.2.1/rulebase/assess/types";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("typ", serverURI);

		SOAPFactory soapFactory = SOAPFactory.newInstance();

		System.out.println("SOAP Envelope");

		// SOAP Header
		SOAPHeader soapHeader = envelope.getHeader();

		final String seqHeader = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
		Name headerName = soapFactory.createName("Security", "o", seqHeader);

		SOAPHeaderElement headerElement = soapHeader.addHeaderElement(headerName);
		headerElement.setMustUnderstand(true);

		final String Username = "apiuser";
		final String Password = "ApiUser@123";

		SOAPElement soapUserToken = headerElement.addChildElement("UsernameToken", "o");
		SOAPElement sopaUser = soapUserToken.addChildElement("Username", "o");
		sopaUser.addTextNode(Username);
		SOAPElement sopaPass = soapUserToken.addChildElement("Password", "o");
		sopaPass.addTextNode(Password);

		SOAPHeader header = soapMessage.getSOAPHeader();
		SOAPBody body = soapMessage.getSOAPBody();

		System.out.println("SOAP Header");

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();

		SOAPElement soapBodyElem = soapBody.addChildElement("assess-request", "typ");

		System.out.println("SOAP Body");

		SOAPElement config = soapBodyElem.addChildElement("config", "typ");

		SOAPElement outcome = config.addChildElement("outcome", "typ");

		ArrayList<String> outcome_entity_type = new ArrayList<String>();

		outcome_entity_type.add("global");
		outcome_entity_type.add("the_employee");

		ArrayList<String> global_outcome = new ArrayList<String>();
		ArrayList<String> Employee_outcome = new ArrayList<String>();

		for (String outcome_entity : outcome_entity_type) {

			if (outcome_entity.equals("global")) {
				global_outcome.add("MF_no");
				global_outcome.add("MF_rate");
				global_outcome.add("PMS_no");
				global_outcome.add("PMS_rate");
				global_outcome.add("BTL_initiatives_no");
				global_outcome.add("BTL_initiatives_rate");
				global_outcome.add("account_opened_via_LMS_no");
				global_outcome.add("account_opened_via_LMS_rate");

				global_outcome.add("total_incentive_kitty_amount");
				global_outcome.add("incentive_for_lead_conversion");
				global_outcome.add("performance_incentive");
				global_outcome.add("the_Final_Additional_Incentive");

				SOAPElement entity = outcome.addChildElement("entity", "typ");
				entity.addAttribute(soapFactory.createName("id"), outcome_entity);

				for (String global_att : global_outcome) {
					SOAPElement entityoutcome = entity.addChildElement("attribute-outcome", "typ");
					entityoutcome.addAttribute(soapFactory.createName("id"), global_att);
					entityoutcome.addAttribute(soapFactory.createName("known-outcome-style"), "value-only");
					entityoutcome.addAttribute(soapFactory.createName("unknown-outcome-style"), "value-only");
				}

			} else if (outcome_entity.equals("the_employee")) {
				Employee_outcome.add("employee_name");
				Employee_outcome.add("employee_ID");
				Employee_outcome.add("employee_actual_basic_pay");
				Employee_outcome.add("first_90_days_brokerage_amount");
				Employee_outcome.add("Employee_processed_average_basic_pay");
				Employee_outcome.add("Employee_designation");

				Employee_outcome.add("additional_incentive");
				Employee_outcome.add("Employee_basic_proportion");
				Employee_outcome.add("Employee_flat_incentive_Monthly");
				Employee_outcome.add("Employee_Quarterly_Performance_rating_by_HOD");
				Employee_outcome.add("Employee_performance_proportion");
				Employee_outcome.add("Employee_performance_incentive_Quarterly");
				Employee_outcome.add("Employee_additional_incentive_for_quality_conversion_Quarterly");
				Employee_outcome.add("Employee_total_payable");

				SOAPElement entity = outcome.addChildElement("entity", "typ");
				entity.addAttribute(soapFactory.createName("id"), outcome_entity);

				for (String employee_att : Employee_outcome) {
					System.out.println("employee_att outcome att = " + employee_att);

					SOAPElement entityoutcome = entity.addChildElement("attribute-outcome", "typ");
					entityoutcome.addAttribute(soapFactory.createName("id"), employee_att);
					entityoutcome.addAttribute(soapFactory.createName("known-outcome-style"), "value-only");
					entityoutcome.addAttribute(soapFactory.createName("unknown-outcome-style"), "value-only");
				}

			}
		}

		ArrayList<String> employee_instances = new ArrayList<String>();

		ArrayList<String> employee_attributes = new ArrayList<String>();
		ArrayList<String> employee_attributes_type = new ArrayList<String>();
		ArrayList<String> employee_attributes_value = new ArrayList<String>();

		employee_attributes.add("employee_name");
		employee_attributes.add("employee_ID");
		employee_attributes.add("employee_actual_basic_pay");
		employee_attributes.add("first_90_days_brokerage_amount");
		employee_attributes.add("Employee_processed_average_basic_pay");
		employee_attributes.add("Employee_designation");

		employee_attributes_type.add("text-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("number-val");
		employee_attributes_type.add("text-val");

		int employeeid = 0;

		SOAPElement globalinstance = soapBodyElem.addChildElement("global-instance", "typ");

		SOAPElement globalattribute = globalinstance.addChildElement("attribute", "typ");
		globalattribute.addAttribute(soapFactory.createName("id"), "MF_no");
		SOAPElement globalattributeattributeDataType = globalattribute.addChildElement("number-val", "typ");
		globalattributeattributeDataType.addTextNode(String.valueOf(0));

		SOAPElement globalattribute1 = globalinstance.addChildElement("attribute", "typ");
		globalattribute1.addAttribute(soapFactory.createName("id"), "MF_rate");
		SOAPElement globalattributeattributeDataType1 = globalattribute1.addChildElement("number-val", "typ");
		globalattributeattributeDataType1.addTextNode(String.valueOf(0));

		SOAPElement globalattribute2 = globalinstance.addChildElement("attribute", "typ");
		globalattribute2.addAttribute(soapFactory.createName("id"), "PMS_no");
		SOAPElement globalattributeattributeDataType2 = globalattribute2.addChildElement("number-val", "typ");
		globalattributeattributeDataType2.addTextNode(String.valueOf(2500000));

		SOAPElement globalattribute3 = globalinstance.addChildElement("attribute", "typ");
		globalattribute3.addAttribute(soapFactory.createName("id"), "PMS_rate");
		SOAPElement globalattributeattributeDataType3 = globalattribute3.addChildElement("number-val", "typ");
		globalattributeattributeDataType3.addTextNode(String.valueOf(0.01));

		SOAPElement globalattribute4 = globalinstance.addChildElement("attribute", "typ");
		globalattribute4.addAttribute(soapFactory.createName("id"), "BTL_initiatives_no");
		SOAPElement globalattributeattributeDataType4 = globalattribute4.addChildElement("number-val", "typ");
		globalattributeattributeDataType4.addTextNode(String.valueOf(378));

		SOAPElement globalattribute5 = globalinstance.addChildElement("attribute", "typ");
		globalattribute5.addAttribute(soapFactory.createName("id"), "BTL_initiatives_rate");
		SOAPElement globalattributeattributeDataType5 = globalattribute5.addChildElement("number-val", "typ");
		globalattributeattributeDataType5.addTextNode(String.valueOf(365));

		SOAPElement globalattribute6 = globalinstance.addChildElement("attribute", "typ");
		globalattribute6.addAttribute(soapFactory.createName("id"), "account_opened_via_LMS_no");
		SOAPElement globalattributeattributeDataType6 = globalattribute6.addChildElement("number-val", "typ");
		globalattributeattributeDataType6.addTextNode(String.valueOf(333));

		SOAPElement globalattribute7 = globalinstance.addChildElement("attribute", "typ");
		globalattribute7.addAttribute(soapFactory.createName("id"), "account_opened_via_LMS_rate");
		SOAPElement globalattributeattributeDataType7 = globalattribute7.addChildElement("number-val", "typ");
		globalattributeattributeDataType7.addTextNode(String.valueOf(300));

		SOAPElement employee_entity = globalinstance.addChildElement("entity", "typ");
		employee_entity.addAttribute(soapFactory.createName("id"), "the_employee");

		System.out.println("Employee_entity");

		employee_instances.clear();

		for (Sales_Incentive rewards : rewards_list) {
			employeeid++;
			rewards.setId(employeeid);
			employee_instances.add(Integer.toString(rewards.getId()));

		}

		for (int k = 0; k < employee_instances.size(); k++) {

			SOAPElement employee_entity_instance = employee_entity.addChildElement("instance", "typ");
			employee_entity_instance.addAttribute(soapFactory.createName("id"), employee_instances.get(k));

			System.out.println("employee_instances = " + employee_instances.get(k));

			employee_attributes_value.clear();

			Sales_Incentive rewards = rewards_list.get(k);

			employee_attributes_value.add(rewards.getEmp_name());
			employee_attributes_value.add(Integer.toString(rewards.getId()));
			employee_attributes_value.add(Integer.toString(rewards.getActual_basic_pay()));
			employee_attributes_value.add(Integer.toString(rewards.getBrokrage_days()));
			employee_attributes_value.add(Integer.toString(rewards.getProcessed_basic_average_pay()));
			employee_attributes_value.add(rewards.getDesignation());

			for (int i = 0; i < employee_attributes.size(); i++) {

				SOAPElement attribute = employee_entity_instance.addChildElement("attribute", "typ");
				attribute.addAttribute(soapFactory.createName("id"), employee_attributes.get(i));
				SOAPElement attributeDataType = attribute.addChildElement(employee_attributes_type.get(i), "typ");
				attributeDataType.addTextNode(employee_attributes_value.get(i));

				System.out.println("employee_attributes = " + employee_attributes.get(i));

			}
		}

		final String SOAPAction = "http://oracle.com/determinations/server/12.2.1/rulebase/types/Assess";

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", SOAPAction);

		soapMessage.saveChanges();

		/* Print the request message */
		System.out.print("Request SOAP Message = ");
		soapMessage.writeTo(System.out);
		System.out.println();

		return soapMessage;

	}

	private void printsales_schSOAPResponse(SOAPMessage soapRequest, SOAPMessage soapResponse,
			List<Sales_Incentive> rewards_list, Sales_Incentive final_incentives, HttpServletRequest request)
			throws SOAPException, TransformerException, ParserConfigurationException, SAXException, IOException,
			XPathExpressionException, ParseException {
		// TODO Auto-generated method stub

		TransformerFactory transformerFactoryReq = TransformerFactory.newInstance();
		Transformer transformerReq = transformerFactoryReq.newTransformer();
		Source sourceContentReq = soapRequest.getSOAPPart().getContent();

		System.out.print("\nRequest SOAP Message = ");
		StreamResult resultReq = new StreamResult(System.out);
		transformerReq.transform(sourceContentReq, resultReq);

		String reqxmlpath = request.getServletContext().getRealPath("/WEB-INF/classes/com/report");

		System.out.println("\nxmlpath = " + reqxmlpath);

		StreamResult resultReq3 = new StreamResult(new FileOutputStream(new File(reqxmlpath + "\\soaprequest.xml")));
		transformerReq.transform(sourceContentReq, resultReq3);

		ByteArrayOutputStream osReq = new ByteArrayOutputStream();

		StreamResult resultReq2 = new StreamResult(osReq);
		transformerReq.transform(sourceContentReq, resultReq2);

		String xmlReq = new String(osReq.toByteArray(), "UTF-8");

		System.out.println("\n");
		System.out.println(xmlReq);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();

		System.out.print("\nResponse SOAP Message = ");
		StreamResult result = new StreamResult(System.out);
		transformer.transform(sourceContent, result);

		StreamResult result3 = new StreamResult(new FileOutputStream(new File(reqxmlpath + "\\soapresponse.xml")));
		transformer.transform(sourceContent, result3);

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		StreamResult result2 = new StreamResult(os);
		transformer.transform(sourceContent, result2);

		String xml = new String(os.toByteArray(), "UTF-8");

		System.out.println("\n");
		System.out.println(xml);

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		Document xmlDocument = builder.parse(new ByteArrayInputStream(xml.getBytes()));

		XPath xPath = XPathFactory.newInstance().newXPath();

		ArrayList<String> outcome_entity_type = new ArrayList<String>();

		outcome_entity_type.add("global");
		outcome_entity_type.add("the_employee");

		ArrayList<String> global_outcome = new ArrayList<String>();
		ArrayList<String> Employee_outcome = new ArrayList<String>();
		ArrayList<String> Employee_outcome_value = new ArrayList<String>();

		for (String outcome_entity : outcome_entity_type) {
			if (outcome_entity.equals("global")) {
				global_outcome.add("total_incentive_kitty_amount");
				global_outcome.add("incentive_for_lead_conversion");
				global_outcome.add("performance_incentive");
				global_outcome.add("the_Final_Additional_Incentive");
			}
			if (outcome_entity.equals("the_employee")) {

				Employee_outcome.add("employee_name");
				Employee_outcome.add("employee_ID");
				Employee_outcome.add("employee_actual_basic_pay");
				Employee_outcome.add("first_90_days_brokerage_amount");
				Employee_outcome.add("Employee_processed_average_basic_pay");
				Employee_outcome.add("Employee_designation");

				Employee_outcome.add("additional_incentive");
				Employee_outcome.add("Employee_basic_proportion");
				Employee_outcome.add("Employee_flat_incentive_Monthly");
				Employee_outcome.add("Employee_Quarterly_Performance_rating_by_HOD");
				Employee_outcome.add("Employee_performance_proportion");
				Employee_outcome.add("Employee_performance_incentive_Quarterly");
				Employee_outcome.add("Employee_additional_incentive_for_quality_conversion_Quarterly");
				Employee_outcome.add("Employee_total_payable");

			}
		}

		for (String global_att : global_outcome) {
			String xmlpath = "/Envelope/Body/assess-response/global-instance/attribute";
			String expression = xmlpath + "[@id='" + global_att + "']";
			// System.out.println(expression);

			String global_value = xPath.compile(expression).evaluate(xmlDocument);
			System.out.println("global_att " + global_att);
			System.out.println("global_value " + global_value);

			if (global_att.equals("total_incentive_kitty_amount")) {
				final_incentives.setTotal_kitty_amount(new BigDecimal(global_value).intValue());
			} else if (global_att.equals("incentive_for_lead_conversion")) {
				final_incentives.setFinal_flat_incentive(new BigDecimal(global_value).intValue());
			} else if (global_att.equals("performance_incentive")) {
				final_incentives.setFinal_performance_incentive(new BigDecimal(global_value).intValue());
			} else if (global_att.equals("the_Final_Additional_Incentive")) {
				final_incentives.setFinal_additional_incentive(new BigDecimal(global_value).intValue());
			}
		}

		ArrayList<String> employee_instances = new ArrayList<String>();

		employee_instances.clear();

		for (Sales_Incentive rewards : rewards_list) {
			employee_instances.add(Integer.toString(rewards.getId()));

		}

		for (int j = 0; j < employee_instances.size(); j++) {

			Employee_outcome_value.clear();

			Sales_Incentive rewards = rewards_list.get(j);

			for (String employee_att : Employee_outcome) {
				System.out.println("employee instances : " + employee_instances.get(j));
				String xmlpath = "/Envelope/Body/assess-response/global-instance/entity/instance[@id='"
						+ employee_instances.get(j) + "']/attribute";
				String expression = xmlpath + "[@id='" + employee_att + "']";
				System.out.println(expression);

				String employee_value = xPath.compile(expression).evaluate(xmlDocument);
				Employee_outcome_value.add(employee_value);

				System.out.println(employee_att + " = " + employee_value);

				if (employee_att.equals("additional_incentive")) {
					rewards.setAdditional_incentive(new BigDecimal(employee_value).intValue());

				} else if (employee_att.equals("Employee_basic_proportion")) {
					rewards.setBasic_proportion(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("Employee_flat_incentive_Monthly")) {
					rewards.setFlat_incentive(new BigDecimal(employee_value).intValue());

				} else if (employee_att.equals("Employee_Quarterly_Performance_rating_by_HOD")) {
					rewards.setQuarterly_performance_rating_by_hod(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("Employee_performance_proportion")) {
					rewards.setPerformance_proportion(new BigDecimal(employee_value).floatValue());

				} else if (employee_att.equals("Employee_performance_incentive_Quarterly")) {
					rewards.setPerformance_incentive(new BigDecimal(employee_value).intValue());

				} else if (employee_att.equals("Employee_additional_incentive_for_quality_conversion_Quarterly")) {
					rewards.setAdditional_incentive(new BigDecimal(employee_value).intValue());

				} else if (employee_att.equals("Employee_total_payable")) {
					rewards.setTotal_payable(new BigDecimal(employee_value).intValue());

				}

			}

		}

	}

}

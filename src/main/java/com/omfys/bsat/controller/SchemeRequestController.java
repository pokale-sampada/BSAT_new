package com.omfys.bsat.controller;

import java.io.IOException;
import java.security.Security;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.omfys.bsat.repository.MenuGroupDao;
import com.omfys.bsat.repository.SchemeMasterDao;
import com.omfys.bsat.repository.SchemeRequestDao;
import com.sun.mail.smtp.SMTPTransport;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.email.NotifyDealer;
import com.omfys.bsat.model.BPIL_MENU;
import com.omfys.bsat.model.Bpil_Bsat_Defaults;
import com.omfys.bsat.model.Bpil_Fin_Year;
import com.omfys.bsat.model.Bpil_Gift_Master;
import com.omfys.bsat.model.Bpil_ReportGroup;
import com.omfys.bsat.model.Bpil_Scheme_Doc;
import com.omfys.bsat.model.Bpil_User_ProfileId_List;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.Bpil_notification;
import com.omfys.bsat.model.Crm_Bpil_Scheme_Doc;
import com.omfys.bsat.model.New_Scheme_mstr;
import com.omfys.bsat.model.New_Scheme_mstr_for_Crm;
import com.omfys.bsat.model.NewsFeeds_Autofill;
import com.omfys.bsat.model.RenewedMailCommunication;


@Controller
public class SchemeRequestController {

	@Autowired
	SchemeRequestDao schemerequestdao;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private MenuGroupDao menudao;

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	SchemeMasterDao schememasterdao;

	@Autowired
	private TilesConfiguration hibernateConfiguration;

	@RequestMapping("/schemerequest")
	//@RequestMapping("/")
	public ModelAndView schemerequest(ModelMap map,Model model,HttpServletRequest request)
	{
		String kwm_user = (String) request.getSession().getAttribute("kwm_user");
		if (kwm_user != null) {						
	
			String username = (String) request.getSession().getAttribute("username");
			int user_id = (Integer) request.getSession().getAttribute("userid");	
			
			   ArrayList<Bpil_Users> getdata = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+user_id);

				  String fname = getdata.get(0).getFirst_name();
				  String lname = getdata.get(0).getLast_name();
				  
			      model.addAttribute("firstname",fname);
			        model.addAttribute("lastname",lname);
			        
			int count=10;
			
			Bpil_Bsat_Defaults defaults = menudao.getDefaults();
			
			model.addAttribute("count", count);
			model.addAttribute("redemption_day", defaults.getRedemption_date());
		}
		return new ModelAndView("SchemeRequest");
	}
	
	@RequestMapping("/ITschemerequest")
	//@RequestMapping("/")
	public ModelAndView ITschemerequest(ModelMap map,Model model,HttpServletRequest request)
	{
		String kwm_user = (String) request.getSession().getAttribute("kwm_user");
		if (kwm_user != null) {						
	
			String username = (String) request.getSession().getAttribute("username");
			int user_id = (Integer) request.getSession().getAttribute("userid");	
			
			   ArrayList<Bpil_Users> getdata = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+user_id);
			   
			   ArrayList<Bpil_Users> pmg = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where profile_id="+6);

				  String fname = getdata.get(0).getFirst_name();
				  String lname = getdata.get(0).getLast_name();
				  
				  Bpil_Bsat_Defaults defaults = menudao.getDefaults();
				  
			      model.addAttribute("firstname",fname);
			      model.addAttribute("lastname",lname);
			      model.addAttribute("pmg",pmg);
			      model.addAttribute("redemption_day", defaults.getRedemption_date());
			        
			int count=10;
			model.addAttribute("count", count);
		}
		return new ModelAndView("ITSchemeRequest");
	}
	
	@RequestMapping("/prdoutcalci")
	public ModelAndView prdoutcalci(ModelMap map,Model model,HttpServletRequest request)
	{
		String kwm_user = (String) request.getSession().getAttribute("kwm_user");
		if (kwm_user != null) {						
	
			String username = (String) request.getSession().getAttribute("username");
			int user_id = (Integer) request.getSession().getAttribute("userid");	
			
		}
		return new ModelAndView("PrdOutCalci");
	}

	
	
	@RequestMapping("/primaryfinancialanalysis")
	//@RequestMapping("/")
	public ModelAndView financialanalysis(ModelMap map,Model model,HttpServletRequest request)
	{
		//model.addAttribute("price",price);
		return new ModelAndView("PrimaryFinancialAnalysis");
	}
	

	
	@RequestMapping("/primaryfinancialanalysism")
	//@RequestMapping("/")
	public ModelAndView financialanalysism(ModelMap map,Model model,HttpServletRequest request)
	{
		//model.addAttribute("price",price);
		return new ModelAndView("PrimaryFinancialAnalysism");
	}
	
	
	@RequestMapping("/histfinancialanalysis")
	public ModelAndView histfinancialanalysis(ModelMap map,Model model,HttpServletRequest request)
	{
		//model.addAttribute("price",price);
		return new ModelAndView("HistFinancialAnalysis");
	}
	
	@RequestMapping(value = "/loadpmguser", method = RequestMethod.GET)
	public void loadsubmenuname1(HttpServletRequest request,Model model,HttpServletResponse response,@RequestParam(value="user_id") String user_id) {
								
		 	try {
		 		
	ArrayList<Bpil_Users> dml = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id = "+user_id);
			 String json = null;
			 
			 json = new Gson().toJson(dml.get(0));
			 response.setContentType("application/json");
			 response.getWriter().write(json);
			 } catch (IOException e) {
			 	e.printStackTrace();
			 }
		
	}
	

	@RequestMapping(value = "/savescheme_request", method = RequestMethod.POST)
	public ModelAndView savescheme_request(@ModelAttribute("New_Scheme_mstr") New_Scheme_mstr new_scheme,
			BindingResult resultkwm_users ,
			@RequestParam CommonsMultipartFile [] doc_file,
			@RequestParam CommonsMultipartFile [] doc_file1,
			HttpServletRequest request,Model model) {
		
		System.out.println(" savescheme_request in controller");	
		
		String sel=request.getParameter("start_date");

		String selend=request.getParameter("end_date");
		String redemsel=request.getParameter("redemption_date");
		System.out.println(sel+"  "+selend+"  "+redemsel);
		System.out.println(sel+"----------------------------------");
		int rev=0;
		int rev1=0;
		int user_id = (Integer) request.getSession().getAttribute("userid");	
		int profile_id = (Integer) request.getSession().getAttribute("profileid");
		
		Date created_on = null;
		Date startdate = null;
		Date redemp_date = null;
		Date enddate = null;
		if(request.getParameter("redemption_date")!=null)
		{
				
				try {
					if (!request.getParameter("redemption_date").equals("")) {
						redemp_date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("redemption_date"));
						System.out.println(redemp_date);
					
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("start_date")!=null)
		{
			
				System.out.println("Start date for scheme is : "+request.getParameter("start_date"));
				System.out.println("Start datedup for scheme is : "+request.getParameter("start_datedup"));
				try {
					if (!request.getParameter("start_date").equals("")) {
						startdate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("start_datedup"));
						System.out.println(startdate);
						
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("end_date")!=null)
		{
			System.out.println("end datedup for scheme is : "+request.getParameter("end_datedup"));
				try {
					if (!request.getParameter("end_date").equals("")) {
						enddate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("end_datedup"));
						System.out.println(enddate);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
//		if(profile_id==3)
//		{			
//		
//		String str[] = request.getParameterValues("appl_depot_code1[]"); // string separate by ,
//		String str1 = "";
//		for(int i=0;i<str.length;i++)
//		{
//				System.out.println("in ctrl"+str[i]);
//				str1+=str[i];
//				
//			    if(i<str.length-1) // Avoiding the last comma
//			    {
//			    	str1+=",";
//			    }
//		}
//		
//		new_scheme.setAppl_depot_code(str1);
//		
//		
//		}
		
		String str[] = request.getParameterValues("sel_depo"); // string separate by ,
		String str1 = "";
		
		Set<String> set = new HashSet<>();
		for(int j = 0; j< str.length; j ++){
			set.add(str[j]);
		}
		
		System.out.println("Set : "+set.toString());
		
		int line =0;
		if(request.getParameterValues("sel_depo") != null ){
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
//		for(int i=0;i<str.length;i++)
//		{
//				System.out.println("in ctrl"+str[i]);
//				str1+=str[i];
//				
//			    if(i<str.length-1) // Avoiding the last comma
//			    {
//			    	str1+=",";
//			    }
//		}
		}
		
		
		new_scheme.setAppl_depot_code(str1);
		
		new_scheme.setStart_date(startdate);
		new_scheme.setEnd_date(enddate);
		new_scheme.setCreated_by(user_id);
		new_scheme.setLast_updated_by(user_id);
		new_scheme.setActive_flag("Incomplete");		
		new_scheme.setRedemption_date(redemp_date);
		
		System.out.println("Parent Scheme = "+new_scheme.getParent_scheme_code());
		
		if(new_scheme.getParent_scheme_code() != null && new_scheme.getParent_scheme_code() != "") {
	        
			ArrayList<New_Scheme_mstr> ps = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id = '"+new_scheme.getParent_scheme_code()+"'");

			if(!ps.isEmpty()){
			
			new_scheme.setParent_scheme_name(ps.get(0).getScheme_name());
			}
	        }
		
		if(request.getParameter("created_on")!=null)
		{			
				try {
					if (!request.getParameter("created_on").equals("")) {
						created_on = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("created_on"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
			new_scheme.setCreation_date(created_on);
			new_scheme.setLast_update_date(new Date());
			
			String sql = "select MAX(SCHEME_ID) SCHEME_ID from BPIL_SCHEME_MASTER";
	 		List<New_Scheme_mstr> dml = jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>() {

				@Override
				public New_Scheme_mstr mapRow(ResultSet rs, int rowNum) throws SQLException {
					New_Scheme_mstr aContact = new New_Scheme_mstr();
		
					aContact.setScheme_id(rs.getInt("SCHEME_ID"));
					
					
					return aContact;
				}
				
			});	
	 		
	 		int saveschid = dml.get(0).getScheme_id() + 1;
	 		new_scheme.setScheme_id(saveschid);
			
			int new_scheme_id = schemerequestdao.saveheader(new_scheme);
		
			
/////save doc	 scheme realted
		String	scheme_document_comment = request.getParameter("scheme_document_comment");
			
			   if (null != doc_file && doc_file.length>0) 
		        {
		            for (MultipartFile multipartFile : doc_file) {
		 
		            	Bpil_Scheme_Doc docs = new Bpil_Scheme_Doc();
		            	
		                String fileName = multipartFile.getOriginalFilename();
		                
		                try {
							docs.setDoc_file(multipartFile.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
		                docs.setDoc_title(multipartFile.getOriginalFilename());
		                docs.setDoc_type("Scheme Document");
		                docs.setScheme_id(new_scheme_id);
		                docs.setComments(scheme_document_comment);
		                docs.setCreation_date(new Date());
		                docs.setLast_update_date(new Date());
		              
		                
		                 long size = multipartFile.getSize();
		                if(size>0)
		                {
		                	  rev=new_scheme.getRevision();
//				                rev=rev+1;
				                docs.setRevision(rev);
		                 int doc_id = schemerequestdao.savedocs(docs);
		                }
		                 
		            }
		        }
			
			   String sch_code = new_scheme.getScheme_code();
			   String sr_no = Integer.toString(new_scheme_id);
			   String serial_num = sch_code.concat(sr_no);
			   new_scheme.setScheme_code(serial_num);
			   new_scheme.setRevision(rev);
			   new_scheme.setScheme_srl_no(sr_no);
			   
			   int new_scheme_id2 = schemerequestdao.saveheader(new_scheme);   

////save doc	others
				
			   String	other_document_comment = request.getParameter("other_document_comment");
			   
				   if (null != doc_file1 && doc_file1.length>0) 
			        {
			            for (MultipartFile multipartFile : doc_file1) {
			 
			            	Bpil_Scheme_Doc docs = new Bpil_Scheme_Doc();
			            	
			                String fileName = multipartFile.getOriginalFilename();
			                
			                try {
								docs.setDoc_file(multipartFile.getBytes());
							} catch (IOException e) {
								e.printStackTrace();
							}
			                docs.setDoc_title(multipartFile.getOriginalFilename());
			                docs.setDoc_type("Other Document");
			                docs.setScheme_id(new_scheme_id);
			                docs.setComments(other_document_comment);
			                
			                rev1=new_scheme.getRevision();			              
			                docs.setRevision(rev1);
			                docs.setCreation_date(new Date());
			                docs.setLast_update_date(new Date());
			                
			                 long size = multipartFile.getSize();
			                if(size>0)
			                {
			                 int doc_id = schemerequestdao.savedocs(docs);
			                }
			                 
			            }
			        }
/// save scheme cust type
				   
				   if(request.getParameter("cust_type")!=null) {
					   String cust_type[] = request.getParameterValues("cust_type");
					   
					   int custlen = cust_type.length;
					   
					   int prod_id = schemerequestdao.savecust_type(custlen, cust_type, new_scheme_id);
				   }
				   
				   
				   
//// save product info
			 
			String str2 = "";
		  if(request.getParameter("sch_prd_line_type")!=null && request.getParameter("sch_prd_exceptions")!=null && request.getParameter("sch_product_id")!=null && request.getParameter("vol_grwth_pct")!=null && request.getParameter("val_grwth_pct")!=null &&  request.getParameter("spread_pct")!=null && request.getParameter("spend_per_ltr")!=null)
				   {
			  
			String sch_prd_unique_id[] = request.getParameterValues("sch_prd_unique_id");
			String sch_prd_line_type[] = request.getParameterValues("sch_prd_line_type");
			String sch_product_id[] = request.getParameterValues("sch_product_id");
			String sch_prd_exceptions[] = request.getParameterValues("sch_prd_exceptions");
			String vol_grwth_pct[] = request.getParameterValues("vol_grwth_pct");
			String val_grwth_pct[] = request.getParameterValues("val_grwth_pct");
			String spread_pct[] = request.getParameterValues("spread_pct");			
			String spend_per_ltr[] = request.getParameterValues("spend_per_ltr");
			
			System.out.println(sch_prd_unique_id.toString()+"        sch_prd_unique_id");
			System.out.println(sch_prd_line_type.toString()+"        sch_prd_line_type");
			System.out.println(sch_product_id.toString()+"        sch_product_id");
			System.out.println(sch_prd_exceptions.toString()+"        sch_prd_exceptions");
			System.out.println(vol_grwth_pct.toString()+"        vol_grwth_pct");
			System.out.println(val_grwth_pct.toString()+"        val_grwth_pct");
			
			System.out.println(spread_pct.toString()+"        spread_pct");
			System.out.println(spend_per_ltr.toString()+"        spend_per_ltr");
			int len1 = vol_grwth_pct.length;				 
				 
				 int prod_id = schemerequestdao.saveproduct(len1,new_scheme_id,sch_prd_unique_id,sch_prd_line_type,sch_product_id,sch_prd_exceptions,vol_grwth_pct,val_grwth_pct,spread_pct,spend_per_ltr);  
				   
				for(int i=0;i<sch_product_id.length;i++)
					{
							System.out.println("in ctrl"+sch_product_id[i]);
							str2+=sch_product_id[i];
							
						    if(i<sch_product_id.length-1) // Avoiding the last comma
						    {
						    	str2+=",";
						    }
					}
					
		 }
				 
				//	new_scheme.setAttribute2(scheme_document_comment);  //scheme doc comments
				//	new_scheme.setAttribute3(other_document_comment);  //oyher doc comments
					new_scheme.setSch_product_codes(str2);
					new_scheme.setLast_update_date(new Date());
				 int new_scheme_id1 = schemerequestdao.saveheader(new_scheme);
				 
			//// save product outflow info
				 
					String str3 = "";
				  if(request.getParameter("sch_prd_outflow_line_type")!=null && request.getParameter("sch_product_outflow_id")!=null 
						  && request.getParameter("sch_prd_lly_vol")!=null && request.getParameter("sch_prd_lly_val")!=null 
						  && request.getParameter("sch_prd_ly_vol")!=null &&  request.getParameter("sch_prd_ly_val")!=null
						  && request.getParameter("sch_prd_spread_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_tgt_val")!=null
						  && request.getParameter("sch_prd_spread_mtd_ly_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ly_val")!=null
						  && request.getParameter("proj_grwth_vol_pct")!=null && request.getParameter("proj_grwth_val_pct")!=null 
						  && request.getParameter("proj_grwth_spd_pct")!=null 
						  && request.getParameter("sch_prd_ty_vol")!=null &&  request.getParameter("sch_prd_ty_val")!=null 
						  && request.getParameter("sch_prd_spread_mtd_ty_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ty_tgt_val")!=null 
						  && request.getParameter("sch_prd_wt_avg")!=null &&  request.getParameter("sch_prd_total_prd_bdgt")!=null)
						   {
					String sch_prd_outflow_unique_id[] = request.getParameterValues("sch_prd_outflow_unique_id");
					String sch_prd_outflow_line_type[] = request.getParameterValues("sch_prd_outflow_line_type");
					String sch_product_outflow_id[] = request.getParameterValues("sch_product_outflow_id");
					String sch_prd_lly_vol[] = request.getParameterValues("sch_prd_lly_vol");
					String sch_prd_lly_val[] = request.getParameterValues("sch_prd_lly_val");
					String sch_prd_ly_vol[] = request.getParameterValues("sch_prd_ly_vol");
					String sch_prd_ly_val[] = request.getParameterValues("sch_prd_ly_val");			
					String sch_prd_spread_tgt_vol[] = request.getParameterValues("sch_prd_spread_tgt_vol");
					String sch_prd_spread_tgt_val[] = request.getParameterValues("sch_prd_spread_tgt_val");
					String sch_prd_spread_mtd_ly_vol[] = request.getParameterValues("sch_prd_spread_mtd_ly_vol");
					String sch_prd_spread_mtd_ly_val[] = request.getParameterValues("sch_prd_spread_mtd_ly_val");
					String proj_grwth_vol_pct[] = request.getParameterValues("proj_grwth_vol_pct");
					String proj_grwth_val_pct[] = request.getParameterValues("proj_grwth_val_pct");
					String proj_grwth_spd_pct[] = request.getParameterValues("proj_grwth_spd_pct");
					String sch_prd_ty_vol[] = request.getParameterValues("sch_prd_ty_vol");
					String sch_prd_ty_val[] = request.getParameterValues("sch_prd_ty_val");
					String sch_prd_spread_mtd_ty_tgt_vol[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_vol");
					String sch_prd_spread_mtd_ty_tgt_val[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_val");
					String sch_prd_wt_avg[] = request.getParameterValues("sch_prd_wt_avg");			
					String sch_prd_total_prd_bdgt[] = request.getParameterValues("sch_prd_total_prd_bdgt");
					
					int len1 = sch_product_outflow_id.length;				 
						 
						 int prod_id = schemerequestdao.saveproductoutflow(len1,new_scheme_id,
								 sch_prd_outflow_unique_id,sch_prd_outflow_line_type,sch_product_outflow_id,
								 sch_prd_lly_vol,sch_prd_lly_val,sch_prd_ly_vol,sch_prd_ly_val,
								 sch_prd_spread_tgt_vol,sch_prd_spread_tgt_val,
								 sch_prd_spread_mtd_ly_vol,sch_prd_spread_mtd_ly_val,
								 proj_grwth_vol_pct,proj_grwth_val_pct,proj_grwth_spd_pct,sch_prd_ty_vol,sch_prd_ty_val,
								 sch_prd_spread_mtd_ty_tgt_vol,sch_prd_spread_mtd_ty_tgt_val,
								 sch_prd_wt_avg,sch_prd_total_prd_bdgt);  
						   
						for(int i=0;i<sch_product_outflow_id.length;i++)
							{
									System.out.println("in ctrl"+sch_product_outflow_id[i]);
									str3+=sch_product_outflow_id[i];
									
								    if(i<sch_product_outflow_id.length-1) // Avoiding the last comma
								    {
								    	str3+=",";
								    }
							}
							
				 }
						 
						
							new_scheme.setAttribute5(str3);
//						 int new_scheme_id1 = schemerequestdao.saveheader(new_scheme);
							
						
				 
//// save sheme gift

		 if(request.getParameter("gift_code")!=null && request.getParameter("gift_group")!=null && request.getParameter("gift_name")!=null && request.getParameter("effective_price")!=null )
			 {
//			 String str[] = request.getParameterValues("appl_depot_code1[]"); // string separate by ,
				String[] sche_code = request.getParameterValues("gift_code");
				String[] gift_id = request.getParameterValues("gift_id");
				String[] gift_group = request.getParameterValues("gift_group");
				String[] gift_name = request.getParameterValues("gift_name");			
				String[] effective_price = request.getParameterValues("effective_price");
//				if(gift_group != null) {
				int len = gift_group.length;
					
				 int schemegift_id = schemerequestdao.savegift(user_id,new_scheme_id,len,sche_code,gift_id,gift_group,gift_name,effective_price);  
//				}
		 }
		 
/////////// entry into depots table
		 
		 int revsion = new_scheme.getRevision();
		   
						   CallableStatement cStmt;
					 		try {
					 		cStmt = hibernateConfiguration.dataSource()
									.getConnection().prepareCall("{call BPIL_POPULATE_SCH_DEPOT_DTLS(?,?,?,?)}");
					 		 									 		
					 		
					 		cStmt.setInt(1, new_scheme_id);
					 		cStmt.setInt(2,revsion);	
					 		cStmt.setInt(3, user_id);
					 		cStmt.registerOutParameter(4,Types.VARCHAR); 
					 		ResultSet rs1 = cStmt.executeQuery();
					 			 	
					 			String str111 =cStmt.getString(4);
					 			System.out.println("msg is="+str111);
					
					 		} catch (SQLException e) {
					 		e.printStackTrace();
					 		}
					 		catch (Exception e) {
					 		System.out.println(e.getMessage());
					 		} 
					 		
					 		ArrayList<New_Scheme_mstr> sm = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id="+new_scheme_id);
							String schemecode=sm.get(0).getScheme_code();
							int createdby=sm.get(0).getCreated_by();
							ArrayList<Bpil_Users> su = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdby);
							String createdby1=su.get(0).getUser_name();
					 		
					 		try {
					 			CallableStatement cStmt2;	
					 			
					 				cStmt2 = hibernateConfiguration.dataSource().getConnection()
					 						.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
					 			

					 				cStmt2.setInt(1, createdby);
					 				cStmt2.setInt(2, new_scheme_id);
					 				cStmt2.setString(3, "NSR");
					 				cStmt2.setString(4, "New Scheme "+ schemecode + " registered in BSAT");
					 				cStmt2.registerOutParameter(5, Types.VARCHAR);
					 			ResultSet result = cStmt2.executeQuery();
					 			String flag = cStmt2.getString(5);
					 			System.out.println("scheme request mail flag "+ flag);
					 			
//					 			New Scheme 1718-ML7-497 is registered in BSAT
//					 			Scheme 1718-ML7-497 is updated in BSAT
					 			

					 			} catch (SQLException e) {
					 				// TODO Auto-generated catch block
					 				e.printStackTrace();
					 			}
					 		
					 		New_Scheme_mstr mstr = schememasterdao.schemeautofill(new_scheme_id);
							 if(mstr.getScheme_id() != Integer.parseInt(mstr.getScheme_srl_no())){
								 mstr.setScheme_srl_no(String.valueOf(mstr.getScheme_id()));
								 int srlSchemeId = schemerequestdao.saveheader(mstr);
								 System.out.println("srlSchemeId "+srlSchemeId);
							 }

			return new ModelAndView("redirect:/schemedetails?scheme_id="+new_scheme_id);		
	}
	

	
	@RequestMapping(value = "/ITsavescheme_request", method = RequestMethod.POST)
	public ModelAndView ITsavescheme_request(@ModelAttribute("New_Scheme_mstr") New_Scheme_mstr new_scheme,
			BindingResult resultkwm_users ,
			@RequestParam CommonsMultipartFile [] doc_file,
			@RequestParam CommonsMultipartFile [] doc_file1,
			HttpServletRequest request,Model model) {
		
		System.out.println("in ctrl");	
		int rev=0;
		int rev1=0;
		int user_id = (Integer) request.getSession().getAttribute("userid");	
		int profile_id = (Integer) request.getSession().getAttribute("profileid");
		
		String pmg_user_id = request.getParameter("pmg_user_id");
		
		Date created_on = null;
		Date startdate = null;
		Date redemp_date = null;
		Date enddate = null;
		
		System.out.println("---red----->>"+request.getParameter("redemption_date"));
		System.out.println("-----sd------>>"+request.getParameter("start_date"));
		System.out.println("-----ed------>>"+request.getParameter("end_date"));
		
		if (request.getParameter("redemption_date") != null) {

			try {
				if (!request.getParameter("redemption_date").equals("")) {
					redemp_date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("redemption_date"));

					System.out.println(" redemp_date ----------->>" + redemp_date);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter("start_date") != null) {

			try {
				if (!request.getParameter("start_date").equals("")) {
					startdate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("start_date"));
					
					
					System.out.println(" startdate ----------->>" + startdate);
					
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter("end_date") != null) {

			try {
				if (!request.getParameter("end_date").equals("")) {
					enddate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("end_date"));
					
					System.out.println(" enddate ----------->>" + enddate);
					
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
	
		String str[] = request.getParameterValues("sel_depo"); // string separate by ,
		String str1 = "";
		
		Set<String> set = new HashSet<>();
		for(int j = 0; j< str.length; j ++){
			set.add(str[j]);
		}
		
		System.out.println("Set : "+set.toString());
		
		int line =0;
		if(request.getParameterValues("sel_depo") != null ){
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
		}
		
		System.out.println("str1--------->>"+str1);
		
		new_scheme.setAppl_depot_code(str1);
		
		System.out.println("---->>"+startdate+"  --------->> "+enddate);
		new_scheme.setStart_date(startdate);
		new_scheme.setEnd_date(enddate);
		new_scheme.setCreated_by(Integer.parseInt(pmg_user_id));
		new_scheme.setLast_updated_by(user_id);
		new_scheme.setActive_flag("Incomplete");		
		new_scheme.setRedemption_date(redemp_date);
		
		System.out.println("Parent Scheme = "+new_scheme.getParent_scheme_code());
		
		if(new_scheme.getParent_scheme_code() != null && new_scheme.getParent_scheme_code() != "") {
	        
			ArrayList<New_Scheme_mstr> ps = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id = '"+new_scheme.getParent_scheme_code()+"'");

			if(!ps.isEmpty()){
			
			new_scheme.setParent_scheme_name(ps.get(0).getScheme_name());
			}
	        }
		
		if(request.getParameter("created_on")!=null)
		{			
				try {
					if (!request.getParameter("created_on").equals("")) {
						created_on = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("created_on"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
			new_scheme.setCreation_date(created_on);
			new_scheme.setLast_update_date(new Date());
			
			String sql = "select MAX(SCHEME_ID) SCHEME_ID from BPIL_SCHEME_MASTER";
	 		List<New_Scheme_mstr> dml = jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>() {

				@Override
				public New_Scheme_mstr mapRow(ResultSet rs, int rowNum) throws SQLException {
					New_Scheme_mstr aContact = new New_Scheme_mstr();
		
					aContact.setScheme_id(rs.getInt("SCHEME_ID"));
					
					
					return aContact;
				}
				
			});	
	 		
	 		int saveschid = dml.get(0).getScheme_id() + 1;
	 		new_scheme.setScheme_id(saveschid);
			
			int new_scheme_id = schemerequestdao.saveheader(new_scheme);
		
			
/////save doc	 scheme realted
		String	scheme_document_comment = request.getParameter("scheme_document_comment");
			
			   if (null != doc_file && doc_file.length>0) 
		        {
		            for (MultipartFile multipartFile : doc_file) {
		 
		            	Bpil_Scheme_Doc docs = new Bpil_Scheme_Doc();
		            	
		                String fileName = multipartFile.getOriginalFilename();
		                
		                try {
							docs.setDoc_file(multipartFile.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
		                docs.setDoc_title(multipartFile.getOriginalFilename());
		                docs.setDoc_type("Scheme Document");
		                docs.setScheme_id(new_scheme_id);
		                docs.setComments(scheme_document_comment);
		                docs.setCreation_date(new Date());
		                docs.setLast_update_date(new Date());
		              
		                
		                 long size = multipartFile.getSize();
		                if(size>0)
		                {
		                	  rev=new_scheme.getRevision();
//				                rev=rev+1;
				                docs.setRevision(rev);
		                 int doc_id = schemerequestdao.savedocs(docs);
		                }
		                 
		            }
		        }
			
			   String sch_code = new_scheme.getScheme_code();
			   String sr_no = Integer.toString(new_scheme_id);
			   String serial_num = sch_code.concat(sr_no);
			   new_scheme.setScheme_code(serial_num);
			   new_scheme.setRevision(rev);
			   new_scheme.setScheme_srl_no(sr_no);
			   
			   int new_scheme_id2 = schemerequestdao.saveheader(new_scheme);   

////save doc	others
				
			   String	other_document_comment = request.getParameter("other_document_comment");
			   
				   if (null != doc_file1 && doc_file1.length>0) 
			        {
			            for (MultipartFile multipartFile : doc_file1) {
			 
			            	Bpil_Scheme_Doc docs = new Bpil_Scheme_Doc();
			            	
			                String fileName = multipartFile.getOriginalFilename();
			                
			                try {
								docs.setDoc_file(multipartFile.getBytes());
							} catch (IOException e) {
								e.printStackTrace();
							}
			                docs.setDoc_title(multipartFile.getOriginalFilename());
			                docs.setDoc_type("Other Document");
			                docs.setScheme_id(new_scheme_id);
			                docs.setComments(other_document_comment);
			                
			                rev1=new_scheme.getRevision();			              
			                docs.setRevision(rev1);
			                docs.setCreation_date(new Date());
			                docs.setLast_update_date(new Date());
			                
			                 long size = multipartFile.getSize();
			                if(size>0)
			                {
			                 int doc_id = schemerequestdao.savedocs(docs);
			                }
			                 
			            }
			        }
/// save scheme cust type
				   
				   if(request.getParameter("cust_type")!=null) {
					   String cust_type[] = request.getParameterValues("cust_type");
					   
					   int custlen = cust_type.length;
					   
					   int prod_id = schemerequestdao.savecust_type(custlen, cust_type, new_scheme_id);
				   }
				   
//// save product info
			 
			String str2 = "";
		  if(request.getParameter("sch_prd_line_type")!=null && request.getParameter("sch_prd_exceptions")!=null && request.getParameter("sch_product_id")!=null && request.getParameter("vol_grwth_pct")!=null && request.getParameter("val_grwth_pct")!=null &&  request.getParameter("spread_pct")!=null && request.getParameter("spend_per_ltr")!=null)
				   {
			String sch_prd_unique_id[] = request.getParameterValues("sch_prd_unique_id");
			String sch_prd_line_type[] = request.getParameterValues("sch_prd_line_type");
			String sch_product_id[] = request.getParameterValues("sch_product_id");
			String sch_prd_exceptions[] = request.getParameterValues("sch_prd_exceptions");
			String vol_grwth_pct[] = request.getParameterValues("vol_grwth_pct");
			String val_grwth_pct[] = request.getParameterValues("val_grwth_pct");
			String spread_pct[] = request.getParameterValues("spread_pct");			
			String spend_per_ltr[] = request.getParameterValues("spend_per_ltr");
			
			int len1 = vol_grwth_pct.length;				 
				 
				 int prod_id = schemerequestdao.saveproduct(len1,new_scheme_id,sch_prd_unique_id,sch_prd_line_type,sch_product_id,sch_prd_exceptions,vol_grwth_pct,val_grwth_pct,spread_pct,spend_per_ltr);  
				   
				for(int i=0;i<sch_product_id.length;i++)
					{
							System.out.println("in ctrl"+sch_product_id[i]);
							str2+=sch_product_id[i];
							
						    if(i<sch_product_id.length-1) // Avoiding the last comma
						    {
						    	str2+=",";
						    }
					}
					
		 }
				 
					new_scheme.setSch_product_codes(str2);
					new_scheme.setLast_update_date(new Date());
				 int new_scheme_id1 = schemerequestdao.saveheader(new_scheme);
				 
			//// save product outflow info
				 
					String str3 = "";
				  if(request.getParameter("sch_prd_outflow_line_type")!=null && request.getParameter("sch_product_outflow_id")!=null 
						  && request.getParameter("sch_prd_lly_vol")!=null && request.getParameter("sch_prd_lly_val")!=null 
						  && request.getParameter("sch_prd_ly_vol")!=null &&  request.getParameter("sch_prd_ly_val")!=null
						  && request.getParameter("sch_prd_spread_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_tgt_val")!=null
						  && request.getParameter("sch_prd_spread_mtd_ly_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ly_val")!=null
						  && request.getParameter("proj_grwth_vol_pct")!=null && request.getParameter("proj_grwth_val_pct")!=null 
						  && request.getParameter("proj_grwth_spd_pct")!=null 
						  && request.getParameter("sch_prd_ty_vol")!=null &&  request.getParameter("sch_prd_ty_val")!=null 
						  && request.getParameter("sch_prd_spread_mtd_ty_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ty_tgt_val")!=null 
						  && request.getParameter("sch_prd_wt_avg")!=null &&  request.getParameter("sch_prd_total_prd_bdgt")!=null)
						   {
					String sch_prd_outflow_unique_id[] = request.getParameterValues("sch_prd_outflow_unique_id");
					String sch_prd_outflow_line_type[] = request.getParameterValues("sch_prd_outflow_line_type");
					String sch_product_outflow_id[] = request.getParameterValues("sch_product_outflow_id");
					String sch_prd_lly_vol[] = request.getParameterValues("sch_prd_lly_vol");
					String sch_prd_lly_val[] = request.getParameterValues("sch_prd_lly_val");
					String sch_prd_ly_vol[] = request.getParameterValues("sch_prd_ly_vol");
					String sch_prd_ly_val[] = request.getParameterValues("sch_prd_ly_val");			
					String sch_prd_spread_tgt_vol[] = request.getParameterValues("sch_prd_spread_tgt_vol");
					String sch_prd_spread_tgt_val[] = request.getParameterValues("sch_prd_spread_tgt_val");
					String sch_prd_spread_mtd_ly_vol[] = request.getParameterValues("sch_prd_spread_mtd_ly_vol");
					String sch_prd_spread_mtd_ly_val[] = request.getParameterValues("sch_prd_spread_mtd_ly_val");
					String proj_grwth_vol_pct[] = request.getParameterValues("proj_grwth_vol_pct");
					String proj_grwth_val_pct[] = request.getParameterValues("proj_grwth_val_pct");
					String proj_grwth_spd_pct[] = request.getParameterValues("proj_grwth_spd_pct");
					String sch_prd_ty_vol[] = request.getParameterValues("sch_prd_ty_vol");
					String sch_prd_ty_val[] = request.getParameterValues("sch_prd_ty_val");
					String sch_prd_spread_mtd_ty_tgt_vol[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_vol");
					String sch_prd_spread_mtd_ty_tgt_val[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_val");
					String sch_prd_wt_avg[] = request.getParameterValues("sch_prd_wt_avg");			
					String sch_prd_total_prd_bdgt[] = request.getParameterValues("sch_prd_total_prd_bdgt");
					
					int len1 = sch_product_outflow_id.length;				 
						 
						 int prod_id = schemerequestdao.saveproductoutflow(len1,new_scheme_id,
								 sch_prd_outflow_unique_id,sch_prd_outflow_line_type,sch_product_outflow_id,
								 sch_prd_lly_vol,sch_prd_lly_val,sch_prd_ly_vol,sch_prd_ly_val,
								 sch_prd_spread_tgt_vol,sch_prd_spread_tgt_val,
								 sch_prd_spread_mtd_ly_vol,sch_prd_spread_mtd_ly_val,
								 proj_grwth_vol_pct,proj_grwth_val_pct,proj_grwth_spd_pct,sch_prd_ty_vol,sch_prd_ty_val,
								 sch_prd_spread_mtd_ty_tgt_vol,sch_prd_spread_mtd_ty_tgt_val,
								 sch_prd_wt_avg,sch_prd_total_prd_bdgt);  
						   
						for(int i=0;i<sch_product_outflow_id.length;i++)
							{
									System.out.println("in ctrl"+sch_product_outflow_id[i]);
									str3+=sch_product_outflow_id[i];
									
								    if(i<sch_product_outflow_id.length-1) // Avoiding the last comma
								    {
								    	str3+=",";
								    }
							}
							
				 }
						 
						
							new_scheme.setAttribute5(str3);
//						 int new_scheme_id1 = schemerequestdao.saveheader(new_scheme);
							
//// save scheme gift //sameer
							System.out.println("---->>"+request.getParameter("gift_code"));
							System.out.println("---->>"+request.getParameter("gift_group"));
							System.out.println("---->>"+request.getParameter("gift_name"));
							System.out.println("---->>"+request.getParameter("effective_price"));
							
							

		 if(request.getParameter("gift_code")!=null && request.getParameter("gift_group")!=null && request.getParameter("gift_name")!=null && request.getParameter("effective_price")!=null )
			 {
//			 String str[] = request.getParameterValues("appl_depot_code1[]"); // string separate by ,
				String[] sche_code = request.getParameterValues("gift_code");
				String[] gift_id = request.getParameterValues("gift_id");
				String[] gift_group = request.getParameterValues("gift_group");
				String[] gift_name = request.getParameterValues("gift_name");			
				String[] effective_price = request.getParameterValues("effective_price");
//				if(gift_group != null) {
				int len = gift_group.length;
					
				 int schemegift_id = schemerequestdao.savegift(user_id,new_scheme_id,len,sche_code,gift_id,gift_group,gift_name,effective_price);  
//				}
		 }
		 
/////////// entry into depots table
		 
		 int revsion = new_scheme.getRevision();
		   
						   CallableStatement cStmt;
					 		try {
					 		cStmt = hibernateConfiguration.dataSource()
									.getConnection().prepareCall("{call BPIL_POPULATE_SCH_DEPOT_DTLS(?,?,?,?)}");
					 		 									 		
					 		
					 		cStmt.setInt(1, new_scheme_id);
					 		cStmt.setInt(2,revsion);	
					 		cStmt.setInt(3, user_id);
					 		cStmt.registerOutParameter(4,Types.VARCHAR); 
					 		ResultSet rs1 = cStmt.executeQuery();
					 			 	
					 			String str111 =cStmt.getString(4);
					 			System.out.println("msg is="+str111);
					
					 		} catch (SQLException e) {
					 		e.printStackTrace();
					 		}
					 		catch (Exception e) {
					 		System.out.println(e.getMessage());
					 		} 
					 		
					 		ArrayList<New_Scheme_mstr> sm = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id="+new_scheme_id);
							String schemecode=sm.get(0).getScheme_code();
							int createdby=sm.get(0).getCreated_by();
							ArrayList<Bpil_Users> su = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdby);
							String createdby1=su.get(0).getUser_name();
					 		
					 		try {
					 			CallableStatement cStmt2;	
					 			
					 				cStmt2 = hibernateConfiguration.dataSource().getConnection()
					 						.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
					 			

					 				cStmt2.setInt(1, createdby);
					 				cStmt2.setInt(2, new_scheme_id);
					 				cStmt2.setString(3, "NSR");
					 				cStmt2.setString(4, "New Scheme "+ schemecode + " registered in BSAT");
					 				cStmt2.registerOutParameter(5, Types.VARCHAR);
					 			ResultSet result = cStmt2.executeQuery();
					 			String flag = cStmt2.getString(5);
					 			System.out.println("scheme request mail flag "+ flag);
					 			
//					 			New Scheme 1718-ML7-497 is registered in BSAT
//					 			Scheme 1718-ML7-497 is updated in BSAT
					 			

					 			} catch (SQLException e) {
					 				// TODO Auto-generated catch block
					 				e.printStackTrace();
					 			}

			return new ModelAndView("redirect:/schemedetails?scheme_id="+new_scheme_id);		
	}
	
	
	

	
	
	
	@RequestMapping(value = "/updatescheme_request", method = RequestMethod.POST)
	public ModelAndView updatescheme_request(@ModelAttribute("New_Scheme_mstr") New_Scheme_mstr new_scheme,
			BindingResult resultkwm_users ,
			@RequestParam CommonsMultipartFile [] doc_file,
			@RequestParam CommonsMultipartFile [] doc_file1,
			HttpServletRequest request,Model model) {
		
		System.out.println("in ctrl");	
		String action = request.getParameter("action");
		int rev=new_scheme.getRevision() + 1;
		int rev1=0;
		int user_id = (Integer) request.getSession().getAttribute("userid");	
		int profile_id = (Integer) request.getSession().getAttribute("profileid");
		int scheme_id = new_scheme.getScheme_id();
		
		boolean datechangeflag = false, budgetchangeflag = false, depotschangeflag = false, documentchangeflag = false;
		
		ArrayList<New_Scheme_mstr> Update_Schemes=(ArrayList<New_Scheme_mstr>)hibernateTemplate.find("from New_Scheme_mstr  where scheme_id="+new_scheme.getScheme_id());
		New_Scheme_mstr Update_Scheme = Update_Schemes.get(0);
		
		Date created_on = null;
		Date startdate = null;
		Date redemp_date = null;
		Date enddate = null;
		if(request.getParameter("redemption_date")!=null)
		{
				
				try {
					if (!request.getParameter("redemption_date").equals("")) {
						redemp_date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("redemption_date"));
						
						System.out.println(" "+redemp_date);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("start_date")!=null)
		{
				
				try {
					if (!request.getParameter("start_date").equals("")) {
						startdate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("start_date"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("end_date")!=null)
		{
				
				try {
					if (!request.getParameter("end_date").equals("")) {
						enddate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("end_date"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(!redemp_date.equals(Update_Scheme.getRedemption_date()) || !startdate.equals(Update_Scheme.getStart_date())
				|| !enddate.equals(Update_Scheme.getEnd_date())) {
			datechangeflag = true;
		} 
		
		/*
		if(profile_id==3)
		{			
		
		String str[] = request.getParameterValues("appl_depot_code1[]"); // string separate by ,
		String str1 = "";
		for(int i=0;i<str.length;i++)
		{
				System.out.println("in ctrl"+str[i]);
				str1+=str[i];
				
			    if(i<str.length-1) // Avoiding the last comma
			    {
			    	str1+=",";
			    }
		}
		
		new_scheme.setAppl_depot_code(str1);
		Update_Scheme.setAppl_depot_code(new_scheme.getAppl_depot_code());
		
		
		}
		*/
		
		String str[] = request.getParameterValues("sel_depo"); // string separate by ,
		String str1 = "";
		
		Set<String> set = new HashSet<>();
		for(int j = 0; j< str.length; j ++){
			set.add(str[j]);
		}
		
		System.out.println("Set : "+set.toString());
		
		int line =0;
		if(request.getParameterValues("sel_depo") != null ){
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
		}
		
		
		String schdepo[] = Update_Scheme.getAppl_depot_code().split(","); // string separate by ,
		
		Set<String> set2 = new HashSet<>();
		for(int j = 0; j< schdepo.length; j ++){
			set2.add(schdepo[j]);
		}
		
		System.out.println("Set2 : "+set2.toString());
			
		if(!set.equals(set2)) {
			depotschangeflag = true;
			System.out.println("depotschangeflag "+depotschangeflag);
		}
		
//		if(request.getParameterValues("appl_depot_code1[]") != null)
//		{
//		for(int i=0;i<str.length;i++)
//		{
//				System.out.println("in ctrl"+str[i]);
//				str1+=str[i];
//				
//			    if(i<str.length-1) // Avoiding the last comma
//			    {
//			    	str1+=",";
//			    }
//		}
//		}
		
		new_scheme.setAppl_depot_code(str1);
		
		new_scheme.setStart_date(startdate);
		new_scheme.setEnd_date(enddate);
		new_scheme.setCreated_by(user_id);
		new_scheme.setLast_updated_by(user_id);
		new_scheme.setActive_flag("Incomplete");		
		new_scheme.setRedemption_date(redemp_date);
		
		Update_Scheme.setAppl_depot_code(new_scheme.getAppl_depot_code());
		Update_Scheme.setAppl_regn_code(new_scheme.getAppl_regn_code());
		Update_Scheme.setStart_date(new_scheme.getStart_date());
		Update_Scheme.setEnd_date(new_scheme.getEnd_date());
		Update_Scheme.setCreated_by(new_scheme.getCreated_by());
		Update_Scheme.setLast_updated_by(new_scheme.getLast_updated_by());
		Update_Scheme.setActive_flag(new_scheme.getActive_flag());
		Update_Scheme.setRedemption_date(new_scheme.getRedemption_date());
		Update_Scheme.setRevision(new_scheme.getRevision() + 1);
		
//		if(new_scheme.getParent_scheme_code() != null && new_scheme.getParent_scheme_code() != "") {
//	        
//			ArrayList<New_Scheme_mstr> ps = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id = '"+new_scheme.getParent_scheme_code()+"'");
//
//			if(!ps.isEmpty()){
//			new_scheme.setParent_scheme_name(ps.get(0).getScheme_name());
//			}
//	        }

		
		if(request.getParameter("created_on")!=null)
		{			
				try {
					if (!request.getParameter("created_on").equals("")) {
						created_on = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("created_on"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		new_scheme.setCreation_date(created_on);
		
		if(new_scheme.getScheme_budget() != Update_Scheme.getScheme_budget()) {
			budgetchangeflag = true;
		} 
		
		Update_Scheme.setCreation_date(new_scheme.getCreation_date());
		
		Update_Scheme.setScheme_name(new_scheme.getScheme_name());
		Update_Scheme.setScheme_budget(new_scheme.getScheme_budget());
		Update_Scheme.setObjective(new_scheme.getObjective());
		Update_Scheme.setAttribute1(new_scheme.getAttribute1());
		Update_Scheme.setAttribute2(new_scheme.getAttribute2());
		Update_Scheme.setAttribute3(new_scheme.getAttribute3());
		
		Update_Scheme.setProvision_id(new_scheme.getProvision_id());
		Update_Scheme.setBudget_available(new_scheme.getBudget_available());
		Update_Scheme.setFin_analysis_flag(new_scheme.getFin_analysis_flag());
		Update_Scheme.setProvision_comments(new_scheme.getProvision_comments());
		Update_Scheme.setReference_sch_id(new_scheme.getReference_sch_id());
		Update_Scheme.setSch_reward_eff_price(new_scheme.getSch_reward_eff_price());
		Update_Scheme.setConfidence_pct(new_scheme.getConfidence_pct());
		Update_Scheme.setOutflow(new_scheme.getOutflow());
		Update_Scheme.setLast_update_date(new Date());
		
//			int new_scheme_id = schemerequestdao.saveheader(new_scheme);
			int new_scheme_id = schemerequestdao.saveheader(Update_Scheme);
		
			
/////save doc	 scheme realted
		String	scheme_document_comment = request.getParameter("scheme_document_comment");
			
			   if (null != doc_file && doc_file.length>0) 
		        {
				   
		            for (MultipartFile multipartFile : doc_file) {
		 
		            	Bpil_Scheme_Doc docs = new Bpil_Scheme_Doc();
		            	
		                String fileName = multipartFile.getOriginalFilename();
		                
		                try {
							docs.setDoc_file(multipartFile.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
		                docs.setDoc_title(multipartFile.getOriginalFilename());
		                docs.setDoc_type("Scheme Document");
		                docs.setScheme_id(Update_Scheme.getScheme_id());
		                docs.setComments(scheme_document_comment);
		                docs.setLast_update_date(new Date());
		                
		                 long size = multipartFile.getSize();
		                if(size>0)
		                {
		                	documentchangeflag = true;
//		                	rev=new_scheme.getRevision();
//			                rev=rev+1;
			                docs.setRevision(Update_Scheme.getRevision());
			                
		                 int doc_id = schemerequestdao.savedocs(docs);
		                }
		                 
		            }
		        }
					 
			   new_scheme.setRevision(Update_Scheme.getRevision());
			   String sr_no = Integer.toString(new_scheme_id);
			   new_scheme.setScheme_srl_no(sr_no);
			   
//			   int new_scheme_id2 = schemerequestdao.saveheader(new_scheme);   

////save doc	others
				
			   String	other_document_comment = request.getParameter("other_document_comment");
			   
				   if (null != doc_file1 && doc_file1.length>0) 
			        {
					    for (MultipartFile multipartFile : doc_file1) {
			 
			            	Bpil_Scheme_Doc docs = new Bpil_Scheme_Doc();
			            	
			                String fileName = multipartFile.getOriginalFilename();
			                
			                try {
								docs.setDoc_file(multipartFile.getBytes());
							} catch (IOException e) {
								e.printStackTrace();
							}
			                docs.setDoc_title(multipartFile.getOriginalFilename());
			                docs.setDoc_type("Other Document");
			                docs.setScheme_id(Update_Scheme.getScheme_id());
			                docs.setComments(other_document_comment);
			                
//			                rev1=new_scheme.getRevision();			              
			                docs.setRevision(Update_Scheme.getRevision());
			                docs.setLast_update_date(new Date());
			                
			                 long size = multipartFile.getSize();
			                if(size>0)
			                {
			                	documentchangeflag = true;
			                 int doc_id = schemerequestdao.savedocs(docs);
			                }
			                 
			            }
			        }
				   
				   if(datechangeflag) {
					   Update_Scheme.setAttribute6("Y");
					} else {
						Update_Scheme.setAttribute6("N");
					}
				   if(depotschangeflag) {
					   Update_Scheme.setAttribute7("Y");
					} else {
						Update_Scheme.setAttribute7("N");
					}
				   if(budgetchangeflag) {
					   Update_Scheme.setAttribute8("Y");
					} else {
						Update_Scheme.setAttribute8("N");
					}
				   if(documentchangeflag) {
					   Update_Scheme.setAttribute9("Y");
					} else {
						Update_Scheme.setAttribute9("N");
					}
				   
				   new_scheme_id = schemerequestdao.saveheader(Update_Scheme);
				   
/// save scheme cust type
				   
				   if(request.getParameter("cust_type")!=null) {
					   String cust_type[] = request.getParameterValues("cust_type");
					   
					   int custlen = cust_type.length;
					   
					   int prod_id = schemerequestdao.savecust_type(custlen, cust_type, new_scheme_id);
				   }

				   
//// save product info
		String str2 = "";
		 if(request.getParameter("sch_prd_line_type")!=null && request.getParameter("sch_prd_exceptions")!=null && request.getParameter("sch_product_id")!=null && request.getParameter("vol_grwth_pct")!=null && request.getParameter("val_grwth_pct")!=null &&  request.getParameter("spread_pct")!=null && request.getParameter("spend_per_ltr")!=null)
		 {	   
			String sch_prd_unique_id[] = request.getParameterValues("sch_prd_unique_id"); 			
			String sch_prd_line_type[] = request.getParameterValues("sch_prd_line_type");
			String sch_product_id[] = request.getParameterValues("sch_product_id");
			String sch_prd_exceptions[] = request.getParameterValues("sch_prd_exceptions");
			String vol_grwth_pct[] = request.getParameterValues("vol_grwth_pct");
			String val_grwth_pct[] = request.getParameterValues("val_grwth_pct");
			String spread_pct[] = request.getParameterValues("spread_pct");			
			String spend_per_ltr[] = request.getParameterValues("spend_per_ltr");
			
			int len1 = vol_grwth_pct.length;				 
				 
//				 int prod_id = schemerequestdao.saveproduct(len1,new_scheme_id,sch_prd_unique_id,sch_prd_line_type,sch_product_id,sch_prd_exceptions,vol_grwth_pct,val_grwth_pct,spread_pct,spend_per_ltr);  
								
					for(int i=0;i<sch_product_id.length;i++)
					{
							System.out.println("in ctrl"+sch_product_id[i]);
							str2+=sch_product_id[i];
							
						    if(i<sch_product_id.length-1) // Avoiding the last comma
						    {
						    	str2+=",";
						    }
					}
				 
		 }
				//	new_scheme.setAttribute2(scheme_document_comment);  //scheme doc comments
				//	new_scheme.setAttribute3(other_document_comment);  //oyher doc comments
					new_scheme.setSch_product_codes(str2);
//				 int new_scheme_id1 = schemerequestdao.saveheader(new_scheme);
					
					//// save product outflow info
					 
					String str3 = "";
				  if(request.getParameter("sch_prd_outflow_line_type")!=null && request.getParameter("sch_product_outflow_id")!=null 
						  && request.getParameter("sch_prd_lly_vol")!=null && request.getParameter("sch_prd_lly_val")!=null 
						  && request.getParameter("sch_prd_ly_vol")!=null &&  request.getParameter("sch_prd_ly_val")!=null
						  && request.getParameter("sch_prd_spread_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_tgt_val")!=null
						  && request.getParameter("sch_prd_spread_mtd_ly_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ly_val")!=null
						  && request.getParameter("proj_grwth_vol_pct")!=null && request.getParameter("proj_grwth_val_pct")!=null 
						  && request.getParameter("proj_grwth_spd_pct")!=null 
						  && request.getParameter("sch_prd_ty_vol")!=null &&  request.getParameter("sch_prd_ty_val")!=null 
						  && request.getParameter("sch_prd_spread_mtd_ty_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ty_tgt_val")!=null 
						  && request.getParameter("sch_prd_wt_avg")!=null &&  request.getParameter("sch_prd_total_prd_bdgt")!=null)
						   {
					String sch_prd_outflow_unique_id[] = request.getParameterValues("sch_prd_outflow_unique_id");
					String sch_prd_outflow_line_type[] = request.getParameterValues("sch_prd_outflow_line_type");
					String sch_product_outflow_id[] = request.getParameterValues("sch_product_outflow_id");
					String sch_prd_lly_vol[] = request.getParameterValues("sch_prd_lly_vol");
					String sch_prd_lly_val[] = request.getParameterValues("sch_prd_lly_val");
					String sch_prd_ly_vol[] = request.getParameterValues("sch_prd_ly_vol");
					String sch_prd_ly_val[] = request.getParameterValues("sch_prd_ly_val");			
					String sch_prd_spread_tgt_vol[] = request.getParameterValues("sch_prd_spread_tgt_vol");
					String sch_prd_spread_tgt_val[] = request.getParameterValues("sch_prd_spread_tgt_val");
					String sch_prd_spread_mtd_ly_vol[] = request.getParameterValues("sch_prd_spread_mtd_ly_vol");
					String sch_prd_spread_mtd_ly_val[] = request.getParameterValues("sch_prd_spread_mtd_ly_val");
					String proj_grwth_vol_pct[] = request.getParameterValues("proj_grwth_vol_pct");
					String proj_grwth_val_pct[] = request.getParameterValues("proj_grwth_val_pct");
					String proj_grwth_spd_pct[] = request.getParameterValues("proj_grwth_spd_pct");
					String sch_prd_ty_vol[] = request.getParameterValues("sch_prd_ty_vol");
					String sch_prd_ty_val[] = request.getParameterValues("sch_prd_ty_val");
					String sch_prd_spread_mtd_ty_tgt_vol[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_vol");
					String sch_prd_spread_mtd_ty_tgt_val[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_val");
					String sch_prd_wt_avg[] = request.getParameterValues("sch_prd_wt_avg");			
					String sch_prd_total_prd_bdgt[] = request.getParameterValues("sch_prd_total_prd_bdgt");
					
					int len1 = sch_product_outflow_id.length;				 
						 
						 int prod_id = schemerequestdao.saveproductoutflow(len1,new_scheme_id,
								 sch_prd_outflow_unique_id,sch_prd_outflow_line_type,sch_product_outflow_id,
								 sch_prd_lly_vol,sch_prd_lly_val,sch_prd_ly_vol,sch_prd_ly_val,
								 sch_prd_spread_tgt_vol,sch_prd_spread_tgt_val,
								 sch_prd_spread_mtd_ly_vol,sch_prd_spread_mtd_ly_val,
								 proj_grwth_vol_pct,proj_grwth_val_pct,proj_grwth_spd_pct,sch_prd_ty_vol,sch_prd_ty_val,
								 sch_prd_spread_mtd_ty_tgt_vol,sch_prd_spread_mtd_ty_tgt_val,
								 sch_prd_wt_avg,sch_prd_total_prd_bdgt);  
						   
						for(int i=0;i<sch_product_outflow_id.length;i++)
							{
									System.out.println("in ctrl"+sch_product_outflow_id[i]);
									str3+=sch_product_outflow_id[i];
									
								    if(i<sch_product_outflow_id.length-1) // Avoiding the last comma
								    {
								    	str3+=",";
								    }
							}
							
				 }
						 
						
							new_scheme.setAttribute5(str3);
//						 int new_scheme_id1 = schemerequestdao.saveheader(new_scheme);
	
							
				 
//// save sheme gift
	 if(request.getParameter("gift_code")!=null  && request.getParameter("gift_group")!=null && request.getParameter("gift_name")!=null && request.getParameter("effective_price")!=null )
		 {
//			String str[] = request.getParameterValues("appl_depot_code1[]"); // string separate by ,
			String[] sche_code = request.getParameterValues("gift_code");
			String[] gift_id = request.getParameterValues("gift_id");
			String[] gift_group = request.getParameterValues("gift_group");
			String[] gift_name = request.getParameterValues("gift_name");			
			String[] effective_price = request.getParameterValues("effective_price");
			int len = gift_group.length;
				
			 int schemegift_id = schemerequestdao.savegift(user_id,new_scheme_id,len,sche_code,gift_id,gift_group,gift_name,effective_price);  
			 	   
		}
	 
/////////// entry into depots table
	 
	 int revsion = new_scheme.getRevision();
	   
					   CallableStatement cStmt;
				 		try {
				 		cStmt = hibernateConfiguration.dataSource()
								.getConnection().prepareCall("{call BPIL_POPULATE_SCH_DEPOT_DTLS(?,?,?,?)}");
				 		 									 		
				 		
				 		cStmt.setInt(1, new_scheme_id);
				 		cStmt.setInt(2,revsion);	
				 		cStmt.setInt(3, user_id);
				 		cStmt.registerOutParameter(4,Types.VARCHAR); 
				 		ResultSet rs1 = cStmt.executeQuery();
				 			 	
				 			String str111 =cStmt.getString(4);
				 			System.out.println("msg is="+str111);
				
				 		} catch (SQLException e) {
				 		e.printStackTrace();
				 		}
				 		catch (Exception e) {
				 		System.out.println(e.getMessage());
				 		}
				 		
				 		ArrayList<New_Scheme_mstr> sm = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id="+new_scheme_id);
						String schemecodeu=sm.get(0).getScheme_code();
						int createdbyu=sm.get(0).getCreated_by();
						ArrayList<Bpil_Users> su = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdbyu);
						String createdbyu1=su.get(0).getUser_name();
				 		
				 		try {
				 			CallableStatement cStmt2;	
				 			
				 				cStmt2 = hibernateConfiguration.dataSource().getConnection()
				 						.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
				 			

				 				cStmt2.setInt(1, createdbyu);
				 				cStmt2.setInt(2, new_scheme_id);
				 				cStmt2.setString(3, "SUP");
				 				cStmt2.setString(4, "Scheme "+ schemecodeu + " updated in BSAT");
				 				cStmt2.registerOutParameter(5, Types.VARCHAR);
				 			ResultSet result = cStmt2.executeQuery();
				 			String flag = cStmt2.getString(5);
				 			System.out.println("scheme request mail flag "+ flag);
				 			
//				 			New Scheme 1718-ML7-497 is registered in BSAT
//				 			Scheme 1718-ML7-497 is updated in BSAT
				 			

				 			} catch (SQLException e) {
				 				// TODO Auto-generated catch block
				 				e.printStackTrace();
				 			}
				 		
				 		New_Scheme_mstr mstr = schememasterdao.schemeautofill(new_scheme_id);
						 if(mstr.getScheme_id() != Integer.parseInt(mstr.getScheme_srl_no())){
							 mstr.setScheme_srl_no(String.valueOf(mstr.getScheme_id()));
							 int srlSchemeId = schemerequestdao.saveheader(mstr);
							 System.out.println("srlSchemeId "+srlSchemeId);
						 }

				 		
				 		if(action.equals("SaveAndApprove")){
				 			
				 			int schemeid = scheme_id;
//				 			DateFormat ser1 = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
				 			DateFormat ser1 = new SimpleDateFormat("dd-MMM-yyyy");
				 			String dateStr1 = ser1.format(new Date());
				 			
				 			ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id="+scheme_id);
				 			
				 			if(dml.get(0).getScheme_type().equals("National")){
				 				System.out.println("In National Approver");
				 				String schemecode=dml.get(0).getScheme_code();
					 			int createdby=dml.get(0).getCreated_by();
					 			String status = dml.get(0).getActive_flag();
					 			ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdby);
					 			String createdby1=dml1.get(0).getUser_name();

					 			ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_name='HeadQuarter'");
					 			int HQApprover = dml2.get(0).getUser_id();
					 			
					 			System.out.println("Submition date = " +dateStr1);
					 			String query="update BPIL_SCHEME_MASTER set active_flag='Pending for HQ Approval', submission_date = '"+ dateStr1 +"'  WHERE scheme_id='"+schemeid+"'";				
					 			jdbctemplate.update(query); 
					 			System.out.println(".............................."+schemeid);
					 				
					 			
					 			 CallableStatement cStmt1;
					 				try {
					 				cStmt1 = hibernateConfiguration.dataSource()
					 						.getConnection().prepareCall("{call BSATV2_WF_NOTIFICATION_ENTRY(?,?,?,?)}");
					 				
					 				cStmt1.setInt(1,createdby);
					 				cStmt1.setInt(2,schemeid );
					 				cStmt1.setInt(3, HQApprover);
					 				cStmt1.registerOutParameter(4,Types.VARCHAR);
					 				ResultSet rs1 = cStmt1.executeQuery();
					 					 	
					 					String str111 =cStmt1.getString(4);
					 					System.out.println("msg is="+str111);
					 					
					 					
					 					CallableStatement cStmt2;	
					 					
					 					cStmt2 = hibernateConfiguration.dataSource().getConnection()
					 							.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
					 				

					 					cStmt2.setInt(1, createdby);
					 					cStmt2.setInt(2, schemeid);
					 					cStmt2.setString(3, "SA");
					 					cStmt2.setString(4, "Scheme "+ schemecode + " Submited for Approval to Head Quarter");
					 					cStmt2.registerOutParameter(5, Types.VARCHAR);
					 				ResultSet result = cStmt2.executeQuery();
					 				String flag = cStmt2.getString(5);
					 				System.out.println("scheme approval mail flag "+ flag);

					 					
					 				} catch (SQLException e) {
					 					e.printStackTrace();
					 				}
					 				catch (Exception e) {
					 					System.out.println(e.getMessage());
					 				}
					 				if(status.equals("Incomplete")) {
					 					return new ModelAndView("redirect:/pendingrequest");
					 				}
					 				else if(status.equals("Provisioned")) {
					 					return new ModelAndView("redirect:/reviewscheme");
					 				} else {
					 					return new ModelAndView("redirect:/pendingrequest");
					 				}
				 			}else if(dml.get(0).getScheme_type().equals("Regional")){
				 				System.out.println("In Regional Approver");
				 				String schemecode=dml.get(0).getScheme_code();
					 			int createdby=dml.get(0).getCreated_by();
					 			String status = dml.get(0).getActive_flag();
					 			ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdby);
					 			String createdby1=dml1.get(0).getUser_name();

					 			ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_name='National'");
					 			int NAApprover = dml2.get(0).getUser_id();
					 			
					 			System.out.println("Submition date = " +dateStr1);
					 			String query="update BPIL_SCHEME_MASTER set active_flag='Pending for NA Approval', submission_date = '"+ dateStr1 +"'  WHERE scheme_id='"+schemeid+"'";				
					 			jdbctemplate.update(query); 
					 			System.out.println(".............................."+schemeid);
					 			
					 			ArrayList<Bpil_notification> dml_notfication = (ArrayList<Bpil_notification>) hibernateTemplate.find("from Bpil_notification where scheme_id = "+schemeid+" and status = 'Pending'");
					 				
					 			if(dml_notfication.size()>0) {
					 				
					 			
					 			 CallableStatement cStmt1;
					 				try {
					 				cStmt1 = hibernateConfiguration.dataSource()
					 						.getConnection().prepareCall("{call BSATV2_WF_NOTIFICATION_ENTRY(?,?,?,?)}");
					 				
					 				cStmt1.setInt(1,createdby);
					 				cStmt1.setInt(2,schemeid );
					 				cStmt1.setInt(3, NAApprover);
					 				cStmt1.registerOutParameter(4,Types.VARCHAR);
					 				ResultSet rs1 = cStmt1.executeQuery();
					 					 	
					 					String str111 =cStmt1.getString(4);
					 					System.out.println("msg is="+str111);
					 					
					 					
					 					CallableStatement cStmt2;	
					 					
					 					cStmt2 = hibernateConfiguration.dataSource().getConnection()
					 							.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
					 				

					 					cStmt2.setInt(1, createdby);
					 					cStmt2.setInt(2, schemeid);
					 					cStmt2.setString(3, "SA");
					 					cStmt2.setString(4, "Scheme "+ schemecode + " Submited for Approval to National");
					 					cStmt2.registerOutParameter(5, Types.VARCHAR);
					 				ResultSet result = cStmt2.executeQuery();
					 				String flag = cStmt2.getString(5);
					 				System.out.println("scheme approval mail flag "+ flag);

					 					
					 				} catch (SQLException e) {
					 					e.printStackTrace();
					 				}
					 				catch (Exception e) {
					 					System.out.println(e.getMessage());
					 				}
					 				
				 			}
					 				if(status.equals("Incomplete")) {
					 					return new ModelAndView("redirect:/pendingrequest");
					 				}
					 				else if(status.equals("Provisioned")) {
					 					return new ModelAndView("redirect:/reviewscheme");
					 				} else {
					 					return new ModelAndView("redirect:/pendingrequest");
					 				}
				 			}else if(dml.get(0).getScheme_type().equals("Branch")){
				 				
				 				String status = dml.get(0).getActive_flag();
				 				if(!status.equals("Pending for RG Approval")) 
				 			
				 		{	
				 			
				 			
				 		
				 				System.out.println("Inside Pending for RG Approval");
				 				System.out.println("In Branch Approver");
				 				String schemecode=dml.get(0).getScheme_code();
					 			int createdby=dml.get(0).getCreated_by();
					 			
					 			ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdby);
					 			String createdby1=dml1.get(0).getUser_name();

					 			ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_name='Regional' and region_code = '"+dml1.get(0).getRegion_code()+"'");
					 			int RGApprover = dml2.get(0).getUser_id();
					 			
					 			System.out.println("Submition date = " +dateStr1);
					 			String query="update BPIL_SCHEME_MASTER set active_flag='Pending for RG Approval', submission_date = '"+ dateStr1 +"'  WHERE scheme_id='"+schemeid+"'";				
					 			jdbctemplate.update(query); 
					 			System.out.println(".............................."+schemeid);
					 				
					 			
					 			 CallableStatement cStmt1;
					 				try {
					 				cStmt1 = hibernateConfiguration.dataSource()
					 						.getConnection().prepareCall("{call BSATV2_WF_NOTIFICATION_ENTRY(?,?,?,?)}");
					 				
					 				cStmt1.setInt(1,createdby);
					 				cStmt1.setInt(2,schemeid );
					 				cStmt1.setInt(3, RGApprover);
					 				cStmt1.registerOutParameter(4,Types.VARCHAR);
					 				ResultSet rs1 = cStmt1.executeQuery();
					 					 	
					 					String str111 =cStmt1.getString(4);
					 					System.out.println("msg is="+str111);
					 					
					 					
					 					CallableStatement cStmt2;	
					 					
					 					cStmt2 = hibernateConfiguration.dataSource().getConnection()
					 							.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
					 				

					 					cStmt2.setInt(1, createdby);
					 					cStmt2.setInt(2, schemeid);
					 					cStmt2.setString(3, "SA");
					 					cStmt2.setString(4, "Scheme "+ schemecode + " Submited for Approval to Regional");
					 					cStmt2.registerOutParameter(5, Types.VARCHAR);
					 				ResultSet result = cStmt2.executeQuery();
					 				String flag = cStmt2.getString(5);
					 				System.out.println("scheme approval mail flag "+ flag);

					 					
					 				} catch (SQLException e) {
					 					e.printStackTrace();
					 				}
					 				catch (Exception e) {
					 					System.out.println(e.getMessage());
					 				}
/*************************** Put Mail Code Here***********************************************************************/		
					 	RenewedMailCommunication mail = new RenewedMailCommunication();
					 	String subject = "Scheme "+schemecode+" Requires Approval";
					 	String message1 = "<!DOCTYPE html>"
								+ "<html>"
								+ "<head>"
								
								+ "<style>"
								+ "p {"
								+ "display: block;"
								+ "margin-top: 1em;"
								+ "margin-bottom: 1em;"
								+ "margin-left: 0;"
								+ "margin-right: 0;"
								+ "font-family: Times New Roman, serif;"
								+ "font-size:14px;"
								+ "}"
								
								+ "</style>"
								
								+ "</head>"

								+ "<body>"
								+ "<p>"
								+ "Dear Manager,<br><br>"
								+ "Please be informed that <b>"+schemecode+"</b> is pending for your approval. You are requested to go through the scheme document attached with the scheme details and review the same.<br>"
								+ "The review must be more realistic in terms of overall purpose of scheme.<br><br>"
								+ "<br>Thanks & Regards,<br>" + "Marketing Manager<br>"
								+ "<br><br><br><br><br>"
								+ "Note : This is a system generated mail. Do not reply to this mail."
							    + "</body>"
								+ "</html>";
					 				mail.setSubject(subject);
					 				mail.setBody(message1);
					 				try {
										updatedSendMail(mail);
									} catch (MessagingException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
				 			}
					 				
/*************************** Put Mail Code Here***********************************************************************/				 				
					 				if(status.equals("Incomplete")) {
					 					return new ModelAndView("redirect:/pendingrequest");
					 				}
					 				else if(status.equals("Provisioned")) {
					 					return new ModelAndView("redirect:/reviewscheme");
					 				} else {
					 					return new ModelAndView("redirect:/pendingrequest");
					 				}
					 				
				 					
				 			}else if(dml.get(0).getScheme_type().equals("Sales") || dml.get(0).getScheme_type().equals("Commodity Research") || dml.get(0).getScheme_type().equals("Marketing Team")){
				 				System.out.println("In GeoJit Approver");
				 				String schemecode=dml.get(0).getScheme_code();
					 			int createdby=dml.get(0).getCreated_by();
					 			String status = dml.get(0).getActive_flag();
					 			ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdby);
					 			String createdby1=dml1.get(0).getUser_name();

					 			ArrayList<Bpil_Users> dml2 = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_name='Regional' and region_code = '"+dml1.get(0).getRegion_code()+"'");
					 			int RGApprover = dml2.get(0).getUser_id();
					 			
					 			System.out.println("Submition date = " +dateStr1);
					 			String query="update BPIL_SCHEME_MASTER set active_flag='Pending for RG Approval', submission_date = '"+ dateStr1 +"'  WHERE scheme_id='"+schemeid+"'";				
					 			jdbctemplate.update(query); 
					 			
					 			System.out.println(".............................."+schemeid);
					 				
					 			
					 			 CallableStatement cStmt1;
					 				try {
					 				cStmt1 = hibernateConfiguration.dataSource()
					 						.getConnection().prepareCall("{call BSATV2_WF_NOTIFICATION_ENTRY(?,?,?,?)}");
					 				
					 				cStmt1.setInt(1,createdby);
					 				cStmt1.setInt(2,schemeid );
					 				cStmt1.setInt(3, RGApprover);
					 				cStmt1.registerOutParameter(4,Types.VARCHAR);
					 				ResultSet rs1 = cStmt1.executeQuery();
					 					 	
					 					String str111 =cStmt1.getString(4);
					 					System.out.println("msg is="+str111);
					 					
					 					
					 					CallableStatement cStmt2;	
					 					
					 					cStmt2 = hibernateConfiguration.dataSource().getConnection()
					 							.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
					 				

					 					cStmt2.setInt(1, createdby);
					 					cStmt2.setInt(2, schemeid);
					 					cStmt2.setString(3, "SA");
					 					cStmt2.setString(4, "Scheme "+ schemecode + " Submited for Approval to Regional");
					 					cStmt2.registerOutParameter(5, Types.VARCHAR);
					 				ResultSet result = cStmt2.executeQuery();
					 				String flag = cStmt2.getString(5);
					 				System.out.println("scheme approval mail flag "+ flag);

					 					
					 				} catch (SQLException e) {
					 					e.printStackTrace();
					 				}
					 				catch (Exception e) {
					 					System.out.println(e.getMessage());
					 				}
					 				if(status.equals("Incomplete")) {
					 					return new ModelAndView("redirect:/pendingrequest");
					 				}
					 				else if(status.equals("Provisioned")) {
					 					return new ModelAndView("redirect:/reviewscheme");
					 				} else {
					 					return new ModelAndView("redirect:/pendingrequest");
					 				}
				 			}else{
				 				
				 				String schemecode=dml.get(0).getScheme_code();
					 			int createdby=dml.get(0).getCreated_by();
					 			String status = dml.get(0).getActive_flag();
					 			ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdby);
					 			String createdby1=dml1.get(0).getUser_name();
					 			
					 			
					 			System.out.println("Submition date = " +dateStr1);
					 			String query="update BPIL_SCHEME_MASTER set active_flag='Pending for Approval', submission_date = '"+ dateStr1 +"'  WHERE scheme_id='"+schemeid+"'";				
					 			jdbctemplate.update(query); 
					 			System.out.println(".............................."+schemeid);
					 				
					 			
					 			 CallableStatement cStmt1;
					 				try {
					 				cStmt1 = hibernateConfiguration.dataSource()
					 						.getConnection().prepareCall("{call BPIL_WF_NOTIFICATION_ENTRY(?,?,?)}");
					 				
					 				cStmt1.setInt(1,createdby);
					 				cStmt1.setInt(2,schemeid );
					 				cStmt1.registerOutParameter(3,Types.VARCHAR);
					 				ResultSet rs1 = cStmt1.executeQuery();
					 					 	
					 					String str111 =cStmt1.getString(3);
					 					System.out.println("msg is="+str111);
					 					
					 					
					 					CallableStatement cStmt2;	
					 					
					 					cStmt2 = hibernateConfiguration.dataSource().getConnection()
					 							.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
					 				
					 					cStmt2.setInt(1, createdby);
					 					cStmt2.setInt(2, schemeid);
					 					cStmt2.setString(3, "SA");
					 					cStmt2.setString(4, "Scheme "+ schemecode + " Submited for Approval to Supervisor");
					 					cStmt2.registerOutParameter(5, Types.VARCHAR);
					 				ResultSet result = cStmt2.executeQuery();
					 				String flag = cStmt2.getString(5);
					 				System.out.println("scheme approval mail flag "+ flag);
					 					
					 				} catch (SQLException e) {
					 					e.printStackTrace();
					 				}
					 				catch (Exception e) {
					 					System.out.println(e.getMessage());
					 				}
					 				if(status.equals("Incomplete")) {
					 					return new ModelAndView("redirect:/pendingrequest");
					 				}
					 				else if(status.equals("Provisioned")) {
					 					return new ModelAndView("redirect:/reviewscheme");
					 				} else {
					 					return new ModelAndView("redirect:/pendingrequest");
					 				}
				 			}
				 							 							 				
				 		}

			return new ModelAndView("redirect:/schemedetails?scheme_id="+new_scheme_id);		
	}

	
	@RequestMapping(value = "/copyupdatescheme_request", method = RequestMethod.POST)
	public ModelAndView copyupdatescheme_request(@ModelAttribute("New_Scheme_mstr") New_Scheme_mstr new_scheme,
			BindingResult resultkwm_users ,
			@RequestParam CommonsMultipartFile [] doc_file,
			@RequestParam CommonsMultipartFile [] doc_file1,
			HttpServletRequest request,Model model) {
		
		System.out.println("in ctrl");	
		String action = request.getParameter("action");
		int rev=new_scheme.getRevision() + 1;
		int rev1=0;
		int user_id = (Integer) request.getSession().getAttribute("userid");	
		int profile_id = (Integer) request.getSession().getAttribute("profileid");
		int scheme_id = schememasterdao.getLastSchemeId();
		scheme_id = scheme_id + 1;
		System.out.println("scheme Id in ctr "+scheme_id);
		
		
//		ArrayList<New_Scheme_mstr> Update_Schemes=(ArrayList<New_Scheme_mstr>)hibernateTemplate.find("from New_Scheme_mstr  where scheme_id=?",+new_scheme.getScheme_id());
		New_Scheme_mstr Update_Scheme = new New_Scheme_mstr();

		Date created_on = null;
		Date startdate = null;
		Date redemp_date = null;
		Date enddate = null;
		if(request.getParameter("redemption_date")!=null)
		{
				
				try {
					if (!request.getParameter("redemption_date").equals("")) {
						redemp_date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("redemption_date"));
						
						System.out.println(" "+redemp_date);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("start_date")!=null)
		{
				
				try {
					if (!request.getParameter("start_date").equals("")) {
						startdate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("start_date"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("end_date")!=null)
		{
				
				try {
					if (!request.getParameter("end_date").equals("")) {
						enddate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("end_date"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		/*
		if(profile_id==3)
		{			
		
		String str[] = request.getParameterValues("appl_depot_code1[]"); // string separate by ,
		String str1 = "";
		for(int i=0;i<str.length;i++)
		{
				System.out.println("in ctrl"+str[i]);
				str1+=str[i];
				
			    if(i<str.length-1) // Avoiding the last comma
			    {
			    	str1+=",";
			    }
		}
		
		new_scheme.setAppl_depot_code(str1);
		Update_Scheme.setAppl_depot_code(new_scheme.getAppl_depot_code());
		
		
		}
		*/
		
		String str[] = request.getParameterValues("appl_depot_code1[]"); // string separate by ,
		String str1 = "";
		
		Set<String> set = new HashSet<>();
		for(int j = 0; j< str.length; j ++){
			set.add(str[j]);
		}
		
		System.out.println("Set : "+set.toString());
		
		int line =0;
		if(request.getParameterValues("appl_depot_code1[]") != null ){
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
		}
			
//		if(request.getParameterValues("appl_depot_code1[]") != null)
//		{
//		for(int i=0;i<str.length;i++)
//		{
//				System.out.println("in ctrl"+str[i]);
//				str1+=str[i];
//				
//			    if(i<str.length-1) // Avoiding the last comma
//			    {
//			    	str1+=",";
//			    }
//		}
//		}
		

		new_scheme.setAppl_depot_code(str1);
		
		new_scheme.setStart_date(startdate);
		new_scheme.setEnd_date(enddate);
		new_scheme.setCreated_by(new_scheme.getCreated_by());
		new_scheme.setLast_updated_by(new_scheme.getCreated_by());
		new_scheme.setActive_flag("Incomplete");		
		new_scheme.setRedemption_date(redemp_date);
		
		Update_Scheme.setAppl_depot_code(new_scheme.getAppl_depot_code());
		Update_Scheme.setAppl_regn_code(new_scheme.getAppl_regn_code());
		Update_Scheme.setStart_date(new_scheme.getStart_date());
		Update_Scheme.setEnd_date(new_scheme.getEnd_date());
		Update_Scheme.setCreated_by(new_scheme.getCreated_by());
		Update_Scheme.setLast_updated_by(new_scheme.getLast_updated_by());
		Update_Scheme.setActive_flag(new_scheme.getActive_flag());
		Update_Scheme.setRedemption_date(new_scheme.getRedemption_date());
		Update_Scheme.setRevision(new_scheme.getRevision() + 1);
		
//		if(new_scheme.getParent_scheme_code() != null && new_scheme.getParent_scheme_code() != "") {
//	        
//			ArrayList<New_Scheme_mstr> ps = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id = '"+new_scheme.getParent_scheme_code()+"'");
//
//			if(!ps.isEmpty()){
//			new_scheme.setParent_scheme_name(ps.get(0).getScheme_name());
//			}
//	        }

		
		if(request.getParameter("created_on")!=null)
		{			
				try {
					if (!request.getParameter("created_on").equals("")) {
						created_on = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("created_on"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		new_scheme.setCreation_date(created_on);
		
		Update_Scheme.setCreation_date(new_scheme.getCreation_date());
		
		Update_Scheme.setScheme_name(new_scheme.getScheme_name());
		Update_Scheme.setScheme_id(scheme_id);
		Update_Scheme.setScheme_srl_no(new_scheme.getScheme_code().substring(10, 13));
		Update_Scheme.setScheme_type(new_scheme.getScheme_type());
		
		String scheme_code = new_scheme.getScheme_code().substring(0, 9);
        scheme_code = scheme_code+scheme_id;
		
		Update_Scheme.setScheme_code(scheme_code);
		Update_Scheme.setScheme_budget(new_scheme.getScheme_budget());
		Update_Scheme.setObjective(new_scheme.getObjective());
		Update_Scheme.setAttribute1(new_scheme.getAttribute1());
		Update_Scheme.setAttribute2(new_scheme.getAttribute2());
		Update_Scheme.setAttribute3(new_scheme.getAttribute3());
		Update_Scheme.setRevision(1);
		
		Update_Scheme.setProvision_id(new_scheme.getProvision_id());
		Update_Scheme.setBudget_available(new_scheme.getBudget_available());
		Update_Scheme.setFin_analysis_flag(new_scheme.getFin_analysis_flag());
		Update_Scheme.setScheme_fin_month(new_scheme.getScheme_fin_month());
		Update_Scheme.setScheme_fin_yr(new_scheme.getScheme_fin_yr());
		Update_Scheme.setProvision_comments(new_scheme.getProvision_comments());
		Update_Scheme.setScheme_business_line(new_scheme.getScheme_business_line());
		Update_Scheme.setReference_sch_id(new_scheme.getReference_sch_id());
		Update_Scheme.setSch_reward_eff_price(new_scheme.getSch_reward_eff_price());
		Update_Scheme.setConfidence_pct(new_scheme.getConfidence_pct());
		Update_Scheme.setOutflow(new_scheme.getOutflow());
		Update_Scheme.setLast_update_date(new Date());
		Update_Scheme.setVolume_growth(new_scheme.getVolume_growth());
		Update_Scheme.setValue_growth(new_scheme.getValue_growth());
		Update_Scheme.setSpraid(new_scheme.getSpraid());
		
//			int new_scheme_id = schemerequestdao.saveheader(new_scheme);
			int new_scheme_id = schemerequestdao.saveheader(Update_Scheme);
		
			
/////save doc	 scheme realted
		String	scheme_document_comment = request.getParameter("scheme_document_comment");
			
			   if (null != doc_file && doc_file.length>0) 
		        {
		            for (MultipartFile multipartFile : doc_file) {
		 
		            	Bpil_Scheme_Doc docs = new Bpil_Scheme_Doc();
		            	
		                String fileName = multipartFile.getOriginalFilename();
		                
		                try {
							docs.setDoc_file(multipartFile.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
		                docs.setDoc_title(multipartFile.getOriginalFilename());
		                docs.setDoc_type("Scheme Document");
		                docs.setScheme_id(Update_Scheme.getScheme_id());
		                docs.setComments(scheme_document_comment);
		                docs.setLast_update_date(new Date());
		                
		                 long size = multipartFile.getSize();
		                if(size>0)
		                {
//		                	rev=new_scheme.getRevision();
//			                rev=rev+1;
			                docs.setRevision(Update_Scheme.getRevision());
			                
		                 int doc_id = schemerequestdao.savedocs(docs);
		                }
		                 
		            }
		        }
					 
			   new_scheme.setRevision(Update_Scheme.getRevision());
			   String sr_no = Integer.toString(new_scheme_id);
			   new_scheme.setScheme_srl_no(sr_no);
			   
//			   int new_scheme_id2 = schemerequestdao.saveheader(new_scheme);   

////save doc	others
				
			   String	other_document_comment = request.getParameter("other_document_comment");
			   
				   if (null != doc_file1 && doc_file1.length>0) 
			        {
			            for (MultipartFile multipartFile : doc_file1) {
			 
			            	Bpil_Scheme_Doc docs = new Bpil_Scheme_Doc();
			            	
			                String fileName = multipartFile.getOriginalFilename();
			                
			                try {
								docs.setDoc_file(multipartFile.getBytes());
							} catch (IOException e) {
								e.printStackTrace();
							}
			                docs.setDoc_title(multipartFile.getOriginalFilename());
			                docs.setDoc_type("Other Document");
			                docs.setScheme_id(Update_Scheme.getScheme_id());
			                docs.setComments(other_document_comment);
			                
//			                rev1=new_scheme.getRevision();			              
			                docs.setRevision(Update_Scheme.getRevision());
			                docs.setLast_update_date(new Date());
			                
			                 long size = multipartFile.getSize();
			                if(size>0)
			                {
			                 int doc_id = schemerequestdao.savedocs(docs);
			                }
			                 
			            }
			        }
				   
/// save scheme cust type
				   
				   if(request.getParameter("cust_type")!=null) {
					   String cust_type[] = request.getParameterValues("cust_type");
					   
					   int custlen = cust_type.length;
					   
					   int prod_id = schemerequestdao.savecust_type(custlen, cust_type, new_scheme_id);
				   }

				   
//// save product info
		String str2 = "";
		 if(request.getParameter("sch_prd_line_type")!=null && request.getParameter("sch_prd_exceptions")!=null && request.getParameter("sch_product_id")!=null && request.getParameter("vol_grwth_pct")!=null && request.getParameter("val_grwth_pct")!=null &&  request.getParameter("spread_pct")!=null && request.getParameter("spend_per_ltr")!=null)
		 {	   
			String sch_prd_unique_id[] = request.getParameterValues("sch_prd_unique_id"); 			
			String sch_prd_line_type[] = request.getParameterValues("sch_prd_line_type");
			String sch_product_id[] = request.getParameterValues("sch_product_id");
			String sch_prd_exceptions[] = request.getParameterValues("sch_prd_exceptions");
			String vol_grwth_pct[] = request.getParameterValues("vol_grwth_pct");
			String val_grwth_pct[] = request.getParameterValues("val_grwth_pct");
			String spread_pct[] = request.getParameterValues("spread_pct");			
			String spend_per_ltr[] = request.getParameterValues("spend_per_ltr");
			
			int len1 = vol_grwth_pct.length;				 
				 
//				 int prod_id = schemerequestdao.saveproduct(len1,new_scheme_id,sch_prd_unique_id,sch_prd_line_type,sch_product_id,sch_prd_exceptions,vol_grwth_pct,val_grwth_pct,spread_pct,spend_per_ltr);  
								
					for(int i=0;i<sch_product_id.length;i++)
					{
							System.out.println("in ctrl"+sch_product_id[i]);
							str2+=sch_product_id[i];
							
						    if(i<sch_product_id.length-1) // Avoiding the last comma
						    {
						    	str2+=",";
						    }
					}
				 
		 }
				//	new_scheme.setAttribute2(scheme_document_comment);  //scheme doc comments
				//	new_scheme.setAttribute3(other_document_comment);  //oyher doc comments
					new_scheme.setSch_product_codes(str2);
//				 int new_scheme_id1 = schemerequestdao.saveheader(new_scheme);
					
					//// save product outflow info
					 
					String str3 = "";
				  if(request.getParameter("sch_prd_outflow_line_type")!=null && request.getParameter("sch_product_outflow_id")!=null 
						  && request.getParameter("sch_prd_lly_vol")!=null && request.getParameter("sch_prd_lly_val")!=null 
						  && request.getParameter("sch_prd_ly_vol")!=null &&  request.getParameter("sch_prd_ly_val")!=null
						  && request.getParameter("sch_prd_spread_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_tgt_val")!=null
						  && request.getParameter("sch_prd_spread_mtd_ly_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ly_val")!=null
						  && request.getParameter("proj_grwth_vol_pct")!=null && request.getParameter("proj_grwth_val_pct")!=null
						  && request.getParameter("proj_grwth_spd_pct")!=null
						  && request.getParameter("sch_prd_ty_vol")!=null &&  request.getParameter("sch_prd_ty_val")!=null 
						  && request.getParameter("sch_prd_spread_mtd_ty_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ty_tgt_val")!=null 
						  && request.getParameter("sch_prd_wt_avg")!=null &&  request.getParameter("sch_prd_total_prd_bdgt")!=null)
						   {
					String sch_prd_outflow_unique_id[] = request.getParameterValues("sch_prd_outflow_unique_id");
					String sch_prd_outflow_line_type[] = request.getParameterValues("sch_prd_outflow_line_type");
					String sch_product_outflow_id[] = request.getParameterValues("sch_product_outflow_id");
					String sch_prd_lly_vol[] = request.getParameterValues("sch_prd_lly_vol");
					String sch_prd_lly_val[] = request.getParameterValues("sch_prd_lly_val");
					String sch_prd_ly_vol[] = request.getParameterValues("sch_prd_ly_vol");
					String sch_prd_ly_val[] = request.getParameterValues("sch_prd_ly_val");			
					String sch_prd_spread_tgt_vol[] = request.getParameterValues("sch_prd_spread_tgt_vol");
					String sch_prd_spread_tgt_val[] = request.getParameterValues("sch_prd_spread_tgt_val");
					String sch_prd_spread_mtd_ly_vol[] = request.getParameterValues("sch_prd_spread_mtd_ly_vol");
					String sch_prd_spread_mtd_ly_val[] = request.getParameterValues("sch_prd_spread_mtd_ly_val");
					String proj_grwth_vol_pct[] = request.getParameterValues("proj_grwth_vol_pct");
					String proj_grwth_val_pct[] = request.getParameterValues("proj_grwth_val_pct");
					String proj_grwth_spd_pct[] = request.getParameterValues("proj_grwth_spd_pct");
					String sch_prd_ty_vol[] = request.getParameterValues("sch_prd_ty_vol");
					String sch_prd_ty_val[] = request.getParameterValues("sch_prd_ty_val");
					String sch_prd_spread_mtd_ty_tgt_vol[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_vol");
					String sch_prd_spread_mtd_ty_tgt_val[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_val");
					String sch_prd_wt_avg[] = request.getParameterValues("sch_prd_wt_avg");			
					String sch_prd_total_prd_bdgt[] = request.getParameterValues("sch_prd_total_prd_bdgt");
					
					int len1 = sch_product_outflow_id.length;				 
						 
						 int prod_id = schemerequestdao.copysaveproductoutflow(len1,new_scheme_id,
								 sch_prd_outflow_unique_id,sch_prd_outflow_line_type,sch_product_outflow_id,
								 sch_prd_lly_vol,sch_prd_lly_val,sch_prd_ly_vol,sch_prd_ly_val,
								 sch_prd_spread_tgt_vol,sch_prd_spread_tgt_val,
								 sch_prd_spread_mtd_ly_vol,sch_prd_spread_mtd_ly_val,
								 proj_grwth_vol_pct,proj_grwth_val_pct,proj_grwth_spd_pct,sch_prd_ty_vol,sch_prd_ty_val,
								 sch_prd_spread_mtd_ty_tgt_vol,sch_prd_spread_mtd_ty_tgt_val,
								 sch_prd_wt_avg,sch_prd_total_prd_bdgt);  
						   
						for(int i=0;i<sch_product_outflow_id.length;i++)
							{
									System.out.println("in ctrl"+sch_product_outflow_id[i]);
									str3+=sch_product_outflow_id[i];
									
								    if(i<sch_product_outflow_id.length-1) // Avoiding the last comma
								    {
								    	str3+=",";
								    }
							}
							
				 }
						 
						
							new_scheme.setAttribute5(str3);
//						 int new_scheme_id1 = schemerequestdao.saveheader(new_scheme);
	
							
				 
//// save sheme gift
	 if(request.getParameter("gift_code")!=null  && request.getParameter("gift_group")!=null && request.getParameter("gift_name")!=null && request.getParameter("effective_price")!=null )
		 {
//			String str[] = request.getParameterValues("appl_depot_code1[]"); // string separate by ,
			String[] sche_code = request.getParameterValues("gift_code");
			String[] gift_id = request.getParameterValues("gift_id");
			String[] gift_group = request.getParameterValues("gift_group");
			String[] gift_name = request.getParameterValues("gift_name");			
			String[] effective_price = request.getParameterValues("effective_price");
			int len = gift_group.length;
				
			 int schemegift_id = schemerequestdao.copysavegift(user_id,new_scheme_id,len,sche_code,gift_id,gift_group,gift_name,effective_price);  
			 	   
		}
	 
/////////// entry into depots table
	 
	 int revsion = new_scheme.getRevision();
	   
					   CallableStatement cStmt;
				 		try {
				 		cStmt = hibernateConfiguration.dataSource()
								.getConnection().prepareCall("{call BPIL_POPULATE_SCH_DEPOT_DTLS(?,?,?,?)}");
				 		 									 		
				 		
				 		cStmt.setInt(1, new_scheme_id);
				 		cStmt.setInt(2,revsion);	
				 		cStmt.setInt(3, user_id);
				 		cStmt.registerOutParameter(4,Types.VARCHAR); 
				 		ResultSet rs1 = cStmt.executeQuery();
				 			 	
				 			String str111 =cStmt.getString(4);
				 			System.out.println("msg is="+str111);
				
				 		} catch (SQLException e) {
				 		e.printStackTrace();
				 		}
				 		catch (Exception e) {
				 		System.out.println(e.getMessage());
				 		}
				 		
				 		ArrayList<New_Scheme_mstr> sm = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id="+new_scheme_id);
						String schemecodeu=sm.get(0).getScheme_code();
						int createdbyu=sm.get(0).getCreated_by();
						ArrayList<Bpil_Users> su = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdbyu);
						String createdbyu1=su.get(0).getUser_name();
				 		
				 		try {
				 			CallableStatement cStmt2;	
				 			
				 				cStmt2 = hibernateConfiguration.dataSource().getConnection()
				 						.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
				 			

				 				cStmt2.setInt(1, createdbyu);
				 				cStmt2.setInt(2, new_scheme_id);
				 				cStmt2.setString(3, "SUP");
				 				cStmt2.setString(4, "Scheme "+ schemecodeu + " updated in BSAT");
				 				cStmt2.registerOutParameter(5, Types.VARCHAR);
				 			ResultSet result = cStmt2.executeQuery();
				 			String flag = cStmt2.getString(5);
				 			System.out.println("scheme request mail flag "+ flag);
				 			
//				 			New Scheme 1718-ML7-497 is registered in BSAT
//				 			Scheme 1718-ML7-497 is updated in BSAT
				 			

				 			} catch (SQLException e) {
				 				// TODO Auto-generated catch block
				 				e.printStackTrace();
				 			}

				 		New_Scheme_mstr mstr = schememasterdao.schemeautofill(new_scheme_id);
						 if(mstr.getScheme_id() != Integer.parseInt(mstr.getScheme_srl_no())){
							 mstr.setScheme_srl_no(String.valueOf(mstr.getScheme_id()));
							 int srlSchemeId = schemerequestdao.saveheader(mstr);
							 System.out.println("srlSchemeId "+srlSchemeId);
						 }
				 		
				 		if(action.equals("SaveAndApprove")){
				 			
				 			int schemeid = scheme_id;
//				 			DateFormat ser1 = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
				 			DateFormat ser1 = new SimpleDateFormat("dd-MMM-yyyy");
				 			String dateStr1 = ser1.format(new Date());
				 			
				 			ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id="+scheme_id);
				 			String schemecode=dml.get(0).getScheme_code();
				 			int createdby=dml.get(0).getCreated_by();
				 			String status = dml.get(0).getActive_flag();
				 			ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdby);
				 			String createdby1=dml1.get(0).getUser_name();
				 			
				 			
				 			System.out.println("Submition date = " +dateStr1);
				 			String query="update BPIL_SCHEME_MASTER set active_flag='Pending for Approval', submission_date = '"+ dateStr1 +"'  WHERE scheme_id='"+schemeid+"'";				
				 			jdbctemplate.update(query); 
				 			System.out.println(".............................."+schemeid);
				 				
				 			
				 			 CallableStatement cStmt1;
				 				try {
				 				cStmt1 = hibernateConfiguration.dataSource()
				 						.getConnection().prepareCall("{call BPIL_WF_NOTIFICATION_ENTRY(?,?,?)}");
				 				
				 				cStmt1.setInt(1,createdby);
				 				cStmt1.setInt(2,schemeid );
				 				cStmt1.registerOutParameter(3,Types.VARCHAR);
				 				ResultSet rs1 = cStmt1.executeQuery();
				 					 	
				 					String str111 =cStmt1.getString(3);
				 					System.out.println("msg is="+str111);
				 					
				 					
				 					CallableStatement cStmt2;	
				 					
				 					cStmt2 = hibernateConfiguration.dataSource().getConnection()
				 							.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
				 				

				 					cStmt2.setInt(1, createdby);
				 					cStmt2.setInt(2, schemeid);
				 					cStmt2.setString(3, "SA");
				 					cStmt2.setString(4, "Scheme "+ schemecode + " Submited for Approval to Supervisor");
				 					cStmt2.registerOutParameter(5, Types.VARCHAR);
				 				ResultSet result = cStmt2.executeQuery();
				 				String flag = cStmt2.getString(5);
				 				System.out.println("scheme approval mail flag "+ flag);

				 					
				 				} catch (SQLException e) {
				 					e.printStackTrace();
				 				}
				 				catch (Exception e) {
				 					System.out.println(e.getMessage());
				 				}
				 				if(status.equals("Incomplete")) {
				 					return new ModelAndView("redirect:/pendingrequest");
				 				}
				 				else if(status.equals("Provisioned")) {
				 					return new ModelAndView("redirect:/reviewscheme");
				 				} else {
				 					return new ModelAndView("redirect:/pendingrequest");
				 				}
				 		}
				 		
				 		

			return new ModelAndView("redirect:/schemedetails?scheme_id="+new_scheme_id);		
	}
	
	
	@RequestMapping(value = "/getschemegroup1", method = RequestMethod.GET)
	public void getschemegroup1( @RequestParam(value="groupname") String groupname ,HttpServletRequest request,Model model,HttpServletResponse response) {
								
		 	try {
		 		System.out.println("Group mane :"+groupname);
		 		// changes by pramila order by
	ArrayList<Bpil_Gift_Master> dml = (ArrayList<Bpil_Gift_Master>) hibernateTemplate.find("from Bpil_Gift_Master where gift_group = "+"'"+groupname+"'"+"order by gift_name");
			 
			 String json = null;
			 
			 json = new Gson().toJson(dml);
			 response.setContentType("application/json");
			 response.getWriter().write(json);
			 } catch (IOException e) {
			 	e.printStackTrace();
			 }
		
	}
	
	@RequestMapping(value = "/getgiftcode", method = RequestMethod.GET)
	public void getgiftcode( @RequestParam(value="groupname") String groupname ,HttpServletRequest request,Model model,HttpServletResponse response) {
								
		 	try {
		 		if (groupname != null && groupname != "") {
		 		int gift_id = Integer.parseInt(groupname);
		 		
	ArrayList<Bpil_Gift_Master> dml = (ArrayList<Bpil_Gift_Master>) hibernateTemplate.find("from Bpil_Gift_Master where gift_id= "+gift_id);
			 
	String gift_code = dml.get(0).getGift_code();
	Bpil_Gift_Master gift= dml.get(0);
	
			 String json = null;
			 
			 json = new Gson().toJson(gift);
			 response.setContentType("application/json");
			 response.getWriter().write(json);
		 		}
			 } catch (IOException e) {
			 	e.printStackTrace();
			 }
		
	}
	
	// for change status to requested
	@RequestMapping("/statusrequested")
	public ModelAndView statusrequested12(@RequestParam (value="scheme_id") String scheme_id,@RequestParam (value="budget") String budget,HttpServletRequest request,Model model) {
		
		int id1=Integer.parseInt(scheme_id);
		float budget1=Float.parseFloat(budget);
		String status="Requested";
//		DateFormat ser1 = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
		DateFormat ser1 = new SimpleDateFormat("dd-MMM-yyyy");
		String dateStr1 = ser1.format(new Date());
//		System.out.println("Submition date = " +dateStr1);
		String query="update BPIL_SCHEME_MASTER set active_flag='"+status+"',scheme_budget='"+budget1+"', submission_date = '"+ dateStr1 +"' WHERE scheme_id='"+id1+"'";				
		jdbctemplate.update(query); 
//		System.out.println("done");
		
		ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id="+scheme_id);
		String schemecode=dml.get(0).getScheme_code();
		int createdby=dml.get(0).getCreated_by();
		ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdby);
		String createdby1=dml1.get(0).getUser_name();
		try {
		CallableStatement cStmt;	
		
			cStmt = hibernateConfiguration.dataSource().getConnection()
					.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
		

			cStmt.setInt(1, createdby);
			cStmt.setInt(2, id1);
			cStmt.setString(3, "SI");
			cStmt.setString(4, "Scheme "+ schemecode + " Request Submited to IT");
			cStmt.registerOutParameter(5, Types.VARCHAR);
		ResultSet result = cStmt.executeQuery();
		String flag = cStmt.getString(5);
		System.out.println("scheme request mail flag "+ flag);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String mailto="akashshelar@omfysgroup.com";
//		NotifyDealer n1=new NotifyDealer();
		
//		n1.NewScheme(schemename,mailto,createdby1);
	return new ModelAndView("redirect:/pendingrequest");		
	}
	
	
	@RequestMapping(value = "/loadscheme", method = RequestMethod.GET)
	public void loadscheme(HttpServletRequest request,Model model,HttpServletResponse response) {
								
		 	try {
		 		
		 		int user_id = (Integer) request.getSession().getAttribute("userid");
		 		int profile_id = (Integer) request.getSession().getAttribute("profileid");
		 		
		 		ArrayList<New_Scheme_mstr> dml = new ArrayList<New_Scheme_mstr>();
		 		if(profile_id == 6){
		 		
		 			dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("select sm from New_Scheme_mstr sm, Bpil_Users bu where sm.active_flag='Closed' and bu.pmg_ml_group = sm.scheme_business_line and bu.user_id = "+user_id);
			 
		 		}
		 		else {
		 			dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("select sm from New_Scheme_mstr sm where sm.active_flag='Closed' ");
		 		}
			 String json = null;
			 
			 json = new Gson().toJson(dml);
			 response.setContentType("application/json");
			 response.getWriter().write(json);
			 } catch (IOException e) {
			 	e.printStackTrace();
			 }
		
	}
	
	
	
	@RequestMapping(value = "/loadschemedata", method = RequestMethod.GET)
	public void loadschemedata(@RequestParam(value = "scheme") String scheme,HttpServletRequest request,Model model,HttpServletResponse response) {
								
		 	try {
		 		System.out.println("scheme "+scheme);
		 		ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id='"+scheme+"'");
		 		
		 					 
			 String json = null;
			 
			 json = new Gson().toJson(dml);
			 response.setContentType("application/json");
			 response.getWriter().write(json);
			 } catch (IOException e) {
			 	e.printStackTrace();
			 }
		
	}
	
		
	@RequestMapping(value = "/pendingrequest")
	public ModelAndView pendingrequest(HttpServletRequest request,Model model,HttpServletResponse response) {
		
		int user_id = (Integer) request.getSession().getAttribute("userid");
		int profile_id = (Integer) request.getSession().getAttribute("profileid");
		
		if(profile_id == 6){
		
			String PMG_ML_Group = (String) request.getSession().getAttribute("PMG_ML_grp");
			
//		ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where created_by = "+user_id+" and (active_flag='Incomplete' or active_flag='Cancel' or active_flag='Rejected') ");
		
		ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_business_line = '"+ PMG_ML_Group + "' and (active_flag='Incomplete' or active_flag='Cancel' or active_flag='Rejected') ");
		
		model.addAttribute("Pendinglist",dml);
		
		} else
		
		if(profile_id == 3){
			
			ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where (active_flag='Incomplete' or active_flag='Cancel' or active_flag='Rejected') ");
			model.addAttribute("Pendinglist",dml);
			
			}
		
	return new ModelAndView("Pending_Scheme");		
	}
	
	
	/**************** Submit for approval request ***************/
	@RequestMapping(value = "/submitforapprovalrequest")
	public ModelAndView aprrovalrequest(HttpServletRequest request,Model model,HttpServletResponse response) {
		
		int user_id = (Integer) request.getSession().getAttribute("userid");
		int profile_id = (Integer) request.getSession().getAttribute("profileid");
		
		if(profile_id == 6){
		
			String PMG_ML_Group = (String) request.getSession().getAttribute("PMG_ML_grp");
			
//		ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where created_by = "+user_id+" and (active_flag='Incomplete' or active_flag='Cancel' or active_flag='Rejected') ");
		
		ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_business_line = '"+ PMG_ML_Group + "' and (active_flag='Incomplete' or active_flag='Cancel' or active_flag='Rejected') ");
		
		model.addAttribute("Pendinglist",dml);
		
		} else
		
		if(profile_id == 3){
			
			ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where (active_flag='Incomplete' or active_flag='Cancel' or active_flag='Rejected') ");
			model.addAttribute("Pendinglist",dml);
			
			}
		
	return new ModelAndView("Approval_Scheme");		
	}
	
	
	/*------------------------- active scheme or cancle scheme by IT --------------------------*/
	
	@RequestMapping(value = "/ITschemerequest", method = RequestMethod.POST)
	public ModelAndView ITschemerequest(@ModelAttribute("New_Scheme_mstr") New_Scheme_mstr new_scheme,
			BindingResult resultkwm_users ,
			@RequestParam CommonsMultipartFile [] doc_file,
			HttpServletRequest request,Model model) {
		
		
		
		
		System.out.println("The start date is____ "+request.getParameter("start_date"));
		System.out.println("The end date is____ "+request.getParameter("end_date"));
		
		System.out.println("The Redemption date is____ "+request.getParameter("redemption_date"));
		
		int user_id = (Integer) request.getSession().getAttribute("userid");	
		int new_scheme_id=0;
		String actionname = request.getParameter("action");
	if(actionname.equals("Active scheme"))
	{		
		
		int revsion = new_scheme.getRevision();
		Date created_on = null;
		Date startdate = null;
		Date redemp_date = null;
		Date enddate = null;

		ArrayList<New_Scheme_mstr> Update_Schemes=(ArrayList<New_Scheme_mstr>)hibernateTemplate.find("from New_Scheme_mstr  where scheme_id="+new_scheme.getScheme_id());
		New_Scheme_mstr Update_Scheme = Update_Schemes.get(0);

		if(request.getParameter("redemption_date")!=null)
		{
				
				try {
					if (!request.getParameter("redemption_date").equals("")) {
						redemp_date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("redemption_date"));
						
						System.out.println("tttttttttttttttttttttttttttttttttttttttttttt "+redemp_date);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("start_date")!=null)
		{
				
				try {
					if (!request.getParameter("start_date").equals("")) {
						startdate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("start_date"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("end_date")!=null)
		{
				
				try {
					if (!request.getParameter("end_date").equals("")) {
						enddate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("end_date"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		if(request.getParameter("created_on")!=null)
		{				
				try {
					if (!request.getParameter("created_on").equals("")) {
						created_on = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("created_on"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		String str[] = request.getParameterValues("sel_depo"); // string separate by ,
		String str1 = "";
		
		Set<String> set = new HashSet<>();
		for(int j = 0; j< str.length; j ++){
			set.add(str[j]);
		}
		
		System.out.println("Set : "+set.toString());
		
		int line =0;
		if(request.getParameterValues("sel_depo") != null ){
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
		}
		
//		if(request.getParameterValues("appl_depot_code1[]") != null)
//		{
//		for(int i=0;i<str.length;i++)
//		{
//				System.out.println("in ctrl"+str[i]);
//				str1+=str[i];
//				
//			    if(i<str.length-1) // Avoiding the last comma
//			    {
//			    	str1+=",";
//			    }
//		}
//		}
		new_scheme.setRedemption_date(redemp_date);

		new_scheme.setAppl_depot_code(str1);
		new_scheme.setStart_date(startdate);
		new_scheme.setEnd_date(enddate);
		new_scheme.setCreation_date(created_on);		
		new_scheme.setCreated_by(user_id);
		new_scheme.setLast_updated_by(user_id);
		if(new_scheme.getFin_analysis_flag().equals("Y")) {
			new_scheme.setActive_flag("Review");
		} else if(new_scheme.getFin_analysis_flag().equals("N")) {
			new_scheme.setActive_flag("Ready To Launch");
		}
		
		Update_Scheme.setRedemption_date(new_scheme.getRedemption_date());
		Update_Scheme.setAppl_depot_code(new_scheme.getAppl_depot_code());
		Update_Scheme.setAppl_regn_code(new_scheme.getAppl_regn_code());
		Update_Scheme.setStart_date(new_scheme.getStart_date());
		Update_Scheme.setEnd_date(new_scheme.getEnd_date());
		Update_Scheme.setCreation_date(new_scheme.getCreation_date());
		Update_Scheme.setCreated_by(new_scheme.getCreated_by());
		Update_Scheme.setLast_updated_by(new_scheme.getLast_updated_by());
		Update_Scheme.setActive_flag(new_scheme.getActive_flag());
		
		Update_Scheme.setSch_dir_name(new_scheme.getSch_dir_name());
		Update_Scheme.setFin_an_batch_file(new_scheme.getFin_an_batch_file());
		Update_Scheme.setSch_an_batch_file(new_scheme.getSch_an_batch_file());
		Update_Scheme.setPrc_rw_batch_file(new_scheme.getPrc_rw_batch_file());
		Update_Scheme.setSch_opa_url(new_scheme.getSch_opa_url());
		Update_Scheme.setOpa_whatif_url(new_scheme.getOpa_whatif_url());
		Update_Scheme.setOpa_sch_an_name(new_scheme.getOpa_sch_an_name());
		Update_Scheme.setAttribute4(new_scheme.getAttribute4());
		Update_Scheme.setAttribute5(new_scheme.getAttribute5());
		Update_Scheme.setLast_update_date(new Date());
		
//		if(new_scheme.getParent_scheme_code() != null && new_scheme.getParent_scheme_code() != "") {
//	        
//			ArrayList<New_Scheme_mstr> ps = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id = '"+new_scheme.getParent_scheme_code()+"'");
//			if(!ps.isEmpty()){
//			new_scheme.setParent_scheme_name(ps.get(0).getScheme_name());
//			}
//	        }

		
//			 new_scheme_id = schemerequestdao.saveheader(new_scheme);
			 new_scheme_id = schemerequestdao.saveheader(Update_Scheme);
			
//////////save doc	
			 /*  if (null != doc_file) 
		        {
		            for (MultipartFile multipartFile : doc_file) {
		 
		            	Bpil_Scheme_Doc docs = new Bpil_Scheme_Doc();
		            	
		                String fileName = multipartFile.getOriginalFilename();
		                
		                try {
							docs.setDoc_file(multipartFile.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
		                docs.setDoc_title(multipartFile.getOriginalFilename());
		                docs.setDoc_type(multipartFile.getContentType());
		                docs.setScheme_id(new_scheme_id);
		                
		                 int doc_id = schemerequestdao.savedocs(docs);
		            }
		        }
 			 	*/
			 
			 
		//// save product info

			 String str11 = "";
			 if(request.getParameter("sch_prd_line_type")!=null && request.getParameter("sch_prd_exceptions")!=null && request.getParameter("sch_product_id")!=null && request.getParameter("vol_grwth_pct")!=null && request.getParameter("val_grwth_pct")!=null &&  request.getParameter("spread_pct")!=null && request.getParameter("spend_per_ltr")!=null)
			 {
				String sch_prd_unique_id[] = request.getParameterValues("sch_prd_unique_id"); 			
				String sch_prd_line_type[] = request.getParameterValues("sch_prd_line_type");
				String sch_product_id[] = request.getParameterValues("sch_product_id");
				String sch_prd_exceptions[] = request.getParameterValues("sch_prd_exceptions");
				String vol_grwth_pct[] = request.getParameterValues("vol_grwth_pct");
				String val_grwth_pct[] = request.getParameterValues("val_grwth_pct");
				String spread_pct[] = request.getParameterValues("spread_pct");			
				String spend_per_ltr[] = request.getParameterValues("spend_per_ltr");
				
				int len1 = vol_grwth_pct.length;				 
					 
//					 int prod_id = schemerequestdao.saveproduct(len1,new_scheme_id,sch_prd_unique_id,sch_prd_line_type,sch_product_id,sch_prd_exceptions,vol_grwth_pct,val_grwth_pct,spread_pct,spend_per_ltr);  
					
						for(int i=0;i<sch_product_id.length;i++)
						{
								System.out.println("in ctrl"+sch_product_id[i]);
								str11+=sch_product_id[i];
								
							    if(i<sch_product_id.length-1) // Avoiding the last comma
							    {
							    	str11+=",";
							    }
						}
			 }
					 new_scheme.setSch_product_codes(str11);
//					 int new_scheme_id1 = schemerequestdao.saveheader(new_scheme);
					 
						//// save product outflow info
					 
						String str3 = "";
					  if(request.getParameter("sch_prd_outflow_line_type")!=null && request.getParameter("sch_product_outflow_id")!=null 
							  && request.getParameter("sch_prd_lly_vol")!=null && request.getParameter("sch_prd_lly_val")!=null 
							  && request.getParameter("sch_prd_ly_vol")!=null &&  request.getParameter("sch_prd_ly_val")!=null
							  && request.getParameter("sch_prd_spread_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_tgt_val")!=null
							  && request.getParameter("sch_prd_spread_mtd_ly_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ly_val")!=null
							  && request.getParameter("proj_grwth_vol_pct")!=null && request.getParameter("proj_grwth_val_pct")!=null
							  && request.getParameter("proj_grwth_spd_pct")!=null
							  && request.getParameter("sch_prd_ty_vol")!=null &&  request.getParameter("sch_prd_ty_val")!=null 
							  && request.getParameter("sch_prd_spread_mtd_ty_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ty_tgt_val")!=null 
							  && request.getParameter("sch_prd_wt_avg")!=null &&  request.getParameter("sch_prd_total_prd_bdgt")!=null)
							   {
						String sch_prd_outflow_unique_id[] = request.getParameterValues("sch_prd_outflow_unique_id");
						String sch_prd_outflow_line_type[] = request.getParameterValues("sch_prd_outflow_line_type");
						String sch_product_outflow_id[] = request.getParameterValues("sch_product_outflow_id");
						String sch_prd_lly_vol[] = request.getParameterValues("sch_prd_lly_vol");
						String sch_prd_lly_val[] = request.getParameterValues("sch_prd_lly_val");
						String sch_prd_ly_vol[] = request.getParameterValues("sch_prd_ly_vol");
						String sch_prd_ly_val[] = request.getParameterValues("sch_prd_ly_val");			
						String sch_prd_spread_tgt_vol[] = request.getParameterValues("sch_prd_spread_tgt_vol");
						String sch_prd_spread_tgt_val[] = request.getParameterValues("sch_prd_spread_tgt_val");
						String sch_prd_spread_mtd_ly_vol[] = request.getParameterValues("sch_prd_spread_mtd_ly_vol");
						String sch_prd_spread_mtd_ly_val[] = request.getParameterValues("sch_prd_spread_mtd_ly_val");
						String proj_grwth_vol_pct[] = request.getParameterValues("proj_grwth_vol_pct");
						String proj_grwth_val_pct[] = request.getParameterValues("proj_grwth_val_pct");
						String proj_grwth_spd_pct[] = request.getParameterValues("proj_grwth_spd_pct");
						String sch_prd_ty_vol[] = request.getParameterValues("sch_prd_ty_vol");
						String sch_prd_ty_val[] = request.getParameterValues("sch_prd_ty_val");
						String sch_prd_spread_mtd_ty_tgt_vol[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_vol");
						String sch_prd_spread_mtd_ty_tgt_val[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_val");
						String sch_prd_wt_avg[] = request.getParameterValues("sch_prd_wt_avg");			
						String sch_prd_total_prd_bdgt[] = request.getParameterValues("sch_prd_total_prd_bdgt");
						
						int len1 = sch_product_outflow_id.length;				 
							 
//							 int prod_id = schemerequestdao.saveproductoutflow(len1,new_scheme_id,
//									 sch_prd_outflow_unique_id,sch_prd_outflow_line_type,sch_product_outflow_id,
//									 sch_prd_lly_vol,sch_prd_lly_val,sch_prd_ly_vol,sch_prd_ly_val,
//									 sch_prd_spread_tgt_vol,sch_prd_spread_tgt_val,
//									 sch_prd_spread_mtd_ly_vol,sch_prd_spread_mtd_ly_val,
//									 proj_grwth_vol_pct,proj_grwth_val_pct,proj_grwth_spd_pct,sch_prd_ty_vol,sch_prd_ty_val,
//									 sch_prd_spread_mtd_ty_tgt_vol,sch_prd_spread_mtd_ty_tgt_val,
//									 sch_prd_wt_avg,sch_prd_total_prd_bdgt);  
							   
							for(int i=0;i<sch_product_outflow_id.length;i++)
								{
										System.out.println("in ctrl"+sch_product_outflow_id[i]);
										str3+=sch_product_outflow_id[i];
										
									    if(i<sch_product_outflow_id.length-1) // Avoiding the last comma
									    {
									    	str3+=",";
									    }
								}
								
					 }
							 
							
								new_scheme.setAttribute5(str3);
//							 int new_scheme_id1 = schemerequestdao.saveheader(new_scheme);


						//// save IT product info

					 String str12 = "";
					 if(request.getParameter("sch_prd_code")!=null && request.getParameter("sch_prd_grp")!=null && request.getParameter("sch_prd_cat")!=null && request.getParameter("sch_prd_cat_desc")!=null )
					 {
						String sch_it_prd_dtls_id[] = request.getParameterValues("sch_it_prd_dtls_id"); 			
						String sch_prd_code[] = request.getParameterValues("sch_prd_code");
						String sch_prd_grp[] = request.getParameterValues("sch_prd_grp");
						String sch_prd_cat[] = request.getParameterValues("sch_prd_cat");
						String sch_prd_cat_desc[] = request.getParameterValues("sch_prd_cat_desc");
						
						int len1 = sch_prd_code.length;				 
							 
							 int prod_id = schemerequestdao.saveitproduct(len1,new_scheme_id,sch_it_prd_dtls_id,sch_prd_code,sch_prd_grp,sch_prd_cat,sch_prd_cat_desc);  
							
								for(int i=0;i<sch_prd_code.length;i++)
								{
										System.out.println("in ctrl"+sch_prd_code[i]);
										str12+=sch_prd_code[i];
										
									    if(i<sch_prd_code.length-1) // Avoiding the last comma
									    {
									    	str12+=",";
									    }
								}
					 }
							 new_scheme.setAttribute4(str12);
//							 int new_scheme_id2 = schemerequestdao.saveheader(new_scheme);

					 
		/////////// save sheme gift
			   
					 if(request.getParameter("gift_code")!=null && request.getParameter("gift_group")!=null && request.getParameter("gift_name")!=null && request.getParameter("effective_price")!=null )
					 {
							String[] gift_id = request.getParameterValues("gift_id");
							String[] sche_code = request.getParameterValues("gift_code");
							String[] gift_group = request.getParameterValues("gift_group");
							String[] gift_name = request.getParameterValues("gift_name");			
							String[] effective_price = request.getParameterValues("effective_price");
							
								 int len = gift_group.length;
									
//							 int schemegift_id = schemerequestdao.savegift(user_id,new_scheme_id,len,sche_code,gift_id,gift_group,gift_name,effective_price,str);  

					}
						 
				/////////// entry into depots table
						   
									   CallableStatement cStmt;
								 		try {
								 		cStmt = hibernateConfiguration.dataSource()
												.getConnection().prepareCall("{call BPIL_POPULATE_SCH_DEPOT_DTLS(?,?,?,?)}");
								 		 									 		
								 		
								 		cStmt.setInt(1, new_scheme_id);
								 		cStmt.setInt(2,revsion);	
								 		cStmt.setInt(3, user_id);
								 		cStmt.registerOutParameter(4,Types.VARCHAR); 
								 		ResultSet rs1 = cStmt.executeQuery();
								 			 	
								 			String str111 =cStmt.getString(4);
								 			System.out.println("msg is="+str111);
								 			
								 			ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id="+new_scheme_id);
											String schemecode=dml.get(0).getScheme_code();
											int createdby=dml.get(0).getCreated_by();
											ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdby);
											String createdby1=dml1.get(0).getUser_name();
											
									 		
//									 			CallableStatement cStmt3;	
//									 			
//									 				cStmt3 = hibernateConfiguration.dataSource().getConnection()
//									 						.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
//									 			
//
//									 				cStmt3.setInt(1, createdby);
//									 				cStmt3.setInt(2, new_scheme_id);
//									 				cStmt3.setString(3, "SUP");
//									 				cStmt3.setString(4, "Scheme "+ schemecode + " updated in BSAT");
//									 				cStmt3.registerOutParameter(5, Types.VARCHAR);
//									 			ResultSet result3 = cStmt3.executeQuery();
//									 			String flag3 = cStmt3.getString(5);
//									 			System.out.println("scheme request mail flag "+ flag3);
									 			
//									 			New Scheme 1718-ML7-497 is registered in BSAT
//									 			Scheme 1718-ML7-497 is updated in BSAT
									 			


											
											CallableStatement cStmt2;	
											
											cStmt2 = hibernateConfiguration.dataSource().getConnection()
													.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
										

											cStmt2.setInt(1, createdby);
											cStmt2.setInt(2, new_scheme_id);
											cStmt2.setString(3, "I2P");
											cStmt2.setString(4, "Scheme "+ schemecode + " Ready for Analysis for PMG");
											cStmt2.registerOutParameter(5, Types.VARCHAR);
										ResultSet result = cStmt2.executeQuery();
										String flag = cStmt2.getString(5);
										System.out.println("scheme Ready for Analysis mail flag "+ flag);
								
								 		} catch (SQLException e) {
								 		e.printStackTrace();
								 		}
								 		catch (Exception e) {
								 		System.out.println(e.getMessage());
								 		} 
						 						 
						 
//		 model.addAttribute("scheme_id",new_scheme_id);
//		 String scheme_name=new_scheme.getScheme_name();
//		 String tentative=new_scheme.getAttribute6();
		
//		 model.addAttribute("tentative", tentative);
//		 model.addAttribute("scheme_name",scheme_name);
		 System.out.println(new_scheme_id);
		 
		 New_Scheme_mstr mstr = schememasterdao.schemeautofill(new_scheme_id);
		 if(mstr.getScheme_id() != Integer.parseInt(mstr.getScheme_srl_no())){
			 mstr.setScheme_srl_no(String.valueOf(mstr.getScheme_id()));
			 int srlSchemeId = schemerequestdao.saveheader(mstr);
			 System.out.println("srlSchemeId "+srlSchemeId);
		 }
			//return new ModelAndView("redirect:/schememaster");
			return new ModelAndView("redirect:/oiainfo");

	}else{
		
		int revsion = new_scheme.getRevision();
		Date created_on = null;
		Date startdate = null;
		Date redemp_date = null;
		Date enddate = null;
		
		ArrayList<New_Scheme_mstr> Update_Schemes=(ArrayList<New_Scheme_mstr>)hibernateTemplate.find("from New_Scheme_mstr  where scheme_id=?",+new_scheme.getScheme_id());
		New_Scheme_mstr Update_Scheme = Update_Schemes.get(0);

		if(request.getParameter("redemption_date")!=null)
		{
				
				try {
					if (!request.getParameter("redemption_date").equals("")) {
						redemp_date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("redemption_date"));
						
						System.out.println(redemp_date);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("start_date")!=null)
		{
				
				try {
					if (!request.getParameter("start_date").equals("")) {
						startdate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("start_date"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("end_date")!=null)
		{
				
				try {
					if (!request.getParameter("end_date").equals("")) {
						enddate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("end_date"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("created_on")!=null)
		{				
				try {
					if (!request.getParameter("created_on").equals("")) {
						created_on = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("created_on"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		String str[] = request.getParameterValues("appl_depot_code1[]"); // string separate by ,
		String str1 = "";
		if(request.getParameterValues("appl_depot_code1[]") != null ){
		for(int i=0;i<str.length;i++)
		{
				System.out.println("in ctrl"+str[i]);
				str1+=str[i];
				
			    if(i<str.length-1) // Avoiding the last comma
			    {
			    	str1+=",";
			    }
		}
		}
		new_scheme.setRedemption_date(redemp_date);
		new_scheme.setAppl_depot_code(str1);
		new_scheme.setStart_date(startdate);
		new_scheme.setEnd_date(enddate);
		new_scheme.setCreation_date(created_on);		
		new_scheme.setCreated_by(user_id);
		new_scheme.setLast_updated_by(user_id);
		new_scheme.setActive_flag("Requested");
		
		Update_Scheme.setRedemption_date(new_scheme.getRedemption_date());
		Update_Scheme.setAppl_depot_code(new_scheme.getAppl_depot_code());
		Update_Scheme.setAppl_regn_code(new_scheme.getAppl_regn_code());
		Update_Scheme.setStart_date(new_scheme.getStart_date());
		Update_Scheme.setEnd_date(new_scheme.getEnd_date());
		Update_Scheme.setCreation_date(new_scheme.getCreation_date());
		Update_Scheme.setCreated_by(new_scheme.getCreated_by());
		Update_Scheme.setLast_updated_by(new_scheme.getLast_updated_by());
		Update_Scheme.setActive_flag(new_scheme.getActive_flag());
		
		Update_Scheme.setSch_dir_name(new_scheme.getSch_dir_name());
		Update_Scheme.setFin_an_batch_file(new_scheme.getFin_an_batch_file());
		Update_Scheme.setSch_an_batch_file(new_scheme.getSch_an_batch_file());
		Update_Scheme.setPrc_rw_batch_file(new_scheme.getPrc_rw_batch_file());
		Update_Scheme.setSch_opa_url(new_scheme.getSch_opa_url());
		Update_Scheme.setOpa_whatif_url(new_scheme.getOpa_whatif_url());
		Update_Scheme.setOpa_sch_an_name(new_scheme.getOpa_sch_an_name());
		Update_Scheme.setAttribute4(new_scheme.getAttribute4());
		Update_Scheme.setAttribute5(new_scheme.getAttribute5());
		Update_Scheme.setLast_update_date(new Date());
		
		
//		if(new_scheme.getParent_scheme_code() != null && new_scheme.getParent_scheme_code() != "") {
//	        
//			ArrayList<New_Scheme_mstr> ps = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id = '"+new_scheme.getParent_scheme_code()+"'");
//			if(!ps.isEmpty()){
//			new_scheme.setParent_scheme_name(ps.get(0).getScheme_name());
//			}
//	        }

		
//			 new_scheme_id = schemerequestdao.saveheader(new_scheme);
			 new_scheme_id = schemerequestdao.saveheader(Update_Scheme);
		
			
//////////save doc	
			  /* if (null != doc_file) 
		        {
		            for (MultipartFile multipartFile : doc_file) {
		 
		            	Bpil_Scheme_Doc docs = new Bpil_Scheme_Doc();
		            	
		                String fileName = multipartFile.getOriginalFilename();
		                
		                try {
							docs.setDoc_file(multipartFile.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
		                docs.setDoc_title(multipartFile.getOriginalFilename());
		                docs.setDoc_type(multipartFile.getContentType());
		                docs.setScheme_id(new_scheme_id);
		                
		                 int doc_id = schemerequestdao.savedocs(docs);
		            }
		        }
 			 	*/
			 
		//// save product info
			 String str11 = "";
			 if(request.getParameter("sch_prd_line_type")!=null && request.getParameter("sch_prd_exceptions")!=null && request.getParameter("sch_product_id")!=null && request.getParameter("vol_grwth_pct")!=null && request.getParameter("val_grwth_pct")!=null &&  request.getParameter("spread_pct")!=null && request.getParameter("spend_per_ltr")!=null)
			 {
				String sch_prd_unique_id[] = request.getParameterValues("sch_prd_unique_id"); 			
				String sch_prd_line_type[] = request.getParameterValues("sch_prd_line_type");
				String sch_product_id[] = request.getParameterValues("sch_product_id");
				String sch_prd_exceptions[] = request.getParameterValues("sch_prd_exceptions");
				String vol_grwth_pct[] = request.getParameterValues("vol_grwth_pct");
				String val_grwth_pct[] = request.getParameterValues("val_grwth_pct");
				String spread_pct[] = request.getParameterValues("spread_pct");			
				String spend_per_ltr[] = request.getParameterValues("spend_per_ltr");
				
				int len1 = vol_grwth_pct.length;				 
					 
//					 int prod_id = schemerequestdao.saveproduct(len1,new_scheme_id,sch_prd_unique_id,sch_prd_line_type,sch_product_id,sch_prd_exceptions,vol_grwth_pct,val_grwth_pct,spread_pct,spend_per_ltr);  
										
						for(int i=0;i<sch_product_id.length;i++)
						{
								System.out.println("in ctrl"+sch_product_id[i]);
								str11+=sch_product_id[i];
								
							    if(i<sch_product_id.length-1) // Avoiding the last comma
							    {
							    	str11+=",";
							    }
						}							 
			 }		 
						new_scheme.setSch_product_codes(str11);
//						int new_scheme_id1 = schemerequestdao.saveheader(new_scheme);
						
						//// save product outflow info
						 
						String str3 = "";
					  if(request.getParameter("sch_prd_outflow_line_type")!=null && request.getParameter("sch_product_outflow_id")!=null 
							  && request.getParameter("sch_prd_lly_vol")!=null && request.getParameter("sch_prd_lly_val")!=null 
							  && request.getParameter("sch_prd_ly_vol")!=null &&  request.getParameter("sch_prd_ly_val")!=null
							  && request.getParameter("sch_prd_spread_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_tgt_val")!=null
							  && request.getParameter("sch_prd_spread_mtd_ly_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ly_val")!=null
							  && request.getParameter("proj_grwth_vol_pct")!=null && request.getParameter("proj_grwth_val_pct")!=null
							  && request.getParameter("proj_grwth_spd_pct")!=null
							  && request.getParameter("sch_prd_ty_vol")!=null &&  request.getParameter("sch_prd_ty_val")!=null 
							  && request.getParameter("sch_prd_spread_mtd_ty_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ty_tgt_val")!=null 
							  && request.getParameter("sch_prd_wt_avg")!=null &&  request.getParameter("sch_prd_total_prd_bdgt")!=null)
							   {
						String sch_prd_outflow_unique_id[] = request.getParameterValues("sch_prd_outflow_unique_id");
						String sch_prd_outflow_line_type[] = request.getParameterValues("sch_prd_outflow_line_type");
						String sch_product_outflow_id[] = request.getParameterValues("sch_product_outflow_id");
						String sch_prd_lly_vol[] = request.getParameterValues("sch_prd_lly_vol");
						String sch_prd_lly_val[] = request.getParameterValues("sch_prd_lly_val");
						String sch_prd_ly_vol[] = request.getParameterValues("sch_prd_ly_vol");
						String sch_prd_ly_val[] = request.getParameterValues("sch_prd_ly_val");			
						String sch_prd_spread_tgt_vol[] = request.getParameterValues("sch_prd_spread_tgt_vol");
						String sch_prd_spread_tgt_val[] = request.getParameterValues("sch_prd_spread_tgt_val");
						String sch_prd_spread_mtd_ly_vol[] = request.getParameterValues("sch_prd_spread_mtd_ly_vol");
						String sch_prd_spread_mtd_ly_val[] = request.getParameterValues("sch_prd_spread_mtd_ly_val");
						String proj_grwth_vol_pct[] = request.getParameterValues("proj_grwth_vol_pct");
						String proj_grwth_val_pct[] = request.getParameterValues("proj_grwth_val_pct");
						String proj_grwth_spd_pct[] = request.getParameterValues("proj_grwth_spd_pct");
						String sch_prd_ty_vol[] = request.getParameterValues("sch_prd_ty_vol");
						String sch_prd_ty_val[] = request.getParameterValues("sch_prd_ty_val");
						String sch_prd_spread_mtd_ty_tgt_vol[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_vol");
						String sch_prd_spread_mtd_ty_tgt_val[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_val");
						String sch_prd_wt_avg[] = request.getParameterValues("sch_prd_wt_avg");			
						String sch_prd_total_prd_bdgt[] = request.getParameterValues("sch_prd_total_prd_bdgt");
						
						int len1 = sch_product_outflow_id.length;				 
							 
							 int prod_id = schemerequestdao.saveproductoutflow(len1,new_scheme_id,
									 sch_prd_outflow_unique_id,sch_prd_outflow_line_type,sch_product_outflow_id,
									 sch_prd_lly_vol,sch_prd_lly_val,sch_prd_ly_vol,sch_prd_ly_val,
									 sch_prd_spread_tgt_vol,sch_prd_spread_tgt_val,
									 sch_prd_spread_mtd_ly_vol,sch_prd_spread_mtd_ly_val,
									 proj_grwth_vol_pct,proj_grwth_val_pct,proj_grwth_spd_pct,sch_prd_ty_vol,sch_prd_ty_val,
									 sch_prd_spread_mtd_ty_tgt_vol,sch_prd_spread_mtd_ty_tgt_val,
									 sch_prd_wt_avg,sch_prd_total_prd_bdgt);  
							   
							for(int i=0;i<sch_product_outflow_id.length;i++)
								{
										System.out.println("in ctrl"+sch_product_outflow_id[i]);
										str3+=sch_product_outflow_id[i];
										
									    if(i<sch_product_outflow_id.length-1) // Avoiding the last comma
									    {
									    	str3+=",";
									    }
								}
								
					 }
							 
							
								new_scheme.setAttribute5(str3);
//							 int new_scheme_id1 = schemerequestdao.saveheader(new_scheme);

						
						//// save IT product info

						 String str12 = "";
						 if(request.getParameter("sch_prd_code")!=null && request.getParameter("sch_prd_grp")!=null && request.getParameter("sch_prd_cat")!=null && request.getParameter("sch_prd_cat_desc")!=null )
						 {
							String sch_it_prd_dtls_id[] = request.getParameterValues("sch_it_prd_dtls_id"); 			
							String sch_prd_code[] = request.getParameterValues("sch_prd_code");
							String sch_prd_grp[] = request.getParameterValues("sch_prd_grp");
							String sch_prd_cat[] = request.getParameterValues("sch_prd_cat");
							String sch_prd_cat_desc[] = request.getParameterValues("sch_prd_cat_desc");
							
							int len1 = sch_prd_code.length;				 
								 
								 int prod_id = schemerequestdao.saveitproduct(len1,new_scheme_id,sch_it_prd_dtls_id,sch_prd_code,sch_prd_grp,sch_prd_cat,sch_prd_cat_desc);  
								
									for(int i=0;i<sch_prd_code.length;i++)
									{
											System.out.println("in ctrl"+sch_prd_code[i]);
											str12+=sch_prd_code[i];
											
										    if(i<sch_prd_code.length-1) // Avoiding the last comma
										    {
										    	str12+=",";
										    }
									}
						 }
								 new_scheme.setAttribute4(str12);
//								 int new_scheme_id2 = schemerequestdao.saveheader(new_scheme);
						
							 
		/////////// save sheme gift			   
					 if(request.getParameter("gift_code")!=null && request.getParameter("gift_group")!=null && request.getParameter("gift_name")!=null && request.getParameter("effective_price")!="" )
					 {	
							String[] gift_id = request.getParameterValues("gift_id");
							String[] sche_code = request.getParameterValues("gift_code");
							String[] gift_group = request.getParameterValues("gift_group");
							String[] gift_name = request.getParameterValues("gift_name");			
							String[] effective_price = request.getParameterValues("effective_price");
						
							int len = gift_group.length;					
//						 int schemegift_id = schemerequestdao.savegift(user_id,new_scheme_id,len,sche_code,gift_id,gift_group,gift_name,effective_price,str);  
					 }
							/////////// entry into depots table
						   
						   CallableStatement cStmt;
					 		try {
					 		cStmt = hibernateConfiguration.dataSource()
									.getConnection().prepareCall("{call BPIL_POPULATE_SCH_DEPOT_DTLS(?,?,?,?)}");
					 		 									 		
					 		
					 		cStmt.setInt(1, new_scheme_id);
					 		cStmt.setInt(2,revsion);	
					 		cStmt.setInt(3, user_id);
					 		cStmt.registerOutParameter(4,Types.VARCHAR); 
					 		ResultSet rs1 = cStmt.executeQuery();
					 			 	
					 			String str111 =cStmt.getString(4);
					 			System.out.println("msg is="+str111);
					 			
					 			ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id="+new_scheme_id);
								String schemecode=dml.get(0).getScheme_code();
								int createdby=dml.get(0).getCreated_by();
								ArrayList<Bpil_Users> dml1 = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdby);
								String createdby1=dml1.get(0).getUser_name();

					 			
//					 			CallableStatement cStmt3;	
//					 			
//				 				cStmt3 = hibernateConfiguration.dataSource().getConnection()
//				 						.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
//				 			
//
//				 				cStmt3.setInt(1, createdby);
//				 				cStmt3.setInt(2, new_scheme_id);
//				 				cStmt3.setString(3, "SUP");
//				 				cStmt3.setString(4, "Scheme "+ schemecode + " updated in BSAT");
//				 				cStmt3.registerOutParameter(5, Types.VARCHAR);
//				 			ResultSet result3 = cStmt3.executeQuery();
//				 			String flag3 = cStmt3.getString(5);
//				 			System.out.println("scheme request mail flag "+ flag3);
				 			
//				 			New Scheme 1718-ML7-497 is registered in BSAT
//				 			Scheme 1718-ML7-497 is updated in BSAT

					
					 		} catch (SQLException e) {
					 		e.printStackTrace();
					 		}
					 		catch (Exception e) {
					 		System.out.println(e.getMessage());
					 		} 

						
							
						   
//		 model.addAttribute("scheme_id",new_scheme_id);
//		 String scheme_name=new_scheme.getScheme_name();
//		 String tentative=new_scheme.getAttribute6();
		
//		 model.addAttribute("tentative", tentative);
//		 model.addAttribute("scheme_name",scheme_name);
		 
		 System.out.println(new_scheme_id);
		 
		 New_Scheme_mstr mstr = schememasterdao.schemeautofill(new_scheme_id);
		 if(mstr.getScheme_id() != Integer.parseInt(mstr.getScheme_srl_no())){
			 mstr.setScheme_srl_no(String.valueOf(mstr.getScheme_id()));
			 int srlSchemeId = schemerequestdao.saveheader(mstr);
			 System.out.println("srlSchemeId "+srlSchemeId);
		 }
			return new ModelAndView("redirect:/schemedetails?scheme_id="+new_scheme_id+"");

		}
	
	//String id= Integer.toString(new_scheme_id);
	

	
	}
	
	

	
	/*@RequestMapping(value = "/ITschemerequest")
	public ModelAndView save()
	{
		return new ModelAndView("FinancialAnalysis");
		
	}*/
	
	
	


	
	
	@RequestMapping(value = "/serialno", method = RequestMethod.GET)
	public void serialno(HttpServletRequest request,Model model,HttpServletResponse response) {
								
		 	try {
		 		
		 		String sql = "select max(scheme_srl_no) SCHEME_SRL from bpil_scheme_master";
		 		List<New_Scheme_mstr> dml = jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>() {

					@Override
					public New_Scheme_mstr mapRow(ResultSet rs, int rowNum) throws SQLException {
						New_Scheme_mstr aContact = new New_Scheme_mstr();
			
						aContact.setScheme_srl_no(rs.getString("SCHEME_SRL"));
						
						
						return aContact;
					}
					
				});	
			 
		 		
			 String json = null;
			 
			 json = new Gson().toJson(dml);
			 response.setContentType("application/json");
			 response.getWriter().write(json);
			 } catch (IOException e) {
			 	e.printStackTrace();
			 }
		
	}
	
	public void updatedSendMail(RenewedMailCommunication renewMailObj) throws MessagingException {

		/*System.out.println("In mail method");
		String host = "smtp.omfysgroup.com";
		final String user = "hrdesk@omfysgroup.com";// change accordingly
		final String password = "Omfys@123";// change accordingly
		final String port = "587";

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		//props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");

		 String to = renewMailObj.getTo_mail(); String cc = null; 
		 
		 String to = "kranti.patil@omfysgroup.com"; String cc = null; 		 
		 
		 Session session1 = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		 System.out.println("Values in session"+session1.getProperties());

		MimeMessage message1 = new MimeMessage(session1);
		message1.setFrom(new InternetAddress(user));
		message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		if (cc != null) {
			message1.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
		}

		message1.setSubject(renewMailObj.getSubject());

		try {
			message1.setContent(renewMailObj.getBody(), "text/html");
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Transport.send(message1);
			System.out.println("Transport method call");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//Email send Code
		  Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

	        // Get a Properties object
	        Properties props = System.getProperties();
	        props.setProperty("mail.smtps.host", "smtp.gmail.com");
	        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	        props.setProperty("mail.smtp.socketFactory.fallback", "false");
	        props.setProperty("mail.smtp.port", "465");
	        props.setProperty("mail.smtp.socketFactory.port", "465");
	        props.setProperty("mail.smtps.auth", "true");

	        /*
	        If set to false, the QUIT command is sent and the connection is immediately closed. If set 
	        to true (the default), causes the transport to wait for the response to the QUIT command.

	        ref :   http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
	                http://forum.java.sun.com/thread.jspa?threadID=5205249
	                smtpsend.java - demo program from javamail
	        */
	        props.put("mail.smtps.quitwait", "false");

	        Session session = Session.getInstance(props, null);

	        // -- Create a new message --
	        final MimeMessage msg = new MimeMessage(session);

	        // -- Set the FROM and TO fields --
	        msg.setFrom(new InternetAddress("patil.kranti90@gmail.com"));
	        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("patil.kranti90@gmail.com", false));

	        if ("patil.kranti90@gmail.com".length() > 0) {
	            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse("patil.kranti90@gmail.com", false));
	        }

	        msg.setSubject(renewMailObj.getSubject());
	        msg.setText("");
	        msg.setContent(renewMailObj.getBody(), "text/html");
	        msg.setSentDate(new Date());

	        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

	        t.connect("smtp.gmail.com", "patil.kranti90@gmail.com", "krupapatil");
	        t.sendMessage(msg, msg.getAllRecipients());      
	        t.close();

	}
	
	@RequestMapping("/NewSchmReq")
	public ModelAndView NewSchmReq(ModelMap map,Model model,HttpServletRequest request)
	{
		Bpil_Bsat_Defaults defaults = menudao.getDefaults();
		model.addAttribute("redemption_day", defaults.getRedemption_date());
		return new ModelAndView("NewSchmReq");
		//return new ModelAndView("NewSchemeTest");
	}
	
	@RequestMapping(value = "/new_savescheme_request", method = RequestMethod.POST)
	public String newsavescheme_request(@ModelAttribute("New_Scheme_mstr_for_Crm") New_Scheme_mstr_for_Crm new_scheme,
			BindingResult resultkwm_users ,
			@RequestParam CommonsMultipartFile [] doc_file,
			@RequestParam CommonsMultipartFile [] doc_file1,
			HttpServletRequest request,Model model) {
		
		System.out.println(" new savescheme_request in controller New_Scheme_mstr_for_Crm");	
		

		
		String sel=request.getParameter("start_date");
		String selend=request.getParameter("end_date");
		String redemsel=request.getParameter("redemption_date");
		System.out.println(sel+"  "+selend+"  "+redemsel);
		System.out.println(sel+"----------------------------------");
		int rev=0;
		int rev1=0;
		int user_id = (Integer) request.getSession().getAttribute("userid");	
		int profile_id = (Integer) request.getSession().getAttribute("profileid");
		
		Date created_on = null;
		Date startdate = null;
		Date redemp_date = null;
		Date enddate = null;
		if(request.getParameter("redemption_date")!=null)
		{
				
				try {
					if (!request.getParameter("redemption_date").equals("")) {
						redemp_date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("redemption_date"));
						System.out.println(redemp_date);
					
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("start_date")!=null)
		{
			
				System.out.println("Start date for scheme is : "+request.getParameter("start_date"));
				System.out.println("Start datedup for scheme is : "+request.getParameter("start_datedup"));
				try {
					if (!request.getParameter("start_date").equals("")) {
						startdate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("start_datedup"));
						System.out.println(startdate);
						
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("end_date")!=null)
		{
			System.out.println("end datedup for scheme is : "+request.getParameter("end_datedup"));
				try {
					if (!request.getParameter("end_date").equals("")) {
						enddate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("end_datedup"));
						System.out.println(enddate);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}

		
	
		
	
		
	
		
		if(request.getParameter("created_on")!=null)
		{			
				try {
					if (!request.getParameter("created_on").equals("")) {
						created_on = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("created_on"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}

			
			String sql = "select MAX(SCHEME_ID) SCHEME_ID from BPIL_SCHEME_MASTER_CRM";
	 		List<New_Scheme_mstr_for_Crm> dml = jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr_for_Crm>() {

				@Override
				public New_Scheme_mstr_for_Crm mapRow(ResultSet rs, int rowNum) throws SQLException {
					New_Scheme_mstr_for_Crm aContact = new New_Scheme_mstr_for_Crm();
		
					aContact.setScheme_id(rs.getInt("SCHEME_ID"));
					
					
					
					return aContact;
				}
				
			});	
	 		
	 		int saveschid = dml.get(0).getScheme_id() + 1;
	
	 		new_scheme.setScheme_id(saveschid);
		
	 		String	company_type = request.getParameter("company_type");	
			
/////save doc	 scheme realted
		String	scheme_document_comment = request.getParameter("scheme_document_comment");
			
			   if (null != doc_file && doc_file.length>0) 
		        {
		            for (MultipartFile multipartFile : doc_file) {
		 
		            	Crm_Bpil_Scheme_Doc docs = new Crm_Bpil_Scheme_Doc();
		            	
		                String fileName = multipartFile.getOriginalFilename();
		                
		                try {
							docs.setDoc_file(multipartFile.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
		                docs.setDoc_title(multipartFile.getOriginalFilename());
		                docs.setDoc_type("Scheme Document");
		                docs.setScheme_id(saveschid);
		                docs.setComments(scheme_document_comment);
		                docs.setCreation_date(new Date());
		                docs.setLast_update_date(new Date());
		              
		                
		                 long size = multipartFile.getSize();
		                if(size>0)
		                {
		                	 // rev=new_scheme.getRevision();
//				                rev=rev+1;
				                docs.setRevision(rev);
		                 int doc_id = schemerequestdao.crmsavedocs(docs);
		                }
		                 
		            }
		        }
			
			   String sch_code = new_scheme.getScheme_code();
			   String sr_no = Integer.toString(saveschid);
			   String serial_num = sch_code.concat(sr_no);
				new_scheme.setStart_date(startdate);
				new_scheme.setEnd_date(enddate);
				new_scheme.setCreated_by(user_id);
				new_scheme.setLast_updated_by(user_id);
				new_scheme.setActive_flag("Incomplete");		
				new_scheme.setRedemption_date(redemp_date);
				new_scheme.setCreation_date(created_on);
				new_scheme.setLast_update_date(new Date());
		 	    new_scheme.setCompany_type(company_type);
			   new_scheme.setScheme_code(serial_num);
			  // new_scheme.setRevision(rev);
			   new_scheme.setScheme_srl_no(sr_no);
			   System.out.println(new_scheme.toString());
			   int new_scheme_id2 = schemerequestdao.crmsaveheader(new_scheme);   

////save doc	others
				
			   String	other_document_comment = request.getParameter("other_document_comment");
			   
				   if (null != doc_file1 && doc_file1.length>0) 
			        {
			            for (MultipartFile multipartFile : doc_file1) {
			 
			            	Crm_Bpil_Scheme_Doc docs = new Crm_Bpil_Scheme_Doc();
			            	
			                String fileName = multipartFile.getOriginalFilename();
			                
			                try {
								docs.setDoc_file(multipartFile.getBytes());
							} catch (IOException e) {
								e.printStackTrace();
							}
			                docs.setDoc_title(multipartFile.getOriginalFilename());
			                docs.setDoc_type("Other Document");
			                docs.setScheme_id(saveschid);
			                docs.setComments(other_document_comment);
			                
			                //rev1=new_scheme.getRevision();			              
			                docs.setRevision(rev1);
			                docs.setCreation_date(new Date());
			                docs.setLast_update_date(new Date());
			                
			                 long size = multipartFile.getSize();
			                if(size>0)
			                {
			                 int doc_id = schemerequestdao.crmsavedocs(docs);
			                }
			                 
			            }
			        }

				   
		 		

				   return "redirect:/CrmSchemeDetails?scheme_id=" + saveschid + "";	
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public void test()
	{
		
//		String sendData="{\n" +
//				" \"commands\":[\n" +
//				" {\n" +
//				" \"insert\": {\n" +
//				" \"out-identifier\":\"com.trial.mindsconnect.AAMindsConnectRule\",\n" +
//				" \"object\":{\n" +
//				" \"com.trial.mindsconnect\":{\n" +
//				" \"startDate\":\""+fromdate+"\",\n" +
//				" \"balanceLeave\":8,\n" +
//				" \"endDate\":\""+todate+"\",\n" +
//				" \"setValue\":\"2\"\n" +
//				" } \n" +
//				" },\n" +
//				" \"disconnected\":true,\n" +
//				" \"return-object\":true,\n" +
//				" \"entry-point\":\"DEFAULT\"\n" +
//				" }\n" +
//				" },\n" +
//				" {\n" +
//				" \"fire-all-rules\":\"\"\n" +
//				" }";
//		System.out.println(sendData);
	}
	
	
	@RequestMapping(value = "/new_savescheme_request_om", method = RequestMethod.POST)
	public ModelAndView newsavescheme_request_om(@ModelAttribute("New_Scheme_mstr_for_Crm") New_Scheme_mstr_for_Crm new_scheme,
			BindingResult resultkwm_users ,
			@RequestParam CommonsMultipartFile [] doc_file,
			@RequestParam CommonsMultipartFile [] doc_file1,
			HttpServletRequest request,Model model) {
		
		System.out.println(" new savescheme_request in controller New_Scheme_mstr_for_Crm");	
		

		
		String sel=request.getParameter("start_date");
		String selend=request.getParameter("end_date");
		String redemsel=request.getParameter("redemption_date");
		System.out.println(sel+"  "+selend+"  "+redemsel);
		System.out.println(sel+"----------------------------------");
		int rev=0;
		int rev1=0;
		int user_id = (Integer) request.getSession().getAttribute("userid");	
		int profile_id = (Integer) request.getSession().getAttribute("profileid");
		
		Date created_on = null;
		Date startdate = null;
		Date redemp_date = null;
		Date enddate = null;
		if(request.getParameter("redemption_date")!=null)
		{
				
				try {
					if (!request.getParameter("redemption_date").equals("")) {
						redemp_date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("redemption_date"));
						System.out.println(redemp_date);
					
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("start_date")!=null)
		{
			
				System.out.println("Start date for scheme is : "+request.getParameter("start_date"));
				System.out.println("Start datedup for scheme is : "+request.getParameter("start_datedup"));
				try {
					if (!request.getParameter("start_date").equals("")) {
						startdate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("start_datedup"));
						System.out.println(startdate);
						
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(request.getParameter("end_date")!=null)
		{
			System.out.println("end datedup for scheme is : "+request.getParameter("end_datedup"));
				try {
					if (!request.getParameter("end_date").equals("")) {
						enddate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("end_datedup"));
						System.out.println(enddate);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
//		if(profile_id==3)
//		{			
//		
//		String str[] = request.getParameterValues("appl_depot_code1[]"); // string separate by ,
//		String str1 = "";
//		for(int i=0;i<str.length;i++)
//		{
//				System.out.println("in ctrl"+str[i]);
//				str1+=str[i];
//				
//			    if(i<str.length-1) // Avoiding the last comma
//			    {
//			    	str1+=",";
//			    }
//		}
//		
//		new_scheme.setAppl_depot_code(str1);
//		
//		
//		}
		
		String str[] = request.getParameterValues("sel_depo"); // string separate by ,
		String str1 = "";
		
		Set<String> set = new HashSet<>();
		for(int j = 0; j< str.length; j ++){
			set.add(str[j]);
		}
		
		System.out.println("Set : "+set.toString());
		
		int line =0;
		if(request.getParameterValues("sel_depo") != null ){
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
//		for(int i=0;i<str.length;i++)
//		{
//				System.out.println("in ctrl"+str[i]);
//				str1+=str[i];
//				
//			    if(i<str.length-1) // Avoiding the last comma
//			    {
//			    	str1+=",";
//			    }
//		}
		}
		
		
		//new_scheme.setAppl_depot_code(str1);
		
		new_scheme.setStart_date(startdate);
		new_scheme.setEnd_date(enddate);
		new_scheme.setCreated_by(user_id);
		new_scheme.setLast_updated_by(user_id);
		new_scheme.setActive_flag("Incomplete");		
		new_scheme.setRedemption_date(redemp_date);
		
		//System.out.println("Parent Scheme = "+new_scheme.getParent_scheme_code());
		
//		if(new_scheme.getParent_scheme_code() != null && new_scheme.getParent_scheme_code() != "") {
//	        
//			ArrayList<New_Scheme_mstr> ps = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id = '"+new_scheme.getParent_scheme_code()+"'");
//
//			if(!ps.isEmpty()){
//			
//			//new_scheme.setParent_scheme_name(ps.get(0).getScheme_name());
//			}
//	        }
		
		if(request.getParameter("created_on")!=null)
		{			
				try {
					if (!request.getParameter("created_on").equals("")) {
						created_on = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("created_on"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
			new_scheme.setCreation_date(created_on);
			new_scheme.setLast_update_date(new Date());
			
			String sql = "select MAX(SCHEME_ID) SCHEME_ID from BPIL_SCHEME_MASTER";
	 		List<New_Scheme_mstr_for_Crm> dml = jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr_for_Crm>() {

				@Override
				public New_Scheme_mstr_for_Crm mapRow(ResultSet rs, int rowNum) throws SQLException {
					New_Scheme_mstr_for_Crm aContact = new New_Scheme_mstr_for_Crm();
		
					aContact.setScheme_id(rs.getInt("SCHEME_ID"));
					
					
					return aContact;
				}
				
			});	
	 		
	 		int saveschid = dml.get(0).getScheme_id() + 1;
	 		new_scheme.setScheme_id(saveschid);
			
			int new_scheme_id = schemerequestdao.crmsaveheader(new_scheme);
		
			
/////save doc	 scheme realted
		String	scheme_document_comment = request.getParameter("scheme_document_comment");
			
			   if (null != doc_file && doc_file.length>0) 
		        {
		            for (MultipartFile multipartFile : doc_file) {
		 
		            	Crm_Bpil_Scheme_Doc docs = new Crm_Bpil_Scheme_Doc();
		            	
		                String fileName = multipartFile.getOriginalFilename();
		                
		                try {
							docs.setDoc_file(multipartFile.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
		                docs.setDoc_title(multipartFile.getOriginalFilename());
		                docs.setDoc_type("Scheme Document");
		                docs.setScheme_id(new_scheme_id);
		                docs.setComments(scheme_document_comment);
		                docs.setCreation_date(new Date());
		                docs.setLast_update_date(new Date());
		              
		                
		                 long size = multipartFile.getSize();
		                if(size>0)
		                {
		                	  //rev=new_scheme.getRevision();
//				                rev=rev+1;
				                docs.setRevision(rev);
		                 int doc_id = schemerequestdao.crmsavedocs(docs);
		                }
		                 
		            }
		        }
			
			   String sch_code = new_scheme.getScheme_code();
			   String sr_no = Integer.toString(new_scheme_id);
			   String serial_num = sch_code.concat(sr_no);
			   new_scheme.setScheme_code(serial_num);
			 //  new_scheme.setRevision(rev);
			   new_scheme.setScheme_srl_no(sr_no);
			   
			   int new_scheme_id2 = schemerequestdao.crmsaveheader(new_scheme);   

////save doc	others
				
			   String	other_document_comment = request.getParameter("other_document_comment");
			   
				   if (null != doc_file1 && doc_file1.length>0) 
			        {
			            for (MultipartFile multipartFile : doc_file1) {
			 
			            	Crm_Bpil_Scheme_Doc docs = new Crm_Bpil_Scheme_Doc();
			            	
			                String fileName = multipartFile.getOriginalFilename();
			                
			                try {
								docs.setDoc_file(multipartFile.getBytes());
							} catch (IOException e) {
								e.printStackTrace();
							}
			                docs.setDoc_title(multipartFile.getOriginalFilename());
			                docs.setDoc_type("Other Document");
			                docs.setScheme_id(new_scheme_id);
			                docs.setComments(other_document_comment);
			                
			             //   rev1=new_scheme.getRevision();			              
			                docs.setRevision(rev1);
			                docs.setCreation_date(new Date());
			                docs.setLast_update_date(new Date());
			                
			                 long size = multipartFile.getSize();
			                if(size>0)
			                {
			                 int doc_id = schemerequestdao.crmsavedocs(docs);
			                }
			                 
			            }
			        }
/// save scheme cust type
				   
				   if(request.getParameter("cust_type")!=null) {
					   System.out.println("in ------------cust_type");
					   String cust_type[] = request.getParameterValues("cust_type");
					   
					   int custlen = cust_type.length;
					   
					   int prod_id = schemerequestdao.savecust_type(custlen, cust_type, new_scheme_id);
					   System.out.println("-----------lllllll---------");
					   System.out.println("--------------------"+prod_id);
					   
				   }
				   
				   
				   
//// save product info
			 
			String str2 = "";
		  if(request.getParameter("sch_prd_line_type")!=null && request.getParameter("sch_prd_exceptions")!=null && request.getParameter("sch_product_id")!=null && request.getParameter("vol_grwth_pct")!=null && request.getParameter("val_grwth_pct")!=null &&  request.getParameter("spread_pct")!=null && request.getParameter("spend_per_ltr")!=null)
				   {
			  
			String sch_prd_unique_id[] = request.getParameterValues("sch_prd_unique_id");
			String sch_prd_line_type[] = request.getParameterValues("sch_prd_line_type");
			String sch_product_id[] = request.getParameterValues("sch_product_id");
			String sch_prd_exceptions[] = request.getParameterValues("sch_prd_exceptions");
			String vol_grwth_pct[] = request.getParameterValues("vol_grwth_pct");
			String val_grwth_pct[] = request.getParameterValues("val_grwth_pct");
			String spread_pct[] = request.getParameterValues("spread_pct");			
			String spend_per_ltr[] = request.getParameterValues("spend_per_ltr");
			
			System.out.println(sch_prd_unique_id.toString()+"        sch_prd_unique_id");
			System.out.println(sch_prd_line_type.toString()+"        sch_prd_line_type");
			System.out.println(sch_product_id.toString()+"        sch_product_id");
			System.out.println(sch_prd_exceptions.toString()+"        sch_prd_exceptions");
			System.out.println(vol_grwth_pct.toString()+"        vol_grwth_pct");
			System.out.println(val_grwth_pct.toString()+"        val_grwth_pct");
			
			System.out.println(spread_pct.toString()+"        spread_pct");
			System.out.println(spend_per_ltr.toString()+"        spend_per_ltr");
			int len1 = vol_grwth_pct.length;				 
				 
				 int prod_id = schemerequestdao.saveproduct(len1,new_scheme_id,sch_prd_unique_id,sch_prd_line_type,sch_product_id,sch_prd_exceptions,vol_grwth_pct,val_grwth_pct,spread_pct,spend_per_ltr);  
				   
				for(int i=0;i<sch_product_id.length;i++)
					{
							System.out.println("in ctrl"+sch_product_id[i]);
							str2+=sch_product_id[i];
							
						    if(i<sch_product_id.length-1) // Avoiding the last comma
						    {
						    	str2+=",";
						    }
					}
					
		 }
				 
				//	new_scheme.setAttribute2(scheme_document_comment);  //scheme doc comments
				//	new_scheme.setAttribute3(other_document_comment);  //oyher doc comments
					//new_scheme.setSch_product_codes(str2);
					new_scheme.setLast_update_date(new Date());
				 int new_scheme_id1 = schemerequestdao.crmsaveheader(new_scheme);
				 
			//// save product outflow info
				 
					String str3 = "";
				  if(request.getParameter("sch_prd_outflow_line_type")!=null && request.getParameter("sch_product_outflow_id")!=null 
						  && request.getParameter("sch_prd_lly_vol")!=null && request.getParameter("sch_prd_lly_val")!=null 
						  && request.getParameter("sch_prd_ly_vol")!=null &&  request.getParameter("sch_prd_ly_val")!=null
						  && request.getParameter("sch_prd_spread_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_tgt_val")!=null
						  && request.getParameter("sch_prd_spread_mtd_ly_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ly_val")!=null
						  && request.getParameter("proj_grwth_vol_pct")!=null && request.getParameter("proj_grwth_val_pct")!=null 
						  && request.getParameter("proj_grwth_spd_pct")!=null 
						  && request.getParameter("sch_prd_ty_vol")!=null &&  request.getParameter("sch_prd_ty_val")!=null 
						  && request.getParameter("sch_prd_spread_mtd_ty_tgt_vol")!=null &&  request.getParameter("sch_prd_spread_mtd_ty_tgt_val")!=null 
						  && request.getParameter("sch_prd_wt_avg")!=null &&  request.getParameter("sch_prd_total_prd_bdgt")!=null)
						   {
					String sch_prd_outflow_unique_id[] = request.getParameterValues("sch_prd_outflow_unique_id");
					String sch_prd_outflow_line_type[] = request.getParameterValues("sch_prd_outflow_line_type");
					String sch_product_outflow_id[] = request.getParameterValues("sch_product_outflow_id");
					String sch_prd_lly_vol[] = request.getParameterValues("sch_prd_lly_vol");
					String sch_prd_lly_val[] = request.getParameterValues("sch_prd_lly_val");
					String sch_prd_ly_vol[] = request.getParameterValues("sch_prd_ly_vol");
					String sch_prd_ly_val[] = request.getParameterValues("sch_prd_ly_val");			
					String sch_prd_spread_tgt_vol[] = request.getParameterValues("sch_prd_spread_tgt_vol");
					String sch_prd_spread_tgt_val[] = request.getParameterValues("sch_prd_spread_tgt_val");
					String sch_prd_spread_mtd_ly_vol[] = request.getParameterValues("sch_prd_spread_mtd_ly_vol");
					String sch_prd_spread_mtd_ly_val[] = request.getParameterValues("sch_prd_spread_mtd_ly_val");
					String proj_grwth_vol_pct[] = request.getParameterValues("proj_grwth_vol_pct");
					String proj_grwth_val_pct[] = request.getParameterValues("proj_grwth_val_pct");
					String proj_grwth_spd_pct[] = request.getParameterValues("proj_grwth_spd_pct");
					String sch_prd_ty_vol[] = request.getParameterValues("sch_prd_ty_vol");
					String sch_prd_ty_val[] = request.getParameterValues("sch_prd_ty_val");
					String sch_prd_spread_mtd_ty_tgt_vol[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_vol");
					String sch_prd_spread_mtd_ty_tgt_val[] = request.getParameterValues("sch_prd_spread_mtd_ty_tgt_val");
					String sch_prd_wt_avg[] = request.getParameterValues("sch_prd_wt_avg");			
					String sch_prd_total_prd_bdgt[] = request.getParameterValues("sch_prd_total_prd_bdgt");
					
					int len1 = sch_product_outflow_id.length;				 
						 
						 int prod_id = schemerequestdao.saveproductoutflow(len1,new_scheme_id,
								 sch_prd_outflow_unique_id,sch_prd_outflow_line_type,sch_product_outflow_id,
								 sch_prd_lly_vol,sch_prd_lly_val,sch_prd_ly_vol,sch_prd_ly_val,
								 sch_prd_spread_tgt_vol,sch_prd_spread_tgt_val,
								 sch_prd_spread_mtd_ly_vol,sch_prd_spread_mtd_ly_val,
								 proj_grwth_vol_pct,proj_grwth_val_pct,proj_grwth_spd_pct,sch_prd_ty_vol,sch_prd_ty_val,
								 sch_prd_spread_mtd_ty_tgt_vol,sch_prd_spread_mtd_ty_tgt_val,
								 sch_prd_wt_avg,sch_prd_total_prd_bdgt);  
						   
						for(int i=0;i<sch_product_outflow_id.length;i++)
							{
									System.out.println("in ctrl"+sch_product_outflow_id[i]);
									str3+=sch_product_outflow_id[i];
									
								    if(i<sch_product_outflow_id.length-1) // Avoiding the last comma
								    {
								    	str3+=",";
								    }
							}
							
				 }
						 
						
						//	new_scheme.setAttribute5(str3);
//						 int new_scheme_id1 = schemerequestdao.saveheader(new_scheme);
							
						
				 
//// save sheme gift

		 if(request.getParameter("gift_code")!=null && request.getParameter("gift_group")!=null && request.getParameter("gift_name")!=null && request.getParameter("effective_price")!=null )
			 {
//			 String str[] = request.getParameterValues("appl_depot_code1[]"); // string separate by ,
				String[] sche_code = request.getParameterValues("gift_code");
				String[] gift_id = request.getParameterValues("gift_id");
				String[] gift_group = request.getParameterValues("gift_group");
				String[] gift_name = request.getParameterValues("gift_name");			
				String[] effective_price = request.getParameterValues("effective_price");
//				if(gift_group != null) {
				int len = gift_group.length;
					
				 int schemegift_id = schemerequestdao.savegift(user_id,new_scheme_id,len,sche_code,gift_id,gift_group,gift_name,effective_price);  
//				}
		 }
		 
/////////// entry into depots table
		 
	//	 int revsion = new_scheme.getRevision();
		   
						   CallableStatement cStmt;
					 		try {
					 		cStmt = hibernateConfiguration.dataSource()
									.getConnection().prepareCall("{call BPIL_POPULATE_SCH_DEPOT_DTLS(?,?,?,?)}");
					 		 									 		
					 		
					 		cStmt.setInt(1, new_scheme_id);
					 	//	cStmt.setInt(2,revsion);	
					 		cStmt.setInt(3, user_id);
					 		cStmt.registerOutParameter(4,Types.VARCHAR); 
					 		ResultSet rs1 = cStmt.executeQuery();
					 			 	
					 			String str111 =cStmt.getString(4);
					 			System.out.println("msg is="+str111);
					
					 		} catch (SQLException e) {
					 		e.printStackTrace();
					 		}
					 		catch (Exception e) {
					 		System.out.println(e.getMessage());
					 		} 
					 		
					 		ArrayList<New_Scheme_mstr_for_Crm> sm = (ArrayList<New_Scheme_mstr_for_Crm>) hibernateTemplate.find("from New_Scheme_mstr where scheme_id="+new_scheme_id);
							String schemecode=sm.get(0).getScheme_code();
							int createdby=sm.get(0).getCreated_by();
							ArrayList<Bpil_Users> su = (ArrayList<Bpil_Users>) hibernateTemplate.find("from Bpil_Users where user_id="+createdby);
							String createdby1=su.get(0).getUser_name();
					 		
					 		try {
					 			CallableStatement cStmt2;	
					 			
					 				cStmt2 = hibernateConfiguration.dataSource().getConnection()
					 						.prepareCall("{call BPIL_MAIL_ENTRY(?,?,?,?,?)}");
					 			

					 				cStmt2.setInt(1, createdby);
					 				cStmt2.setInt(2, new_scheme_id);
					 				cStmt2.setString(3, "NSR");
					 				cStmt2.setString(4, "New Scheme "+ schemecode + " registered in BSAT");
					 				cStmt2.registerOutParameter(5, Types.VARCHAR);
					 			ResultSet result = cStmt2.executeQuery();
					 			String flag = cStmt2.getString(5);
					 			System.out.println("scheme request mail flag "+ flag);
					 			
//					 			New Scheme 1718-ML7-497 is registered in BSAT
//					 			Scheme 1718-ML7-497 is updated in BSAT
					 			

					 			} catch (SQLException e) {
					 				// TODO Auto-generated catch block
					 				e.printStackTrace();
					 			}
					 		
					 		New_Scheme_mstr_for_Crm mstr = schememasterdao.crmschemeautofill(new_scheme_id);
							 if(mstr.getScheme_id() != Integer.parseInt(mstr.getScheme_srl_no())){
								 mstr.setScheme_srl_no(String.valueOf(mstr.getScheme_id()));
								 int srlSchemeId = schemerequestdao.crmsaveheader(mstr);
								 System.out.println("srlSchemeId "+srlSchemeId);
							 }
			return new ModelAndView("NewFile");		
	}
	
	

}


package com.omfys.bsat.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.omfys.bsat.repository.ReviewSchemeDao;
import com.omfys.bsat.repository.SchemeMasterDao;
import com.omfys.bsat.model.Bpil_Depot_Master;
import com.omfys.bsat.model.Bpil_Gift_Master;
import com.omfys.bsat.model.Bpil_Scheme_Benefit;
import com.omfys.bsat.model.Bpil_Scheme_Depots_Details;
import com.omfys.bsat.model.Bpil_Scheme_Doc;
import com.omfys.bsat.model.Bpil_Scheme_IT_Product;
import com.omfys.bsat.model.Bpil_Scheme_Product;
import com.omfys.bsat.model.Bpil_Scheme_Product_Outflow;
import com.omfys.bsat.model.Bpil_User_ProfileId_List;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.New_Scheme_mstr;

@Controller
public class ReviewSchemeController {

	@Autowired
	ReviewSchemeDao dao;

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Autowired
	SchemeMasterDao schememasterdao;

	@RequestMapping("/reviewscheme")
	public ModelAndView review(HttpServletRequest request, Model model, ModelMap map) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");
			int profile_id = (Integer) request.getSession().getAttribute("profileid");
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.IT_PROFILE_ID) {

					int user_id = (Integer) request.getSession().getAttribute("userid");

					String PMG_ML_Group = (String) request.getSession().getAttribute("PMG_ML_grp");

					ArrayList<New_Scheme_mstr> list = dao.showreviwe(user_id, profile_id, PMG_ML_Group);

					model.addAttribute("list", list);

					ArrayList<New_Scheme_mstr> Fin_Pending_list = dao.Fin_Pending_list(user_id, profile_id,
							PMG_ML_Group);

					model.addAttribute("Fin_Pending_list", Fin_Pending_list);

					return new ModelAndView("ReviewScheme");

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

	@RequestMapping("/launchscheme")
	public ModelAndView launchscheme(HttpServletRequest request, Model model, ModelMap map) {

		int user_id = (Integer) request.getSession().getAttribute("userid");

		int profile_id = (Integer) request.getSession().getAttribute("profileid");

		String PMG_ML_Group = (String) request.getSession().getAttribute("PMG_ML_grp");

		ArrayList<New_Scheme_mstr> list = dao.showlaunchscheme(user_id, profile_id, PMG_ML_Group);

		model.addAttribute("list", list);

		return new ModelAndView("LaunchScheme");

	}

	@RequestMapping("/reviewschemedetails")
	public ModelAndView reviewdetails(@RequestParam(value = "scheme_id") String scheme_id, ModelMap map, Model model,
			HttpServletRequest request) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");
			int profile_id = (Integer) request.getSession().getAttribute("profileid");
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.IT_PROFILE_ID) {

					String kwm_user = (String) request.getSession().getAttribute("kwm_user");
					if (kwm_user != null) {

						int schemeid = Integer.parseInt(scheme_id);

//								String username = (String) request.getSession().getAttribute("username");			

						New_Scheme_mstr mstr = schememasterdao.schemeautofill(schemeid);

						ArrayList<Bpil_Scheme_Doc> doc_line = schememasterdao.docautofill(schemeid);

						ArrayList<Bpil_Scheme_Benefit> gift_line = schememasterdao.giftautofill(schemeid);

						if (!gift_line.isEmpty()) {
							for (Bpil_Scheme_Benefit gift : gift_line) {
								int gift_id = gift.getGift_id();
								ArrayList<Bpil_Gift_Master> aa = (ArrayList<Bpil_Gift_Master>) hibernateTemplate
										.find("from Bpil_Gift_Master where gift_id="+gift_id);
								String name = aa.get(0).getGift_name();
								gift.setAttribute1(name);

							}

//						                model.addAttribute("gift_list",gift_line);
						}

//								if(mstr.getSch_reward_item()!=null)
//								{
//								        int gift_id = gift_line.get(0).getGift_id();

//								        ArrayList<Bpil_Gift_Master> dml = (ArrayList<Bpil_Gift_Master>) hibernateTemplate.find("from Bpil_Gift_Master where gift_id=?",gift_id);
//								        String name = dml.get(0).getGift_name();

//								        mstr.setGift_name(name);
//								}

						ArrayList<Bpil_Scheme_Product> prod = (ArrayList<Bpil_Scheme_Product>) hibernateTemplate
								.find("from Bpil_Scheme_Product where scheme_id="+ schemeid);

						ArrayList<Bpil_Scheme_IT_Product> itprd = (ArrayList<Bpil_Scheme_IT_Product>) hibernateTemplate
								.find("from Bpil_Scheme_IT_Product where scheme_id="+ schemeid);

						ArrayList<Bpil_Scheme_Product_Outflow> prdoutflow = (ArrayList<Bpil_Scheme_Product_Outflow>) hibernateTemplate
								.find("from Bpil_Scheme_Product_Outflow where scheme_id="+schemeid);

						for (Bpil_Scheme_Product_Outflow Product_Outflow : prdoutflow) {
							Product_Outflow.setLly_vol_div(Product_Outflow.getLly_vol() / 1000);
							Product_Outflow.setLly_val_div(Product_Outflow.getLly_val() / 10000000);
							Product_Outflow.setLy_vol_div(Product_Outflow.getLy_vol() / 1000);
							Product_Outflow.setLy_val_div(Product_Outflow.getLy_val() / 10000000);
							Product_Outflow.setProj_ty_vol_div(Product_Outflow.getProj_ty_vol() / 1000);
							Product_Outflow.setProj_ty_val_div(Product_Outflow.getProj_ty_val() / 10000000);
						}
						/*
						 * if(mstr.getAppl_depot_code()!=null || mstr.getAppl_depot_code()!="") { String
						 * depots = mstr.getAppl_depot_code(); String depo1[] = depots.split(",");
						 * String depo[] = new String[depo1.length] ; for(int i=0;i<depo1.length;i++) {
						 * ArrayList<Bpil_Depot_Master> getdata = (ArrayList<Bpil_Depot_Master>)
						 * hibernateTemplate.find("from Bpil_Depot_Master where depot_code=?",depo1[i]);
						 * 
						 * depo[i] = getdata.get(0).getDepot_name(); }
						 * model.addAttribute("depo1",depo1); model.addAttribute("depo",depo); }
						 */

						ArrayList<Bpil_Scheme_Depots_Details> schdepos = (ArrayList<Bpil_Scheme_Depots_Details>) hibernateTemplate
								.find("from Bpil_Scheme_Depots_Details where scheme_id="+ schemeid);

						int user_id = mstr.getCreated_by();
						ArrayList<Bpil_Users> getdata = (ArrayList<Bpil_Users>) hibernateTemplate
								.find("from Bpil_Users where user_id="+ user_id);

						String fname = getdata.get(0).getFirst_name();
						String lname = getdata.get(0).getLast_name();

						model.addAttribute("scheme_id", scheme_id);
						model.addAttribute("firstname", fname);
						model.addAttribute("lastname", lname);
						model.addAttribute("JSON", mstr);
						model.addAttribute("doc_list", doc_line);
						model.addAttribute("gift_list", gift_line);
						model.addAttribute("product_list", prod);
						model.addAttribute("it_product_list", itprd);
						model.addAttribute("product_outflow_list", prdoutflow);
						model.addAttribute("schdepos", schdepos);
					}

					return new ModelAndView("ReviewSchemeDetails");

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

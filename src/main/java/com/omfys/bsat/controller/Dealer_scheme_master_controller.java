package com.omfys.bsat.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.omfys.bsat.repository.SchemeMasterDao;
import com.omfys.bsat.model.Bpil_Scheme_Benefit;
import com.omfys.bsat.model.Bpil_Scheme_Doc;
import com.omfys.bsat.model.Bpil_User_ProfileId_List;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.New_Scheme_mstr;

@Controller
public class Dealer_scheme_master_controller {

	@Autowired
	SchemeMasterDao schememasterdao;

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	@RequestMapping("/dealerrewardanalysis")
	public ModelAndView dealer_schme(ModelMap map, Model model, HttpServletRequest request)// @RequestParam(value="scheme_id")
																							// String scheme_id,
	{

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				ArrayList<New_Scheme_mstr> n_s_m = (ArrayList<New_Scheme_mstr>) hibernateTemplate
						.find("from New_Scheme_mstr");

				model.addAttribute("dealer", n_s_m);

				return new ModelAndView("Dealer_scheme_master");

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

	@RequestMapping("/dealerschemedetails")
	public ModelAndView schemedetails(@RequestParam(value = "scheme_id") String scheme_id, ModelMap map, Model model,
			HttpServletRequest request) {
		String kwm_user = (String) request.getSession().getAttribute("kwm_user");
		if (kwm_user != null) {

			int schemeid = Integer.parseInt(scheme_id);

			String username = (String) request.getSession().getAttribute("username");

			New_Scheme_mstr mstr = schememasterdao.schemeautofill(schemeid);

			ArrayList<Bpil_Scheme_Doc> doc_line = schememasterdao.docautofill(schemeid);

			// ArrayList<Bpil_Scheme_Benefit> gift_line =
			// schememasterdao.giftautofill(schemeid);

			model.addAttribute("username", username);
			model.addAttribute("JSON", mstr);
			model.addAttribute("doc_list", doc_line);
			// model.addAttribute("gift_list",gift_line);
		}
		return new ModelAndView("Dealer_scheme_Details");
	}

//	dealer scheme history

	@RequestMapping("/schemehistory")
	public ModelAndView menugroup(HttpServletRequest request, ModelMap map, Model model) {

		ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate.find("from New_Scheme_mstr");

		model.addAttribute("history", dml);
		return new ModelAndView("SchemeHistory");
	}

	@RequestMapping("/historydetails")
	public ModelAndView Schemehistorydetails(@RequestParam(value = "scheme_id") String scheme_id,
			HttpServletRequest request, ModelMap map, Model model) {
		int schemeid = Integer.parseInt(scheme_id);

		New_Scheme_mstr mstr = schememasterdao.schemeautofill(schemeid);

		ArrayList<Bpil_Scheme_Doc> doc_line = schememasterdao.docautofill(schemeid);

		// ArrayList<Bpil_Scheme_Benefit> gift_line =
		// schememasterdao.giftautofill(schemeid);

		model.addAttribute("JSON", mstr);
		model.addAttribute("doc_list", doc_line);
		// model.addAttribute("gift_list",gift_line);
		return new ModelAndView("HistoryDetails");
	}

}

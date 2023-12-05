package com.omfys.bsat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.omfys.bsat.model.Bpil_Dealer_Master;
import com.omfys.bsat.model.Bpil_Depot_Master;
import com.omfys.bsat.model.Bpil_Headquarter_Master;
import com.omfys.bsat.model.Bpil_Region_Master;
import com.omfys.bsat.model.Bpil_User_ProfileId_List;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.service.RegionMasterService;

@Controller
public class RegionController {

	@Autowired
	RegionMasterService RegionService;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	@RequestMapping(value = "/InsertRegion", method = RequestMethod.GET)
	public ModelAndView saveServiceRequest(@ModelAttribute Bpil_Region_Master region_Master,
			BindingResult resultKoel_user, Model model, ModelMap map, HttpServletRequest request) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");
			Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				int user_id = (Integer) request.getSession().getAttribute("userid");

				String region_code = request.getParameter("group_code");
				String region_name = request.getParameter("group_name");
				String is_active = request.getParameter("is_active");

				region_Master.setRegion_code(region_code);
				region_Master.setRegion_name(region_name);
				region_Master.setIs_active(is_active);

				int newuserId = RegionService.InsertRegion(region_Master, user_id);
				System.out.println("newuserId " + newuserId);

				return new ModelAndView("NewRegionMaster");

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

	@RequestMapping(value = "/saveregion", method = RequestMethod.POST)
	public ModelAndView helloWorld(@ModelAttribute Bpil_Region_Master regionmaster, BindingResult result,
			HttpServletRequest request, Model model, ModelMap map) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");

			/* Login Checking Code Start */
			if (loginString.equals("Y")) {
				try {
					String region_code = request.getParameter("group_code");
					String region_name = request.getParameter("group_name");
					String is_active = request.getParameter("active");

					System.out.println("is_active::-" + is_active);
					if (!"Y".equals(is_active)) {
						regionmaster.setIs_active("N");
					} else {
						regionmaster.setIs_active(is_active);

					}

					regionmaster.setRegion_code(region_code);
					regionmaster.setRegion_name(region_name);
				} catch (Exception e) {
					e.printStackTrace();
				}

				RegionService.saveregion(regionmaster);

				return new ModelAndView("redirect:/getregionslist");

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

	@RequestMapping(value = "/saveregion")
	public ModelAndView showregion(@ModelAttribute Bpil_Region_Master regionmaster, BindingResult result,
			HttpServletRequest request, Model model) {

		return new ModelAndView("NewRegionMaster");
	}

	@RequestMapping("/regionslist")
	public ModelAndView regionlist(@ModelAttribute Bpil_Region_Master region_Master, BindingResult resultKoel_user,
			Model model, ModelMap map, HttpServletRequest request) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");
			Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				return new ModelAndView("RegionsList");

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

	@RequestMapping("/getregionslist")
	public ModelAndView getRegionList(ModelMap map, Model model, HttpServletRequest request,
			HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");
			Integer profile_id = (Integer) request.getSession().getAttribute("profileid");

			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					List<Bpil_Region_Master> users = RegionService.getRegionList();
					model.addAttribute("regionmaster", users);
					return new ModelAndView("RegionMaster");
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

	@RequestMapping("/updateregion")
	public ModelAndView updatemenugroup(@RequestParam(value = "regionid") String region_id, HttpServletRequest request,
			Model model, ModelMap map) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");

			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				int reg_id = Integer.parseInt(region_id);
				Bpil_Region_Master bpil_Region_Master = RegionService.updateregion(reg_id);

				model.addAttribute("JSON", bpil_Region_Master);

				return new ModelAndView("NewRegionMaster");

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
	
	@RequestMapping("/regionalmanagement")
	public ModelAndView regionalmanagement(HttpServletRequest request, Model model, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					//List<Bpil_MenuGroup> menugroup_list = menugrpdao.menugroupgrid();

					//model.addAttribute("menu_grp_list", menugroup_list);

					return new ModelAndView("RegionalManagement");
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
	@RequestMapping(value = "/saveHeadquarter", method = RequestMethod.POST)
	public ModelAndView saveHeadquarter(@ModelAttribute Bpil_Headquarter_Master headquartermaster, BindingResult result,
			HttpServletRequest request, Model model, ModelMap map) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");

			/* Login Checking Code Start */
			if (loginString.equals("Y")) {
				try {
					String region_code = request.getParameter("headquarter_code");
					String region_name = request.getParameter("headquarter_name");
					String is_active = request.getParameter("is_active");

					System.out.println("is_active::-" + is_active);
					if (!"Y".equals(is_active)) {
						headquartermaster.setIs_active("N");
					} else {
						headquartermaster.setIs_active(is_active);

					}

					headquartermaster.setHeadquarter_code(region_code);
					headquartermaster.setHeadquarter_name(region_name);
				} catch (Exception e) {
					e.printStackTrace();
				}

				RegionService.saveheadquarter(headquartermaster);

				return new ModelAndView("redirect:/regionalmanagement");

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
	@RequestMapping(value = "/saveRegion", method = RequestMethod.POST)
	public ModelAndView saveRegion(@ModelAttribute Bpil_Region_Master regionmaster, BindingResult result,
			HttpServletRequest request, Model model, ModelMap map) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");

			/* Login Checking Code Start */
			if (loginString.equals("Y")) {
				try {
					int headquarter_id = Integer.parseInt(request.getParameter("headquarter_id"));
					String region_code = request.getParameter("group_code");
					String region_name = request.getParameter("group_name");
					String is_active = request.getParameter("active");

					System.out.println("is_active::-" + is_active);
					if (!"Y".equals(is_active)) {
						regionmaster.setIs_active("N");
					} else {
						regionmaster.setIs_active(is_active);

					}
					regionmaster.setHeadquarter_id(headquarter_id);
					regionmaster.setRegion_code(region_code);
					regionmaster.setRegion_name(region_name);
				} catch (Exception e) {
					e.printStackTrace();
				}

				RegionService.saveregion(regionmaster);

				return new ModelAndView("redirect:/regionalmanagement");

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
	@RequestMapping(value = "/loadheadquarter", method = RequestMethod.GET)
	public void loadheadquarter(HttpServletRequest request, Model model, HttpServletResponse response) {
		
		ArrayList<Bpil_Headquarter_Master> headquarters = (ArrayList<Bpil_Headquarter_Master>) hibernateTemplate.find("from Bpil_Headquarter_Master where is_active = 'Y'");
		
		String json = null;
		
		json = new Gson().toJson(headquarters);
		response.setContentType("application/json");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/loadRegions", method = RequestMethod.GET)
	public void loadRegions(@RequestParam(value="headquarter_id")int headquarter_id,HttpServletRequest request, Model model, HttpServletResponse response) {
		
		ArrayList<Bpil_Region_Master> regions = (ArrayList<Bpil_Region_Master>) hibernateTemplate.find("from Bpil_Region_Master where is_active = 'Y' and headquarter_id = "+headquarter_id);
		
		String json = null;
		
		json = new Gson().toJson(regions);
		response.setContentType("application/json");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/loadDistributors", method = RequestMethod.GET)
	public void loadDistributors(@RequestParam(value="region_name")String region_name,HttpServletRequest request, Model model, HttpServletResponse response) {
		
		ArrayList<Bpil_Depot_Master> distributors = (ArrayList<Bpil_Depot_Master>) hibernateTemplate.find("from Bpil_Depot_Master where regn = "+"'"+region_name+"'");
		
		String json = null;
		
		json = new Gson().toJson(distributors);
		response.setContentType("application/json");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/saveDistributor", method = RequestMethod.POST)
	public ModelAndView saveDistributor(@ModelAttribute Bpil_Depot_Master depot, BindingResult result,
			HttpServletRequest request, Model model, ModelMap map) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");

			/* Login Checking Code Start */
			if (loginString.equals("Y")) {
				try {
					String regn = request.getParameter("regn");
					depot.setRegn(regn);
					depot.setDsr_regn(regn);
				} catch (Exception e) {
					e.printStackTrace();
				}

				RegionService.saveDepot(depot);

				return new ModelAndView("redirect:/regionalmanagement");

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
	@RequestMapping(value = "/saveDealer", method = RequestMethod.POST)
	public ModelAndView saveDealer(@ModelAttribute Bpil_Dealer_Master dealer, BindingResult result,
			HttpServletRequest request, Model model, ModelMap map) {

		try {
			String loginString = (String) request.getSession().getAttribute("loginflag");

			/* Login Checking Code Start */
			if (loginString.equals("Y")) {
				try {
					String depot_code = request.getParameter("depot_code1");
					dealer.setDepot_code(depot_code);
				} catch (Exception e) {
					e.printStackTrace();
				}

				RegionService.saveDealer(dealer);

				return new ModelAndView("redirect:/regionalmanagement");

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

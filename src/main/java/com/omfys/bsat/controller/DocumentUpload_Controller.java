package com.omfys.bsat.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.omfys.bsat.repository.DocumentUploadDao;
import com.omfys.bsat.model.DocumentGrid_Autofill;
import com.omfys.bsat.model.Bpil_Document_Master;
import com.omfys.bsat.model.Bpil_User_ProfileId_List;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.service.DocumentUploadService;

@Controller
public class DocumentUpload_Controller {

	@Autowired
	private DocumentUploadDao DocumentUploadDao;

	public DocumentUploadDao getFiledownload() {
		return DocumentUploadDao;
	}

	public void setFiledownload(DocumentUploadDao DocumentUploadDao) {
		this.DocumentUploadDao = DocumentUploadDao;
	}

	@Autowired
	DocumentUploadService doc_upload;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/AdminUpload")
	public ModelAndView DocumentLoad(ModelMap map, Model model, HttpServletRequest request) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				if (profile_id == Bpil_User_ProfileId_List.ADMIN_PROFILE_ID) {
					Bpil_Document_Master document = new Bpil_Document_Master();

					List<DocumentGrid_Autofill> Doc_List = doc_upload.Loaddoc();

					for (int i = 0; i < Doc_List.size(); i++) {
						System.out.println("hello");
					}
					model.addAttribute("Doc_List", Doc_List);

					map.addAttribute("document", document);

					return new ModelAndView("DocumentUpload");
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

	@RequestMapping(value = "/UploadDocument", method = RequestMethod.POST)
	public ModelAndView saveServiceRequest(@ModelAttribute Bpil_Document_Master Koel_doc, BindingResult resultKoel_doc,
			@RequestParam CommonsMultipartFile upload_file, ModelMap map, HttpServletRequest request, Model model) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				String description = request.getParameter("Description");
				Koel_doc.setFile_description(description);
				Date start_date = null;
				try {
					start_date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("active_start_date"));
				} catch (ParseException e) {

					e.printStackTrace();
				}
				Date end_date = null;
				try {
					end_date = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("active_end_date"));
				} catch (ParseException e) {

					e.printStackTrace();
				}
				Koel_doc.setActive_start_date(start_date);
				Koel_doc.setActive_end_date(end_date);

				Koel_doc.setCreated_by(1);
				Koel_doc.setLast_updated_by(1);

				Double uploadfile = 0d;

				if (upload_file != null) {

					System.out.println("Saving file: " + upload_file.getOriginalFilename());

					uploadfile = (double) upload_file.getSize();
					System.out.println("SIze   " + uploadfile);

					Koel_doc.setFile_name(upload_file.getOriginalFilename());
					Koel_doc.setDoc_file(upload_file.getBytes());
					Koel_doc.setFile_type(upload_file.getContentType());
					Koel_doc.setFile_size(upload_file.getSize());

				}

				if (uploadfile > 0) {

					int doc_id = doc_upload.UploadDocs(Koel_doc);
					System.out.println(doc_id);
				}

				List<DocumentGrid_Autofill> Doc_List = doc_upload.Loaddoc();

				for (int i = 0; i < Doc_List.size(); i++) {

				}
				model.addAttribute("Doc_List", Doc_List);

				return new ModelAndView("DocumentUpload");

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

	@RequestMapping(value = "/DownloadDocument", method = RequestMethod.GET)
	public byte[] DownloadFileRequest(@RequestParam(value = "Doc_id") String doc_id, ModelAndView model,
			HttpServletResponse response) {

		int docment_id = Integer.parseInt(doc_id);
		@SuppressWarnings("unchecked")
		ArrayList<Bpil_Document_Master> Doc_List = (ArrayList<Bpil_Document_Master>) hibernateTemplate
				.find("from Koel_Document_Master where document_id=?", docment_id);

		for (int i = 0; i < Doc_List.size(); i++) {
			System.out.println(Doc_List.get(i).getFile_name());
		}

		response.setContentType(Doc_List.get(0).getFile_type());
		response.setContentLength(Doc_List.get(0).getDoc_file().length);
		response.setHeader("Content-Disposition", "attachment; filename =\"" + Doc_List.get(0).getFile_name() + "\"");
		try {
			FileCopyUtils.copy(Doc_List.get(0).getDoc_file(), response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Doc_List.get(0).getDoc_file();
	}

	@RequestMapping(value = "/DeleteDocument", method = RequestMethod.GET)
	public String DeleteFileRequest(@RequestParam(value = "Doc_id") String doc_id, HttpServletResponse response,
			Model model, HttpServletRequest request, ModelMap map) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		Integer profile_id = (Integer) request.getSession().getAttribute("profileid");
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				int docment_id = Integer.parseInt(doc_id);

				Session session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				Bpil_Document_Master doc = (Bpil_Document_Master) session.load(Bpil_Document_Master.class, docment_id);

				session.delete(doc);
				tx.commit();

				List<DocumentGrid_Autofill> Doc_List = doc_upload.Loaddoc();

				for (int i = 0; i < Doc_List.size(); i++) {
					System.out.println("hello");
				}
				model.addAttribute("Doc_List", Doc_List);

				model.addAttribute("doc", doc);
				System.out.println("out");

				return "DocumentUpload";

			} else {
				Bpil_Users kwm_users = new Bpil_Users();
				map.addAttribute("kwm_users", kwm_users);
				System.out.println("Here ------> berger login"); // Cursor comes to here
				return "login";
			}
			/* Login Checking Code Ends */
		} catch (NullPointerException e) {
			Bpil_Users kwm_users = new Bpil_Users();
			map.addAttribute("kwm_users", kwm_users);
			System.out.println("Here ------> berger login"); // Cursor comes to here
			return "login";
		}

	}

	///////////////////////////////////// below code for admin publicly put file for
	///////////////////////////////////// download///////////////////

	@RequestMapping("/AdminDownloadfile")
	public ModelAndView DocumentDownload(ModelMap map, Model model, HttpServletRequest request) {

		String loginString = (String) request.getSession().getAttribute("loginflag");
		
		try {
			/* Login Checking Code Start */
			if (loginString.equals("Y")) {

				Bpil_Document_Master document = new Bpil_Document_Master();

				List<DocumentGrid_Autofill> Doc_List = doc_upload.Loaddoc();

				for (int i = 0; i < Doc_List.size(); i++) {
					System.out.println("hello");
				}
				model.addAttribute("Doc_List", Doc_List);

				map.addAttribute("document", document);

				return new ModelAndView("DownLoadDoc");

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

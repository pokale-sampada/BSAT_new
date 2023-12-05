package com.omfys.bsat.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import com.omfys.bsat.repository.ForgotPasswordDao;
import com.omfys.bsat.repository.HierarchySetUpDao;
import com.omfys.bsat.repository.MenuRegisterDao;
import com.omfys.bsat.repository.NewsLoginDAO;

import com.omfys.bsat.model.HierarchySetUp;
import com.omfys.bsat.model.HierarchySetUp1;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_Users;

import com.omfys.bsat.model.News_Login;


import sun.misc.BASE64Decoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Controller
public class ForgotPasswordController {

	@Autowired
	private NewsLoginDAO contactDAO1;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ForgotPasswordDao contactDAO;

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	
	public static final String ALGORITHM = "AES";
    public static final String KEY = "1Hbfh667adfDEJ78";
	
	@RequestMapping(value="/forgotpassword")
	public ModelAndView forgotpassword(ModelAndView model,ModelMap map) throws IOException
	{		
		return new ModelAndView("forgotpassword");
		
	}

	@Transactional
	@RequestMapping(value = "/forgot_password", method = RequestMethod.POST)
	public ModelAndView updatedistributormaster(@ModelAttribute Bpil_Users menuregister,Model model, BindingResult result, 
			ModelMap map, HttpServletRequest request) throws ParseException
	{
		Bpil_Users kwm_users1 = new Bpil_Users();
		
		String user_name = request.getParameter("user_name");

			System.out.println("user Name"+user_name);
			List<Bpil_Users> ForgotPassword_List = contactDAO.ForgotPassword_List(user_name);
			//model.addObject("distributor_master_list", distributor_master_list);
			//model.setViewName("distributormaster");
			//System.out.println(".............password :"+ForgotPassword_List.get(0).getPassword());
			//System.out.println(".................Email :"+ForgotPassword_List.get(0).getEmail_address());
			String email1=null;
			String password=null;
			
			if(ForgotPassword_List.get(0).getEmail_address()!=null && ForgotPassword_List.get(0).getPassword()!=null)
			{
			   email1=ForgotPassword_List.get(0).getEmail_address();
			   password = ForgotPassword_List.get(0).getPassword();
			}
			if(email1.equals("no_email") && password.equals("no_password"))
			{
				model.addAttribute("kwm_users", kwm_users1);
				return new ModelAndView("login");
			}
			else
			{
					////////decrypt password //////			
			
			 Key key=null;
				try {
					key = generateKey();
				} catch (Exception e) {
					e.printStackTrace();
				}
		        Cipher cipher=null;
				try {
					cipher = Cipher.getInstance(ForgotPasswordController.ALGORITHM);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (NoSuchPaddingException e) {
					e.printStackTrace();
				}
		        try {
					cipher.init(Cipher.DECRYPT_MODE, key);
				} catch (InvalidKeyException e) {
					e.printStackTrace();
				}
		        byte[] decryptedValue64=null;
				try {
					decryptedValue64 = new BASE64Decoder().decodeBuffer(password);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
		        byte[] decryptedByteValue=null;
				try {
					decryptedByteValue = cipher.doFinal(decryptedValue64);
				} catch (IllegalBlockSizeException e) {
					e.printStackTrace();
				} catch (BadPaddingException e) {
					e.printStackTrace();
				}
		        String decryptedValue=null;
				try {
					decryptedValue = new String(decryptedByteValue,"utf-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
	///////////////////////////////////////////////////////////////////////////////////////////////////
			
				int ab=0;
			try {
				generateAndSendEmail(decryptedValue,email1,user_name);
				System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");

				ab = 5;
			} catch (MessagingException e) {
				e.printStackTrace();
				ab=3;
			}

			Bpil_Users kwm_users = new Bpil_Users();

			map.addAttribute("kwm_users", kwm_users);
		
			model.addAttribute("ab",ab);

			return new ModelAndView("login");

			}
	
	}

	public static void generateAndSendEmail(String password1,String email,String user_name) throws AddressException, MessagingException 
	{
	
		PreparedStatement stmt2;
		String host="bpilexchange.bergerindia.com";
		final String user="opaadmin@bergerindia.com";
		final String password="berger@123";
		String to = email;
		String subject="Forgot your password";
		String content="your password is ="+password1;
	    int i=0;
	    
			   Properties props = new Properties();
			   props.put("mail.smtp.host",host);
			   props.put("mail.smtp.auth", "true");
			  
			   Session session = Session.getDefaultInstance(props,
			    new javax.mail.Authenticator() {
			      protected PasswordAuthentication getPasswordAuthentication() {
			    	  	return new PasswordAuthentication(user,password);
			      	}
			    });

			   //Compose the message
			    try {
					     MimeMessage message = new MimeMessage(session);
					     message.setFrom(new InternetAddress(user));
					     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
					     message.setSubject(subject);
					     message.setText(content);
			    
			    //send the message
			     Transport.send(message);

			     System.out.println("message sent successfully...");
			 
			     } catch (Exception e) {
			    	 e.printStackTrace();
			
			     }	
	}

	 //////password //////
	 
	 private static Key generateKey() throws Exception 
	    {
	        Key key = new SecretKeySpec(UserRegistration_Controller.KEY.getBytes(),UserRegistration_Controller.ALGORITHM);
	        return key;
	    }
	 
	
}
	

	


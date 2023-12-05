package com.omfys.bsat;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omfys.bsat.model.Employee;
import com.omfys.bsat.model.Employee1;
import com.omfys.bsat.model.EmployeeList;
import com.sun.mail.smtp.SMTPTransport;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Security;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
//@ComponentScan({ "com.omfys.bsat" })
//@EntityScan("com.omfys.bsat.model")
public class BSATApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	static
	HibernateTemplate hibernateTemplate;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BSATApplication.class);
	}

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(BSATApplication.class, args);
		System.out.println("In the main method");
		
		
		
		
		
//		  Calendar calendar = Calendar.getInstance();
//		  Date currentTime=calendar.getTime();
//	      System.out.println("Current Date = " + calendar.getTime());
//	      calendar.add(Calendar.MINUTE, +5);
//	      System.out.println("Updated Date = " + calendar.getTime());
//	      String s="sdff12uytr2iong234aqw5y";
//	      int j=s.length();
//	      System.out.println(s.length());
//	      List<Character> o=new ArrayList<Character>();
//	      for(int i=0;i<j;i++)
//	      {
//	    	  char c=s.charAt(i);
//	    	  
//	    	  if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
//	    	  {
//	    		  System.out.println("yes");
//	    	  }
//	    	 
//	    	  else
//	    	  {
//	    		 o.add(c);
//	    	  }
//	    	  
//	    	  
//	      }
//	      System.out.println(o.toString());
//	      int k=0;
//	      int count=0;
//	      for(int i=0;i<o.size();i++)
//	      {
//	    	 if(count==0)
//	    	 {
//	    		 
//	    	 }
//	    	  k=k+i;
//	      }
//	      System.out.println(k);

		
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void run(String... args) throws Exception {

		// Email send Code
		/*
		 * Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider()); final
		 * String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		 * 
		 * // Get a Properties object Properties props = System.getProperties();
		 * props.setProperty("mail.smtps.host", "smtp.gmail.com");
		 * props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		 * props.setProperty("mail.smtp.socketFactory.fallback", "false");
		 * props.setProperty("mail.smtp.port", "465");
		 * props.setProperty("mail.smtp.socketFactory.port", "465");
		 * props.setProperty("mail.smtps.auth", "true");
		 * props.put("mail.smtps.quitwait", "false");
		 * 
		 * Session session = Session.getInstance(props, null);
		 * 
		 * // -- Create a new message -- final MimeMessage msg = new
		 * MimeMessage(session);
		 * 
		 * // -- Set the FROM and TO fields -- msg.setFrom(new
		 * InternetAddress("patil.kranti90@gmail.com"));
		 * msg.setRecipients(Message.RecipientType.TO,
		 * InternetAddress.parse("patil.kranti90@gmail.com", false));
		 * 
		 * if ("patil.kranti90@gmail.com".length() > 0) {
		 * msg.setRecipients(Message.RecipientType.CC,
		 * InternetAddress.parse("patil.kranti90@gmail.com", false)); }
		 * 
		 * msg.setSubject("Email Testing.....");
		 * msg.setText("Email Sent Successfully.............."); msg.setSentDate(new
		 * Date());
		 * 
		 * SMTPTransport t = (SMTPTransport)session.getTransport("smtps");
		 * 
		 * t.connect("smtp.gmail.com", "patil.kranti90@gmail.com", "krupapatil");
		 * t.sendMessage(msg, msg.getAllRecipients()); t.close();
		 */
		// Email send Code

	}

}

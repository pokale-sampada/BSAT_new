package com.omfys.bsat.email;

	

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public boolean sendEmail(String subject, String message, String to)
	{
		boolean f =false;
		String from="shilpinalanda@gmail.com";
		String host="smtp.gmail.com";
		Properties p=System.getProperties();
		System.out.println("Properties: "+ p);
		p.put("mail.smtp.host",	host);
		p.put("mail.smtp.port",	"465");
		p.put("mail.smtp.ssl.enable","true");
		p.put("mail.smtp.auth",	"true");
		Session session=Session.getInstance(p, new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication("shilpinalanda@gmail.com", "hpcghfulcofidbus");
			}
			
		});
		session.setDebug(true);
		MimeMessage m=new MimeMessage(session);
		try {
			m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			//m.setText(message);
			m.setContent(message,"text/html");
			Transport.send(m);
			System.out.println("sent email success");
			f=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}


}

package com.omfys.bsat.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NotifyDealer {

	public NotifyDealer()
	{
		System.out.println("hello");
	}
	 public static void main(String[] args) {
//		public NotifyDealer(String schemename) {

		 String schemename= "test";
		 
String host = "webmail.omfysgroup.com";
final String user = "helpdesk@omfysgroup.com";// change accordingly
final String password = "Zxcv@123";// change accordingly

String to = "pratiksoni@omfysgroup.com";
//String randomno1 = no;
//String fname = fnam;
// Get the session object
Properties props = new Properties();
props.put("mail.smtp.host", host);
props.put("mail.smtp.auth", "true");

Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, password);
	}
});

// Compose the message
try {
	MimeMessage message = new MimeMessage(session1);
	message.setFrom(new InternetAddress(user));
	message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	message.setSubject("Notification");
	message.setContent("<h5 style='color:blue'>Hello Sir</h5>" + "\n" + "\n "
			+ "\n	This mail is for notify you that there is one new scheme have launch name by "+schemename+". So please check it.", "text/html");
	// send the message
	Transport.send(message);

	System.out.println("message sent successfully...");

} catch (MessagingException e) {
	e.printStackTrace();
}
}


		////////////////////////////// new scheme created //////////////////////////////////////////
		
		public void  NewScheme(String schemename,String mailto,String createdby) {

			String host = "webmail.omfysgroup.com";
			final String user = "helpdesk@omfysgroup.com";// change accordingly
			final String password = "Zxcv@123";// change accordingly

			String to = mailto;
			//String randomno1 = no;
			//String fname = fnam;
			// Get the session object
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");

			Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});

			// Compose the message
			try {
				MimeMessage message = new MimeMessage(session1);
				message.setFrom(new InternetAddress(user));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("Notification");
				message.setContent("<h5 style='color:blue'>Hello Sir</h5>" + "\n" + "\n "
						+ "\n	This mail is for notify you that there is one new scheme have created by "+createdby+" and scheme name is : "+schemename+". So please review it.", "text/html");
				// send the message
				Transport.send(message);

				System.out.println("message sent successfully...");

			} catch (MessagingException e) {
				e.printStackTrace();
			}
			}

				
		///////////////////////////// end here /////////////////////////////////////////////////////



}

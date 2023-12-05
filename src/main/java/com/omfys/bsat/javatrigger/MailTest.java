package com.omfys.bsat.javatrigger;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.smtp.SMTPTransport;
import java.security.Security;
import java.util.Date;


public class MailTest {

	public static void main(String[] args) throws AddressException, MessagingException {
		// TODO Auto-generated method stub
		
//		String host = "bpilexchange.bergerindia.com";
		//String host = "bpilhombx01.bergerindia.com";
//		final String user = "erpsupport@bergerindia.com";// change accordingly
//		final String password = "berger@123";// change accordingly

//		final String user = "hosystems@bergerindia.com";// change accordingly
//		final String password = "Pass@123";// change accordingly

//		final String user = "networksupport@bergerindia.com";// change accordingly
//		final String password = "berger@123";// change accordingly

		
//		final String user = "mailsupport@bergerindia.com";// change accordingly
//		final String password = "berger@123";// change accordingly
		
		/*final String user = "opaadmin@bergerindia.com";// change accordingly
		final String password = "berger@123";// change accordingly*/

		/*String to = "kranti.patil@omfysgroup.com";
		String host = "smtp.omfysgroup.com";
		final String user = "kranti.patil@omfysgroup.com";// change accordingly
		final String password = "krupa@158";// change accordingly
		System.out.println("to "+to);
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
			System.out.println("subject Test");
			MimeMessage message = new MimeMessage(session1);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Test");
			message.setContent("<h5 style='color:blue'>Hello Sir</h5>" + "\n" + "\n "
					+ "\n	This mail is for notify you that there is one new scheme have created by  ", "text/html");
			// send the message
			
			String emailBody = "Body";
			System.out.println("emailbody "+emailBody);

			message.setText(emailBody);
			System.out.println("before mail send");
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}*/
		/*System.out.println("In the mail sending main method");
	
		  // Recipient's email ID needs to be mentioned.
        String to = "patil.kranti90@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "patil.kranti90@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("patil.kranti90@gmail.com", "krupapatil");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
*/
		
	/*	
		
		String host = "smtp.omfysgroup.com";
		final String user = "prashant.shrangare@omfysgroup.com";// change accordingly
		final String password = "Prash@123";// change accordingly
		final String port = "587";

		String to = "kranti.patil@omfysgroup.com";
		System.out.println("to "+to);
		//String randomno1 = no;
		//String fname = fnam;
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
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
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("Test mail");


		message.setContent("This is trial mail", "text/html");
		System.out.println("before mail send");
		Transport.send(message);
		} catch (MessagingException mex) {
		mex.printStackTrace();

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
	        try {
				msg.setFrom(new InternetAddress("ujansingg@gmail.com"));
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ujangirase@gmail.com", false));

	        if ("ujangirase@gmail.com".length() > 0) {
	            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse("ujangirase@gmail.com", false));
	        }

	        msg.setSubject("Email Testing.....");
	        msg.setText("Email Sent Successfully..............");
	        msg.setSentDate(new Date());

	        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

	        t.connect("smtp.gmail.com", "ujansingg@gmail.com", "343RAMkrushna");
	        t.sendMessage(msg, msg.getAllRecipients());      
	        t.close();
		//Email send Code

		
    }	  
	}



package com.omfys.bsat.javatrigger;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.omfys.bsat.TilesConfiguration;

import oracle.jdbc.internal.OracleTypes;

public class MailTrigger implements Runnable {

	TilesConfiguration hibernateConfiguration;

	public MailTrigger(TilesConfiguration hibernateConfiguration) {
		this.hibernateConfiguration = hibernateConfiguration;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		int i = 0;
//		int i1 = 0;
//		int count = 0;
//		String flag="N";
		
		Date LYSD=new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(LYSD);
		cal.add(Calendar.MINUTE, +1);
		LYSD = cal.getTime();
		System.out.println("enter in thread mailTrigger");
		while (true) {
			CallableStatement cStmt2;
//			if (i == 0) {
				try {
					/*cStmt2 = hibernateConfiguration.dataSource().getConnection()
							.prepareCall("{call KOEL_GET_TIME_DETAIL(?)}");*/
//					cStmt2.registerOutParameter(1, Types.VARCHAR);
//					ResultSet result2 = cStmt2.executeQuery();
//					String flag = cStmt2.getString(1);
//					if (flag.equals("Y")) {

						// DateFormat dateFormat = new
						// SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						// Calendar cal = Calendar.getInstance();
						// Calendar calendar = Calendar.getInstance();
						// calendar.setTime(cal.getTime());
						// int hours = calendar.get(Calendar.HOUR_OF_DAY);
						// int minutes = calendar.get(Calendar.MINUTE);
						// int seconds = calendar.get(Calendar.SECOND);

						// if(hours==0&&minutes==0&&seconds==0)
						// {
					
					
//						if (LYSD.equals(new Date())) {
							
							Connection connection= hibernateConfiguration.dataSource().getConnection();
							PreparedStatement stmt = null;
							PreparedStatement stmt2 = null;

						//	CallableStatement cStmt;
							/*
							// try {
							cStmt = hibernateConfiguration.dataSource().getConnection()
									.prepareCall("{call KOEL_WASIB_APRL_ESACLATION()}");

							System.out.println("sp for mail sending data");

							ResultSet result = cStmt.executeQuery();
*/
							
							
							stmt = connection.prepareStatement(
									"select * from BPIL_MAIL_COMMUNICATIONS where STATUS = 'Pending'");

							ResultSet mails = stmt.executeQuery();
							System.out.println("mail statment");
							if(mails!=null)
							{
//								System.out.println("mails "+mails);
							}else{
								System.out.println("no mails");
							}
							while (mails.next()) {
								
//////////////////////////////////// new code for testing////////////////////////////////////////////////////
								


//								String host = "bpilexchange.bergerindia.com";
								String host = "bpilhombx01.bergerindia.com";
								final String user = "opaadmin@bergerindia.com";// change accordingly
								final String password = "berger@123";// change accordingly

								String to = mails.getString("TO_MAIL");
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
//								try {
									System.out.println("subject "+mails.getString("SUBJECT"));
									MimeMessage message = new MimeMessage(session1);
									message.setFrom(new InternetAddress(user));
									message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
									message.setSubject(mails.getString("SUBJECT"));
									/*message.setContent("<h5 style='color:blue'>Hello Sir</h5>" + "\n" + "\n "
											+ "\n	This mail is for notify you that there is one new scheme have created by  ", "text/html");
									// send the message
									*/
									String emailBody = mails.getString("BODY");
									System.out.println("emailbody "+emailBody);

									message.setText(emailBody);
									System.out.println("before mail send");
									Transport.send(message);

									System.out.println("message sent successfully...");

//								} catch (MessagingException e) {
//									e.printStackTrace();
//								}
								
////////////////////////////////////////////////////////////////////////////////////////////////////////////								
								
								
								
								
								
								/*
								System.out.println("mail sending data");
								String to = mails.getString("TO_MAIL");

								System.out.println(to);

								// Sender's email ID needs to be mentioned
								// String from = mails.getString("FROM_MAIL");
								String from = "helpdesk@omfysgroup.com";

								// Assuming you are sending email from localhost
								String host = "mail.omfysgroup.com";

								// Get system properties
								Properties properties = System.getProperties();

								// Setup mail server
								properties.setProperty("mail.omfysgroup.com", host);

								// Get the default Session object.
								Session session = Session.getDefaultInstance(properties);

								try {
									// Create a default MimeMessage object.
									MimeMessage message = new MimeMessage(session);

									// Set From: header field of the header.
									message.setFrom(new InternetAddress(from));

									// Set To: header field of the header.
									message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

									// Set Subject: header field
									message.setSubject(mails.getString("SUBJECT"));
									System.out.println(mails.getString("SUBJECT"));

									// Now set the actual message
									String emailBody = mails.getString("BODY");
									System.out.println(emailBody);

									message.setText(emailBody);
									
									// Send message
									 Transport.send(message);
									System.out.println("Sent message successfully.....................................");
								} catch (MessagingException mex) {
									mex.printStackTrace();
								}
*/
								stmt2 = connection.prepareStatement(
										"update BPIL_MAIL_COMMUNICATIONS set STATUS = 'Completed' WHERE STATUS = 'Pending' and SUBJECT = '" + mails.getString("SUBJECT") + "'");

								stmt2.executeUpdate();

								System.out.println("mail send update");
								
								
							}
							

							// } catch (SQLException e) {
							// e.printStackTrace();
							// }
							// catch (Exception e) {
							// System.out.println(e.getMessage());
							// }

//							System.out.println("ok");
//							i1++;
//							System.out.println(i1);
//							count++;
							
							
							
							connection.close();
							
							LYSD=new Date();
							Calendar cal2 = Calendar.getInstance();
							cal2.setTime(LYSD);
							cal2.add(Calendar.MINUTE, +2);
							LYSD = cal.getTime();

							
//						}
						
						
						
//						stmt.close();
//						stmt2.close();
						
//					}

					// if(hours==0&&minutes>0&&seconds>0)
					// {
					// count=0;

					// }

					// }

				} catch (MessagingException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
					Thread.sleep(84000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

//			i++;
//			if (i > 8000) {
//				i = 0;
//				
//				
////				flag="Y";
//			}
//		}

	}
}

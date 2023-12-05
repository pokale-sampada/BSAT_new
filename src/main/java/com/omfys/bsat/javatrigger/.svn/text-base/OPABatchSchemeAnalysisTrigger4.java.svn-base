package com.omfys.bsat.javatrigger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_BatSchAnalysis_Process_Queue2;
import com.omfys.bsat.model.Bpil_BatSchAnalysis_Process_Queue4;
import com.omfys.bsat.model.Bpil_Scheme_Exception;
import com.omfys.bsat.model.New_Scheme_mstr;

import oracle.jdbc.internal.OracleTypes;

public class OPABatchSchemeAnalysisTrigger4 implements Runnable {

	TilesConfiguration hibernateConfiguration;

	HibernateTemplate hibernateTemplate;

	JdbcTemplate jdbcTemplate;

	Environment environment;

	public OPABatchSchemeAnalysisTrigger4(TilesConfiguration hibernateConfiguration,
			HibernateTemplate hibernateTemplate, JdbcTemplate jdbcTemplate, Environment environment) {

		this.hibernateConfiguration = hibernateConfiguration;
		this.hibernateTemplate = hibernateTemplate;
		this.jdbcTemplate = jdbcTemplate;
		this.environment = environment;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		Date LYSD=new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(LYSD);
		cal.add(Calendar.MINUTE, +1);
		LYSD = cal.getTime();
		System.out.println("enter in thread OPABatchSchemeAnalysisTrigger4");
		
		while (true) {

			try {
				
//				if (LYSD.equals(new Date())) {
				
				Connection connection = hibernateConfiguration.dataSource().getConnection();
				
//				System.out.println("calling BPIL_GET_SCH_AN_FLAG2");
				CallableStatement cStmt = connection.prepareCall("{call BPIL_GET_SCH_AN_FLAG4(?)}");
				cStmt.registerOutParameter(1, Types.VARCHAR);
				
				ResultSet result = cStmt.executeQuery();
				String flag = cStmt.getString(1);
//				System.out.println("BPIL_GET_SCH_AN_FLAG2 =" +flag);
				
				cStmt.close();
				if (flag.equals("Y")) {

					ArrayList<Bpil_BatSchAnalysis_Process_Queue4> rewprocessqueue = (ArrayList<Bpil_BatSchAnalysis_Process_Queue4>) hibernateTemplate
							.find("from Bpil_BatSchAnalysis_Process_Queue4 where status='Pending' order by scheme_id asc");

					System.out.println("Pending Bpil_BatSchAnalysis_Process_Queue4 = " + rewprocessqueue.size());

					for (Bpil_BatSchAnalysis_Process_Queue4 bpil_Process_Queue : rewprocessqueue) {
						
						Date strDate = new Date();
						Format formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
						String strtime = formatter.format(strDate);
						
						Statement statementschstart = connection.createStatement();
						String updateschstartquery = "UPDATE BPIL_SCH_ANALYSIS_QUEUE4 "
								+ "set STARTTIME = TO_DATE('"+strtime+"', 'DD-MON-YYYY HH24:MI:SS'), "
								+ "ENDTIME = '' where SCH_ANALYSIS_QUEUE_ID = "+bpil_Process_Queue.getSch_analysis_queue_id();
						System.out.println(updateschstartquery);
						statementschstart.executeUpdate(updateschstartquery);
						
						statementschstart.close();

						System.out.println("Starting Sch bat analysis for schid = " + bpil_Process_Queue.getScheme_id()
								+ " schcode = " + bpil_Process_Queue.getScheme_code() + " schnm = " + bpil_Process_Queue.getScheme_name());

						int scheme_id = bpil_Process_Queue.getScheme_id();
						String scheme_code = bpil_Process_Queue.getScheme_code();
						
						ArrayList<New_Scheme_mstr> sch = (ArrayList<New_Scheme_mstr>) hibernateTemplate
								.find("from New_Scheme_mstr where scheme_id=?", scheme_id);

						System.out.println("calling BPIL_FLUSH_OPA_SCH_AN_OUTPUT");
						CallableStatement checkoutputStmt = connection.prepareCall("{call BPIL_FLUSH_OPA_SCH_AN_OUTPUT(?,?)}");
						checkoutputStmt.setInt(1, scheme_id);
						checkoutputStmt.registerOutParameter(2, Types.VARCHAR);
						
						ResultSet resultout = checkoutputStmt.executeQuery();
						String checkoutputflag = checkoutputStmt.getString(2);
						System.out.println("BPIL_FLUSH_OPA_SCH_AN_OUTPUT =" + checkoutputflag);
						
						checkoutputStmt.close();
						if (checkoutputflag.equals("Y")) {
							
							Date getspstarttime = new Date();
							String spstrtime = formatter.format(getspstarttime);
							
							Statement statementspstart = connection.createStatement();
							String updatespstartquery = "UPDATE BPIL_SCH_ANALYSIS_QUEUE4 "
									+ "set SP_STARTTIME = TO_DATE('"+spstrtime+"', 'DD-MON-YYYY HH24:MI:SS') , "
									+ "SP_ENDTIME = '' where SCH_ANALYSIS_QUEUE_ID = "+bpil_Process_Queue.getSch_analysis_queue_id();
							System.out.println(updatespstartquery);
							statementspstart.executeUpdate(updatespstartquery);

							statementspstart.close();

							System.out.println("calling BPIL_SCH_AN_INPUT_ENTRY4");
							CallableStatement getschinputStmt = connection.prepareCall("{call BPIL_SCH_AN_INPUT_ENTRY4(?,?,?)}");
							getschinputStmt.setInt(1, scheme_id);
							getschinputStmt.registerOutParameter(2, Types.VARCHAR);
							getschinputStmt.registerOutParameter(3, Types.VARCHAR);

							ResultSet resultinput = getschinputStmt.executeQuery();

							String getschinputflag = getschinputStmt.getString(2);
							String getschinputexp = getschinputStmt.getString(3);

							System.out.println("BPIL_SCH_AN_INPUT_ENTRY4 flag =" + getschinputflag);
							System.out.println("BPIL_SCH_AN_INPUT_ENTRY4 exp =" + getschinputexp);
							
							getschinputStmt.close();
							
							Date getspendtime = new Date();
							String spendtime = formatter.format(getspendtime);
							
							Statement statementspend = connection.createStatement();
							String updatespendquery = "UPDATE BPIL_SCH_ANALYSIS_QUEUE4 "
									+ "set SP_ENDTIME = TO_DATE('"+spendtime+"', 'DD-MON-YYYY HH24:MI:SS') "
									+ "where SCH_ANALYSIS_QUEUE_ID = "+bpil_Process_Queue.getSch_analysis_queue_id();
							System.out.println(updatespendquery);
							statementspend.executeUpdate(updatespendquery);
							
							statementspend.close();
							if (getschinputflag.equals("Y")) {

								String schemebatfilename = sch.get(0).getSch_an_batch_file();
								String schemedirname = sch.get(0).getSch_dir_name();

								String BatfilePath = environment.getRequiredProperty("BatfilePath");

								System.out.println("sch bat file name = " + schemebatfilename + " schdir name = " + schemedirname);

								System.out.println("sch bat file BatfilePath = " + BatfilePath);

								System.out.println("Running Sch Batch DB processing for schid = " + scheme_id);
								List<String> cmdAndArgs = new ArrayList<String>();

								// String [] arg = {"cmd", "/c", "run-BPIL-ML12-454-1617-DB.bat"};

								String[] arg = { "cmd", "/c", schemebatfilename };
								cmdAndArgs = Arrays.asList(arg);
								
								// .asList({"cmd", "/c", "horse_batch_cmd.bat"});

								// File dir = new File("D:/Oracle/OPA/OPA
								// Setups/OPA_Nov2016_v12.2.5.644.0/opa/examples/determinations-batch/BPIL-ML12-454-1617");

								File dir = new File(BatfilePath + "/" + schemedirname);
								
								//Validation of schemes before proceeding for scheme analysis
								boolean dirflag = false;
								boolean batfileflag = false;
								
								String schemeDirectory = "BPIL_SCH_"+sch.get(0).getScheme_business_line()+"_"+sch.get(0).getScheme_id()+"_"+sch.get(0).getScheme_fin_yr();
								
								if(schemedirname != null) {
									
									if(schemeDirectory.equals(schemedirname)) {
										
										dirflag = new File(BatfilePath + "/" + schemeDirectory).exists();
										
										if(dirflag == false) {
											
											System.out.println("Scheme Directory "+BatfilePath+"/"+schemeDirectory+" is not present");
											
											ArrayList<Bpil_Scheme_Exception> rwexcp = (ArrayList<Bpil_Scheme_Exception>) hibernateTemplate
													.find("from Bpil_Scheme_Exception where scheme_id=? and exception = ?", scheme_id,
													"Scheme Directory "+BatfilePath+"/"+schemeDirectory+" is not present");
											
											if(!rwexcp.isEmpty()) {
												
//												Iterator<Bpil_Scheme_Exception> itr = rwexcp.iterator();
//												while(itr.hasNext()) {
//												
//													Bpil_Scheme_Exception excp = itr.next();
//													if(excp.getScheme_id() == sch.get(0).getScheme_id() 
//															&& excp.getException().equals("Scheme Directory "+BatfilePath+"/"+schemeDirectory+" is not present")) {
//														
//													} else {
//														
//														Statement statement = connection.createStatement();
//														statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
//																+ "'"+sch.get(0).getScheme_id()+"', 'Scheme Directory "+BatfilePath+"/"+schemeDirectory+" is not present',"
//																+ "SYSDATE,'"+sch.get(0).getScheme_code()+"')");
//														statement.close();
//													}
//												
//												}
											
											} else {
												
												Statement statement = connection.createStatement();
												statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
														+ "'"+sch.get(0).getScheme_id()+"', 'Scheme Directory "+BatfilePath+"/"+schemeDirectory+" is not present',"
														+ "SYSDATE,'"+sch.get(0).getScheme_code()+"')");
												statement.close();
											}

										} else {
											
											dirflag = true;
											
											String schemeBatfile = "BPIL_SCH_"+sch.get(0).getScheme_business_line()+"_"+sch.get(0).getScheme_id()+"_"+sch.get(0).getScheme_fin_yr()+"_SCH_AN_Batch.bat";
											
											if(schemebatfilename != null) {
												
												if(schemeBatfile.equals(schemebatfilename)) {
													
													batfileflag = new File(BatfilePath + "/" + schemeDirectory + "/" + schemeBatfile).exists();
													
													if(batfileflag == false) {
														
														System.out.println("Scheme Bat file "+BatfilePath+"/"+schemeDirectory+"/"+schemeBatfile+" is not present");
														
														ArrayList<Bpil_Scheme_Exception> rwexcp = (ArrayList<Bpil_Scheme_Exception>) hibernateTemplate
																.find("from Bpil_Scheme_Exception where scheme_id=? and exception = ?", scheme_id,
																"Scheme Bat file "+BatfilePath+"/"+schemeDirectory+"/"+schemeBatfile+" is not present");
														
														if(!rwexcp.isEmpty()) {
															
//															Iterator<Bpil_Scheme_Exception> itr = rwexcp.iterator();
//															while(itr.hasNext()) {
//																
//																Bpil_Scheme_Exception excp = itr.next();
//																if(excp.getScheme_id() == sch.get(0).getScheme_id() 
//																		&& excp.getException().equals("Scheme Bat file "+BatfilePath+"/"+schemeDirectory+"/"+schemeBatfile+" is not present")) {
//																	
//																} else {
//																	
//																	Statement statement = connection.createStatement();
//																	statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
//																			+ "'"+sch.get(0).getScheme_id()+"', 'Scheme Bat file "+BatfilePath+"/"+schemeDirectory+"/"+schemeBatfile+" is not present',"
//																			+ "SYSDATE,'"+sch.get(0).getScheme_code()+"')");
//																	statement.close();
//																}
//															
//															}

														} else {
															
															Statement statement = connection.createStatement();
															statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
																	+ "'"+sch.get(0).getScheme_id()+"', 'Scheme Bat file "+BatfilePath+"/"+schemeDirectory+"/"+schemeBatfile+" is not present',"
																	+ "SYSDATE,'"+sch.get(0).getScheme_code()+"')");
															statement.close();
														}
													
													} else {
														
														batfileflag = true;
													}
												
												} else {
													
													System.out.println("Scheme Bat file name is wrong, it must be : "+schemeBatfile);
													
													ArrayList<Bpil_Scheme_Exception> rwexcp = (ArrayList<Bpil_Scheme_Exception>) hibernateTemplate
															.find("from Bpil_Scheme_Exception where scheme_id=? and exception = ?", scheme_id,
															"Scheme Bat file name is wrong, it must be : "+schemeBatfile);
													
													if(!rwexcp.isEmpty()) {
														
//														Iterator<Bpil_Scheme_Exception> itr = rwexcp.iterator();
//														while(itr.hasNext()) {
//															
//															Bpil_Scheme_Exception excp = itr.next();
//															if(excp.getScheme_id() == sch.get(0).getScheme_id() 
//																	&& excp.getException().equals("Scheme Bat file name is wrong, it must be : "+schemeBatfile)) {
//																
//															} else {
//																
//																Statement statement = connection.createStatement();
//																statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
//																		+ "'"+sch.get(0).getScheme_id()+"', 'Scheme Bat file name is wrong, it must be : "+schemeBatfile+"',"
//																		+ "SYSDATE,'"+sch.get(0).getScheme_code()+"')");
//																statement.close();
//															}
//														
//														}
													
													} else {
														
														Statement statement = connection.createStatement();
														statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
																+ "'"+sch.get(0).getScheme_id()+"', 'Scheme Bat file name is wrong, it must be : "+schemeBatfile+"',"
																+ "SYSDATE,'"+sch.get(0).getScheme_code()+"')");
														statement.close();
													}
												
												}
											
											} else {
												
												System.out.println("Scheme Bat file Name is NULL");
												
												ArrayList<Bpil_Scheme_Exception> rwexcp = (ArrayList<Bpil_Scheme_Exception>) hibernateTemplate
														.find("from Bpil_Scheme_Exception where scheme_id=? and exception = ?", scheme_id,"Scheme Bat file Name is NULL");
												
												if(!rwexcp.isEmpty()) {
													
//													Iterator<Bpil_Scheme_Exception> itr = rwexcp.iterator();
//													while(itr.hasNext()) {
//														
//														Bpil_Scheme_Exception excp = itr.next();
//														if(excp.getScheme_id() == sch.get(0).getScheme_id() && excp.getException().equals("Scheme Bat file Name is NULL")) {
//															
//														} else {
//															
//															Statement statement = connection.createStatement();
//															statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
//																	+ "'"+sch.get(0).getScheme_id()+"', 'Scheme Bat file Name is NULL',"
//																	+ "SYSDATE,'"+sch.get(0).getScheme_code()+"')");
//															statement.close();
//														}
//													
//													}
												
												} else {
													
													Statement statement = connection.createStatement();
													statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
															+ "'"+sch.get(0).getScheme_id()+"', 'Scheme Bat file Name is NULL',SYSDATE,'"+sch.get(0).getScheme_code()+"')");
													statement.close();
												}
											
											}
										
										}
									
									} else {
										
										System.out.println("Scheme Directory name is wrong, it must be : "+schemeDirectory);
										
										ArrayList<Bpil_Scheme_Exception> rwexcp = (ArrayList<Bpil_Scheme_Exception>) hibernateTemplate
												.find("from Bpil_Scheme_Exception where scheme_id=? and exception = ?", scheme_id,
												"Scheme Directory name is wrong, it must be : "+schemeDirectory);
										
										if(!rwexcp.isEmpty()) {
											
//											Iterator<Bpil_Scheme_Exception> itr = rwexcp.iterator();
//											while(itr.hasNext()) {
//												
//												Bpil_Scheme_Exception excp = itr.next();
//												if(excp.getScheme_id() == sch.get(0).getScheme_id() 
//														&& excp.getException().equals("Scheme Directory name is wrong, it must be : "+schemeDirectory)) {
//													
//												} else {
//													
//													Statement statement = connection.createStatement();
//													statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
//															+ "'"+sch.get(0).getScheme_id()+"', 'Scheme Directory name is wrong, it must be : "+schemeDirectory+"',"
//															+ "SYSDATE,'"+sch.get(0).getScheme_code()+"')");
//													statement.close();
//												}
//											
//											}
										
										} else {
											
											Statement statement = connection.createStatement();
											statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
													+ "'"+sch.get(0).getScheme_id()+"', 'Scheme Directory name is wrong, it must be : "+schemeDirectory+"',"
													+ "SYSDATE,'"+sch.get(0).getScheme_code()+"')");
											statement.close();
										}
									
									}
								
								} else {
									
									System.out.println("Scheme Directory Name is NULL");
									
									ArrayList<Bpil_Scheme_Exception> rwexcp = (ArrayList<Bpil_Scheme_Exception>) hibernateTemplate
											.find("from Bpil_Scheme_Exception where scheme_id=? and exception = ?", scheme_id,"Scheme Directory Name is NULL");
									
									if(!rwexcp.isEmpty()) {

//										Iterator<Bpil_Scheme_Exception> itr = rwexcp.iterator();
//										while(itr.hasNext()) {
//										
//											Bpil_Scheme_Exception excp = itr.next();
//											if(excp.getScheme_id() == sch.get(0).getScheme_id() && excp.getException().equals("Scheme Directory Name is NULL")) {
//												
//											} else {
//												
//												Statement statement = connection.createStatement();
//												statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
//														+ "'"+sch.get(0).getScheme_id()+"', 'Scheme Directory Name is NULL',SYSDATE,'"+sch.get(0).getScheme_code()+"')");
//												statement.close();
//											}
//										
//										}
									
									} else {
										
										Statement statement = connection.createStatement();
										statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
												+ "'"+sch.get(0).getScheme_id()+"', 'Scheme Directory Name is NULL',SYSDATE,'"+sch.get(0).getScheme_code()+"')");
										statement.close();
									}
								
								}

								if(dirflag == true && batfileflag == true) {
									
									ProcessBuilder pb = new ProcessBuilder(cmdAndArgs);
									pb.directory(dir);
									Process process = pb.start();

									int waitForprocess = process.waitFor();

									if (waitForprocess == 0) {

										System.out.println("BAT script " + schemebatfilename + " process executed properly");

										String message = "Batch processing completed successfully";

										System.out.println(message);
										
										InputStream processIn = process.getInputStream();
										ByteArrayOutputStream processInbaos = new ByteArrayOutputStream();

										int processInch = -1;
										while ((processInch = processIn.read()) != -1) {
											processInbaos.write(processInch);
										}

										String processresponse = new String(processInbaos.toByteArray());
										System.out.println("process Response From Exe : " + processresponse);
										
										boolean schexp = processresponse.contains("Exception caught during processing");
										if(schexp) {
											
											System.out.println("Exception caught during processing BAT script " + schemebatfilename);
											
											ArrayList<Bpil_Scheme_Exception> rwexcp = (ArrayList<Bpil_Scheme_Exception>) hibernateTemplate
													.find("from Bpil_Scheme_Exception where scheme_id=? and exception = ?", scheme_id,
													"Exception caught during processing BAT script " + schemebatfilename);
											
											if(!rwexcp.isEmpty()) {
												
//												Iterator<Bpil_Scheme_Exception> itr = rwexcp.iterator();
//												while(itr.hasNext()) {
//													
//													Bpil_Scheme_Exception excp = itr.next();
//													if(excp.getScheme_id() == sch.get(0).getScheme_id() 
//															&& excp.getException().equals("Exception caught during processing BAT script " + schemebatfilename)) {
//														
//													} else {
//														
//														Statement statement = connection.createStatement();
//														statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
//																+ "'"+sch.get(0).getScheme_id()+"', 'Exception caught during processing BAT script " + schemebatfilename+"',"
//																+ "SYSDATE,'"+sch.get(0).getScheme_code()+"')");
//														statement.close();
//													}
//												
//												}
											
											} else {
												
												Statement statement = connection.createStatement();
												statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
														+ "'"+sch.get(0).getScheme_id()+"', 'Exception caught during processing BAT script " + schemebatfilename+"',"
														+ "SYSDATE,'"+sch.get(0).getScheme_code()+"')");
												statement.close();
											}
											
											System.out.println("Batch Processing Not Completed");
										} else {
										
											System.out.println("Batch Processing Completed");
											
											System.out.println("calling BPIL_SP_RECOMPILE");
											CallableStatement compInvalStmt = connection.prepareCall("{call BPIL_SP_RECOMPILE(?,?)}");
											compInvalStmt.setString(1, "BPIL_SCH_AN_INPUT_ENTRY4");
											compInvalStmt.registerOutParameter(2, Types.VARCHAR);
	
											ResultSet resultcompInval = compInvalStmt.executeQuery();
											String compInvalflag = compInvalStmt.getString(2);
											System.out.println("BPIL_SP_RECOMPILE =" + compInvalflag);
											
											compInvalStmt.close();
											
//											System.out.println("calling BPIL_SCH_AN_GIFT_DESC");
//											CallableStatement schrwgiftStmt = connection.prepareCall("{call BPIL_SCH_AN_GIFT_DESC(?)}");
//											schrwgiftStmt.setInt(1, scheme_id);
//											
//											ResultSet resultschrwgiftStmt = schrwgiftStmt.executeQuery();
//																			
//											schrwgiftStmt.close();
											
//											System.out.println("calling BPIL_SCH_AN_REWARDS_SORT");
//											CallableStatement schrwsortStmt = connection.prepareCall("{call BPIL_SCH_AN_REWARDS_SORT(?)}");
//											schrwsortStmt.setInt(1, scheme_id);
//	
//											ResultSet resultschrwsortStmt = schrwsortStmt.executeQuery();
//																			
//											schrwsortStmt.close();
											
											Date endDate = new Date();
											String endtime = formatter.format(endDate);
											 
											Statement statementschend = connection.createStatement();
											String updateschendquery = "UPDATE BPIL_SCH_ANALYSIS_QUEUE4 "
													+ "set ENDTIME = TO_DATE('"+endtime+"', 'DD-MON-YYYY HH24:MI:SS') "
													+ "where SCH_ANALYSIS_QUEUE_ID = "+bpil_Process_Queue.getSch_analysis_queue_id();
											System.out.println(updateschendquery);
											statementschend.executeUpdate(updateschendquery);
											
											statementschend.close();
										}
									
									} else {
										
										System.out.println("BAT script " + schemebatfilename + " process not executed properly");

										String message = "Batch processing not completed successfully";

										System.out.println(message);
										
										InputStream processErrStream = process.getErrorStream();
										ByteArrayOutputStream processErbaos = new ByteArrayOutputStream();

										int processErrch = -1;
										while ((processErrch = processErrStream.read()) != -1) {
											processErbaos.write(processErrch);
										}

										String processErresponse = new String(processErbaos.toByteArray());
										System.out.println("process Error From Exe : " + processErresponse);
										
										ArrayList<Bpil_Scheme_Exception> rwexcp = (ArrayList<Bpil_Scheme_Exception>) hibernateTemplate
												.find("from Bpil_Scheme_Exception where scheme_id=? and exception = ?", scheme_id,
												"BAT script " + schemebatfilename + " process not executed properly");
										
										if(!rwexcp.isEmpty()) {
											
//											Iterator<Bpil_Scheme_Exception> itr = rwexcp.iterator();
//											while(itr.hasNext()) {
//												
//												Bpil_Scheme_Exception excp = itr.next();
//												if(excp.getScheme_id() == sch.get(0).getScheme_id() 
//														&& excp.getException().equals("BAT script " + schemebatfilename + " process not executed properly")) {
//													
//												} else {
//													
//													Statement statement = connection.createStatement();
//													statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
//															+ "'"+sch.get(0).getScheme_id()+"', 'BAT script " + schemebatfilename + " process not executed properly',"
//															+ "SYSDATE,'"+sch.get(0).getScheme_code()+"')");
//													statement.close();
//												}
//											
//											}
										
										} else {
											
											Statement statement = connection.createStatement();
											statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
													+ "'"+sch.get(0).getScheme_id()+"', 'BAT script " + schemebatfilename + " process not executed properly',"
													+ "SYSDATE,'"+sch.get(0).getScheme_code()+"')");
											statement.close();
										}
										
										System.out.println("Batch Processing Not Completed");
									}
								
								}
								
							} else {
								
								ArrayList<Bpil_Scheme_Exception> rwexcp = (ArrayList<Bpil_Scheme_Exception>) hibernateTemplate
										.find("from Bpil_Scheme_Exception where scheme_id=? and exception = ?", scheme_id,getschinputexp);
								
								if(!rwexcp.isEmpty()) {
									
//									Iterator<Bpil_Scheme_Exception> itr = rwexcp.iterator();
//									while(itr.hasNext()) {
//										
//										Bpil_Scheme_Exception excp = itr.next();
//										if(excp.getScheme_id() == sch.get(0).getScheme_id() && excp.getException().equals(getschinputexp)) {
//											
//										} else {
//											
//											Statement statement = connection.createStatement();
//											statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
//													+ "'"+sch.get(0).getScheme_id()+"', '"+getschinputexp+"',SYSDATE,'"+sch.get(0).getScheme_code()+"')");
//											statement.close();
//										}
//									
//									}
								
								} else {
									
									Statement statement = connection.createStatement();
									statement.executeUpdate("INSERT INTO BPIL_SCHEME_EXCEPTION " + "VALUES (BPIL_SCHEME_EXCEPTION_S.nextval, "
											+ "'"+sch.get(0).getScheme_id()+"', '"+getschinputexp+"',SYSDATE,'"+sch.get(0).getScheme_code()+"')");
									statement.close();
								}
								
							}
						
						}

					}

				}
				
				connection.close();

				LYSD=new Date();
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(LYSD);
				cal2.add(Calendar.MINUTE, +2);
				LYSD = cal.getTime();

//				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Thread.sleep(84000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

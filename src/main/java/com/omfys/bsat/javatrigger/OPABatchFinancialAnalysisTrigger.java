package com.omfys.bsat.javatrigger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_BatFinAnalysis_Process_Queue;
import com.omfys.bsat.model.Bpil_BatSchAnalysis_Process_Queue;
import com.omfys.bsat.model.New_Scheme_mstr;

public class OPABatchFinancialAnalysisTrigger implements Runnable {
	
	TilesConfiguration hibernateConfiguration;

	HibernateTemplate hibernateTemplate;

	JdbcTemplate jdbcTemplate;
	
	Environment environment;
	
	

	public OPABatchFinancialAnalysisTrigger(TilesConfiguration hibernateConfiguration, HibernateTemplate hibernateTemplate,
			JdbcTemplate jdbcTemplate, Environment environment) {
		
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
		System.out.println("enter in thread OPABatchFinancialAnalysisTrigger");
		
		while (true) {

			try {
				
//				if (LYSD.equals(new Date())) {
				
				Connection connection = hibernateConfiguration.dataSource().getConnection();
				
				// System.out.println("calling BPIL_GET_FIN_AN_FLAG");
				CallableStatement cStmt = connection
						.prepareCall("{call BPIL_GET_FIN_AN_FLAG(?)}");

				cStmt.registerOutParameter(1, Types.VARCHAR);
				ResultSet result = cStmt.executeQuery();
				String flag = cStmt.getString(1);
				
				cStmt.close();
				// System.out.println("BPIL_GET_FIN_AN_FLAG =" +flag);
				if (flag.equals("Y")) {

					ArrayList<Bpil_BatFinAnalysis_Process_Queue> finprocessqueue = (ArrayList<Bpil_BatFinAnalysis_Process_Queue>) hibernateTemplate
							.find("from Bpil_BatFinAnalysis_Process_Queue where status='Pending' order by scheme_id asc");

					System.out.println("Pending Bpil_BatFinAnalysis_Process_Queue = " + finprocessqueue.size());

					for (Bpil_BatFinAnalysis_Process_Queue bpil_Process_Queue : finprocessqueue) {

						System.out.println("Starting Fin bat analysis for schid = " + bpil_Process_Queue.getScheme_id()
								+ " schcode = " + bpil_Process_Queue.getScheme_code() + " schnm = "
								+ bpil_Process_Queue.getScheme_name());

						int scheme_id = bpil_Process_Queue.getScheme_id();
						String scheme_code = bpil_Process_Queue.getScheme_code();

						System.out.println("calling BPIL_FLUSH_OPA_FIN_AN_OUTPUT");
						CallableStatement checkoutputStmt = connection
								.prepareCall("{call BPIL_FLUSH_OPA_FIN_AN_OUTPUT(?,?)}");

						checkoutputStmt.setInt(1, scheme_id);
						checkoutputStmt.registerOutParameter(2, Types.VARCHAR);
						ResultSet resultout = checkoutputStmt.executeQuery();
						String checkoutputflag = checkoutputStmt.getString(2);
						System.out.println("BPIL_FLUSH_OPA_FIN_AN_OUTPUT =" + checkoutputflag);
						if (checkoutputflag.equals("Y")) {

							 System.out.println("calling BPIL_OPA_FIN_AN_INPUT_ENTRY");
//							System.out.println("calling BPIL_FIN_AN_INPUT_ENTRY");
							CallableStatement getschinputStmt = connection
									 .prepareCall("{call BPIL_OPA_FIN_AN_INPUT_ENTRY(?,?)}");
//									.prepareCall("{call BPIL_FIN_AN_INPUT_ENTRY(?,?)}");
							getschinputStmt.setInt(1, scheme_id);
							getschinputStmt.registerOutParameter(2, Types.VARCHAR);

							ResultSet resultinput = getschinputStmt.executeQuery();

							String getschinputflag = getschinputStmt.getString(2);
							 System.out.println("BPIL_OPA_FIN_AN_INPUT_ENTRY =" +getschinputflag);
//							System.out.println("BPIL_FIN_AN_INPUT_ENTRY =" + getschinputflag);
							 
							 getschinputStmt.close();

							if (getschinputflag.equals("Y")) {

								ArrayList<New_Scheme_mstr> sch = (ArrayList<New_Scheme_mstr>) hibernateTemplate
										.find("from New_Scheme_mstr where scheme_id=?", scheme_id);
								String schemebatfilename = sch.get(0).getFin_an_batch_file();
								String schemedirname = sch.get(0).getSch_dir_name();

								String BatfilePath = environment.getRequiredProperty("BatfilePath");

								System.out.println(
										"fin bat file name = " + schemebatfilename + " schdir name = " + schemedirname);

								System.out.println("sch bat file BatfilePath = " + BatfilePath);

								System.out.println("Running Fin Batch DB processing for schid = " + scheme_id);
								List<String> cmdAndArgs = new ArrayList<String>();

								// String [] arg = {"cmd", "/c",
								// "run-BPIL-ML12-454-1617-DB.bat"};

								String[] arg = { "cmd", "/c", schemebatfilename };
								cmdAndArgs = Arrays.asList(arg);// .asList({"cmd",
																// "/c",
																// "horse_batch_cmd.bat"});

								// File dir = new File("D:/Oracle/OPA/OPA
								// Setups/OPA_Nov2016_v12.2.5.644.0/opa/examples/determinations-batch/BPIL-ML12-454-1617");

								File dir = new File(BatfilePath + "/" + schemedirname);

								ProcessBuilder pb = new ProcessBuilder(cmdAndArgs);
								pb.directory(dir);
								Process process = pb.start();

								int waitForprocess = process.waitFor();

								if (waitForprocess == 0) {

									System.out
											.println("BAT script " + schemebatfilename + " process executed properly");

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
									
									System.out.println("Batch Processing Completed");
									
									System.out.println("calling BPIL_SP_RECOMPILE");
									CallableStatement compInvalStmt = connection
											.prepareCall("{call BPIL_SP_RECOMPILE(?,?)}");

									compInvalStmt.setString(1, "BPIL_OPA_FIN_AN_INPUT_ENTRY");
									compInvalStmt.registerOutParameter(2, Types.VARCHAR);
									ResultSet resultcompInval = compInvalStmt.executeQuery();
									String compInvalflag = compInvalStmt.getString(2);
									System.out.println("BPIL_SP_RECOMPILE =" + compInvalflag);
									
									compInvalStmt.close();
									
//									System.out.println("calling BPIL_FIN_AN_GIFT_DESC");
//									CallableStatement finrwgiftStmt = connection
//											.prepareCall("{call BPIL_FIN_AN_GIFT_DESC(?)}");
	//
//									finrwgiftStmt.setInt(1, scheme_id);
//									ResultSet resultfinrwgiftStmt = finrwgiftStmt.executeQuery();
//																	
//									finrwgiftStmt.close();
									
									System.out.println("calling BPIL_FIN_AN_REWARDS_SORT");
									CallableStatement finrwsortStmt = connection
											.prepareCall("{call BPIL_FIN_AN_REWARDS_SORT(?)}");

									finrwsortStmt.setInt(1, scheme_id);
									ResultSet resultfinrwsortStmt = finrwsortStmt.executeQuery();
																	
									finrwsortStmt.close();

									System.out.println("calling BPIL_UPDATE_FIN_AN_QUEUE");
									CallableStatement cStmt2 = connection
											 .prepareCall("{call BPIL_UPDATE_FIN_AN_QUEUE(?,?)}");
									
									cStmt2.setInt(1, scheme_id);
									cStmt2.setInt(2, bpil_Process_Queue.getFin_analysis_queue_id());
									
									System.out.println("update process " + scheme_id + " " +
											+ bpil_Process_Queue.getFin_analysis_queue_id());
									ResultSet result2 = cStmt2.executeQuery();
									System.out.println("update BPIL_UPDATE_FIN_AN_QUEUE");
									
									cStmt2.close();


								} else {
									System.out.println(
											"BAT script " + schemebatfilename + " process not executed properly");

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
									
									System.out.println("Batch Processing Not Completed");
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

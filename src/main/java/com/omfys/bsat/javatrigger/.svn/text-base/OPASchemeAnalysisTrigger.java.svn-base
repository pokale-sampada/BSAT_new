package com.omfys.bsat.javatrigger;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;

import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.controller.CallOPA_RewardsAnalysis;
import com.omfys.bsat.model.Bpil_Process_Queue;

public class OPASchemeAnalysisTrigger implements Runnable {

	TilesConfiguration hibernateConfiguration;

	HibernateTemplate hibernateTemplate;

	JdbcTemplate jdbcTemplate;

	CallOPA_RewardsAnalysis callopa_rewardsanalysis;

	// OPASchemeAnalysisTrigger() {
	//
	// }
	//
	public OPASchemeAnalysisTrigger(TilesConfiguration hibernateConfiguration, HibernateTemplate hibernateTemplate,
			JdbcTemplate jdbcTemplate, CallOPA_RewardsAnalysis callopa_rewardsanalysis) {
		this.hibernateConfiguration = hibernateConfiguration;
		this.hibernateTemplate = hibernateTemplate;
		this.callopa_rewardsanalysis = callopa_rewardsanalysis;
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		Date LYSD=new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(LYSD);
		cal.add(Calendar.MINUTE, +1);
		LYSD = cal.getTime();
		System.out.println("enter in thread OPASchemeAnalysisTrigger");
		

		while (true) {

			try {
				
//				if (LYSD.equals(new Date())) {
				
				Connection connection = hibernateConfiguration.dataSource().getConnection();
				
				CallableStatement cStmt = connection
						.prepareCall("{call BPIL_GET_FLAG(?)}");

				cStmt.registerOutParameter(1, Types.VARCHAR);
				ResultSet result = cStmt.executeQuery();
				String flag = cStmt.getString(1);
				
				cStmt.close();

				if (flag.equals("Y")) {

					ArrayList<Bpil_Process_Queue> rewprocessqueue = (ArrayList<Bpil_Process_Queue>) hibernateTemplate
							.find("from Bpil_Process_Queue where status='Pending' order by scheme_id asc");

					for (Bpil_Process_Queue bpil_Process_Queue : rewprocessqueue) {

						String depot_code = bpil_Process_Queue.getSch_depot_code();
						int scheme_id = bpil_Process_Queue.getScheme_id();
						String scheme_code = Integer.toString(scheme_id);
						String finanalysis = null;
						String ProcessFlag = null;

						if (bpil_Process_Queue.getProcess_type().equals("Financial Analysis")) {
							finanalysis = "1";
							ProcessFlag = "F";
						} else if (bpil_Process_Queue.getProcess_type().equals("Reward Processing")) {
							finanalysis = "0";
							ProcessFlag = "R";
						}

						int Scheme_budget = callopa_rewardsanalysis.callopaprocess(depot_code, scheme_code,
								finanalysis);

						// bpil_Process_Queue.setAttribute1(Integer.toString(Scheme_budget));
						// bpil_Process_Queue.setStatus("Completed");
						//
						// String query="update BPIL_PROCESS_QUEUE set
						// ATTRIBUTE1='"+Scheme_budget+"', STATUS='Completed'
						// WHERE
						// QUEUE_ID='"+bpil_Process_Queue.getQueue_id()+"'";
						// jdbcTemplate.update(query);
						//
						// hibernateTemplate.saveOrUpdate(bpil_Process_Queue);

						CallableStatement cStmt2 = connection
								.prepareCall("{call BPIL_UPDATE_PROCESS_QUEUE(?,?,?,?)}");

						cStmt2.setInt(1, scheme_id);
						cStmt2.setString(2, ProcessFlag);
						cStmt2.setInt(3, Scheme_budget);
						cStmt2.setInt(4, bpil_Process_Queue.getQueue_id());

						System.out.println("update process " + scheme_id + " " + ProcessFlag + " " + Scheme_budget + " "
								+ bpil_Process_Queue.getQueue_id());
						ResultSet result2 = cStmt2.executeQuery();
						
						cStmt2.close();

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

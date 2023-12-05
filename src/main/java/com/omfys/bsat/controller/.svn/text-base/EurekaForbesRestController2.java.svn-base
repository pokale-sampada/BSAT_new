/**
 * 
 */
package com.omfys.bsat.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.omfys.bsat.model.EurekaEmpMaster;
import com.omfys.bsat.model.EurekaLevel0TransactionModel;


/**
 * @author Ujansing.Girase
 *
 */
@Controller
public class EurekaForbesRestController2 {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	Environment environment;

	@RequestMapping(value = "/showEurekaSchAnalysisSoapRest2")
	public ModelAndView showSalesSchAnReportSoapforL2(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "cycle_name") int cycle_name, @RequestParam(value = "emp_id") int emp_id,
			Model model) {

		String schopawebserviceUrl = "https://iflictest1.custhelp.com/iflicproduction__tst1/determinations-server/assess/soap/generic/12.2.1/EURFOB_AGT_INCENTIVES?wsdl";
		System.out.println("in Eureka Forbes scheme" + emp_id);

		String Sql = "select PERNR,EMP_NAME,HR_DESIGNATION,CYCLE from EURO_EMP_MASTER where PERNR = " + emp_id + " ";
		List<EurekaEmpMaster> L2Level = jdbcTemplate.query(Sql, new RowMapper<EurekaEmpMaster>() {

			@Override
			public EurekaEmpMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				EurekaEmpMaster l2level = new EurekaEmpMaster();
				l2level.setEmpId(rs.getInt("PERNR"));
				l2level.setEmpName(rs.getString("EMP_NAME"));
				l2level.setTransactionCycle(rs.getInt("CYCLE"));
				l2level.setHrDesignation("L2ZH");
				l2level.setTier("T01");
				return l2level;
			}
		});

		String L1Sql = "select PERNR,EMP_NAME,HR_DESIGNATION,CYCLE,SALES_GROUP from EURO_EMP_MASTER"
				+ " where HR_DESIGNATION = 'L1CH' and ACTIVE_FLAG = 'Y' and PERNR IN (select distinct(L1CH) from EURO_EMP_MASTER where L2ZH = "
				+ L2Level.get(0).getEmpId() + ")";
		List<EurekaEmpMaster> L1Level_obj = jdbcTemplate.query(L1Sql, new RowMapper<EurekaEmpMaster>() {
			@Override
			public EurekaEmpMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				EurekaEmpMaster l1level = new EurekaEmpMaster();
				l1level.setEmpId(rs.getInt("PERNR"));
				l1level.setEmpName(rs.getString("EMP_NAME"));
				l1level.setHrDesignation(rs.getString("HR_DESIGNATION"));
				l1level.setTransactionCycle(rs.getInt("CYCLE"));
				l1level.setSalesGroup(rs.getString("SALES_GROUP"));
				return l1level;
			}
		});
		L2Level.get(0).setL1level(L1Level_obj);

		for (int j = 0; j < L2Level.get(0).getL1level().size(); j++) {

			if (cycle_name == 10) {
				String l1tranSql = "SELECT PERNR,MATERIAL_CODE,MATERIAL_GROUP,ADJUSTABLE_SCALE_QTY,FINAL_NET_SALES,TRANS_CYCLE,COLLECTED_AMT,SALES_GROUP FROM EURO_TRANSACTION_MASTER"
						+ " WHERE PERNR = " + L2Level.get(0).getL1level().get(j).getEmpId();
				List<EurekaLevel0TransactionModel> L1Level_Transobj = jdbcTemplate.query(l1tranSql,
						new RowMapper<EurekaLevel0TransactionModel>() {

							@Override
							public EurekaLevel0TransactionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
								EurekaLevel0TransactionModel l1level_trans = new EurekaLevel0TransactionModel();
								l1level_trans.setEmpId(rs.getInt("PERNR"));
								l1level_trans.setTransactionCycle(rs.getInt("TRANS_CYCLE"));
								l1level_trans.setAdjustableScaleQuantity(rs.getInt("ADJUSTABLE_SCALE_QTY"));
								l1level_trans.setMaterialCode(rs.getString("MATERIAL_CODE"));
								l1level_trans.setMaterialgroup(rs.getString("MATERIAL_GROUP"));
								l1level_trans.setSales_group(rs.getString("SALES_GROUP"));
								l1level_trans.setFinalNetValue(rs.getFloat("FINAL_NET_SALES"));
								l1level_trans.setCollected_amt(rs.getFloat("COLLECTED_AMT"));
								return l1level_trans;
							}
						});
				L2Level.get(0).getL1level().get(j).setL1level_Trans(L1Level_Transobj);
			} else {
				String l1tranSql = "SELECT PERNR,MATERIAL_CODE,MATERIAL_GROUP,ADJUSTABLE_SCALE_QTY,FINAL_NET_SALES,TRANS_CYCLE,COLLECTED_AMT,SALES_GROUP FROM EURO_TRANSACTION_MASTER"
						+ " WHERE PERNR = " + L2Level.get(0).getL1level().get(j).getEmpId() + " AND TRANS_CYCLE = "
						+ cycle_name;
				List<EurekaLevel0TransactionModel> L1Level_Transobj = jdbcTemplate.query(l1tranSql,
						new RowMapper<EurekaLevel0TransactionModel>() {

							@Override
							public EurekaLevel0TransactionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
								EurekaLevel0TransactionModel l1level_trans = new EurekaLevel0TransactionModel();
								l1level_trans.setEmpId(rs.getInt("PERNR"));
								l1level_trans.setTransactionCycle(rs.getInt("TRANS_CYCLE"));
								l1level_trans.setAdjustableScaleQuantity(rs.getInt("ADJUSTABLE_SCALE_QTY"));
								l1level_trans.setMaterialCode(rs.getString("MATERIAL_CODE"));
								l1level_trans.setMaterialgroup(rs.getString("MATERIAL_GROUP"));
								l1level_trans.setSales_group(rs.getString("SALES_GROUP"));
								l1level_trans.setFinalNetValue(rs.getFloat("FINAL_NET_SALES"));
								l1level_trans.setCollected_amt(rs.getFloat("COLLECTED_AMT"));
								return l1level_trans;
							}
						});
				L2Level.get(0).getL1level().get(j).setL1level_Trans(L1Level_Transobj);
			}
			/*
			 * String l1tranSql =
			 * "SELECT PERNR,MATERIAL_CODE,MATERIAL_GROUP,ADJUSTABLE_SCALE_QTY,FINAL_NET_SALES,TRANS_CYCLE,COLLECTED_AMT FROM EURO_TRANSACTION_MASTER"
			 * + " WHERE PERNR = " +
			 * L2Level.get(i).getL1level().get(j).getEmpId() +
			 * " AND TRANS_CYCLE = " + cycle_name; // +
			 * " AND MATERIAL_GROUP = '" + // product_name + "'";
			 * List<EurekaLevel0TransactionModel> L1Level_Transobj =
			 * jdbcTemplate.query(l1tranSql, new
			 * RowMapper<EurekaLevel0TransactionModel>() {
			 * 
			 * @Override public EurekaLevel0TransactionModel mapRow(ResultSet
			 * rs, int rowNum) throws SQLException {
			 * EurekaLevel0TransactionModel l1level_trans = new
			 * EurekaLevel0TransactionModel();
			 * l1level_trans.setEmpId(rs.getInt("PERNR"));
			 * l1level_trans.setTransactionCycle(rs.getInt("TRANS_CYCLE"));
			 * l1level_trans.setAdjustableScaleQuantity(rs.getInt(
			 * "ADJUSTABLE_SCALE_QTY"));
			 * l1level_trans.setMaterialCode(rs.getString("MATERIAL_CODE"));
			 * l1level_trans.setMaterialgroup(rs.getString("MATERIAL_GROUP"));
			 * l1level_trans.setFinalNetValue(rs.getFloat("FINAL_NET_SALES"));
			 * l1level_trans.setCollected_amt(rs.getFloat("COLLECTED_AMT"));
			 * return l1level_trans; } });
			 * L2Level.get(i).getL1level().get(j).setL1level_Trans(
			 * L1Level_Transobj);
			 */

			// L0 level employess
			String L0levelSql = "select PERNR,EMP_NAME,HR_DESIGNATION,CYCLE,DOJ from EURO_EMP_MASTER where ACTIVE_FLAG = 'Y' and"
					+ " PERNR IN (select PERNR from EURO_EMP_MASTER where L1CH = "
					+ L2Level.get(0).getL1level().get(j).getEmpId() + ")";
			List<EurekaEmpMaster> L0Level = jdbcTemplate.query(L0levelSql, new RowMapper<EurekaEmpMaster>() {

				@Override
				public EurekaEmpMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
					EurekaEmpMaster l0level = new EurekaEmpMaster();
					l0level.setEmpId(rs.getInt("PERNR"));
					l0level.setEmpName(rs.getString("EMP_NAME"));
					l0level.setTransactionCycle(rs.getInt("CYCLE"));
					l0level.setHrDesignation(rs.getString("HR_DESIGNATION"));
					l0level.setDoj(rs.getString("DOJ"));
					return l0level;
				}

			});
			L2Level.get(0).getL1level().get(j).setL0level(L0Level);

			for (int k = 0; k < L2Level.get(0).getL1level().get(j).getL0level().size(); k++) {

				if (cycle_name == 10) {
					String l0tranSql = "SELECT PERNR,MATERIAL_CODE,MATERIAL_GROUP,ADJUSTABLE_SCALE_QTY,ACTUAL_SCALE_QTY,FINAL_NET_SALES,TRANS_CYCLE,COLLECTED_AMT FROM EURO_TRANSACTION_MASTER"
							+ " WHERE PERNR = " + L2Level.get(0).getL1level().get(j).getL0level().get(k).getEmpId();
					List<EurekaLevel0TransactionModel> L0Level_Transobj = jdbcTemplate.query(l0tranSql,
							new RowMapper<EurekaLevel0TransactionModel>() {

								@Override
								public EurekaLevel0TransactionModel mapRow(ResultSet rs, int rowNum)
										throws SQLException {
									EurekaLevel0TransactionModel l0level_trans = new EurekaLevel0TransactionModel();
									l0level_trans.setEmpId(rs.getInt("PERNR"));
									l0level_trans.setTransactionCycle(rs.getInt("TRANS_CYCLE"));
									l0level_trans.setAdjustableScaleQuantity(rs.getInt("ADJUSTABLE_SCALE_QTY"));
									l0level_trans.setActualScaleQuantity(rs.getInt("ACTUAL_SCALE_QTY"));
									l0level_trans.setMaterialCode(rs.getString("MATERIAL_CODE"));
									l0level_trans.setMaterialgroup(rs.getString("MATERIAL_GROUP"));
									l0level_trans.setFinalNetValue(rs.getFloat("FINAL_NET_SALES"));
									l0level_trans.setCollected_amt(rs.getFloat("COLLECTED_AMT"));
									return l0level_trans;
								}
							});
					L2Level.get(0).getL1level().get(j).getL0level().get(k).setL0level_Trans(L0Level_Transobj);
				} else {
					String l0tranSql = "SELECT PERNR,MATERIAL_CODE,MATERIAL_GROUP,ADJUSTABLE_SCALE_QTY,ACTUAL_SCALE_QTY,FINAL_NET_SALES,TRANS_CYCLE,COLLECTED_AMT FROM EURO_TRANSACTION_MASTER"
							+ " WHERE PERNR = " + L2Level.get(0).getL1level().get(j).getL0level().get(k).getEmpId()
							+ " AND TRANS_CYCLE = " + cycle_name;
					List<EurekaLevel0TransactionModel> L0Level_Transobj = jdbcTemplate.query(l0tranSql,
							new RowMapper<EurekaLevel0TransactionModel>() {

								@Override
								public EurekaLevel0TransactionModel mapRow(ResultSet rs, int rowNum)
										throws SQLException {
									EurekaLevel0TransactionModel l0level_trans = new EurekaLevel0TransactionModel();
									l0level_trans.setEmpId(rs.getInt("PERNR"));
									l0level_trans.setTransactionCycle(rs.getInt("TRANS_CYCLE"));
									l0level_trans.setAdjustableScaleQuantity(rs.getInt("ADJUSTABLE_SCALE_QTY"));
									l0level_trans.setActualScaleQuantity(rs.getInt("ACTUAL_SCALE_QTY"));
									l0level_trans.setMaterialCode(rs.getString("MATERIAL_CODE"));
									l0level_trans.setMaterialgroup(rs.getString("MATERIAL_GROUP"));
									l0level_trans.setFinalNetValue(rs.getFloat("FINAL_NET_SALES"));
									l0level_trans.setCollected_amt(rs.getFloat("COLLECTED_AMT"));
									return l0level_trans;
								}
							});
					L2Level.get(0).getL1level().get(j).getL0level().get(k).setL0level_Trans(L0Level_Transobj);
				}

				/*
				 * String l0tranSql =
				 * "SELECT PERNR,MATERIAL_CODE,MATERIAL_GROUP,ADJUSTABLE_SCALE_QTY,ACTUAL_SCALE_QTY,FINAL_NET_SALES,TRANS_CYCLE,COLLECTED_AMT FROM EURO_TRANSACTION_MASTER"
				 * + " WHERE PERNR = " +
				 * L2Level.get(i).getL1level().get(j).getL0level().get(k).
				 * getEmpId() + " AND TRANS_CYCLE = " + cycle_name; // + " AND
				 * // MATERIAL_GROUP // = '" + // product_name // + "'";
				 * List<EurekaLevel0TransactionModel> L0Level_Transobj =
				 * jdbcTemplate.query(l0tranSql, new
				 * RowMapper<EurekaLevel0TransactionModel>() {
				 * 
				 * @Override public EurekaLevel0TransactionModel
				 * mapRow(ResultSet rs, int rowNum) throws SQLException {
				 * EurekaLevel0TransactionModel l0level_trans = new
				 * EurekaLevel0TransactionModel();
				 * l0level_trans.setEmpId(rs.getInt("PERNR"));
				 * l0level_trans.setTransactionCycle(rs.getInt("TRANS_CYCLE"));
				 * l0level_trans.setAdjustableScaleQuantity(rs.getInt(
				 * "ADJUSTABLE_SCALE_QTY"));
				 * l0level_trans.setActualScaleQuantity(rs.getInt(
				 * "ACTUAL_SCALE_QTY"));
				 * l0level_trans.setMaterialCode(rs.getString("MATERIAL_CODE"));
				 * l0level_trans.setMaterialgroup(rs.getString("MATERIAL_GROUP")
				 * );
				 * l0level_trans.setFinalNetValue(rs.getFloat("FINAL_NET_SALES")
				 * );
				 * l0level_trans.setCollected_amt(rs.getFloat("COLLECTED_AMT"));
				 * return l0level_trans; } });
				 * L2Level.get(i).getL1level().get(j).getL0level().get(k).
				 * setL0level_Trans(L1Level_Transobj);
				 */

			}
		}
		// }
		EurekaEmpMaster data = new EurekaEmpMaster();
		data.setL2level(L2Level);

		// call rest req webservice
		callRest(data, schopawebserviceUrl, request);
		// call rest req webservice

		HttpSession session = request.getSession();
		session.setAttribute("Info_grid", data.getL2level());

		request.setAttribute("L2Level", L2Level);
		model.addAttribute("cycle", cycle_name);
		request.setAttribute("Info_grid", data.getL2level());
		return new ModelAndView("SalesSchemeAnalysis3");
	}

	// Webservice call code
	public void callRest(EurekaEmpMaster inputData, String schopawebserviceUrl, HttpServletRequest request) {

		String[] outcome = new String[] { "L2_LEVEL", "L2_COMMISSION", "L2_QUARTERLY_COMMISSION",
				"L2_OPERATIVE_INCENTIVE", "L2_CATEGORY", "L1_LEVEL", "L1_CATEGORY", "L1_COMMISSION",
				"L1_PRODUCTIVITY_OF_EC_EA", "L1_PRODUCTIVITY_OF_AG", "L1_TEAM_SALE_COMMISSION", "L1_SKU_INCENTIVE",
				"L0_COMMISSION", "L0_SKU_INCENTIVE", "L0_CATEGORY", "L0_VINTAGE_PERIOD", "L0_LEVEL",
				"L1_INCENTIVE_VALIDATION_FLAG", "L1_FINAL_NET_VALUE", "L1_FINAL_COLLECTION_VALUE",
				"L0_INCENTIVE_VALIDATION_FLAG", "L0_FINAL_COLLECTION_VALUE", "L0_FINAL_NET_VALUE" };
		List<String> outcomes = Arrays.asList(outcome);

		// Rest Input Mapping
		List<String> reqcases = new ArrayList<String>();
		reqcases.add("1");

		JsonObjectBuilder OpaRestReqBuilder = Json.createObjectBuilder();
		JsonArrayBuilder outcomeBuilder = Json.createArrayBuilder();
		JsonArrayBuilder casesBuilder = Json.createArrayBuilder();

		for (String out : outcomes) {
			outcomeBuilder.add(out);
		}
		OpaRestReqBuilder.add("outcomes", outcomeBuilder);

		int casecount = 1;
		int l2levelCount = 1;
		int l1levelCount = 1;
		int l1levelTransactionCount = 1;
		int l0levelCount = 1;
		int l0levelTransactionCount = 1;

		for (String resCase : reqcases) {
			JsonObjectBuilder globalBuilder = Json.createObjectBuilder();
			globalBuilder.add("@id", casecount);
			globalBuilder.add("MONTH", "APRIL");
			globalBuilder.add("REGION", "R5");

			// l2 level
			List<EurekaEmpMaster> l2Levels = inputData.getL2level();
			JsonArrayBuilder agentL2levelDataBuilder = Json.createArrayBuilder();
			for (EurekaEmpMaster l2Level : l2Levels) {
				JsonObjectBuilder agentL2levelBuilder = Json.createObjectBuilder();
				agentL2levelBuilder.add("@id", l2levelCount);
				agentL2levelBuilder.add("L2_LEVEL", l2Level.getEmpId());
				agentL2levelBuilder.add("L2_TIER", l2Level.getTier());
				agentL2levelBuilder.add("L2_CATEGORY", l2Level.getHrDesignation());

				JsonArrayBuilder L1sofL2DataBuilder = Json.createArrayBuilder();
				List<EurekaEmpMaster> l1Levels = l2Level.getL1level();
				for (EurekaEmpMaster l1Level : l1Levels) {
					JsonObjectBuilder L1sofL2Builder = Json.createObjectBuilder();
					L1sofL2Builder.add("@id", l1levelCount);
					L1sofL2Builder.add("L1_LEVEL", l1Level.getEmpId());
					L1sofL2Builder.add("L1_CATEGORY", l1Level.getHrDesignation());
					L1sofL2Builder.add("L1_BUDGET_SALES_GROUP", l1Level.getSalesGroup());
					if (l1Level.getL1level_Trans().isEmpty()) {
						L1sofL2Builder.add("L1_PRODUCT_NAME", "");
					} else {
						L1sofL2Builder.add("L1_PRODUCT_NAME", l1Level.getL1level_Trans().get(0).getMaterialgroup());
					}

					// lo level
					JsonArrayBuilder L0sofL1DataBuilder = Json.createArrayBuilder();
					List<EurekaEmpMaster> l0Levels = l1Level.getL0level();
					for (EurekaEmpMaster l0Level : l0Levels) {
						JsonObjectBuilder L0sofL1Builder = Json.createObjectBuilder();
						L0sofL1Builder.add("@id", l0levelCount);
						L0sofL1Builder.add("L0_CATEGORY", l0Level.getHrDesignation());
						L0sofL1Builder.add("L0_LEVEL", l0Level.getEmpId());
						L0sofL1Builder.add("L0_DOJ", l0Level.getDoj());
						if (l0Level.getL0level_Trans().isEmpty()) {
							L0sofL1Builder.add("L0_PRODUCT_NAME", "AG");
						} else {
							L0sofL1Builder.add("L0_PRODUCT_NAME", l0Level.getL0level_Trans().get(0).getMaterialgroup());
						}

						// l0 transactions
						JsonArrayBuilder l0transactionsofL1DataBuilder = Json.createArrayBuilder();
						List<EurekaLevel0TransactionModel> l0LevelTransactions = l0Level.getL0level_Trans();
						for (EurekaLevel0TransactionModel l0LevelTransaction : l0LevelTransactions) {
							JsonObjectBuilder l0transactionsofL1Builder = Json.createObjectBuilder();
							l0transactionsofL1Builder.add("@id", l0levelTransactionCount);
							l0transactionsofL1Builder.add("L0_TRANSACTION_MATERIAL_CODE",
									l0LevelTransaction.getMaterialCode());
							l0transactionsofL1Builder.add("L0_TRANSACTION_ADJUSTABLE_SCALE_QTY",
									l0LevelTransaction.getAdjustableScaleQuantity());
							l0transactionsofL1Builder.add("L0_TRANSACTION_FINAL_NET_VALUE",
									l0LevelTransaction.getFinalNetValue());
							l0transactionsofL1Builder.add("L0_TRANSACTION_CYCLE",
									l0LevelTransaction.getTransactionCycle());
							l0transactionsofL1Builder.add("L0_TRANSACTION_ACTUAL_SCALE_QTY",
									l0LevelTransaction.getActualScaleQuantity());
							l0transactionsofL1Builder.add("L0_TRANSACTION_COLLECTION_AMOUNT",
									l0LevelTransaction.getCollected_amt());

							l0transactionsofL1DataBuilder.add(l0transactionsofL1Builder);
							l0levelTransactionCount++;
						}
						// l0 transactions

						L0sofL1Builder.add("l0transactionsofL0", l0transactionsofL1DataBuilder);
						L0sofL1DataBuilder.add(L0sofL1Builder);
						l0levelCount++;
					}
					L1sofL2Builder.add("L0sofL1", L0sofL1DataBuilder);
					// lo level

					// l1 transactions
					JsonArrayBuilder l1transactionsofL1DataBuilder = Json.createArrayBuilder();
					List<EurekaLevel0TransactionModel> l1LevelTransactions = l1Level.getL1level_Trans();
					for (EurekaLevel0TransactionModel l1LevelTransaction : l1LevelTransactions) {
						JsonObjectBuilder l1transactionsofL1Builder = Json.createObjectBuilder();
						l1transactionsofL1Builder.add("@id", l1levelTransactionCount);
						l1transactionsofL1Builder.add("L1_TRANSACTION_MATERIAL_CODE",
								l1LevelTransaction.getMaterialCode());
						l1transactionsofL1Builder.add("L1_TRANSACTION_FINAL_NET_VALUE",
								l1LevelTransaction.getFinalNetValue());
						l1transactionsofL1Builder.add("L1_TRANSACTION_CYCLE", l1LevelTransaction.getTransactionCycle());
						l1transactionsofL1Builder.add("L1_TRANSACTION_ADJUSTABLE_SCALE_QTY",
								l1LevelTransaction.getAdjustableScaleQuantity());
						l1transactionsofL1Builder.add("L1_TRANSACTION_SALES_GROUP",
								l1LevelTransaction.getSales_group());
						l1transactionsofL1Builder.add("L1_TRANSACTION_COLLECTION_AMOUNT",
								l1LevelTransaction.getCollected_amt());

						l1transactionsofL1DataBuilder.add(l1transactionsofL1Builder);
						l1levelTransactionCount++;
					}
					// l1 transactions

					L1sofL2Builder.add("l1transactionsofL1", l1transactionsofL1DataBuilder);

					L1sofL2DataBuilder.add(L1sofL2Builder);
					l1levelCount++;
				}
				agentL2levelBuilder.add("L1sofL2", L1sofL2DataBuilder);
				agentL2levelDataBuilder.add(agentL2levelBuilder);
				l2levelCount++;
			}
			// l2 level

			globalBuilder.add("agentL2level", agentL2levelDataBuilder);

			casesBuilder.add(globalBuilder);
			casecount++;
		}
		OpaRestReqBuilder.add("cases", casesBuilder);
		JsonObject GTLOpaRestReq = OpaRestReqBuilder.build();
		// Rest Input Mapping

		StringWriter strWtr = new StringWriter();
		JsonWriter jsonWtr = Json.createWriter(strWtr);
		jsonWtr.writeObject(GTLOpaRestReq);
		jsonWtr.close();
		// System.out.println(strWtr.toString());

		// write to file
		try {
			String JSON_REQ_SAVEPATH = environment.getRequiredProperty("attachment_savepath");
			String filePath = JSON_REQ_SAVEPATH;

			System.out.println("PATH" + filePath);
			File file5 = new File(filePath);

			if (file5.exists() && file5.isDirectory()) {
				System.out.println("a file or directory named " + filePath + " exists");
			} else {
				boolean successful = file5.mkdirs();

				if (successful) {
					System.out.println("Direcory is created");
				}
			}
			OutputStream osf = new FileOutputStream(filePath + "/Eur_Rest_Request.json");

			JsonWriter jsonWriter = Json.createWriter(osf);
			jsonWriter.writeObject(GTLOpaRestReq);
			jsonWriter.close();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		String OAuth2_token = "";
		try {
			String OPAHUBAccount = environment.getRequiredProperty("opahubaccount");
			URL OAuth2_url = new URL(OPAHUBAccount
					+ "/determinations-server/batch/auth?grant_type=client_credentials&client_id=yamini&client_secret=Y@mini22");

			HttpURLConnection OAuth2_conn = (HttpURLConnection) OAuth2_url.openConnection();

			OAuth2_conn.setDoOutput(true);
			OAuth2_conn.setRequestMethod("POST");
			OAuth2_conn.setRequestProperty("Content-Type", "application/json");

			String OAuth2_JSON_REQ = "";

			OutputStream OAuth2_os = OAuth2_conn.getOutputStream();
			OAuth2_os.write(OAuth2_JSON_REQ.getBytes());
			OAuth2_os.flush();

			if (OAuth2_conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + OAuth2_conn.getResponseCode());
			}

			BufferedReader OAuth2_br = new BufferedReader(new InputStreamReader(OAuth2_conn.getInputStream()));

			String OAuth2_output;
			System.out.println("Output from Server .... \n");
			while ((OAuth2_output = OAuth2_br.readLine()) != null) {
				System.out.println(OAuth2_output);

				Document html = Jsoup.parse(OAuth2_output);
				String title = html.title();
				String body = html.body().text();
				System.out.println("Input HTML String to JSoup :" + OAuth2_output);
				System.out.println("After parsing, Title : " + title);
				System.out.println("Afte parsing, Heading : " + body);

				OAuth2_token = body;
			}

			OAuth2_conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			String OPAHUBAccount = environment.getRequiredProperty("opahubaccount");
			URL url = new URL(OPAHUBAccount
					+ "/determinations-server/batch/12.2.7/policy-models/EURFOB_AGT_INCENTIVES_REST/assessor");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", OAuth2_token);

			String JSON_REQ = strWtr.toString();

			OutputStream os = conn.getOutputStream();
			os.write(JSON_REQ.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String output = "";
			System.out.println("Output from Server .... ");

			while ((output = br.readLine()) != null) {
				// System.out.println(output);

				// BSAT_DLR_RESPJSONReader.bsat_DLR_RESPJSONReader(output);
				StringReader fis = new StringReader(output);

				// create JsonReader object
				JsonReader jsonReader = Json.createReader(fis);

				// get JsonObject from JsonReader
				JsonObject jsonObject = jsonReader.readObject();

				// we can close IO resource and JsonReader now
				jsonReader.close();
				fis.close();

				// System.out.println("BSAT RESP JSON String\n"+jsonObject);

				StringWriter strWtr2 = new StringWriter();
				JsonWriter jsonWtr2 = Json.createWriter(strWtr2);
				jsonWtr2.writeObject(jsonObject);
				jsonWtr2.close();

				// System.out.println(strWtr.toString());
				// write to file
				String JSON_REQ_SAVEPATH = environment.getRequiredProperty("attachment_savepath");
				String filePath = JSON_REQ_SAVEPATH;

				// System.out.println("PATH" +filePath);
				File file5 = new File(filePath);

				if (file5.exists() && file5.isDirectory()) {
					System.out.println("a file or directory named " + filePath + " exists");
				} else {
					boolean successful = file5.mkdirs();

					if (successful) {
						System.out.println("Direcory is created");
					}
				}
				OutputStream osf = new FileOutputStream(filePath + "/Eur_Rest_Response.json");

				JsonWriter jsonWriter = Json.createWriter(osf);
				jsonWriter.writeObject(jsonObject);
				jsonWriter.close();

				// Retrieve data from JsonObject and create Employee bean
				JsonArray cases = jsonObject.getJsonArray("cases");
				// for (JsonValue euro_value : cases) {
				JsonObject EURO_object = (JsonObject) cases.get(0);
				int caseid = EURO_object.getInt("@id");

				JsonArray l2level = EURO_object.getJsonArray("agentL2level");
				// for (JsonValue l2level_value : l2level) {

				JsonObject l2level_object = (JsonObject) l2level.get(0);
				int l2LevelId = l2level_object.getInt("@id");
				inputData.getL2level().get(0).setL2_category(l2level_object.getString("L2_CATEGORY"));
				try {
					inputData.getL2level().get(0)
							.setL2_qua_commission(l2level_object.getJsonNumber("L2_QUARTERLY_COMMISSION").intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
				inputData.getL2level().get(0).setL2_level(l2level_object.getJsonNumber("L2_LEVEL").intValue());
				inputData.getL2level().get(0)
						.setL2_oper_incentive(l2level_object.getJsonNumber("L2_OPERATIVE_INCENTIVE").intValue());
				inputData.getL2level().get(0)
						.setL2_commission(l2level_object.getJsonNumber("L2_COMMISSION").intValue());

				JsonArray l1level = l2level_object.getJsonArray("L1sofL2");

				for (int j = 0; j < l1level.size(); j++) {
					JsonObject l1level_object = (JsonObject) l1level.get(j);

					int l1LevelId = l1level_object.getInt("@id");
					inputData.getL2level().get(0).getL1level().get(j).setL1_team_sales_commiss(
							l1level_object.getJsonNumber("L1_TEAM_SALE_COMMISSION").intValue());
					inputData.getL2level().get(0).getL1level().get(j)
							.setL1_productivity_of_ag(l1level_object.getJsonNumber("L1_PRODUCTIVITY_OF_AG").intValue());
					inputData.getL2level().get(0).getL1level().get(j)
							.setL1_status(l1level_object.getString("L1_INCENTIVE_VALIDATION_FLAG"));
					inputData.getL2level().get(0).getL1level().get(j)
							.setL1_finalNetValue(l1level_object.getJsonNumber("L1_FINAL_NET_VALUE").intValue());
					inputData.getL2level().get(0).getL1level().get(j)
							.setL1_level(l1level_object.getJsonNumber("L1_LEVEL").intValue());
					inputData.getL2level().get(0).getL1level().get(j).setL1_finalCollectedValue(
							l1level_object.getJsonNumber("L1_FINAL_COLLECTION_VALUE").intValue());
					inputData.getL2level().get(0).getL1level().get(j).setL1_productivity_of_ec_ea(
							l1level_object.getJsonNumber("L1_PRODUCTIVITY_OF_EC_EA").intValue());
					inputData.getL2level().get(0).getL1level().get(j)
							.setL1_commission(l1level_object.getJsonNumber("L1_COMMISSION").intValue());
					inputData.getL2level().get(0).getL1level().get(j)
							.setL1_category(l1level_object.getString("L1_CATEGORY"));
					inputData.getL2level().get(0).getL1level().get(j)
							.setL1_sku_incentive(l1level_object.getJsonNumber("L1_SKU_INCENTIVE").intValue());

					JsonArray l0level = l1level_object.getJsonArray("L0sofL1");
					for (int k = 0; k < l0level.size(); k++) {

						JsonObject l0level_object = (JsonObject) l0level.get(k);

						int l0LevelId = l0level_object.getInt("@id");
						inputData.getL2level().get(0).getL1level().get(j).getL0level().get(k)
								.setL0_level(l0level_object.getJsonNumber("L0_LEVEL").intValue());
						inputData.getL2level().get(0).getL1level().get(j).getL0level().get(k)
								.setL0_finalNetValue(l0level_object.getJsonNumber("L0_FINAL_NET_VALUE").intValue());
						inputData.getL2level().get(0).getL1level().get(j).getL0level().get(k).setL0_finalCollectedValue(
								l0level_object.getJsonNumber("L0_FINAL_COLLECTION_VALUE").intValue());
						inputData.getL2level().get(0).getL1level().get(j).getL0level().get(k)
								.setL0_status(l0level_object.getString("L0_INCENTIVE_VALIDATION_FLAG"));

						inputData.getL2level().get(0).getL1level().get(j).getL0level().get(k)
								.setL0_commission(l0level_object.getJsonNumber("L0_COMMISSION").intValue());
						inputData.getL2level().get(0).getL1level().get(j).getL0level().get(k)
								.setL0_sku_incentive(l0level_object.getJsonNumber("L0_SKU_INCENTIVE").intValue());
						inputData.getL2level().get(0).getL1level().get(j).getL0level().get(k)
								.setL0_category(l0level_object.getString("L0_CATEGORY"));
						inputData.getL2level().get(0).getL1level().get(j).getL0level().get(k)
								.setL0_vintage_period(l0level_object.getJsonNumber("L0_VINTAGE_PERIOD").intValue());

					}
				}
				conn.disconnect();

			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

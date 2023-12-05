/**
 * 
 */
package com.omfys.bsat.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.omfys.bsat.model.EurekaEmpMaster;
import com.omfys.bsat.model.EurekaL0OutPutModel;
import com.omfys.bsat.model.EurekaLevel0TransactionModel;


/**
 * @author Omfys
 *
 */
@Controller
public class EurekaForbesController1 {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	HibernateTemplate HibernateTemplate;

	@RequestMapping(value = "/getalll1")
	public void findAllL1(HttpServletRequest request, Model model, HttpServletResponse response,
			@RequestParam(value = "l2EmpId") int l2EmpId) {
		//System.out.println("L2 Emp Id==> "+ l2EmpId);
		String L1Sql = "select PERNR,EMP_NAME,HR_DESIGNATION,CYCLE,SALES_GROUP from EURO_EMP_MASTER"
				+ " where HR_DESIGNATION = 'L1CH' and ACTIVE_FLAG = 'Y' and PERNR IN (select distinct(L1CH) from EURO_EMP_MASTER where L2ZH = "+ l2EmpId +" )";

		/*+ l2EmpId +*/
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

		String json = new Gson().toJson(L1Level_obj);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getalll0")
	public void findAllL0(HttpServletRequest request, Model model, HttpServletResponse response,
			@RequestParam(value = "l1EmpId") int l1EmpId) {
		//System.out.println("L1 Emp Id==>"+l1EmpId );
		String L0levelSql = "select PERNR,EMP_NAME,HR_DESIGNATION,CYCLE,DOJ from EURO_EMP_MASTER where ACTIVE_FLAG = 'Y' and"
				+ " PERNR IN (select PERNR from EURO_EMP_MASTER where L1CH = " + l1EmpId + ")";
        //" + l1EmpId + "  //
		List<EurekaEmpMaster> L0Level = jdbcTemplate.query(L0levelSql, new RowMapper<EurekaEmpMaster>() {

			@Override
			public EurekaEmpMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				EurekaEmpMaster l0level = new EurekaEmpMaster();
				l0level.setEmpId(rs.getInt("PERNR"));
				l0level.setEmpName(rs.getString("EMP_NAME"));
				l0level.setTransactionCycle(rs.getInt("CYCLE"));
				l0level.setHrDesignation(rs.getString("HR_DESIGNATION"));
				l0level.setDoj(rs.getString("DOJ"));
				//System.out.println("Lo list==>"+l0level);
				return l0level;
			}

		});
		String json = new Gson().toJson(L0Level);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/showEurekaSchAnalysisSoap1")
	public ModelAndView showSalesSchAnReportSoap(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "cycle_name") int cycle_name,
			@RequestParam(value = "product_name") String product_name, @RequestParam(value = "l2EmpId") int l2EmpId,
			@RequestParam(value = "l1EmpId") int l1EmpId, @RequestParam(value = "l0EmpId") int l0EmpId, Model model) {

		String schopawebserviceUrl = "https://iflictest1.custhelp.com/iflicproduction__tst1/determinations-server/assess/soap/generic/12.2.1/EURFOB_AGT_INCENTIVES?wsdl";
		//System.out.println("in Eureka Forbes scheme" + "L2 id" + l2EmpId + "L1 id" + l1EmpId + "L0 id" + l0EmpId);

		EurekaL0OutPutModel final_incentives = new EurekaL0OutPutModel();

		String Sql = "select PERNR,EMP_NAME,HR_DESIGNATION from EURO_EMP_MASTER where PERNR = "+ l2EmpId +"";
		List<EurekaEmpMaster> L2Level = jdbcTemplate.query(Sql, new RowMapper<EurekaEmpMaster>() {
			@Override
			public EurekaEmpMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				EurekaEmpMaster l2level = new EurekaEmpMaster();

				l2level.setEmpId(rs.getInt("PERNR"));
				l2level.setEmpName(rs.getString("EMP_NAME"));
				l2level.setTransactionCycle(cycle_name);
				l2level.setHrDesignation("L2ZH");
				l2level.setTier("T01");
				//l2level.setMaterialGroup(product_name);
				return l2level;
			}
		});
		EurekaEmpMaster L2Obj = new EurekaEmpMaster();
		L2Obj.setEmpId(L2Level.get(0).getEmpId());
		L2Obj.setCycle(L2Level.get(0).getTransactionCycle());
		L2Obj.setHrDesignation(L2Level.get(0).getHrDesignation());
		L2Obj.setTier(L2Level.get(0).getTier());
		System.out.println("size of L2" + L2Level.size());

		/*String Sql1 = "select distinct(L1CH) from EURO_EMP_MASTER where L2ZH =" + L2Obj.getEmpId();
		List<EurekaEmpMaster> L1Level = jdbcTemplate.query(Sql1, new RowMapper<EurekaEmpMaster>() {
			@Override
			public EurekaEmpMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				EurekaEmpMaster l1level = new EurekaEmpMaster();
				l1level.setEmpId(rs.getInt("L1CH"));
				return l1level;
			}
		});*/

		String L1Sql = "select PERNR,EMP_NAME,HR_DESIGNATION,CYCLE,SALES_GROUP from EURO_EMP_MASTER where PERNR = "+ l1EmpId +" and HR_DESIGNATION = 'L1CH'";
		List<EurekaEmpMaster> L1Level_obj = jdbcTemplate.query(L1Sql, new RowMapper<EurekaEmpMaster>() {

			@Override
			public EurekaEmpMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				EurekaEmpMaster l1level = new EurekaEmpMaster();
				l1level.setEmpId(rs.getInt("PERNR"));
				l1level.setEmpName(rs.getString("EMP_NAME"));
				l1level.setHrDesignation(rs.getString("HR_DESIGNATION"));
				l1level.setTransactionCycle(cycle_name);
				l1level.setSalesGroup(rs.getString("SALES_GROUP"));
				// l1level.setMaterialGroup(product_name);
				return l1level;
			}

		});
		L2Level.get(0).setL1level(L1Level_obj);

		for (int i = 0; i < L1Level_obj.size(); i++) {
			String l1tranSql = "SELECT PERNR,MATERIAL_CODE,MATERIAL_GROUP,COLLECTED_AMT,ADJUSTABLE_SCALE_QTY,FINAL_NET_SALES,TRANS_CYCLE FROM EURO_TRANSACTION_MASTER"
					+ " WHERE PERNR = "+ l1EmpId +" AND TRANS_CYCLE = " + cycle_name + "";
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
							l1level_trans.setFinalNetValue(rs.getFloat("FINAL_NET_SALES"));
							l1level_trans.setCollected_amt(rs.getFloat("COLLECTED_AMT"));
							return l1level_trans;
						}

					});
			L2Level.get(0).getL1level().get(0).setL1level_Trans(L1Level_Transobj);
		}

		String L0levelSql = "select PERNR,EMP_NAME,HR_DESIGNATION,CYCLE,DOJ from EURO_EMP_MASTER where PERNR = "+l0EmpId+"";
		List<EurekaEmpMaster> L0Level = jdbcTemplate.query(L0levelSql, new RowMapper<EurekaEmpMaster>() {
			@Override
			public EurekaEmpMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				EurekaEmpMaster l0level = new EurekaEmpMaster();
				l0level.setEmpId(rs.getInt("PERNR"));
				l0level.setEmpName(rs.getString("EMP_NAME"));
				l0level.setTransactionCycle(cycle_name);
				l0level.setHrDesignation(rs.getString("HR_DESIGNATION"));
				l0level.setDoj(rs.getString("DOJ"));
				return l0level;
			}

		});
		L2Level.get(0).getL1level().get(0).setL0level(L0Level);

		String l0tranSql = "SELECT PERNR,MATERIAL_CODE,MATERIAL_GROUP,COLLECTED_AMT, ADJUSTABLE_SCALE_QTY,ACTUAL_SCALE_QTY,FINAL_NET_SALES,TRANS_CYCLE FROM EURO_TRANSACTION_MASTER"
				+ " WHERE PERNR = "+l0EmpId+" AND TRANS_CYCLE = " + cycle_name + "";
		List<EurekaLevel0TransactionModel> L0Level_Transobj = jdbcTemplate.query(l0tranSql,
				new RowMapper<EurekaLevel0TransactionModel>() {

					@Override
					public EurekaLevel0TransactionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
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
		L2Level.get(0).getL1level().get(0).getL0level().get(0).setL0level_Trans(L0Level_Transobj);

		EurekaEmpMaster data = new EurekaEmpMaster();
		data.setMaterialGroup(product_name);
		data.setL2level(L2Level);

		Date Sd = new Date();

		// Start SOAP WebserviceCall
		call_eureka_sales_webservice(data, final_incentives, schopawebserviceUrl, request);
		// End SOAP WebserviceCall

		HttpSession session = request.getSession();
		session.setAttribute("Info_grid", data.getL2level());
		
		//model.addAttribute("Info_grid", data.getL2level());
		model.addAttribute("cycle", cycle_name);
		model.addAttribute("product", product_name);
		request.setAttribute("Info_grid", data.getL2level());
		return new ModelAndView("SalesSchemeAnalysis1");
	}

	public void call_eureka_sales_webservice(EurekaEmpMaster inputData, EurekaL0OutPutModel final_incentives,
			String schopawebserviceUrl, HttpServletRequest request) {

		// Create SOAP Connection
		try {
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			// Send SOAP Message to SOAP Server
			final String url = schopawebserviceUrl;
			// SOAP Request
			SOAPMessage soapRequest = createEurekaSchemeSOAPRequest(inputData, final_incentives);

			TransformerFactory transformerFactoryReq = TransformerFactory.newInstance();
			Transformer transformerReq = transformerFactoryReq.newTransformer();
			Source sourceContentReq = soapRequest.getSOAPPart().getContent();

			String reqxmlpath = request.getServletContext().getRealPath("/WEB-INF/classes/com/report");
			System.out.println("Request xmlpath = " + reqxmlpath);
			StreamResult resultReq = new StreamResult(new FileOutputStream(new File(reqxmlpath + "\\soaprequest.xml")));
			transformerReq.transform(sourceContentReq, resultReq);

			SOAPMessage soapResponse = soapConnection.call(soapRequest, url);

			TransformerFactory transformerFactoryResp = TransformerFactory.newInstance();
			Transformer transformerResp = transformerFactoryResp.newTransformer();
			Source sourceContentResp = soapResponse.getSOAPPart().getContent();

			StreamResult resultResp = new StreamResult(
					new FileOutputStream(new File(reqxmlpath + "\\soapresponse.xml")));
			transformerResp.transform(sourceContentResp, resultResp);
			System.out.println("Response xmlpath = " + resultResp);
			// Process the SOAP Response
			printEurekaSchemeSOAPResponse(soapRequest, soapResponse, inputData, final_incentives, request);

			soapConnection.close();

		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private SOAPMessage createEurekaSchemeSOAPRequest(EurekaEmpMaster inputData, EurekaL0OutPutModel final_incentives)
			throws SOAPException, IOException {

		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		final String serverURI = "http://oracle.com/determinations/server/12.2.1/rulebase/assess/types";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("typ", serverURI);
		SOAPFactory soapFactory = SOAPFactory.newInstance();
		System.out.println("SOAP Envelope");

		// SOAP Header
		SOAPHeader soapHeader = envelope.getHeader();
		final String seqHeader = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
		Name headerName = soapFactory.createName("Security", "o", seqHeader);

		SOAPHeaderElement headerElement = soapHeader.addHeaderElement(headerName);
		headerElement.setMustUnderstand(true);

		final String Username = "apiuser";
		final String Password = "ApiUser@123";

		SOAPElement soapUserToken = headerElement.addChildElement("UsernameToken", "o");
		SOAPElement sopaUser = soapUserToken.addChildElement("Username", "o");
		sopaUser.addTextNode(Username);
		SOAPElement sopaPass = soapUserToken.addChildElement("Password", "o");
		sopaPass.addTextNode(Password);

		SOAPHeader header = soapMessage.getSOAPHeader();
		SOAPBody body = soapMessage.getSOAPBody();

		System.out.println("SOAP Header");

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("assess-request", "typ");
		System.out.println("SOAP Body");

		SOAPElement config = soapBodyElem.addChildElement("config", "typ");
		SOAPElement outcome = config.addChildElement("outcome", "typ");

		// Eureka Forbes
		// Eureka Outcome
		ArrayList<String> outcome_entity_type = new ArrayList<String>();
		outcome_entity_type.add("L2LEVEL");
		outcome_entity_type.add("L1LEVEL");
		outcome_entity_type.add("L0LEVEL");
		ArrayList<String> L2LEVEL_outcome = new ArrayList<String>();
		ArrayList<String> L1LEVEL_outcome = new ArrayList<String>();
		ArrayList<String> L0LEVEL_outcome = new ArrayList<String>();

		for (String outcome_entity : outcome_entity_type) {
			if (outcome_entity.equals("L2LEVEL")) {
				L2LEVEL_outcome.add("L2_LEVEL");
				L2LEVEL_outcome.add("L2_COMMISSION");
				L2LEVEL_outcome.add("L2_QUARTERLY_COMMISSION");
				L2LEVEL_outcome.add("L2_OPERATIVE_INCENTIVE");
				L2LEVEL_outcome.add("L2_CATEGORY");

				SOAPElement entity = outcome.addChildElement("entity", "typ");
				entity.addAttribute(soapFactory.createName("id"), outcome_entity);
				for (String l2level_att : L2LEVEL_outcome) {
					SOAPElement entityoutcome = entity.addChildElement("attribute-outcome", "typ");
					entityoutcome.addAttribute(soapFactory.createName("id"), l2level_att);
					entityoutcome.addAttribute(soapFactory.createName("known-outcome-style"), "value-only");
					entityoutcome.addAttribute(soapFactory.createName("unknown-outcome-style"), "value-only");
				}

			} else if (outcome_entity.equals("L1LEVEL")) {
				L1LEVEL_outcome.add("L1_LEVEL");
				L1LEVEL_outcome.add("L1_PRODUCTIVITY_OF_EC_EA");
				L1LEVEL_outcome.add("L1_PRODUCTIVITY_OF_AG");
				L1LEVEL_outcome.add("L1_CATEGORY");
				L1LEVEL_outcome.add("L1_COMMISSION");
				L1LEVEL_outcome.add("L1_TEAM_SALE_COMMISSION");
				L1LEVEL_outcome.add("L1_SKU_INCENTIVE");
				L1LEVEL_outcome.add("L1_INCENTIVE_VALIDATION_FLAG");

				SOAPElement entity = outcome.addChildElement("entity", "typ");
				entity.addAttribute(soapFactory.createName("id"), outcome_entity);
				for (String l1level_att : L1LEVEL_outcome) {
					SOAPElement entityoutcome = entity.addChildElement("attribute-outcome", "typ");
					entityoutcome.addAttribute(soapFactory.createName("id"), l1level_att);
					entityoutcome.addAttribute(soapFactory.createName("known-outcome-style"), "value-only");
					entityoutcome.addAttribute(soapFactory.createName("unknown-outcome-style"), "value-only");
				}

			} else if (outcome_entity.equals("L0LEVEL")) {
				L0LEVEL_outcome.add("L0_PRODUCTIVITY_FOR_EC_EA");
				L0LEVEL_outcome.add("L0_PRODUCTIVITY_FOR_AG");
				L0LEVEL_outcome.add("L0_COMMISSION");
				L0LEVEL_outcome.add("L0_SKU_INCENTIVE");
				L0LEVEL_outcome.add("L0_CATEGORY");
				L0LEVEL_outcome.add("L0_VINTAGE_PERIOD");
				L0LEVEL_outcome.add("L0_LEVEL");
				L0LEVEL_outcome.add("L0_INCENTIVE_VALIDATION_FLAG");

				SOAPElement entity = outcome.addChildElement("entity", "typ");
				entity.addAttribute(soapFactory.createName("id"), outcome_entity);

				for (String l0level_att : L0LEVEL_outcome) {
					System.out.println("l0level_att outcome att = " + l0level_att);

					SOAPElement entityoutcome = entity.addChildElement("attribute-outcome", "typ");
					entityoutcome.addAttribute(soapFactory.createName("id"), l0level_att);
					entityoutcome.addAttribute(soapFactory.createName("known-outcome-style"), "value-only");
					entityoutcome.addAttribute(soapFactory.createName("unknown-outcome-style"), "value-only");
				}

			}
		}
		// Eureka Outcome

		// Agent Entity
		ArrayList<String> agent_instances = new ArrayList<String>();
		ArrayList<String> agent_attributes = new ArrayList<String>();
		ArrayList<String> agent_attributes_type = new ArrayList<String>();
		ArrayList<String> agent_attributes_value = new ArrayList<String>();

		agent_attributes.add("AGENT_PRODUCT_NAME");
		agent_attributes_type.add("text-val");
		// Agent Entity

		ArrayList<String> material_instances = new ArrayList<String>();
		ArrayList<String> material_attributes = new ArrayList<String>();
		ArrayList<String> material_attributes_type = new ArrayList<String>();
		ArrayList<String> material_attributes_value = new ArrayList<String>();

		// l0 level Entity
		ArrayList<String> l0level_instances = new ArrayList<String>();
		ArrayList<String> l0level_attributes = new ArrayList<String>();
		ArrayList<String> l0level_attributes_type = new ArrayList<String>();
		ArrayList<String> l0level_attributes_value = new ArrayList<String>();

		l0level_attributes.add("L0_CATEGORY");
		l0level_attributes.add("L0_LEVEL");
		l0level_attributes.add("L0_LEVEL_TRANSACTION_CYCLE");
		l0level_attributes.add("L0_DOJ");
		l0level_attributes.add("L0_PRODUCT_NAME");
		l0level_attributes.add("L0_PERS_NO");
		
		l0level_attributes_type.add("text-val");
		l0level_attributes_type.add("number-val");
		l0level_attributes_type.add("number-val");
		l0level_attributes_type.add("date-val");
		l0level_attributes_type.add("text-val");
		l0level_attributes_type.add("number-val");
		// l0 level Entity

		// l0 transaction entity
		ArrayList<String> l0transaction_instances = new ArrayList<String>();
		ArrayList<String> l0transaction_attributes = new ArrayList<String>();
		ArrayList<String> l0transaction_attributes_type = new ArrayList<String>();
		ArrayList<String> l0transaction_attributes_value = new ArrayList<String>();

		l0transaction_attributes.add("L0_TRANSACTION_MATERIAL_CODE");
		l0transaction_attributes.add("L0_TRANSACTION_ADJUSTABLE_SCALE_QTY");
		l0transaction_attributes.add("L0_TRANSACTION_FINAL_NET_VALUE");
		l0transaction_attributes.add("L0_TRANSACTION_CYCLE");
		l0transaction_attributes.add("L0_TRANSACTION_ACTUAL_SCALE_QTY");
		l0transaction_attributes.add("L0_TRANSACTION_COLLECTION_AMOUNT");

		l0transaction_attributes_type.add("text-val");
		l0transaction_attributes_type.add("number-val");
		l0transaction_attributes_type.add("number-val");
		l0transaction_attributes_type.add("number-val");
		l0transaction_attributes_type.add("number-val");
		l0transaction_attributes_type.add("number-val");
		// l0 transaction entity

		// L1 level entity
		ArrayList<String> l1level_instances = new ArrayList<String>();
		ArrayList<String> l1level_attributes = new ArrayList<String>();
		ArrayList<String> l1level_attributes_type = new ArrayList<String>();
		ArrayList<String> l1level_attributes_value = new ArrayList<String>();

		l1level_attributes.add("L1_CATEGORY");
		l1level_attributes.add("L1_BUDGET_SALES_GROUP");
		l1level_attributes.add("L1_LEVEL");
		l1level_attributes.add("L1_LEVEL_TRANSACTION_CYCLE");
		l1level_attributes.add("L1_PRODUCT_NAME");
		l1level_attributes.add("L1_PERS_NO");
		
		l1level_attributes_type.add("text-val");
		l1level_attributes_type.add("text-val");
		l1level_attributes_type.add("number-val");
		l1level_attributes_type.add("number-val");
		l1level_attributes_type.add("text-val");
		l1level_attributes_type.add("number-val");
		// L1 level entity

		// l1 transaction entity
		ArrayList<String> l1transaction_instances = new ArrayList<String>();
		ArrayList<String> l1transaction_attributes = new ArrayList<String>();
		ArrayList<String> l1transaction_attributes_type = new ArrayList<String>();
		ArrayList<String> l1transaction_attributes_value = new ArrayList<String>();

		l1transaction_attributes.add("L1_TRANSACTION_MATERIAL_CODE");
		l1transaction_attributes.add("L1_TRANSACTION_FINAL_NET_VALUE");
		l1transaction_attributes.add("L1_TRANSACTION_CYCLE");
		l1transaction_attributes.add("L1_TRANSACTION_ADJUSTABLE_SCALE_QTY");
		l1transaction_attributes.add("L1_TRANSACTION_SALES_GROUP");
		l1transaction_attributes.add("L1_TRANSACTION_COLLECTION_AMOUNT");

		l1transaction_attributes_type.add("text-val");
		l1transaction_attributes_type.add("number-val");
		l1transaction_attributes_type.add("number-val");
		l1transaction_attributes_type.add("number-val");
		l1transaction_attributes_type.add("text-val");
		l1transaction_attributes_type.add("number-val");
		// l2 level entity

		ArrayList<String> l2level_instances = new ArrayList<String>();
		ArrayList<String> l2level_attributes = new ArrayList<String>();
		ArrayList<String> l2level_attributes_type = new ArrayList<String>();
		ArrayList<String> l2level_attributes_value = new ArrayList<String>();

		l2level_attributes.add("L2_TIER");
		l2level_attributes.add("L2_CATEGORY");
		l2level_attributes.add("L2_LEVEL");
		l2level_attributes.add("L2_TRANSACTION_CYCLE");
		l2level_attributes.add("L2_PRODUCT_NAME");
		l2level_attributes.add("L2_PERS_NO");
		
		l2level_attributes_type.add("text-val");
		l2level_attributes_type.add("text-val");
		l2level_attributes_type.add("number-val");
		l2level_attributes_type.add("number-val");
		l2level_attributes_type.add("text-val");
		l2level_attributes_type.add("number-val");

		SOAPElement globalinstance = soapBodyElem.addChildElement("global-instance", "typ");

		SOAPElement globalattribute = globalinstance.addChildElement("attribute", "typ");
		globalattribute.addAttribute(soapFactory.createName("id"), "MONTH");
		SOAPElement globalattributeattributeDataType = globalattribute.addChildElement("text-val", "typ");
		globalattributeattributeDataType.addTextNode("April");

		SOAPElement globalattribute1 = globalinstance.addChildElement("attribute", "typ");
		globalattribute1.addAttribute(soapFactory.createName("id"), "REGION");
		SOAPElement globalattributeattributeDataType1 = globalattribute1.addChildElement("text-val", "typ");
		globalattributeattributeDataType1.addTextNode("R5");

		// agent v
		SOAPElement agent_entity = globalinstance.addChildElement("entity", "typ");
		agent_entity.addAttribute(soapFactory.createName("id"), "Agent");
		System.out.println("Agent_entity");

		agent_instances.add("Product");

		// values from db
		for (int k = 0; k < agent_instances.size(); k++) {
			SOAPElement agent_entity_instance = agent_entity.addChildElement("instance", "typ");
			agent_entity_instance.addAttribute(soapFactory.createName("id"), agent_instances.get(k));
			// System.out.println("agent_instances = " +
			// agent_instances.get(k));

			agent_attributes_value.add("AG");

			for (int i = 0; i < agent_attributes.size(); i++) {

				SOAPElement attribute = agent_entity_instance.addChildElement("attribute", "typ");
				attribute.addAttribute(soapFactory.createName("id"), agent_attributes.get(i));
				SOAPElement attributeDataType = attribute.addChildElement(agent_attributes_type.get(i), "typ");
				attributeDataType.addTextNode(agent_attributes_value.get(i));
			}

			SOAPElement l2entity = agent_entity_instance.addChildElement("entity", "typ");
			l2entity.addAttribute(soapFactory.createName("id"), "L2LEVEL");

			l2level_instances.clear();

			for (EurekaEmpMaster L2Level : inputData.getL2level()) {
				l2level_instances.add(Integer.toString(L2Level.getEmpId()));
			}

			for (int l = 0; l < l2level_instances.size(); l++) {
				SOAPElement l2level_entity_instance = l2entity.addChildElement("instance", "typ");
				l2level_entity_instance.addAttribute(soapFactory.createName("id"), l2level_instances.get(l));
				// System.out.println("l2lelvel_instances = " +
				// l2level_instances.get(l));
				l2level_attributes_value.clear();

				EurekaEmpMaster rewards4 = inputData.L2level.get(0);
				l2level_attributes_value.add(rewards4.getTier());//
				l2level_attributes_value.add(rewards4.getHrDesignation());//
				l2level_attributes_value.add(Integer.toString(rewards4.getEmpId()));//
				l2level_attributes_value.add(Integer.toString(rewards4.getTransactionCycle()));//
				l2level_attributes_value.add("AG");
				l2level_attributes_value.add(Integer.toString(rewards4.getEmpId()));
				for (int i = 0; i < l2level_attributes.size(); i++) {

					SOAPElement attribute = l2level_entity_instance.addChildElement("attribute", "typ");
					attribute.addAttribute(soapFactory.createName("id"), l2level_attributes.get(i));
					SOAPElement attributeDataType = attribute.addChildElement(l2level_attributes_type.get(i), "typ");
					attributeDataType.addTextNode(l2level_attributes_value.get(i));
				}

				SOAPElement l1entity = l2level_entity_instance.addChildElement("entity", "typ");
				l1entity.addAttribute(soapFactory.createName("id"), "L1LEVEL");
				l1level_instances.clear();

				for (EurekaEmpMaster eurekaLevel0TransactionModel : inputData.getL2level().get(0).getL1level()) {
					l1level_instances.add(Integer.toString(eurekaLevel0TransactionModel.getEmpId()));
				}

				for (int n = 0; n < l1level_instances.size(); n++) {
					SOAPElement l1level_entity_instance = l1entity.addChildElement("instance", "typ");
					l1level_entity_instance.addAttribute(soapFactory.createName("id"), l1level_instances.get(n));
					l1level_attributes_value.clear();

					EurekaEmpMaster rewards2 = inputData.getL2level().get(0).getL1level().get(0);

					l1level_attributes_value.add(rewards2.getHrDesignation());//
					l1level_attributes_value.add(rewards2.getSalesGroup());//
					l1level_attributes_value.add(Integer.toString(rewards2.getEmpId()));//
					l1level_attributes_value.add(Integer.toString(rewards2.getTransactionCycle()));//
					l1level_attributes_value.add(rewards2.getL1level_Trans().get(0).getMaterialgroup());//
					l1level_attributes_value.add(Integer.toString(rewards2.getEmpId()));//
					for (int i = 0; i < l1level_attributes.size(); i++) {

						SOAPElement attribute = l1level_entity_instance.addChildElement("attribute", "typ");
						attribute.addAttribute(soapFactory.createName("id"), l1level_attributes.get(i));
						SOAPElement attributeDataType = attribute.addChildElement(l1level_attributes_type.get(i),
								"typ");
						attributeDataType.addTextNode(l1level_attributes_value.get(i));
					}
					// l1 level values

					SOAPElement l0entity = l1level_entity_instance.addChildElement("entity", "typ");
					l0entity.addAttribute(soapFactory.createName("id"), "L0LEVEL");
					// System.out.println("L0_entity");
					l0level_instances.clear();

					for (EurekaEmpMaster eurekaLevel0TransactionModel : inputData.getL2level().get(0).getL1level()
							.get(0).getL0level()) {
						l0level_instances.add(Integer.toString(eurekaLevel0TransactionModel.getEmpId()));
					}

					for (int j = 0; j < l0level_instances.size(); j++) {
						SOAPElement l0level_entity_instance = l0entity.addChildElement("instance", "typ");
						l0level_entity_instance.addAttribute(soapFactory.createName("id"), l0level_instances.get(j));
						l0level_attributes_value.clear();

						EurekaEmpMaster rewards1 = inputData.getL2level().get(0).getL1level().get(0).getL0level()
								.get(0);
						l0level_attributes_value.add(rewards1.getHrDesignation());
						l0level_attributes_value.add(Integer.toString(rewards1.getEmpId()));
						l0level_attributes_value.add(Integer.toString(rewards1.getTransactionCycle()));
						l0level_attributes_value.add(rewards1.getDoj());
						l0level_attributes_value.add(rewards1.getL0level_Trans().get(0).getMaterialgroup());
						l0level_attributes_value.add(Integer.toString(rewards1.getEmpId()));
						
						for (int i = 0; i < l0level_attributes.size(); i++) {

							SOAPElement attribute = l0level_entity_instance.addChildElement("attribute", "typ");
							attribute.addAttribute(soapFactory.createName("id"), l0level_attributes.get(i));
							SOAPElement attributeDataType = attribute.addChildElement(l0level_attributes_type.get(i),
									"typ");

							if (l0level_attributes_value.get(i) != null) {
								// System.out.println("l0 level_attributes = " +
								// l0level_attributes.get(i));
								attributeDataType.addTextNode(l0level_attributes_value.get(i));
							}
						}
						// l0 level values

						// l0 transaction

						SOAPElement l0tran_entity = l0level_entity_instance.addChildElement("entity", "typ");
						l0tran_entity.addAttribute(soapFactory.createName("id"), "L0TRANSACTION");
						// System.out.println("Transaction_entity");

						l0transaction_instances.clear();

						int e = 1;
						for (EurekaLevel0TransactionModel eurekaLevel0TransactionModel : inputData.getL2level().get(0)
								.getL1level().get(0).getL0level().get(j).getL0level_Trans()) {
							l0transaction_instances.add(Integer.toString(e));
							e++;
						}

						for (int m = 0; m < l0transaction_instances.size(); m++) {

							SOAPElement l0transaction_entity_instance = l0tran_entity.addChildElement("instance",
									"typ");
							l0transaction_entity_instance.addAttribute(soapFactory.createName("id"),
									l0transaction_instances.get(m));
							// System.out.println("l0transaction_instances = " +
							// l0transaction_instances.get(m));
							l0transaction_attributes_value.clear();

							EurekaLevel0TransactionModel rewards3 = inputData.getL2level().get(0).getL1level().get(0)
									.getL0level().get(j).getL0level_Trans().get(m);
							l0transaction_attributes_value.add(rewards3.getMaterialCode());
							l0transaction_attributes_value.add(Integer.toString(rewards3.getAdjustableScaleQuantity()));
							l0transaction_attributes_value.add(Float.toString(rewards3.getFinalNetValue()));
							l0transaction_attributes_value.add(Integer.toString(rewards3.getTransactionCycle()));
							l0transaction_attributes_value.add(Integer.toString(rewards3.getActualScaleQuantity()));
							l0transaction_attributes_value.add(Float.toString(rewards3.getCollected_amt()));
							
							for (int i = 0; i < l0transaction_attributes.size(); i++) {

								SOAPElement attribute = l0transaction_entity_instance.addChildElement("attribute",
										"typ");
								attribute.addAttribute(soapFactory.createName("id"), l0transaction_attributes.get(i));
								SOAPElement attributeDataType = attribute
										.addChildElement(l0transaction_attributes_type.get(i), "typ");
								attributeDataType.addTextNode(l0transaction_attributes_value.get(i));
								System.out.println("l0transaction_attributes = " + l0transaction_attributes.get(i));
							}
						}
					}
					SOAPElement l1tran_entity = l1level_entity_instance.addChildElement("entity", "typ");
					l1tran_entity.addAttribute(soapFactory.createName("id"), "L1TRANSACTION");

					// System.out.println("Transaction_entity");

					l1transaction_instances.clear();

					int z = 1;
					for (EurekaLevel0TransactionModel eurekaLevel1TransactionModel : inputData.getL2level().get(0)
							.getL1level().get(0).getL1level_Trans()) {
						l1transaction_instances.add(Integer.toString(z));
						z++;
					}

					// l1transaction_instances.add("1");
					for (int m = 0; m < l1transaction_instances.size(); m++) {
						SOAPElement l1transaction_entity_instance = l1tran_entity.addChildElement("instance", "typ");
						l1transaction_entity_instance.addAttribute(soapFactory.createName("id"),
								l1transaction_instances.get(m));
						l1transaction_attributes_value.clear();

						EurekaLevel0TransactionModel rewards1 = inputData.getL2level().get(0).getL1level().get(0)
								.getL1level_Trans().get(m);
						l1transaction_attributes_value.add(rewards1.getMaterialCode());//
						l1transaction_attributes_value.add(Float.toString(rewards1.getFinalNetValue()));//
						l1transaction_attributes_value.add(Integer.toString(rewards1.getTransactionCycle()));//
						l1transaction_attributes_value.add(Integer.toString(rewards1.getAdjustableScaleQuantity()));//
						l1transaction_attributes_value.add(rewards2.getSalesGroup());//
						l1transaction_attributes_value.add(Float.toString(rewards1.getCollected_amt()));//
						
						for (int i = 0; i < l1transaction_attributes.size(); i++) {

							SOAPElement attribute = l1transaction_entity_instance.addChildElement("attribute", "typ");
							attribute.addAttribute(soapFactory.createName("id"), l1transaction_attributes.get(i));
							SOAPElement attributeDataType = attribute
									.addChildElement(l1transaction_attributes_type.get(i), "typ");
							attributeDataType.addTextNode(l1transaction_attributes_value.get(i));
							System.out.println("l1transaction_attributes = " + l0transaction_attributes.get(i));
						}
					}
				}
			}
			SOAPElement materialentity = agent_entity_instance.addChildElement("entity", "typ");
			materialentity.addAttribute(soapFactory.createName("id"), "MATERIAL");

		}
		final String SOAPAction = "http://oracle.com/determinations/server/12.2.1/rulebase/types/Assess";

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", SOAPAction);
		soapMessage.saveChanges();

		/* Print the request message */
		System.out.print("Request SOAP Message = " + soapMessage);
		soapMessage.writeTo(System.out);
		System.out.println();

		return soapMessage;
	}

	private void printEurekaSchemeSOAPResponse(SOAPMessage soapRequest, SOAPMessage soapResponse,
			EurekaEmpMaster inputdata, EurekaL0OutPutModel final_incentives, HttpServletRequest request)
			throws SOAPException, TransformerException, ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {

		// EurekaL0OutPutModel op = new EurekaL0OutPutModel();
		TransformerFactory transformerFactoryReq = TransformerFactory.newInstance();
		Transformer transformerReq = transformerFactoryReq.newTransformer();
		Source sourceContentReq = soapRequest.getSOAPPart().getContent();

		System.out.print("\nRequest SOAP Message = ");
		StreamResult resultReq = new StreamResult(System.out);
		transformerReq.transform(sourceContentReq, resultReq);

		String reqxmlpath = request.getServletContext().getRealPath("/WEB-INF/classes/com/report");
		System.out.println("\nxmlpath = " + reqxmlpath);
		StreamResult resultReq3 = new StreamResult(new FileOutputStream(new File(reqxmlpath + "\\soaprequest.xml")));
		transformerReq.transform(sourceContentReq, resultReq3);

		ByteArrayOutputStream osReq = new ByteArrayOutputStream();

		StreamResult resultReq2 = new StreamResult(osReq);
		transformerReq.transform(sourceContentReq, resultReq2);

		String xmlReq = new String(osReq.toByteArray(), "UTF-8");

		System.out.println("\n");
		System.out.println(xmlReq);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();

		System.out.print("\nResponse SOAP Message = ");
		StreamResult result = new StreamResult(System.out);
		transformer.transform(sourceContent, result);

		StreamResult result3 = new StreamResult(new FileOutputStream(new File(reqxmlpath + "\\soapresponse.xml")));
		transformer.transform(sourceContent, result3);

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		StreamResult result2 = new StreamResult(os);
		transformer.transform(sourceContent, result2);

		String xml = new String(os.toByteArray(), "UTF-8");

		System.out.println("\n");
		System.out.println(xml);

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		Document xmlDocument = builder.parse(new ByteArrayInputStream(xml.getBytes()));
		System.out.println("Xml document for data" + xmlDocument);
		XPath xPath = XPathFactory.newInstance().newXPath();

		ArrayList<String> outcome_entity_type = new ArrayList<String>();
		outcome_entity_type.add("L2LEVEL");
		outcome_entity_type.add("L1LEVEL");
		outcome_entity_type.add("L0LEVEL");
		ArrayList<String> L2LEVEL_outcome = new ArrayList<String>();
		ArrayList<String> L2LEVEL_outcome_value = new ArrayList<String>();
		ArrayList<String> L1LEVEL_outcome = new ArrayList<String>();
		ArrayList<String> L1LEVEL_outcome_value = new ArrayList<String>();
		ArrayList<String> L0LEVEL_outcome = new ArrayList<String>();
		ArrayList<String> L0LEVEL_outcome_value = new ArrayList<String>();

		for (String outcome_entity : outcome_entity_type) {
			if (outcome_entity.equals("L1LEVEL")) {
				L1LEVEL_outcome.add("L1_LEVEL");
				L1LEVEL_outcome.add("L1_PRODUCTIVITY_OF_EC_EA");
				L1LEVEL_outcome.add("L1_PRODUCTIVITY_OF_AG");
				L1LEVEL_outcome.add("L1_CATEGORY");
				L1LEVEL_outcome.add("L1_COMMISSION");
				L1LEVEL_outcome.add("L1_TEAM_SALE_COMMISSION");
				L1LEVEL_outcome.add("L1_SKU_INCENTIVE");
				L1LEVEL_outcome.add("L1_FINAL_COLLECTION_VALUE");
				
			} else if (outcome_entity.equals("L0LEVEL")) {
				L0LEVEL_outcome.add("L0_PRODUCTIVITY_FOR_EC_EA");
				L0LEVEL_outcome.add("L0_PRODUCTIVITY_FOR_AG");
				L0LEVEL_outcome.add("L0_COMMISSION");
				L0LEVEL_outcome.add("L0_SKU_INCENTIVE");
				L0LEVEL_outcome.add("L0_CATEGORY");
				L0LEVEL_outcome.add("L0_VINTAGE_PERIOD");
				L0LEVEL_outcome.add("L0_LEVEL");
				L0LEVEL_outcome.add("L0_FINAL_COLLECTION_VALUE");
				
			} else if (outcome_entity.equals("L2LEVEL")) {
				L2LEVEL_outcome.add("L2_LEVEL");
				L2LEVEL_outcome.add("L2_COMMISSION");
				L2LEVEL_outcome.add("L2_QUARTERLY_COMMISSION");
				L2LEVEL_outcome.add("L2_OPERATIVE_INCENTIVE");
				L2LEVEL_outcome.add("L2_CATEGORY");
			}
		}

		ArrayList<String> agent_instances = new ArrayList<String>();
		agent_instances.add(inputdata.getMaterialGroup());

		ArrayList<String> L2_instances = new ArrayList<String>();
		ArrayList<String> L1_instances = new ArrayList<String>();
		ArrayList<String> L0_instances = new ArrayList<String>();

		for (EurekaEmpMaster L2Level : inputdata.getL2level()) {
			L2_instances.add(Integer.toString(L2Level.getEmpId()));
		}
		for (int i = 0; i < L2_instances.size(); i++) {
			L2LEVEL_outcome_value.clear();

			EurekaEmpMaster l2level = inputdata.getL2level().get(i);
			for (String l2level_att : L2LEVEL_outcome) {
				String xmlpath = "/Envelope/Body/assess-response/global-instance/entity/instance/entity[@id='L2LEVEL']/instance[@id='"
						+ L2_instances.get(i) + "']/attribute";
				String expression = xmlpath + "[@id='" + l2level_att + "']";
				String l2level_value = xPath.compile(expression).evaluate(xmlDocument);
				L2LEVEL_outcome_value.add(l2level_value);

				try {
					if (l2level_att.equals("L2_LEVEL")) {
						inputdata.getL2level().get(i).setL2EmpId(new BigDecimal(l2level_value).intValue());
					} else if (l2level_att.equals("L2_COMMISSION")) {
						inputdata.getL2level().get(i).setL2_commission(new BigDecimal(l2level_value).floatValue());
					} else if (l2level_att.equals("L2_CATEGORY")) {
						inputdata.getL2level().get(i).setHrDesignation(l2level_value);
					} else if (l2level_att.equals("L2_QUARTERLY_COMMISSION")) {
						inputdata.getL2level().get(i).setL2_qua_commission(new BigDecimal(l2level_value).floatValue());
					} else if (l2level_att.equals("L2_OPERATIVE_INCENTIVE")) {
						inputdata.getL2level().get(i).setL2_oper_incentive(new BigDecimal(l2level_value).floatValue());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// L1 Level response
			L1_instances.clear();

			for (EurekaEmpMaster L1Level : inputdata.getL2level().get(i).getL1level()) {
				L1_instances.add(Integer.toString(L1Level.getEmpId()));
			}
			for (int j = 0; j < L1_instances.size(); j++) {

				L1LEVEL_outcome_value.clear();
				for (String l1level_att : L1LEVEL_outcome) {
					String xmlpath = "/Envelope/Body/assess-response/global-instance/entity/instance/entity[@id='L2LEVEL']/instance[@id='"
							+ L2_instances.get(i) + "']/entity/instance[@id='" + L1_instances.get(j) + "']/attribute";
					String expression = xmlpath + "[@id='" + l1level_att + "']";

					String l1level_value = xPath.compile(expression).evaluate(xmlDocument);
					L1LEVEL_outcome_value.add(l1level_value);

					try {
						if (l1level_att.equals("L1_LEVEL")) {
							inputdata.getL2level().get(i).getL1level().get(j)
									.setEmpId(new BigDecimal(l1level_value).intValue());
						} else if (l1level_att.equals("L1_CATEGORY")) {
							inputdata.getL2level().get(i).getL1level().get(j).setHrDesignation(l1level_value);
						} else if (l1level_att.equals("L1_PRODUCTIVITY_OF_EC_EA")) {
							inputdata.getL2level().get(i).getL1level().get(j)
									.setL1_productivity_of_ec_ea(new BigDecimal(l1level_value).floatValue());
						} else if (l1level_att.equals("L1_PRODUCTIVITY_OF_AG")) {
							inputdata.getL2level().get(i).getL1level().get(j)
									.setL1_productivity_of_ag(new BigDecimal(l1level_value).floatValue());
						} else if (l1level_att.equals("L1_SKU_INCENTIVE")) {
							inputdata.getL2level().get(i).getL1level().get(j)
									.setL1_sku_incentive(new BigDecimal(l1level_value).floatValue());
						} else if (l1level_att.equals("L1_TEAM_SALE_COMMISSION")) {
							inputdata.getL2level().get(i).getL1level().get(j)
									.setL1_team_sales_commiss(new BigDecimal(l1level_value).floatValue());
						} else if (l1level_att.equals("L1_COMMISSION")) {
							inputdata.getL2level().get(i).getL1level().get(j)
									.setL1_commission(new BigDecimal(l1level_value).floatValue());
						}else if (l1level_att.equals("L1_FINAL_COLLECTION_VALUE")) {
							inputdata.getL2level().get(i).getL1level().get(j).setL1_status(l1level_value);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				L0LEVEL_outcome_value.clear();
				L0_instances.clear();

				for (EurekaEmpMaster L0Level : inputdata.getL2level().get(i).getL1level().get(j).getL0level()) {
					L0_instances.add(Integer.toString(L0Level.getEmpId()));
				}
				for (int k = 0; k < L0_instances.size(); k++) {

					for (String l0level_att : L0LEVEL_outcome) {
						String xmlpath = "/Envelope/Body/assess-response/global-instance/entity/instance/entity[@id='L2LEVEL']/instance[@id='"
								+ L2_instances.get(i) + "']/entity/instance[@id='" + L1_instances.get(j)
								+ "']/entity/instance[@id='" + L0_instances.get(k) + "']/attribute";
						String expression = xmlpath + "[@id='" + l0level_att + "']";

						String l0level_value = xPath.compile(expression).evaluate(xmlDocument);
						L0LEVEL_outcome_value.add(l0level_value);

						try {

							if (l0level_att.equals("L0_LEVEL")) {
								inputdata.getL2level().get(i).getL1level().get(j).getL0level().get(k)
										.setEmpId(new BigDecimal(l0level_value).intValue());
							} else if (l0level_att.equals("L0_CATEGORY")) {
								inputdata.getL2level().get(i).getL1level().get(j).getL0level().get(k)
										.setHrDesignation(l0level_value);
							} else if (l0level_att.equals("L0_PRODUCTIVITY_FOR_EC_EA")) {
								inputdata.getL2level().get(i).getL1level().get(j).getL0level().get(k)
										.setL0_productivity_of_ec_ea(new BigDecimal(l0level_value).floatValue());
							} else if (l0level_att.equals("L0_PRODUCTIVITY_FOR_AG")) {
								inputdata.getL2level().get(i).getL1level().get(j).getL0level().get(k)
										.setL0_productivity_of_ag(new BigDecimal(l0level_value).floatValue());
							} else if (l0level_att.equals("L0_COMMISSION")) {
								inputdata.getL2level().get(i).getL1level().get(j).getL0level().get(k)
										.setL0_commission(new BigDecimal(l0level_value).floatValue());
							} else if (l0level_att.equals("L0_SKU_INCENTIVE")) {
								inputdata.getL2level().get(i).getL1level().get(j).getL0level().get(k)
										.setL0_sku_incentive(new BigDecimal(l0level_value).floatValue());
							} else if (l0level_att.equals("L0_VINTAGE_PERIOD")) {
								inputdata.getL2level().get(i).getL1level().get(j).getL0level().get(k)
										.setL0_vintage_period(new BigDecimal(l0level_value).intValue());
							}else if (l0level_att.equals("L0_FINAL_COLLECTION_VALUE")) {
								inputdata.getL2level().get(i).getL1level().get(j).getL0level().get(k)
								.setL0_status(l0level_value);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
}
package com.omfys.bsat.controller;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.email.EmailService;
import com.omfys.bsat.model.Bpil_DealerOPAInput;
import com.omfys.bsat.model.Bpil_Dealer_Master;
import com.omfys.bsat.model.Bpil_Dealers_Rest;
import com.omfys.bsat.model.Bpil_Menu_Header;
import com.omfys.bsat.model.Bpil_Opa_Rw_Analysis_Rw;
import com.omfys.bsat.model.Bpil_Opa_Sch_Analysis_Rw;
import com.omfys.bsat.model.Bpil_ProductOPAInput;
import com.omfys.bsat.model.Bpil_Products_Rest;
import com.omfys.bsat.model.Bpil_RewardOPAOutput;
import com.omfys.bsat.model.Bpil_Scheme_Doc;
import com.omfys.bsat.model.Bpil_Scheme_Product_Outflow;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.Crm_Detail;
import com.omfys.bsat.model.New_Scheme_mstr;
import com.omfys.bsat.model.OiaData;
import com.omfys.bsat.model.TestExample;
import com.omfys.bsat.model.drools_obj;
import com.omfys.bsat.repository.SchemeMasterDao;

import oracle.jdbc.internal.OracleTypes;
import sun.misc.BASE64Encoder;

@Controller
public class BpilRestController {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Autowired
	TilesConfiguration hibernateConfiguration;

	@Autowired
	JdbcTemplate jdbctemplate;

	@Autowired
	private EmailService emailService;

	@Autowired
	SchemeMasterDao schememasterdao;

	public static final String ALGORITHM = "AES";
	public static final String KEY = "1Hbfh667adfDEJ78";
	public String callauthoparest_webservice(String schopaauthwebserviceUrl, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String OAuth2_token = "";
		System.out.println("The url is :- " + schopaauthwebserviceUrl);
		try {
//			String schopaauthwebserviceUrl = "https://bergerindiaprod--tst1.custhelp.com/determinations-server/batch/auth?grant_type=client_credentials&client_id=omfys&client_secret=omfysTest1@123";

			URL OAuth2_url = new URL(schopaauthwebserviceUrl);

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

				org.jsoup.nodes.Document html = Jsoup.parse(OAuth2_output);
				String title = html.title();
				String body = html.body().text();
				System.out.println("Input HTML String to JSoup :" + OAuth2_output);
				System.out.println("After parsing, Title : " + title);
				System.out.println("Afte parsing, Heading : " + body);

				OAuth2_token = body;

			}

			OAuth2_conn.disconnect();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return OAuth2_token;
	}
	public String callauthoparest_webservice_crm(String schopaauthwebserviceUrl, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String OAuth2_token = "";
		System.out.println("The url is :- " + schopaauthwebserviceUrl);
		try {
//			String schopaauthwebserviceUrl = "https://bergerindiaprod--tst1.custhelp.com/determinations-server/batch/auth?grant_type=client_credentials&client_id=omfys&client_secret=omfysTest1@123";

			URL OAuth2_url = new URL(schopaauthwebserviceUrl);

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

				org.jsoup.nodes.Document html = Jsoup.parse(OAuth2_output);
				String title = html.title();
				String body = html.body().text();
				System.out.println("Input HTML String to JSoup :" + OAuth2_output);
				System.out.println("After parsing, Title : " + title);
				System.out.println("Afte parsing, Heading : " + body);

				OAuth2_token = body;

			}

			OAuth2_conn.disconnect();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return OAuth2_token;
	}

	public List<Bpil_RewardOPAOutput> callschoparest_webservice(List<Bpil_DealerOPAInput> dealerOPAInput,
			List<Bpil_ProductOPAInput> productOPAInput, String schnm, String depot, String dealer_bill_to_id,
			String schopawebserviceUrl, String oAuth2_token, HttpServletRequest request) {
		// TODO Auto-generated method stub
		// Create Rest Connection
		System.out.println("Url is AAAAAAAAAAAAAA: = " + schopawebserviceUrl);

		List<Bpil_RewardOPAOutput> RewardOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

		try {
			URL url = new URL(schopawebserviceUrl);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", oAuth2_token);

			String JSON_REQ = createDlrSchRestRequestJSONWriter(dealerOPAInput, productOPAInput, schnm, depot,
					dealer_bill_to_id, request);

			OutputStream os = conn.getOutputStream();
			os.write(JSON_REQ.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String JSON_RESP;
			System.out.println("Output from Server .... \n");
			while ((JSON_RESP = br.readLine()) != null) {
				System.out.println(JSON_RESP);

				RewardOPAOutput = printDlrSchRestResponseJSONReader(JSON_REQ, JSON_RESP, dealerOPAInput,
						productOPAInput, schnm, depot, dealer_bill_to_id, request);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return RewardOPAOutput;
	}

	private String createDlrSchRestRequestJSONWriter(List<Bpil_DealerOPAInput> dealerOPAInput,
			List<Bpil_ProductOPAInput> productOPAInput, String schnm, String depot, String dealer_bill_to_id,
			HttpServletRequest request) throws IOException {
		// TODO Auto-generated method stub

		JsonObjectBuilder JsonReqBuilder = Json.createObjectBuilder();
		JsonArrayBuilder outcomesBuilder = Json.createArrayBuilder();
		JsonArrayBuilder casesBuilder = Json.createArrayBuilder();

		List<String> outcomes = new ArrayList<String>();

		String[] Stroutcome = new String[] { "DLR_TOT_CN", "DLR_TOT_BDGT", "RW_SCH_ID", "RW_CODE", "RW_DLR_REGN",
				"RW_DLR_DEPOT", "RW_DLR_STATE", "RW_DLR_TERR_CODE", "RW_DLR_TERR_NAME", "RW_DLR_CODE", "RW_DLR_CAT",
				"RW_DLR_BILL_TO", "RW_DLR_TYPE", "RW_DLR_NAME", "RW_SEC", "RW_TYPE", "RW_PRD", "RW_UNIT", "RW_DATE",
				"RW_LY", "RW_TGT", "RW_TY", "RW_ADDITIONAL", "RW_BASE_TOTAL", "RW_Q_STAT", "RW_DESC", "RW_TOTAL",
				"RW_NXT_TGT", "RW_GFT_TO_CN", "RW_GFT_ID", "RW_CONV_CN", "RW_I_STAT", "RW_LAST_UPDATE" };

		outcomes = Arrays.asList(Stroutcome);

		for (String outcome : outcomes) {
			outcomesBuilder.add(outcome);
		}

		JsonReqBuilder.add("outcomes", outcomesBuilder);

		int dealercaseid = 1;

		for (Bpil_DealerOPAInput dealer : dealerOPAInput) {
			JsonObjectBuilder dealerBuilder = Json.createObjectBuilder();
			JsonArrayBuilder productsBuilder = Json.createArrayBuilder();

			dealerBuilder.add("@id", dealercaseid);
			dealerBuilder.add("DLR_SCH_ID", dealer.getDLR_SCH_ID());
			dealerBuilder.add("DLR_FIN_AN_FLAG", dealer.getDLR_FIN_AN_FLAG());
			dealerBuilder.add("DLR_REGN", dealer.getDLR_REGN());
			dealerBuilder.add("DLR_DEPOT", dealer.getDLR_DEPOT());
			if (dealer.getDLR_STATE() != null) {
				dealerBuilder.add("DLR_STATE", dealer.getDLR_STATE());
			} else {
				dealerBuilder.add("DLR_STATE", "");
			}
			dealerBuilder.add("DLR_TERR_CODE", dealer.getDLR_TERR_CODE());
			if (dealer.getDLR_TERR_NAME() != null) {
				dealerBuilder.add("DLR_TERR_NAME", dealer.getDLR_TERR_NAME());
			} else {
				dealerBuilder.add("DLR_TERR_NAME", "");
			}
			dealerBuilder.add("DLR_BILL_TO", dealer.getDLR_BILL_TO());
			dealerBuilder.add("DLR_AC_NO", dealer.getDLR_AC_NO());
			dealerBuilder.add("DLR_AC_NAME", dealer.getDLR_AC_NAME());
			dealerBuilder.add("DLR_CAT", dealer.getDLR_CAT());
			dealerBuilder.add("DLR_TYPE", dealer.getDLR_TYPE());
			dealerBuilder.add("DLR_RET", dealer.getDLR_RET());
			dealerBuilder.add("DLR_SDLR_COUNT", dealer.getDLR_SDLR_COUNT());

			int productid = 1;
			for (Bpil_ProductOPAInput product : productOPAInput) {
				JsonObjectBuilder productBuilder = Json.createObjectBuilder();

				productBuilder.add("@id", productid);
				productBuilder.add("PRD", Integer.toString(productid));
				productBuilder.add("PRD_SCH_ID", product.getPRD_SCH_ID());
				productBuilder.add("PRD_BILL_TO", product.getPRD_BILL_TO());
				productBuilder.add("PRD_DLR_AC_NO", product.getPRD_DLR_AC_NO());
				productBuilder.add("PRD_DLR_TYPE", product.getPRD_DLR_TYPE());
				productBuilder.add("PRD_NAME", product.getPRD_NAME());
				productBuilder.add("PRD_CAT", product.getPRD_CAT());
				productBuilder.add("PRD_CAT_DESC", product.getPRD_CAT_DESC());
				productBuilder.add("PRD_GRP", product.getPRD_GRP());
				productBuilder.add("PRD_CODE", product.getPRD_CODE());
				productBuilder.add("PRD_SHD_CODE", product.getPRD_SHD_CODE());
				productBuilder.add("PRD_INV_DT", new SimpleDateFormat("yyyy-MM-dd").format(product.getPRD_INV_DT()));
				productBuilder.add("PRD_UOM", product.getPRD_UOM());
				productBuilder.add("PRD_PCK_SIZE", product.getPRD_PCK_SIZE());
				productBuilder.add("PRD_VOL", product.getPRD_VOL());
				productBuilder.add("PRD_FNL_VOL", product.getPRD_FNL_VOL());
				productBuilder.add("PRD_VAL", product.getPRD_VAL());
				productBuilder.add("PRD_VOL_RW", product.getPRD_VOL_RW());
				productBuilder.add("PRD_FNL_VOL_RW", product.getPRD_FNL_VOL_RW());
				productBuilder.add("PRD_VAL_RW", product.getPRD_VAL_RW());

				productsBuilder.add(productBuilder);

				productid++;

			}

			dealerBuilder.add("products", productsBuilder);

			casesBuilder.add(dealerBuilder);

			dealercaseid++;
		}

		JsonReqBuilder.add("cases", casesBuilder);

		JsonObject JsonREQObject = JsonReqBuilder.build();

		System.out.println("JsonREQObject JSON String\n" + JsonREQObject);

		StringWriter strWtr = new StringWriter();
		JsonWriter jsonWtr = Json.createWriter(strWtr);
		jsonWtr.writeObject(JsonREQObject);
		String JSON_REQ = strWtr.toString();
		jsonWtr.close();
		strWtr.close();

		String reqxmlpath = request.getServletContext().getRealPath("/WEB-INF/classes/com/report");

		System.out.println("xmlpath = " + reqxmlpath);

		// write to file
		OutputStream os = new FileOutputStream(reqxmlpath + "/jsonrequest.json");
		JsonWriter jsonWriter = Json.createWriter(os);
		jsonWriter.writeObject(JsonREQObject);
		jsonWriter.close();
		os.close();

		System.out.println(JSON_REQ);
		return JSON_REQ;

	}

	private List<Bpil_RewardOPAOutput> printDlrSchRestResponseJSONReader(String JSON_REQ, String JSON_RESP,
			List<Bpil_DealerOPAInput> dealerOPAInput, List<Bpil_ProductOPAInput> productOPAInput, String schnm,
			String depot, String dealer_bill_to_id, HttpServletRequest request) throws IOException, ParseException {
		// TODO Auto-generated method stub

		List<Bpil_RewardOPAOutput> RewardOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

		StringReader strReqRdr = new StringReader(JSON_REQ);

		// create JsonReader object
		JsonReader jsonReqReader = Json.createReader(strReqRdr);

		// get JsonObject from JsonReader
		JsonObject JsonREQObject = jsonReqReader.readObject();

		// we can close IO resource and JsonReader now
		jsonReqReader.close();
		strReqRdr.close();

		System.out.println("JsonREQObject JSON String\n" + JsonREQObject);

		String reqxmlpath = request.getServletContext().getRealPath("/WEB-INF/classes/com/report");

		System.out.println("xmlpath = " + reqxmlpath);

		// write to file
		OutputStream reqos = new FileOutputStream(reqxmlpath + "/jsonrequest.json");
		JsonWriter jsonReqWriter = Json.createWriter(reqos);
		jsonReqWriter.writeObject(JsonREQObject);
		jsonReqWriter.close();
		reqos.close();

		System.out.println(JSON_REQ);

		StringReader strRespRdr = new StringReader(JSON_RESP);

		// create JsonReader object
		JsonReader jsonRespReader = Json.createReader(strRespRdr);

		// get JsonObject from JsonReader
		JsonObject JsonRESPObject = jsonRespReader.readObject();

		// we can close IO resource and JsonReader now
		jsonRespReader.close();
		strRespRdr.close();

		System.out.println("JsonRESPObject JSON String\n" + JsonRESPObject);

		// write to file
		OutputStream respos = new FileOutputStream(reqxmlpath + "/jsonresponse.json");
		JsonWriter jsonRespWriter = Json.createWriter(respos);
		jsonRespWriter.writeObject(JsonRESPObject);
		jsonRespWriter.close();
		respos.close();

		System.out.println(JSON_RESP);

		JsonArray cases = JsonRESPObject.getJsonArray("cases");
		List<Bpil_DealerOPAInput> DealerOPAInput = new ArrayList<Bpil_DealerOPAInput>(cases.size());
		for (JsonValue dlr_value : cases) {
			Bpil_DealerOPAInput dealer = new Bpil_DealerOPAInput();
			DealerOPAInput.add(dealer);

			System.out.println(dlr_value.toString());
			JsonObject DLR_object = (JsonObject) dlr_value;

			dealer.setID(DLR_object.getInt("@id"));
			System.out.println(DLR_object.getInt("@id"));
			dealer.setDLR_TOT_CN(DLR_object.getJsonNumber("DLR_TOT_CN").bigDecimalValue());
			System.out.println(DLR_object.getJsonNumber("DLR_TOT_CN"));
			dealer.setDLR_TOT_BDGT(DLR_object.getJsonNumber("DLR_TOT_BDGT").bigDecimalValue());
			System.out.println(DLR_object.getJsonNumber("DLR_TOT_BDGT"));

			JsonArray rewards = DLR_object.getJsonArray("rewards");
			RewardOPAOutput = new ArrayList<Bpil_RewardOPAOutput>(rewards.size());
			for (JsonValue rw_value : rewards) {
				Bpil_RewardOPAOutput bsat_RW = new Bpil_RewardOPAOutput();
				RewardOPAOutput.add(bsat_RW);

				System.out.println(rw_value.toString());
				JsonObject RW_object = (JsonObject) rw_value;

				bsat_RW.setID(RW_object.getInt("@id"));
				System.out.println(RW_object.getInt("@id"));
				bsat_RW.setRW_SCH_ID(RW_object.getInt("RW_SCH_ID"));
				System.out.println(RW_object.getInt("RW_SCH_ID"));
				bsat_RW.setRW_CODE(RW_object.getString("RW_CODE"));
				System.out.println(RW_object.getString("RW_CODE"));
				bsat_RW.setRW_DLR_REGN(RW_object.getString("RW_DLR_REGN"));
				System.out.println(RW_object.getString("RW_DLR_REGN"));
				bsat_RW.setRW_DLR_DEPOT(RW_object.getString("RW_DLR_DEPOT"));
				System.out.println(RW_object.getString("RW_DLR_DEPOT"));
				bsat_RW.setRW_DLR_STATE(RW_object.getString("RW_DLR_STATE"));
				System.out.println(RW_object.getString("RW_DLR_STATE"));
				bsat_RW.setRW_DLR_TERR_CODE(RW_object.getString("RW_DLR_TERR_CODE"));
				System.out.println(RW_object.getString("RW_DLR_TERR_CODE"));
				bsat_RW.setRW_DLR_TERR_NAME(RW_object.getString("RW_DLR_TERR_NAME"));
				System.out.println(RW_object.getString("RW_DLR_TERR_NAME"));
				bsat_RW.setRW_DLR_CODE(RW_object.getString("RW_DLR_CODE"));
				System.out.println(RW_object.getString("RW_DLR_CODE"));
				bsat_RW.setRW_DLR_CAT(RW_object.getString("RW_DLR_CAT"));
				System.out.println(RW_object.getString("RW_DLR_CAT"));
				bsat_RW.setRW_DLR_BILL_TO(RW_object.getInt("RW_DLR_BILL_TO"));
				System.out.println(RW_object.getInt("RW_DLR_BILL_TO"));
				bsat_RW.setRW_DLR_TYPE(RW_object.getString("RW_DLR_TYPE"));
				System.out.println(RW_object.getString("RW_DLR_TYPE"));
				bsat_RW.setRW_DLR_NAME(RW_object.getString("RW_DLR_NAME"));
				System.out.println(RW_object.getString("RW_DLR_NAME"));
				bsat_RW.setRW_SEC(RW_object.getString("RW_SEC"));
				System.out.println(RW_object.getString("RW_SEC"));
				bsat_RW.setRW_TYPE(RW_object.getString("RW_TYPE"));
				System.out.println(RW_object.getString("RW_TYPE"));
				bsat_RW.setRW_PRD(RW_object.getString("RW_PRD"));
				System.out.println(RW_object.getString("RW_PRD"));
				bsat_RW.setRW_UNIT(RW_object.getString("RW_UNIT"));
				System.out.println(RW_object.getString("RW_UNIT"));
				bsat_RW.setRW_DATE(new SimpleDateFormat("yyyy-MM-dd").parse(RW_object.getString("RW_DATE")));
				System.out.println(RW_object.getString("RW_DATE"));
				bsat_RW.setRW_LY(RW_object.getJsonNumber("RW_LY").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_LY"));
				bsat_RW.setRW_TGT(RW_object.getJsonNumber("RW_TGT").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_TGT"));
				bsat_RW.setRW_TY(RW_object.getJsonNumber("RW_TY").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_TY"));
				bsat_RW.setRW_ADDITIONAL(RW_object.getJsonNumber("RW_ADDITIONAL").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_ADDITIONAL"));
				/*
				 * if(RW_object.get("RW_BASE_TOTAL") != null) {
				 * bsat_RW.setRW_BASE_TOTAL(((JsonNumber)
				 * RW_object.get("RW_BASE_TOTAL")).bigDecimalValue()); }else {
				 */
				bsat_RW.setRW_BASE_TOTAL(BigDecimal.valueOf(0));
				// }
				// System.out.println(RW_object.getJsonNumber("RW_BASE_TOTAL"));
				bsat_RW.setRW_Q_STAT(RW_object.getString("RW_Q_STAT"));
				System.out.println(RW_object.getString("RW_Q_STAT"));
				bsat_RW.setRW_DESC(RW_object.getString("RW_DESC"));
				System.out.println(RW_object.getString("RW_DESC"));
				bsat_RW.setRW_TOTAL(RW_object.getJsonNumber("RW_TOTAL").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_TOTAL"));
				bsat_RW.setRW_NXT_TGT(RW_object.getJsonNumber("RW_NXT_TGT").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_NXT_TGT"));
				bsat_RW.setRW_GFT_TO_CN(RW_object.getString("RW_GFT_TO_CN"));
				System.out.println(RW_object.getString("RW_GFT_TO_CN"));
				// bsat_RW.setRW_GFT_ID(RW_object.getString("RW_GFT_ID"));
				bsat_RW.setRW_GFT_ID("");
				// System.out.println(RW_object.getString("RW_GFT_ID"));
				bsat_RW.setRW_CONV_CN(RW_object.getJsonNumber("RW_CONV_CN").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_CONV_CN"));
				bsat_RW.setRW_I_STAT(RW_object.getString("RW_I_STAT"));
				System.out.println(RW_object.getString("RW_I_STAT"));
				bsat_RW.setRW_LAST_UPDATE(
						new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(RW_object.getString("RW_LAST_UPDATE")));
				System.out.println(RW_object.getString("RW_LAST_UPDATE"));

			}

		}

		return RewardOPAOutput;
	}

	@RequestMapping(value = "/callschoparest_webservice1")
	public ModelAndView callschoparest_webservice1(Model model, @RequestParam(value = "scheme_id") String schnm,
			@RequestParam(value = "depot") String depot, @RequestParam(value = "bill_to_id") String bill_to_id,
			HttpServletRequest request) {
		//code change 26 sept 2023 after demo delete it 
		
		schnm="1734";
		depot="021";
		bill_to_id="";
				
				
		
		
		//end of code change 
		
		
		System.out.println("inside callschoparest_webservice1---------with parameter values--scheme id----"+schnm+"-- depot -"+depot+"_  bill to id ___"+bill_to_id+"_________");
		System.out.println("1   " + schnm);
		System.out.println("2   " + depot);
		System.out.println("3   " + bill_to_id);
		// TODO Auto-generated method stub
		///// -12-06-21-///////////
		List<String> dealer_name = new ArrayList<>();
		if (bill_to_id == "") {
			System.out.println("bill_to_id is empty");

			List<Bpil_Opa_Rw_Analysis_Rw> dml = new ArrayList<Bpil_Opa_Rw_Analysis_Rw>();
			CallableStatement cStmts;
			try {
				cStmts = hibernateConfiguration.dataSource().getConnection()
						.prepareCall("{call BPIL_GET_OPA_SCH_DLR(?,?,?)}");
				cStmts.setInt(1, Integer.parseInt(schnm));
				cStmts.setString(2, depot);
				cStmts.registerOutParameter(3, OracleTypes.CURSOR);
				ResultSet result = cStmts.executeQuery();
				ResultSet rs1 = (ResultSet) cStmts.getObject(3);
				while (rs1.next()) {
					Bpil_Opa_Rw_Analysis_Rw aContact = new Bpil_Opa_Rw_Analysis_Rw();
					System.out.println(rs1.getString("OPA_RW_AN_DEALER_ID"));
					System.out.println(rs1.getString("DLR_AC_NAME"));
					System.out.println(rs1.getString("DLR_AC_NO"));
					System.out.println(rs1.getInt("DLR_BILL_TO"));
					aContact.setOpa_rw_an_dealer_id(rs1.getString("OPA_RW_AN_DEALER_ID"));
					aContact.setDlr_ac_no(rs1.getString("DLR_AC_NO"));
					aContact.setDlr_name(rs1.getString("DLR_AC_NAME"));
					aContact.setDlr_bill_to(rs1.getInt("DLR_BILL_TO"));

					dml.add(aContact);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(dml.toString());
			Iterator<Bpil_Opa_Rw_Analysis_Rw> itr = dml.iterator();
			while (itr.hasNext()) {
				Bpil_Opa_Rw_Analysis_Rw br = itr.next();
				dealer_name.add(String.valueOf(br.getDlr_bill_to()));
			}

			System.out.println("list of dealer_name" + dealer_name.toString());
		} else {
			dealer_name = Arrays.asList(bill_to_id.split(","));
			System.out.println("list " + dealer_name.toString());
		}

		ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
				.find("from New_Scheme_mstr where scheme_id = '" + schnm + "'");
		System.out.println("Size of scheme master array is : " + dml.size());
		System.out.println("Scheme policy name is :- " + dml.get(0).getSch_dir_name());
		String schopawebserviceUrl = "";
		if (dml != null && dml.size() > 0) {
			String opa_sch_policy_name = dml.get(0).getSch_dir_name();
			System.out.println("Scheme policy name is :- " + opa_sch_policy_name);
			if (opa_sch_policy_name != null && !opa_sch_policy_name.equals("")) {

				schopawebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/12.2.7/policy-models/"
						+ opa_sch_policy_name + "/assessor";
			}

		}
		System.out.println("Url is : = " + schopawebserviceUrl);
		String OAuth2_token = "";
		if (dealer_name.size() > 0) {

			String schopaauthwebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/auth?grant_type=client_credentials&client_id=apiuser1&client_secret=ApiUser$111";

			OAuth2_token = callauthoparest_webservice(schopaauthwebserviceUrl, request);

		}
		////////////// END////////////////

		// Start trial code
		List<Bpil_DealerOPAInput> dealerOPAInput = new ArrayList<Bpil_DealerOPAInput>();
		List<Bpil_ProductOPAInput> productOPAInput = new ArrayList<Bpil_ProductOPAInput>();
		// String schopaauthwebserviceUrl =
		// "https://iflictest2.custhelp.com/determinations-server/batch/auth?grant_type=client_credentials&client_id=apiuser1&client_secret=ApiUser$111";
		// String oAuth2_token = "";
		// oAuth2_token = callauthoparest_webservice(schopaauthwebserviceUrl, request);
		// End Trial code
		// Create Rest Connection

		List<Bpil_RewardOPAOutput> RewardSchOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

		for (String dealer_bill_to_id : dealer_name) {

			List<Bpil_DealerOPAInput> DealerOPAInput = new ArrayList<Bpil_DealerOPAInput>();
			List<Bpil_ProductOPAInput> ProductOPAInput = new ArrayList<Bpil_ProductOPAInput>();
			List<Bpil_RewardOPAOutput> RewardOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

			CallableStatement cStmt;
			try {
				cStmt = hibernateConfiguration.dataSource().getConnection()
						.prepareCall("{call BPIL_GET_OPA_DLR_INPUT(?,?,?,?,?)}");
				cStmt.setInt(1, Integer.parseInt(schnm));
				cStmt.setString(2, depot);
				cStmt.setInt(3, Integer.parseInt(dealer_bill_to_id));

				cStmt.registerOutParameter(4, OracleTypes.CURSOR);
				cStmt.registerOutParameter(5, OracleTypes.CURSOR);

				ResultSet result = cStmt.executeQuery();
				ResultSet rsdealers = (ResultSet) cStmt.getObject(4);
				ResultSet rsproducts = (ResultSet) cStmt.getObject(5);

				while (rsdealers.next()) {
					Bpil_DealerOPAInput bpil_DealerOPAInput = new Bpil_DealerOPAInput();

					bpil_DealerOPAInput.setDLR_SCH_ID(rsdealers.getInt("SCHEME_ID"));
					bpil_DealerOPAInput.setDLR_FIN_AN_FLAG(rsdealers.getString("FIN_AN_FLAG"));
					bpil_DealerOPAInput.setDLR_REGN(rsdealers.getString("DLR_REGN"));
					bpil_DealerOPAInput.setDLR_DEPOT(rsdealers.getString("DLR_DEPOT"));
					bpil_DealerOPAInput.setDLR_STATE(rsdealers.getString("DLR_STATE"));
					bpil_DealerOPAInput.setDLR_TERR_CODE(rsdealers.getString("DLR_TERR_CODE"));
					bpil_DealerOPAInput.setDLR_TERR_NAME(rsdealers.getString("DLR_TERR_NAME"));
					bpil_DealerOPAInput.setDLR_BILL_TO(rsdealers.getInt("DLR_BILL_TO"));
					bpil_DealerOPAInput.setDLR_AC_NO(rsdealers.getString("DLR_AC_NO"));
					bpil_DealerOPAInput.setDLR_AC_NAME(rsdealers.getString("DLR_AC_NAME"));
					bpil_DealerOPAInput.setDLR_CAT(rsdealers.getString("DLR_CAT"));
					bpil_DealerOPAInput.setDLR_TYPE(rsdealers.getString("DLR_TYPE"));
					bpil_DealerOPAInput.setDLR_RET(rsdealers.getString("DLR_RET"));
					bpil_DealerOPAInput.setDLR_SDLR_COUNT(rsdealers.getInt("DLR_SDLR_COUNT"));

					DealerOPAInput.add(bpil_DealerOPAInput);
				}

				while (rsproducts.next()) {
					Bpil_ProductOPAInput bpil_ProductOPAInput = new Bpil_ProductOPAInput();

					bpil_ProductOPAInput.setPRD_SCH_ID(rsproducts.getInt("PRD_SCH_ID"));
					bpil_ProductOPAInput.setPRD_BILL_TO(rsproducts.getInt("PRD_BILL_TO"));
					bpil_ProductOPAInput.setPRD_DLR_AC_NO(rsproducts.getString("PRD_DLR_AC_NO"));
					bpil_ProductOPAInput.setPRD_DLR_TYPE(rsproducts.getString("PRD_DLR_TYPE"));
					bpil_ProductOPAInput.setPRD_NAME(rsproducts.getString("PRD_NAME"));
					bpil_ProductOPAInput.setPRD_CAT(rsproducts.getString("PRD_CAT"));
					bpil_ProductOPAInput.setPRD_CAT_DESC(rsproducts.getString("PRD_CAT_DESC"));
					bpil_ProductOPAInput.setPRD_GRP(rsproducts.getString("PRD_GRP"));
					bpil_ProductOPAInput.setPRD_CODE(rsproducts.getString("PRD_CODE"));
					bpil_ProductOPAInput.setPRD_SHD_CODE(rsproducts.getString("PRD_SHD_CODE"));
					bpil_ProductOPAInput.setPRD_INV_DT(rsproducts.getDate("PRD_INV_DT"));
					bpil_ProductOPAInput.setPRD_UOM(rsproducts.getString("PRD_UOM"));
					bpil_ProductOPAInput.setPRD_PCK_SIZE(rsproducts.getBigDecimal("PRD_PCK_SIZE"));
					bpil_ProductOPAInput.setPRD_VOL(rsproducts.getBigDecimal("PRD_VOL"));
					bpil_ProductOPAInput.setPRD_FNL_VOL(rsproducts.getBigDecimal("PRD_FNL_VOL"));
					bpil_ProductOPAInput.setPRD_VAL(rsproducts.getBigDecimal("PRD_VAL"));
					bpil_ProductOPAInput.setPRD_VOL_RW(rsproducts.getBigDecimal("PRD_VOL_RW"));
					bpil_ProductOPAInput.setPRD_FNL_VOL_RW(rsproducts.getBigDecimal("PRD_FNL_VOL_RW"));
					bpil_ProductOPAInput.setPRD_VAL_RW(rsproducts.getBigDecimal("PRD_VAL_RW"));

					ProductOPAInput.add(bpil_ProductOPAInput);
				}

				System.out.println("Dealers size = " + DealerOPAInput.size() + " Products = " + ProductOPAInput.size());

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			Date Sd = new Date();
			System.out.println("Start call to webservice" + Sd);
			System.out.println("sch opa rest url is : = " + schopawebserviceUrl);
			RewardOPAOutput = callschoparest_webservice(DealerOPAInput, ProductOPAInput, schnm, depot,
					dealer_bill_to_id, schopawebserviceUrl, OAuth2_token, request);

			Date Ed = new Date();
			System.out.println("End call to webservice" + Ed);

			System.out.println("Total time : Sw " + Sd + " Ew " + Ed);

			RewardSchOPAOutput.addAll(RewardOPAOutput);

		}
		System.out.println("Total size of  RewardSchOPAOutput: " + RewardSchOPAOutput.size());
		List<Bpil_Opa_Sch_Analysis_Rw> sch_Analysis_Rws = new ArrayList<Bpil_Opa_Sch_Analysis_Rw>();

		for (Bpil_RewardOPAOutput bpil_RewardOPAOutput : RewardSchOPAOutput) {

			Bpil_Opa_Sch_Analysis_Rw aContact = new Bpil_Opa_Sch_Analysis_Rw();

			aContact.setScheme_id(bpil_RewardOPAOutput.getRW_SCH_ID());
			aContact.setRegn(bpil_RewardOPAOutput.getRW_DLR_REGN());
			aContact.setState(bpil_RewardOPAOutput.getRW_DLR_STATE());
			aContact.setDepot(bpil_RewardOPAOutput.getRW_DLR_DEPOT());
			aContact.setTerr_code(bpil_RewardOPAOutput.getRW_DLR_TERR_CODE());
			aContact.setTerr_name(bpil_RewardOPAOutput.getRW_DLR_TERR_NAME());
			aContact.setDlr_ac_no(bpil_RewardOPAOutput.getRW_DLR_CODE());
			aContact.setDlr_cat(bpil_RewardOPAOutput.getRW_DLR_CAT());
			aContact.setDlr_bill_to(bpil_RewardOPAOutput.getRW_DLR_BILL_TO());
			aContact.setDlr_type(bpil_RewardOPAOutput.getRW_DLR_TYPE());
			aContact.setDlr_name(bpil_RewardOPAOutput.getRW_DLR_NAME());
			aContact.setReward_section(bpil_RewardOPAOutput.getRW_SEC());
			aContact.setReward_type(bpil_RewardOPAOutput.getRW_TYPE());
			aContact.setProduct(bpil_RewardOPAOutput.getRW_PRD());
			aContact.setUnit(bpil_RewardOPAOutput.getRW_UNIT());
			aContact.setReward_date(bpil_RewardOPAOutput.getRW_DATE());

			if (bpil_RewardOPAOutput.getRW_DATE() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
				String dateStr1 = ser1.format(bpil_RewardOPAOutput.getRW_DATE());
				aContact.setReward_date1(dateStr1);
//					try {
//						System.out.println(ser1.parse(rs.getString("REWARD_DATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}
			}

			aContact.setReward_ly(bpil_RewardOPAOutput.getRW_LY().intValue());
			aContact.setReward_target(bpil_RewardOPAOutput.getRW_TGT().intValue());
			aContact.setReward_ty(bpil_RewardOPAOutput.getRW_TY().intValue());
			aContact.setAdditional(bpil_RewardOPAOutput.getRW_ADDITIONAL().intValue());
			aContact.setBase_total(bpil_RewardOPAOutput.getRW_BASE_TOTAL().intValue());
			aContact.setReward_status(bpil_RewardOPAOutput.getRW_Q_STAT());
			aContact.setReward_description(bpil_RewardOPAOutput.getRW_DESC());
			aContact.setReward_total(bpil_RewardOPAOutput.getRW_TOTAL().intValue());
			aContact.setNext_tgt_pending(bpil_RewardOPAOutput.getRW_NXT_TGT().intValue());
			aContact.setGift_to_cn_flag(bpil_RewardOPAOutput.getRW_GFT_TO_CN());
			aContact.setConverted_cn_value(bpil_RewardOPAOutput.getRW_CONV_CN().intValue());
			aContact.setInterface_status(bpil_RewardOPAOutput.getRW_I_STAT());

			aContact.setReward_last_update(bpil_RewardOPAOutput.getRW_LAST_UPDATE());

			if (bpil_RewardOPAOutput.getRW_LAST_UPDATE() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String dateStr1 = ser1.format(bpil_RewardOPAOutput.getRW_LAST_UPDATE());
				aContact.setReward_last_update1(dateStr1);
//					try {
////						System.out.println(ser1.parse(rs.getString("REWARD_LAST_UPDATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}
			}

			sch_Analysis_Rws.add(aContact);

		}

		String LastRefresh = "";

		if (sch_Analysis_Rws.size() > 0) {

			if (sch_Analysis_Rws.get(0).getReward_last_update() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String dateStr1 = ser1.format(sch_Analysis_Rws.get(0).getReward_last_update());
//					try {
////						System.out.println(ser1.parse(rs.getString("REWARD_LAST_UPDATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}

				LastRefresh = dateStr1;
			}

		}
		if (schnm != null && schnm != "") {
			int scheme_id = Integer.parseInt(schnm);

			ArrayList<New_Scheme_mstr> data = (ArrayList<New_Scheme_mstr>) hibernateTemplate
					.find("from New_Scheme_mstr where scheme_id=" + scheme_id);
			String name = data.get(0).getScheme_name();

			ArrayList<Bpil_Scheme_Doc> doc_line = schememasterdao.docautofill(scheme_id);
			System.out.println("doc_line " + doc_line.size());

			model.addAttribute("doc_list", doc_line);

			model.addAttribute("Info_grid", sch_Analysis_Rws);

			model.addAttribute("LastRefresh", LastRefresh);

			model.addAttribute("schnm", name);
		}
		model.addAttribute("depo_code", depot);
		model.addAttribute("scheme_id", schnm);

		return new ModelAndView("SchemeAnalysisRest");
		/*
		 * try { URL url = new URL(schopawebserviceUrl);
		 * 
		 * HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 * 
		 * conn.setDoOutput(true); conn.setRequestMethod("POST");
		 * conn.setRequestProperty("Content-Type", "application/json");
		 * conn.setRequestProperty("Authorization", oAuth2_token);
		 * 
		 * String JSON_REQ =
		 * createDlrSchRestRequestJSONWriter(dealerOPAInput,productOPAInput, schnm,
		 * depot, bill_to_id, request);
		 * 
		 * OutputStream os = conn.getOutputStream(); os.write(JSON_REQ.getBytes());
		 * os.flush();
		 * 
		 * if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) { throw new
		 * RuntimeException("Failed : HTTP error code : " + conn.getResponseCode()); }
		 * 
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(conn.getInputStream()));
		 * 
		 * String JSON_RESP; System.out.println("Output from Server .... \n"); while
		 * ((JSON_RESP = br.readLine()) != null) { System.out.println(JSON_RESP);
		 * 
		 * RewardOPAOutput = printDlrSchRestResponseJSONReader(JSON_REQ,
		 * JSON_RESP,dealerOPAInput,productOPAInput, schnm, depot, bill_to_id, request);
		 * }
		 * 
		 * conn.disconnect();
		 * 
		 * 
		 * } catch (MalformedURLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (ParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}
	
	@Transactional
	@RequestMapping(value = "/payout_report_grid")
	public ModelAndView payout_report_grid(Model model, @RequestParam(value = "scheme_id") String schnm,
			@RequestParam(value = "depot") String depot, @RequestParam(value = "bill_to_id") String bill_to_id,
			HttpServletRequest request) {
		
		
		
		String sql = "SELECT * FROM BPIL_OPA_SCH_ANALYSIS_RW ";

//		List<Bpil_opa_scheme_analysis> dml = jdbcTemplate.query(sql, new RowMapper<Bpil_opa_scheme_analysis>() {

		List<Bpil_Opa_Sch_Analysis_Rw> dml = jdbctemplate.query(sql, new RowMapper<Bpil_Opa_Sch_Analysis_Rw>() {

			@Override

//			public Bpil_opa_scheme_analysis mapRow(ResultSet rs, int rowNum) throws SQLException {

			public Bpil_Opa_Sch_Analysis_Rw mapRow(ResultSet rs, int rowNum) throws SQLException {

//				Bpil_opa_scheme_analysis aContact = new Bpil_opa_scheme_analysis();

				Bpil_Opa_Sch_Analysis_Rw aContact = new Bpil_Opa_Sch_Analysis_Rw();

//				aContact.setOpa_analysis_id(rs.getInt("OPA_ANALYSIS_ID"));
//				aContact.setScheme_id(rs.getInt("SCHEME_ID"));
//				aContact.setTerr_code(rs.getString("TERR_CODE"));
//				aContact.setRegn(rs.getString("REGN"));			
//				aContact.setDepot(rs.getString("DEPOT"));				
//				aContact.setDlr_bill_to(rs.getInt("DLR_BILL_TO"));	
//				aContact.setDlr_ac_no(rs.getString("DLR_AC_NO"));	
//				aContact.setDlr_name(rs.getString("DLR_NAME"));	
//				aContact.setDlr_cat(rs.getString("DLR_CAT"));	
//				aContact.setDlr_type(rs.getString("DLR_TYPE"));				
//				aContact.setReward_section(rs.getString("REWARD_SECTION"));
//				aContact.setReward_type(rs.getString("REWARD_TYPE"));
//				aContact.setProduct(rs.getString("PRODUCT"));
//				aContact.setUnit(rs.getString("UNIT"));
//				aContact.setReward_date(rs.getDate("REWARD_DATE"));	
//				if(rs.getDate("REWARD_DATE")!=null)
//				{
//					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
//					String dateStr1 = ser1.format(rs.getDate("REWARD_DATE"));
//					aContact.setReward_date1(dateStr1);	
//					try {
//						System.out.println(ser1.parse(rs.getString("REWARD_DATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}
//				}
//				
//				
//				aContact.setReward_ly(rs.getInt("REWARD_LY"));
//				aContact.setReward_target(rs.getInt("REWARD_TARGET"));				
//				aContact.setReward_ty(rs.getInt("REWARD_TY"));				
//				aContact.setAdditional(rs.getInt("ADDITIONAL"));
//				aContact.setBase_total(rs.getInt("BASE_TOTAL"));
//				aContact.setNext_tgt_pending(rs.getInt("NEXT_TGT_PENDING"));
////				aContact.setAdjustments(rs.getInt("ADJUSTMENTS"));
//				aContact.setConverted_cn_value(rs.getInt("CONVERTED_CN_VALUE"));				
//				aContact.setReward_status(rs.getString("REWARD_STATUS"));
//				aContact.setReward_total(rs.getInt("REWARD_TOTAL"));

				aContact.setOpa_analysis_id(rs.getInt("OPA_SCH_AN_REWARD_ID"));
				aContact.setScheme_id(rs.getInt("REWARD_SCHEME_ID"));
				aContact.setRegn(rs.getString("REWARD_DLR_REGN"));
				aContact.setState(rs.getString("REWARD_DLR_STATE"));
				aContact.setDepot(rs.getString("REWARD_DLR_DEPOT"));
				aContact.setSup_code(rs.getString("REWARD_SUP_CODE"));
				aContact.setSup_name(rs.getString("REWARD_SUP_NAME"));
				aContact.setTerr_code(rs.getString("REWARD_DLR_TERR_CODE"));
				aContact.setTerr_name(rs.getString("REWARD_DLR_TERR_NAME"));
				aContact.setDlr_ac_no(rs.getString("REWARD_DLR_CODE"));
				aContact.setDlr_cat(rs.getString("REWARD_DLR_CAT"));
				aContact.setDlr_bill_to(rs.getInt("REWARD_DLR_BILL_TO"));
				aContact.setDlr_type(rs.getString("REWARD_DLR_TYPE"));
				aContact.setDlr_name(rs.getString("REWARD_DLR_NAME"));
				aContact.setReward_section(rs.getString("REWARD_SECTION"));
				aContact.setReward_type(rs.getString("REWARD_TYPE"));
				aContact.setProduct(rs.getString("REWARD_PRODUCT"));
				aContact.setUnit(rs.getString("REWARD_UNIT"));
				aContact.setReward_date(rs.getDate("REWARD_DATE"));

				if (rs.getDate("REWARD_DATE") != null) {
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("REWARD_DATE"));
					aContact.setReward_date1(dateStr1);
//					try {
//						System.out.println(ser1.parse(rs.getString("REWARD_DATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}
				}

				aContact.setReward_ly(rs.getInt("REWARD_LY"));
				aContact.setReward_target(rs.getInt("REWARD_TARGET"));
				aContact.setReward_ty(rs.getInt("REWARD_TY"));
				aContact.setAdditional(rs.getInt("REWARD_ADDITIONAL"));
				aContact.setBase_total(rs.getInt("REWARD_BASE_TOTAL"));
				aContact.setReward_status(rs.getString("REWARD_Q_STATUS"));
				aContact.setReward_description(rs.getString("REWARD_DESCRIPTION"));
				
				if(rs.getString("ATTRIBUTE1")!=null ) {
					
					if(rs.getString("ATTRIBUTE1").equals("A")) {
						
						aContact.setReward_total(rs.getInt("REWARD_ADJUSTMENTS"));
					}else {
						
						aContact.setReward_total(rs.getInt("REWARD_TOTAL"));
					}
					
					
				}else {
					
					aContact.setReward_total(rs.getInt("REWARD_TOTAL"));
				}
			
				
				
				aContact.setNext_tgt_pending(rs.getInt("REWARD_NEXT_TGT"));
				aContact.setGift_to_cn_flag(rs.getString("REWARD_GIFT_TO_CN"));
				aContact.setConverted_cn_value(rs.getInt("REWARD_CONVERTED_CN"));
				aContact.setInterface_status(rs.getString("REWARD_I_STATUS"));
				aContact.setReward_color(rs.getString("REWARD_COLOR"));
				aContact.setAttribute1(rs.getString("ATTRIBUTE1"));	
				aContact.setAdjustments((float)rs.getInt("REWARD_ADJUSTMENTS"));
				aContact.setAdjustment_reason(rs.getString("REWARD_ADJUSTMENT_REASON"));
			

				aContact.setReward_last_update(rs.getDate("REWARD_LAST_UPDATE"));

				if (rs.getDate("REWARD_LAST_UPDATE") != null) {
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
					String dateStr1 = ser1.format(rs.getTimestamp("REWARD_LAST_UPDATE"));
					aContact.setReward_last_update1(dateStr1);
//					try {
////						System.out.println(ser1.parse(rs.getString("REWARD_LAST_UPDATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}
				}

				return aContact;
			}

		});
		
		String LastRefresh = "";

		if (dml.size() > 0) {

			if (dml.get(0).getReward_last_update() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String dateStr1 = ser1.format(dml.get(0).getReward_last_update());
//					try {
////						System.out.println(ser1.parse(rs.getString("REWARD_LAST_UPDATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}

				LastRefresh = dateStr1;
			}

		}
		
		if (schnm != null && schnm != "") {
			int scheme_id = Integer.parseInt(schnm);

			ArrayList<New_Scheme_mstr> data = (ArrayList<New_Scheme_mstr>) hibernateTemplate
					.find("from New_Scheme_mstr where scheme_id=" + scheme_id);
			String name = data.get(0).getScheme_name();

			ArrayList<Bpil_Scheme_Doc> doc_line = schememasterdao.docautofill(scheme_id);
			System.out.println("doc_line " + doc_line.size());

			model.addAttribute("doc_list", doc_line);

			model.addAttribute("Info_grid", dml);

			model.addAttribute("LastRefresh", LastRefresh);

			model.addAttribute("schnm", name);
		}
		model.addAttribute("depo_code", depot);
		model.addAttribute("scheme_id", schnm);


		
		
		return new ModelAndView("payout_report");
		
	}
	
	@Transactional
	@RequestMapping(value = "/callschoparest_webservice1_new")
	public ModelAndView callschoparest_webservice1_new(Model model, @RequestParam(value = "scheme_id") String schnm,
			@RequestParam(value = "depot") String depot, @RequestParam(value = "bill_to_id") String bill_to_id,
			HttpServletRequest request) {
		
		
		ArrayList<New_Scheme_mstr> dml_nw = (ArrayList<New_Scheme_mstr>) hibernateTemplate
				.find("from New_Scheme_mstr where scheme_id = '"+schnm+"'");
		
		Date Edd = new Date();
		
		String schnm_nw=schnm;
		String depot_nw=depot;
		String bill_to_id_nw=bill_to_id;
		
		//code change 26 sept 2023 after demo delete it 
		
		schnm="1734";
		depot="021";
		bill_to_id="";
				
				
		
		
		//end of code change 
		
		
		System.out.println("inside callschoparest_webservice1---------with parameter values--scheme id----"+schnm_nw+"-- depot -"+depot+"_  bill to id ___"+bill_to_id+"_________");
		System.out.println("1   " + schnm);
		System.out.println("2   " + depot);
		System.out.println("3   " + bill_to_id);
		// TODO Auto-generated method stub
		///// -12-06-21-///////////
		List<String> dealer_name = new ArrayList<>();
		if (bill_to_id == "") {
			System.out.println("bill_to_id is empty");

			List<Bpil_Opa_Rw_Analysis_Rw> dml = new ArrayList<Bpil_Opa_Rw_Analysis_Rw>();
			CallableStatement cStmts;
			try {
				cStmts = hibernateConfiguration.dataSource().getConnection()
						.prepareCall("{call BPIL_GET_OPA_SCH_DLR(?,?,?)}");
				cStmts.setInt(1, Integer.parseInt(schnm));
				cStmts.setString(2, depot);
				cStmts.registerOutParameter(3, OracleTypes.CURSOR);
				ResultSet result = cStmts.executeQuery();
				ResultSet rs1 = (ResultSet) cStmts.getObject(3);
				while (rs1.next()) {
					Bpil_Opa_Rw_Analysis_Rw aContact = new Bpil_Opa_Rw_Analysis_Rw();
					System.out.println(rs1.getString("OPA_RW_AN_DEALER_ID"));
					System.out.println(rs1.getString("DLR_AC_NAME"));
					System.out.println(rs1.getString("DLR_AC_NO"));
					System.out.println(rs1.getInt("DLR_BILL_TO"));
					aContact.setOpa_rw_an_dealer_id(rs1.getString("OPA_RW_AN_DEALER_ID"));
					aContact.setDlr_ac_no(rs1.getString("DLR_AC_NO"));
					aContact.setDlr_name(rs1.getString("DLR_AC_NAME"));
					aContact.setDlr_bill_to(rs1.getInt("DLR_BILL_TO"));

					dml.add(aContact);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(dml.toString());
			Iterator<Bpil_Opa_Rw_Analysis_Rw> itr = dml.iterator();
			while (itr.hasNext()) {
				Bpil_Opa_Rw_Analysis_Rw br = itr.next();
				dealer_name.add(String.valueOf(br.getDlr_bill_to()));
			}

			System.out.println("list of dealer_name" + dealer_name.toString());
		} else {
			dealer_name = Arrays.asList(bill_to_id.split(","));
			System.out.println("else block list " + dealer_name.toString());
		}
		
		System.out.println("dealer_name To String method " + dealer_name.toString());

		ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
				.find("from New_Scheme_mstr where scheme_id = '" + schnm + "'");
		System.out.println("Size of scheme master array is : " + dml.size());
		System.out.println("Scheme policy name is :- " + dml.get(0).getSch_dir_name());
		String schopawebserviceUrl = "";
		if (dml != null && dml.size() > 0) {
			String opa_sch_policy_name = dml.get(0).getSch_dir_name();
			System.out.println("Scheme policy name is :- " + opa_sch_policy_name);
			if (opa_sch_policy_name != null && !opa_sch_policy_name.equals("")) {

//				schopawebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/12.2.7/policy-models/"
//						+ opa_sch_policy_name + "/assessor";
				
				
				System.out.println("newwww policy name is :- with schme id "+schnm_nw);
			
				
				
				ArrayList<OiaData> dml_nww = (ArrayList<OiaData>) hibernateTemplate
						.find("from OiaData where scheme_code = '"+schnm_nw+"'");
				
				schopawebserviceUrl=dml_nww.get(0).getOpa_url();
				//schopawebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/12.2.7/policy-models/BPIL_SCH_ML7_1734/assessor";
				System.out.println("newwww policy name is : "+schopawebserviceUrl);
			}

		}
		System.out.println("Url is : = " + schopawebserviceUrl);
		String OAuth2_token = "";
		if (dealer_name.size() > 0) {

			String schopaauthwebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/auth?grant_type=client_credentials&client_id=apiuser1&client_secret=ApiUser$111";

			OAuth2_token = callauthoparest_webservice(schopaauthwebserviceUrl, request);

		}
		////////////// END////////////////

		// Start trial code
		List<Bpil_DealerOPAInput> dealerOPAInput = new ArrayList<Bpil_DealerOPAInput>();
		List<Bpil_ProductOPAInput> productOPAInput = new ArrayList<Bpil_ProductOPAInput>();
		// String schopaauthwebserviceUrl =
		// "https://iflictest2.custhelp.com/determinations-server/batch/auth?grant_type=client_credentials&client_id=apiuser1&client_secret=ApiUser$111";
		// String oAuth2_token = "";
		// oAuth2_token = callauthoparest_webservice(schopaauthwebserviceUrl, request);
		// End Trial code
		// Create Rest Connection

		List<Bpil_RewardOPAOutput> RewardSchOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

		for (String dealer_bill_to_id : dealer_name) {

		
			
			List<Bpil_DealerOPAInput> DealerOPAInput = new ArrayList<Bpil_DealerOPAInput>();
			List<Bpil_ProductOPAInput> ProductOPAInput = new ArrayList<Bpil_ProductOPAInput>();
			List<Bpil_RewardOPAOutput> RewardOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

			CallableStatement cStmt;
			try {
				cStmt = hibernateConfiguration.dataSource().getConnection()
						.prepareCall("{call BPIL_GET_OPA_DLR_INPUT(?,?,?,?,?)}");
				cStmt.setInt(1, Integer.parseInt(schnm));
				cStmt.setString(2, depot);
				cStmt.setInt(3, Integer.parseInt(dealer_bill_to_id));

				cStmt.registerOutParameter(4, OracleTypes.CURSOR);
				cStmt.registerOutParameter(5, OracleTypes.CURSOR);

				ResultSet result = cStmt.executeQuery();
				ResultSet rsdealers = (ResultSet) cStmt.getObject(4);
				ResultSet rsproducts = (ResultSet) cStmt.getObject(5);

				while (rsdealers.next()) {
					Bpil_DealerOPAInput bpil_DealerOPAInput = new Bpil_DealerOPAInput();

					bpil_DealerOPAInput.setDLR_SCH_ID(rsdealers.getInt("SCHEME_ID"));
					bpil_DealerOPAInput.setDLR_FIN_AN_FLAG(rsdealers.getString("FIN_AN_FLAG"));
					bpil_DealerOPAInput.setDLR_REGN(rsdealers.getString("DLR_REGN"));
					bpil_DealerOPAInput.setDLR_DEPOT(rsdealers.getString("DLR_DEPOT"));
					bpil_DealerOPAInput.setDLR_STATE(rsdealers.getString("DLR_STATE"));
					bpil_DealerOPAInput.setDLR_TERR_CODE(rsdealers.getString("DLR_TERR_CODE"));
					bpil_DealerOPAInput.setDLR_TERR_NAME(rsdealers.getString("DLR_TERR_NAME"));
					bpil_DealerOPAInput.setDLR_BILL_TO(rsdealers.getInt("DLR_BILL_TO"));
					bpil_DealerOPAInput.setDLR_AC_NO(rsdealers.getString("DLR_AC_NO"));
					bpil_DealerOPAInput.setDLR_AC_NAME(rsdealers.getString("DLR_AC_NAME"));
					bpil_DealerOPAInput.setDLR_CAT(rsdealers.getString("DLR_CAT"));
					bpil_DealerOPAInput.setDLR_TYPE(rsdealers.getString("DLR_TYPE"));
					bpil_DealerOPAInput.setDLR_RET(rsdealers.getString("DLR_RET"));
					bpil_DealerOPAInput.setDLR_SDLR_COUNT(rsdealers.getInt("DLR_SDLR_COUNT"));

					DealerOPAInput.add(bpil_DealerOPAInput);
				}

				while (rsproducts.next()) {
					Bpil_ProductOPAInput bpil_ProductOPAInput = new Bpil_ProductOPAInput();

					bpil_ProductOPAInput.setPRD_SCH_ID(rsproducts.getInt("PRD_SCH_ID"));
					bpil_ProductOPAInput.setPRD_BILL_TO(rsproducts.getInt("PRD_BILL_TO"));
					bpil_ProductOPAInput.setPRD_DLR_AC_NO(rsproducts.getString("PRD_DLR_AC_NO"));
					bpil_ProductOPAInput.setPRD_DLR_TYPE(rsproducts.getString("PRD_DLR_TYPE"));
					bpil_ProductOPAInput.setPRD_NAME(rsproducts.getString("PRD_NAME"));
					bpil_ProductOPAInput.setPRD_CAT(rsproducts.getString("PRD_CAT"));
					bpil_ProductOPAInput.setPRD_CAT_DESC(rsproducts.getString("PRD_CAT_DESC"));
					bpil_ProductOPAInput.setPRD_GRP(rsproducts.getString("PRD_GRP"));
					bpil_ProductOPAInput.setPRD_CODE(rsproducts.getString("PRD_CODE"));
					bpil_ProductOPAInput.setPRD_SHD_CODE(rsproducts.getString("PRD_SHD_CODE"));
					bpil_ProductOPAInput.setPRD_INV_DT(rsproducts.getDate("PRD_INV_DT"));
					bpil_ProductOPAInput.setPRD_UOM(rsproducts.getString("PRD_UOM"));
					bpil_ProductOPAInput.setPRD_PCK_SIZE(rsproducts.getBigDecimal("PRD_PCK_SIZE"));
					bpil_ProductOPAInput.setPRD_VOL(rsproducts.getBigDecimal("PRD_VOL"));
					bpil_ProductOPAInput.setPRD_FNL_VOL(rsproducts.getBigDecimal("PRD_FNL_VOL"));
					bpil_ProductOPAInput.setPRD_VAL(rsproducts.getBigDecimal("PRD_VAL"));
					bpil_ProductOPAInput.setPRD_VOL_RW(rsproducts.getBigDecimal("PRD_VOL_RW"));
					bpil_ProductOPAInput.setPRD_FNL_VOL_RW(rsproducts.getBigDecimal("PRD_FNL_VOL_RW"));
					bpil_ProductOPAInput.setPRD_VAL_RW(rsproducts.getBigDecimal("PRD_VAL_RW"));

					ProductOPAInput.add(bpil_ProductOPAInput);
				}

				System.out.println("Dealers size = " + DealerOPAInput.size() + " Products = " + ProductOPAInput.size());

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			Date Sd = new Date();
			System.out.println("Start call to webservice" + Sd);
			System.out.println("sch opa rest url is : = " + schopawebserviceUrl);
			System.out.println("sch opa rest url is : = " + schopawebserviceUrl);
			RewardOPAOutput = callschoparest_webservice(DealerOPAInput, ProductOPAInput, schnm, depot,
					dealer_bill_to_id, schopawebserviceUrl, OAuth2_token, request);

			Date Ed = new Date();
			System.out.println("End call to webservice" + Ed);

			System.out.println("Total time : Sw " + Sd + " Ew " + Ed);

			RewardSchOPAOutput.addAll(RewardOPAOutput);

		}
		System.out.println("Total size of  RewardSchOPAOutput: " + RewardSchOPAOutput.size());
		List<Bpil_Opa_Sch_Analysis_Rw> sch_Analysis_Rws = new ArrayList<Bpil_Opa_Sch_Analysis_Rw>();
		
	

		for (Bpil_RewardOPAOutput bpil_RewardOPAOutput : RewardSchOPAOutput) {

			Bpil_Opa_Sch_Analysis_Rw aContact = new Bpil_Opa_Sch_Analysis_Rw();

			aContact.setScheme_id(bpil_RewardOPAOutput.getRW_SCH_ID());
			aContact.setRegn(bpil_RewardOPAOutput.getRW_DLR_REGN());
			aContact.setState(bpil_RewardOPAOutput.getRW_DLR_STATE());
			aContact.setDepot(bpil_RewardOPAOutput.getRW_DLR_DEPOT());
			aContact.setTerr_code(bpil_RewardOPAOutput.getRW_DLR_TERR_CODE());
			aContact.setTerr_name(bpil_RewardOPAOutput.getRW_DLR_TERR_NAME());
			aContact.setDlr_ac_no(bpil_RewardOPAOutput.getRW_DLR_CODE());
			aContact.setDlr_cat(bpil_RewardOPAOutput.getRW_DLR_CAT());
			aContact.setDlr_bill_to(bpil_RewardOPAOutput.getRW_DLR_BILL_TO());
			aContact.setDlr_type(bpil_RewardOPAOutput.getRW_DLR_TYPE());
			aContact.setDlr_name(bpil_RewardOPAOutput.getRW_DLR_NAME());
			aContact.setReward_section(bpil_RewardOPAOutput.getRW_SEC());
			aContact.setReward_type(bpil_RewardOPAOutput.getRW_TYPE());
			aContact.setProduct(bpil_RewardOPAOutput.getRW_PRD());
			aContact.setUnit(bpil_RewardOPAOutput.getRW_UNIT());
			//aContact.setReward_date(bpil_RewardOPAOutput.getRW_DATE());
			aContact.setReward_date(dml_nw.get(0).getEnd_date());

			if (bpil_RewardOPAOutput.getRW_DATE() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
				String dateStr1 = ser1.format(dml_nw.get(0).getEnd_date());
				aContact.setReward_date1(dateStr1);
//					try {
//						System.out.println(ser1.parse(rs.getString("REWARD_DATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}
			}

			aContact.setReward_ly(bpil_RewardOPAOutput.getRW_LY().intValue());
			aContact.setReward_target(bpil_RewardOPAOutput.getRW_TGT().intValue());
			aContact.setReward_ty(bpil_RewardOPAOutput.getRW_TY().intValue());
			aContact.setAdditional(bpil_RewardOPAOutput.getRW_ADDITIONAL().intValue());
			aContact.setBase_total(bpil_RewardOPAOutput.getRW_BASE_TOTAL().intValue());
			aContact.setReward_status(bpil_RewardOPAOutput.getRW_Q_STAT());
			aContact.setReward_description(bpil_RewardOPAOutput.getRW_DESC());
			aContact.setReward_total(bpil_RewardOPAOutput.getRW_TOTAL().intValue());
			aContact.setNext_tgt_pending(bpil_RewardOPAOutput.getRW_NXT_TGT().intValue());
			aContact.setGift_to_cn_flag(bpil_RewardOPAOutput.getRW_GFT_TO_CN());
			aContact.setConverted_cn_value(bpil_RewardOPAOutput.getRW_CONV_CN().intValue());
			aContact.setInterface_status(bpil_RewardOPAOutput.getRW_I_STAT());

			aContact.setReward_last_update(bpil_RewardOPAOutput.getRW_LAST_UPDATE());

			if (bpil_RewardOPAOutput.getRW_LAST_UPDATE() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String dateStr1 = ser1.format(bpil_RewardOPAOutput.getRW_LAST_UPDATE());
				aContact.setReward_last_update1(dateStr1);
//					try {
////						System.out.println(ser1.parse(rs.getString("REWARD_LAST_UPDATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}
			}

			sch_Analysis_Rws.add(aContact);
//			hibernateTemplate.flush();
//			hibernateTemplate.clear();
//			hibernateTemplate.save(aContact);
			
			

		}

		String LastRefresh = "";

		if (sch_Analysis_Rws.size() > 0) {

			if (sch_Analysis_Rws.get(0).getReward_last_update() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String dateStr1 = ser1.format(sch_Analysis_Rws.get(0).getReward_last_update());
//					try {
////						System.out.println(ser1.parse(rs.getString("REWARD_LAST_UPDATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}

				LastRefresh = dateStr1;
			}

		}
		if (schnm != null && schnm != "") {
			int scheme_id = Integer.parseInt(schnm_nw);

			ArrayList<New_Scheme_mstr> data = (ArrayList<New_Scheme_mstr>) hibernateTemplate
					.find("from New_Scheme_mstr where scheme_id=" + scheme_id);
			String name = data.get(0).getScheme_name();

			ArrayList<Bpil_Scheme_Doc> doc_line = schememasterdao.docautofill(scheme_id);
			System.out.println("doc_line " + doc_line.size());

			model.addAttribute("doc_list", doc_line);

			model.addAttribute("Info_grid", sch_Analysis_Rws);

			model.addAttribute("LastRefresh", LastRefresh);

			model.addAttribute("schnm", name);
		}
		model.addAttribute("depo_code", depot_nw);
		model.addAttribute("scheme_id", schnm_nw);

		return new ModelAndView("SchemeAnalysisRest");
		/*
		 * try { URL url = new URL(schopawebserviceUrl);
		 * 
		 * HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 * 
		 * conn.setDoOutput(true); conn.setRequestMethod("POST");
		 * conn.setRequestProperty("Content-Type", "application/json");
		 * conn.setRequestProperty("Authorization", oAuth2_token);
		 * 
		 * String JSON_REQ =
		 * createDlrSchRestRequestJSONWriter(dealerOPAInput,productOPAInput, schnm,
		 * depot, bill_to_id, request);
		 * 
		 * OutputStream os = conn.getOutputStream(); os.write(JSON_REQ.getBytes());
		 * os.flush();
		 * 
		 * if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) { throw new
		 * RuntimeException("Failed : HTTP error code : " + conn.getResponseCode()); }
		 * 
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(conn.getInputStream()));
		 * 
		 * String JSON_RESP; System.out.println("Output from Server .... \n"); while
		 * ((JSON_RESP = br.readLine()) != null) { System.out.println(JSON_RESP);
		 * 
		 * RewardOPAOutput = printDlrSchRestResponseJSONReader(JSON_REQ,
		 * JSON_RESP,dealerOPAInput,productOPAInput, schnm, depot, bill_to_id, request);
		 * }
		 * 
		 * conn.disconnect();
		 * 
		 * 
		 * } catch (MalformedURLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (ParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}
	
	@Transactional
	@RequestMapping(value = "/callschoparest_webservice1_new_depo")
	public ModelAndView callschoparest_webservice1_new_depo(Model model, @RequestParam(value = "scheme_id") String schnm,
			@RequestParam(value = "depot") String depot, @RequestParam(value = "bill_to_id") String bill_to_id,
			HttpServletRequest request) {
		
		
		ArrayList<New_Scheme_mstr> dml_nw = (ArrayList<New_Scheme_mstr>) hibernateTemplate
				.find("from New_Scheme_mstr where scheme_id = '"+schnm+"'");
		
		Date Edd = new Date();
		
		String schnm_nw=schnm;
		String depot_nw=depot;
		String bill_to_id_nw=bill_to_id;
		
		//code change 26 sept 2023 after demo delete it 
		
		schnm="1734";
		depot="021";
		bill_to_id="";
				
				
		
		
		//end of code change 
		
		
		System.out.println("inside callschoparest_webservice1---------with parameter values--scheme id----"+schnm_nw+"-- depot -"+depot+"_  bill to id ___"+bill_to_id+"_________");
		System.out.println("1   " + schnm);
		System.out.println("2   " + depot);
		System.out.println("3   " + bill_to_id);
		// TODO Auto-generated method stub
		///// -12-06-21-///////////
		List<String> dealer_name = new ArrayList<>();
		if (bill_to_id == "") {
			System.out.println("bill_to_id is empty");

			List<Bpil_Opa_Rw_Analysis_Rw> dml = new ArrayList<Bpil_Opa_Rw_Analysis_Rw>();
			CallableStatement cStmts;
			try {
				cStmts = hibernateConfiguration.dataSource().getConnection()
						.prepareCall("{call BPIL_GET_OPA_SCH_DLR(?,?,?)}");
				cStmts.setInt(1, Integer.parseInt(schnm));
				cStmts.setString(2, depot);
				cStmts.registerOutParameter(3, OracleTypes.CURSOR);
				ResultSet result = cStmts.executeQuery();
				ResultSet rs1 = (ResultSet) cStmts.getObject(3);
				while (rs1.next()) {
					Bpil_Opa_Rw_Analysis_Rw aContact = new Bpil_Opa_Rw_Analysis_Rw();
					System.out.println(rs1.getString("OPA_RW_AN_DEALER_ID"));
					System.out.println(rs1.getString("DLR_AC_NAME"));
					System.out.println(rs1.getString("DLR_AC_NO"));
					System.out.println(rs1.getInt("DLR_BILL_TO"));
					aContact.setOpa_rw_an_dealer_id(rs1.getString("OPA_RW_AN_DEALER_ID"));
					aContact.setDlr_ac_no(rs1.getString("DLR_AC_NO"));
					aContact.setDlr_name(rs1.getString("DLR_AC_NAME"));
					aContact.setDlr_bill_to(rs1.getInt("DLR_BILL_TO"));

					dml.add(aContact);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(dml.toString());
			Iterator<Bpil_Opa_Rw_Analysis_Rw> itr = dml.iterator();
			while (itr.hasNext()) {
				Bpil_Opa_Rw_Analysis_Rw br = itr.next();
				dealer_name.add(String.valueOf(br.getDlr_bill_to()));
			}

			System.out.println("list of dealer_name" + dealer_name.toString());
		} else {
			dealer_name = Arrays.asList(bill_to_id.split(","));
			System.out.println("list " + dealer_name.toString());
		}

		ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
				.find("from New_Scheme_mstr where scheme_id = '" + schnm + "'");
		System.out.println("Size of scheme master array is : " + dml.size());
		System.out.println("Scheme policy name is :- " + dml.get(0).getSch_dir_name());
		String schopawebserviceUrl = "";
		if (dml != null && dml.size() > 0) {
			String opa_sch_policy_name = dml.get(0).getSch_dir_name();
			System.out.println("Scheme policy name is :- " + opa_sch_policy_name);
			if (opa_sch_policy_name != null && !opa_sch_policy_name.equals("")) {

//				schopawebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/12.2.7/policy-models/"
//						+ opa_sch_policy_name + "/assessor";
				
				
				System.out.println("newwww policy name is :- with schme id "+schnm_nw);
			
				
				
				ArrayList<OiaData> dml_nww = (ArrayList<OiaData>) hibernateTemplate
						.find("from OiaData where scheme_code = '"+schnm_nw+"'");
				
				schopawebserviceUrl=dml_nww.get(0).getOpa_url();
				//schopawebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/12.2.7/policy-models/BPIL_SCH_ML7_1734/assessor";
				System.out.println("newwww policy name is : "+schopawebserviceUrl);
			}

		}
		System.out.println("Url is : = " + schopawebserviceUrl);
		String OAuth2_token = "";
		if (dealer_name.size() > 0) {

			String schopaauthwebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/auth?grant_type=client_credentials&client_id=apiuser1&client_secret=ApiUser$111";

			OAuth2_token = callauthoparest_webservice(schopaauthwebserviceUrl, request);

		}
		////////////// END////////////////

		// Start trial code
		List<Bpil_DealerOPAInput> dealerOPAInput = new ArrayList<Bpil_DealerOPAInput>();
		List<Bpil_ProductOPAInput> productOPAInput = new ArrayList<Bpil_ProductOPAInput>();
		// String schopaauthwebserviceUrl =
		// "https://iflictest2.custhelp.com/determinations-server/batch/auth?grant_type=client_credentials&client_id=apiuser1&client_secret=ApiUser$111";
		// String oAuth2_token = "";
		// oAuth2_token = callauthoparest_webservice(schopaauthwebserviceUrl, request);
		// End Trial code
		// Create Rest Connection

		List<Bpil_RewardOPAOutput> RewardSchOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

		for (String dealer_bill_to_id : dealer_name) {

			List<Bpil_DealerOPAInput> DealerOPAInput = new ArrayList<Bpil_DealerOPAInput>();
			List<Bpil_ProductOPAInput> ProductOPAInput = new ArrayList<Bpil_ProductOPAInput>();
			List<Bpil_RewardOPAOutput> RewardOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

			CallableStatement cStmt;
			try {
				cStmt = hibernateConfiguration.dataSource().getConnection()
						.prepareCall("{call BPIL_GET_OPA_DLR_INPUT(?,?,?,?,?)}");
				cStmt.setInt(1, Integer.parseInt(schnm));
				cStmt.setString(2, depot);
				cStmt.setInt(3, Integer.parseInt(dealer_bill_to_id));

				cStmt.registerOutParameter(4, OracleTypes.CURSOR);
				cStmt.registerOutParameter(5, OracleTypes.CURSOR);

				ResultSet result = cStmt.executeQuery();
				ResultSet rsdealers = (ResultSet) cStmt.getObject(4);
				ResultSet rsproducts = (ResultSet) cStmt.getObject(5);

				while (rsdealers.next()) {
					Bpil_DealerOPAInput bpil_DealerOPAInput = new Bpil_DealerOPAInput();

					bpil_DealerOPAInput.setDLR_SCH_ID(rsdealers.getInt("SCHEME_ID"));
					bpil_DealerOPAInput.setDLR_FIN_AN_FLAG(rsdealers.getString("FIN_AN_FLAG"));
					bpil_DealerOPAInput.setDLR_REGN(rsdealers.getString("DLR_REGN"));
					bpil_DealerOPAInput.setDLR_DEPOT(rsdealers.getString("DLR_DEPOT"));
					bpil_DealerOPAInput.setDLR_STATE(rsdealers.getString("DLR_STATE"));
					bpil_DealerOPAInput.setDLR_TERR_CODE(rsdealers.getString("DLR_TERR_CODE"));
					bpil_DealerOPAInput.setDLR_TERR_NAME(rsdealers.getString("DLR_TERR_NAME"));
					bpil_DealerOPAInput.setDLR_BILL_TO(rsdealers.getInt("DLR_BILL_TO"));
					bpil_DealerOPAInput.setDLR_AC_NO(rsdealers.getString("DLR_AC_NO"));
					bpil_DealerOPAInput.setDLR_AC_NAME(rsdealers.getString("DLR_AC_NAME"));
					bpil_DealerOPAInput.setDLR_CAT(rsdealers.getString("DLR_CAT"));
					bpil_DealerOPAInput.setDLR_TYPE(rsdealers.getString("DLR_TYPE"));
					bpil_DealerOPAInput.setDLR_RET(rsdealers.getString("DLR_RET"));
					bpil_DealerOPAInput.setDLR_SDLR_COUNT(rsdealers.getInt("DLR_SDLR_COUNT"));

					DealerOPAInput.add(bpil_DealerOPAInput);
				}

				while (rsproducts.next()) {
					Bpil_ProductOPAInput bpil_ProductOPAInput = new Bpil_ProductOPAInput();

					bpil_ProductOPAInput.setPRD_SCH_ID(rsproducts.getInt("PRD_SCH_ID"));
					bpil_ProductOPAInput.setPRD_BILL_TO(rsproducts.getInt("PRD_BILL_TO"));
					bpil_ProductOPAInput.setPRD_DLR_AC_NO(rsproducts.getString("PRD_DLR_AC_NO"));
					bpil_ProductOPAInput.setPRD_DLR_TYPE(rsproducts.getString("PRD_DLR_TYPE"));
					bpil_ProductOPAInput.setPRD_NAME(rsproducts.getString("PRD_NAME"));
					bpil_ProductOPAInput.setPRD_CAT(rsproducts.getString("PRD_CAT"));
					bpil_ProductOPAInput.setPRD_CAT_DESC(rsproducts.getString("PRD_CAT_DESC"));
					bpil_ProductOPAInput.setPRD_GRP(rsproducts.getString("PRD_GRP"));
					bpil_ProductOPAInput.setPRD_CODE(rsproducts.getString("PRD_CODE"));
					bpil_ProductOPAInput.setPRD_SHD_CODE(rsproducts.getString("PRD_SHD_CODE"));
					bpil_ProductOPAInput.setPRD_INV_DT(rsproducts.getDate("PRD_INV_DT"));
					bpil_ProductOPAInput.setPRD_UOM(rsproducts.getString("PRD_UOM"));
					bpil_ProductOPAInput.setPRD_PCK_SIZE(rsproducts.getBigDecimal("PRD_PCK_SIZE"));
					bpil_ProductOPAInput.setPRD_VOL(rsproducts.getBigDecimal("PRD_VOL"));
					bpil_ProductOPAInput.setPRD_FNL_VOL(rsproducts.getBigDecimal("PRD_FNL_VOL"));
					bpil_ProductOPAInput.setPRD_VAL(rsproducts.getBigDecimal("PRD_VAL"));
					bpil_ProductOPAInput.setPRD_VOL_RW(rsproducts.getBigDecimal("PRD_VOL_RW"));
					bpil_ProductOPAInput.setPRD_FNL_VOL_RW(rsproducts.getBigDecimal("PRD_FNL_VOL_RW"));
					bpil_ProductOPAInput.setPRD_VAL_RW(rsproducts.getBigDecimal("PRD_VAL_RW"));

					ProductOPAInput.add(bpil_ProductOPAInput);
				}

				System.out.println("Dealers size = " + DealerOPAInput.size() + " Products = " + ProductOPAInput.size());

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			Date Sd = new Date();
			System.out.println("Start call to webservice" + Sd);
			System.out.println("sch opa rest url is : = " + schopawebserviceUrl);
			RewardOPAOutput = callschoparest_webservice(DealerOPAInput, ProductOPAInput, schnm, depot,
					dealer_bill_to_id, schopawebserviceUrl, OAuth2_token, request);

			Date Ed = new Date();
			System.out.println("End call to webservice" + Ed);

			System.out.println("Total time : Sw " + Sd + " Ew " + Ed);

			RewardSchOPAOutput.addAll(RewardOPAOutput);

		}
		System.out.println("Total size of  RewardSchOPAOutput: " + RewardSchOPAOutput.size());
		List<Bpil_Opa_Sch_Analysis_Rw> sch_Analysis_Rws = new ArrayList<Bpil_Opa_Sch_Analysis_Rw>();
		
	

		for (Bpil_RewardOPAOutput bpil_RewardOPAOutput : RewardSchOPAOutput) {

			Bpil_Opa_Sch_Analysis_Rw aContact = new Bpil_Opa_Sch_Analysis_Rw();

			aContact.setScheme_id(bpil_RewardOPAOutput.getRW_SCH_ID());
			aContact.setRegn(bpil_RewardOPAOutput.getRW_DLR_REGN());
			aContact.setState(bpil_RewardOPAOutput.getRW_DLR_STATE());
			aContact.setDepot(bpil_RewardOPAOutput.getRW_DLR_DEPOT());
			aContact.setTerr_code(bpil_RewardOPAOutput.getRW_DLR_TERR_CODE());
			aContact.setTerr_name(bpil_RewardOPAOutput.getRW_DLR_TERR_NAME());
			aContact.setDlr_ac_no(bpil_RewardOPAOutput.getRW_DLR_CODE());
			aContact.setDlr_cat(bpil_RewardOPAOutput.getRW_DLR_CAT());
			aContact.setDlr_bill_to(bpil_RewardOPAOutput.getRW_DLR_BILL_TO());
			aContact.setDlr_type(bpil_RewardOPAOutput.getRW_DLR_TYPE());
			aContact.setDlr_name(bpil_RewardOPAOutput.getRW_DLR_NAME());
			aContact.setReward_section(bpil_RewardOPAOutput.getRW_SEC());
			aContact.setReward_type(bpil_RewardOPAOutput.getRW_TYPE());
			aContact.setProduct(bpil_RewardOPAOutput.getRW_PRD());
			aContact.setUnit(bpil_RewardOPAOutput.getRW_UNIT());
			//aContact.setReward_date(bpil_RewardOPAOutput.getRW_DATE());
			aContact.setReward_date(dml_nw.get(0).getEnd_date());

			if (bpil_RewardOPAOutput.getRW_DATE() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
				String dateStr1 = ser1.format(dml_nw.get(0).getEnd_date());
				aContact.setReward_date1(dateStr1);
//					try {
//						System.out.println(ser1.parse(rs.getString("REWARD_DATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}
			}

			aContact.setReward_ly(bpil_RewardOPAOutput.getRW_LY().intValue());
			aContact.setReward_target(bpil_RewardOPAOutput.getRW_TGT().intValue());
			aContact.setReward_ty(bpil_RewardOPAOutput.getRW_TY().intValue());
			aContact.setAdditional(bpil_RewardOPAOutput.getRW_ADDITIONAL().intValue());
			aContact.setBase_total(bpil_RewardOPAOutput.getRW_BASE_TOTAL().intValue());
			aContact.setReward_status(bpil_RewardOPAOutput.getRW_Q_STAT());
			aContact.setReward_description(bpil_RewardOPAOutput.getRW_DESC());
			aContact.setReward_total(bpil_RewardOPAOutput.getRW_TOTAL().intValue());
			aContact.setNext_tgt_pending(bpil_RewardOPAOutput.getRW_NXT_TGT().intValue());
			aContact.setGift_to_cn_flag(bpil_RewardOPAOutput.getRW_GFT_TO_CN());
			aContact.setConverted_cn_value(bpil_RewardOPAOutput.getRW_CONV_CN().intValue());
			aContact.setInterface_status(bpil_RewardOPAOutput.getRW_I_STAT());

			aContact.setReward_last_update(bpil_RewardOPAOutput.getRW_LAST_UPDATE());

			if (bpil_RewardOPAOutput.getRW_LAST_UPDATE() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String dateStr1 = ser1.format(bpil_RewardOPAOutput.getRW_LAST_UPDATE());
				aContact.setReward_last_update1(dateStr1);
//					try {
////						System.out.println(ser1.parse(rs.getString("REWARD_LAST_UPDATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}
			}

			sch_Analysis_Rws.add(aContact);
			//hibernateTemplate.flush();
			//hibernateTemplate.clear();
			//hibernateTemplate.save(aContact);
			
			

		}

		String LastRefresh = "";

		if (sch_Analysis_Rws.size() > 0) {

			if (sch_Analysis_Rws.get(0).getReward_last_update() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String dateStr1 = ser1.format(sch_Analysis_Rws.get(0).getReward_last_update());
//					try {
////						System.out.println(ser1.parse(rs.getString("REWARD_LAST_UPDATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}

				LastRefresh = dateStr1;
			}

		}
		if (schnm != null && schnm != "") {
			int scheme_id = Integer.parseInt(schnm_nw);

			ArrayList<New_Scheme_mstr> data = (ArrayList<New_Scheme_mstr>) hibernateTemplate
					.find("from New_Scheme_mstr where scheme_id=" + scheme_id);
			String name = data.get(0).getScheme_name();

			ArrayList<Bpil_Scheme_Doc> doc_line = schememasterdao.docautofill(scheme_id);
			System.out.println("doc_line " + doc_line.size());

			model.addAttribute("doc_list", doc_line);

			model.addAttribute("Info_grid", sch_Analysis_Rws);

			model.addAttribute("LastRefresh", LastRefresh);

			model.addAttribute("schnm", name);
		}
		model.addAttribute("deptnm", depot_nw);
		model.addAttribute("scheme_id", schnm_nw);

		return new ModelAndView("depoSchemeAnalysis");
		/*
		 * try { URL url = new URL(schopawebserviceUrl);
		 * 
		 * HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 * 
		 * conn.setDoOutput(true); conn.setRequestMethod("POST");
		 * conn.setRequestProperty("Content-Type", "application/json");
		 * conn.setRequestProperty("Authorization", oAuth2_token);
		 * 
		 * String JSON_REQ =
		 * createDlrSchRestRequestJSONWriter(dealerOPAInput,productOPAInput, schnm,
		 * depot, bill_to_id, request);
		 * 
		 * OutputStream os = conn.getOutputStream(); os.write(JSON_REQ.getBytes());
		 * os.flush();
		 * 
		 * if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) { throw new
		 * RuntimeException("Failed : HTTP error code : " + conn.getResponseCode()); }
		 * 
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(conn.getInputStream()));
		 * 
		 * String JSON_RESP; System.out.println("Output from Server .... \n"); while
		 * ((JSON_RESP = br.readLine()) != null) { System.out.println(JSON_RESP);
		 * 
		 * RewardOPAOutput = printDlrSchRestResponseJSONReader(JSON_REQ,
		 * JSON_RESP,dealerOPAInput,productOPAInput, schnm, depot, bill_to_id, request);
		 * }
		 * 
		 * conn.disconnect();
		 * 
		 * 
		 * } catch (MalformedURLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (ParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}
	
	
	@Transactional
	@RequestMapping(value = "/callschoparest_webservice1_new_dealer")
	public ModelAndView callschoparest_webservice1_new_dealer(Model model, @RequestParam(value = "scheme_id") String schnm,
			@RequestParam(value = "depot") String depot, @RequestParam(value = "bill_to_id") String bill_to_id,
			HttpServletRequest request) {
		
		int scheme_id=Integer.parseInt(schnm);
		scheme_id=1734;
		
	
		String userid=(String)request.getSession().getAttribute("kwm_user");
		int uid=Integer.parseInt(userid);
		
		
		List<Bpil_Opa_Sch_Analysis_Rw> sch_Analysis_Rws = new ArrayList<Bpil_Opa_Sch_Analysis_Rw>();
		
		ArrayList<Bpil_Opa_Sch_Analysis_Rw> output_data = (ArrayList<Bpil_Opa_Sch_Analysis_Rw>) hibernateTemplate
				.find("from Bpil_Opa_Sch_Analysis_Rw where scheme_id=" + scheme_id+" and dlr_ac_no="+uid+"");
		

		System.out.println("The dealer output is __"+output_data.toString());
		String LastRefresh = "";

		if (sch_Analysis_Rws.size() > 0) {

			if (sch_Analysis_Rws.get(0).getReward_last_update() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String dateStr1 = ser1.format(sch_Analysis_Rws.get(0).getReward_last_update());


				LastRefresh = dateStr1;
			}

		}
		if (schnm != null && schnm != "") {
			//int scheme_id = Integer.parseInt(schnm_nw);

			ArrayList<New_Scheme_mstr> data = (ArrayList<New_Scheme_mstr>) hibernateTemplate
					.find("from New_Scheme_mstr where scheme_id=" + scheme_id);
			String name = data.get(0).getScheme_name();

			ArrayList<Bpil_Scheme_Doc> doc_line = schememasterdao.docautofill(scheme_id);
			System.out.println("doc_line " + doc_line.size());

			model.addAttribute("doc_list", doc_line);

			model.addAttribute("Info_grid", output_data);

			model.addAttribute("LastRefresh", LastRefresh);

			model.addAttribute("schnm", name);
		}
		//model.addAttribute("deptnm", depot_nw);
		model.addAttribute("scheme_id", scheme_id);

		return new ModelAndView("dealerschemeanalysisreport");


	}




	//// --12-06-2021--
	//// ///////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/callschoparest_webservice2")
	public List<Bpil_RewardOPAOutput> callschoparest_webservice2(@RequestParam(value = "scheme_id") String schnm,
			@RequestParam(value = "depot") String depot, @RequestParam(value = "bill_to_id") String dealer_bill_to_id,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		// Start trial code
		List<Bpil_Dealers_Rest> dealerOPAInput = (List<Bpil_Dealers_Rest>) hibernateTemplate
				.find("from  Bpil_Dealers_Rest where SCHEME_ID = '" + schnm + "'");
		List<Bpil_Products_Rest> productOPAInput = (List<Bpil_Products_Rest>) hibernateTemplate
				.find("from  Bpil_Products_Rest where SCHEME_ID = '" + schnm + "'");
		String schopaauthwebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/auth?grant_type=client_credentials&client_id=apiuser1&client_secret=ApiUser$111";
		String oAuth2_token = "";
		oAuth2_token = callauthoparest_webservice(schopaauthwebserviceUrl, request);
		// End Trial code
		// Create Rest Connection

		ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
				.find("from New_Scheme_mstr where scheme_id = '" + schnm + "'");
		System.out.println("Size of scheme master array is : " + dml.size());
		System.out.println("Scheme policy name is :- " + dml.get(0).getSch_dir_name());
		String schopawebserviceUrl = "";
		if (dml != null && dml.size() > 0) {
			String opa_sch_policy_name = dml.get(0).getSch_dir_name();
			// String opa_sch_policy_name = dml.get(0).getOpa_sch_an_name();
			System.out.println("Scheme policy name is :- " + opa_sch_policy_name);
			if (opa_sch_policy_name != null && !opa_sch_policy_name.equals("")) {

				schopawebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/12.2.7/policy-models/"
						+ opa_sch_policy_name + "/assessor";
			}

		}
		System.out.println("Url is : = " + schopawebserviceUrl);
		List<Bpil_RewardOPAOutput> RewardOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

		try {
			URL url = new URL(schopawebserviceUrl);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", oAuth2_token);

			String JSON_REQ = createDlrSchRestRequestJSONWriter2(dealerOPAInput, productOPAInput, schnm, depot,
					dealer_bill_to_id, request);

			OutputStream os = conn.getOutputStream();
			os.write(JSON_REQ.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String JSON_RESP;
			System.out.println("Output from Server .... \n");
			while ((JSON_RESP = br.readLine()) != null) {
				System.out.println(JSON_RESP);

				RewardOPAOutput = printDlrSchRestResponseJSONReader2(JSON_REQ, JSON_RESP, dealerOPAInput,
						productOPAInput, schnm, depot, dealer_bill_to_id, request);
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return RewardOPAOutput;
	}

	private String createDlrSchRestRequestJSONWriter2(List<Bpil_Dealers_Rest> dealerOPAInput,
			List<Bpil_Products_Rest> productOPAInput, String schnm, String depot, String dealer_bill_to_id,
			HttpServletRequest request) throws IOException {
		// TODO Auto-generated method stub
		JsonObjectBuilder JsonReqBuilder = Json.createObjectBuilder();
		JsonArrayBuilder outcomesBuilder = Json.createArrayBuilder();
		JsonArrayBuilder casesBuilder = Json.createArrayBuilder();
		List<String> outcomes = new ArrayList<String>();
		String[] Stroutcome = new String[] { "DLR_TOT_CN", "DLR_TOT_BDGT", "RW_SCH_ID", "RW_CODE", "RW_DLR_REGN",
				"RW_DLR_DEPOT", "RW_DLR_STATE", "RW_DLR_TERR_CODE", "RW_DLR_TERR_NAME", "RW_DLR_CODE", "RW_DLR_CAT",
				"RW_DLR_BILL_TO", "RW_DLR_TYPE", "RW_DLR_NAME", "RW_SEC", "RW_TYPE", "RW_PRD", "RW_UNIT", "RW_DATE",
				"RW_LY", "RW_TGT", "RW_TY", "RW_ADDITIONAL", "RW_BASE_TOTAL", "RW_Q_STAT", "RW_DESC", "RW_TOTAL",
				"RW_NXT_TGT", "RW_GFT_TO_CN", "RW_GFT_ID", "RW_CONV_CN", "RW_I_STAT", "RW_LAST_UPDATE" };
		outcomes = Arrays.asList(Stroutcome);
		for (String outcome : outcomes) {
			outcomesBuilder.add(outcome);
		}

		JsonReqBuilder.add("outcomes", outcomesBuilder);

		int dealercaseid = 1;

		for (Bpil_Dealers_Rest dealer : dealerOPAInput) {
			JsonObjectBuilder dealerBuilder = Json.createObjectBuilder();
			JsonArrayBuilder productsBuilder = Json.createArrayBuilder();

			dealerBuilder.add("@id", dealercaseid);
			dealerBuilder.add("DLR_BILL_TO", dealer.getBILL_TO_ID());
			dealerBuilder.add("DEPOT", dealer.getDEPOT_NAME());
			/*
			 * if(dealer.getDLR_STATE() != null) { dealerBuilder.add("DLR_STATE",
			 * dealer.getDLR_STATE()); } else { dealerBuilder.add("DLR_STATE", ""); }
			 */
			dealerBuilder.add("REGN", dealer.getREGN());
			/*
			 * if(dealer.getDLR_TERR_NAME() != null) { dealerBuilder.add("TERR",
			 * dealer.getDLR_TERR_NAME()); } else { dealerBuilder.add("TERR", ""); }
			 */
			dealerBuilder.add("DLR_AC_NO", dealer.getDLR_AC_NO());
			dealerBuilder.add("DLR_AC_NAME", dealer.getDLR_AC_NAME());
			dealerBuilder.add("DLR_CAT", dealer.getDLR_CAT());
			dealerBuilder.add("DLR_TYPE", dealer.getCUST_TYPE());
			// dealerBuilder.add("DLR_RET", dealer.getDLR_RET());
			// dealerBuilder.add("DLR_SDLR_COUNT", dealer.getDLR_SDLR_COUNT());

			int productid = 1;
			for (Bpil_Products_Rest product : productOPAInput) {
				JsonObjectBuilder productBuilder = Json.createObjectBuilder();

				productBuilder.add("@id", productid);
				productBuilder.add("PRD", Integer.toString(productid));
				productBuilder.add("PRD_BILL_TO", product.getBILL_TO_ID());
				// productBuilder.add("PRD_DLR_AC_NO", product.getPRD_DLR_AC_NO());
				// productBuilder.add("PRD_DLR_TYPE", product.getPRD_DLR_TYPE());
				// productBuilder.add("PRD_NAME", product.getPRD_NAME());
				productBuilder.add("PRD_CAT", product.getPRD_CAT());
				// productBuilder.add("PRD_CAT_DESC", product.getPRD_CAT_DESC());
				// productBuilder.add("PRD_GRP", product.getPRD_GRP());
				productBuilder.add("PRD_CODE", product.getPRD_CODE());
				productBuilder.add("PRD_SHD_CODE", product.getSHD_CODE());
				productBuilder.add("PRD_INV_DT", new SimpleDateFormat("yyyy-MM-dd").format(product.getSLS_TRX_DATE()));
				productBuilder.add("PRD_UOM", product.getPRD_UOM());
				productBuilder.add("PRD_PCK_SIZE", product.getPACK_SIZE());
				productBuilder.add("PRD_VOL", product.getSLS_VOL());
				productBuilder.add("PRD_FNL_VOL", product.getSLS_FNL_VOL());
				productBuilder.add("PRD_VAL", product.getSLS_VAL());
				productBuilder.add("PRD_VOL_RW", product.getSLS_VOL_RW());
				productBuilder.add("PRD_FNL_VOL_RW", product.getSLS_FNL_VOL_RW());
				productBuilder.add("PRD_VAL_RW", product.getSLS_VAL_RW());
				productsBuilder.add(productBuilder);

				productid++;

			}

			dealerBuilder.add("products", productsBuilder);

			casesBuilder.add(dealerBuilder);

			dealercaseid++;
		}

		JsonReqBuilder.add("cases", casesBuilder);

		JsonObject JsonREQObject = JsonReqBuilder.build();

		System.out.println("JsonREQObject JSON String\n" + JsonREQObject);

		StringWriter strWtr = new StringWriter();
		JsonWriter jsonWtr = Json.createWriter(strWtr);
		jsonWtr.writeObject(JsonREQObject);
		String JSON_REQ = strWtr.toString();
		jsonWtr.close();
		strWtr.close();

		String reqxmlpath = request.getServletContext().getRealPath("/WEB-INF/classes/com/report");

		System.out.println("xmlpath = " + reqxmlpath);

		// write to file
		OutputStream os = new FileOutputStream(reqxmlpath + "/jsonrequest.json");
		JsonWriter jsonWriter = Json.createWriter(os);
		jsonWriter.writeObject(JsonREQObject);
		jsonWriter.close();
		os.close();

		System.out.println(JSON_REQ);
		return JSON_REQ;

	}

	private List<Bpil_RewardOPAOutput> printDlrSchRestResponseJSONReader2(String JSON_REQ, String JSON_RESP,
			List<Bpil_Dealers_Rest> dealerOPAInput, List<Bpil_Products_Rest> productOPAInput, String schnm,
			String depot, String dealer_bill_to_id, HttpServletRequest request) throws IOException, ParseException {
		// TODO Auto-generated method stub

		List<Bpil_RewardOPAOutput> RewardOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

		StringReader strReqRdr = new StringReader(JSON_REQ);

		// create JsonReader object
		JsonReader jsonReqReader = Json.createReader(strReqRdr);

		// get JsonObject from JsonReader
		JsonObject JsonREQObject = jsonReqReader.readObject();

		// we can close IO resource and JsonReader now
		jsonReqReader.close();
		strReqRdr.close();

		System.out.println("JsonREQObject JSON String\n" + JsonREQObject);

		String reqxmlpath = request.getServletContext().getRealPath("/WEB-INF/classes/com/report");

		System.out.println("xmlpath = " + reqxmlpath);

		// write to file
		OutputStream reqos = new FileOutputStream(reqxmlpath + "/jsonrequest.json");
		JsonWriter jsonReqWriter = Json.createWriter(reqos);
		jsonReqWriter.writeObject(JsonREQObject);
		jsonReqWriter.close();
		reqos.close();

		System.out.println(JSON_REQ);

		StringReader strRespRdr = new StringReader(JSON_RESP);

		// create JsonReader object
		JsonReader jsonRespReader = Json.createReader(strRespRdr);

		// get JsonObject from JsonReader
		JsonObject JsonRESPObject = jsonRespReader.readObject();

		// we can close IO resource and JsonReader now
		jsonRespReader.close();
		strRespRdr.close();

		System.out.println("JsonRESPObject JSON String\n" + JsonRESPObject);

		// write to file
		OutputStream respos = new FileOutputStream(reqxmlpath + "/jsonresponse.json");
		JsonWriter jsonRespWriter = Json.createWriter(respos);
		jsonRespWriter.writeObject(JsonRESPObject);
		jsonRespWriter.close();
		respos.close();

		System.out.println(JSON_RESP);

		JsonArray cases = JsonRESPObject.getJsonArray("cases");
		List<Bpil_DealerOPAInput> DealerOPAInput = new ArrayList<Bpil_DealerOPAInput>(cases.size());
		for (JsonValue dlr_value : cases) {
			Bpil_DealerOPAInput dealer = new Bpil_DealerOPAInput();
			DealerOPAInput.add(dealer);

			System.out.println(dlr_value.toString());
			JsonObject DLR_object = (JsonObject) dlr_value;

			/*
			 * dealer.setID(DLR_object.getInt("@id"));
			 * System.out.println(DLR_object.getInt("@id"));
			 * dealer.setDLR_TOT_CN(DLR_object.getJsonNumber("DLR_TOT_CN").bigDecimalValue()
			 * ); System.out.println(DLR_object.getJsonNumber("DLR_TOT_CN"));
			 * dealer.setDLR_TOT_BDGT(DLR_object.getJsonNumber("DLR_TOT_BDGT").
			 * bigDecimalValue());
			 * System.out.println(DLR_object.getJsonNumber("DLR_TOT_BDGT"));
			 */

			JsonArray rewards = DLR_object.getJsonArray("rewards");
			RewardOPAOutput = new ArrayList<Bpil_RewardOPAOutput>(rewards.size());
			for (JsonValue rw_value : rewards) {
				Bpil_RewardOPAOutput bsat_RW = new Bpil_RewardOPAOutput();
				RewardOPAOutput.add(bsat_RW);

				System.out.println(rw_value.toString());
				JsonObject RW_object = (JsonObject) rw_value;

				bsat_RW.setID(RW_object.getInt("@id"));
				System.out.println(RW_object.getInt("@id"));
				bsat_RW.setRW_SCH_ID(RW_object.getInt("RW_SCH_ID"));
				System.out.println(RW_object.getInt("RW_SCH_ID"));
				bsat_RW.setRW_CODE(RW_object.getString("RW_CODE"));
				System.out.println(RW_object.getString("RW_CODE"));
				bsat_RW.setRW_DLR_REGN(RW_object.getString("RW_DLR_REGN"));
				System.out.println(RW_object.getString("RW_DLR_REGN"));
				bsat_RW.setRW_DLR_DEPOT(RW_object.getString("RW_DLR_DEPOT"));
				System.out.println(RW_object.getString("RW_DLR_DEPOT"));
				bsat_RW.setRW_DLR_STATE(RW_object.getString("RW_DLR_STATE"));
				System.out.println(RW_object.getString("RW_DLR_STATE"));
				bsat_RW.setRW_DLR_TERR_CODE(RW_object.getString("RW_DLR_TERR_CODE"));
				System.out.println(RW_object.getString("RW_DLR_TERR_CODE"));
				bsat_RW.setRW_DLR_TERR_NAME(RW_object.getString("RW_DLR_TERR_NAME"));
				System.out.println(RW_object.getString("RW_DLR_TERR_NAME"));
				bsat_RW.setRW_DLR_CODE(RW_object.getString("RW_DLR_CODE"));
				System.out.println(RW_object.getString("RW_DLR_CODE"));
				bsat_RW.setRW_DLR_CAT(RW_object.getString("RW_DLR_CAT"));
				System.out.println(RW_object.getString("RW_DLR_CAT"));
				bsat_RW.setRW_DLR_BILL_TO(RW_object.getInt("RW_DLR_BILL_TO"));
				System.out.println(RW_object.getInt("RW_DLR_BILL_TO"));
				bsat_RW.setRW_DLR_TYPE(RW_object.getString("RW_DLR_TYPE"));
				System.out.println(RW_object.getString("RW_DLR_TYPE"));
				bsat_RW.setRW_DLR_NAME(RW_object.getString("RW_DLR_NAME"));
				System.out.println(RW_object.getString("RW_DLR_NAME"));
				bsat_RW.setRW_SEC(RW_object.getString("RW_SEC"));
				System.out.println(RW_object.getString("RW_SEC"));
				bsat_RW.setRW_TYPE(RW_object.getString("RW_TYPE"));
				System.out.println(RW_object.getString("RW_TYPE"));
				bsat_RW.setRW_PRD(RW_object.getString("RW_PRD"));
				System.out.println(RW_object.getString("RW_PRD"));
				bsat_RW.setRW_UNIT(RW_object.getString("RW_UNIT"));
				System.out.println(RW_object.getString("RW_UNIT"));
				bsat_RW.setRW_DATE(new SimpleDateFormat("yyyy-MM-dd").parse(RW_object.getString("RW_DATE")));
				System.out.println(RW_object.getString("RW_DATE"));
				bsat_RW.setRW_LY(RW_object.getJsonNumber("RW_LY").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_LY"));
				bsat_RW.setRW_TGT(RW_object.getJsonNumber("RW_TGT").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_TGT"));
				bsat_RW.setRW_TY(RW_object.getJsonNumber("RW_TY").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_TY"));
				bsat_RW.setRW_ADDITIONAL(RW_object.getJsonNumber("RW_ADDITIONAL").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_ADDITIONAL"));
				bsat_RW.setRW_BASE_TOTAL(RW_object.getJsonNumber("RW_BASE_TOTAL").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_BASE_TOTAL"));
				bsat_RW.setRW_Q_STAT(RW_object.getString("RW_Q_STAT"));
				System.out.println(RW_object.getString("RW_Q_STAT"));
				bsat_RW.setRW_DESC(RW_object.getString("RW_DESC"));
				System.out.println(RW_object.getString("RW_DESC"));
				bsat_RW.setRW_TOTAL(RW_object.getJsonNumber("RW_TOTAL").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_TOTAL"));
				bsat_RW.setRW_NXT_TGT(RW_object.getJsonNumber("RW_NXT_TGT").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_NXT_TGT"));
				bsat_RW.setRW_GFT_TO_CN(RW_object.getString("RW_GFT_TO_CN"));
				System.out.println(RW_object.getString("RW_GFT_TO_CN"));
				bsat_RW.setRW_GFT_ID(RW_object.getString("RW_GFT_ID"));
				System.out.println(RW_object.getString("RW_GFT_ID"));
				bsat_RW.setRW_CONV_CN(RW_object.getJsonNumber("RW_CONV_CN").bigDecimalValue());
				System.out.println(RW_object.getJsonNumber("RW_CONV_CN"));
				bsat_RW.setRW_I_STAT(RW_object.getString("RW_I_STAT"));
				System.out.println(RW_object.getString("RW_I_STAT"));
				bsat_RW.setRW_LAST_UPDATE(
						new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(RW_object.getString("RW_LAST_UPDATE")));
				System.out.println(RW_object.getString("RW_LAST_UPDATE"));

			}

		}

		return RewardOPAOutput;
	}

	@RequestMapping("/openEmailFor")
	public String openEmailForm(ModelMap map) {
		System.out.println("inside____________________________/openEmailForm");

		return "";
	}

	@RequestMapping("/resetpass")
	public ModelAndView resetpass(ModelMap map) {
		System.out.println("inside____________________________/resetpass");
	
		return new ModelAndView("resetpass");
	}

	@RequestMapping("/resetpassotp")
	public ModelAndView resetpassotp(ModelMap map) {
		System.out.println("inside____________________________/resetpassotp");

		return new ModelAndView("resetpassotp");
	}

	@RequestMapping("/sendotp")
	public ModelAndView sendotp(ModelMap map, @RequestParam(value = "email") String email, HttpServletRequest request,Model m) {
		
		
		System.out.println("inside____________________________/sendotp");
		HttpSession session = request.getSession();
		long unixTime = System.currentTimeMillis() / 1000L;
	    Date time=new java.util.Date((long)unixTime*1000);
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(time);
	    int hours = cal.get(Calendar.HOUR_OF_DAY);
	    int minutes = cal.get(Calendar.MINUTE);
	    int seconds = cal.get(Calendar.SECOND);
	    String currentTime = (hours+":"+minutes+":"+seconds);
	    
	   System.out.println("Test: "+currentTime );
	   int minutess = cal.get(Calendar.MINUTE);
	   String newTime = (hours+":"+minutes+":"+seconds);
	   System.out.println("New: "+minutess);
	   System.out.println("New: "+newTime);
       session.setAttribute("minutess", minutess);
		System.out.println(email);
		// generating otp of 6 digit
		String hql="select distinct email_address from Bpil_Users";
		ArrayList<Bpil_Users> users = (ArrayList<Bpil_Users>) hibernateTemplate.find(hql);		
		boolean b=users.contains(email);
		if(b==true)
		{
			
			System.out.println("present");
			Random r = new Random();
			int otp = r.nextInt(999999);
			session.setAttribute("OTP", otp);


			 
			System.out.println("OTP    " + otp);
			String subject = "Reset Password OTP From BSAT";
			String message = ""
					+"<div style='border:1px solid #e2e2e2;padding:20 px;'>"
					+"<h1>"
					+"OTP is : "
					+"<b>"+otp
					+"</n>"
					+"</h1>"
					+"</div>";
			String to = email;
			boolean flag = false;
			flag = this.emailService.sendEmail(subject, message, to);

			if (flag) {
				String s="success";
				map.addAttribute("success", s);
				 m.addAttribute("otpbsent",true);
				System.out.println("otpsent");
				session.setAttribute("oldotp", otp);
				session.setAttribute("email", to);
				
				return new ModelAndView("sendotp");
			}
			 

		}
		    m.addAttribute("otpbsent",false);
			System.out.println("emailabsent");
		
		return new ModelAndView("redirect:resetpassotp");


	}

	@RequestMapping("/verify_otp")
	public ModelAndView verify_otp(ModelMap map, @RequestParam("otp") int otp, HttpSession session,Model m) {
		System.out.println("inside____________________________/verify_otp");
		System.out.println("Entered OTP : " + otp);
	
		int oldotp = (int) session.getAttribute("oldotp");
		int oldmin=(int) session.getAttribute("minutess");
		System.out.println(oldmin+"---------------- old minute");
		long unixTime = System.currentTimeMillis() / 1000L;
	    Date time=new java.util.Date((long)unixTime*1000);
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(time);
	    int hours = cal.get(Calendar.HOUR_OF_DAY);
	    int minutes = cal.get(Calendar.MINUTE);
	    int seconds = cal.get(Calendar.SECOND);
	    String currentTime = (hours+":"+minutes+":"+seconds);
	    int diff=minutes-oldmin;
	    System.out.println(diff);
	   System.out.println("currentTime: "+currentTime );
	   

       
		
		
		   session.setAttribute("ctime",currentTime );
		System.out.println("Old OTP : " + oldotp);
		if(diff<=5)
		{
			if (otp == oldotp ) {
				System.out.println("otp matched---");
				m.addAttribute("OtpSucess",true);
				return new ModelAndView("redirect:resetpass");
			}
		}
		m.addAttribute("OtpFail",false);
		

		return new ModelAndView("sendotp");

	}

	@RequestMapping("/resetsubmit")
	public ModelAndView resetsubmit(HttpServletRequest request, ModelMap map,
			@RequestParam(value = "username") String username, @RequestParam(value = "newpassword") String newpassword,
			@RequestParam(value = "conpassword") String conpassword, Model m) {
		System.out.println("inside____________________________/resetsubmit");
		System.out.println(username + "   username");
		System.out.println(newpassword + "   newpassword");
		System.out.println(conpassword + "   conpassword");

		List<Bpil_Users> kwm_menu_groups = new ArrayList<Bpil_Users>();
		if (newpassword.equals(conpassword)) {

			if (newpassword != null) {
				Key key = null;
				Cipher cipher = null;
				try {
					key = generateKey();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					cipher = Cipher.getInstance(BpilRestController.ALGORITHM);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					cipher.init(Cipher.ENCRYPT_MODE, key);
				} catch (InvalidKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				byte[] encryptedByteValue = null;
				try {
					encryptedByteValue = cipher.doFinal(newpassword.getBytes("utf-8"));
				} catch (IllegalBlockSizeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				final String encryptedValue = new BASE64Encoder().encode(encryptedByteValue);

				System.out.println("encrypted pass" + encryptedValue);

				String query = "update BPIL_USERS set PASSWORD='" + encryptedValue + "'  WHERE USER_NAME='" + username
						+ "'";

				try {
					jdbctemplate.update(query);
					System.out.println("password changed successfully");
				} catch (Exception e) {
					System.out.println("exception ---------------");
					e.printStackTrace();
				}

			}
		}

		return new ModelAndView("redirect:logout");
	}

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(BpilRestController.KEY.getBytes(), BpilRestController.ALGORITHM);
		return key;
	}

	@RequestMapping(value = "/callschoparest_webservicee")
	public ModelAndView callschoparest_webservicee(Model model, @RequestParam(value = "scheme_id") String schnm,
			@RequestParam(value = "depot") String depot, @RequestParam(value = "bill_to_id") String bill_to_id,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		///// -12-06-21-///////////
		List<String> dealer_name = new ArrayList<>();
		if (bill_to_id == "") {

			List<Bpil_Opa_Rw_Analysis_Rw> dml = new ArrayList<Bpil_Opa_Rw_Analysis_Rw>();
			CallableStatement cStmts;
			try {
				cStmts = hibernateConfiguration.dataSource().getConnection()
						.prepareCall("{call BPIL_GET_OPA_SCH_DLR(?,?,?)}");
				cStmts.setInt(1, Integer.parseInt(schnm));
				cStmts.setString(2, depot);
				cStmts.registerOutParameter(3, OracleTypes.CURSOR);
				ResultSet result = cStmts.executeQuery();
				ResultSet rs1 = (ResultSet) cStmts.getObject(3);
				while (rs1.next()) {
					Bpil_Opa_Rw_Analysis_Rw aContact = new Bpil_Opa_Rw_Analysis_Rw();

					aContact.setOpa_rw_an_dealer_id(rs1.getString("OPA_RW_AN_DEALER_ID"));
					aContact.setDlr_ac_no(rs1.getString("DLR_AC_NO"));
					aContact.setDlr_name(rs1.getString("DLR_AC_NAME"));
					aContact.setDlr_bill_to(rs1.getInt("DLR_BILL_TO"));

					dml.add(aContact);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			Iterator<Bpil_Opa_Rw_Analysis_Rw> itr = dml.iterator();
			while (itr.hasNext()) {
				Bpil_Opa_Rw_Analysis_Rw br = itr.next();
				dealer_name.add(String.valueOf(br.getDlr_bill_to()));
			}

			System.out.println("list " + dealer_name.toString());
		} else {
			dealer_name = Arrays.asList(bill_to_id.split(","));
			System.out.println("list " + dealer_name.toString());
		}

		ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
				.find("from New_Scheme_mstr where scheme_id = '" + schnm + "'");
		System.out.println("Size of scheme master array is : " + dml.size());
		System.out.println("Scheme policy name is :- " + dml.get(0).getSch_dir_name());
		String schopawebserviceUrl = "";
		if (dml != null && dml.size() > 0) {
			String opa_sch_policy_name = dml.get(0).getSch_dir_name();
			System.out.println("Scheme policy name is :- " + opa_sch_policy_name);
			if (opa_sch_policy_name != null && !opa_sch_policy_name.equals("")) {

//				schopawebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/12.2.7/policy-models/"
//						+ opa_sch_policy_name + "/assessor";
				System.out.println("inside policy model new link");
				schopawebserviceUrl="https://iflictest2.custhelp.com/determinations-server/batch/12.2.7/policy-models/BPIL_SCH_ML7_1734/assessor";
			}

		}
		System.out.println("Url is : = " + schopawebserviceUrl);
		String OAuth2_token = "";
		if (dealer_name.size() > 0) {

			String schopaauthwebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/auth?grant_type=client_credentials&client_id=apiuser1&client_secret=ApiUser$111";

			OAuth2_token = callauthoparest_webservice(schopaauthwebserviceUrl, request);

		}
		////////////// END////////////////

		// Start trial code
		List<Bpil_DealerOPAInput> dealerOPAInput = new ArrayList<Bpil_DealerOPAInput>();
		List<Bpil_ProductOPAInput> productOPAInput = new ArrayList<Bpil_ProductOPAInput>();
		// String schopaauthwebserviceUrl =
		// "https://iflictest2.custhelp.com/determinations-server/batch/auth?grant_type=client_credentials&client_id=apiuser1&client_secret=ApiUser$111";
		// String oAuth2_token = "";
		// oAuth2_token = callauthoparest_webservice(schopaauthwebserviceUrl, request);
		// End Trial code
		// Create Rest Connection

		List<Bpil_RewardOPAOutput> RewardSchOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

		for (String dealer_bill_to_id : dealer_name) {

			List<Bpil_DealerOPAInput> DealerOPAInput = new ArrayList<Bpil_DealerOPAInput>();
			List<Bpil_ProductOPAInput> ProductOPAInput = new ArrayList<Bpil_ProductOPAInput>();
			List<Bpil_RewardOPAOutput> RewardOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

			CallableStatement cStmt;
			try {
				cStmt = hibernateConfiguration.dataSource().getConnection()
						.prepareCall("{call BPIL_GET_OPA_DLR_INPUT(?,?,?,?,?)}");
				cStmt.setInt(1, Integer.parseInt(schnm));
				cStmt.setString(2, depot);
				cStmt.setInt(3, Integer.parseInt(dealer_bill_to_id));

				cStmt.registerOutParameter(4, OracleTypes.CURSOR);
				cStmt.registerOutParameter(5, OracleTypes.CURSOR);

				ResultSet result = cStmt.executeQuery();
				ResultSet rsdealers = (ResultSet) cStmt.getObject(4);
				ResultSet rsproducts = (ResultSet) cStmt.getObject(5);

				while (rsdealers.next()) {
					Bpil_DealerOPAInput bpil_DealerOPAInput = new Bpil_DealerOPAInput();

					bpil_DealerOPAInput.setDLR_SCH_ID(rsdealers.getInt("SCHEME_ID"));
					bpil_DealerOPAInput.setDLR_FIN_AN_FLAG(rsdealers.getString("FIN_AN_FLAG"));
					bpil_DealerOPAInput.setDLR_REGN(rsdealers.getString("DLR_REGN"));
					bpil_DealerOPAInput.setDLR_DEPOT(rsdealers.getString("DLR_DEPOT"));
					bpil_DealerOPAInput.setDLR_STATE(rsdealers.getString("DLR_STATE"));
					bpil_DealerOPAInput.setDLR_TERR_CODE(rsdealers.getString("DLR_TERR_CODE"));
					bpil_DealerOPAInput.setDLR_TERR_NAME(rsdealers.getString("DLR_TERR_NAME"));
					bpil_DealerOPAInput.setDLR_BILL_TO(rsdealers.getInt("DLR_BILL_TO"));
					bpil_DealerOPAInput.setDLR_AC_NO(rsdealers.getString("DLR_AC_NO"));
					bpil_DealerOPAInput.setDLR_AC_NAME(rsdealers.getString("DLR_AC_NAME"));
					bpil_DealerOPAInput.setDLR_CAT(rsdealers.getString("DLR_CAT"));
					bpil_DealerOPAInput.setDLR_TYPE(rsdealers.getString("DLR_TYPE"));
					bpil_DealerOPAInput.setDLR_RET(rsdealers.getString("DLR_RET"));
					bpil_DealerOPAInput.setDLR_SDLR_COUNT(rsdealers.getInt("DLR_SDLR_COUNT"));

					DealerOPAInput.add(bpil_DealerOPAInput);
				}

				while (rsproducts.next()) {
					Bpil_ProductOPAInput bpil_ProductOPAInput = new Bpil_ProductOPAInput();

					bpil_ProductOPAInput.setPRD_SCH_ID(rsproducts.getInt("PRD_SCH_ID"));
					bpil_ProductOPAInput.setPRD_BILL_TO(rsproducts.getInt("PRD_BILL_TO"));
					bpil_ProductOPAInput.setPRD_DLR_AC_NO(rsproducts.getString("PRD_DLR_AC_NO"));
					bpil_ProductOPAInput.setPRD_DLR_TYPE(rsproducts.getString("PRD_DLR_TYPE"));
					bpil_ProductOPAInput.setPRD_NAME(rsproducts.getString("PRD_NAME"));
					bpil_ProductOPAInput.setPRD_CAT(rsproducts.getString("PRD_CAT"));
					bpil_ProductOPAInput.setPRD_CAT_DESC(rsproducts.getString("PRD_CAT_DESC"));
					bpil_ProductOPAInput.setPRD_GRP(rsproducts.getString("PRD_GRP"));
					bpil_ProductOPAInput.setPRD_CODE(rsproducts.getString("PRD_CODE"));
					bpil_ProductOPAInput.setPRD_SHD_CODE(rsproducts.getString("PRD_SHD_CODE"));
					bpil_ProductOPAInput.setPRD_INV_DT(rsproducts.getDate("PRD_INV_DT"));
					bpil_ProductOPAInput.setPRD_UOM(rsproducts.getString("PRD_UOM"));
					bpil_ProductOPAInput.setPRD_PCK_SIZE(rsproducts.getBigDecimal("PRD_PCK_SIZE"));
					bpil_ProductOPAInput.setPRD_VOL(rsproducts.getBigDecimal("PRD_VOL"));
					bpil_ProductOPAInput.setPRD_FNL_VOL(rsproducts.getBigDecimal("PRD_FNL_VOL"));
					bpil_ProductOPAInput.setPRD_VAL(rsproducts.getBigDecimal("PRD_VAL"));
					bpil_ProductOPAInput.setPRD_VOL_RW(rsproducts.getBigDecimal("PRD_VOL_RW"));
					bpil_ProductOPAInput.setPRD_FNL_VOL_RW(rsproducts.getBigDecimal("PRD_FNL_VOL_RW"));
					bpil_ProductOPAInput.setPRD_VAL_RW(rsproducts.getBigDecimal("PRD_VAL_RW"));

					ProductOPAInput.add(bpil_ProductOPAInput);
				}

				System.out.println("Dealers size = " + DealerOPAInput.size() + " Products = " + ProductOPAInput.size());

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			Date Sd = new Date();
			System.out.println("Start call to webservice" + Sd);
			System.out.println("sch opa rest url is : = " + schopawebserviceUrl);
			RewardOPAOutput = callschoparest_webservice(DealerOPAInput, ProductOPAInput, schnm, depot,
					dealer_bill_to_id, schopawebserviceUrl, OAuth2_token, request);

			Date Ed = new Date();
			System.out.println("End call to webservice" + Ed);

			System.out.println("Total time : Sw " + Sd + " Ew " + Ed);

			RewardSchOPAOutput.addAll(RewardOPAOutput);

		}
		System.out.println("Total size of  RewardSchOPAOutput: " + RewardSchOPAOutput.size());
		List<Bpil_Opa_Sch_Analysis_Rw> sch_Analysis_Rws = new ArrayList<Bpil_Opa_Sch_Analysis_Rw>();

		for (Bpil_RewardOPAOutput bpil_RewardOPAOutput : RewardSchOPAOutput) {

			Bpil_Opa_Sch_Analysis_Rw aContact = new Bpil_Opa_Sch_Analysis_Rw();

			aContact.setScheme_id(bpil_RewardOPAOutput.getRW_SCH_ID());
			aContact.setRegn(bpil_RewardOPAOutput.getRW_DLR_REGN());
			aContact.setState(bpil_RewardOPAOutput.getRW_DLR_STATE());
			aContact.setDepot(bpil_RewardOPAOutput.getRW_DLR_DEPOT());
			aContact.setTerr_code(bpil_RewardOPAOutput.getRW_DLR_TERR_CODE());
			aContact.setTerr_name(bpil_RewardOPAOutput.getRW_DLR_TERR_NAME());
			aContact.setDlr_ac_no(bpil_RewardOPAOutput.getRW_DLR_CODE());
			aContact.setDlr_cat(bpil_RewardOPAOutput.getRW_DLR_CAT());
			aContact.setDlr_bill_to(bpil_RewardOPAOutput.getRW_DLR_BILL_TO());
			aContact.setDlr_type(bpil_RewardOPAOutput.getRW_DLR_TYPE());
			aContact.setDlr_name(bpil_RewardOPAOutput.getRW_DLR_NAME());
			aContact.setReward_section(bpil_RewardOPAOutput.getRW_SEC());
			aContact.setReward_type(bpil_RewardOPAOutput.getRW_TYPE());
			aContact.setProduct(bpil_RewardOPAOutput.getRW_PRD());
			aContact.setUnit(bpil_RewardOPAOutput.getRW_UNIT());
			aContact.setReward_date(bpil_RewardOPAOutput.getRW_DATE());

			if (bpil_RewardOPAOutput.getRW_DATE() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
				String dateStr1 = ser1.format(bpil_RewardOPAOutput.getRW_DATE());
				aContact.setReward_date1(dateStr1);
//					try {
//						System.out.println(ser1.parse(rs.getString("REWARD_DATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}
			}

			aContact.setReward_ly(bpil_RewardOPAOutput.getRW_LY().intValue());
			aContact.setReward_target(bpil_RewardOPAOutput.getRW_TGT().intValue());
			aContact.setReward_ty(bpil_RewardOPAOutput.getRW_TY().intValue());
			aContact.setAdditional(bpil_RewardOPAOutput.getRW_ADDITIONAL().intValue());
			aContact.setBase_total(bpil_RewardOPAOutput.getRW_BASE_TOTAL().intValue());
			aContact.setReward_status(bpil_RewardOPAOutput.getRW_Q_STAT());
			aContact.setReward_description(bpil_RewardOPAOutput.getRW_DESC());
			aContact.setReward_total(bpil_RewardOPAOutput.getRW_TOTAL().intValue());
			aContact.setNext_tgt_pending(bpil_RewardOPAOutput.getRW_NXT_TGT().intValue());
			aContact.setGift_to_cn_flag(bpil_RewardOPAOutput.getRW_GFT_TO_CN());
			aContact.setConverted_cn_value(bpil_RewardOPAOutput.getRW_CONV_CN().intValue());
			aContact.setInterface_status(bpil_RewardOPAOutput.getRW_I_STAT());

			aContact.setReward_last_update(bpil_RewardOPAOutput.getRW_LAST_UPDATE());

			if (bpil_RewardOPAOutput.getRW_LAST_UPDATE() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String dateStr1 = ser1.format(bpil_RewardOPAOutput.getRW_LAST_UPDATE());
				aContact.setReward_last_update1(dateStr1);
//					try {
////						System.out.println(ser1.parse(rs.getString("REWARD_LAST_UPDATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}
			}

			sch_Analysis_Rws.add(aContact);

		}

		String LastRefresh = "";

		if (sch_Analysis_Rws.size() > 0) {

			if (sch_Analysis_Rws.get(0).getReward_last_update() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String dateStr1 = ser1.format(sch_Analysis_Rws.get(0).getReward_last_update());
//					try {
////						System.out.println(ser1.parse(rs.getString("REWARD_LAST_UPDATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}

				LastRefresh = dateStr1;
			}

		}
		if (schnm != null && schnm != "") {
			int scheme_id = Integer.parseInt(schnm);

			ArrayList<New_Scheme_mstr> data = (ArrayList<New_Scheme_mstr>) hibernateTemplate
					.find("from New_Scheme_mstr where scheme_id=" + scheme_id);
			String name = data.get(0).getScheme_name();

			ArrayList<Bpil_Scheme_Doc> doc_line = schememasterdao.docautofill(scheme_id);
			System.out.println("doc_line " + doc_line.size());

			model.addAttribute("doc_list", doc_line);

			model.addAttribute("Info_grid", sch_Analysis_Rws);

			model.addAttribute("LastRefresh", LastRefresh);

			model.addAttribute("schnm", name);
		}
		model.addAttribute("depo_code", depot);
		model.addAttribute("scheme_id", schnm);

		return new ModelAndView("SchemeAnalysisRest");
		/*
		 * try { URL url = new URL(schopawebserviceUrl);
		 * 
		 * HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 * 
		 * conn.setDoOutput(true); conn.setRequestMethod("POST");
		 * conn.setRequestProperty("Content-Type", "application/json");
		 * conn.setRequestProperty("Authorization", oAuth2_token);
		 * 
		 * String JSON_REQ =
		 * createDlrSchRestRequestJSONWriter(dealerOPAInput,productOPAInput, schnm,
		 * depot, bill_to_id, request);
		 * 
		 * OutputStream os = conn.getOutputStream(); os.write(JSON_REQ.getBytes());
		 * os.flush();
		 * 
		 * if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) { throw new
		 * RuntimeException("Failed : HTTP error code : " + conn.getResponseCode()); }
		 * 
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(conn.getInputStream()));
		 * 
		 * String JSON_RESP; System.out.println("Output from Server .... \n"); while
		 * ((JSON_RESP = br.readLine()) != null) { System.out.println(JSON_RESP);
		 * 
		 * RewardOPAOutput = printDlrSchRestResponseJSONReader(JSON_REQ,
		 * JSON_RESP,dealerOPAInput,productOPAInput, schnm, depot, bill_to_id, request);
		 * }
		 * 
		 * conn.disconnect();
		 * 
		 * 
		 * } catch (MalformedURLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (ParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

	@RequestMapping(value = "/callschjbpmrest_webservice1")
	public ModelAndView callschjbpmrest_webservice1(Model model, @RequestParam(value = "scheme_id") String schnm,
			@RequestParam(value = "depot") String depot, @RequestParam(value = "bill_to_id") String bill_to_id,
			HttpServletRequest request) {
		System.out.println("inside jbpm rest cont------------------");
		System.out.println("1   " + schnm);
		System.out.println("2   " + depot);
		System.out.println("3   " + bill_to_id);
		// TODO Auto-generated method stub
		///// -12-06-21-///////////
		List<String> dealer_name = new ArrayList<>();
		if (bill_to_id == "") {
			System.out.println("bill_to_id is empty");

			List<Bpil_Opa_Rw_Analysis_Rw> dml = new ArrayList<Bpil_Opa_Rw_Analysis_Rw>();
			CallableStatement cStmts;
			try {
				cStmts = hibernateConfiguration.dataSource().getConnection()
						.prepareCall("{call BPIL_GET_OPA_SCH_DLR(?,?,?)}");
				cStmts.setInt(1, Integer.parseInt(schnm));
				cStmts.setString(2, depot);
				cStmts.registerOutParameter(3, OracleTypes.CURSOR);
				ResultSet result = cStmts.executeQuery();
				ResultSet rs1 = (ResultSet) cStmts.getObject(3);
				while (rs1.next()) {
					Bpil_Opa_Rw_Analysis_Rw aContact = new Bpil_Opa_Rw_Analysis_Rw();
					System.out.println(rs1.getString("OPA_RW_AN_DEALER_ID"));
					System.out.println(rs1.getString("DLR_AC_NAME"));
					System.out.println(rs1.getString("DLR_AC_NO"));
					System.out.println(rs1.getInt("DLR_BILL_TO"));
					aContact.setOpa_rw_an_dealer_id(rs1.getString("OPA_RW_AN_DEALER_ID"));
					aContact.setDlr_ac_no(rs1.getString("DLR_AC_NO"));
					aContact.setDlr_name(rs1.getString("DLR_AC_NAME"));
					aContact.setDlr_bill_to(rs1.getInt("DLR_BILL_TO"));

					dml.add(aContact);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(dml.toString());
			Iterator<Bpil_Opa_Rw_Analysis_Rw> itr = dml.iterator();
			while (itr.hasNext()) {
				Bpil_Opa_Rw_Analysis_Rw br = itr.next();
				dealer_name.add(String.valueOf(br.getDlr_bill_to()));
			}

			System.out.println("list of dealer_name" + dealer_name.toString());
		} else {
			dealer_name = Arrays.asList(bill_to_id.split(","));
			System.out.println("list " + dealer_name.toString());
		}

		ArrayList<New_Scheme_mstr> dml = (ArrayList<New_Scheme_mstr>) hibernateTemplate
				.find("from New_Scheme_mstr where scheme_id = '" + schnm + "'");
		System.out.println("Size of scheme master array is : " + dml.size());
		System.out.println("Scheme policy name is :- " + dml.get(0).getSch_dir_name());
		String schopawebserviceUrl = "";
		if (dml != null && dml.size() > 0) {
			String opa_sch_policy_name = dml.get(0).getSch_dir_name();
			System.out.println("Scheme policy name is :- " + opa_sch_policy_name);
			if (opa_sch_policy_name != null && !opa_sch_policy_name.equals("")) {

				schopawebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/12.2.7/policy-models/"
						+ opa_sch_policy_name + "/assessor";
			}

		}
		System.out.println("Url is : = " + schopawebserviceUrl);
		String OAuth2_token = "";
		if (dealer_name.size() > 0) {

			String schopaauthwebserviceUrl = "https://iflictest2.custhelp.com/determinations-server/batch/auth?grant_type=client_credentials&client_id=apiuser1&client_secret=ApiUser$111";

			OAuth2_token = callauthoparest_webservice(schopaauthwebserviceUrl, request);

		}
		////////////// END////////////////

		// Start trial code
		List<Bpil_DealerOPAInput> dealerOPAInput = new ArrayList<Bpil_DealerOPAInput>();
		List<Bpil_ProductOPAInput> productOPAInput = new ArrayList<Bpil_ProductOPAInput>();
		// String schopaauthwebserviceUrl =
		// "https://iflictest2.custhelp.com/determinations-server/batch/auth?grant_type=client_credentials&client_id=apiuser1&client_secret=ApiUser$111";
		// String oAuth2_token = "";
		// oAuth2_token = callauthoparest_webservice(schopaauthwebserviceUrl, request);
		// End Trial code
		// Create Rest Connection

		List<Bpil_RewardOPAOutput> RewardSchOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

		for (String dealer_bill_to_id : dealer_name) {

			List<Bpil_DealerOPAInput> DealerOPAInput = new ArrayList<Bpil_DealerOPAInput>();
			List<Bpil_ProductOPAInput> ProductOPAInput = new ArrayList<Bpil_ProductOPAInput>();
			List<Bpil_RewardOPAOutput> RewardOPAOutput = new ArrayList<Bpil_RewardOPAOutput>();

			CallableStatement cStmt;
			try {
				cStmt = hibernateConfiguration.dataSource().getConnection()
						.prepareCall("{call BPIL_GET_OPA_DLR_INPUT(?,?,?,?,?)}");
				cStmt.setInt(1, Integer.parseInt(schnm));
				cStmt.setString(2, depot);
				cStmt.setInt(3, Integer.parseInt(dealer_bill_to_id));

				cStmt.registerOutParameter(4, OracleTypes.CURSOR);
				cStmt.registerOutParameter(5, OracleTypes.CURSOR);

				ResultSet result = cStmt.executeQuery();
				ResultSet rsdealers = (ResultSet) cStmt.getObject(4);
				ResultSet rsproducts = (ResultSet) cStmt.getObject(5);

				while (rsdealers.next()) {
					Bpil_DealerOPAInput bpil_DealerOPAInput = new Bpil_DealerOPAInput();

					bpil_DealerOPAInput.setDLR_SCH_ID(rsdealers.getInt("SCHEME_ID"));
					bpil_DealerOPAInput.setDLR_FIN_AN_FLAG(rsdealers.getString("FIN_AN_FLAG"));
					bpil_DealerOPAInput.setDLR_REGN(rsdealers.getString("DLR_REGN"));
					bpil_DealerOPAInput.setDLR_DEPOT(rsdealers.getString("DLR_DEPOT"));
					bpil_DealerOPAInput.setDLR_STATE(rsdealers.getString("DLR_STATE"));
					bpil_DealerOPAInput.setDLR_TERR_CODE(rsdealers.getString("DLR_TERR_CODE"));
					bpil_DealerOPAInput.setDLR_TERR_NAME(rsdealers.getString("DLR_TERR_NAME"));
					bpil_DealerOPAInput.setDLR_BILL_TO(rsdealers.getInt("DLR_BILL_TO"));
					bpil_DealerOPAInput.setDLR_AC_NO(rsdealers.getString("DLR_AC_NO"));
					bpil_DealerOPAInput.setDLR_AC_NAME(rsdealers.getString("DLR_AC_NAME"));
					bpil_DealerOPAInput.setDLR_CAT(rsdealers.getString("DLR_CAT"));
					bpil_DealerOPAInput.setDLR_TYPE(rsdealers.getString("DLR_TYPE"));
					bpil_DealerOPAInput.setDLR_RET(rsdealers.getString("DLR_RET"));
					bpil_DealerOPAInput.setDLR_SDLR_COUNT(rsdealers.getInt("DLR_SDLR_COUNT"));

					DealerOPAInput.add(bpil_DealerOPAInput);
				}

				while (rsproducts.next()) {
					Bpil_ProductOPAInput bpil_ProductOPAInput = new Bpil_ProductOPAInput();

					bpil_ProductOPAInput.setPRD_SCH_ID(rsproducts.getInt("PRD_SCH_ID"));
					bpil_ProductOPAInput.setPRD_BILL_TO(rsproducts.getInt("PRD_BILL_TO"));
					bpil_ProductOPAInput.setPRD_DLR_AC_NO(rsproducts.getString("PRD_DLR_AC_NO"));
					bpil_ProductOPAInput.setPRD_DLR_TYPE(rsproducts.getString("PRD_DLR_TYPE"));
					bpil_ProductOPAInput.setPRD_NAME(rsproducts.getString("PRD_NAME"));
					bpil_ProductOPAInput.setPRD_CAT(rsproducts.getString("PRD_CAT"));
					bpil_ProductOPAInput.setPRD_CAT_DESC(rsproducts.getString("PRD_CAT_DESC"));
					bpil_ProductOPAInput.setPRD_GRP(rsproducts.getString("PRD_GRP"));
					bpil_ProductOPAInput.setPRD_CODE(rsproducts.getString("PRD_CODE"));
					bpil_ProductOPAInput.setPRD_SHD_CODE(rsproducts.getString("PRD_SHD_CODE"));
					bpil_ProductOPAInput.setPRD_INV_DT(rsproducts.getDate("PRD_INV_DT"));
					bpil_ProductOPAInput.setPRD_UOM(rsproducts.getString("PRD_UOM"));
					bpil_ProductOPAInput.setPRD_PCK_SIZE(rsproducts.getBigDecimal("PRD_PCK_SIZE"));
					bpil_ProductOPAInput.setPRD_VOL(rsproducts.getBigDecimal("PRD_VOL"));
					bpil_ProductOPAInput.setPRD_FNL_VOL(rsproducts.getBigDecimal("PRD_FNL_VOL"));
					bpil_ProductOPAInput.setPRD_VAL(rsproducts.getBigDecimal("PRD_VAL"));
					bpil_ProductOPAInput.setPRD_VOL_RW(rsproducts.getBigDecimal("PRD_VOL_RW"));
					bpil_ProductOPAInput.setPRD_FNL_VOL_RW(rsproducts.getBigDecimal("PRD_FNL_VOL_RW"));
					bpil_ProductOPAInput.setPRD_VAL_RW(rsproducts.getBigDecimal("PRD_VAL_RW"));

					ProductOPAInput.add(bpil_ProductOPAInput);
				}

				System.out.println("Dealers size = " + DealerOPAInput.size() + " Products = " + ProductOPAInput.size());

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			Date Sd = new Date();
			System.out.println("Start call to webservice" + Sd);
			System.out.println("sch opa rest url is : = " + schopawebserviceUrl);
			RewardOPAOutput = callschoparest_webservice(DealerOPAInput, ProductOPAInput, schnm, depot,
					dealer_bill_to_id, schopawebserviceUrl, OAuth2_token, request);

			Date Ed = new Date();
			System.out.println("End call to webservice" + Ed);

			System.out.println("Total time : Sw " + Sd + " Ew " + Ed);

			RewardSchOPAOutput.addAll(RewardOPAOutput);

		}
		System.out.println("Total size of  RewardSchOPAOutput: " + RewardSchOPAOutput.size());
		List<Bpil_Opa_Sch_Analysis_Rw> sch_Analysis_Rws = new ArrayList<Bpil_Opa_Sch_Analysis_Rw>();

		for (Bpil_RewardOPAOutput bpil_RewardOPAOutput : RewardSchOPAOutput) {

			Bpil_Opa_Sch_Analysis_Rw aContact = new Bpil_Opa_Sch_Analysis_Rw();

			aContact.setScheme_id(bpil_RewardOPAOutput.getRW_SCH_ID());
			aContact.setRegn(bpil_RewardOPAOutput.getRW_DLR_REGN());
			aContact.setState(bpil_RewardOPAOutput.getRW_DLR_STATE());
			aContact.setDepot(bpil_RewardOPAOutput.getRW_DLR_DEPOT());
			aContact.setTerr_code(bpil_RewardOPAOutput.getRW_DLR_TERR_CODE());
			aContact.setTerr_name(bpil_RewardOPAOutput.getRW_DLR_TERR_NAME());
			aContact.setDlr_ac_no(bpil_RewardOPAOutput.getRW_DLR_CODE());
			aContact.setDlr_cat(bpil_RewardOPAOutput.getRW_DLR_CAT());
			aContact.setDlr_bill_to(bpil_RewardOPAOutput.getRW_DLR_BILL_TO());
			aContact.setDlr_type(bpil_RewardOPAOutput.getRW_DLR_TYPE());
			aContact.setDlr_name(bpil_RewardOPAOutput.getRW_DLR_NAME());
			aContact.setReward_section(bpil_RewardOPAOutput.getRW_SEC());
			aContact.setReward_type(bpil_RewardOPAOutput.getRW_TYPE());
			aContact.setProduct(bpil_RewardOPAOutput.getRW_PRD());
			aContact.setUnit(bpil_RewardOPAOutput.getRW_UNIT());
			aContact.setReward_date(bpil_RewardOPAOutput.getRW_DATE());

			if (bpil_RewardOPAOutput.getRW_DATE() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
				String dateStr1 = ser1.format(bpil_RewardOPAOutput.getRW_DATE());
				aContact.setReward_date1(dateStr1);
//					try {
//						System.out.println(ser1.parse(rs.getString("REWARD_DATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}
			}

			aContact.setReward_ly(bpil_RewardOPAOutput.getRW_LY().intValue());
			aContact.setReward_target(bpil_RewardOPAOutput.getRW_TGT().intValue());
			aContact.setReward_ty(bpil_RewardOPAOutput.getRW_TY().intValue());
			aContact.setAdditional(bpil_RewardOPAOutput.getRW_ADDITIONAL().intValue());
			aContact.setBase_total(bpil_RewardOPAOutput.getRW_BASE_TOTAL().intValue());
			aContact.setReward_status(bpil_RewardOPAOutput.getRW_Q_STAT());
			aContact.setReward_description(bpil_RewardOPAOutput.getRW_DESC());
			aContact.setReward_total(bpil_RewardOPAOutput.getRW_TOTAL().intValue());
			aContact.setNext_tgt_pending(bpil_RewardOPAOutput.getRW_NXT_TGT().intValue());
			aContact.setGift_to_cn_flag(bpil_RewardOPAOutput.getRW_GFT_TO_CN());
			aContact.setConverted_cn_value(bpil_RewardOPAOutput.getRW_CONV_CN().intValue());
			aContact.setInterface_status(bpil_RewardOPAOutput.getRW_I_STAT());

			aContact.setReward_last_update(bpil_RewardOPAOutput.getRW_LAST_UPDATE());

			if (bpil_RewardOPAOutput.getRW_LAST_UPDATE() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String dateStr1 = ser1.format(bpil_RewardOPAOutput.getRW_LAST_UPDATE());
				aContact.setReward_last_update1(dateStr1);
//					try {
////						System.out.println(ser1.parse(rs.getString("REWARD_LAST_UPDATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}
			}

			sch_Analysis_Rws.add(aContact);

		}

		String LastRefresh = "";

		if (sch_Analysis_Rws.size() > 0) {

			if (sch_Analysis_Rws.get(0).getReward_last_update() != null) {
				DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String dateStr1 = ser1.format(sch_Analysis_Rws.get(0).getReward_last_update());
//					try {
////						System.out.println(ser1.parse(rs.getString("REWARD_LAST_UPDATE")));
//					} catch (ParseException e) {
//							e.printStackTrace();
//					}

				LastRefresh = dateStr1;
			}

		}
		if (schnm != null && schnm != "") {
			int scheme_id = Integer.parseInt(schnm);

			ArrayList<New_Scheme_mstr> data = (ArrayList<New_Scheme_mstr>) hibernateTemplate
					.find("from New_Scheme_mstr where scheme_id=" + scheme_id);
			String name = data.get(0).getScheme_name();

			ArrayList<Bpil_Scheme_Doc> doc_line = schememasterdao.docautofill(scheme_id);
			System.out.println("doc_line " + doc_line.size());

			model.addAttribute("doc_list", doc_line);

			model.addAttribute("Info_grid", sch_Analysis_Rws);

			model.addAttribute("LastRefresh", LastRefresh);

			model.addAttribute("schnm", name);
		}
		model.addAttribute("depo_code", depot);
		model.addAttribute("scheme_id", schnm);

		return new ModelAndView("SchemeAnalysisRest");
		/*
		 * try { URL url = new URL(schopawebserviceUrl);
		 * 
		 * HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 * 
		 * conn.setDoOutput(true); conn.setRequestMethod("POST");
		 * conn.setRequestProperty("Content-Type", "application/json");
		 * conn.setRequestProperty("Authorization", oAuth2_token);
		 * 
		 * String JSON_REQ =
		 * createDlrSchRestRequestJSONWriter(dealerOPAInput,productOPAInput, schnm,
		 * depot, bill_to_id, request);
		 * 
		 * OutputStream os = conn.getOutputStream(); os.write(JSON_REQ.getBytes());
		 * os.flush();
		 * 
		 * if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) { throw new
		 * RuntimeException("Failed : HTTP error code : " + conn.getResponseCode()); }
		 * 
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(conn.getInputStream()));
		 * 
		 * String JSON_RESP; System.out.println("Output from Server .... \n"); while
		 * ((JSON_RESP = br.readLine()) != null) { System.out.println(JSON_RESP);
		 * 
		 * RewardOPAOutput = printDlrSchRestResponseJSONReader(JSON_REQ,
		 * JSON_RESP,dealerOPAInput,productOPAInput, schnm, depot, bill_to_id, request);
		 * }
		 * 
		 * conn.disconnect();
		 * 
		 * 
		 * } catch (MalformedURLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (ParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}
	
	@RequestMapping(value = "/callschoparest_webservicecrm")
	public ModelAndView callschoparest_webservicecrm(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException, DataAccessException, JSONException, UnirestException, org.json.simple.parser.ParseException {
		System.out.println("inside test callschoparest_webservicecrm------------------");
						
		   String sql ="SELECT  DISTINCT   h.CUSTOMER_ID,h.CUSTOMER_COMPANY,h.SALES_ORDER_ID,h.CREATED_DATE, l.SO_LINE_TOTAL,l.RES_LINE_STATUS\r\n"
		    		+ "  FROM    BAS_SALES_ORDER_HEADER h, BAS_SALES_ORDER_LINES l\r\n"
		    		+ "  WHERE   h.SALES_ORDER_ID = l.SALES_ORDER_ID\r\n"
		    		+ "  AND    l.RES_LINE_STATUS='Closed'";
		 
		List<Crm_Detail> dml = jdbctemplate.query(sql, new RowMapper<Crm_Detail>() {

			@Override
			public Crm_Detail mapRow(ResultSet rs, int rowNum) throws SQLException {
				Crm_Detail aContact = new Crm_Detail();  

				aContact.setRES_LINE_STATUS((rs.getString("RES_LINE_STATUS")));
				aContact.setSO_LINE_TOTAL((rs.getString("SO_LINE_TOTAL")));
				aContact.setCUSTOMER_ID((rs.getString("CUSTOMER_ID")));
				aContact.setSALES_ORDER_ID(rs.getString("SALES_ORDER_ID"));
				aContact.setCUSTOMER_COMPANY((rs.getString("CUSTOMER_COMPANY")));
				aContact.setDATE(rs.getString("CREATED_DATE"));
				
				
				return aContact;
			}

		});
		

		   List<drools_obj> drools_obj = new ArrayList<drools_obj>();
		   String  res_line_status=null;
		   String so_line_total=null;
		   String customer_company=null;
		   String sales_order_id=null;
		   String customer_id=null;
		   String date=null;
		for (Crm_Detail dealer : dml) {
             drools_obj obj=new drools_obj();
             res_line_status = dealer.getRES_LINE_STATUS().toLowerCase();
			 so_line_total =dealer.getSO_LINE_TOTAL();
			 customer_company=dealer.getCUSTOMER_COMPANY();
			 sales_order_id=dealer.getSALES_ORDER_ID();
			 customer_id=dealer.getCUSTOMER_ID();
			 date=dealer.getDATE();
			
			String res ;
			System.out.println("before POST api hitt");
			Unirest.setTimeouts(0, 0);		
		
			HttpResponse<String> response11 = Unirest.post("http://mindsconnect.omfysgroup.com:8080/kie-server/services/rest/server/containers/instances/Bsat_1.0.0-SNAPSHOT")
					   .header("Authorization", "Basic d2JhZG1pbjp3YmFkbWlu")
					   .header("Content-Type", "application/json")
					   .body("{\r\n  \"lookups\":null,\r\n    \"commands\":[\r\n         {\r\n        \"insert\": {\r\n            \"out-identifier\":\"BSAT_RULE\",\r\n            \"object\":{   \r\n                \"com.trial.bsat.BSAT_Module\":{\r\n          \"customer_company\":\""+customer_company+"\",\r\n      \"customer_id\":\""+customer_id+"\",\r\n     \"sales_order_id\":\""+sales_order_id+"\",\r\n      \"res_line_status\":\""+res_line_status+"\",\r\n                    \"so_line_total\":\""+so_line_total+"\"    \r\n                }  \r\n            },\r\n            \"disconnected\":true,\r\n            \"return-object\":true,\r\n            \"entry-point\":\"DEFAULT\"\r\n          }\r\n        }, \r\n    {\r\n        \"fire-all-rules\":\"\"\r\n    }\r\n    ]\r\n}")
					   .asString();

						System.out.println(" the response code=====>"+response11.getStatus());
						res=response11.getBody().toString();
						//System.out.println(" In String response"+res);
						
						JSONObject json = new JSONObject(res);   
						// System.out.println(" new String response"+json);
						  JSONObject geometry = json.getJSONObject("result");
						 // System.out.println("Second Iteration  :"+geometry);
						  
						  JSONObject thirdObject = geometry.getJSONObject("execution-results");
						//  System.out.println("\nThird Iteration  :"+thirdObject);
						  
						  JSONArray thirdObject2 = thirdObject.getJSONArray("results");
						//  System.out.println("\nfourth Iteration  :"+thirdObject2.get(1));
						  
						  JSONObject thirdObject3 =thirdObject2.getJSONObject(1);
						 // System.out.println("\nfive Iteration  :"+thirdObject3);
						  
						  
						  JSONObject thirdObject4= thirdObject3.getJSONObject("value");
						 // System.out.println("\nsix Iteration  :"+thirdObject4);
						  
						  JSONObject thirdObject5= thirdObject4.getJSONObject("com.trial.bsat.BSAT_Module");
						 // System.out.println("\nseven Iteration  :"+thirdObject5);
						  
						  Object s=thirdObject5.get("status");
					      String msg = s.toString();
					      
					      
					      
					      Object res_line_status1=thirdObject5.get("res_line_status");
					      String  res_line_status11= res_line_status1.toString();
					      
					      Object so_line_total1=thirdObject5.get("so_line_total");
					      String so_line_total1u = so_line_total1.toString();
					      
					      Object customer_company1=thirdObject5.get("customer_company");
					      String customer_company11 = customer_company1.toString();
					      
					      Object customer_id1=thirdObject5.get("customer_id");
					      String customer_id11 = customer_id1.toString();
					      
					      Object sales_order_id1=thirdObject5.get("sales_order_id");
					      String sales_order_id11 = sales_order_id1.toString();
				
					     System.out.println("\nMessage   :"+msg+" "+res_line_status11+" "+so_line_total1u+" "+customer_company11+" "+sales_order_id11+" "+customer_id11);
					     System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
					     
					     
					     obj.setCUSTOMER_ID(customer_id11);
					      obj.setRES_LINE_STATUS(res_line_status11);
					      obj.setSO_LINE_TOTAL(so_line_total1u);
					      obj.setCUSTOMER_COMPANY(customer_company11);
					      obj.setSALES_ORDER_ID(sales_order_id11);
					      obj.setSTATUS(msg);
					      obj.setDATE(date);
//					     sales_order_id_list.add(sales_order_id11);
//					     status_list.add(msg);
//					     so_line_total_list.add(so_line_total1u);
//					     customer_company_list.add(customer_company11);
//					     customer_id_list.add(customer_id11);
//					     res_line_status_list.add(res_line_status11);
					    // aContact.setSTATUS(msg);
					      drools_obj.add(obj);
					

		}
		
		model.addAttribute("ifl",dml);
		model.addAttribute("ifl2",1000);	    
	    model.addAttribute("iftest",drools_obj);

	    
		return new ModelAndView("SchemeAnalysisRestCrm");

}
	
	public void sendReq(String req) throws IOException, UnirestException
	{	
	       
	

		JsonObjectBuilder JsonReqBuilder = Json.createObjectBuilder();
		JsonArrayBuilder outcomesBuilder = Json.createArrayBuilder();
		JsonArrayBuilder casesBuilder = Json.createArrayBuilder();

		List<String> outcomes = new ArrayList<String>();

		String[] Stroutcome = new String[] { "CUSTOMER_ID", "CUSTOMER_COMPANY", "SALES_ORDER_ID", "SO_LINE_TOTAL", "RES_LINE_STATUS"};
		
		outcomes = Arrays.asList(Stroutcome);
		
		for (String outcome : outcomes) {
			outcomesBuilder.add(outcome);
		}

		JsonReqBuilder.add("outcomes", outcomesBuilder);
		try {

			String json = null;			
			   String sql ="SELECT  DISTINCT   h.CUSTOMER_ID,h.CUSTOMER_COMPANY,h.SALES_ORDER_ID, l.SO_LINE_TOTAL,l.RES_LINE_STATUS\r\n"
		        		+ "  FROM    BAS_SALES_ORDER_HEADER h, BAS_SALES_ORDER_LINES l\r\n"
		        		+ "  WHERE   h.SALES_ORDER_ID = l.SALES_ORDER_ID\r\n"
		        		+ "  AND    l.RES_LINE_STATUS='Closed'";
			List<Crm_Detail> dml = jdbctemplate.query(sql, new RowMapper<Crm_Detail>() {

				@Override
				public Crm_Detail mapRow(ResultSet rs, int rowNum) throws SQLException {
					Crm_Detail aContact = new Crm_Detail();

					aContact.setRES_LINE_STATUS((rs.getString("RES_LINE_STATUS")));
					aContact.setSO_LINE_TOTAL((rs.getString("SO_LINE_TOTAL")));
					aContact.setCUSTOMER_ID((rs.getString("CUSTOMER_ID")));
					aContact.setSALES_ORDER_ID(rs.getString("SALES_ORDER_ID"));
					aContact.setCUSTOMER_COMPANY((rs.getString("CUSTOMER_COMPANY")));

					return aContact;
				}

			});
			
			
			
			for (Crm_Detail dealer : dml) {
				JsonObjectBuilder dealerBuilder = Json.createObjectBuilder();
				

				dealerBuilder.add("RES_LINE_STATUS", dealer.getRES_LINE_STATUS());
				dealerBuilder.add("SO_LINE_TOTAL", dealer.getSO_LINE_TOTAL());
				dealerBuilder.add("CUSTOMER_ID", dealer.getCUSTOMER_ID());
				dealerBuilder.add("SALES_ORDER_ID", dealer.getSALES_ORDER_ID());
				dealerBuilder.add("CUSTOMER_COMPANY", dealer.getCUSTOMER_COMPANY());
				casesBuilder.add(dealerBuilder);

			
			}
			
			JsonReqBuilder.add("cases", casesBuilder);
			String[] elementNames = JSONObject.getNames("cases");
			for(int i=0;i<elementNames.length;i++)
			{
				System.out.println("Hey: "+elementNames[i]);
			}
			
			System.out.println(JsonReqBuilder.toString()+"0909000000000000000000000000000");
			JsonObject JsonREQObject = JsonReqBuilder.build();
			
			String s=JsonReqBuilder.toString();
			System.out.println("------------99999999999999    "+s);

			
			JSONObject getSth = (JSONObject) JsonREQObject.get("cases");
			Object level = getSth.get("2");
			System.out.println(level);
			
					
			System.out.println("JsonREQObject JSON String Size" + JsonREQObject);
			System.out.println("JsonREQObject JSON String\n" + JsonREQObject.get("cases"));
			
		
			 JSONObject json1 = new JSONObject(JsonREQObject.get("cases"));  
			 System.out.println(" new String response"+json);
			  JSONObject geometry = json1.getJSONObject("so_line_total");
			  System.out.println("Second Iteration  :"+geometry);
			  
			StringWriter strWtr = new StringWriter();
			JsonWriter jsonWtr = Json.createWriter(strWtr);
			jsonWtr.writeObject(JsonREQObject);
			String JSON_REQ = strWtr.toString();
			jsonWtr.close();
			strWtr.close();

			System.out.println("----------++++++++++++++--------------------");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		StringBuffer response1 = new StringBuffer();
		
		String res ;
			 System.out.println("before POST api hitt");
			 Unirest.setTimeouts(0, 0);

			
			String res_line_status = "closed";
			String so_line_total = "800";
			HttpResponse<String> response11 = Unirest.post("http://mindsconnect.omfysgroup.com:8080/kie-server/services/rest/server/containers/instances/Bsat_1.0.0-SNAPSHOT")
			   .header("Authorization", "Basic d2JhZG1pbjp3YmFkbWlu")
			   .header("Content-Type", "application/json")
			   .body("{\r\n  \"lookups\":null,\r\n    \"commands\":[\r\n         {\r\n        \"insert\": {\r\n            \"out-identifier\":\"BSAT_RULE\",\r\n            \"object\":{   \r\n                \"com.trial.bsat.BSAT_Module\":{\r\n                     \"res_line_status\":\""+res_line_status+"\",\r\n                    \"so_line_total\":\""+so_line_total+"\"    \r\n                }  \r\n            },\r\n            \"disconnected\":true,\r\n            \"return-object\":true,\r\n            \"entry-point\":\"DEFAULT\"\r\n          }\r\n        }, \r\n    {\r\n        \"fire-all-rules\":\"\"\r\n    }\r\n    ]\r\n}")
			   .asString();

				System.out.println(" the response code=====>"+response11.getStatus());
				//System.out.println(" the response code=====>"+response.getBody());
				res=response11.getBody().toString();
				System.out.println(" In String response"+res);
				
				 JSONObject json = new JSONObject(res);   
				 System.out.println(" new String response"+json);
				  JSONObject geometry = json.getJSONObject("result");
				  System.out.println("Second Iteration  :"+geometry);
				  
				  JSONObject thirdObject = geometry.getJSONObject("execution-results");
				  System.out.println("\nThird Iteration  :"+thirdObject);
				  
				  JSONArray thirdObject2 = thirdObject.getJSONArray("results");
				  System.out.println("\nfourth Iteration  :"+thirdObject2.get(1));
				  
				  JSONObject thirdObject3 =thirdObject2.getJSONObject(1);
				  System.out.println("\nfive Iteration  :"+thirdObject3);
				  
				  
				  JSONObject thirdObject4= thirdObject3.getJSONObject("value");
				  System.out.println("\nsix Iteration  :"+thirdObject4);
				  
				  JSONObject thirdObject5= thirdObject4.getJSONObject("com.trial.bsat.BSAT_Module");
				  System.out.println("\nseven Iteration  :"+thirdObject5);
				  
				  Object s=thirdObject5.get("status");
			      String msg = s.toString();
		
			     System.out.println("\nMessage   :"+msg);
			    // model.addAttribute("msg",msg);

		
	}
}
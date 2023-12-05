package com.omfys.bsat.repositoryImpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.repository.DashbordDAO;
import com.omfys.bsat.model.AdminCount;
import com.omfys.bsat.model.Bpil_Dealer_Master;
import com.omfys.bsat.model.Bpil_Depot_Master;
import com.omfys.bsat.model.Bpil_notification;
import com.omfys.bsat.model.Dashbord;
import com.omfys.bsat.model.New_Scheme_mstr;
@Repository("DashbordApproverDAO")
public class DashbordDAOImpl implements DashbordDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Override
	public List<Bpil_notification> DashbordApprover_List(int user_id) {
		
		String sql = "SELECT WF_NOTIFICATION_ID,SCHEME_ID,WF_INSTANCE_ID,WF_NOTIFICATION_MSG FROM BPIL_WF_NOTIFICATIONS WHERE USER_ID="+user_id+" AND STATUS='Pending' order by SCHEME_ID desc";
		
		List<Bpil_notification> listContact = jdbcTemplate.query(sql, new RowMapper<Bpil_notification>() {

			@Override
			public Bpil_notification mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_notification aContact = new Bpil_notification();
	
				aContact.setWf_notification_id(rs.getInt("WF_NOTIFICATION_ID"));
				aContact.setScheme_id(rs.getInt("SCHEME_ID"));
				aContact.setWf_instance_id(rs.getInt("WF_INSTANCE_ID"));
				aContact.setWf_notification_msg(rs.getString("WF_NOTIFICATION_MSG"));
			
				return aContact;
			}
			
		});
		
		return listContact;
	}
	
	@Override
	public List<Bpil_notification> DashbordApprover_List(int user_id, int scheme_id) {
		
		String sql = "SELECT WF_NOTIFICATION_ID,SCHEME_ID,WF_INSTANCE_ID,WF_NOTIFICATION_MSG FROM BPIL_WF_NOTIFICATIONS WHERE SCHEME_ID = "+scheme_id+" AND  USER_ID="+user_id+" AND STATUS='Pending'";
		
		List<Bpil_notification> listContact = jdbcTemplate.query(sql, new RowMapper<Bpil_notification>() {

			@Override
			public Bpil_notification mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_notification aContact = new Bpil_notification();
	
				aContact.setWf_notification_id(rs.getInt("WF_NOTIFICATION_ID"));
				aContact.setScheme_id(rs.getInt("SCHEME_ID"));
				aContact.setWf_instance_id(rs.getInt("WF_INSTANCE_ID"));
				aContact.setWf_notification_msg(rs.getString("WF_NOTIFICATION_MSG"));
			
				return aContact;
			}
			
		});
		
		return listContact;
	}

	
	@Override
	public List<Dashbord> DashbordApproverCount_List(int user_id) {
		String sql = "SELECT pending_claims, approved_claims, total_claims, rejected_claims, inprocess_claims FROM "
				+ "(SELECT COUNT(claim_header_id) pending_claims FROM koel_claim_header WHERE claim_status = 'Entered' ), "
				+ "(SELECT COUNT(claim_header_id) Approved_claims FROM koel_claim_header WHERE claim_status = 'Approved' ), "
				+ "(SELECT COUNT(claim_header_id) total_claims FROM koel_claim_header ), (SELECT COUNT(claim_header_id) rejected_claims "
				+ "FROM koel_claim_header WHERE claim_status = 'Rejected' ), (SELECT COUNT(claim_header_id) inprocess_claims FROM koel_claim_header "
				+ "WHERE claim_status = 'In Process')";
		List<Dashbord> listContact = jdbcTemplate.query(sql, new RowMapper<Dashbord>() {

			@Override
			public Dashbord mapRow(ResultSet rs, int rowNum) throws SQLException {
				Dashbord aContact = new Dashbord();
	
				aContact.setPending_claims(rs.getInt("pending_claims"));
				aContact.setApproved_claims(rs.getInt("approved_claims"));
				aContact.setTotal_claims(rs.getInt("total_claims"));
				aContact.setRejected_claims(rs.getInt("rejected_claims"));
				System.out.println(rs.getInt("approved_claims")+"approved claims");

				return aContact;
			}
			
		});
		
		return listContact;
	}
	
	
	@Override
	public List<Dashbord> DashbordDealerCount_List(int user_id) {
		String sql = "SELECT PENDING_SR, SUBMITTED_SR, CONVERTED_SR, TOTAL_SR, "
				+ "APPROVED_CLAIMS, REJECTED_CLAIMS, INPROCESS_CLAIMS, TOTAL_CLAIMS "
				+ "FROM (SELECT COUNT(SRH.SERVICE_REQUEST_ID) PENDING_SR "
				+ "FROM KOEL_SERVICE_REQUEST_HEADER SRH, KOEL_DISTRIBUTOR_MASTER KDM "
				+ "WHERE SRH.SERVICED_BY = KDM.DISTRIBUTOR_ID AND SRH.SERVICE_REQUEST_STATUS = 'Created' "
				+ "AND KDM.USER_ID = "+user_id+"), "
				+ "(SELECT COUNT(SRH.SERVICE_REQUEST_ID) SUBMITTED_SR "
				+ "FROM KOEL_SERVICE_REQUEST_HEADER SRH, KOEL_DISTRIBUTOR_MASTER KDM "
				+ "WHERE SRH.SERVICED_BY = KDM.DISTRIBUTOR_ID AND SRH.SERVICE_REQUEST_STATUS = 'Submitted' "
				+ "AND KDM.USER_ID = "+user_id+"), "
				+ "(SELECT COUNT(SRH.SERVICE_REQUEST_ID) CONVERTED_SR "
				+ "FROM KOEL_SERVICE_REQUEST_HEADER SRH, KOEL_DISTRIBUTOR_MASTER KDM "
				+ "WHERE SRH.SERVICED_BY = KDM.DISTRIBUTOR_ID AND SRH.SERVICE_REQUEST_STATUS = 'Claimed' "
				+ "AND KDM.USER_ID = "+user_id+"), "
				+ "(SELECT COUNT(SRH.SERVICE_REQUEST_ID) TOTAL_SR "
				+ "FROM KOEL_SERVICE_REQUEST_HEADER SRH, KOEL_DISTRIBUTOR_MASTER KDM "
				+ "WHERE SRH.SERVICED_BY = KDM.DISTRIBUTOR_ID AND KDM.USER_ID = "+user_id+"), "
				+ "(SELECT COUNT(KCH.CLAIM_HEADER_ID) APPROVED_CLAIMS "
				+ "FROM KOEL_CLAIM_HEADER KCH, KOEL_DISTRIBUTOR_MASTER KDM "
				+ "WHERE KCH.SERVICED_BY = KDM.DISTRIBUTOR_ID AND KCH.CLAIM_STATUS = 'Approved' "
				+ "AND KDM.USER_ID = "+user_id+"), "
				+ "(SELECT COUNT(KCH.CLAIM_HEADER_ID) REJECTED_CLAIMS "
				+ "FROM KOEL_CLAIM_HEADER KCH, KOEL_DISTRIBUTOR_MASTER KDM "
				+ "WHERE KCH.SERVICED_BY = KDM.DISTRIBUTOR_ID AND KCH.CLAIM_STATUS = 'Rejected' "
				+ "AND KDM.USER_ID = "+user_id+"), "
				+ "(SELECT COUNT(KCH.CLAIM_HEADER_ID) INPROCESS_CLAIMS "
				+ "FROM KOEL_CLAIM_HEADER KCH, KOEL_DISTRIBUTOR_MASTER KDM "
				+ "WHERE KCH.SERVICED_BY = KDM.DISTRIBUTOR_ID AND KCH.CLAIM_STATUS = 'In Process' "
				+ "AND KDM.USER_ID = "+user_id+"), "
				+ "(SELECT COUNT(KCH.CLAIM_HEADER_ID) TOTAL_CLAIMS "
				+ "FROM KOEL_CLAIM_HEADER KCH, KOEL_DISTRIBUTOR_MASTER KDM "
				+ "WHERE KCH.SERVICED_BY = KDM.DISTRIBUTOR_ID AND KDM.USER_ID = "+user_id+")";
		List<Dashbord> listContact = jdbcTemplate.query(sql, new RowMapper<Dashbord>() {

			@Override
			public Dashbord mapRow(ResultSet rs, int rowNum) throws SQLException {
				Dashbord aContact = new Dashbord();
	
				aContact.setPending_srdealer(rs.getInt("PENDING_SR"));;
				aContact.setSubmitted_srdealer(rs.getInt("SUBMITTED_SR"));;
				aContact.setConverted_srdealer(rs.getInt("CONVERTED_SR"));;
				aContact.setTotal_srdealer(rs.getInt("TOTAL_SR"));;
				aContact.setApproved_claimsdealer(rs.getInt("APPROVED_CLAIMS"));;
				aContact.setRejected_claimsdealer(rs.getInt("REJECTED_CLAIMS"));;
				aContact.setInprocess_claimsdealer(rs.getInt("INPROCESS_CLAIMS"));;
				aContact.setTotal_claimsdealer(rs.getInt("TOTAL_CLAIMS"));;
				return aContact;
			}
			
		});
		
		return listContact;
	}
	

	@Override
	public List<Dashbord> DashbordSalesCount_List(int user_id) {
		String sql = "SELECT PENDING_SR, SUBMITTED_SR, CONVERTED_SR, TOTAL_SR, APPROVED_CLAIMS, REJECTED_CLAIMS, INPROCESS_CLAIMS, TOTAL_CLAIMS"
				+ " FROM (SELECT COUNT(SERVICE_REQUEST_ID) PENDING_SR FROM KOEL_SERVICE_REQUEST_HEADER WHERE SERVICE_REQUEST_STATUS = 'Created'), "
				+ "(SELECT COUNT(SERVICE_REQUEST_ID) SUBMITTED_SR FROM KOEL_SERVICE_REQUEST_HEADER WHERE SERVICE_REQUEST_STATUS = 'Submitted'), "
				+ "(SELECT COUNT(SERVICE_REQUEST_ID) CONVERTED_SR FROM KOEL_SERVICE_REQUEST_HEADER WHERE SERVICE_REQUEST_STATUS = 'Claimed'), "
				+ "(SELECT COUNT(SERVICE_REQUEST_ID) TOTAL_SR FROM KOEL_SERVICE_REQUEST_HEADER), (SELECT COUNT(CLAIM_HEADER_ID) APPROVED_CLAIMS "
				+ "FROM KOEL_CLAIM_HEADER WHERE CLAIM_STATUS = 'Approved'), (SELECT COUNT(CLAIM_HEADER_ID) REJECTED_CLAIMS FROM KOEL_CLAIM_HEADER "
				+ "WHERE CLAIM_STATUS = 'Rejected'), (SELECT COUNT(CLAIM_HEADER_ID) INPROCESS_CLAIMS FROM KOEL_CLAIM_HEADER WHERE CLAIM_STATUS ="
				+ "'In Process'), (SELECT COUNT(CLAIM_HEADER_ID) TOTAL_CLAIMS FROM KOEL_CLAIM_HEADER)";
		List<Dashbord> listContact = jdbcTemplate.query(sql, new RowMapper<Dashbord>() {

			@Override
			public Dashbord mapRow(ResultSet rs, int rowNum) throws SQLException {
				Dashbord aContact = new Dashbord();
	
				aContact.setPending_srsales(rs.getInt("PENDING_SR"));
				aContact.setSubmitted_srsales(rs.getInt("SUBMITTED_SR"));
				aContact.setConverted_srsales(rs.getInt("CONVERTED_SR"));
				aContact.setTotal_srsales(rs.getInt("TOTAL_SR"));
				aContact.setApproved_claimssales(rs.getInt("APPROVED_CLAIMS"));
				aContact.setTotal_claimssales(rs.getInt("TOTAL_CLAIMS"));
				aContact.setRejected_claimssales(rs.getInt("REJECTED_CLAIMS"));
				aContact.setInprocess_claimssales(rs.getInt("INPROCESS_CLAIMS"));
				return aContact;
			}
			
		});
		
		return listContact;
	}
	
	
	
	@Override
	public List<AdminCount> AdminCount_List() {
		String sql = "SELECT DIST.DISTRIBUTOR_NAME,NVL(OPNSR.OPEN_SR, 0) OPEN_SR,NVL(OPNCLM.OPEN_CLAIMS, 0) OPEN_CLAIMS,NVL(CLSDCLM.CLOSED_CLAIMS, 0) CLOSED_CLAIMS,NVL(RJCTDCLM.REJECTED_CLAIMS, 0) REJECTED_CLAIMS,NVL(INSTPRF.INSTALLED_PRF, 0) INSTALLED_PRF FROM (SELECT  KDM.DISTRIBUTOR_ID,COUNT(SRH.SERVICE_REQUEST_ID) OPEN_SR FROM KOEL_DISTRIBUTOR_MASTER KDM, KOEL_SERVICE_REQUEST_HEADER SRH WHERE KDM.DISTRIBUTOR_ID = SRH.SERVICED_BY AND SRH.SERVICE_REQUEST_STATUS = 'Submitted' GROUP BY KDM.DISTRIBUTOR_ID) OPNSR, (SELECT  KDM.DISTRIBUTOR_ID, COUNT(KCH.CLAIM_HEADER_ID) OPEN_CLAIMS FROM KOEL_DISTRIBUTOR_MASTER KDM, KOEL_CLAIM_HEADER KCH WHERE KDM.DISTRIBUTOR_ID = KCH.SERVICED_BY AND KCH.CLAIM_STATUS = 'Entered' GROUP BY KDM.DISTRIBUTOR_ID) OPNCLM, (SELECT  KDM.DISTRIBUTOR_ID, COUNT(KCH.CLAIM_HEADER_ID) CLOSED_CLAIMS FROM KOEL_DISTRIBUTOR_MASTER KDM, KOEL_CLAIM_HEADER KCH WHERE KDM.DISTRIBUTOR_ID = KCH.SERVICED_BY AND KCH.CLAIM_STATUS = 'Approved' GROUP BY KDM.DISTRIBUTOR_ID) CLSDCLM, (SELECT  KDM.DISTRIBUTOR_ID, COUNT(KCH.CLAIM_HEADER_ID) REJECTED_CLAIMS FROM KOEL_DISTRIBUTOR_MASTER KDM, KOEL_CLAIM_HEADER KCH WHERE KDM.DISTRIBUTOR_ID = KCH.SERVICED_BY AND KCH.CLAIM_STATUS = 'Rejected' GROUP BY KDM.DISTRIBUTOR_ID) RJCTDCLM, (SELECT  KDM.DISTRIBUTOR_ID, COUNT(KID.INSTANCE_ID) INSTALLED_PRF FROM KOEL_DISTRIBUTOR_MASTER KDM, KOEL_INSTANCE_DETAILS KID WHERE KDM.DISTRIBUTOR_ID = KID.SERVICED_BY AND KID.INSTANCE_STATUS = 'Installed' GROUP BY KDM.DISTRIBUTOR_ID) INSTPRF, KOEL_DISTRIBUTOR_MASTER DIST WHERE DIST.DISTRIBUTOR_ID = OPNSR.DISTRIBUTOR_ID(+) AND DIST.DISTRIBUTOR_ID = OPNCLM.DISTRIBUTOR_ID(+) AND DIST.DISTRIBUTOR_ID = CLSDCLM.DISTRIBUTOR_ID(+) AND DIST.DISTRIBUTOR_ID = RJCTDCLM.DISTRIBUTOR_ID(+) AND DIST.DISTRIBUTOR_ID = INSTPRF.DISTRIBUTOR_ID(+)";
		List<AdminCount> listContact = jdbcTemplate.query(sql, new RowMapper<AdminCount>() {

			@Override
			public AdminCount mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminCount aContact = new AdminCount();
	
				aContact.setDistributor_name(rs.getString("DISTRIBUTOR_NAME"));
				aContact.setOpen_claim(rs.getInt("OPEN_CLAIMS"));
				aContact.setOpen_sr(rs.getInt("OPEN_SR"));
				aContact.setClosed_claim(rs.getInt("CLOSED_CLAIMS"));
				aContact.setRejected_claim(rs.getInt("REJECTED_CLAIMS"));
				aContact.setInstalled_prf(rs.getInt("INSTALLED_PRF"));
		
				return aContact;
			}
			
		});
		
		return listContact;
	}


//---------------------------------------------------Dashboard dsign-------------------------------------------------------------	
	
	@Override
	public ArrayList<New_Scheme_mstr> active_scheme(int profile_id, int userid) {
		
		
	//	old code //ArrayList<Bpil_Dealer_Master> dml = (ArrayList<Bpil_Dealer_Master>) hibernateTemplate.find("from Bpil_Dealer_Master where user_id=?",userid);
		ArrayList<Bpil_Dealer_Master> dml = (ArrayList<Bpil_Dealer_Master>) hibernateTemplate.find("from Bpil_Dealer_Master where dealer_code = "+userid);
		
		String deptcode = dml.get(0).getDepot_code();
		System.out.println("depot code="+deptcode);
		
		
		ArrayList<Bpil_Depot_Master> dml1 = (ArrayList<Bpil_Depot_Master>) hibernateTemplate.find("from Bpil_Depot_Master where depot_code='"+deptcode+"'");
		String region_code = dml1.get(0).getRegn();
		System.out.println("depot code="+region_code);
		
		String sql = "SELECT SCHEME_ID,SCHEME_CODE,SCHEME_NAME,ACTIVE_FLAG,START_DATE,END_DATE FROM BPIL_SCHEME_MASTER WHERE ACTIVE_FLAG='Active' AND APPL_REGN_CODE ='"+region_code+"' ORDER BY SCHEME_ID DESC";
			
		List<New_Scheme_mstr> obj = jdbcTemplate.query(sql, new RowMapper<New_Scheme_mstr>() {

			@Override
			public New_Scheme_mstr mapRow(ResultSet rs, int rowNum) throws SQLException {
				New_Scheme_mstr aContact = new New_Scheme_mstr();
	
				aContact.setScheme_id(rs.getInt("SCHEME_ID"));
				aContact.setScheme_code(rs.getString("SCHEME_CODE"));
				aContact.setScheme_name(rs.getString("SCHEME_NAME"));
				aContact.setActive_flag(rs.getString("ACTIVE_FLAG"));
				
				if(rs.getDate("START_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("START_DATE"));
					aContact.setStart_date1(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("START_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}
				
				if(rs.getDate("END_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("END_DATE"));
					aContact.setEnd_date1(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("END_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}		
						
				
				return aContact;
			}
			
		});				
		
		return  (ArrayList<New_Scheme_mstr>) obj;
	
	
	}
	
	//--------------------------------------------------End -Dashboard dsign-------------------------------------------------------------	

	
	
	
	}



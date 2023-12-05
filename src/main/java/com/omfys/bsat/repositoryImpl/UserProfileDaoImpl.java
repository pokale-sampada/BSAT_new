package com.omfys.bsat.repositoryImpl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.repository.UserProfileDao;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.model.Bpil_Users;
@Repository("UserProfileDao")
public class UserProfileDaoImpl implements UserProfileDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private TilesConfiguration hibernateConfiguration;
	
	public List<Bpil_Users> getUserData(int user_id)
	{
				
		String sql="SELECT USER_ID,USER_NAME,USER_TYPE,FIRST_NAME,MIDDLE_NAME,LAST_NAME,EMAIL_ADDRESS,CONTACT_NUMBER,CREATION_DATE FROM BPIL_USERS WHERE USER_ID=";

		List<Bpil_Users> user_data = jdbcTemplate.query(sql+user_id, new RowMapper<Bpil_Users>() {

			@Override
			public Bpil_Users mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
				
				Bpil_Users user_details = new Bpil_Users();
				
				user_details.setUser_id(rs.getInt("USER_ID"));
				user_details.setUser_type(rs.getString("USER_TYPE"));
				user_details.setUser_name(rs.getString("USER_NAME"));
				user_details.setFirst_name(rs.getString("FIRST_NAME"));
				user_details.setMiddle_name(rs.getString("MIDDLE_NAME"));
				user_details.setLast_name(rs.getString("LAST_NAME"));
				user_details.setEmail_address(rs.getString("EMAIL_ADDRESS"));
				user_details.setContact_number(rs.getString("CONTACT_NUMBER"));
				user_details.setCreation_date(rs.getDate("CREATION_DATE"));
				return user_details;
				
				
			}
			
		});
		
		return user_data;
		
	}
	
	@Override
	public String updateuser(int user_id,int id,String s1)
	{
		String message=null;
					
			CallableStatement cStmt;
			try {
			cStmt = hibernateConfiguration.dataSource().getConnection()
				.prepareCall("{call BPIL_SP_ACT_DEACT_USER(?,?,?,?)}");
			cStmt.setInt(1, user_id );		
			cStmt.setInt(2, id );	
			cStmt.setString(3,s1 );
			cStmt.registerOutParameter(4,Types.VARCHAR);  
			

			//cStmt.registerOutParameter(4, OracleTypes.CURSOR);
			ResultSet result = cStmt.executeQuery();
			message=cStmt.getString(4);		

				
			} catch (SQLException e) {
			e.printStackTrace();
			}
			catch (Exception e) {
			System.out.println(e.getMessage());
			}
			
	return message;
		
	}
	

//	String query="update Koel_Users set is_active='"+s1+"' where user_id='"+id+"' ";
	
	//return jdbcTemplate.update(query);
	
	
	/////////////////////////////////////my code start from here////////////////////////////////////////////
	@Override
	public List<Bpil_Users> getUsers()
	{
		
		String sql="SELECT USER_ID,USER_NAME,ATTRIBUTE1,FIRST_NAME,LAST_NAME,EMAIL_ADDRESS,CONTACT_NUMBER,IS_ACTIVE FROM BPIL_USERS";

		List<Bpil_Users> user_data = jdbcTemplate.query(sql, new RowMapper<Bpil_Users>() {

			@Override
			public Bpil_Users mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
				
				Bpil_Users user_details = new Bpil_Users();
				
				user_details.setUser_id(rs.getInt("USER_ID"));
				user_details.setUser_name(rs.getString("USER_NAME"));
				user_details.setSource(rs.getString("ATTRIBUTE1"));
				user_details.setFirst_name(rs.getString("FIRST_NAME"));
				//user_details.setMiddle_name(rs.getString("MIDDLE_NAME"));
				user_details.setLast_name(rs.getString("LAST_NAME"));
				user_details.setEmail_address(rs.getString("EMAIL_ADDRESS"));
				user_details.setContact_number(rs.getString("CONTACT_NUMBER"));
				user_details.setIs_active(rs.getString("IS_ACTIVE"));
				//user_details.setCreation_date(rs.getDate("CREATION_DATE"));
				return user_details;
				
				
			}
			
		});
		
		return user_data;

	}
	

}

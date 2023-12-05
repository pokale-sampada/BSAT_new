package com.omfys.bsat.repositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

import org.hibernate.validator.internal.util.Contracts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.model.HierarchySetUp;
import com.omfys.bsat.model.HierarchySetUp1;
import com.omfys.bsat.repository.ForgotPasswordDao;
import com.omfys.bsat.model.Bpil_Users;

@Repository("ForgotPasswordDao")
public class ForgotPasswordDaoImpl implements ForgotPasswordDao 
{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	
int i=1;

	@Override
	public List<Bpil_Users> ForgotPassword_List(String user_name)  {
		Bpil_Users Contact=new Bpil_Users();
		String sql = "select password,EMAIL_ADDRESS from BPIL_USERS where user_name='"+user_name+"'";
	
		List<Bpil_Users> ForgotPassword_List = jdbcTemplate.query(sql, new RowMapper<Bpil_Users>() {			
			
			@Override
			public Bpil_Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_Users	 aContact = new Bpil_Users();
				
				 i++;
			//	if(rs.getString("password")!=null && rs.getString("EMAIL_ADDRESS")!=null)
			//	{
					aContact.setPassword(rs.getString("password"));
					aContact.setEmail_address(rs.getString("EMAIL_ADDRESS"));
					
				//	System.out.println("password iffff"+rs.getString("password"));
				//	System.out.println("email iffff:"+rs.getString("EMAIL_ADDRESS"));
				//}
				//else
				//{
				//	aContact.setPassword("no_password");
				//	aContact.setEmail_address("no_email");
					
				//	System.out.println("password "+rs.getString("password"));
				//	System.out.println("email :"+rs.getString("EMAIL_ADDRESS"));
				//}									
			
				//System.out.println("forgot password run");
				
				
				return aContact;
			}
					
		});
		
		if(i==1)
		{
			//ForgotPassword_List.set(0).("no_email");
			Contact.setPassword("no_password");
			Contact.setEmail_address("no_email");
			
		}
		ForgotPassword_List.add(Contact);
		
		System.out.println("forgot password run");
		return ForgotPassword_List;
	}

	

}

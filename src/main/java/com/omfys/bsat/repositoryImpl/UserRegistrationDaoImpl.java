package com.omfys.bsat.repositoryImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.LookupAutofill;
import com.omfys.bsat.repository.UserRegistrationDao;
import com.omfys.bsat.model.Bpil_LookupValues;

@Repository("UserRegistrationDao")
public class UserRegistrationDaoImpl  implements UserRegistrationDao {
	
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int CreateUser(Bpil_Users Koel_user,int userid) {
		int userid1=Koel_user.getUser_id();
		
		if(userid1==0)
		{
				hibernateTemplate.saveOrUpdate(Koel_user);
		}
		else
		{
			Koel_user.setUser_id(userid);
			hibernateTemplate.saveOrUpdate(Koel_user);
		
		}
		return Koel_user.getUser_id();
	}
	
	public List<Bpil_Users> SearchUser(String user_name)
	 {
		 System.out.println("in dao");

		 String name=null;
		 
		 ArrayList<Bpil_Users> dml = (ArrayList<Bpil_Users>)hibernateTemplate.find("FROM Bpil_Users where user_name = "+"'"+user_name+"'");
		
		 int len =dml.size();
		 System.out.println("in dao="+len);
		 for(int i=0; i<dml.size(); i++)
			{
				name = dml.get(0).getUser_name();
				
				
				System.out.println("user name  "+name);
				System.out.println("Password "+dml.get(0).getPassword());
				System.out.println("Email  "+dml.get(0).getEmail_address());
				System.out.println("user name  "+name);
				System.out.println("user name sujit  "+dml.get(0).getIs_active());

			}
		return dml;
	 }

	public List<LookupAutofill> findrole(int newuserId)
	{
		String name="Roles";
		String sql="SELECT USER_ROLE_ASSIGNMENT_ID,USER_ID,ROLE,ENABLE_FLAG,END_DATE FROM BPIL_USER_ROLE_ASSIGNMENTS WHERE USER_ID ='"+newuserId+"'";	

		List<LookupAutofill> rolelist = jdbcTemplate.query(sql, new RowMapper<LookupAutofill>() {

			@Override
			public LookupAutofill mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				System.out.println("in dao impl");

				LookupAutofill roledata = new LookupAutofill();
	
				roledata.setUser_role_assignment_id(rs.getInt("USER_ROLE_ASSIGNMENT_ID"));
				roledata.setUser_id(rs.getInt("USER_ID"));	
				roledata.setRole(rs.getString("ROLE"));	
				roledata.setEnable_flag(rs.getString("ENABLE_FLAG"));	
				
				if(rs.getDate("END_DATE")!=null)
				{
					DateFormat ser33 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr33 = ser33.format(rs.getDate("END_DATE"));
					roledata.setEnd_date(dateStr33);	
					try {
						System.out.println(ser33.parse(rs.getString("END_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
					System.out.println("datttttttttttttttttttttt="+roledata.getEnd_date());
				}
					

				return roledata;
			}
			
		});
		
		return rolelist;
	}

	@Override
	public List<Bpil_Users> getAllUsers() {
		List<Bpil_Users> users=null;
		Transaction tx = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		
		try{
			tx = session.beginTransaction();
			
			String query = "from Bpil_Users";
			Query sql = session.createQuery(query);
			users = sql.list();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return users;
	}

	@Override
	public Bpil_Users getUserByUsername(String username) {
		Bpil_Users users=null;
		Transaction tx = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		
		try{
			tx = session.beginTransaction();
			
			String query = "from Bpil_Users where user_name = :username";
			Query sql = session.createQuery(query);
			sql.setParameter("username", username);
			users = (Bpil_Users) sql.uniqueResult();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return users;
	}

	@Override
	public boolean updateUser(Bpil_Users user) {
		Transaction tx = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		
		try{
			tx = session.beginTransaction();
			session.update(user);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return false;
	}
}
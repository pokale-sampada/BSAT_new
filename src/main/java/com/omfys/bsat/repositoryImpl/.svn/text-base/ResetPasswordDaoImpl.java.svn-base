package com.omfys.bsat.repositoryImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.repository.ResetPasswordDao;
import com.omfys.bsat.model.Bpil_Users_Autofill;
@Repository("ResetPasswordDao")
public class ResetPasswordDaoImpl  implements ResetPasswordDao {
	
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int CreateUser(Bpil_Users_Autofill Koel_user,int userid) {
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
	
	public List<Bpil_Users_Autofill> SearchUser(String user_name)
	 {
		 System.out.println("in dao");

		 String name;
		 
		 ArrayList<Bpil_Users_Autofill> dml = (ArrayList<Bpil_Users_Autofill>)hibernateTemplate.find("FROM Bpil_Users_Autofill where user_name =?",user_name);
		
		 int len =dml.size();
		 System.out.println("in dao="+len);
		 for(int i=0; i<dml.size(); i++)
			{
				name = dml.get(0).getUser_name();
				System.out.println("user name exist"+name);				
				System.out.println("user name  "+name);
				
			}
		return dml;
	 }

}
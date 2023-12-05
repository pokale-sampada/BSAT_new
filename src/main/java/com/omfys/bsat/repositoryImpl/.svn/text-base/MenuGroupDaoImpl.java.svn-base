package com.omfys.bsat.repositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.omfys.bsat.repository.MenuGroupDao;
import com.omfys.bsat.model.Bpil_Bsat_Defaults;
import com.omfys.bsat.model.Bpil_LookupValues;
import com.omfys.bsat.model.Bpil_MenuGroup;
import com.omfys.bsat.model.Bpil_Menu_FunRegi;
import com.omfys.bsat.model.Bpil_Menu_Header;
import com.omfys.bsat.model.Bpil_Menu_Line;
import com.omfys.bsat.model.Bpil_Report_FunRegi;

@Repository("MenuGroupDao")
public class MenuGroupDaoImpl implements MenuGroupDao
{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional
	public int saveGroup(Bpil_MenuGroup menugroup)
	{
		System.out.println(" in daoimpl");

		hibernateTemplate.saveOrUpdate(menugroup);
		return 1;
	}

	@Override
	@Transactional
	public int saveHeader(Bpil_Menu_Header menuheaderline) {
		System.out.println("in dao");
		hibernateTemplate.saveOrUpdate(menuheaderline);
		return menuheaderline.getMenu_header_id();
	}

	@Override
	@Transactional
	public int saveHeaderLine(int id,int count, String[] submenu, String[] status,String menu_line_id[],int userid) {
		// TODO Auto-generated method stub
		
		int id1=0;
		for (int i = 0; i < count; i++)
		{
			Bpil_Menu_Line val=new Bpil_Menu_Line();
			System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiii"+i);
			
			if(menu_line_id[i].length()>0 && menu_line_id[i]!=null)
			{
				 id1 =Integer.parseInt(menu_line_id[i]);
			}
			else
			{
				id1 = val.getMenu_line_id();
			}
//			
//			if(submenu[i]!= null && submenu[i].length()>0)
//			{					
//				
			
			val.setMenu_header_id(id);
			val.setMenu_line_id(id1);
			val.setLine_name(submenu[i]);
			val.setActive(status[i]);
			val.setCreated_by(userid);
			val.setLast_updated_by(userid);
			hibernateTemplate.saveOrUpdate(val);
//			}
		}
		
		return 1;
	}

	@Override
	@Transactional
	public int savedata3(String[] menu_function_id, String[] menu_line_id, String[] function_name,
			String[] function_action_name, String[] active) {

		
		System.out.println("in dao");
		int infonum=0;
		System.out.println("dfhgvdfyh");
		System.out.println("llllllllllllllllllllllllllllllllllllll "+function_action_name.length);
		for(int i=0;i<function_action_name.length;i++)
		{
			System.out.println("start");
			Bpil_Menu_FunRegi brl=new Bpil_Menu_FunRegi();
			
				if(menu_function_id[i].length()>0 && menu_function_id[i]!=null)
				{
					System.out.println("in if");
					infonum = Integer.parseInt(menu_function_id[i]);
				}
				else
				{
					System.out.println("in else");
					infonum = brl.getMenu_function_id();
				}
				System.out.println("info num is _____________________"+infonum);
				brl.setMenu_line_id(Integer.parseInt(menu_line_id[i]));
				brl.setMenu_function_id(infonum);
				
				brl.setFunction_action_name(function_action_name[i]);
				brl.setActive(active[i]);			
				brl.setFunction_name(function_name[i]);
				
				
//				brl.setCreated_by(created_by);				
//				brl.setLast_updated_by(last_updated_by);
//				
				
				hibernateTemplate.saveOrUpdate(brl);
				
		}
		return 1;
	
	}
	
	
	/// grid autofill 
			public List<Bpil_MenuGroup> grid1()
			{
				String sql = "SELECT MENU_GROUP_ID,GROUP_NAME,GROUP_DESCRIPTION,ACTIVE,GROUP_START_DATE,GROUP_END_DATE FROM BPIL_MENU_GROUP ";
				List<Bpil_MenuGroup> listContact = jdbcTemplate.query(sql, new RowMapper<Bpil_MenuGroup>() {

					@Override
					public Bpil_MenuGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
						Bpil_MenuGroup aContact = new Bpil_MenuGroup();
			
						aContact.setMenu_group_id(rs.getInt("MENU_GROUP_ID"));
						aContact.setGroup_name(rs.getString("GROUP_NAME"));
						aContact.setActive(rs.getString("ACTIVE"));
						aContact.setGroup_description(rs.getString("GROUP_DESCRIPTION"));
						if(rs.getDate("GROUP_START_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("GROUP_START_DATE"));
							System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSTART"+dateStr1);
							aContact.setGroup_start_date1(dateStr1);	
							try {
								System.out.println(ser1.parse(rs.getString("GROUP_START_DATE")));
							} catch (ParseException e) {
									e.printStackTrace();
							}
						}
						
						if(rs.getDate("GROUP_END_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("GROUP_END_DATE"));
							aContact.setGroup_end_date1(dateStr1);	
							System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSTART"+dateStr1);

							try {
								System.out.println(ser1.parse(rs.getString("GROUP_END_DATE")));
							} catch (ParseException e) {
									e.printStackTrace();
							}
						}		
								
						
						return aContact;
					}
					
				});
				
				return listContact;
			}	
			
			
			
			
			
				
			/// grid autofill 
			public List<Bpil_Menu_Header> grid2()
			{
				String sql = "SELECT MENU_HEADER_ID,HEADER_NAME,HEADER_ACTIVE,CREATION_DATE,HEADER_END_DATE FROM BPIL_MENU_HEADER ";
				List<Bpil_Menu_Header> listContact = jdbcTemplate.query(sql, new RowMapper<Bpil_Menu_Header>() {

					@Override
					public Bpil_Menu_Header mapRow(ResultSet rs, int rowNum) throws SQLException {
						Bpil_Menu_Header aContact = new Bpil_Menu_Header();
			
						aContact.setMenu_header_id(rs.getInt("MENU_HEADER_ID"));
						aContact.setHeader_name(rs.getString("HEADER_NAME"));
						aContact.setHeader_active(rs.getString("HEADER_ACTIVE"));
						
						if(rs.getDate("CREATION_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("CREATION_DATE"));
							System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSTART"+dateStr1);
							aContact.setHeader_start_date1(dateStr1);	
							try {
								System.out.println(ser1.parse(rs.getString("CREATION_DATE")));
							} catch (ParseException e) {
									e.printStackTrace();
							}
						}
						
						if(rs.getDate("HEADER_END_DATE")!=null)
						{
							DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
							String dateStr1 = ser1.format(rs.getDate("HEADER_END_DATE"));
							aContact.setHeader_end_date1(dateStr1);	
							System.out.println("SSSSSSSSSEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEND"+dateStr1);

							try {
								System.out.println(ser1.parse(rs.getString("HEADER_END_DATE")));
							} catch (ParseException e) {
									e.printStackTrace();
							}
						}		
								
						
						return aContact;
					}
					
				});
				
				return listContact;
			}

			@Override
			public boolean saveDefaults(Bpil_Bsat_Defaults defaults) {
				Transaction tx = null;
				Session session = hibernateTemplate.getSessionFactory().openSession();
				try{
					tx = session.beginTransaction();
					session.saveOrUpdate(defaults);
					
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

			@Override
			public Bpil_Bsat_Defaults getDefaults() {
				Transaction tx = null;
				Bpil_Bsat_Defaults defaults = null;
				Session session = hibernateTemplate.getSessionFactory().openSession();
				try{
					tx = session.beginTransaction();
					String query = "from Bpil_Bsat_Defaults";
					Query sql = session.createQuery(query);
					defaults = (Bpil_Bsat_Defaults) sql.uniqueResult();
					
					return defaults;
				}catch(Exception e){
					e.printStackTrace();
				}finally {
					tx.commit();
					session.close();
					System.gc();
				}
				return defaults;
			}	

}

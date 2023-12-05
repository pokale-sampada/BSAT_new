package com.omfys.bsat.repositoryImpl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.omfys.bsat.repository.BpilLoginDao;
import com.omfys.bsat.TilesConfiguration;
import com.omfys.bsat.controller.UserRegistration_Controller;
import com.omfys.bsat.model.ADList;
import com.omfys.bsat.model.BPIL_MENU;
import com.omfys.bsat.model.Bpil_Main_Menu;
import com.omfys.bsat.model.Bpil_Menu_Header;
import com.omfys.bsat.model.Bpil_Menu_Line;
import com.omfys.bsat.model.Bpil_Sub_Menu;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.Student;

import oracle.jdbc.OracleTypes;
import sun.misc.BASE64Encoder;

@Repository("BpilLoginDao")
public class BpilLoginDaoImpl implements BpilLoginDao {

//	@Autowired
//	SessionFactory sessionFactory;

	@Autowired
	HibernateTemplate hibernatetemplate;

	@Autowired
	private TilesConfiguration hibernateConfiguration;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static final String ALGORITHM = "AES";
	public static final String KEY = "1Hbfh667adfDEJ78";

	@Override
	@Transactional
	public List<Bpil_Users> getUser(Bpil_Users kwm_users) {

		String username = kwm_users.getUser_name();
		String password = kwm_users.getPassword();
		System.out.println("login doa " + username + " " + password);
		///////////////////// edit code for check encrypted password
		///////////////////// ////////////////////////////////////

		Key key = null;
		Cipher cipher = null;
		try {
			key = generateKey();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			cipher = Cipher.getInstance(UserRegistration_Controller.ALGORITHM);
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
			encryptedByteValue = cipher.doFinal(password.getBytes("utf-8"));
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
		String encryptedValue = new BASE64Encoder().encode(encryptedByteValue);
		System.out.println(encryptedValue);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		String sql = "SELECT USER_ID, USER_NAME,FIRST_NAME,LAST_NAME, PROFILE_ID,USER_TYPE,ATTRIBUTE2, PMG_ML_GROUP, ACTIVE_DIRECTORY_ID  FROM BPIL_USERS WHERE USER_NAME = '"
				+ kwm_users.getUser_name() + "' AND PASSWORD = '" + encryptedValue
				+ "' AND IS_ACTIVE = 'Y' AND ACTIVE_DIRECTORY_ID IS NULL";

		List<Bpil_Users> Koel_User = jdbcTemplate.query(sql, new RowMapper<Bpil_Users>() {

			@Override
			public Bpil_Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_Users koel_Users = new Bpil_Users();

				koel_Users.setUser_id(rs.getInt("USER_ID"));
				koel_Users.setUser_name(rs.getString("USER_NAME"));
				koel_Users.setProfile_id(rs.getInt("PROFILE_ID"));
				koel_Users.setUser_type(rs.getString("USER_TYPE"));
				koel_Users.setFirst_name(rs.getString("FIRST_NAME"));
				koel_Users.setLast_name(rs.getString("LAST_NAME"));
				koel_Users.setAttribute2(rs.getDate("ATTRIBUTE2"));
				koel_Users.setPmg_ml_group(rs.getString("PMG_ML_GROUP"));
				koel_Users.setActive_directory_id(rs.getString("ACTIVE_DIRECTORY_ID"));

				System.out.println("user id----------------------------------------------" + rs.getInt("USER_ID"));
				System.out
						.println("user name---------------------------------------------" + rs.getString("USER_NAME"));

				return koel_Users;
			}

		});
		System.out.println("Out from dao---" + Koel_User.size());

		return Koel_User;
	}

	@Override
	public List<Bpil_Users> list(Bpil_Users kwm_users) {
		String sql = "SELECT USER_ID, USER_NAME,  PROFILE_ID,USER_TYPE  FROM BPIL_USERS WHERE USER_NAME = '"
				+ kwm_users.getUser_name() + "' AND PASSWORD = '" + kwm_users.getPassword() + "'";
		List<Bpil_Users> listContact = jdbcTemplate.query(sql, new RowMapper<Bpil_Users>() {

			@Override
			public Bpil_Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_Users koel_Users = new Bpil_Users();

				koel_Users.setUser_id(rs.getInt("USER_ID"));
				koel_Users.setUser_name(rs.getString("USER_NAME"));
				koel_Users.setProfile_id(rs.getInt("PROFILE_ID"));
				koel_Users.setUser_type(rs.getString("USER_TYPE"));

				return koel_Users;
			}

		});

		return listContact;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Bpil_Main_Menu> getMenuGroup(int profile_id) {
		// TODO Auto-generated method stub
//		ArrayList<Kwm_Menu_Group> list=new ArrayList<Kwm_Menu_Group>();

//		String sql="from Menu_Header mh where user_id = ?";

		String sql = "SELECT MAIN_MENU_ID, PROFILE_ID, "
				+ "MAIN_MENU_NAME, MAIN_MENU_CTRLR_NAME, MAIN_MENU_ACTION_NAME,"
				+ " MAIN_MENU_ICON FROM BPIL_MAIN_MENU KMN WHERE KMN.PROFILE_ID = " + " " + Integer.toString(profile_id)
				+ " ORDER BY KMN.MAIN_MENU_ID";

		List<Bpil_Main_Menu> kwm_menu_groups = jdbcTemplate.query(sql, new RowMapper<Bpil_Main_Menu>() {

			@Override
			public Bpil_Main_Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_Main_Menu kwm_menu_group = new Bpil_Main_Menu();

				kwm_menu_group.setMain_menu_id(rs.getInt("MAIN_MENU_ID"));
				kwm_menu_group.setMain_menu_name(rs.getString("MAIN_MENU_NAME"));
				kwm_menu_group.setMain_menu_action_name(rs.getString("MAIN_MENU_ACTION_NAME"));
				kwm_menu_group.setMain_menu_icon(rs.getString("MAIN_MENU_ICON"));

				System.out.println(kwm_menu_group.getMain_menu_name());

				return kwm_menu_group;
			}
		});

//		list=(ArrayList<Kwm_Menu_Group>) hibernatetemplate.find(sql);

		return kwm_menu_groups;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Bpil_Menu_Header> getMenuGroup1(int userid) {
		// TODO Auto-generated method stub
//		ArrayList<Kwm_Menu_Group> list=new ArrayList<Kwm_Menu_Group>();

//		String sql="from Menu_Header mh where user_id = ?";

		/*
		 * String sql = "SELECT MAIN_MENU_ID, PROFILE_ID, " +
		 * "MAIN_MENU_NAME, MAIN_MENU_CTRLR_NAME, MAIN_MENU_ACTION_NAME," +
		 * " MAIN_MENU_ICON FROM BPIL_MAIN_MENU KMN WHERE KMN.PROFILE_ID = " +
		 * " "+Integer.toString(profile_id)+" ORDER BY KMN.MAIN_MENU_ID";
		 */

//		System.out.println("in menu group");
//		String sql="select * from BPIL_MENU_HEADER mh, BPIL_MENU_GROUP mg, BPIL_USER_ASSIGNMENTS ua "
//				+ " where  mh.MENU_GROUP_ID = mg.MENU_GROUP_ID and mg.MENU_GROUP_ID =  ua.MENU_GROUP_ID and ua.USER_ID = "+userid+""
//						+ " ORDER BY MENU_HEADER_ID ASC";
//=============================================================== Changes by shilpi

//		String sql = "select * from BPIL_MENU_HEADER mh, BPIL_MENU_GROUP mg, BPIL_USERS us " 
//				 +" where  mh.MENU_GROUP_ID = mg.MENU_GROUP_ID and mg.MENU_GROUP_ID =  us.MENU_GROUP_ID and us.USER_ID = "+userid+""
//						 +" ORDER BY MENU_HEADER_ID ASC";

		List<BPIL_MENU> str = new ArrayList<BPIL_MENU>();

		String sql2 = "select b.MENU_HEADER_ID ,b.SUBMENU from BPIL_MENU b where b.USER_ID=" + userid + "";

		System.out.println("before  --------------------------- assigning all the menu to user");
		str = jdbcTemplate.query(sql2, new RowMapper<BPIL_MENU>() {

			@Override
			public BPIL_MENU mapRow(ResultSet rs, int rowNum) throws SQLException {
				BPIL_MENU BPIL_MENU = new BPIL_MENU();
				BPIL_MENU.setMENU_HEADER_ID(rs.getString("MENU_HEADER_ID"));
				BPIL_MENU.setSUBMENU(rs.getString("SUBMENU"));
				System.out.println(rs.getString("MENU_HEADER_ID"));
				System.out.println(rs.getString("SUBMENU"));

				return BPIL_MENU;
			}
		});

		System.out.println("value2++++++++++++++ --------------------------------------" + str);
		System.out.println("value --------------------------------------" + str.size());
		String str2 = "";
		String str3 = "";

		String sql = "";
		if (str.size() != 0) {
			str2 = str.get(0).getMENU_HEADER_ID();
			str3 = str.get(0).getSUBMENU();

			System.out.println(str2 + "----------------------------str2");
			System.out.println(str3 + "----------------------------str2");

			sql = "select * from BPIL_MENU_HEADER mh, BPIL_MENU_GROUP mg, BPIL_USERS us "
					+ " where  mh.MENU_GROUP_ID = mg.MENU_GROUP_ID and mg.MENU_GROUP_ID =  us.MENU_GROUP_ID and us.USER_ID = "
					+ userid + "" + " and mh.MENU_HEADER_ID IN (" + str2 + ") and mh.HEADER_ACTIVE = 'Y' ORDER BY MENU_HEADER_ID ASC";

		} else {
			sql = "select * from BPIL_MENU_HEADER mh, BPIL_MENU_GROUP mg, BPIL_USERS us "
					+ " where  mh.MENU_GROUP_ID = mg.MENU_GROUP_ID and mg.MENU_GROUP_ID =  us.MENU_GROUP_ID and us.USER_ID = "
					+ userid + " and mh.HEADER_ACTIVE = 'Y' ORDER BY MENU_HEADER_ID ASC";
		}
		List<Bpil_Menu_Header> kwm_menu_groups = jdbcTemplate.query(sql, new RowMapper<Bpil_Menu_Header>() {
			@Override
			public Bpil_Menu_Header mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_Menu_Header kwm_menu_group = new Bpil_Menu_Header();
				kwm_menu_group.setMenu_header_id(rs.getInt("MENU_HEADER_ID"));
				kwm_menu_group.setHeader_name(rs.getString("HEADER_NAME"));
				kwm_menu_group.setAction_name(rs.getString("ACTION_NAME"));
				kwm_menu_group.setHeader_icon(rs.getString("HEADER_ICON"));
				return kwm_menu_group;
			}
		});

		return kwm_menu_groups;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Bpil_Menu_Line> getMenuLine(int menu_header_id) {
		System.out.println(menu_header_id+"      getMenuLine                            999999999999999999999999999999999999");
		ArrayList<Bpil_Menu_Line> list = new ArrayList<Bpil_Menu_Line>();
		String sql = "SELECT MENU_LINE_ID, MENU_HEADER_ID, LINE_NAME," + " ACTION_NAME, "
				+ "LINE_ICON FROM BPIL_MENU_LINES b WHERE b.MENU_HEADER_ID" + "= " + Integer.toString(menu_header_id)
				+ " " + " ORDER BY MENU_LINE_ID";

		List<Bpil_Menu_Line> kwm_menu_group_lines = jdbcTemplate.query(sql, new RowMapper<Bpil_Menu_Line>() {

			@Override
			public Bpil_Menu_Line mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_Menu_Line kwm_menu_group_line = new Bpil_Menu_Line();
				kwm_menu_group_line.setMenu_line_id(rs.getInt("MENU_LINE_ID"));
				kwm_menu_group_line.setMenu_header_id(rs.getInt("MENU_HEADER_ID"));
				kwm_menu_group_line.setAction_name(rs.getString("ACTION_NAME"));
				kwm_menu_group_line.setLine_name(rs.getString("LINE_NAME"));
				return kwm_menu_group_line;
			    }
		    });
		    return kwm_menu_group_lines;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Bpil_Sub_Menu> getSubMenuLine(int menu_group_id) {
		// TODO Auto-generated method stub
		ArrayList<Bpil_Sub_Menu> list = new ArrayList<Bpil_Sub_Menu>();
		String sql = "SELECT SUB_MENU_ID, MAIN_MENU_ID, SUB_MENU_NAME," + " SUB_MENU_CTRLR_NAME, SUB_MENU_ACTION_NAME, "
				+ "SUB_MENU_ICON FROM BPIL_SUB_MENU KSM WHERE MAIN_MENU_ID" + "= " + Integer.toString(menu_group_id)
				+ " " + "ORDER BY KSM.SUB_MENU_ID";

		List<Bpil_Sub_Menu> kwm_menu_group_lines = jdbcTemplate.query(sql, new RowMapper<Bpil_Sub_Menu>() {

			@Override
			public Bpil_Sub_Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_Sub_Menu kwm_menu_group_line = new Bpil_Sub_Menu();

				kwm_menu_group_line.setSub_menu_id(rs.getInt("SUB_MENU_ID"));
				kwm_menu_group_line.setMain_menu_id(rs.getInt("MAIN_MENU_ID"));
				kwm_menu_group_line.setSub_menu_name(rs.getString("SUB_MENU_NAME"));
				kwm_menu_group_line.setSub_menu_action_name(rs.getString("SUB_MENU_ACTION_NAME"));

				System.out.println(kwm_menu_group_line.getSub_menu_name());

				return kwm_menu_group_line;
			}
		});

//		list=(ArrayList<Kwm_Menu_Group_Line>) hibernatetemplate.find(sql);

		return kwm_menu_group_lines;
	}

	/////// password
	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(UserRegistration_Controller.KEY.getBytes(), UserRegistration_Controller.ALGORITHM);
		return key;
	}

	@Override
	public List<Bpil_Main_Menu> get_user_main_menu(int user_id) {

		List<Bpil_Main_Menu> list = new ArrayList<Bpil_Main_Menu>();
		CallableStatement cStmt;
		try {
			cStmt = hibernateConfiguration.dataSource().getConnection()
					.prepareCall("{call BPIL_SP_DERIVE_MAIN_MENU(?,?)}");
			cStmt.setInt(1, user_id);
			cStmt.registerOutParameter(2, OracleTypes.CURSOR);
			ResultSet result = cStmt.executeQuery();

			ResultSet rs1 = (ResultSet) cStmt.getObject(2);
			while (rs1.next()) {

				Bpil_Main_Menu kwm_menu_group = new Bpil_Main_Menu();

				kwm_menu_group.setMain_menu_id(rs1.getInt("MAIN_MENU_ID"));
				kwm_menu_group.setMain_menu_name(rs1.getString("MAIN_MENU_NAME"));
				kwm_menu_group.setMain_menu_action_name(rs1.getString("MAIN_MENU_ACTION_NAME"));
				kwm_menu_group.setMain_menu_icon(rs1.getString("MAIN_MENU_ICON"));
				kwm_menu_group.setMenu_type(rs1.getString("MENU_TYPE"));
				System.out.println(kwm_menu_group.getMain_menu_name());

				list.add(kwm_menu_group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public List<Bpil_Sub_Menu> get_user_sub_menu(int main_men_id, String menu_type) {

		List<Bpil_Sub_Menu> list = new ArrayList<Bpil_Sub_Menu>();
		CallableStatement cStmt;
		try {
			cStmt = hibernateConfiguration.dataSource().getConnection()
					.prepareCall("{call BPIL_SP_DERIVE_SUB_MENU(?,?,?)}");
			cStmt.setInt(1, main_men_id);
			cStmt.setString(2, menu_type);
			cStmt.registerOutParameter(3, OracleTypes.CURSOR);
			ResultSet result = cStmt.executeQuery();

			ResultSet rs1 = (ResultSet) cStmt.getObject(3);
			while (rs1.next()) {

				Bpil_Sub_Menu kwm_menu_group_line = new Bpil_Sub_Menu();

				kwm_menu_group_line.setSub_menu_id(rs1.getInt("SUB_MENU_ID"));
				kwm_menu_group_line.setMain_menu_id(rs1.getInt("MAIN_MENU_ID"));
				kwm_menu_group_line.setSub_menu_name(rs1.getString("SUB_MENU_NAME"));
				kwm_menu_group_line.setSub_menu_action_name(rs1.getString("SUB_MENU_ACTION_NAME"));

				System.out.println(kwm_menu_group_line.getSub_menu_name());

				list.add(kwm_menu_group_line);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public boolean insertADList(List<ADList> ADList) {
		Transaction tx = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();

			String query1 = "delete from ADList";
			Query sql1 = session.createQuery(query1);
			sql1.executeUpdate();

			Iterator<ADList> itr = ADList.iterator();
			while (itr.hasNext()) {
				session.save(itr.next());
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}

		return false;
	}

	@Override
	public List<ADList> getADList() {
		Transaction tx = null;
		List<ADList> ad = new ArrayList<>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();

			String query = "from ADList";
			Query sql = session.createQuery(query);
			ad = sql.list();

			return ad;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}

		return ad;
	}

	@Override
	public Bpil_Users getUserByADID(String AdId) {
		Bpil_Users user = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			String query = "from Bpil_Users where active_directory_id = :AdId";
			Query sql = session.createQuery(query);
			sql.setParameter("AdId", AdId);
			user = (Bpil_Users) sql.uniqueResult();

			return user;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return user;
	}

	@Override
	public List<Bpil_Users> getNonADUserList() {
		List<Bpil_Users> users = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			String query = "from Bpil_Users where active_directory_id is not null";
			Query sql = session.createQuery(query);
			users = sql.list();

			return users;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return users;
	}

	@Override
	public List<Student> getstudent() {
		return null;

	}

	@Override
	public List<Bpil_Menu_Line> getMenuLine2(int userid,int menu_header_id) {
    System.out.println(menu_header_id+"   getMenuLine2     "+userid);
		List<BPIL_MENU> str = new ArrayList<BPIL_MENU>();
		BpilLoginDaoImpl i = new BpilLoginDaoImpl();
		System.out.println("useerd id is menu line2 -----------------------"+userid);
		String sql2 = "select b.MENU_HEADER_ID ,b.SUBMENU from BPIL_MENU b where b.USER_ID=" + userid + "";

		System.out.println("Menu line2  --------------------------- assigning all the menu to user");
		str = jdbcTemplate.query(sql2, new RowMapper<BPIL_MENU>() {

			@Override
			public BPIL_MENU mapRow(ResultSet rs, int rowNum) throws SQLException {
				BPIL_MENU BPIL_MENU = new BPIL_MENU();
				BPIL_MENU.setMENU_HEADER_ID(rs.getString("MENU_HEADER_ID"));
				BPIL_MENU.setSUBMENU(rs.getString("SUBMENU"));
				System.out.println(rs.getString("MENU_HEADER_ID"));
				System.out.println(rs.getString("SUBMENU"));
				return BPIL_MENU;
			}
		});
		
	//	System.out.println("menu line 2 ---"+str.get(0).getSUBMENU());
		String str3 = "";
		if (str.size() != 0) {
			str3 = str.get(0).getSUBMENU();
		}

		System.out.println(str3 + "before====================================");

		// TODO Auto-generated method stub
		ArrayList<Bpil_Menu_Line> list = new ArrayList<Bpil_Menu_Line>();

//		String sql="from Menu_Line mh where mh.header_menu_id="+Integer.parseInt(id)+"";
		String sql = "";
		if (str3.length()!=0) {
			
			System.out.println("if block running menu line2");

			sql = "SELECT MENU_LINE_ID, MENU_HEADER_ID, LINE_NAME," + " ACTION_NAME, "
					+ "LINE_ICON FROM BPIL_MENU_LINES b WHERE b.MENU_HEADER_ID" + "= "
					+ Integer.toString(menu_header_id) + " " + " and b.MENU_LINE_ID IN (" + str3
					+ ") and ACTIVE = 'Y' ORDER BY MENU_LINE_ID";
		} else {
			sql = "SELECT MENU_LINE_ID, MENU_HEADER_ID, LINE_NAME," + " ACTION_NAME, "
					+ "LINE_ICON FROM BPIL_MENU_LINES b WHERE b.MENU_HEADER_ID" + "= "
					+ Integer.toString(menu_header_id) + " " + " and ACTIVE = 'Y'  ORDER BY MENU_LINE_ID";
		}

		List<Bpil_Menu_Line> kwm_menu_group_lines = jdbcTemplate.query(sql, new RowMapper<Bpil_Menu_Line>() {

			@Override
			public Bpil_Menu_Line mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bpil_Menu_Line kwm_menu_group_line = new Bpil_Menu_Line();

				kwm_menu_group_line.setMenu_line_id(rs.getInt("MENU_LINE_ID"));
				kwm_menu_group_line.setMenu_header_id(rs.getInt("MENU_HEADER_ID"));
				kwm_menu_group_line.setAction_name(rs.getString("ACTION_NAME"));
				kwm_menu_group_line.setLine_name(rs.getString("LINE_NAME"));

//				System.out.println(kwm_menu_group_line.getLine_name());

				return kwm_menu_group_line;
			}
		});

//		list=(ArrayList<Kwm_Menu_Group_Line>) hibernatetemplate.find(sql);

		return kwm_menu_group_lines;
	}

}

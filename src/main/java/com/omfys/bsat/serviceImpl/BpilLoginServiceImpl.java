package com.omfys.bsat.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omfys.bsat.repository.BpilLoginDao;
import com.omfys.bsat.model.ADList;
import com.omfys.bsat.model.Bpil_Main_Menu;
import com.omfys.bsat.model.Bpil_Menu_Header;
import com.omfys.bsat.model.Bpil_Menu_Line;
import com.omfys.bsat.model.Bpil_Sub_Menu;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.Student;
import com.omfys.bsat.service.BpilLoginService;

@Service("BpilLoginService")
@Transactional
public class BpilLoginServiceImpl implements BpilLoginService {

	@Autowired
	BpilLoginDao bpilLoginDao;

	@Override
	public List<Bpil_Users> getUser(Bpil_Users kwm_users) {

		return bpilLoginDao.getUser(kwm_users);
	}

	@Override
	public List<Bpil_Main_Menu> getMenuGroup(int profile_id) {
		// TODO Auto-generated method stub
		return bpilLoginDao.getMenuGroup(profile_id);
	}
	
	@Override
	public List<Bpil_Menu_Header> getMenuGroup1(int userid) {
		// TODO Auto-generated method stub
		return bpilLoginDao.getMenuGroup1(userid);
	}

	@Override
	public List<Bpil_Sub_Menu> getSubMenuLine(int menu_group_id) {
		// TODO Auto-generated method stub
		return bpilLoginDao.getSubMenuLine(menu_group_id);
	}
	
	@Override
	public List<Bpil_Menu_Line> getMenuLine(int menu_header_id) {
		// TODO Auto-generated method stub
		return bpilLoginDao.getMenuLine(menu_header_id);
	}

	@Override
	public List<Bpil_Main_Menu> get_user_main_menu(int user_id) {
		// TODO Auto-generated method stub
		return bpilLoginDao.get_user_main_menu(user_id);
	}

	@Override
	public List<Bpil_Sub_Menu> get_user_sub_menu(int main_men_id, String menu_type) {
		// TODO Auto-generated method stub
		return bpilLoginDao.get_user_sub_menu(main_men_id, menu_type);
	}

	@Override
	public List<ADList> getActiveDirectoryUserList(String username, String password) {
		List<ADList> userList = new ArrayList<ADList>();
		DirContext ldapContext;
		
		System.out.println("AD user name : "+username+" password : "+password);
		
		 try
		    {

		      Hashtable<String, String> ldapEnv = new Hashtable<String, String>(11);
		      ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		      //Omfys Network
//		      ldapEnv.put(Context.PROVIDER_URL,  "ldap://omfys.co.in");
		      //Berger Network
		      //ldapEnv.put(Context.PROVIDER_URL,  "ldap://bergerindia.com");
		      ldapEnv.put(Context.PROVIDER_URL, "ldap://10.150.72.11:389");
		      ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		      //Omfys Username
//		      ldapEnv.put(Context.SECURITY_PRINCIPAL, username+"@omfys.co.in");
		      //Berger Username
		      ldapEnv.put(Context.SECURITY_PRINCIPAL, username+"@bergerindia.com");
		      //password
		      ldapEnv.put(Context.SECURITY_CREDENTIALS, password);
		      
		      ldapContext = new InitialDirContext(ldapEnv);

		      // Create the search controls         
		      SearchControls searchCtls = new SearchControls();

		      //Specify the attributes to return
		      String returnedAtts[]={"sn","givenName", "samAccountName"};
		      searchCtls.setReturningAttributes(returnedAtts);

		      //Specify the search scope
		      searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		      //specify the LDAP search filter
		      String searchFilter = "(&(objectClass=user)(!(userAccountControl:1.2.840.113556.1.4.803:=2)))"; //return only enabled users
		      //String searchFilter = "(&(objectClass=user)(!(userAccountControl:1.2.840.113556.1.4.803:=1)))"; //returns both enabled and disabled users

		      //Specify the Base for the search
		      //Omfys domain
//		      String searchBase = "dc=omfys,dc=co,dc=in";
		      //Berger domain
		      String searchBase = "dc=bergerindia,dc=com";
		      
		      // Search for objects using the filter
		      NamingEnumeration<SearchResult> answer = ldapContext.search(searchBase, searchFilter, searchCtls);

		      //Loop through the search results
		      while (answer.hasMoreElements())
		      {
		        SearchResult sr = (SearchResult)answer.next();

		        //System.out.println(">>>" + sr.getName());
		        Attributes attrs = sr.getAttributes();
		        String userName = attrs.get("samAccountName").toString();
		        
		        ADList ad = new ADList();
		        ad.setAd_id(userName.substring(userName.indexOf(":") + 2));
		        
		        userList.add(ad);
		      }
		      System.out.println(userList.toString());
		      ldapContext.close();
		    }
		    catch (Exception e)
		    {
		      System.out.println(" Search error: " + e);
		      e.printStackTrace();
		    }
//		 finally {
//				if(userList.isEmpty()){
//					userList = bpilLoginDao.getADList();
//				}else{
//					bpilLoginDao.insertADList(userList);
//				}
//			}
		 Collections.sort(userList, ADList.getAD());
		 return userList;
	}

	@Override
	public Bpil_Users getUserByADID(String AdId) {
		// TODO Auto-generated method stub
		return bpilLoginDao.getUserByADID(AdId);
	}

	@Override
	public List<Bpil_Users> getNonADUserList() {
		// TODO Auto-generated method stub
		return bpilLoginDao.getNonADUserList();
	}

	@Override
	public List<Bpil_Menu_Line> getMenuLine2(int userid,int menu_header_id) {
		// TODO Auto-generated method stub
		return bpilLoginDao.getMenuLine2(userid, menu_header_id);
	}

	

}

package com.omfys.bsat.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.LookupAutofill;
import com.omfys.bsat.model.Bpil_LookupValues;

@Transactional(readOnly = false)
public interface UserRegistrationDao {
	
	public int CreateUser( Bpil_Users Koel_user,int userid);

	 List<Bpil_Users> SearchUser(String user_name);
	 
	 public List<LookupAutofill> findrole(int newuserId);
	 
	 List<Bpil_Users> getAllUsers();
	 
	 public Bpil_Users getUserByUsername(String username);
	 
	 public boolean updateUser(Bpil_Users user);
}

package com.omfys.bsat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.LookupAutofill;
import com.omfys.bsat.model.Bpil_LookupValues;


public interface UserRegistrationService {
	
	public int CreateUser( Bpil_Users Koel_user,int userid);
	
	public List<Bpil_Users> SearchUser(String user_name);
	 
	public List<LookupAutofill> findrole(int newuserId);
	 
	public List<Bpil_Users> getAllUsers();
	 
	public Bpil_Users getUserByUsername(String username);
	
	public boolean updateUser(Bpil_Users user);
	 
}

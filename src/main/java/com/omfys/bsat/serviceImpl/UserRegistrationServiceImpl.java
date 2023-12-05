package com.omfys.bsat.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omfys.bsat.repository.UserRegistrationDao;
import com.omfys.bsat.service.UserRegistrationService;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.LookupAutofill;
import com.omfys.bsat.model.Bpil_LookupValues;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	@Autowired
	private UserRegistrationDao newuserdao;
	

	public int CreateUser( Bpil_Users Koel_user,int userid)
	{
		return newuserdao.CreateUser(Koel_user,userid);
	}
	
	public List<Bpil_Users> SearchUser(String user_name)
	 {
		 return newuserdao.SearchUser(user_name);
	 }
	public List<LookupAutofill> findrole(int newuserId)
	{
		return newuserdao.findrole(newuserId);
	}

	@Override
	public List<Bpil_Users> getAllUsers() {
		return newuserdao.getAllUsers();
	}

	@Override
	public Bpil_Users getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return newuserdao.getUserByUsername(username);
	}

	@Override
	public boolean updateUser(Bpil_Users user) {
		// TODO Auto-generated method stub
		return newuserdao.updateUser(user);
	}
}

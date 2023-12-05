package com.omfys.bsat.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omfys.bsat.repository.UserProfileDao;
import com.omfys.bsat.service.UserProfileService;
import com.omfys.bsat.model.Bpil_Users;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	private UserProfileDao userprofiledao;
	
	public List<Bpil_Users> getUserData(int user_id)
	{
		return userprofiledao.getUserData(user_id);
	}
	
	@Override
	public List<Bpil_Users> getUsers() {
		// TODO Auto-generated method stub
		return userprofiledao.getUsers();
	}
	

	@Override
	public String updateuser(int user_id, int id,String s1) {
		// TODO Auto-generated method stub
		return userprofiledao.updateuser(user_id,id,s1);
	}

}

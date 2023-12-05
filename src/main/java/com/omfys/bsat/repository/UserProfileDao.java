package com.omfys.bsat.repository;

import java.util.List;

import com.omfys.bsat.model.Bpil_Users;

public interface UserProfileDao {
	
	public List<Bpil_Users> getUserData(int user_id);

	public List<Bpil_Users> getUsers();
	
	public String updateuser(int user_id, int id,String s1);

}

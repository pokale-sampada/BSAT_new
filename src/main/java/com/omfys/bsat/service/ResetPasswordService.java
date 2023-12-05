package com.omfys.bsat.service;

import java.util.List;

import com.omfys.bsat.model.Bpil_Users_Autofill;

public interface ResetPasswordService {
	
	public int CreateUser( Bpil_Users_Autofill Koel_user,int userid);
	
	 List<Bpil_Users_Autofill> SearchUser(String user_name);
}

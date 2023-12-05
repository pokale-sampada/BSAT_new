package com.omfys.bsat.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omfys.bsat.service.ResetPasswordService;
import com.omfys.bsat.repository.ResetPasswordDao;
import com.omfys.bsat.model.Bpil_Users_Autofill;
@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {
	
	@Autowired
	private ResetPasswordDao newuserdao;
	

	public int CreateUser( Bpil_Users_Autofill Koel_user,int userid)
	{
		return newuserdao.CreateUser(Koel_user,userid);
	}
	
	public List<Bpil_Users_Autofill> SearchUser(String user_name)
	 {
		 return newuserdao.SearchUser(user_name);
	 }
}

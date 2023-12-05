package com.omfys.bsat.repository;

import java.util.List;


import com.omfys.bsat.model.HierarchySetUp;
import com.omfys.bsat.model.HierarchySetUp1;
import com.omfys.bsat.model.Bpil_Users;

public interface ForgotPasswordDao {


	public List<Bpil_Users> ForgotPassword_List(String user_name);
	

}

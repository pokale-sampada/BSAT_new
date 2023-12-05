package com.omfys.bsat.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.omfys.bsat.model.Bpil_Login_Details;
import com.omfys.bsat.model.Bpil_Scheme_Benefit;
import com.omfys.bsat.model.Bpil_Scheme_Doc;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.New_Scheme_mstr;
import com.omfys.bsat.model.New_Scheme_mstr_for_Crm;
import com.omfys.bsat.model.Student;

@Transactional(readOnly = false)
public interface SchemeMasterDao {

	public ArrayList<New_Scheme_mstr> masterautofill(int profile_id, int userid, String PMG_ML_Group);

	public ArrayList<New_Scheme_mstr> pendingscehememasterautofill(int profile_id, int userid, String PMG_ML_Group);

	public New_Scheme_mstr schemeautofill(int schemeid);
	
	public New_Scheme_mstr_for_Crm crmschemeautofill(int schemeid);
	
	public ArrayList<Bpil_Scheme_Doc> docautofill(int schemeid);

	public ArrayList<Bpil_Scheme_Benefit> giftautofill(int schemeid);

	public ArrayList<New_Scheme_mstr> gethistory(int userid);

	public List<Bpil_Scheme_Doc> showdoc(String schemeid);

	public boolean updateUser(Bpil_Users bpil_Users);
	
	public boolean updateLoginCount(Bpil_Login_Details bpil_Login_Details);
	
	public boolean addLoginCount(Bpil_Login_Details bpil_Login_Details);
	
	public Bpil_Login_Details getLoginCount(int userId, String month);
	
	public Bpil_Users getUserById(int userId);
	
	public int getLastSchemeId();
	
	public List<Bpil_Users> getall();
	
	public void getall2(Student s);
	

}

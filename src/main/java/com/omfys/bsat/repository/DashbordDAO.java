package com.omfys.bsat.repository;

import java.util.ArrayList;
import java.util.List;

import com.omfys.bsat.model.AdminCount;
import com.omfys.bsat.model.Bpil_notification;
import com.omfys.bsat.model.Dashbord;
import com.omfys.bsat.model.New_Scheme_mstr;

public interface DashbordDAO {
	
	
	
	
	public List<Bpil_notification> DashbordApprover_List(int user_id);
	public List<Bpil_notification> DashbordApprover_List(int user_id, int scheme_id);
	public List<Dashbord> DashbordApproverCount_List(int user_id);
	public List<Dashbord> DashbordDealerCount_List(int user_id);
	public List<Dashbord> DashbordSalesCount_List(int user_id);
	public List<AdminCount> AdminCount_List();
	
	public ArrayList<New_Scheme_mstr> active_scheme(int profile_id, int userid);

}
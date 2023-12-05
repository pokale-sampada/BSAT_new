package com.omfys.bsat.service;

import java.util.ArrayList;
import java.util.List;

import com.omfys.bsat.model.ADList;
import com.omfys.bsat.model.Bpil_Main_Menu;
import com.omfys.bsat.model.Bpil_Menu_Header;
import com.omfys.bsat.model.Bpil_Menu_Line;
import com.omfys.bsat.model.Bpil_Sub_Menu;
import com.omfys.bsat.model.Bpil_Users;
import com.omfys.bsat.model.Student;

public interface BpilLoginService {

	public List<Bpil_Users> getUser(Bpil_Users kwm_users);

	public List<Bpil_Main_Menu> getMenuGroup(int profileid);
	
	public List<Bpil_Menu_Header> getMenuGroup1(int userid);
	
	List<Bpil_Menu_Line> getMenuLine2(int menu_header_id,int userid);
	
	public List<Bpil_Sub_Menu> getSubMenuLine(int menu_group_id);
	
	List<Bpil_Menu_Line> getMenuLine(int menu_header_id);
	
	List<Bpil_Main_Menu> get_user_main_menu(int user_id);

	List<Bpil_Sub_Menu> get_user_sub_menu(int main_men_id, String menu_type);	
	
	List<ADList> getActiveDirectoryUserList(String username, String password);
	
	public Bpil_Users getUserByADID(String AdId);
	
	List<Bpil_Users> getNonADUserList();
	
}

package com.omfys.bsat.repository;

import java.util.List;

import com.omfys.bsat.model.Bpil_Bsat_Defaults;
import com.omfys.bsat.model.Bpil_MenuGroup;
import com.omfys.bsat.model.Bpil_Menu_Header;

public interface MenuGroupDao
{
	public int saveGroup(Bpil_MenuGroup menugroup);
	
	public int saveHeader(Bpil_Menu_Header menuheaderline);
	
	public int saveHeaderLine(int id,int count,String submenu[],String status[],String menu_line_id[],int userid);

	public int savedata3(String[] menu_function_id, String[] menu_line_id, String[] function_name,
			String[] function_action_name, String[] active);

	public List<Bpil_MenuGroup> grid1();
	public List<Bpil_Menu_Header> grid2();
	
	public boolean saveDefaults(Bpil_Bsat_Defaults defaults);
	
	public Bpil_Bsat_Defaults getDefaults();
}

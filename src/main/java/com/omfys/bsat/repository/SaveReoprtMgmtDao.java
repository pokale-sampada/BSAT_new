package com.omfys.bsat.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.omfys.bsat.model.Bpil_ReportGroup;
import com.omfys.bsat.model.Bpil_Report_Header;
import com.omfys.bsat.model.Bpil_Report_Lines;
@Transactional(readOnly = false)
public interface SaveReoprtMgmtDao {

	public int savedata(Bpil_ReportGroup kwm_users);
	public int savedata1(Bpil_Report_Header kwm_users);
	public int savedata2(int id,String[] report_line_id,String[] line_status,String[] line_name);
	public int savedata3(String[] report_function_id,String[] report_line_id,String[] rep_function_name,
			String[] rep_function_action_name,String[] line_status);
	
	public List<Bpil_ReportGroup> grid1();	
	public List<Bpil_Report_Header> grid2();
	
	public Bpil_ReportGroup groupautofill(int id);
	
	public Bpil_Report_Header headerautofill(int id);
	public 	ArrayList<Bpil_Report_Lines> lineautofill(int id); 
}

package com.omfys.bsat.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omfys.bsat.repository.ReportRegisterDAO;
import com.omfys.bsat.service.ReportRegisterService;
import com.omfys.bsat.model.LookupAutofill;

import com.omfys.bsat.model.Vacation_Rule;

@Service
public class ReportRegisterServiceImpl implements ReportRegisterService {
	
	@Autowired
	private ReportRegisterDAO reportRegisterDao;

	

	@Override
	public List<LookupAutofill> get_functions_list() {
		return reportRegisterDao.get_functions_list();
	}

	@Override
	public List<LookupAutofill> view_grp_report(int g_id) {
		
		return reportRegisterDao.view_grp_report(g_id);
	}

	

	@Override
	public List<LookupAutofill> view_funtion(int f_id) {
		return reportRegisterDao.view_funtion(f_id);
	}

	@Override
	public int addVacationRule(Vacation_Rule vacation_rule) {
		return reportRegisterDao.addVacationRule(vacation_rule);
	}
	
	@Override
	public List<LookupAutofill> get_group_reports() {
		// TODO Auto-generated method stub
		return null;
	}

	

}

package com.omfys.bsat.service;

import java.util.List;

import com.omfys.bsat.model.LookupAutofill;

public interface MenuRegisterService {
	
	public List<LookupAutofill> MenuRegister_List();
	

	public List<LookupAutofill> Menu_List(int SR_num);
}

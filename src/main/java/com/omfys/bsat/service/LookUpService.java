package com.omfys.bsat.service;

import java.util.Date;
import java.util.List;

import com.omfys.bsat.model.Bpil_Lookup;
import com.omfys.bsat.model.LookupAutofill;
import com.omfys.bsat.model.Bpil_Lookup;

public interface LookUpService
{
	String save_lookup(Bpil_Lookup lookup);
	
	//String save_lookupvalues(Lookup lookup);
	
	int save_lookupvalues(int user_id,int count,String lookup, String[] lookup_code, String[] meaning, String[] description,
			String[] active_start_date, String[] active_end_date);

	List<Bpil_Lookup> listLookUp(String tagName);
	
	public List<LookupAutofill> lookuplist();
	

	//public List<LookupAutofill> lookuplist1();
public List<LookupAutofill> lookuplist1();
public List<LookupAutofill> lookup1(String s1);
public List<LookupAutofill> lookup2(String s1);


}

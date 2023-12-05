package com.omfys.bsat.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omfys.bsat.service.LookUpService;
import com.omfys.bsat.repository.LookupDao;
import com.omfys.bsat.model.Bpil_Lookup;
import com.omfys.bsat.model.LookupAutofill;
import com.omfys.bsat.model.Bpil_Lookup;


@Service("LookUpService")
@Transactional
public class LookUpServiceImpl implements LookUpService
{

	@Autowired
	LookupDao lookupDao;
	@Override
	public String save_lookup(Bpil_Lookup lookup) {
		// TODO Auto-generated method stub
		return lookupDao.save_lookup(lookup);
	}
	
	@Override
	public int save_lookupvalues(int user_id,int count,String lookup, String[] lookup_code, String[] meaning, String[] description,
			String[] active_start_date, String[] active_end_date) {
		// TODO Auto-generated method stub
		return lookupDao.save_lookupvalues(user_id,count,lookup, lookup_code, meaning, description, active_start_date, active_end_date);
	}

	@Override
	public List<Bpil_Lookup> listLookUp(String tagName) {
		// TODO Auto-generated method stub
		return lookupDao.listLookUp(tagName);
	}

	@Override
	public List<LookupAutofill> lookuplist() {
		// TODO Auto-generated method stub
		return lookupDao.lookuplist();
		}

	
	
	
	
	@Override
	public List<LookupAutofill> lookuplist1() {
		// TODO Auto-generated method stub
		System.out.println("in service");

		return lookupDao.lookuplist1();	}

	/*
	@Override
	public List<LookupAutofill> lookuplist1() {
		// TODO Auto-generated method stub
		System.out.println("in service");

		return lookupDao.lookuplist1();	}
*/
	
	@Override
	public List<LookupAutofill> lookup1(String s1) {
		// TODO Auto-generated method stub
		System.out.println("in service");

		return lookupDao.lookup1(s1);	}
	@Override
	public List<LookupAutofill> lookup2(String s1) {
		return lookupDao.lookup2(s1);
	}

}

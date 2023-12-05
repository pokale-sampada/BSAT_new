package com.omfys.bsat.service;

import java.util.List;

import com.omfys.bsat.model.NewsFeeds_Autofill;
import com.omfys.bsat.model.Bpil_News_Feeds;
import com.omfys.bsat.model.Koel_WF_Hub;
import com.omfys.bsat.model.Koel_Warranty_rule;


public interface NewsfieldService {
	
public List<NewsFeeds_Autofill> Loadnews();
	
	public int SaveNews(Bpil_News_Feeds news);
	
	public List<Koel_WF_Hub> approve(int id);

	public int savewarrant(Koel_Warranty_rule warrant);
	
	public List<Koel_Warranty_rule> Loadwarrant();
}

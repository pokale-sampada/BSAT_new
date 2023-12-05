package com.omfys.bsat.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.omfys.bsat.model.NewsFeeds_Autofill;
import com.omfys.bsat.model.Bpil_News_Feeds;
import com.omfys.bsat.model.Koel_WF_Hub;
import com.omfys.bsat.model.Koel_Warranty_rule;



@Transactional(readOnly = false)
public interface NewsfieldDao {
	
public List<NewsFeeds_Autofill> Loadnews();
	
	public int SaveNews(Bpil_News_Feeds news); //news
	
	public List<Koel_WF_Hub> approve(int id); //transfer approve
	
	public int savewarrant(Koel_Warranty_rule warrant); //warranty
	public List<Koel_Warranty_rule> Loadwarrant();
}

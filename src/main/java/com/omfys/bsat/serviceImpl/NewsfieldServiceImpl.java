package com.omfys.bsat.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omfys.bsat.service.NewsfieldService;
import com.omfys.bsat.repository.NewsfieldDao;
import com.omfys.bsat.model.NewsFeeds_Autofill;
import com.omfys.bsat.model.Bpil_News_Feeds;
import com.omfys.bsat.model.Koel_WF_Hub;
import com.omfys.bsat.model.Koel_Warranty_rule;


@Service
public class NewsfieldServiceImpl implements NewsfieldService {
	
	@Autowired
	private NewsfieldDao newsdao;
	
	
	public List<NewsFeeds_Autofill> Loadnews()
	{
		return newsdao.Loadnews();
	}
	
	public int SaveNews(Bpil_News_Feeds news)
	{
		return newsdao.SaveNews(news);
	}
	
	public List<Koel_WF_Hub> approve(int id)
	{
		return newsdao.approve(id);
	}
	
	public int savewarrant(Koel_Warranty_rule warrant)
	{
		return newsdao.savewarrant(warrant);
	}
	
	public List<Koel_Warranty_rule> Loadwarrant()
	{
		return newsdao.Loadwarrant();
	}
}

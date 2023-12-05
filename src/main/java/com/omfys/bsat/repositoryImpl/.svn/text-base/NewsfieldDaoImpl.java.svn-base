package com.omfys.bsat.repositoryImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.text.ParseException;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.model.NewsFeeds_Autofill;
import com.omfys.bsat.repository.NewsfieldDao;
import com.omfys.bsat.model.Bpil_News_Feeds;
import com.omfys.bsat.model.Koel_WF_Hub;
import com.omfys.bsat.model.Koel_Warranty_rule;


@Repository("NewsfieldDao")
public class NewsfieldDaoImpl  implements NewsfieldDao {
	
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<NewsFeeds_Autofill> Loadnews()   //news
	{
		System.out.println("in of dao");
				
		String sql="SELECT NEWS_FEED_ID,NEWS_TITLE,NEWS_URL,LAST_UPDATE_DATE FROM BPIL_NEWS_FEEDS order by NEWS_FEED_ID desc";

		List<NewsFeeds_Autofill> news_data = jdbcTemplate.query(sql, new RowMapper<NewsFeeds_Autofill>() {

			@Override
			public NewsFeeds_Autofill mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
				
				NewsFeeds_Autofill news_details = new NewsFeeds_Autofill();
				
				news_details.setNews_feed_id(rs.getInt("NEWS_FEED_ID"));
				news_details.setNews_title(rs.getString("NEWS_TITLE"));
				news_details.setNews_url(rs.getString("NEWS_URL"));
		
				if(rs.getDate("LAST_UPDATE_DATE")!=null)
				{
					DateFormat ser1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateStr1 = ser1.format(rs.getDate("LAST_UPDATE_DATE"));
					news_details.setLast_update_date(dateStr1);	
					try {
						System.out.println(ser1.parse(rs.getString("LAST_UPDATE_DATE")));
					} catch (ParseException e) {
							e.printStackTrace();
					}
				}
		
				System.out.println("out of dao");
				
				return news_details;
			
			}
			
		});
		
		return news_data;
		
	}
	
	
	public int SaveNews(Bpil_News_Feeds news)
	{	
	    synchronized(this) {
			hibernateTemplate.saveOrUpdate(news);
	
		return news.getNews_feed_id();
	    }
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		public List<Koel_WF_Hub> approve(int id)  // Transfer approval
		{
			String sql="SELECT CLAIM_HEADER_ID,STATUS FROM BPIL_WF_HUB WHERE STATUS='Waiting' AND USER_ID=";
	
			List<Koel_WF_Hub> news_data = jdbcTemplate.query(sql+id, new RowMapper<Koel_WF_Hub>() {
	
				@Override
				public Koel_WF_Hub mapRow(ResultSet rs, int rowNum) throws SQLException 
				{
					
					Koel_WF_Hub news_details = new Koel_WF_Hub(rowNum, sql);
					
					news_details.setClaim_header_id(rs.getInt("CLAIM_HEADER_ID"));
					news_details.setStatus(rs.getString("STATUS"));
												
					System.out.println("out of dao");
					
					return news_details;
				
				}
			});
			
			return news_data;
	}
		
////////////////////////////////////////////////////////////////////////////////////////////////
	
		public int savewarrant(Koel_Warranty_rule warrant)  /// code for warranty rule
		{
			
			hibernateTemplate.saveOrUpdate(warrant);
			
			return 1;
		}
		
		public List<Koel_Warranty_rule> Loadwarrant()
		{
			String sql="SELECT PG_WRTY_DAYS_FROM_INV,INDRTY_WRTY_DAYS_FROM_INV,PG_WRTY_DAYS_FROM_COMMI,INDRTY_WRTY_DAYS_FROM_COMMI,PG_WRTY_RUNNING_HOUR,INDRTY_WRTY_RUNNING_HOUR FROM BPIL_WARANTY_RULE_CONFG";
			
			List<Koel_Warranty_rule> warrant_data = jdbcTemplate.query(sql, new RowMapper<Koel_Warranty_rule>() {
	
				@Override
				public Koel_Warranty_rule mapRow(ResultSet rs, int rowNum) throws SQLException 
				{
					
					Koel_Warranty_rule rule_details = new Koel_Warranty_rule();
					
					rule_details.setPg_wrty_days_from_inv(rs.getInt("PG_WRTY_DAYS_FROM_INV"));
					rule_details.setIndrty_wrty_days_from_inv(rs.getInt("INDRTY_WRTY_DAYS_FROM_INV"));
					rule_details.setPg_wrty_days_from_commi(rs.getInt("PG_WRTY_DAYS_FROM_COMMI"));
					rule_details.setIndrty_wrty_days_from_commi(rs.getInt("INDRTY_WRTY_DAYS_FROM_COMMI"));
					rule_details.setPg_wrty_running_hour(rs.getInt("PG_WRTY_RUNNING_HOUR"));
					rule_details.setIndrty_wrty_running_hour(rs.getInt("INDRTY_WRTY_RUNNING_HOUR"));
					
					System.out.println("out of dao");
					
					return rule_details;
				
				}
			});
			
			return warrant_data;
			
		}
		
		
}

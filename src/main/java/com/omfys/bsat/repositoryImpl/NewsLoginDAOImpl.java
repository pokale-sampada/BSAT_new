package com.omfys.bsat.repositoryImpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.omfys.bsat.repository.NewsLoginDAO;
import com.omfys.bsat.model.News_Login;
@Repository("NewsLoginDao")
public class NewsLoginDAOImpl implements NewsLoginDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<News_Login> DashbordApprover_List() {
		String sql = "SELECT NEWS_TITLE,NEWS_URL FROM BPIL_NEWS_FEEDS ";
		List<News_Login> listContact = jdbcTemplate.query(sql, new RowMapper<News_Login>() {

			@Override
			public News_Login mapRow(ResultSet rs, int rowNum) throws SQLException {
				News_Login aContact = new News_Login();
	
				aContact.setNews_title(rs.getString("NEWS_TITLE"));
				aContact.setNews_url(rs.getString("NEWS_URL"));
				
				return aContact;
			}
			
		});
		
		return listContact;
	}
	
	
	
	

	}



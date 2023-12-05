package com.omfys.bsat;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@EnableTransactionManagement
//@ComponentScan(basePackages="com.omfys.bsat")
@PropertySource(value = { "classpath:application.properties" })
public class TilesConfiguration {
	
	@Autowired
	private Environment environment;

	@Autowired
	private SessionFactory sessionFactory;

	@Bean
	public UrlBasedViewResolver tilesViewResolver() {
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		return tilesViewResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		
	
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		String[] defs = { "WEB-INF/tiles/tiles.xml" };
		tilesConfigurer.setDefinitions(defs);
		return tilesConfigurer;
	}
	
	@Bean
	public JdbcTemplate getjdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public HibernateTemplate hibernateTemplate() {

		HibernateTemplate hibernateTemplate = new HibernateTemplate();

		hibernateTemplate.setSessionFactory(sessionFactory);

		return hibernateTemplate;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.omfys.bsat.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s); 
		
		return txManager;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    return new CommonsMultipartResolver();
	}
//	@Bean
//	 public SimpleMappingExceptionResolver simpleMappingExceptionResolver()
//	 {
//	        SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();
//
//	        Properties mappings = new Properties();
//	        mappings.put("org.springframework.web.servlet.PageNotFound", "error_404");
//	        mappings.put("org.springframework.dao.DataAccessException", "error_500");
//	        mappings.put("org.springframework.transaction.TransactionException", "error_500");
//	        mappings.put("org.springframework.web.servlet.NoHandlerFoundException", "error_404");
//	        mappings.put("org.springframework.http.HttpStatus.NOT_FOUND", "error_404");
//	        mappings.put("java.io.IOException", "error_404");
//	        mappings.put("java.lang.Exception", "error_500");
//	        mappings.put("com.springmvc.controller.ResourceNotFoundException", "error_404");
//	        b.setExceptionMappings(mappings);
//	        
//	        Properties defaultex = new Properties();
//	        defaultex.setProperty("defaultErrorView", "error_404");
//	        
//	        b.setDefaultErrorView("error_404");
//	        
//	        return b;
//	    }

}

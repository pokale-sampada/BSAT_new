package com.omfys.bsat.configuration;

//import javax.servlet.http.HttpServletRequest;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
/**   Basic Authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http 
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
**/
/** 

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Ayan").password("shilpi").roles("NORMAL");
		auth.inMemoryAuthentication().withUser("Akash").password("bonde").roles("ADMIN");
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
		
	}
**/
/** 	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Ayan").password(this.passwordEncoder().encode("shilpi")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("Akash").password(this.passwordEncoder().encode("bonde ")).roles("ADMIN");
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(10);
		
	}
**/
/**	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http 
		.authorizeRequests()
		.antMatchers("/getSchemeNames","/getSchemeNames","/getPayoutDetails").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
**/
/**
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http 
		.authorizeRequests()
		.antMatchers("/public/**").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
}
**/
/**	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Ayan").password("shilpi").roles("NORMAL");
		auth.inMemoryAuthentication().withUser("Akash").password("bonde").roles("ADMIN");
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http 
		//.csrf().disable()// used for token
		//.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		//.and()
		.authorizeRequests()
		.antMatchers("/signin").permitAll()
		.antMatchers("/public/**").hasRole("ADMIN")
		.antMatchers("/test/**").hasRole("NORMAL")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()//.httpBasic(); 
		.loginPage("/signin")
		.loginProcessingUrl("/dologin")
		.defaultSuccessUrl("/berger_login");
	}
}
**/

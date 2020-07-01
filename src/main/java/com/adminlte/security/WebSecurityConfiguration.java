package com.adminlte.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	private AccessDeniedHandler accessDeniedHandler;
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public WebSecurityConfiguration(
			@Qualifier("customAccessDeniedHandler") AccessDeniedHandler accessDeniedHandler,
			@Qualifier("customSuccessHandler") AuthenticationSuccessHandler authenticationSuccessHandler,
			@Qualifier("customUserDetailsService")UserDetailsService userDetailsService
			) {
		// TODO Auto-generated constructor stub
		this.accessDeniedHandler=accessDeniedHandler;
		this.authenticationSuccessHandler=authenticationSuccessHandler;
		this.userDetailsService=userDetailsService;
	}
	
	
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("user").password("{noop}kdsb@2019").roles("USER") .and()
		 * .withUser("admin").password("{noop}kdsb@2019").roles("ADMIN");
		 */
	  
		// PasswordEncoder encoder=new BCryptPasswordEncoder();
		
		 auth.userDetailsService(userDetailsService).passwordEncoder(encode());
	  }
	 

	  @Override
	protected void configure(HttpSecurity http) throws Exception {
		
		  http.authorizeRequests() 
					  .antMatchers("/logout","/user").permitAll()
					  .antMatchers("/USERS").hasRole("USER")
					  .antMatchers("/admin/**").hasRole("ADMIN")
					  .anyRequest().authenticated()
					  //.antMatchers("/admin/device").hasRole("USER")
					  
					  .and()
					  .formLogin()
					    .loginPage("/login")
					   .usernameParameter("username")
					   .passwordParameter("password")
					    .successHandler(authenticationSuccessHandler)
					  	.permitAll()
					  .and()
					  	.logout()
					  	.permitAll()
		               .and()
		               .csrf().disable().cors();
		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
		         
	}
	  
	/*-- for ingoring css and javaScript no need to login ---*/
	
	  @Override public void configure(WebSecurity web) throws Exception {
	  web.ignoring().antMatchers("/resources/**");
	  web.ignoring().antMatchers("/static/**");
	  }
	 
	  
}

package com.example.sst.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Simple InMemory Auth
		/*
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * auth.inMemoryAuthentication().withUser(users.username("ishan").password(
		 * "pass").roles("ADMIN","DEV"))
		 * .withUser(users.username("dev1").password("1234").roles("DEV"))
		 * .withUser(users.username("manager1").password("abcd").roles("MANAGER"));
		 */
		
		// Simple JDBC Auth
		 auth.jdbcAuthentication()
	        .dataSource(dataSource)
	        .withDefaultSchema()
	        .withUser(
	                User.withUsername("user")
	                .password("password")
	                .roles("USER")
	        )
	        .withUser(
	                User.withUsername("admin")
	                .password("password")
	                .roles("ADMIN")
	        );        
		
		//Using Password Encoding
		/*
		 * PasswordEncoder encoder =
		 * PasswordEncoderFactories.createDelegatingPasswordEncoder(); auth
		 * .inMemoryAuthentication() .withUser("demo") .password(encoder.encode("1234"))
		 * .roles("USER") .and() .withUser("admin") .password(encoder.encode("admin"))
		 * .roles("ADMIN");
		 */
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//Restrict on access roles
		/*
		 * http.authorizeRequests() .antMatchers("/c1/**").hasRole("DEV")
		 * .antMatchers("/c2/**").hasRole("MANAGER") .and().formLogin();
		 */
		
		//using Datasource & Restriction + permit
		/*
		 * http.authorizeRequests() .antMatchers("/c1/**").hasRole("ADMIN")
		 * .antMatchers("/c2/**").hasAnyRole("USER", "ADMIN")
		 * .antMatchers("/").permitAll() .and().formLogin();
		 */
		
		 //Block all Requests
		 http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}
}

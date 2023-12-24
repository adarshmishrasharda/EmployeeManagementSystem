package com.employee.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.employee.service.implementation.UserDetailsServiceImplementaion;

@EnableWebSecurity
@Configuration
public class MySecurityConfiguration {
	
	
	@Autowired
	private UserDetailsServiceImplementaion userDetailsServiceImplementaion;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	
	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
		// TODO Auto-generated method stub
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(this.userDetailsServiceImplementaion);
		provider.setPasswordEncoder(passwordEncoder());
		
		return provider;
	}
	
	@Bean
	public SecurityFilterChain securityFilerChain(HttpSecurity http) throws Exception
	{
		
		http.csrf().disable()
		.authorizeRequests()
		.requestMatchers("/generate-token","/api/login/").permitAll()
		.requestMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated()
		.and()
		.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		http.authenticationProvider(daoAuthenticationProvider());
		DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
		
		return defaultSecurityFilterChain;
		
	}
	
	
	
	
	
	

}

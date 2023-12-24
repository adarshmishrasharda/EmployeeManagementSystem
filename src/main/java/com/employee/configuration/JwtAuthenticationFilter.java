package com.employee.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.employee.service.implementation.UserDetailsServiceImplementaion;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	
	@Autowired
	private UserDetailsServiceImplementaion userDetailsServiceImplementaion;
	
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		System.out.println(requestTokenHeader);
		
		String username=null;
		String jwttoken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer"))
		{
			try {
				jwttoken=requestTokenHeader.substring(7);
				username=this.jwtUtil.extractUsername(jwttoken);
				
			}catch(ExpiredJwtException e)
			{
				e.printStackTrace();
				System.out.println("jwt token expired ");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("error we got");
			}
			
		}
		else
		{
			System.out.println("Invalid token not start with bearer");
		}
		
		//validate token
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			final UserDetails userdetails = this.userDetailsServiceImplementaion.loadUserByUsername(username);
			
			if(this.jwtUtil.validateToken(jwttoken, userdetails))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationtoken = new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
				
				usernamePasswordAuthenticationtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationtoken);
			}
		}
		
		else
		{
			System.out.println("token is not valid");
		}
		
		filterChain.doFilter(request, response);
		
		
	}
	
	

}

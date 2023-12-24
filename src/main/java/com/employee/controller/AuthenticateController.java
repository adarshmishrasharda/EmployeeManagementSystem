package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.configuration.JwtUtil;
import com.employee.models.JwtRequest;
import com.employee.models.JwtResponce;
import com.employee.service.implementation.UserDetailsServiceImplementaion;


@RestController
@CrossOrigin("*")//we can can cofigure it from our MySecurityConfig 
public class AuthenticateController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImplementaion userDetailsServiceImplementaion;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	
	//generate token API
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		System.out.println("going to generate token");
		try {
			
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
			
		}
		catch(UsernameNotFoundException e){
			e.printStackTrace();
			throw new Exception("User not found exception");
		}
		
		//if exception not come mean that authentication done 
		
		UserDetails userdetails = this.userDetailsServiceImplementaion.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtUtil.generateToken(userdetails);
		
		return ResponseEntity.ok(new JwtResponce(token));
		
	}
	
	private void authenticate(String username, String password) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
			
		}
		catch (DisabledException e) {
			
			throw new Exception("User Disabled"+e.getMessage());
		}
		catch (BadCredentialsException e) {

			throw new Exception("Invalid Credentials"+e.getMessage());
		}
	}
	
	//ye hame jo banda login hai us ki details nikalne ke liye banaya hai ye login bande ki details dega
	//basic ham generate token karate time jis bande ki login id password dale hai ye usi bande ko pahachan ke usi ki details return karega
	//
//	@GetMapping("/current-user")
//	public User getCurrentUser(Principal principal)
//	{
//		return (User)this.userDetailsServiceImple.loadUserByUsername(principal.getName());
//	}
//	
	

}

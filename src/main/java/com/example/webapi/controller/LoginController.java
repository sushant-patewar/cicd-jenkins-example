package com.example.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webapi.model.userlogin;
import com.example.webapi.request.userLoginRequest;
import com.example.webapi.security.JwtUtil;
import com.example.webapi.services.IUserLoginService;

@RestController
public class LoginController {

	@Autowired
	private IUserLoginService userService;

	@Autowired
	private AuthenticationManager authmanager;
	
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public userlogin validateUser(@RequestBody userLoginRequest user) {
		return this.userService.getUserByUsername(user.getUserName());
	}

	@PostMapping("/authenticate")
	public String createAuthenticationToken(@RequestBody userlogin authRequest) throws Exception {
		try {
			authmanager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("invalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName()); 
	}

	@GetMapping("/wec")
	public String welcome() {
		return "Welcome home";
	}

	public List<userlogin> getUser() {
		return this.userService.getUser();
	}

	public userlogin getUserByUsername(String userName) {
		return this.userService.getUserByUsername(userName);
	}
}

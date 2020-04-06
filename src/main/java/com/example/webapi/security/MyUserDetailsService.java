package com.example.webapi.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.webapi.model.userlogin;
import com.example.webapi.services.IUserLoginService;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserLoginService userLoginService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// return new User("foo","foo", new ArrayList<>());
		userlogin user = userLoginService.getUserByUsername(username);
		return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
	}

}

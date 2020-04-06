package com.example.webapi.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapi.exception.ResourceNotFoundException;
import com.example.webapi.model.userlogin;
import com.example.webapi.repository.UserLoginRepository;
import com.example.webapi.request.userLoginRequest;
import com.example.webapi.services.IUserLoginService;

@Service
@Transactional
public class UserLoginService implements IUserLoginService{

	@Autowired
	private UserLoginRepository userLoginRepo;
	
	@Override
	public List<userlogin> getUser() {
		return this.userLoginRepo.findAll();
	}

	@Override
	public userlogin getUserByUsername(String userName) {
		userlogin userObj = this.userLoginRepo.finduserByUsername(userName);
		return userObj;	
	}
	

	
}

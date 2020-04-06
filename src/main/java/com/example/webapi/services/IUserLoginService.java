package com.example.webapi.services;

import java.util.List;

import com.example.webapi.model.userlogin;
import com.example.webapi.request.userLoginRequest;

public interface IUserLoginService {

	List<userlogin> getUser();

	userlogin getUserByUsername(String userName);
}

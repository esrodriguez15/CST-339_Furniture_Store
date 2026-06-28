package com.furniturestore.service;

import org.springframework.stereotype.Service;
import com.furniturestore.model.LoginModel;

@Service
public class LoginServiceImpl implements LoginServiceInterface {

	@Override
	public boolean authenticate(LoginModel loginModel) 
	{
		//hardwired login info
		String testEmail = "demo@dea.com";
		String testPassword = "password123";
		
		return loginModel.getEmail().equals(testEmail) && loginModel.getPassword().equals(testPassword);
	}

}

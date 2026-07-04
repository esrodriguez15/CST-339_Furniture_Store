package com.furniturestore.service;

import org.springframework.stereotype.Service;

import com.furniturestore.data.service.UserDataService;
import com.furniturestore.model.LoginModel;

@Service
public class LoginServiceImpl implements LoginServiceInterface
{
	private final UserDataService userDataService;

	public LoginServiceImpl(UserDataService userDataService)
	{
		this.userDataService = userDataService;
	}

	@Override
	public boolean authenticate(LoginModel loginModel)
	{
		return userDataService
				.findByEmailAndPassword(
						loginModel.getEmail(),
						loginModel.getPassword())
				.isPresent();
	}
}

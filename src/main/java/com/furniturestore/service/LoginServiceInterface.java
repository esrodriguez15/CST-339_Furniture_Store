package com.furniturestore.service;

import com.furniturestore.model.LoginModel;

public interface LoginServiceInterface 
{
	boolean authenticate(LoginModel model);
}

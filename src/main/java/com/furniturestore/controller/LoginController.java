package com.furniturestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.furniturestore.model.LoginModel;

/**
 * Responsible for handling user login operations
 */
@Controller
public class LoginController
{
	/**
	 * Displays login page
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/login")
	public String displayLogin(Model model)
	{
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
}
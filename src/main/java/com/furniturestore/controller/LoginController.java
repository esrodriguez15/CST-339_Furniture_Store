package com.furniturestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.furniturestore.model.LoginModel;

/**
 * Controller responsible for displaying the user login page.
 */
@Controller
public class LoginController
{
	/**
	 * Displays the login page and provides an empty login model.
	 *
	 * @param model the Spring MVC model
	 * @return the login page
	 */
	@GetMapping("/login")
	public String displayLogin(Model model)
	{
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
}
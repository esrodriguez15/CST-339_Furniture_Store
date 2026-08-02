package com.furniturestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.furniturestore.model.LoginModel;

/**
<<<<<<< HEAD
 * Responsible for handling user login operations
=======
 * Controller responsible for displaying the user login page.
>>>>>>> ebd241d669a4580cb724fa01bee8106c1f180e00
 */
@Controller
public class LoginController
{
	/**
<<<<<<< HEAD
	 * Displays login page
	 * 
	 * @param model
	 * @return
=======
	 * Displays the login page and provides an empty login model.
	 *
	 * @param model the Spring MVC model
	 * @return the login page
>>>>>>> ebd241d669a4580cb724fa01bee8106c1f180e00
	 */
	@GetMapping("/login")
	public String displayLogin(Model model)
	{
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
}
package com.furniturestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Displays Account page
 */
@Controller
public class AccountController 
{
	@GetMapping("/account")
	public String account() 
	{
		return "account";
	}
}
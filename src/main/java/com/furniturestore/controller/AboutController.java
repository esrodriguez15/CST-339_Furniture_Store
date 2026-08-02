package com.furniturestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Displays About page
 */
@Controller
public class AboutController 
{
	@GetMapping("/about")
	public String about() 
	{
		return "about";
	}
}
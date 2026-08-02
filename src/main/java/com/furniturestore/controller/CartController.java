package com.furniturestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Displays Cart page
 */
@Controller
public class CartController 
{
	@GetMapping("/cart")
	public String cart() 
	{
		return "cart";
	}
}
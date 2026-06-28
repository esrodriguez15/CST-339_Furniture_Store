package com.furniturestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.furniturestore.model.RegistrationModel;
import com.furniturestore.service.RegistrationServiceInterface;

import jakarta.validation.Valid;

@Controller
public class RegistrationController 
{
	@Autowired
	private RegistrationServiceInterface registrationService;
	
	@GetMapping("/registration")
	 public String displayRegistration(Model model)
    {
        model.addAttribute("registrationModel", new RegistrationModel());
        return "registration";
    }

	@PostMapping("/registration/doRegistration")
	public String doRegistration(
	        @Valid @ModelAttribute("registrationModel") RegistrationModel registrationModel,
	        BindingResult bindingResult,
	        Model model)
	{
	    if (!registrationService.validateRegistration(registrationModel))
	    {
	        bindingResult.rejectValue(
	                "confirmPassword",
	                "password.mismatch",
	                "Passwords do not match");
	    }

	    if(bindingResult.hasErrors())
	    {
	        return "registration";
	    }

	    model.addAttribute("successMessage", "Account created successfully.");
	    return "registration";
	}
}

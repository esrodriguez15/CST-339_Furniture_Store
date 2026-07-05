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
        // Controller-level validation (password match)
        if (!registrationModel.getPassword().equals(registrationModel.getConfirmPassword()))
        {
            bindingResult.rejectValue(
                    "confirmPassword",
                    "password.mismatch",
                    "Passwords do not match");
        }

        // If validation errors exist, return to form
        if (bindingResult.hasErrors())
        {
            return "registration";
        }

        // Call service (handles DB + business logic)
        boolean success = registrationService.registerUser(registrationModel);

        if (!success)
        {
            bindingResult.rejectValue(
                    "email",
                    "email.exists",
                    "An account with this email already exists");

            return "registration";
        }

        model.addAttribute("successMessage", "Account created successfully.");
        return "registration";
    }
}

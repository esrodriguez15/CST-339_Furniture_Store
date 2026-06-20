package com.furniturestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.furniturestore.model.LoginModel;

import jakarta.validation.Valid;

@Controller
public class LoginController
{
    @GetMapping("/login")
    public String displayLogin(Model model)
    {
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/login/doLogin")
    public String doLogin(
            @Valid LoginModel loginModel,
            BindingResult bindingResult,
            Model model)
    {
        if (bindingResult.hasErrors())
        {
            return "login";
        }

        String testEmail = "demo@dea.com";
        String testPassword = "password123";

        if (testEmail.equals(loginModel.getEmail())
                && testPassword.equals(loginModel.getPassword()))
        {
            model.addAttribute("successMessage", "Login successful.");
            return "login";
        }

        model.addAttribute("errorMessage", "Invalid email or password.");
        return "login";
    }
}
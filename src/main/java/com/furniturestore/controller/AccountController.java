package com.furniturestore.controller;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.furniturestore.data.entity.UserEntity;
import com.furniturestore.data.service.UserDataService;

/**
 * Controller responsible for displaying the logged-in user's account
 * information.
 */
@Controller
public class AccountController
{
    /**
     * Service used to retrieve user account information from the database.
     */
    private final UserDataService userDataService;

    /**
     * Creates an AccountController with the required user data service.
     *
     * @param userDataService the service used to access user account data
     */
    public AccountController(UserDataService userDataService)
    {
        this.userDataService = userDataService;
    }

    /**
     * Displays the Account page for the currently authenticated user.
     * Retrieves the user's email from the Spring Security context,
     * loads the user's information from the database, and adds it
     * to the model for display.
     *
     * @param model the model used to pass data to the view
     * @return the Account page view
     */
    @GetMapping("/account")
    public String displayAccount(Model model)
    {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        Optional<UserEntity> user = userDataService.findByEmail(email);

        if (user.isPresent())
        {
            model.addAttribute("user", user.get());
        }
        else
        {
            model.addAttribute("error", "User account could not be found.");
        }

        return "account";
    }
}

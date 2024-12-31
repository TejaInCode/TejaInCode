package com.example.controller;

import com.example.entity.userdtls;
import com.example.repository.userepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private userepository userRepo; // Repository for accessing user data

    @ModelAttribute
    public void addUserDetails(Model model, Principal principal) {
        if (principal != null) {
            String email = principal.getName(); // Get logged-in user's email
            userdtls user = userRepo.findByEmail(email); // Fetch user details from the database
            model.addAttribute("user", user); // Add user details to the model
        }
    }

    @GetMapping("/")  // Maps /user/ to this method
    public String home() {
        return "User/home";  // Return the User/home.html template
    }
}

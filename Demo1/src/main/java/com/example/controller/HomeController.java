package com.example.controller;

import com.example.entity.userdtls;
import com.example.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired
    private userservice userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute userdtls user, RedirectAttributes redirectAttributes) {

        boolean emailExists = userService.checkEmail(user.getEmail());
        if (emailExists) {
            redirectAttributes.addFlashAttribute("msg", "Email already exists");
        } else {
            userdtls userDtls = userService.createUser(user);
            if (userDtls != null) {
                redirectAttributes.addFlashAttribute("msg", "Registration Successful");
            } else {
                redirectAttributes.addFlashAttribute("msg", "Registration Failed");
            }
        }
//        System.out.println(user);
        /* return "redirect:/register" by using redirect whenever we keep refreshing data is not stored in the db.  */
        return "redirect:/register"; // Redirect to clear the form and message on refresh
    }
    }

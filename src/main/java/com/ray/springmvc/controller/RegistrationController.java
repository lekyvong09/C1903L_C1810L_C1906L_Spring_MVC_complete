package com.ray.springmvc.controller;

import com.ray.springmvc.entity.RegisteredUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model theModel) {
        theModel.addAttribute("registeredUser", new RegisteredUser());
        return "registration-form";
    }
}

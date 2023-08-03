package com.example.student_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "/login";
    }
}

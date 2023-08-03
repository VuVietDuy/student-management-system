package com.example.student_management_system.controller;

import com.example.student_management_system.dto.UserRegistrationDto;
import com.example.student_management_system.entity.User;
import com.example.student_management_system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAcount(@ModelAttribute("user") UserRegistrationDto user) {
        if (!userService.checkExistingUserByEmail(user.getEmail())) {
            userService.save(user);
            return "redirect:registration?success";
        }
        return "redirect:registration?failed";
    }
}

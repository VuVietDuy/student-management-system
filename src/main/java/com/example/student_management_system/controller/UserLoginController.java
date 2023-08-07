package com.example.student_management_system.controller;

import com.example.student_management_system.entity.User;
import com.example.student_management_system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

//    private UserService userService;
//
//    public UserLoginController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "/login";
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute("userdto") User userdto) {
//        if (!userService.checkExistingUserByEmail(userdto.getEmail())) {
//            return "redirect:/login?emailWrong";
//        }
//        if (!userService.checkPasswordAcount(userdto.getEmail(), userdto.getPassword())) {
//            return "redirect:/login?passwordWrong";
//        }
//        return "redirect:/students";
//    }
}

package com.example.student_management_system.service;

import com.example.student_management_system.dto.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}

package com.example.student_management_system.service;

import com.example.student_management_system.dto.UserRegistrationDto;
import com.example.student_management_system.entity.User;

public interface UserService {
    User save(UserRegistrationDto userRegistrationDto);
}

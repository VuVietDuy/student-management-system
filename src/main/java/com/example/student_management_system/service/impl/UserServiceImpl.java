package com.example.student_management_system.service.impl;

import com.example.student_management_system.dto.UserRegistrationDto;
import com.example.student_management_system.entity.Role;
import com.example.student_management_system.entity.User;
import com.example.student_management_system.repository.UserRepository;
import com.example.student_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public boolean checkPasswordAcount(String email, String password) {
        User user = userRepository.getUserByEmail(email);
        if (user.getPassword().equals(password) ) return true;
        return false;
    }

    @Override
    public boolean checkExistingUserByEmail(String email) {
        User existingUser = userRepository.findUserByEmail(email);
        if (existingUser == null) {
            return false;
        }
        return true;
    }
}

package com.example.student_management_system.service.impl;

import com.example.student_management_system.dto.UserRegistrationDto;
import com.example.student_management_system.entity.User;
import com.example.student_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//
//    @Override
//    public User save(UserRegistrationDto userRegistrationDto) {
//        return null;
//    }
//
//    @Override
//    public User getUserByEmail(String email) {
//        return userRepository.getUserByEmail(email);
//    }
//
//    @Override
//    public boolean checkPasswordAcount(String email, String password) {
//        User user = userRepository.getUserByEmail(email);
//        if (user.getPassword().equals(password) ) return true;
//        return false;
//    }
//
//    @Override
//    public boolean checkExistingUserByEmail(String email) {
//        User existingUser = userRepository.findUserByEmail(email);
//        if (existingUser == null) {
//            return false;
//        }
//        return true;
//    }
}

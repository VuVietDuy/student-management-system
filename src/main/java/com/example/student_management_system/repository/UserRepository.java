package com.example.student_management_system.repository;

import com.example.student_management_system.dto.UserRegistrationDto;
import com.example.student_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByEmail(String email);
    User findUserByEmail(String email);
}

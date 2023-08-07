package com.example.student_management_system.repository;

import com.example.student_management_system.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor , Long> {
}

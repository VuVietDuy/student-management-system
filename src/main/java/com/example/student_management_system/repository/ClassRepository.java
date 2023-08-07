package com.example.student_management_system.repository;

import com.example.student_management_system.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Classes, Long> {
}

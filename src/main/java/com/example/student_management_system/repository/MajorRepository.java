package com.example.student_management_system.repository;

import com.example.student_management_system.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, Long> {
}

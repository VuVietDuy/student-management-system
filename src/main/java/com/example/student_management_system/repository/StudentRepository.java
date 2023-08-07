package com.example.student_management_system.repository;

import com.example.student_management_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByClassesIdAndMajorId(Long classId, Long majorId);
    List<Student> findAllByClassesId(Long classId);
    List<Student> findAllByMajorId(Long majorId);
}

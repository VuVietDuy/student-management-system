package com.example.student_management_system.service;

import com.example.student_management_system.dto.StudentDto;
import com.example.student_management_system.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDto> getStudents(Long classId, Long majorId);

    StudentDto getStudentById(Long id);

    StudentDto createStudent(StudentDto studentDto);

    StudentDto updateStudent(StudentDto studentDto, Long id );

    void deleteStudentById(Long id);
}

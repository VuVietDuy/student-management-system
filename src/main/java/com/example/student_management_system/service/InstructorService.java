package com.example.student_management_system.service;

import com.example.student_management_system.dto.InstructorDto;

public interface InstructorService {
    InstructorDto getInstructorById(Long id);
    InstructorDto getAllInstructor();
    InstructorDto createInstructor(InstructorDto instructorDto);
    InstructorDto updateInstructor(InstructorDto instructorDto);
    void deleteInstructor(Long id);
}

package com.example.student_management_system.service;

import com.example.student_management_system.dto.ClassDto;
import com.example.student_management_system.entity.Classes;

import java.util.List;

public interface ClassService {
    ClassDto getClassById(Long classId);
    List<ClassDto> getAllClasses(Long majorId, String sortBy, String sortDir);
}

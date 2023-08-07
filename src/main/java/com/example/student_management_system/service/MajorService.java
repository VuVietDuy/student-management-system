package com.example.student_management_system.service;

import com.example.student_management_system.dto.MajorDto;

public interface MajorService {
    MajorDto getMajorById(Long majorId);
    MajorDto createMajor(MajorDto majorDto);
}

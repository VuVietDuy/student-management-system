package com.example.student_management_system.service.impl;

import com.example.student_management_system.dto.InstructorDto;
import com.example.student_management_system.repository.InstructorRepository;
import com.example.student_management_system.service.InstructorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private ModelMapper mapper;

    public InstructorServiceImpl(InstructorRepository instructorRepository, ModelMapper mapper) {
        this.instructorRepository = instructorRepository;
        this.mapper = mapper;
    }

    @Override
    public InstructorDto getInstructorById(Long id) {
        return null;
    }

    @Override
    public InstructorDto getAllInstructor() {
        return null;
    }

    @Override
    public InstructorDto createInstructor(InstructorDto instructorDto) {
        return null;
    }

    @Override
    public InstructorDto updateInstructor(InstructorDto instructorDto) {
        return null;
    }

    @Override
    public void deleteInstructor(Long id) {

    }
}

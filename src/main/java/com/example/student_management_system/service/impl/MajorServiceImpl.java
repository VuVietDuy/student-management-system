package com.example.student_management_system.service.impl;

import com.example.student_management_system.dto.MajorDto;
import com.example.student_management_system.entity.Major;
import com.example.student_management_system.exception.ApiException;
import com.example.student_management_system.repository.MajorRepository;
import com.example.student_management_system.service.MajorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MajorServiceImpl implements MajorService {
    private MajorRepository majorRepository;

    @Autowired
    private ModelMapper mapper;

    public MajorServiceImpl(MajorRepository majorRepository, ModelMapper mapper) {
        this.majorRepository = majorRepository;
        this.mapper = mapper;
    }

    @Override
    public MajorDto getMajorById(Long majorId) {
        Major major = majorRepository.findById(majorId).orElseThrow();
        return mapToDto(major);
    }

    @Override
    public MajorDto createMajor(MajorDto majorDto) {
        Major major = mapToEntity(majorDto);
        majorRepository.save(major);
        return mapToDto(major);
    }

    private Major mapToEntity(MajorDto majorDto) {
        return mapper.map(majorDto, Major.class);
    }

    private MajorDto mapToDto(Major major) {
        return mapper.map(major, MajorDto.class);
    }
}

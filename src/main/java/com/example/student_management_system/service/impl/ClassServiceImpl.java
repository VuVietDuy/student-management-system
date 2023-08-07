package com.example.student_management_system.service.impl;

import com.example.student_management_system.dto.ClassDto;
import com.example.student_management_system.entity.Classes;
import com.example.student_management_system.repository.ClassRepository;
import com.example.student_management_system.service.ClassService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements ClassService {

    private ClassRepository classRepository;

    @Autowired
    private ModelMapper mapper;

    public ClassServiceImpl(ClassRepository classRepository, ModelMapper mapper) {
        this.classRepository = classRepository;
        this.mapper = mapper;
    }

    @Override
    public ClassDto getClassById(Long classId) {
        Classes classes = classRepository.findById(classId).get();
        return mapToDto(classes);
    }

    @Override
    public List<ClassDto> getAllClasses(Long majorId,String sortBy,String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        // create
        List<Classes> classes = classRepository.findAll();

        List<ClassDto> classDtos = classes.stream().map((classes1) -> mapToDto(classes1)).collect(Collectors.toList());

        return null;
    }

    private ClassDto mapToDto(Classes classes) {
        return mapper.map(classes, ClassDto.class);
    }
}

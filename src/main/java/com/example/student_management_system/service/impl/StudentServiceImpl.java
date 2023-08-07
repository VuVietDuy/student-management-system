package com.example.student_management_system.service.impl;

import com.example.student_management_system.dto.StudentDto;
import com.example.student_management_system.entity.Student;
import com.example.student_management_system.exception.ResourceNotFoundException;
import com.example.student_management_system.repository.StudentRepository;
import com.example.student_management_system.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private ModelMapper mapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return mapToDto(studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "id", id)));
    }

    @Override
    public List<StudentDto> getStudents(Long classId, Long majorId) {
        List<Student> students = new ArrayList<>();
        if (classId != null && majorId != null) {
            students = studentRepository.findAllByClassesIdAndMajorId(classId, majorId);
        } else if (classId != null) {
            students = studentRepository.findAllByClassesId(classId);
        } else if (majorId != null) {
            students = studentRepository.findAllByMajorId(majorId);
        } else {
            students = studentRepository.findAll();
        }
        return students.stream().map((student -> mapToDto(student))).collect(Collectors.toList());
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student newStudent = mapToEntity(studentDto);
        studentRepository.save(newStudent);
        return mapToDto(newStudent);
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("student", "id", id));

        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        studentRepository.save(student);

        return mapToDto(student);
    }


    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    private StudentDto mapToDto(Student student) {
        return mapper.map(student, StudentDto.class);
    }

    private Student mapToEntity(StudentDto studentDto) {
        return mapper.map(studentDto, Student.class);
    }
}

package com.example.student_management_system.controller;

import com.example.student_management_system.dto.StudentDto;
import com.example.student_management_system.entity.Student;
import com.example.student_management_system.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId) {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @PostMapping("")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto newStudent = studentService.createStudent(studentDto);
        return ResponseEntity.ok(newStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable("id") Long id) {
        StudentDto newStudent = studentService.updateStudent(studentDto, id );
        return ResponseEntity.ok(newStudent);
    }

    @GetMapping()
    public ResponseEntity<List<StudentDto>> getStudents(
            @RequestParam(value = "classId", required = false) Long classId,
            @RequestParam(value = "majorId", required = false) Long majorId
    ) {
        return ResponseEntity.ok(studentService.getStudents(classId, majorId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>("Student entity deleted successfully", HttpStatus.OK);
    }

//    @GetMapping("/new")
//    public String createNewStudent(Model model) {
//        Student student = new Student();
//        model.addAttribute("student", student);
//
//        return "create_student";
//    }
//

//    @GetMapping("/students/{id}")
//    public String getStudentById(@PathVariable("id") Long id, Model model) {
//        Student student = new Student();
//        student = studentService.getStudentById(id);
//        model.addAttribute("student", student);
//        return "students";
//    }


//    @GetMapping("/edit/{id}")
//    public String editStudentForm(@PathVariable("id") Long id,Model model) {
//        Student student = studentService.getStudentById(id);
//        model.addAttribute("stu", student);
//        return "edit_student";
//    }
//
//    @PostMapping("/{id}")
//    public String updateStudent(@PathVariable("id") Long id,
//                              @ModelAttribute Student student,
//                              Model model) {
//        Student existingStudent = studentService.getStudentById(id);
//        existingStudent.setFirstName(student.getFirstName());
//        existingStudent.setLastName(student.getLastName());
//        existingStudent.setEmail(student.getEmail());
//        studentService.updateStudent(existingStudent);
//
//        return "redirect:/api/v1/students";
//    }
//
//    //handler method to handle delete student request
//    @GetMapping("students/{id}")
//    public String deleteStudent(@PathVariable("id") Long id) {
//        studentService.deleteStudentById(id);
//        return "redirect:/api/v1/students";
//    }

}

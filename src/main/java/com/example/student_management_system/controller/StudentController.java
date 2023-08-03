package com.example.student_management_system.controller;

import com.example.student_management_system.entity.Student;
import com.example.student_management_system.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    //handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("student", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createNewStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);

        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

//    @GetMapping("/students/{id}")
//    public String getStudentById(@PathVariable("id") Long id, Model model) {
//        Student student = new Student();
//        student = studentService.getStudentById(id);
//        model.addAttribute("student", student);
//        return "students";
//    }


    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id,Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("stu", student);
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") Long id,
                              @ModelAttribute Student student,
                              Model model) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        studentService.updateStudent(existingStudent);

        return "redirect:/students";
    }

    //handler method to handle delete student request
    @GetMapping("students/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

}

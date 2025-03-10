package com.student.api.controller;

import com.student.api.model.Student;
import com.student.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping("/{institute}")
    public List<Student> getStudentByInstitute(@PathVariable String institute){
        System.out.println("StudentApi: Recieved call for institute " + institute);
        System.out.println("StudentApi: Calling service layer");
        return studentService.getAllStudentByInstitute(institute);
    }

}

package com.may.learn.controller;

import com.may.learn.model.Student;
import com.may.learn.service.GetService;
import com.may.learn.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    GetService getService = new GetService();

    @PostMapping("/register")
    public void saveStudent(@RequestParam int id,
                            @RequestParam String name){
        registrationService.saveStudent(id, name);
    }

    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable int id){
        Student respone = getService.getStudentId(id);
        if(respone == null){
            return "No student is present with the id passed";
        }else{
            return "Congo student is present";
        }
    }

}

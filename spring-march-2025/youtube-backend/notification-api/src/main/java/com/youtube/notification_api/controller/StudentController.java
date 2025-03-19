package com.youtube.notification_api.controller;

import com.youtube.notification_api.Student;
import com.youtube.notification_api.service.CreateStudentService;
import com.youtube.notification_api.service.GetStundetService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    CreateStudentService createService = new CreateStudentService();

    GetStundetService getService = new GetStundetService();

    @PostMapping("/create")
    public void createStudent(@RequestParam int id, @RequestParam String name){
        createService.createStudent(id, name);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id){
        return getService.getStudentById(id);
    }

}

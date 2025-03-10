package com.acciojob.backend.Controller;

import com.acciojob.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class AccioJobController {

    @Autowired
    StudentService service;

    @GetMapping("/")
    public Object getAllStudent(){
        System.out.println("AccioJob: Call recieved at accioJob Backend api calling service");
        return service.getAllStudents();
    }
}

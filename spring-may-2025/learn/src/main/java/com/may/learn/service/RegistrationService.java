package com.may.learn.service;

import com.may.learn.model.Student;
import com.may.learn.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    StudentRepo studentRepo;

    public void saveStudent(int id, String name){
        Student student = new Student();
        student.id = id;
        student.name = name;
        studentRepo.saveStudent(student);
    }

}

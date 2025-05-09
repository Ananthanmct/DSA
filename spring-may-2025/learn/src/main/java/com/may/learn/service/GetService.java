package com.may.learn.service;

import com.may.learn.model.Student;
import com.may.learn.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetService {


    @Autowired
    StudentRepo studentRepo;

    public Student getStudentId(int id){
        return studentRepo.getStudentById(id);
    }

}

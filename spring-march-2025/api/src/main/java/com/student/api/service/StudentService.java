package com.student.api.service;

import com.student.api.model.Student;
import com.student.api.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public void saveStudent(Student student){
        studentRepo.save(student);
    }

    public List<Student> getAllStudentByInstitute(String instituteName){
        System.out.println("StudentAPi: Inside service calling db layer");
        return studentRepo.findByInstitute(instituteName);
    }
}

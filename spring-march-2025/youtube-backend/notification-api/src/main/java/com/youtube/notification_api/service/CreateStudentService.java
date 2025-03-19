package com.youtube.notification_api.service;

import com.youtube.notification_api.Student;
import com.youtube.notification_api.repository.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentService {

    StudentRepo studentRepo = new StudentRepo();

    public void createStudent(int id, String name){
        Student student = new Student();
        student.id = id;
        student.name = name;
        System.out.println(student);
        studentRepo.save(student);
    }
}

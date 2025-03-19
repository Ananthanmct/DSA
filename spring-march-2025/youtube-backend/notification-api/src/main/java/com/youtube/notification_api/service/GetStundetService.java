package com.youtube.notification_api.service;

import com.youtube.notification_api.Student;
import com.youtube.notification_api.repository.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class GetStundetService {

    StudentRepo studentRepo = new StudentRepo();

    public Student getStudentById(int id){
        return studentRepo.findById(id);
    }
}

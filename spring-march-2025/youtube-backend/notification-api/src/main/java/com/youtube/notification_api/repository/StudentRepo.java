package com.youtube.notification_api.repository;

import com.youtube.notification_api.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StudentRepo {
    // 1 - > {id : 1, name : Somendra}
    // 2 -> {id: 2, name : hello}
    HashMap<Integer, Student> map = new HashMap<>();

    public void save(Student student){
        map.put(student.getId(), student);
    }

    public Student findById(Integer id){
        return map.get(id);
    }
}

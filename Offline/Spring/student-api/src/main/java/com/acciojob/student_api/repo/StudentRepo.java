package com.acciojob.student_api.repo;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StudentRepo {
    HashMap<Integer, String> studentDb;

    public StudentRepo(){
        this.studentDb = new HashMap<>();
    }

    public void save(int id, String name){
        studentDb.put(id, name);
    }

    public String get(int id){
        return studentDb.get(id);
    }

    public int getTotalStudents(){
        return studentDb.size();
    }
}

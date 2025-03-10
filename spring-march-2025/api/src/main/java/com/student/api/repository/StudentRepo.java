package com.student.api.repository;


import com.student.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepo extends JpaRepository<Student, UUID> {

    public List<Student> findByInstitute(String institute);
}

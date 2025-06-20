package com.naukri.database_api.repositories;

import com.naukri.database_api.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestionRepo extends JpaRepository<Questions, UUID> {
}

package com.naukri.database_api.repositories;

import com.naukri.database_api.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface answerRepo extends JpaRepository<Answer, UUID> {
}



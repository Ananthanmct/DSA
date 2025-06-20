package com.naukri.database_api.repositories;

import com.naukri.database_api.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepo extends JpaRepository<Job, UUID> {
}

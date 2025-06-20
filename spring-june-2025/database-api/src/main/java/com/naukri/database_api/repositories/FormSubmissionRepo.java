package com.naukri.database_api.repositories;

import com.naukri.database_api.models.FormSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FormSubmissionRepo extends JpaRepository<FormSubmission, UUID> {
}

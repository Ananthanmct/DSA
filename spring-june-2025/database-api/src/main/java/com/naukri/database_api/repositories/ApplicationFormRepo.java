package com.naukri.database_api.repositories;

import com.naukri.database_api.models.ApplicationForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicationFormRepo extends JpaRepository<ApplicationForm, UUID> {

}

package com.naukri.database_api.controllers;

import com.naukri.database_api.models.ApplicationForm;
import com.naukri.database_api.repositories.ApplicationFormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
@RequestMapping("/api/v1/db")

public class ApplicationFormController {
    ApplicationFormRepo applicationFormRepo;

    @Autowired
    public ApplicationFormRepo (ApplicationFormRepo applicationFormRepo)
    {
        this.applicationFormRepo = applicationFormRepo;
    }
    RequestMapping("/saveform")
    public ResponseEntity saveform (@RequestBody ApplicationForm Form){
        ApplicationFormRepo.save(Form);
        return new ResponseEntity(Form, HttpStatus.CREATED);
  ;  }
}

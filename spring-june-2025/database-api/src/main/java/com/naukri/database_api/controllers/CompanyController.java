package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Company;
import com.naukri.database_api.repositories.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db")
public class CompanyController {

    CompanyRepo companyrepo;

    @Autowired
    public void CompanyRepo(CompanyRepo companyrepo){
        this.companyrepo = companyrepo;
    }

    @PostMapping("/save")
    public ResponseEntity createCompany(@RequestBody Company company){
        companyrepo.save(company);
        return new ResponseEntity(company,HttpStatus.CREATED);
    }
}

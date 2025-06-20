package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Company;
import com.naukri.database_api.repositories.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/company")
public class CompanyController {

    CompanyRepo companyrepo;

    @Autowired
    public void CompanyController(CompanyRepo companyrepo){

        this.companyrepo = companyrepo;
    }

    @PostMapping("/save")
    public ResponseEntity createCompany(@RequestBody Company company){
        companyrepo.save(company);
        return new ResponseEntity(company,HttpStatus.CREATED);
    }
    @GetMapping("/{id]")
    public ResponseEntity <Company> findById(@PathVariable UUID id)
    {
        Company company  = CompanyRepo.findById(id).orElse(null);
        if (company != null)
        {
            return new ResponseEntity<>(company HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(company,HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/ FindAll")
    public ResponseEntity<List<Company>> FindAll()
    {
        List<Company> companies = companyrepo.findAll();
        return new ResponseEntity<>(companies,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Company> update (@RequestBody Company company)
    {
        companyrepo.save(company);
        return new ResponseEntity<>(company,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable UUID id )
    {
        companyrepo.delete (id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

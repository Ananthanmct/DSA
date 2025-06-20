package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/jobs")
public class JobController {
    JobRepo jobrepo ;
    @Autowired
    public JobController (JobRepo jobRepo)
    {
        this.jobrepo= jobRepo;

    }
    @PostMapping("/save")
    public ResponseEntity<Job> create (@RequestBody Job job)
    {
        jobrepo.save(job);
        return new ResponseEntity<>(job,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> findById (@PathVariable UUID id )
    {
       Job job = jobrepo.findById(id).orElse(null);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<Job>> findAll ()
    {
        List <Job>jobs = jobrepo.findAll();
        return new ResponseEntity<>(jobs,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity update (@RequestBody Job job)
    {
        jobrepo.save(job);
        return new ResponseEntity(job,HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete (@PathVariable UUID id){
        jobrepo.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}

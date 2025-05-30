package com.ticket_managemnt_system.database_api.controller;

import com.ticket_managemnt_system.database_api.models.Project;
import com.ticket_managemnt_system.database_api.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/db/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;


    @PostMapping("/create")
    public ResponseEntity createProject(@RequestBody Project project){
        projectRepository.save(project);
        return new ResponseEntity(project, HttpStatus.CREATED);
    }

}

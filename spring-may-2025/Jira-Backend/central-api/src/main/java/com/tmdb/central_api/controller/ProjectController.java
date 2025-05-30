package com.tmdb.central_api.controller;

import com.tmdb.central_api.dto.CreateProjectDto;
import com.tmdb.central_api.dto.GeneralMessageDto;
import com.tmdb.central_api.exceptions.UnAuthorizedException;
import com.tmdb.central_api.models.Project;
import com.tmdb.central_api.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/central/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity createProject(@RequestBody CreateProjectDto projectDetail,
                                        @RequestHeader String Authorization){
        try{
            Project project = projectService.createProject(projectDetail, Authorization);
            return new ResponseEntity(project, HttpStatus.CREATED);
        }catch (UnAuthorizedException unAuthorizedException){
            GeneralMessageDto gm = new GeneralMessageDto(unAuthorizedException.getMessage());
            return new ResponseEntity(gm, HttpStatus.UNAUTHORIZED);
        }
    }
}

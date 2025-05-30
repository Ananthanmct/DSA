package com.tmdb.central_api.service;

import com.tmdb.central_api.dto.CreateProjectDto;
import com.tmdb.central_api.exceptions.UnAuthorizedException;
import com.tmdb.central_api.middleware.DbApiIntgeration;
import com.tmdb.central_api.models.Employee;
import com.tmdb.central_api.models.Organization;
import com.tmdb.central_api.models.Project;
import com.tmdb.central_api.util.MappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    AuthService authService;

    @Autowired
    OrgService orgService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DbApiIntgeration dbApiIntgeration;

    @Autowired
    MappingUtil mappingUtil;

    public Project createProject(CreateProjectDto projectDetails,
                              String Authorization){
        boolean isValid = authService.checkAccessAvailable(Authorization, "CREATE_PROJECT");
        if(isValid == false){
            throw new UnAuthorizedException("Does not have access");
        }
        // organizaion
        // Employee

        Organization org = orgService.getOrganizationById(projectDetails.getOrgId());
        String creatorEmail = authService.getEmailFromJwtToken(Authorization);
        Employee creator = employeeService.getEmployeeByEmail(creatorEmail);
        Project project = mappingUtil.createProjectObjectFromProjectDetailsDto(projectDetails,
                org,
                creator);

        Project resp = dbApiIntgeration.callCreateProjectEndpoint(project);
        // Notification APi
        return resp;
    }
}

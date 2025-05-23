package com.tmdb.central_api.service;

import com.tmdb.central_api.dto.OrgDetailDto;
import com.tmdb.central_api.middleware.DbApiIntgeration;
import com.tmdb.central_api.middleware.NotificationAPIConnector;
import com.tmdb.central_api.models.Employee;
import com.tmdb.central_api.models.Organization;
import com.tmdb.central_api.models.Role;
import com.tmdb.central_api.util.MappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrgService {

    @Autowired
    DbApiIntgeration dbapiIntg;

    @Autowired
    NotificationAPIConnector notificationAPIConnector;

    @Autowired
    MappingUtil mapper;

    @Autowired
    RoleService roleService;

    @Autowired
    EmployeeService employeeService;

    public Object createOrganization(OrgDetailDto orgDetailDto){
        // OrgDetailDTO
        // We need to map these details to actual organization model object.
        Organization organization = mapper.mapOrgDetailDtoToOrganization(orgDetailDto);
        Organization org =  dbapiIntg.callCreateOrganizationEndpoint(organization);
        // When Org will get created then we should create default admin role for the org
        Role role  = roleService.createDefaultAdminRole(org);
        // When role got created inside the system lets create the first employee of organization i.e. System Admin
        Employee employee = mapper.mapOrgAdminDetailsToEmployee(org, role);
        employee = employeeService.saveEmployeeToDB(employee);
        notificationAPIConnector.callOrgCreateNotificationEndpoint(organization);
        return org;
    }
}

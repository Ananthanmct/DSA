package com.tmdb.central_api.service;

import com.tmdb.central_api.dto.CreateRoleDto;
import com.tmdb.central_api.middleware.DbApiIntgeration;
import com.tmdb.central_api.models.Operation;
import com.tmdb.central_api.models.Organization;
import com.tmdb.central_api.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    OperationService operationService;

    @Autowired
    DbApiIntgeration dbApiIntgeration;

    public Role createDefaultAdminRole(Organization organization){
        Role role = new Role();
        role.setCreatedAt(LocalDateTime.now());
        role.setUpdatedAt(LocalDateTime.now());
        role.setName("org-admin");
        role.setOrganization(organization);
        List<Operation> oprs = operationService.getAllOperations();
        role.setOperations(oprs);
        return this.saveRoleToDB(role);
    }

    public Role createRole(CreateRoleDto createRoleDto, String Authorization){
        // We need to verify whatever token we are recieving that token will belong to an employee.
        // that employee is having access to create role or not.
    }

    public Role saveRoleToDB(Role role){
        return dbApiIntgeration.callSaveRoleEndpoint(role);
    }

}

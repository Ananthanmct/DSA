package com.tmdb.central_api.service;

import com.tmdb.central_api.dto.CreateRoleDto;
import com.tmdb.central_api.exceptions.UnAuthorizedException;
import com.tmdb.central_api.middleware.DbApiIntgeration;
import com.tmdb.central_api.models.Operation;
import com.tmdb.central_api.models.Organization;
import com.tmdb.central_api.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RoleService {

    @Autowired
    OperationService operationService;

    @Autowired
    DbApiIntgeration dbApiIntgeration;

    @Autowired
    AuthService authService;


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
        boolean isValid = authService.checkAccessAvailable(Authorization, "CREATE_ROLE");
        if(isValid == false){
            throw new UnAuthorizedException("Does not have access to create role");
        }
        List<Operation> operations = operationService.getAllOperationsByOperationName(createRoleDto.getOperations());
        Role role = new Role();
        role.setOperations(operations);
        role.setName(createRoleDto.getRoleName());
        UUID orgId = UUID.fromString(authService.getOrgIdFromToken(Authorization));
        Organization org = this.getOrganizationById(orgId);
        role.setOrganization(org);
        role.setCreatedAt(LocalDateTime.now());
        role.setUpdatedAt(LocalDateTime.now());
        return this.saveRoleToDB(role);
    }

    public Organization getOrganizationById(UUID orgId){
        return  dbApiIntgeration.callGetOrganizationById(orgId);
    }

    public Role saveRoleToDB(Role role){
        return dbApiIntgeration.callSaveRoleEndpoint(role);
    }

}

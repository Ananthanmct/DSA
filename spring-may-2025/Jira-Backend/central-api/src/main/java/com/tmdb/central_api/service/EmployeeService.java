package com.tmdb.central_api.service;

import com.tmdb.central_api.dto.InviteEmployeeDto;
import com.tmdb.central_api.dto.LoginDto;
import com.tmdb.central_api.dto.UserDetailDto;
import com.tmdb.central_api.exceptions.UnAuthorizedException;
import com.tmdb.central_api.exceptions.WrongCredentialsException;
import com.tmdb.central_api.middleware.AuthApiConnector;
import com.tmdb.central_api.middleware.DbApiIntgeration;
import com.tmdb.central_api.middleware.NotificationAPIConnector;
import com.tmdb.central_api.models.Employee;
import com.tmdb.central_api.models.Organization;
import com.tmdb.central_api.models.Role;
import com.tmdb.central_api.util.MappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    DbApiIntgeration dbApiIntgeration;

    @Autowired
    RoleService roleService;

    @Autowired
    AuthService authService;

    @Autowired
    AuthApiConnector authApiConnector;

    @Autowired
    MappingUtil mappingUtil;

    @Autowired
    NotificationAPIConnector notificationAPIConnector;



    public Employee saveEmployeeToDB(Employee employee){
        return dbApiIntgeration.callSaveEmployeeEndpoint(employee);
    }

    public Employee getEmployeeByEmail(String email){
        return dbApiIntgeration.callGetEmployeeByEmailEndpoint(email);
    }
    public String loginEmployee(LoginDto loginDetails){
        String email = loginDetails.getEmail();
        String password = loginDetails.getPassword();
        Employee employee  = this.getEmployeeByEmail(email);
        if(employee == null){
            throw new WrongCredentialsException("Wrong email entered");
        }
        if(employee.getPassword().equals(password)){
            // We will generate token
            // central api is going to call auth api connector class
            // and auth api connector class will hit auth api generateToken endpoint and will bring that token to us.
            UserDetailDto userDetailDto = new UserDetailDto();
            userDetailDto.setEmail(employee.getEmail());
            userDetailDto.setPassword(employee.getPassword());
            userDetailDto.setRole(employee.getRoles().get(0).getName());
            userDetailDto.setOrgId(employee.getOrganization().getId().toString());
            String token = authApiConnector.callGetJwtTokenEndpoint(userDetailDto);
            return token;
        }
        throw new WrongCredentialsException("Wrong Password entered");
    }

    public Employee inviteEmployeeToOrg(
            InviteEmployeeDto employeeDetails,
            String Authorization
    ){
        boolean authResp = authService.checkAccessAvailable(Authorization, "INVITE_EMPLOYEE");
        if(authResp == false){
            throw new UnAuthorizedException("Does not have access to invite employee");
        }

        // To map employeeDetails from EmployeeDto to Employee Model we will require organization object and Role object
        UUID orgId = employeeDetails.getOrgId();
        UUID roleId = employeeDetails.getRoles().get(0);
        Organization org = roleService.getOrganizationById(orgId);
        Role role = roleService.getRoleById(roleId);
        Employee employee  = mappingUtil.mapInviteEmployeeDetailsToEmployee(employeeDetails, org, role);
        employee = this.saveEmployeeToDB(employee);
        // We have saved the employee object in db now we need to call notification api to notify employee
        // that you are inviyed to join this org
        notificationAPIConnector.callInviteEmployeeNotificationEndpoint(employee);
        return employee;
    }
}

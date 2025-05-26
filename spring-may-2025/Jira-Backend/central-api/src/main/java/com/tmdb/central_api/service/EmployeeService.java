package com.tmdb.central_api.service;

import com.tmdb.central_api.dto.LoginDto;
import com.tmdb.central_api.dto.UserDetailDto;
import com.tmdb.central_api.exceptions.WrongCredentialsException;
import com.tmdb.central_api.middleware.AuthApiConnector;
import com.tmdb.central_api.middleware.DbApiIntgeration;
import com.tmdb.central_api.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    DbApiIntgeration dbApiIntgeration;

    @Autowired
    AuthApiConnector authApiConnector;



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
            String token = authApiConnector.callGetJwtTokenEndpoint(userDetailDto);
            return token;
        }
        throw new WrongCredentialsException("Wrong Password entered");
    }
}

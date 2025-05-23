package com.tmdb.central_api.service;

import com.tmdb.central_api.middleware.DbApiIntgeration;
import com.tmdb.central_api.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    DbApiIntgeration dbApiIntgeration;

    public Employee saveEmployeeToDB(Employee employee){
        return dbApiIntgeration.callSaveEmployeeEndpoint(employee);
    }
}

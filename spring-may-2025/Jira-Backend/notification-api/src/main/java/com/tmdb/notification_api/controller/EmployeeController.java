package com.tmdb.notification_api.controller;

import com.tmdb.notification_api.model.Employee;
import com.tmdb.notification_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notify/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PutMapping("/invite/{token}")
    public void inviteEmployee(@RequestBody Employee employee,
                               @PathVariable String token) throws Exception{
        employeeService.sendInvitationMail(employee, token);
    }
}

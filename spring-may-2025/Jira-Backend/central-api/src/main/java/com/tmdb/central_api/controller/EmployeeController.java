package com.tmdb.central_api.controller;

import com.tmdb.central_api.dto.GeneralMessageDto;
import com.tmdb.central_api.dto.InviteEmployeeDto;
import com.tmdb.central_api.dto.LoginDto;
import com.tmdb.central_api.dto.TokenDto;
import com.tmdb.central_api.exceptions.WrongCredentialsException;
import com.tmdb.central_api.models.Employee;
import com.tmdb.central_api.service.EmployeeService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/central/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/login")
    public ResponseEntity loginEmp(@RequestBody LoginDto loginDetails){
        try{
            String token = employeeService.loginEmployee(loginDetails);
            TokenDto tokenDto = new TokenDto();
            tokenDto.setToken(token);
            return new ResponseEntity(tokenDto, HttpStatus.OK);
        }catch (WrongCredentialsException e){
            String message = e.getMessage();
            GeneralMessageDto messageDto = new GeneralMessageDto();
            messageDto.setMessage(message);
            return new ResponseEntity(messageDto, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/invite")
    public ResponseEntity inviteEmployee(@RequestBody InviteEmployeeDto employeeDetails,
                                         @RequestHeader String Authorization){
        Employee employee = employeeService.inviteEmployeeToOrg(employeeDetails, Authorization);
        return new ResponseEntity(employee, HttpStatus.CREATED);
    }


    @GetMapping("/invite/accept/{token}")
    public ResponseEntity acceptInvitation(@PathVariable String token){
        Employee employee = employeeService.acceptInvitation(token);
        return new ResponseEntity(employee, HttpStatus.OK);
    }

}

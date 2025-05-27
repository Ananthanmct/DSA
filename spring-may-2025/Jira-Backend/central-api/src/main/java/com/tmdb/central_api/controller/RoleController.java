package com.tmdb.central_api.controller;

import com.tmdb.central_api.dto.CreateRoleDto;
import com.tmdb.central_api.dto.GeneralMessageDto;
import com.tmdb.central_api.exceptions.UnAuthorizedException;
import com.tmdb.central_api.models.Role;
import com.tmdb.central_api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/central/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity createRole(@RequestBody CreateRoleDto roleDetails,
                                     @RequestHeader String Authorization ){
        try{
            Role role = roleService.createRole(roleDetails, Authorization);
            return new ResponseEntity(role, HttpStatus.OK);
        }catch (UnAuthorizedException e){
            GeneralMessageDto generalMessageDto = new GeneralMessageDto();
            generalMessageDto.setMessage(e.getMessage());
            return new ResponseEntity(generalMessageDto, HttpStatus.UNAUTHORIZED);
        }

    }


}

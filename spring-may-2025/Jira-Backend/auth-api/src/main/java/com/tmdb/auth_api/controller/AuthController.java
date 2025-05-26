package com.tmdb.auth_api.controller;

import com.tmdb.auth_api.dto.StatusDto;
import com.tmdb.auth_api.dto.TokenDto;
import com.tmdb.auth_api.dto.UserDetailDto;
import com.tmdb.auth_api.security.JwtUtil;
import com.tmdb.auth_api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth/token")
public class AuthController {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthService authService;

    @PutMapping("/get")
    public ResponseEntity generateToken(@RequestBody UserDetailDto userDetails){
        String token = jwtUtil.generateToken(userDetails.getEmail(), userDetails.getPassword(), userDetails.getRole());
        return new ResponseEntity(token, HttpStatus.OK);
    }

    @GetMapping("/verify")
    public ResponseEntity verifyToken(@RequestHeader String Authorization){
        StatusDto statusDto = new StatusDto();
        String token = Authorization.substring(7);
        String details = jwtUtil.decryptToken(token);
        statusDto.setUserDetail(details);
        return new ResponseEntity(statusDto, HttpStatus.OK);
    }

    @GetMapping("/verify/operation/access")
    public ResponseEntity verifyOperationAccess(@RequestParam String operationName,
                                                @RequestParam UUID orgId,
                                                @RequestHeader String Authorization){
        String token = Authorization.substring(7);
        boolean result = authService.isValidAccess(token, orgId, operationName);
        TokenDto statusDto = new TokenDto();
        statusDto.setValid(result);
        if(result == false){
            return new ResponseEntity(statusDto, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity(statusDto, HttpStatus.OK);
    }
}

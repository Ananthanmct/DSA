package com.tmdb.auth_api.service;

import com.tmdb.auth_api.connector.DBAPI;
import com.tmdb.auth_api.models.Operation;
import com.tmdb.auth_api.models.Role;
import com.tmdb.auth_api.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    DBAPI dbapi;

    public boolean isValidAccess(String token,
                                 String oprName){
        String information = jwtUtil.decryptToken(token);
        String [] infoArr = information.split(":");
        String role = infoArr[2];
        UUID orgId = UUID.fromString(infoArr[3]);
        Role roleDb = dbapi.callGetRoleByOrgIdEndpoint(orgId, role);
        List<Operation> operations = roleDb.getOperations();
        for(Operation opr: operations){
            if(opr.getName().equals(oprName)){
                return true;
            }
        }
        return false;
    }
}

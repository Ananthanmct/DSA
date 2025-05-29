package com.tmdb.central_api.service;

import com.tmdb.central_api.dto.UserDetailDto;
import com.tmdb.central_api.middleware.AuthApiConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthApiConnector authApiConnector;


    public boolean checkAccessAvailable(String token,
                                        String oprName){
        // We need to call AuthAPI
       return  authApiConnector.callVerifyAccessEndpoint(oprName, token);
    }

    public String getOrgIdFromToken(String token){
        String userDetail = authApiConnector.callDecryptTokenEndpoint(token);
        String [] infoArr = userDetail.split(":");
        return infoArr[3];
    }

    public String getJwtTokenByUserDetails(UserDetailDto userDetail){
        return authApiConnector.callGetJwtTokenEndpoint(userDetail);
    }

    public String getEmailFromJwtToken(String token){
       String empDetails = authApiConnector.callDecryptTokenEndpoint("Bearer " + token);
       return empDetails.split(":")[0];
    }

}

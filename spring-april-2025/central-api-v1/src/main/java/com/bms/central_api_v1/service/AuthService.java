package com.bms.central_api_v1.service;

import com.bms.central_api_v1.exception.UnAuthorizedException;
import com.bms.central_api_v1.integration.AuthAPI;
import com.bms.central_api_v1.requestbody.SuccessResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthAPI authAPI;

    public void verifyToken(String Authorization){
        try{
            SuccessResponseBody successResponseBody = authAPI.callVerifyTokenEndpoint(Authorization);
        }catch (Exception e){
            throw new UnAuthorizedException(String.format("Invalid token"));
        }
    }
}

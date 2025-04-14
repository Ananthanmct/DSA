package com.bms.central_api_v1.service;

import com.bms.central_api_v1.requestbody.CreateUserRB;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void registerUser(CreateUserRB userRB){
        // Before hitting db api user service will create request for create user endpoint of dbapi
    }

}

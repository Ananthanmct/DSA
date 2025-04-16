package com.bms.central_api_v1.service;

import com.bms.central_api_v1.integration.DBAPI;
import com.bms.central_api_v1.requestbody.CreateUserRB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    DBAPI dbapi;

    public Object registerUser(CreateUserRB userRB){
        // Before hitting db api user service will create request for create user endpoint of dbapi
        log.info("Recieved call from controller to service for request body : " + userRB.toString());
        return dbapi.callCreateUserEndpoint(userRB);
    }

}

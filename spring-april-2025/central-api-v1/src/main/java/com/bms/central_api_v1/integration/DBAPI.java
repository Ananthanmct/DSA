package com.bms.central_api_v1.integration;

import com.bms.central_api_v1.models.AppUser;
import com.bms.central_api_v1.requestbody.CreateUserRB;
import com.bms.central_api_v1.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;

@Service
@Slf4j
public class DBAPI extends RestAPI {
    // This class will have different methods such that we make call to different endpoints of db api.
    // For example : You want to hit create user endpoint of dbapi so for that endpoint we will create one method.

    @Value("${db.api.base}")
    String baseUrl;

    @Autowired
    Mapper mapper;

    public Object callCreateUserEndpoint(CreateUserRB createUserRB){
        AppUser appUser = mapper.mapCreateUserRBToAppUser(createUserRB);
        String endPoint = "/user/create";
        log.info("Calling /user/create endpoint of dbapi");
        Object resp = this.makePostCall(baseUrl, endPoint, appUser, new HashMap<>());
        return resp;
    }
}

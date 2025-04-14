package com.bms.central_api_v1.integration;

import com.bms.central_api_v1.models.AppUser;
import com.bms.central_api_v1.requestbody.CreateUserRB;
import com.bms.central_api_v1.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;

import java.net.URI;

public class DBAPI {
    // This class will have different methods such that we make call to different endpoints of db api.
    // For example : You want to hit create user endpoint of dbapi so for that endpoint we will create one method.

    @Value("${db.api.base}")
    String baseUrl;

    @Autowired
    Mapper mapper;

    public void createUser(CreateUserRB createUserRB){
        // We need to map createUserRB to AppUser
        // Create url
        AppUser appUser = mapper.mapCreateUserRBToAppUser(createUserRB);
        String url = baseUrl + "/user/create";
        URI finalURL = URI.create(url);
        //2. STart creating request
        // RequestEntity : RequestEntity is the class which help us to create request
        RequestEntity request = RequestEntity.post(finalURL).body(appUser);
        // 3. Hit the request
    }
}

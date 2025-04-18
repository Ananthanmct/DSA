package com.bms.central_api_v1.service;

import com.bms.central_api_v1.exception.UnAuthorizedException;
import com.bms.central_api_v1.integration.DBAPI;
import com.bms.central_api_v1.models.AppUser;
import com.bms.central_api_v1.models.Theather;
import com.bms.central_api_v1.requestbody.CreateTheatherRB;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TheatherService {

    @Autowired
    UserService userService;

    @Autowired
    DBAPI dbapi;

    public Theather raiseCreateTheatherRequest(CreateTheatherRB theatherRB,
                                               UUID theatherOwnerId) throws UnAuthorizedException{
        boolean isTheatherOwner = userService.isTheatherOwner(theatherOwnerId);
        if (isTheatherOwner == false){
            throw new UnAuthorizedException(
                    String.format("User with id %s does not have access to create theather.", theatherOwnerId.toString())
            );
        }
        AppUser owner = userService.getUserById(theatherOwnerId);

        // We need to call db api to create theather record inside our theather table.
        return dbapi.callCreateTheatherEndpoint(theatherRB, owner);
    }
}

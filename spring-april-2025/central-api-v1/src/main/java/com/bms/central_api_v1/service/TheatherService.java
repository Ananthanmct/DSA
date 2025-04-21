package com.bms.central_api_v1.service;

import com.bms.central_api_v1.exception.UnAuthorizedException;
import com.bms.central_api_v1.integration.DBAPI;
import com.bms.central_api_v1.integration.NotificationAPI;
import com.bms.central_api_v1.models.AppUser;
import com.bms.central_api_v1.models.Theather;
import com.bms.central_api_v1.requestbody.CreateTheatherNotificationRB;
import com.bms.central_api_v1.requestbody.CreateTheatherRB;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TheatherService {

    @Autowired
    UserService userService;

    @Autowired
    DBAPI dbapi;

    @Autowired
    NotificationAPI notificationAPI;

    public void notifyAllAdminsRegardingnewTheatherReq(List<AppUser> admins, Theather theather){
        for(AppUser admin : admins){
            // we need to call notification api endpoint regarding theather request
            CreateTheatherNotificationRB theatherNotificationRB = new CreateTheatherNotificationRB();
            theatherNotificationRB.setTheather(theather);
            theatherNotificationRB.setAdmin(admin);
            notificationAPI.callNotifyAdminForTheatherRequestEndpoint(theatherNotificationRB);
        }
    }

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
        Theather theather  = dbapi.callCreateTheatherEndpoint(theatherRB, owner);


        // we need to call db api to bring all the admins from our database
        // 1. Are we having any getAllAdmins Endpoint developed in dbapi ? Yes
        // 2. Are we having any method developed in dbapi class (Integration package) which is going
        // to call db api get all admins endpoint ? Yes
        // 3. UserService class we are calling db api get all admins endpoint
        List<AppUser> admins =   userService.getAllAdmins();
        this.notifyAllAdminsRegardingnewTheatherReq(admins, theather);
        // Notify all the admins
        return theather;
    }
}

package com.bms.central_api_v1.util;

import com.bms.central_api_v1.models.AppUser;
import com.bms.central_api_v1.requestbody.CreateUserRB;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public AppUser mapCreateUserRBToAppUser(CreateUserRB createUserRB){
        AppUser appUser = new AppUser();
        appUser.setName(createUserRB.getName());
        appUser.setEmail(createUserRB.getEmail());
        appUser.setPassword(createUserRB.getPassword());
        appUser.setPincode(createUserRB.getPinCode());
        appUser.setAddress(createUserRB.getAddress());
        appUser.setState(createUserRB.getState());
        appUser.setPhoneNumber(createUserRB.getPhoneNumber());
        appUser.setUserType(createUserRB.getUserType().toString());
        return appUser;
    }

}

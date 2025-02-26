package com.mail.zepto.mail_api.requestbody;

import lombok.Data;

import java.util.UUID;

@Data
public class AppUser {
    UUID id;
    String name;
    String email;
    String password;
    Long phoneNumber;
    String userType;
    int pincode;
    String address;
    String status;
}


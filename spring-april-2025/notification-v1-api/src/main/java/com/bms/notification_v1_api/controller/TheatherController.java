package com.bms.notification_v1_api.controller;

import com.bms.notification_v1_api.requestbody.TheatherRequestRB;
import com.bms.notification_v1_api.service.TheatherMailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/notify/theather")
public class TheatherController {

    @Autowired
    TheatherMailService mailService;

    @GetMapping("/request")
    public void notifyAdminForCreateTheatherRequest(@RequestBody TheatherRequestRB theatherRequestRB) throws MessagingException {


        mailService.notifyAdminForCreateTheatherRequest(theatherRequestRB);

    }

}

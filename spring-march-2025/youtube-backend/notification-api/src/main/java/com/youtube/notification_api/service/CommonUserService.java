package com.youtube.notification_api.service;

import com.youtube.notification_api.dto.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class CommonUserService {

    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    JavaMailSender javaMailSender;

//    public void senduserRegistrationEmail(NotificationMessage notificationMessage){
//        // This function will send registration email to the user
//        // So, email is of type html So we need to get html template
//        // Before getting html template we need to create variables inside html template
//        Context context = new Context();
//        context.setVariable("userName", notificationMessage.getName());
//        context.setVariable("platformName", "Youtube");
//        // We need to get our html template inform of string and all the variables popluated inside html template
//        String htmlEmailContent = templateEngine.process("user-registration-email", context);
//        // templateEnine.process will insert values for all the variables defined inside html template
//        MimeMailMessage message = new MimeMailMessage();
//        // I need to set this html content inside MimeMessage
//
//
//
//    }
}

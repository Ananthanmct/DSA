package com.youtube.notification_api.controller;

import com.youtube.notification_api.dto.NotificationMessage;
import com.youtube.notification_api.enums.NotificationType;
import com.youtube.notification_api.service.CommonUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CommonController {

//    @Autowired
//    CommonUserService commonUserService;
////
////    @RabbitListener(queues = "notification-queue")
////    public void consumeMessage(@Payload NotificationMessage message){
////        // It will run at the point of time some notification message payload is inserted inside
////        // Notification-queue and as the listner is subscribed to the queue it will automatically get triggered
////        if(message.getType().equals(NotificationType.user_registration.toString())){
////            //
////            commonUserService.senduserRegistrationEmail(message);
////        }else if(message.getType().equals(NotificationType.channel_owner_subscriber_added.toString())){
////
////        }else{
////
////        }

    //}
}

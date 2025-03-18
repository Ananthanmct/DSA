package com.youtube.notification_api.controller;

import com.youtube.notification_api.dto.NotificationMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CommonController {

    @RabbitListener(queues = "notification-queue")
    public void consumeMessage(@Payload NotificationMessage message){
        log.info(message.toString());
    }
}

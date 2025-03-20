package com.youtube.central.service;

import com.youtube.central.dto.CreateChannelRequestBody;
import com.youtube.central.dto.NotificationMessage;
import com.youtube.central.exceptions.UserNotFound;
import com.youtube.central.models.AppUser;
import com.youtube.central.models.Channel;
import com.youtube.central.repository.ChannelRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class ChannelService {

    @Autowired
    UserService userService;

    @Autowired
    RabbitMqService rabbitMqService;

    @Autowired
    ChannelRepo channelRepo;

    public void createChannel(CreateChannelRequestBody channelDetails){
        String email = channelDetails.getUserEmail();
        // we need to check with this email user is present inside database or not
        AppUser user = userService.getUserByEmail(email);
        if(user == null){
            // User does not exist it is wrong email
            throw new UserNotFound(
                    String.format("User with email id %s does not exist in system", email)
            );
        }
        // We need to create channel for that user.
        Channel channel = new Channel();
        channel.setCreatedAt(LocalDateTime.now());
        channel.setUpdatedAt(LocalDateTime.now());
        channel.setMonetized(false);
        channel.setUser(user);
        channel.setDescription(channel.getDescription());
        channel.setName(channelDetails.getChannelName());

        // call my repo layer which will save channel inside channel table
        channelRepo.save(channel);

        // Notify user that hey we have created channel for you in your system
        // We need to mail user
        // So to mail user we need to upload notification message at our message queue

        NotificationMessage notificationMessage = new NotificationMessage();
        notificationMessage.setName(user.getName());
        notificationMessage.setType("create_channel");
        notificationMessage.setEmail(user.getEmail());
        rabbitMqService.insertMessageToQueue(notificationMessage);
    }
}

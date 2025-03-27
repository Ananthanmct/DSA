package com.youtube.video_service.service;

import com.youtube.video_service.dto.VideoDetailRequestBody;
import com.youtube.video_service.dto.VideoDetailsDTO;
import com.youtube.video_service.util.ApiTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

// Work of this class is to call central api endpoints
@Service
public class CentralApiConnectionService {

    @Autowired
    ApiTemplate apiTemplate;

    @Value("${central.api.url}")
    String centralApiUrl;

    // Save video details method is going to call save video details endpoint present in central
    public void saveVideoDetails(
        UUID channelId,
        VideoDetailsDTO videoDetailsDTO
    ){
        // i need to call save video details endpoint declared in your  channel controller of central api
        String endPoint = "/channel/" + channelId.toString() +  "/video/upload";
        // apiurl, endpoint, queryparams, requestbody
        Object resp = apiTemplate.makePostCall(centralApiUrl, endPoint, new HashMap<>(), videoDetailsDTO);
    }
}

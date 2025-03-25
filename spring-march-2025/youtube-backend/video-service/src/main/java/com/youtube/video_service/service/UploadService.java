package com.youtube.video_service.service;

import com.youtube.video_service.dto.VideoDetail;
import com.youtube.video_service.exception.InvalidFileType;
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.exceptions.*;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadService {

    @Autowired
    ImageKit imageKit;

    public boolean isVideoFile(MultipartFile file){
        boolean res = file.getContentType().startsWith("video/");
        return res;
    }

    public VideoDetail uploadVideo(MultipartFile video) throws IOException, ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException, BadRequestException, UnknownException {
        // We need to validate file is having what kind of type
        boolean isVideo = isVideoFile(video);
        if(!isVideo){
            throw new InvalidFileType("File uploaded is not video");
        }

            // If file is of type video then we need to convert it in byte array
            byte [] videoBytes = video.getBytes(); // so to pass over the network we are converting our multipart file to videobytes

            // We need to create one request which we will upload it to imagekit.io

            FileCreateRequest videoRequest = new FileCreateRequest(videoBytes, video.getOriginalFilename());
            videoRequest.setUseUniqueFileName(true);

            Result result = imageKit.upload(videoRequest); // By this line video will get uploaded over image kit server.
            String videoId = result.getFileId();
            String videoUrl = result.getUrl();

            VideoDetail videoDetail = new VideoDetail();
            videoDetail.setVideoId(videoId);
            videoDetail.setVideoUrl(videoUrl);

            return videoDetail;
    }
}

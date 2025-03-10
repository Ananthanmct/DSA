package com.acciojob.backend.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class StudentService {
    public Object getAllStudents(){

        // We need to write code such that we will hit student api get student by institute name endpoinyt
        String url = "http://localhost:8080/api/v1/student/iit-delhi";
        URI uri = URI.create(url);

        System.out.println("AccioJob: In Service layer student api url created " + url);
        // RequestEntity

       RequestEntity request = RequestEntity.post(url).build();

        System.out.println("Acciojob: Request entity created");

       // So too hit this request we require RestTemplate class

        RestTemplate restTemplate = new RestTemplate();

        System.out.println("Acciojob: Calling student api get student by institute name endpoint");

        ResponseEntity<Object> resp = restTemplate.exchange(uri, HttpMethod.GET, request, Object.class);

        System.out.println("Acciojob: Call successfull");

        return resp.getBody();
    }
}

package com.tmdb.central_api.middleware;

import com.tmdb.central_api.models.Organization;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class DbApiIntgeration {

    public Object callCreateOrganizationEndpoint(Organization organization){
        // This function will call /organization/create endpoint of the db api

        // Step1 : Create endpoint
        String endpoint = "http://localhost:8080/api/v1/db/organization/create";
        // Step2 : Create Request
        RequestEntity request = RequestEntity.post(endpoint).body(organization);
        // Step3 : Hit the request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> respone = restTemplate.exchange(endpoint, HttpMethod.POST, request, Object.class); // When this exchange method will get called at that time we will be hitting our request to the db api
        return respone.getBody();
    }


}

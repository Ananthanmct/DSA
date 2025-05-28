package com.tmdb.central_api.middleware;

import com.tmdb.central_api.models.Employee;
import com.tmdb.central_api.models.Organization;
import com.tmdb.central_api.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotificationAPIConnector {

    String baseUrl = "http://localhost:8082/api/v1/notify";

    public void callOrgCreateNotificationEndpoint(Organization organization){
        // This function is going to make request to notification api
        // /org/create endpoint
        String url = baseUrl + "/org/create";
        RequestEntity request = RequestEntity
                .put(url)
                .body(organization);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> resp = restTemplate.exchange(url, HttpMethod.PUT, request, Object.class);
    }

    public void callInviteEmployeeNotificationEndpoint(Employee employee){
        String url = baseUrl + "/emp/invite";
        RequestEntity request = RequestEntity
                .put(url)
                .body(employee);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> resp = restTemplate.exchange(url, HttpMethod.PUT, request, Employee.class);
    }

}

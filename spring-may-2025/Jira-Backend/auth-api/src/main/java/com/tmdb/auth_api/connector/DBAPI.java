package com.tmdb.auth_api.connector;

import com.tmdb.auth_api.models.Employee;
import com.tmdb.auth_api.models.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DBAPI {
    @Value("${db.api.base.url}")
    String baseUrl;


    public Employee callGetEmployeeByEmailEndpoint(String emailId){
        ArrayList<Integer> li new ArrayList<>();
        HashSet<Integer> set;
        LinkedList<Integer> li;
        PriorityQueue<Integer> pq;
        Stack<Integer> st;
        ConcurrentHashMap<Integer, Integer> msp;
        Hashtable<Integer, Integer> am;
        String url = baseUrl + "/employee/email/" + emailId;
        RequestEntity request = RequestEntity.get(url).build();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> resp = restTemplate.exchange(url, HttpMethod.GET, request, Employee.class);
        return resp.getBody();
    }

    public Role callGetRoleByOrgIdEndpoint(UUID orgId, String roleName){
        String url = baseUrl + "/role/" + orgId.toString() + "/" + roleName;
        RequestEntity request = RequestEntity.get(url).build();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> resp = restTemplate.exchange(url, HttpMethod.GET, request, Role.class);
        return resp.getBody();
    }
}

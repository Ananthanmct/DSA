package com.central.zepto.central_api.Util;

import com.central.zepto.central_api.models.AppUser;
import com.central.zepto.central_api.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class DatabaseAPIUtil {

    String dbApiUrl = "/api/v1/db";

    public AppUser callCreateUserEndpoint(AppUser user){
        //creation of url
        String url = "http://localhost:8081" + dbApiUrl + "/user/save";
        URI finalUrl = URI.create(url);
        //create request entity
        RequestEntity request = RequestEntity.post(finalUrl).body(user);
        // Create rest Template
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AppUser> response =restTemplate.exchange(url, HttpMethod.POST, request, AppUser.class);
        return response.getBody();
    }

    public Product callCreateProductEndPoint(Product product){

        String url = "http://localhost:8081" + dbApiUrl + "/product/save";
        URI finalUrl = URI.create(url);

        RequestEntity request = RequestEntity.post(finalUrl).body(product);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> response = restTemplate.exchange(finalUrl, HttpMethod.POST, request, Product.class);
        return response.getBody();
    }

    public AppUser getUserByEmail(String email){
        String url = "http://localhost:8081" + dbApiUrl + "/user/email/" + email;
        URI finalURl = URI.create(url);

        RequestEntity request = RequestEntity.get(finalURl).build();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AppUser> response = restTemplate.exchange(url, HttpMethod.GET, request, AppUser.class);
        return response.getBody();
    }
}

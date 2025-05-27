package com.tmdb.central_api.middleware;

import com.tmdb.central_api.dto.TokenDetailsDto;
import com.tmdb.central_api.dto.TokenResDto;
import com.tmdb.central_api.dto.UserDetailDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthApiConnector {
    @Value("${auth.api.base.url}")
    String baseUrl;

    public String callGetJwtTokenEndpoint(UserDetailDto userDetailDto){
        String url = baseUrl + "/get";
        RequestEntity request = RequestEntity.put(url).body(userDetailDto);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resp  = restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
        return resp.getBody();
    }

    public boolean callVerifyAccessEndpoint(String opeationName, String token){
        try{
            String url = baseUrl + "/verify/operation/access/" + opeationName;
            RequestEntity request = RequestEntity.get(url).header("Authorization", token).build();
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<TokenResDto> resp = restTemplate.exchange(url, HttpMethod.GET, request, TokenResDto.class);
            return resp.getBody().isValid();
        }catch (Exception e){
            return false;
        }


    }

    public String callDecryptTokenEndpoint(String token){
        String url = baseUrl + "/verify";
        RequestEntity request = RequestEntity.get(url).header("Authorization", token).build();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TokenDetailsDto> resp = restTemplate.exchange(url, HttpMethod.GET, request, TokenDetailsDto.class);
        return resp.getBody().getUserDetail();
    }


}

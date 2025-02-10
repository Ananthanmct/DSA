package com.weather.api.demo.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Repository
public class WeatherRepository {

    @Value("${weather.api.accesskey}")
    String accessKey;

    public Object getCityWeather(String city){
        // 1. Create URL
        String url = "https://api.weatherstack.com/current?" + "access_key=" + accessKey
                + "&" + "query=" + city;
        URI finalURL = URI.create(url);
        // Create request -> RequestEntity
        RequestEntity request = RequestEntity.get(finalURL).build();
        // Hit The request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response  = restTemplate.exchange(finalURL, HttpMethod.GET, request, Object.class);
        return response.getBody();
    }
}

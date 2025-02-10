package com.weather.api.demo.service;

import com.weather.api.demo.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    public Object getCityWeather(String city){
        return weatherRepository.getCityWeather(city);
    }
}

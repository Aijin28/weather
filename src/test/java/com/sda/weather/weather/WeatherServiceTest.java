package com.sda.weather.weather;

import com.sda.weather.localisation.LocalisationFetchService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    @Mock
    LocalisationFetchService localisationFetchService;
    @InjectMocks
    WeatherService weatherService;

    @Test
    void getWeather_returnCorrectWeather(){
        weatherService.getWeather(1L, "4");
    }

}
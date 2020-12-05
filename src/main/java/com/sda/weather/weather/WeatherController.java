package com.sda.weather.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;
    private final WeatherMapper weatherMapper;

    @GetMapping("/localisation/{id}/weather")
    WeatherDto getWeather(@PathVariable Long id, @RequestParam(required = false) String period) {
        Weather weather = weatherService.getWeather(id, period);
        return weatherMapper.mapToWeatherDto(weather);
    }

    @GetMapping("/weather")
    String getWeather(@RequestParam String cityName, @RequestParam(required = false) String date) {
        return null;
    }
}

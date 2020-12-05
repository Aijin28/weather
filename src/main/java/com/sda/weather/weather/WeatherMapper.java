package com.sda.weather.weather;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class WeatherMapper {

    WeatherDto mapToWeatherDto(Weather weather) {
        return WeatherDto.builder()
                .id(weather.getId())
                .temperature(weather.getTemperature())
                .humidity(weather.getHumidity())
                .windDegree(weather.getWindDegree())
                .windSpeed(weather.getWindSpeed())
                .airPressure(weather.getAirPressure())
                .build();

    }
}

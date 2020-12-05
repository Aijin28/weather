package com.sda.weather.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weather.localisation.Localisation;
import com.sda.weather.localisation.LocalisationFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
class WeatherService {

    private final LocalisationFetchService localisationFetchService;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public Weather getWeather(Long id, String period) {
        Localisation localisation = localisationFetchService.fetchLocalisation(id);
        String cityName = localisation.getCityName();

        String url = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("api.openweathermap.org/data/2.5/forecast")
                .queryParam("q", cityName)
                .queryParam("appid", "a7f56c4235d1e36534313e315ea5e35a")
                .build().toUriString();

        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        String response = entity.getBody();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try{
            ForecastOpenWeatherResponse forecast = objectMapper.readValue(response, ForecastOpenWeatherResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new Weather();
    }
}

package com.sda.weather.localisation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocalisationDto {
    private Long id;
    private String cityName;
    private String countryName;
    private Float latitude;
    private Float longitude;
    private String region;

    public Optional<String> getRegion() {
        return Optional.ofNullable(region);
    }
}

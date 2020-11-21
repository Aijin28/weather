package com.sda.weather.localisation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalisationDto {
    Long id;
    String cityName;
    String countryName;
    Float latitude;
    Float longitude;
    String region;
}

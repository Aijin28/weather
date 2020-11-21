package com.sda.weather.localisation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Localisation {
    Long id;
    String cityName;
    String countryName;
    Float latitude;
    Float longitude;
    String region;
}

package com.sda.weather.localisation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocalisationDefinition {
    String cityName;
    String countryName;
    Float latitude;
    Float longitude;
    String region;
}

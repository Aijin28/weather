package com.sda.weather.localisation;

import org.springframework.stereotype.Component;

@Component
public class LocalisationMapper {

    LocalisationDto mapLocalisationDtoToLocalisation(Localisation localisation){
        return LocalisationDto
                .builder()
                .id(localisation.getId())
                .cityName(localisation.getCityName())
                .countryName(localisation.getCountryName())
                .latitude(localisation.getLatitude())
                .longitude(localisation.getLongitude())
                .region(localisation.getRegion())
                .build();
    }
}

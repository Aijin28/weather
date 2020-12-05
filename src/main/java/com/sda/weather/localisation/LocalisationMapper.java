package com.sda.weather.localisation;

import org.springframework.stereotype.Component;

@Component
public class LocalisationMapper {

    LocalisationDto mapToLocalisationDtoFrom(Localisation localisation) {
        return LocalisationDto.builder()
                .id(localisation.getId())
                .cityName(localisation.getCityName())
                .countryName(localisation.getCountryName())
                .latitude(localisation.getLatitude())
                .longitude(localisation.getLongitude())
                .region(localisation.getRegion().orElse(null))
                .build();
    }

    LocalisationDefinition mapToLocalisationDefinitionFrom(LocalisationDto localisationDto) {
        return LocalisationDefinition.builder()
                .cityName(localisationDto.getCityName())
                .countryName(localisationDto.getCountryName())
                .region(localisationDto.getRegion())
                .latitude(localisationDto.getLatitude())
                .longitude(localisationDto.getLongitude())
                .build();
    }
}

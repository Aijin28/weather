package com.sda.weather.localisation;

import org.springframework.stereotype.Component;

@Component
public class LocalisationMapper {

    Localisation mapLocalisationToLocalisationDto(LocalisationDefinition localisationDefinition){
        return Localisation
                .builder()
                .cityName(localisationDefinition.getCityName())
                .countryName(localisationDefinition.getCountryName())
                .region(localisationDefinition.getRegion())
                .latitude(localisationDefinition.getLatitude())
                .longitude(localisationDefinition.getLongitude())
                .build();
    }

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

    LocalisationDto mapLocalisationDefinitionToLocalisationDto(LocalisationDefinition localisationDefinition){
        return LocalisationDto
                .builder()
                .cityName(localisationDefinition.getCityName())
                .countryName(localisationDefinition.getCountryName())
                .latitude(localisationDefinition.getLatitude())
                .longitude(localisationDefinition.getLongitude())
                .region(localisationDefinition.getRegion())
                .build();
    }
}

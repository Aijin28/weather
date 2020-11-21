package com.sda.weather.localisation;

import org.springframework.stereotype.Component;

@Component
public class LocalisationMapper {

    LocalisationDto mapToLocalisation(Localisation newLocalisation){
        LocalisationDto localisationDto = new LocalisationDto();
        localisationDto.setCityName(newLocalisation.getCityName());
        localisationDto.setCountryName(newLocalisation.getCountryName());
        localisationDto.setLongitude(newLocalisation.getLongitude());
        localisationDto.setLatitude(newLocalisation.getLatitude());
        localisationDto.setRegion(newLocalisation.getRegion());
        return localisationDto;
    }
}

package com.sda.weather.localisation;

import com.sda.weather.exception.BadCreationParametersException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LocalisationCreateService {

    final LocalisationRepository localisationRepository;

    Localisation createLocalisation(String cityName, String countryName, String region, Float longitude, Float latitude) {
        if (cityName == null && countryName == null && longitude == null && latitude == null) {
            throw new BadCreationParametersException("Parameters cannot be empty (region is optional)");
        }
        if (longitude < -90 && longitude > 90) {
            throw new BadCreationParametersException("Longitude out of range (-90 to 90)");
        }
        if (latitude < -180 && latitude > 180) {
            throw new BadCreationParametersException("Latitude out of range (-180 to 180)");
        }
        Localisation localisation = new Localisation();
        localisation.setCityName(cityName);
        localisation.setCountryName(countryName);
        localisation.setLatitude(latitude);
        localisation.setLongitude(longitude);
        if (region != null) {
            localisation.setRegion(region);
        }
        return localisationRepository.save(localisation);
    }
}

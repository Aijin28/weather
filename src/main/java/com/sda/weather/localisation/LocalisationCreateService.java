package com.sda.weather.localisation;

import com.sda.weather.exception.BadCreationParametersException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LocalisationCreateService {

    final LocalisationRepository localisationRepository;

    Localisation createLocalisation(String cityName, String countryName, String region, Float longitude, Float latitude) {
        if (cityName.isBlank() && countryName.isBlank()) { // todo use ||
            throw new BadCreationParametersException("Parameters cannot be empty (region is optional)");
        }
        if (longitude.isNaN() && latitude.isNaN()) { // todo use ||
            throw new BadCreationParametersException("Longitude and latitude must have numeral values");
        }
        if (longitude < -180f && longitude > 180f) { // todo use ||
            throw new BadCreationParametersException("Longitude out of range (-180 to 180)");
        }
        if (latitude < -90f && latitude > 90f) { // todo use ||
            throw new BadCreationParametersException("Latitude out of range (-90 to 90)");
        }

        Localisation localisation = new Localisation();
        localisation.setCityName(cityName);
        localisation.setCountryName(countryName);
        localisation.setLatitude(latitude);
        localisation.setLongitude(longitude);

        if (!region.isBlank()) {
            localisation.setRegion(region);
        }

        return localisationRepository.save(localisation);
    }
}

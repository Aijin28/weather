package com.sda.weather.localisation;

import com.sda.weather.exception.BadCreationParametersException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LocalisationCreateService {

    final LocalisationRepository localisationRepository;

    Localisation createLocalisation(String cityName, String countryName, String region, Float longitute, Float latitude) {
        if (cityName == null && countryName == null && longitute == null && latitude == null) {
            throw new BadCreationParametersException("Parameters cannot be empty (region is optional)");
        }
        Localisation localisation = new Localisation();
        localisation.setCityName(cityName);
        localisation.setCountryName(countryName);
        localisation.setLatitude(latitude);
        localisation.setLongitude(longitute);
        if (region != null) {
            localisation.setRegion(region);
        }
        return localisationRepository.save(localisation);
    }
}

package com.sda.weather.localisation;

import com.sda.weather.exception.BadCreationParametersException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LocalisationCreateService {

    final LocalisationRepository localisationRepository;

    Localisation createLocalisation(LocalisationDefinition localisationDefinition) {
        if (localisationDefinition.getCityName().isBlank() || localisationDefinition.getCountryName().isBlank()) {
            throw new BadCreationParametersException("Parameters cannot be empty (region is optional)");
        }
        if (localisationDefinition.getLatitude().isNaN() || localisationDefinition.getLongitude().isNaN()) {
            throw new BadCreationParametersException("Longitude and latitude must have numeral values");
        }
        if (localisationDefinition.getLongitude() < -180f || localisationDefinition.getLongitude() > 180f) {
            throw new BadCreationParametersException("Longitude out of range (-180 to 180)");
        }
        if (localisationDefinition.getLatitude() < -90f || localisationDefinition.getLatitude() > 90f) {
            throw new BadCreationParametersException("Latitude out of range (-90 to 90)");
        }

        Localisation localisation = Localisation.builder()
                .cityName(localisationDefinition.getCityName())
                .countryName(localisationDefinition.getCountryName())
                .longitude(localisationDefinition.getLongitude())
                .latitude(localisationDefinition.getLatitude())
                .build();

        if (localisationDefinition.getRegion().isPresent()) {
            localisation.setRegion(localisationDefinition.getRegion().get());
        }

        return localisationRepository.save(localisation);
    }
}

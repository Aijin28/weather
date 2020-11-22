package com.sda.weather.localisation;

import com.sda.weather.exception.LocalisationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocalisationFetchService {

    final LocalisationRepository localisationRepository;

    Localisation fetchLocalisation(Long id){
        return localisationRepository.findById(id)
                .orElseThrow(() -> new LocalisationNotFoundException(id));
    }
}

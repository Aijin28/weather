package com.sda.weather.localisation;

import com.sda.weather.exception.LocalisationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LocalisationFetchService {

    final LocalisationRepository localisationRepository;

    public Localisation fetchLocalisation(Long id) {
        return localisationRepository.findById(id)
                .orElseThrow(() -> new LocalisationNotFoundException(id));
    }

    List<Localisation> fetchAllLocalisations() {
        return new ArrayList<>(localisationRepository.findAll());
    }
}

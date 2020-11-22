package com.sda.weather.localisation;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Log4j2
public class LocalisationController {

    final LocalisationCreateService localisationCreateService;
    final LocalisationFetchService localisationFetchService;
    final LocalisationMapper localisationMapper;

    // todo @GetMapping("/localisation")

    @GetMapping("/localisation/{id}")
    LocalisationDto getLocalisation(@PathVariable Long id) {
        Localisation localisation = localisationFetchService.fetchLocalisation(id);
        return localisationMapper.mapLocalisationDtoToLocalisation(localisation);
    }

    @PostMapping("/localisation")
    ResponseEntity<LocalisationDto> createLocalisation(@RequestBody LocalisationDto localisationDto) {
        String cityName = localisationDto.getCityName();
        String countryName = localisationDto.getCountryName();
        Float longitude = localisationDto.getLongitude();
        Float latitude = localisationDto.getLatitude();
        String region = localisationDto.getRegion();
        // todo wrap a data LocationDefinition use mapper
        Localisation localisation = localisationCreateService.createLocalisation(cityName, countryName, region, longitude, latitude);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(localisationMapper.mapLocalisationDtoToLocalisation(localisation));
    }
}

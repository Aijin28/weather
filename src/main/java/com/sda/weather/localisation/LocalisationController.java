package com.sda.weather.localisation;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Log4j2
public class LocalisationController {

    final LocalisationCreateService localisationCreateService;
    final LocalisationFetchService localisationFetchService;
    final LocalisationMapper localisationMapper;

    @GetMapping("/localisation")
    List<LocalisationDto> getAllLocalisations() {
        return localisationFetchService.fetchAllLocalisations().stream()
                .map(localisationMapper::mapLocalisationToLocalisationDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/localisation/{id}")
    LocalisationDto getLocalisation(@PathVariable Long id) {
        Localisation localisation = localisationFetchService.fetchLocalisation(id);
        return localisationMapper.mapLocalisationToLocalisationDto(localisation);
    }

    @PostMapping("/localisation")
    ResponseEntity<LocalisationDto> createLocalisation(@RequestBody LocalisationDto localisationDto) {
        LocalisationDefinition localisationDefinition = localisationMapper.mapLocalisationDtoToLocalisationDefinition(localisationDto);
        Localisation localisation = localisationCreateService.createLocalisation(localisationDefinition);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(localisationMapper.mapLocalisationToLocalisationDto(localisation));
    }
}

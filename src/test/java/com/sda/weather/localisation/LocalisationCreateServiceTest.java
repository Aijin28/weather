package com.sda.weather.localisation;

import com.sda.weather.exception.BadCreationParametersException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LocalisationCreateServiceTest {

    @Mock
    LocalisationRepository localisationRepository;
    @InjectMocks
    LocalisationCreateService localisationCreateService;

    @Test
    void createLocalisation_callsLocalisationRepository() {
        // given
        when(localisationRepository.save(any(Localisation.class))).thenReturn(new Localisation());
        LocalisationDefinition testLocalisation = LocalisationDefinition
                .builder()
                .cityName("cityTest")
                .countryName("countryTest")
                .region("regionTest")
                .longitude(0f)
                .latitude(0f)
                .build();
        // when
        localisationCreateService.createLocalisation(testLocalisation);
        // then
        verify(localisationRepository).save(any(Localisation.class));
    }

    @Test
    void createLocalisation_whenRegionIsEmpty_callsLocalisationRepository() {
        // given
        when(localisationRepository.save(any(Localisation.class))).thenReturn(new Localisation());
        LocalisationDefinition testLocalisation = LocalisationDefinition
                .builder()
                .cityName("cityTest")
                .countryName("countryTest")
                .region("")
                .longitude(0f)
                .latitude(0f)
                .build();
        // when
        localisationCreateService.createLocalisation(testLocalisation);
        // then
        verify(localisationRepository).save(any(Localisation.class));
    }

    @Test
    void createLocalisation_whenCitynameAndRegionIsBlank_throwsBadCreationParametersException() {
//        given
        LocalisationDefinition testLocalisation = LocalisationDefinition
                .builder()
                .cityName("")
                .countryName("countryTest")
                .region("")
                .longitude(0f)
                .latitude(0f)
                .build();
        // when
        Throwable result = catchThrowable(() -> localisationCreateService.createLocalisation(testLocalisation));
        // then
        assertThat(result).isExactlyInstanceOf(BadCreationParametersException.class);
        verify(localisationRepository, times(0)).save(any(Localisation.class));
    }

    @Test
    void createLocalisation_whenCountrynameAndRegionIsBlank_throwsBadCreationParametersException() {
//        given
        LocalisationDefinition testLocalisation = LocalisationDefinition
                .builder()
                .cityName("cityName")
                .countryName("")
                .region("")
                .longitude(0f)
                .latitude(0f)
                .build();
        // when
        Throwable result = catchThrowable(() -> localisationCreateService.createLocalisation(testLocalisation));
        // then
        assertThat(result).isExactlyInstanceOf(BadCreationParametersException.class);
        verify(localisationRepository, times(0)).save(any(Localisation.class));
    }

    @Test
    void createLocalisation_whenLongitudeIsOverRange_throwsBadCreationParametersException() {
//        given
        LocalisationDefinition testLocalisation = LocalisationDefinition
                .builder()
                .cityName("cityTest")
                .countryName("countryTest")
                .region("regionTest")
                .longitude(181f)
                .latitude(0f)
                .build();
        // when
        Throwable result = catchThrowable(() -> localisationCreateService.createLocalisation(testLocalisation));
        // then
        assertThat(result).isExactlyInstanceOf(BadCreationParametersException.class);
        verify(localisationRepository, times(0)).save(any(Localisation.class));
    }

    @Test
    void createLocalisation_whenLongitudeIsUnderRange_throwsBadCreationParametersException() {
//        given
        LocalisationDefinition testLocalisation = LocalisationDefinition
                .builder()
                .cityName("cityTest")
                .countryName("countryTest")
                .region("regionTest")
                .longitude(-181f)
                .latitude(0f)
                .build();
        // when
        Throwable result = catchThrowable(() -> localisationCreateService.createLocalisation(testLocalisation));
        // then
        assertThat(result).isExactlyInstanceOf(BadCreationParametersException.class);
        verify(localisationRepository, times(0)).save(any(Localisation.class));
    }

    @Test
    void createLocalisation_whenLatitudeIsUnderRange_throwsBadCreationParametersException() {
//        given
        LocalisationDefinition testLocalisation = LocalisationDefinition
                .builder()
                .cityName("cityTest")
                .countryName("countryTest")
                .region("regionTest")
                .longitude(0f)
                .latitude(-91f)
                .build();
        // when
        Throwable result = catchThrowable(() -> localisationCreateService.createLocalisation(testLocalisation));
        // then
        assertThat(result).isExactlyInstanceOf(BadCreationParametersException.class);
        verify(localisationRepository, times(0)).save(any(Localisation.class));
    }

    @Test
    void createLocalisation_whenLatitudeIsOverRange_throwsBadCreationParametersException() {
//        given
        LocalisationDefinition testLocalisation = LocalisationDefinition
                .builder()
                .cityName("cityTest")
                .countryName("countryTest")
                .region("regionTest")
                .longitude(0f)
                .latitude(91f)
                .build();
        // when
        Throwable result = catchThrowable(() -> localisationCreateService.createLocalisation(testLocalisation));
        // then
        assertThat(result).isExactlyInstanceOf(BadCreationParametersException.class);
        verify(localisationRepository, times(0)).save(any(Localisation.class));
    }


}

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
        // when
        localisationCreateService.createLocalisation("cityTest", "countryTest", "regionTest", 0f, 0f);
        // then
        verify(localisationRepository).save(any(Localisation.class));
    }

    @Test
    void createLocalisation_whenRegionIsEmpty_callsLocalisationRepository() {
        // given
        when(localisationRepository.save(any(Localisation.class))).thenReturn(new Localisation());
        // when
        localisationCreateService.createLocalisation("cityTest", "countryTest", " ", 0f, 0f);
        // then
        verify(localisationRepository).save(any(Localisation.class));
    }

    @Test
    void createLocalisation_whenParameterIsBlank_throwsBadCreationParametersException() {
        // when
        Throwable result = catchThrowable(() -> localisationCreateService.createLocalisation("", "", "", 0f, 0f));
        // then
        assertThat(result).isExactlyInstanceOf(BadCreationParametersException.class);
        verify(localisationRepository, times(0)).save(any(Localisation.class));
    }

    @Test
    void createLocalisation_whenLongitudeIsOutOfRange_throwsBadCreationParametersException() {
        // when
        Throwable result = catchThrowable(() -> localisationCreateService.createLocalisation("cityTest", "countryTest", "regionTest", 181f, 0f));
        // then
        assertThat(result).isExactlyInstanceOf(BadCreationParametersException.class);
        verify(localisationRepository, times(0)).save(any(Localisation.class));
    }
}

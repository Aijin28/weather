package com.sda.weather.localisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class LocationIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    LocalisationRepository localisationRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void createNewLocalisation_returnCREATEDStatusCode() throws Exception {
//        given
        localisationRepository.deleteAll();
        LocalisationDto testLocalisationDto = LocalisationDto
                .builder()
                .cityName("cityTest")
                .countryName("countryTest")
                .region("regionTest")
                .longitude(0f)
                .latitude(0f)
                .build();
        String requestBody = objectMapper.writeValueAsString(testLocalisationDto);
        MockHttpServletRequestBuilder post = post("/localisation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);
//        when
        MvcResult result = mockMvc.perform(post).andReturn();
//        then
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void createNewLocalisation_whenCityNameIsEmpty_returnBADREQUESTStatusCode() throws Exception {
//        given
        localisationRepository.deleteAll();
        LocalisationDto testLocalisationDto = LocalisationDto
                .builder()
                .cityName("")
                .countryName("countryTest")
                .region("regionTest")
                .longitude(0f)
                .latitude(0f)
                .build();
        String requestBody = objectMapper.writeValueAsString(testLocalisationDto);
        MockHttpServletRequestBuilder post = post("/localisation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);
//        when
        MvcResult result = mockMvc.perform(post).andReturn();
//        then
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}

package com.sda.weather.localisation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Localisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cityName;
    private String countryName;
    private Float latitude;
    private Float longitude;
    private String region;

    public Optional<String> getRegion() {
        return Optional.ofNullable(region);
    }
}

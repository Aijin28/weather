package com.sda.weather.localisation;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Localisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String cityName;
    String countryName;
    Float latitude;
    Float longitude;
    String region;
}

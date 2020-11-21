package com.sda.weather;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class LocalisationIntegrationTest {

    @Test
    void test() {
        assertThat(1).isEqualTo(1);
    }
}

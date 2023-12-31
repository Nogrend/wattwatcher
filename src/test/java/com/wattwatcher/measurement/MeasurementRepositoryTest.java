package com.wattwatcher.measurement;

import org.instancio.Instancio;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.instancio.Select.field;

@SpringBootTest
public class MeasurementRepositoryTest {
    @Autowired
    MeasurementRepository subject;

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("test-db")
            .withUsername("test-username")
            .withPassword("test-password");

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    void itShouldSaveAMeasurement() {
        // given
        var measurement = Instancio.of(Measurement.class)
                .set(field(Measurement::getTimestamp), Instant.now().truncatedTo(ChronoUnit.MILLIS))
                .create();

        // when
        subject.save(measurement);
        var actual = subject.findById(measurement.getId()).get();

        // then
        assertThat(actual, equalTo(measurement));
    }
}

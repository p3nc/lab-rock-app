package com.rockmusic.lab4_rock;

import com.rockmusic.lab4_rock.models.Band;
import com.rockmusic.lab4_rock.repo.BandRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Testcontainers
public class Lab5RockApplicationTests {

    @Container
    public static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    @Autowired
    private BandRepository bandRepository;

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mysqlContainer::getUsername);
        registry.add("spring.datasource.password", mysqlContainer::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
        registry.add("spring.jpa.properties.hibernate.dialect", () -> "org.hibernate.dialect.MySQLDialect");
    }

    @Test
    void testSaveAndRetrieveBand() {
        Band band = new Band();
        band.setName("Pink Floyd");
        band.setOriginCountry("UK");
        band.setYearFormed(1965);

        bandRepository.save(band);

        Band foundBand = bandRepository.findById(band.getId()).orElse(null);

        assertNotNull(foundBand);
        assertEquals("Pink Floyd", foundBand.getName());
    }
}
package com.example.stationski;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import com.example.stationski.repositories.AbonnementRepository;
import com.example.stationski.services.AbonnementService;
import com.example.stationski.entities.Abonnement;
import com.example.stationski.entities.TypeAbonnement;

import java.util.Collections;
import java.util.Set;

@SpringBootTest
@ExtendWith({MockitoExtension.class, SpringExtension.class})
class GestionStationSkiApplicationTests {

    @Mock
    AbonnementRepository abonnementRepository;

    @InjectMocks
    AbonnementService abonnementService;

    @Test
    public void testRetrieveAbonnementByType() {
        // Setup
        TypeAbonnement testType = TypeAbonnement.MENSUEL; // Example type, change as needed
        Set<Abonnement> expectedSet = Collections.singleton(new Abonnement());
        
        // Mocking
        Mockito.when(abonnementRepository.findByTypeAbon(testType)).thenReturn(expectedSet);

        // Execution
        Set<Abonnement> result = abonnementService.getAbonnementByType(testType);

        // Assertion
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(expectedSet, result);
    }
}
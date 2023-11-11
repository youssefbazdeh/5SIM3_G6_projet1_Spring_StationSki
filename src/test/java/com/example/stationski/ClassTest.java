package com.example.stationski;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;

import com.example.stationski.entities.Couleur;
import com.example.stationski.entities.Skieur;
import com.example.stationski.entities.TypeAbonnement;
import com.example.stationski.repositories.CoursRepository;
import com.example.stationski.repositories.PisteRepository;
import com.example.stationski.repositories.SkieurRepository;
import com.example.stationski.services.SkieurService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@ExtendWith({MockitoExtension.class, SpringExtension.class})
class SkieurServiceTest {

    @Mock
    private SkieurRepository skieurRepository;

    @Mock
    private PisteRepository pisteRepository;

    @Mock
    private CoursRepository coursRepository;

    @InjectMocks
    private SkieurService skieurService;

    @Test
    public void testRetrieveSkieursByTypeAbonnement() {
        // Setup
        TypeAbonnement testType = TypeAbonnement.MENSUEL;
        List<Skieur> expectedList = Arrays.asList(new Skieur());

        // Mocking
        Mockito.when(skieurRepository.findByAbonnementTypeAbon(testType)).thenReturn(expectedList);

        // Execution
        List<Skieur> result = skieurService.retrieveSkieursByTypeAbonnement(testType);

        // Assertion
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(expectedList, result);
    }

    // Additional test cases can be added here for methods like assignSkieurToPiste, addSkieurAndAssignToCourse, etc.

}

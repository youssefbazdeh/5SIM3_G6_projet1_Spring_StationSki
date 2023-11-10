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
import com.example.stationski.repositories.InscriptionRepository;
import com.example.stationski.repositories.CoursRepository;
import com.example.stationski.services.InscriptionService;
import com.example.stationski.entities.Inscription;
import com.example.stationski.entities.Cours;

import java.util.Optional;

@SpringBootTest
@ExtendWith({MockitoExtension.class, SpringExtension.class})
class InscriptionServiceTests {

    @Mock
    private InscriptionRepository inscriptionRepository;

    @Mock
    private CoursRepository coursRepository;

    @InjectMocks
    private InscriptionService inscriptionService;

    @Test
    public void testAssignInscriptionToCours() {
        // Setup
        Long numInscription = 123L; // Example number
        Long numCours = 456L; // Example number

        Inscription inscription = new Inscription();
        inscription.setIdInscription(1); // Example ID

        Cours cours = new Cours();
        cours.setIdCours(1); // Example ID

        // Mocking
        Mockito.when(inscriptionRepository.findByNumInscription(numInscription)).thenReturn(inscription);
        Mockito.when(coursRepository.findByNumCours(numCours)).thenReturn(cours);

        // Execution
        Inscription result = inscriptionService.assignInscriptionToCours(numInscription, numCours);

        // Assertion
        Assertions.assertNotNull(result);
        Assertions.assertEquals(cours, result.getCours()); // Check if the course is correctly assigned
    }
}

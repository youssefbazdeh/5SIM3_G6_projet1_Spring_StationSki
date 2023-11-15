package com.example.stationski;

import com.example.stationski.entities.Moniteur;
import com.example.stationski.repositories.MoniteurRepository;
import com.example.stationski.services.MoniteurServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
class GestionStationSkiApplicationTests {

    @Mock
    MoniteurRepository moniteurRepository;

    @InjectMocks
    MoniteurServiceImpl moniteurService;

    @Test
    public void testAddMoniteur() {
        // Setup
        Moniteur moniteurToAdd = new Moniteur(3, "Moniteur3", "Prenom3", 6000, new HashSet<>());

        // Mocking
        Mockito.when(moniteurRepository.save(moniteurToAdd)).thenReturn(moniteurToAdd);

        // Execution
        Moniteur addedMoniteur = moniteurService.addMoniteur(moniteurToAdd);

        // Assertion
        assertNotNull(addedMoniteur);
        assertEquals(moniteurToAdd.getIdMoniteur(), addedMoniteur.getIdMoniteur());
        assertEquals(moniteurToAdd.getNomM(), addedMoniteur.getNomM());
        assertEquals(moniteurToAdd.getPrenomM(), addedMoniteur.getPrenomM());
        assertEquals(moniteurToAdd.getPrime(), addedMoniteur.getPrime());
    }
}

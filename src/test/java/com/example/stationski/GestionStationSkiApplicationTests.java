package com.example.stationski;

import com.example.stationski.entities.Moniteur;
import com.example.stationski.repositories.CoursRepository;
import com.example.stationski.repositories.MoniteurRepository;
import com.example.stationski.services.MoniteurServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GestionStationSkiApplicationTests {

    @InjectMocks
    private MoniteurServiceImpl moniteurService;

    @Mock
    private MoniteurRepository moniteurRepository;

    @Mock
    private CoursRepository coursRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllMoniteurs() {
        // Mocking the behavior of the repository
        when(moniteurRepository.findAll()).thenReturn(Collections.emptyList());

        // Calling the service method
        moniteurService.retrieveAllMoniteurs();

        // Verifying that the repository method was called
        verify(moniteurRepository, times(1)).findAll();
    }

    @Test
    public void testAddMoniteur() {
        // Creating a mock Moniteur object
        Moniteur moniteur = new Moniteur(1,  "John", "Doe", 12345, new HashSet<>());

        // Mocking the behavior of the repository
        when(moniteurRepository.save(moniteur)).thenReturn(moniteur);

        // Calling the service method
        Moniteur result = moniteurService.addMoniteur(moniteur);

        // Verifying the result
        assertEquals(moniteur, result);

        // Verifying that the repository method was called
        verify(moniteurRepository, times(1)).save(moniteur);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testRetrieveMoniteur(int id) {
        // Create a sample Moniteur object
        Moniteur expectedMoniteur = new Moniteur(id, "John", "Doe", 12345, new HashSet<>());

        // Mocking the behavior of the repository
        when(moniteurRepository.findById(id)).thenReturn(Optional.of(expectedMoniteur));

        // Calling the service method
        Moniteur result = moniteurService.retrieveMoniteur(id);

        // Verifying the result
        assertEquals(expectedMoniteur, result);

        // Verifying that the repository method was called
        verify(moniteurRepository, times(1)).findById(id);
    }


    // Similar tests for other methods like updateMoniteur, deleteMoniteur, addMoniteurAndAssignToCourse, bestMoniteur, etc.
}

package com.example.stationski;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.stationski.entities.Color;
import com.example.stationski.entities.Piste;
import com.example.stationski.repositories.IPisteRepository;
import com.example.stationski.services.PisteServicesImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

class ServicePisteLmplTest {
    @InjectMocks
    private PisteServicesImpl pisteServices;

    @Mock
    private IPisteRepository pisteRepository;


    @Test
    void testRetrievePistesById() {
        Piste piste = new Piste(34L,"hello", Color.BLUE,11, 23,new HashSet<>());

        List<Piste> pisteList = new ArrayList<Piste>(){
            {
                add(new Piste(64L,"hello", Color.BLACK,177, 203,new HashSet<>()));
                add(new Piste(68L,"asmaaa", Color.RED,101, 26,new HashSet<>()));

            }
        };

        when(pisteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(piste));
        Piste piste1 = pisteServices.retrievePiste(64L);
        Assertions.assertNotNull(piste1);
        System.out.println("hello hello ");
    }

    @Test
    void testAjoutPiste() {

        Piste pisteAAjouter = new Piste(34L, "hello", Color.BLUE, 11, 23,new HashSet<>());


        when(pisteRepository.save(Mockito.any(Piste.class))).thenReturn(pisteAAjouter);

        Piste pisteAjoutee = pisteServices.addPiste(pisteAAjouter);

        verify(pisteRepository).save(pisteAAjouter);


        Assertions.assertNotNull(pisteAjoutee);

        System.out.println("hello hello ");

    }



    @Test
    void testRemovePiste () {

        Long numPiste = 1L;


        doNothing().when(pisteRepository).deleteById(1L);


        pisteServices.removePiste(numPiste);


        verify(pisteRepository).deleteById(1L);
        System.out.println("hello hello ");
    }



}
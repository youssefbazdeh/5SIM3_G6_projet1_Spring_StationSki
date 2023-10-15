package tn.esprit.stationski.moniteur.service;

import com.example.stationski.StationSkiApplication;
import com.example.stationski.entities.Moniteur;
import com.example.stationski.repositories.MoniteurRepository;
import com.example.stationski.services.MoniteurServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = StationSkiApplication.class)
@ExtendWith(MockitoExtension.class)
public class MoniteurServiceImplTest {
    @Mock
    MoniteurRepository moniteurRepository;
    @InjectMocks
    MoniteurServiceImpl moniteurService;

    Moniteur moniteur = new Moniteur("f1", "l1");
    List<Moniteur> moniteurList  = new ArrayList<Moniteur>() {
        {
            add(new Moniteur("f2", "l2"));
            add(new Moniteur("f3", "l3"));
        }
    };

    @Test
    public void testRetrieveMoniteur() {
        Mockito.when(moniteurRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(moniteur));
        Moniteur moniteur1 = moniteurService.retrieveMoniteur(2);
        Assertions.assertNotNull(moniteur1);
    }
}

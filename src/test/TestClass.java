import com.example.stationski.entities.*;
import com.example.stationski.repositories.CoursRepository;
import com.example.stationski.repositories.PisteRepository;
import com.example.stationski.repositories.SkieurRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestClass {

    @Mock
    SkieurRepository skieurRepository;

    @Mock
    PisteRepository pisteRepository;

    @Mock
    CoursRepository coursRepository;

    @InjectMocks
    SkieurService skieurService;

    @Test
    void testAssignSkieurToPiste() {
        // Setup
        Long numSkieur = 123L;
        Long numPiste = 456L;

        Skieur skieur = Skieur.builder().numSkieur(numSkieur).build();
        Piste piste = Piste.builder().numPiste(numPiste).build();

        when(skieurRepository.findByNumSkieur(numSkieur)).thenReturn(skieur);
        when(pisteRepository.findByNumPiste(numPiste)).thenReturn(piste);

        // Execution
        Skieur result = skieurService.assignSkieurToPiste(numSkieur, numPiste);

        // Assertion
        assertEquals(skieur, result);
        assertEquals(1, skieur.getPistes().size());
        assertEquals(piste, skieur.getPistes().iterator().next());
    }

    // Add more test methods for other methods in SkieurService if needed
}

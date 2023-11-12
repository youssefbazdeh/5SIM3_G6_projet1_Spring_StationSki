package com.example.stationski.repositories;

import com.example.stationski.entities.Piste;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPisteRepository extends JpaRepository<Piste,Long> {
    Piste findByNumPiste(Long numPiste);


}

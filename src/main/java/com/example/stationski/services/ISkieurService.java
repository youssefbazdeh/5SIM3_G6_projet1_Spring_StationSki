package com.example.stationski.services;

import com.example.stationski.entities.Color;
import com.example.stationski.entities.Skieur;
import com.example.stationski.entities.TypeAbonnement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public interface ISkieurService {

    Skieur assignSkieurToPiste(Long numSkieur, Long numPiste);

    Skieur addSkieurAndAssignToCourse(Skieur skieur, Long numCourse);

    List<Skieur> retrieveSkieursByTypeAbonnement(TypeAbonnement typeAbonnement);



}

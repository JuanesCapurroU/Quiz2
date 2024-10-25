package com.example.Quiz.Servicios;

import com.example.Quiz.Modelo.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaServicio {

    Optional<Persona> getPersonaById(Long id);

    List<Persona> getAllPersonas();

    // 1
    Optional<Persona> getPersonaByCocheMarca(String marca);

    // 2
    List<Persona> getPersonasByCocheMarca(String marca);

    Persona savePersona(Persona Persona);
    // 3
    void updatePersonaNombre(Long id, String nombre);

    void deletePersona(Long id);


    List<Persona> getPersonasConCoche();
}

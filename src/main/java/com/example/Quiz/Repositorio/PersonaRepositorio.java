package com.example.Quiz.Repositorio;

import com.example.Quiz.Modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonaRepositorio extends JpaRepository<Persona, Long> {

    // Obtener Persona por marca de Coche
    @Query("SELECT p FROM Persona p WHERE p.coche.marca = :marca")
    Optional<Persona> findByCocheMarca(@Param("marca") String marca);

    // Obtener todos las personas por marca de Coche
    @Query("SELECT p FROM Persona p WHERE p.coche.marca = :marca")
    List<Persona> findAllByCocheMarca(@Param("marca") String marca);

    // Actualizar nombre de persona por ID
    @Modifying
    @Query("UPDATE Persona p SET p.nombre = :nombre WHERE p.id = :id")
    void updatePersonaNombre(@Param("id") Long id, @Param("nombre") String nombre);

    // Obtener personas que tienen coche
    @Query("SELECT p FROM Persona p INNER JOIN p.coche c")
    List<Persona> findPersonaConCoche();
}

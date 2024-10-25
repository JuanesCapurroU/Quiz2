package com.example.Quiz.Servicios;

import com.example.Quiz.Modelo.Persona;
import com.example.Quiz.Repositorio.PersonaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiciolmpl implements PersonaServicio{

    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Override
    public Optional<Persona> getPersonaById(Long id){
        return personaRepositorio.findById(id);
    }
    @Override
    public List<Persona> getAllPersonas(){
        return personaRepositorio.findAll();
    }

    //1
    @Override
    public Optional<Persona> getPersonaByCocheMarca(String marca){
        return personaRepositorio.findByCocheMarca(marca);

    }
    //2
    @Override
    public List<Persona> getPersonasByCocheMarca(String marca) {
        return personaRepositorio.findAllByCocheMarca(marca);

    }
    @Override
    public Persona savePersona(Persona persona){
        return personaRepositorio.save(persona);
    }
    // 3
    @Override
    @Transactional
    public void updatePersonaNombre(Long id, String nombre){
        personaRepositorio.updatePersonaNombre(id, nombre);
    }

    @Override
    public void deletePersona(Long id){personaRepositorio.deleteById(id);}



    @Override
    public List<Persona> getPersonasConCoche(){
        return personaRepositorio.findPersonaConCoche();
    }



}

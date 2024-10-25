package com.example.Quiz.Controlador;


import com.example.Quiz.Modelo.Persona;
import com.example.Quiz.Servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaControlador {

    @Autowired
    private PersonaServicio personaServicio;

    //Obtener una persona por su ID
    @GetMapping("/{id}")
    public Optional<Persona> getPersonaByID(@PathVariable Long id){
        return personaServicio.getPersonaById(id);
    }

    //Obtener todas las personas
    @GetMapping("/todos")
    public List<Persona> getAllPersonas(){
        return personaServicio.getAllPersonas();
    }


    //1
    //Obtener persona por marca del Coche
    @GetMapping("/detalleproducto/descripcion/{descripcion}")
    public Optional<Persona> getPersonaByCarrosMarca(@PathVariable String marca){
        return personaServicio.getPersonaByCocheMarca(marca);
    }

    //2
    //Obtener todos los personas por marca del Coche
    @GetMapping("/detalleproducto/descripcion/all/{descripcion}")
    public List<Persona> getPersonasByCocheMarca(@PathVariable String marca){
        return personaServicio.getPersonasByCocheMarca(marca);
    }

    //Crear una persona
    @PostMapping("/guardar")
    public ResponseEntity<String> savePersona(@RequestBody Persona persona){
        Persona savedPersona = personaServicio.savePersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Producto Creado con exito ID: "+ savedPersona.getId());

    }
    //3
    //Actualizar nombre de persona por ID
    @PutMapping("/{id}/actualizarNombre")
    public void updatePersonaNombre(@PathVariable Long id, @RequestParam String nombre){
        personaServicio.updatePersonaNombre(id, nombre);
    }

    //Eliminar Persona por ID
    @DeleteMapping("/eliminar/{id}")
    public void deleteProducto(@PathVariable Long id){
        personaServicio.deletePersona(id);
    }

    //Obtener Persona con Coche
    @GetMapping("/con-coche")
    public ResponseEntity<List<Persona>> getPersonaConCoche(){
        List<Persona> personas= personaServicio.getPersonasConCoche();
        return ResponseEntity.ok(personas);
    }



}

package com.example.Quiz.Controlador;


import com.example.Quiz.Modelo.Coche;
import com.example.Quiz.Servicios.CocheServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coches")
public class CocheControlador {

    @Autowired
    private CocheServicio cocheServicio;

    //crear un nuevo Coche
    @PostMapping("/guardar")
    public ResponseEntity<String> saveCoche(@RequestBody Coche coche){
        Coche nuevoCoche = cocheServicio.saveCoche(coche);
        return ResponseEntity.ok("Coche registrado con exito. Matrciula: "+ nuevoCoche.getMatricula());
    }
}

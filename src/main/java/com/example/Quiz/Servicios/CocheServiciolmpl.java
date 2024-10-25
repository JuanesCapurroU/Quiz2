package com.example.Quiz.Servicios;

import com.example.Quiz.Modelo.Coche;
import com.example.Quiz.Repositorio.CocheRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class CocheServiciolmpl implements  CocheServicio{

    @Autowired
    private CocheRepositorio cocheRepositorio;

    @Override
    public Coche saveCoche(Coche coche){
        return cocheRepositorio.save(coche);
    }
}

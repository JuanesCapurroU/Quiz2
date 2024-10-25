package com.example.Quiz.Modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricula;
    private String marca;
    private String modelo;
    private String caballos;

    public Coche() {

    }

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    @JsonBackReference
    private Persona persona;

    public Coche(String matricula, String marca, String modelo, String caballos) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.caballos = caballos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCaballos() {
        return caballos;
    }

    public void setCaballos(String caballos) {
        this.caballos = caballos;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", caballos='" + caballos + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}

package com.proyect.POO.model;
import jakarta.persistence.Entity;

@Entity
public class Laboratorios extends Espacios {
    private int numeroComputadores;

    public Laboratorios() {}

    public Laboratorios(String nombre, int capacidad, int numeroComputadores) {
        super(nombre, capacidad);
        this.numeroComputadores = numeroComputadores;
    }
    public int getNumeroComputadores() {
        return numeroComputadores;
    }
    public void setNumeroComputadores(int numeroComputadores) {
        this.numeroComputadores = numeroComputadores;
    }
}

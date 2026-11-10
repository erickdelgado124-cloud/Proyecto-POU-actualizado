package com.proyect.POO.model;
import com.proyect.POO.PooApplication;
import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;

@Entity 
@Inheritance (strategy = InheritanceType.JOINED)
@Table (name = "espacios")
public class Espacios {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private int capacidad;

    public Espacios() {}
    public Espacios(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}




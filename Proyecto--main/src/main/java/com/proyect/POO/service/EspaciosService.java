package com.proyect.POO.service;

import com.proyect.POO.model.Espacios;
import com.proyect.POO.repository.EspaciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service 
public class EspaciosService {
    @Autowired
    private EspaciosRepository espaciosRepository;

    // obtener todos los espacios
    public List<Espacios> getAllEspacios() {
        return espaciosRepository.findAll();
    }
// Guardas un nuevo espacio en la base de datos
    public Espacios getEspacioById(Long id) {
        return espaciosRepository.findById(id).orElse(null);
    }

    public Espacios saveEspacio(Espacios espacio) {
        if (espacio.getCapacidad() < 20) {
            return espaciosRepository.save(espacio);
        }
        return null;
    }
}

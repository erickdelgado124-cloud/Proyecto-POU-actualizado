
package com.proyect.POO.controller;

import com.proyect.POO.model.Espacios;
import com.proyect.POO.service.EspaciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/espacios")
public class EspaciosController {

    @Autowired
    private EspaciosService espaciosService;

    // GET: Obtener todos los espacios -> http://localhost:8080/api/espacios
    @GetMapping
    public List<Espacios> getAllEspacios() {
        return espaciosService.getAllEspacios();
    }
    @GetMapping ("/{id}")
    public Espacios getEspacioById(@PathVariable Long id) {
        return espaciosService.getEspacioById(id);
    }

    // POST: Guardar un nuevo espacio -> http://localhost:8080/api/espacios
    @PostMapping
    public Espacios saveEspacio(@RequestBody Espacios espacio) {
        return espaciosService.saveEspacio(espacio);
    }

}





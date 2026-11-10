package com.proyect.POO.controller;
import com.proyect.POO.model.Usuarios;
import com.proyect.POO.service.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController 
@RequestMapping ("/api/usuarios")

public class UsuariosController {   
    @Autowired
    private UsuariosServices usuariosService;

    @GetMapping 
     public List<Usuarios> getAllUsuarios() {
        return usuariosService.getAllUsuarios();
}
@PostMapping 
    public Usuarios saveUsuario(@RequestBody Usuarios usuario) {
        return usuariosService.saveUsuario(usuario);
}
}
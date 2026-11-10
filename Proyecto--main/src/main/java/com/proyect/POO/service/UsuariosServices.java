package com.proyect.POO.service;

import com.proyect.POO.model.Usuarios;
import com.proyect.POO.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServices {
    @Autowired
    private UsuariosRepository usuariosRepository;
    //Obtener todos los usuarios
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }
    // Guardar un nuevo usuario en la base de datos
    public Usuarios saveUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }
}

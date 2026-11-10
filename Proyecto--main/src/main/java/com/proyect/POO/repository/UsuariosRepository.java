package com.proyect.POO.repository;

 import com.proyect.POO.model.Usuarios;
 import org.springframework.data.jpa.repository.JpaRepository; 
 import org.springframework.stereotype.Repository;
  @Repository
   public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

   }

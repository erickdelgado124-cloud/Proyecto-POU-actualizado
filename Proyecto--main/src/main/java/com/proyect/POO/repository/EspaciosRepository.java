//La carpeta "repository" es la encargada de
//  comunicarse directamente con la base de datos para guardar, consultar, editar y borrar registros.

package com.proyect.POO.repository;

 import com.proyect.POO.model.Espacios;
  import org.springframework.data.jpa.repository.JpaRepository;
   import org.springframework.stereotype.Repository;
    @Repository
     public interface EspaciosRepository extends JpaRepository<Espacios, Long> {
     }

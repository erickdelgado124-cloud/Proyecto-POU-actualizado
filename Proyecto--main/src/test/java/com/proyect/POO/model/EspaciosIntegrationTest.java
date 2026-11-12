package com.proyect.POO.model;

import com.proyect.POO.repository.EspaciosRepository;
import com.proyect.POO.service.EspaciosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class EspaciosIntegrationTest {

    @Autowired
    private EspaciosService espaciosService;

    @Autowired
    private EspaciosRepository espaciosRepository;

    @Test
    void registraYConsultaUnEspacioPermitido() {
        Espacios espacio = new Espacios("Sala de tutorías", 15);

        Espacios guardado = espaciosService.saveEspacio(espacio);

        assertNotNull(guardado);
        assertTrue(guardado.getId() > 0);
        assertEquals("Sala de tutorías", guardado.getNombre());
        assertEquals(15, guardado.getCapacidad());

        Espacios consultado = espaciosService.getEspacioById(guardado.getId());
        assertNotNull(consultado);
        assertEquals(guardado.getId(), consultado.getId());
        assertEquals("Sala de tutorías", consultado.getNombre());
        assertEquals(15, consultado.getCapacidad());

        List<Espacios> espacios = espaciosService.getAllEspacios();
        assertTrue(espacios.stream().anyMatch(e -> e.getId() == guardado.getId()));
    }

    @Test
    void rechazaEspacioConCapacidadDeVeinteOSuperior() {
        Espacios espacio = new Espacios("Auditorio", 20);

        Espacios resultado = espaciosService.saveEspacio(espacio);

        assertNull(resultado);
        assertTrue(espaciosRepository.findAll().stream()
                .noneMatch(e -> "Auditorio".equals(e.getNombre())));
    }
}

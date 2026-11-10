package com.proyect.POO.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EspaciosTest {

    @Test
    void constructorInicializaNombreYCapacidad() {
        Espacios espacio = new Espacios("Salón principal", 50);

        assertEquals("Salón principal", espacio.getNombre());
        assertEquals(50, espacio.getCapacidad());
    }

    @Test
    void constructorVacioDejaValoresPorDefecto() {
        Espacios espacio = new Espacios();

        assertEquals(0L, espacio.getId());
        assertNull(espacio.getNombre());
        assertEquals(0, espacio.getCapacidad());
    }
 
    @Test
    void settersActualizanLosAtributos() {
        Espacios espacio = new Espacios();

        espacio.setId(7L);
        espacio.setNombre("Auditorio");
        espacio.setCapacidad(120);

        assertEquals(7L, espacio.getId());
        assertEquals("Auditorio", espacio.getNombre());
        assertEquals(120, espacio.getCapacidad());
    }

    @Test
    void setterActualizaNombreDelEspacio() {
        Espacios espacio = new Espacios("Sala de reuniones", 25);
        espacio.setNombre("Sala de conferencias");

        assertEquals("Sala de conferencias", espacio.getNombre());
        assertEquals(25, espacio.getCapacidad());
    }

    @Test
    void setterActualizaCapacidadDelEspacio() {
        Espacios espacio = new Espacios("Sala de reuniones", 25);
        espacio.setCapacidad(40);

        assertEquals("Sala de reuniones", espacio.getNombre());
        assertEquals(40, espacio.getCapacidad());
    }

    @Test
    void actualizarUnEspacioNoModificaLosDatosDeOtro() {
        Espacios salaReuniones = new Espacios("Sala de reuniones", 10);
        Espacios auditorio = new Espacios("Auditorio", 100);

        salaReuniones.setCapacidad(12);

        assertEquals(12, salaReuniones.getCapacidad());
        assertEquals("Auditorio", auditorio.getNombre());
        assertEquals(100, auditorio.getCapacidad());
    }

    @Test
    void setterPermiteAsignarNombreNulo() {
        Espacios espacio = new Espacios(null, 30);



        assertNull(espacio.getNombre());
    }

    @Test
    void setterPermiteCambiarCapacidadACero() {
        Espacios espacio = new Espacios("Sala", 0);

        espacio.setCapacidad(0);

        assertEquals(0, espacio.getCapacidad());
    }

    @Test
    void cadaObjetoConservaSusPropiosDatos() {
        Espacios primeraSala = new Espacios("Sala A", 20);
        Espacios segundaSala = new Espacios("Sala B", 40);

        assertEquals("Sala A", primeraSala.getNombre());
        assertEquals(20, primeraSala.getCapacidad());
        assertEquals("Sala B", segundaSala.getNombre());
        assertEquals(40, segundaSala.getCapacidad());
    }

}

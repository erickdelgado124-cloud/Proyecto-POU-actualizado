package com.proyect.POO.model;

import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertNull;

    class EspacioTest {

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
    }
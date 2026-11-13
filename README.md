# Proyecto POO

## Sistema de reserva de espacios institucionales

### Problema

Las reservas de auditorios, salones, laboratorios, canchas y otros espacios se coordinan por correos o mensajes informales. Esto puede producir cruces de horario, solicitudes duplicadas, falta de responsables y poca claridad sobre la disponibilidad y el uso de cada espacio.

### Objetivo

Desarrollar una plataforma centralizada para registrar espacios, consultar su disponibilidad, solicitar y gestionar reservas, y generar reportes de ocupación. El sistema busca que cada solicitud tenga seguimiento y que las decisiones de aprobación queden registradas.

### Usuarios

- **Solicitante:** consulta espacios y envía solicitudes con horario, responsable y motivo.
- **Administrador de espacios:** mantiene la información de los espacios y gestiona solicitudes.
- **Coordinador académico:** revisa las reservas que requieren aprobación académica.
- **Personal logístico:** prepara los espacios y recursos asociados.
- **Supervisor:** consulta el uso y los reportes de ocupación.

### Módulos propuestos

| Módulo | Funcionalidad prevista |
|---|---|
| Espacios | Registrar salones, auditorios, laboratorios y canchas, incluida su capacidad y características. |
| Disponibilidad | Consultar calendarios y horarios libres, y bloquear espacios por mantenimiento. |
| Reservas | Crear solicitudes y aprobarlas, rechazarlas o cancelarlas con seguimiento de su estado. |
| Recursos | Asociar equipos como proyectores, sonido, computadores y sillas. |
| Reportes | Consultar ocupación por espacio, reservas por usuario y horarios de mayor demanda. |

### Reglas de negocio

- No se deben aprobar dos reservas del mismo espacio para el mismo horario.
- Toda reserva debe identificar a una persona responsable.
- Un espacio bloqueado por mantenimiento no se puede reservar.
- La cancelación debe guardar el motivo.
- Las reservas que lo requieran deben ser aprobadas por un coordinador.
- La cantidad de asistentes no puede superar la capacidad del espacio.

### Historia de usuario de ejemplo

Como docente, quiero solicitar un laboratorio para una fecha y hora determinadas para realizar una práctica académica.

**Criterios de aceptación:** el sistema permite consultar disponibilidad, seleccionar espacio y horario, registrar motivo y responsable, y crea la solicitud en estado pendiente. No permite enviar una solicitud si existe un cruce de horario. El administrador puede aprobarla o rechazarla.

### Estado actual del proyecto

El proyecto es una aplicación Java con Spring Boot y persistencia JPA. Actualmente incluye:

- Registro y consulta de espacios mediante `GET /api/espacios`, `GET /api/espacios/{id}` y `POST /api/espacios`.
- Registro y consulta de usuarios mediante `GET /api/usuarios` y `POST /api/usuarios`.
- Las entidades `Espacios`, `Laboratorios` y `Usuarios`, y sus repositorios.
- Pruebas unitarias para `Espacios` y una prueba de integración que verifica el servicio y el repositorio.

La disponibilidad por horario, el flujo completo de reservas, las aprobaciones, cancelaciones, recursos asociados y reportes forman parte del alcance por desarrollar. La entidad `Reservas` y su flujo funcional aún no están implementados. La validación actual de capacidad en el servicio de espacios es una regla de prueba y debe revisarse antes de usar el sistema para gestionar reservas reales.

## Integrantes

- Erick Delgado
- Erick Sepulveda
- Daniel Chica

## Requisitos

- JDK 17
- Gradle Wrapper incluido en `Proyecto--main`
- Docker Desktop con el motor Linux activo para ejecutar SonarQube

## Pruebas

Desde la carpeta `Proyecto--main`, ejecuta las pruebas normales:

```powershell
.\gradlew.bat test
```

La tarea `test` ejecuta PIT al finalizar. PIT analiza `Espacios` con `EspaciosTest` y genera los reportes en:

- HTML: `Proyecto--main/build/reports/pitest/index.html`
- XML: `Proyecto--main/build/reports/pitest/mutations.xml`

Para ejecutar solo PIT:

```powershell
.\gradlew.bat pitest
```

## SonarQube local con Docker

El archivo Compose está en `Proyecto--main/sonarqube-laboratorio/compose.yaml`. Desde `Proyecto--main`, descarga la imagen e inicia SonarQube:

```powershell
docker compose -f sonarqube-laboratorio/compose.yaml pull
docker compose -f sonarqube-laboratorio/compose.yaml up -d
docker compose -f sonarqube-laboratorio/compose.yaml ps
```

Cuando el contenedor esté activo, abre [http://localhost:9000](http://localhost:9000). En el primer inicio, entra con `admin` / `admin` y cambia la contraseña. Crea el proyecto con la clave `demo-calidad` y el nombre `Proyecto Demo Calidad`, tal como están configurados en `build.gradle`.

Genera un token desde la interfaz de SonarQube y guárdalo en una variable de entorno de PowerShell. No lo escribas en este README ni en `build.gradle`:

```powershell
$env:SONAR_TOKEN = "PEGA_AQUI_TU_TOKEN"
.\gradlew.bat clean build sonar
```

El análisis aparece en el proyecto de SonarQube cuando Gradle termina correctamente. Para detener el servidor sin borrar los datos persistentes:

```powershell
docker compose -f sonarqube-laboratorio/compose.yaml down
```

# Proyecto POO

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

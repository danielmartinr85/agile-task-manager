# Agile Task Manager

## Objetivo

Agile Task Manager es un proyecto desarrollado en Java con el objetivo de aplicar de forma práctica conceptos relacionados con el desarrollo de software ágil, las pruebas automatizadas, la persistencia de datos y la integración continua.

El proyecto consiste en una aplicación sencilla para gestionar tareas, permitiendo crear, consultar, actualizar y controlar el estado de las tareas.

El objetivo principal no es desarrollar una aplicación comercial, sino utilizar un proyecto pequeño y controlado como entorno de aprendizaje para experimentar con prácticas y herramientas habituales en proyectos Agile y DevOps.

A través del proyecto se trabajan conceptos como:

- Desarrollo incremental.
- Gestión del estado de las tareas.
- Separación de responsabilidades.
- Persistencia mediante SQL.
- Pruebas automatizadas con JUnit.
- Control de versiones con Git y GitHub.
- Integración continua mediante GitHub Actions.

## Tecnologías utilizadas

- Java 27
- Maven
- JUnit 5
- H2 Database
- JDBC
- Git
- GitHub
- GitHub Actions

## Arquitectura

El proyecto utiliza una separación sencilla de responsabilidades:

```text
Main
 │
 ▼
TaskService
 │
 ▼
TaskRepository
 │
 ▼
H2 Database

## Testing

El proyecto utiliza JUnit 5 para realizar pruebas automatizadas.

Los tests cubren diferentes niveles de comportamiento:

- Creación y comportamiento básico de las tareas.
- Cambios de estado.
- Conexión con la base de datos.
- Creación de la tabla `tasks`.
- Persistencia de tareas.
- Consulta de tareas por identificador.
- Actualización de tareas.
- Reglas de negocio del servicio.

Actualmente el proyecto cuenta con tests automatizados que se ejecutan mediante Maven.

Una de las reglas de negocio comprobadas mediante tests es que una tarea no puede pasar directamente de `TODO` a `DONE`:

```text
TODO → DONE ❌

## Cómo ejecutar el proyecto

### Requisitos

Para ejecutar el proyecto se necesita:

- Java 27.
- IntelliJ IDEA u otro IDE compatible con Maven.
- Git.

### Ejecutar los tests

Desde IntelliJ se pueden ejecutar los tests mediante el ciclo de vida de Maven:

```text
Maven → Lifecycle → test

## Metodología Agile

El desarrollo del proyecto se ha realizado de forma incremental, incorporando funcionalidades pequeñas y verificables en lugar de desarrollar toda la aplicación de una sola vez.

Cada incremento se ha acompañado de pruebas automatizadas y de un commit independiente en Git.

Algunos de los incrementos realizados han sido:

1. Creación del modelo `Task`.
2. Incorporación de prioridades y estados.
3. Implementación de cambios de estado.
4. Incorporación de persistencia mediante SQL.
5. Implementación de consultas por identificador.
6. Implementación de actualización de tareas.
7. Creación de la capa de servicio.
8. Incorporación de reglas de negocio.
9. Automatización de tests mediante GitHub Actions.

Este enfoque permite obtener feedback rápidamente, detectar errores de forma temprana y mantener los cambios pequeños y fáciles de revisar.

### Ejemplo de evolución

Una funcionalidad como el cambio de estado se desarrolló de forma incremental:

```text
Definir comportamiento
        ↓
Crear test
        ↓
Implementar funcionalidad
        ↓
Ejecutar tests
        ↓
Commit
        ↓
Push
        ↓
GitHub Actions

## Proof of Technology (POT) y aprendizajes

Durante el desarrollo del proyecto se han realizado pequeñas pruebas y validaciones tecnológicas para comprobar cómo distintas herramientas pueden integrarse en un flujo de desarrollo ágil.

### POT 1: Persistencia con H2 y JDBC

Se utilizó H2 junto con JDBC para experimentar con la persistencia de datos mediante SQL sin necesidad de instalar un servidor de base de datos externo.

Esto permitió trabajar con operaciones de creación, consulta y actualización de tareas desde Java.

**Aprendizaje:** H2 resulta útil para proyectos pequeños y entornos de pruebas, mientras que en un proyecto real podría utilizarse un sistema gestor de bases de datos externo.

### POT 2: Pruebas automatizadas con JUnit

Se incorporó JUnit para comprobar automáticamente el comportamiento de las distintas partes de la aplicación.

Las pruebas permitieron validar tanto funcionalidades individuales como reglas de negocio, por ejemplo, que una tarea no pueda pasar directamente de `TODO` a `DONE`.

**Aprendizaje:** las pruebas automatizadas permiten detectar errores durante el desarrollo y facilitan la incorporación de nuevas funcionalidades sin perder el comportamiento existente.

### POT 3: Integración continua con GitHub Actions

Se configuró GitHub Actions para ejecutar automáticamente los tests cada vez que se realiza un `push` a la rama principal o una `pull request`.

El flujo utilizado es:

```text
Git push
   ↓
GitHub Actions
   ↓
Configuración del entorno Java
   ↓
Maven
   ↓
JUnit
   ↓
Tests
```

**Aprendizaje:** la integración continua permite detectar problemas de forma temprana y automatizar una parte del proceso de validación del software.

### POT 4: Separación de responsabilidades

Se experimentó con una estructura sencilla basada en diferentes responsabilidades:

```text
Task
 ↓
TaskService
 ↓
TaskRepository
 ↓
Database
```

De esta forma, la lógica de negocio queda separada del acceso a datos.

**Aprendizaje:** separar responsabilidades facilita comprender el código, realizar pruebas y modificar una parte de la aplicación sin afectar directamente al resto.

### Conclusiones

El desarrollo del proyecto ha permitido experimentar de forma práctica con herramientas y técnicas relacionadas con Agile y DevOps.

Uno de los principales aprendizajes ha sido comprobar que las herramientas no deben utilizarse únicamente de forma aislada, sino formando parte de un flujo de desarrollo:

```text
Desarrollo
   ↓
Git
   ↓
Tests
   ↓
Push
   ↓
CI
   ↓
Validación
```

El proyecto sirve como una primera aproximación práctica a este tipo de flujo y como base para seguir incorporando nuevas herramientas y prácticas en futuras iteraciones.


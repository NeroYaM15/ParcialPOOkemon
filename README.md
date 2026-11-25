# ParcialPOOkemon

**Sistema de gestión de entrenadores y Pokémon**


**Integrantes:**
- Samuel Stiven Yara Mosquera – 20261007081
- Gabriel David Leal Carvajal – 20261007087


## Descripción del proyecto

ParcialPOOkemon es una aplicación desarrollada en Java cuyo propósito es gestionar información relacionada con entrenadores Pokémon y sus respectivos equipos.

El sistema permite administrar entrenadores, registrar sus medallas y gestionar los Pokémon que pertenecen a cada uno. Cada entrenador cuenta con un identificador único, un nombre, una colección de medallas y un equipo compuesto por varios Pokémon.

Por su parte, cada Pokémon cuenta con un identificador, una especie seleccionada de la Pokédex, un nivel y una relación con su entrenador.

El proyecto aplica los fundamentos de la programación orientada a objetos para organizar la información, establecer relaciones entre entidades y facilitar la administración de los datos mediante una interfaz gráfica.

## Objetivos

### Objetivo general

Desarrollar una aplicación en Java que permita gestionar entrenadores Pokémon y sus respectivos equipos mediante una interfaz gráfica, aplicando los fundamentos de la programación orientada a objetos y mecanismos de persistencia para conservar la información.

### Objetivos específicos

- Diseñar e implementar clases que representen entrenadores, Pokémon, medallas y elementos de la Pokédex.
- Aplicar encapsulamiento mediante atributos privados y métodos de acceso y modificación.
- Implementar operaciones de registro, consulta, actualización y eliminación de información.
- Establecer relaciones entre entrenadores y Pokémon, permitiendo que un entrenador tenga varios Pokémon.
- Desarrollar una interfaz gráfica utilizando Java Swing.
- Implementar persistencia mediante archivos CSV para conservar los datos después de cerrar la aplicación.

## Funcionalidades del sistema

### Gestión de entrenadores

- Generación automática de identificadores únicos.
- Registro de entrenadores.
- Consulta de información.
- Modificación de datos.
- Eliminación de registros.
- Administración de varias medallas por entrenador.
- Asociación de varios Pokémon a un mismo entrenador.

### Gestión de Pokémon

- Selección de especies disponibles en la Pokédex.
- Generación automática de identificadores.
- Registro de Pokémon.
- Consulta y modificación de información.
- Eliminación de Pokémon.
- Asociación de cada Pokémon con su entrenador correspondiente.

### Interfaz gráfica

La aplicación utiliza Java Swing para proporcionar una interfaz que facilite la interacción con el sistema mediante campos de texto, listas desplegables, botones y tablas. Su finalidad es permitir la administración de entrenadores y Pokémon sin necesidad de utilizar directamente la consola.

## Persistencia de datos

Para conservar la información entre diferentes ejecuciones, el proyecto utiliza archivos CSV como mecanismo de almacenamiento.

Se contempla la utilización de dos archivos principales:

**trainers.csv:** almacena la información de los entrenadores, incluyendo sus identificadores, nombres, medallas y referencias a los Pokémon asociados.

**Pokemon.csv:** almacena los identificadores, especies, niveles y referencias a los entrenadores correspondientes.

La utilización de identificadores permite relacionar los registros de ambos archivos y mantener la asociación entre entrenadores y Pokémon.

## Tecnologías y herramientas

- **Java:** lenguaje de programación utilizado para desarrollar la lógica del sistema.
- **Java Swing:** biblioteca utilizada para construir la interfaz gráfica.
- **IntelliJ IDEA:** entorno de desarrollo utilizado para escribir, organizar y ejecutar el código.
- **CSV:** formato utilizado para almacenar y recuperar la información.
- **Git:** herramienta de control de versiones utilizada para administrar los cambios del proyecto.

## Ejecución del proyecto

Para ejecutar la aplicación es necesario abrir el proyecto en IntelliJ IDEA, verificar la configuración del JDK y ejecutar la clase principal `Main.java`.

## Estado del desarrollo

El proyecto cuenta con las clases principales del modelo, las enumeraciones correspondientes a las medallas y la Pokédex, y las operaciones iniciales de persistencia de entrenadores.

Actualmente se continúa trabajando en la consolidación de la persistencia de Pokémon, la recuperación de objetos desde los archivos CSV, la integración de las relaciones entre entrenadores y Pokémon y la conexión de los componentes gráficos con las operaciones del sistema.

---

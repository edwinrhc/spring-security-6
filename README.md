# Spring Boot Security 6 Application

## Descripción

Este proyecto es una aplicación Spring Boot que utiliza Spring Security 6 para proporcionar autenticación y autorización. El objetivo es demostrar cómo configurar y utilizar Spring Security en una aplicación moderna de Spring Boot.

## Características

- Autenticación y autorización con Spring Security 6.
- Configuración de seguridad basada en roles.
- Ejemplos de controladores seguros y abiertos.
- Registro y gestión de usuarios.

## Requisitos

- Java 17+
- Maven 3.8+
- IDE compatible con Spring Boot (IntelliJ IDEA, Eclipse, etc.)

## Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/tuusuario/tu-repositorio.git
    ```
2. Navega al directorio del proyecto:
    ```sh
    cd tu-repositorio
    ```
3. Compila y empaqueta el proyecto con Maven:
    ```sh
    mvn clean install
    ```

## Configuración

### Base de Datos

Asegúrate de configurar tu base de datos en el archivo `application.properties` o `application.yml`. Por ejemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

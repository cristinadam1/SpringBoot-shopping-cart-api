# Shopping Cart System (Spring Boot + EJB + ORM)

Implementación de un sistema de comercio electrónico basado en una arquitectura Java empresarial para la gestión de productos, carritos de compra y autenticación de usuarios.

## Funcionalidades Clave

* **Gestión de Catálogo (CRUD):** Implementación completa de operaciones de creación, lectura, actualización y borrado de productos.
* **Sistema de Carrito:** Lógica de negocio para la gestión de artículos en sesión.
* **Seguridad y Autenticación:** Integración de Spring Security para el control de acceso y protección de rutas administrativas.
* **Gestión de Persistencia:** Uso de JPA/ORM con base de datos H2 para el almacenamiento de datos.
* **Exportación de Datos:** Funcionalidad integrada para exportar el estado actual de la base de datos a un script SQL.

## Tecnologías Utilizadas

* **Core:** Java con Spring Boot.
* **Arquitectura:** RESTful Web Services / EJB.
* **Frontend:** Thymeleaf (Motores de plantillas).
* **Persistencia:** Spring Data JPA / Hibernate.
* **Base de Datos:** H2 Database Engine (In-memory).
* **Seguridad:** Spring Security.



## Estructura del Proyecto

* `src/main/java`: Contiene la lógica de negocio, controladores REST y configuración de seguridad.
* `src/main/resources`: Configuración del entorno, plantillas de Thymeleaf y scripts de inicialización de base de datos.
* `endpoints/`: Documentación de rutas para pruebas en Postman.

## Configuración e Instalación

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/spring-shopping-cart-api.git](https://github.com/tu-usuario/spring-shopping-cart-api.git)
    ```
2.  **Ejecutar la aplicación:**
    Si utilizas Maven:
    ```bash
    ./mvnw spring-boot:run
    ```
3.  **Acceso al servicio:**
    * URL de la aplicación: `http://localhost:8080`
    * Consola H2 (Base de datos): `http://localhost:8080/h2-console`

## Pruebas
Los endpoints REST han sido validados utilizando **Postman**. Se incluye la funcionalidad de exportación de base de datos para facilitar la portabilidad de los datos generados durante la ejecución.

---
**Desarrollado por:** cristinadam1

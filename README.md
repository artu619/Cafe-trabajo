# Sistema de Gestión de Café

Creado por: Arturo Lopez Frias

Este es un sistema de gestión para una cafetería desarrollado con Spring Boot. El sistema permite gestionar clientes, pedidos y productos de café.

## Tecnologías Utilizadas

- Java 17 o superior
- Spring Boot 3.4.5
- Maven
- Spring Web
- Spring Actuator
- Spring DevTools

## Características Principales

- API RESTful completa
- Gestión de clientes
- Gestión de productos de café
- Sistema de pedidos
- Soporte para observabilidad con Micrometer
- Seguridad mejorada con OAuth2 y OpenID Connect

## Estructura del Proyecto

El proyecto sigue una arquitectura en capas:

```
src/main/java/com/cafe/cafe/
├── controller/    # Controladores REST
├── model/        # Entidades del dominio
├── service/      # Lógica de negocio
└── repository/   # Acceso a datos
```

## Modelos Principales

### Cliente
- Gestión de información de clientes
- Endpoints REST para operaciones CRUD

### Café
- Catálogo de productos de café
- Gestión de inventario

### Pedido
- Gestión de pedidos de clientes
- Seguimiento de órdenes

## API Endpoints y Ejemplos con Postman

### Clientes (`/api/clientes`)
- `GET /api/clientes` - Obtener todos los clientes
- `GET /api/clientes/{id}` - Obtener cliente por ID
- `POST /api/clientes` - Crear nuevo cliente
  ```json
  {
    "nombre": "Juan Pérez",
    "email": "juan@email.com",
    "telefono": "123456789"
  }
  ```
- `PUT /api/clientes/{id}` - Actualizar cliente existente
- `DELETE /api/clientes/{id}` - Eliminar cliente

### Cafés (`/api/cafes`)
- `GET /api/cafes` - Listar todos los cafés
- `GET /api/cafes/{id}` - Obtener café por ID
- `POST /api/cafes` - Agregar nuevo café
  ```json
  {
    "nombre": "Espresso",
    "descripcion": "Café espresso tradicional",
    "precio": 2.50,
    "stock": 100
  }
  ```
- `PUT /api/cafes/{id}` - Actualizar café existente
- `DELETE /api/cafes/{id}` - Eliminar café

### Pedidos (`/api/pedidos`)
- `GET /api/pedidos` - Listar todos los pedidos
- `GET /api/pedidos/{id}` - Obtener pedido por ID
- `POST /api/pedidos` - Crear nuevo pedido
  ```json
  {
    "clienteId": 1,
    "items": [
      {
        "cafeId": 1,
        "cantidad": 2
      },
      {
        "cafeId": 2,
        "cantidad": 1
      }
    ]
  }
  ```
- `PUT /api/pedidos/{id}` - Actualizar estado del pedido
  ```json
  {
    "estado": "COMPLETADO"
  }
  ```

## Requisitos del Sistema

- Java 17 o superior
- Maven 3.6 o superior

## Configuración y Ejecución

1. Clonar el repositorio
2. Navegar al directorio del proyecto
3. Ejecutar con Maven:
   ```bash
   mvn spring-boot:run
   ```

## Desarrollo

El proyecto utiliza Spring Boot DevTools para facilitar el desarrollo, permitiendo:
- Recarga automática de cambios
- Configuración de propiedades específicas para desarrollo
- Mejoras en la experiencia de desarrollo
- Soporte para hilos virtuales en Java 21


## Licencia

Este proyecto está bajo la Licencia MIT.
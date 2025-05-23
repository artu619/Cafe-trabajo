# Sistema de Gestión de Café

Este es un sistema de gestión para una cafetería desarrollado con Spring Boot. El sistema permite gestionar clientes, pedidos y productos de café.

## Tecnologías Utilizadas

- Java 24
- Spring Boot 3.4.5
- Maven
- Spring Web
- Spring Actuator
- Spring DevTools

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

## API Endpoints

### Clientes (`/api/clientes`)
- `GET /api/clientes` - Obtener todos los clientes
- `GET /api/clientes/{id}` - Obtener cliente por ID
- `POST /api/clientes` - Crear nuevo cliente
- `PUT /api/clientes/{id}` - Actualizar cliente existente
- `DELETE /api/clientes/{id}` - Eliminar cliente

## Requisitos del Sistema

- Java 24 o superior
- Maven 3.6 o superior

## Configuración y Ejecución

1. Clonar el repositorio
2. Navegar al directorio del proyecto
3. Ejecutar con Maven:
   ```bash
   mvn spring-boot:run
   ```

## Características

- API RESTful completa
- Gestión de clientes
- Gestión de productos de café
- Sistema de pedidos
- Desarrollo con Spring Boot
- Documentación de API

## Desarrollo

El proyecto utiliza Spring Boot DevTools para facilitar el desarrollo, permitiendo:
- Recarga automática de cambios
- Configuración de propiedades específicas para desarrollo
- Mejoras en la experiencia de desarrollo

## Contribución

1. Fork el proyecto
2. Crear una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## Licencia

Este proyecto está bajo la Licencia MIT. 
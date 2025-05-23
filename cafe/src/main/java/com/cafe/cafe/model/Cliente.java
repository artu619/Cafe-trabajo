package com.cafe.cafe.model;

/**
 * Clase que representa a un cliente en el sistema de cafetería.
 * Esta entidad almacena la información básica de los clientes que realizan pedidos.
 */
public class Cliente {
    /** Identificador único del cliente */
    private Long id;
    
    /** Nombre completo del cliente */
    private String nombre;
    
    /** Correo electrónico del cliente para contacto */
    private String email;

    /** Constructor por defecto requerido para la serialización */
    public Cliente() {}

    /**
     * Constructor con parámetros para crear un nuevo cliente
     * @param id Identificador único del cliente
     * @param nombre Nombre completo del cliente
     * @param email Correo electrónico del cliente
     */
    public Cliente(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

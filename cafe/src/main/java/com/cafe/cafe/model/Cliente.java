package com.cafe.cafe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que representa a un cliente en el sistema de cafetería.
 * Esta entidad almacena la información básica de los clientes que realizan pedidos.
 */
@Entity
@Table(name = "clientes")
public class Cliente {
    /** Identificador único del cliente */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** Nombre completo del cliente */
    private String nombre;
    
    /** Correo electrónico del cliente para contacto */
    private String email;

    /** Número de teléfono del cliente */
    private String telefono;

    /** Constructor por defecto requerido para la serialización */
    public Cliente() {}

    /**
     * Constructor con parámetros para crear un nuevo cliente
     * @param id Identificador único del cliente
     * @param nombre Nombre completo del cliente
     * @param email Correo electrónico del cliente
     * @param telefono Número de teléfono del cliente
     */
    public Cliente(Long id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}

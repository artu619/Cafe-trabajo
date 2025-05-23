package com.cafe.cafe.model;

/**
 * Clase que representa un producto de café en el sistema.
 * Esta entidad almacena la información de los diferentes tipos de café disponibles.
 */
public class Cafe {
    /** Identificador único del café */
    private Long id;
    
    /** Nombre del tipo de café */
    private String nombre;
    
    /** Precio del café en la moneda local */
    private double precio;
    
    /** País o región de origen del café */
    private String origen;

    /** Constructor por defecto requerido para la serialización */
    public Cafe() {}

    /**
     * Constructor con parámetros para crear un nuevo producto de café
     * @param id Identificador único del café
     * @param nombre Nombre del tipo de café
     * @param precio Precio del café
     * @param origen País o región de origen
     */
    public Cafe(Long id, String nombre, double precio, String origen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.origen = origen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
}
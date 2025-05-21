package com.cafe.cafe.model;

public class Cafe {
    private Long id;
    private String nombre;
    private double precio;
    private String origen;

    public Cafe() {}

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
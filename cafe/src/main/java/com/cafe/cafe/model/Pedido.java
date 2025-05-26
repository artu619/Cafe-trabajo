package com.cafe.cafe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Clase que representa un pedido en el sistema de cafetería.
 * Esta entidad relaciona a un cliente con un producto de café y la cantidad solicitada.
 */
@Entity
@Table(name = "pedidos")
public class Pedido {
    /** Identificador único del pedido */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** Identificador del cliente que realiza el pedido */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    /** Identificador del café solicitado */
    @ManyToOne
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;
    
    /** Cantidad de unidades del café solicitadas */
    private int cantidad;

    /** Constructor por defecto requerido para la serialización */
    public Pedido() {}

    /**
     * Constructor con parámetros para crear un nuevo pedido
     * @param id Identificador único del pedido
     * @param cliente Identificador del cliente
     * @param cafe Identificador del café
     * @param cantidad Cantidad solicitada
     */
    public Pedido(Long id, Cliente cliente, Cafe cafe, int cantidad) {
        this.id = id;
        this.cliente = cliente;
        this.cafe = cafe;
        this.cantidad = cantidad;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Cafe getCafe() { return cafe; }
    public void setCafe(Cafe cafe) { this.cafe = cafe; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}

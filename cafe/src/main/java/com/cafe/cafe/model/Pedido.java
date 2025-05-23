package com.cafe.cafe.model;

/**
 * Clase que representa un pedido en el sistema de cafetería.
 * Esta entidad relaciona a un cliente con un producto de café y la cantidad solicitada.
 */
public class Pedido {
    /** Identificador único del pedido */
    private Long id;
    
    /** Identificador del cliente que realiza el pedido */
    private Long clienteId;
    
    /** Identificador del café solicitado */
    private Long cafeId;
    
    /** Cantidad de unidades del café solicitadas */
    private int cantidad;

    /** Constructor por defecto requerido para la serialización */
    public Pedido() {}

    /**
     * Constructor con parámetros para crear un nuevo pedido
     * @param id Identificador único del pedido
     * @param clienteId Identificador del cliente
     * @param cafeId Identificador del café
     * @param cantidad Cantidad solicitada
     */
    public Pedido(Long id, Long clienteId, Long cafeId, int cantidad) {
        this.id = id;
        this.clienteId = clienteId;
        this.cafeId = cafeId;
        this.cantidad = cantidad;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public Long getCafeId() { return cafeId; }
    public void setCafeId(Long cafeId) { this.cafeId = cafeId; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}

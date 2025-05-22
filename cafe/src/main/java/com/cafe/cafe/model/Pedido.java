package com.cafe.cafe.model;

public class Pedido {
    private Long id;
    private Long clienteId;
    private Long cafeId;
    private int cantidad;

    public Pedido() {}

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

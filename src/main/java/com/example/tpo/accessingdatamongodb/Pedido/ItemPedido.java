package com.example.tpo.accessingdatamongodb.Pedido;

public class ItemPedido {
    private String idProducto;
    private int cantidad;
    private double precio;

    public ItemPedido(String idProducto, int cantidad, double precio) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public ItemPedido() {
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "ItemPedido{" +
                "idProducto='" + idProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}

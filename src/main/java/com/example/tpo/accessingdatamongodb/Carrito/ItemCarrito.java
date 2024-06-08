package com.example.tpo.accessingdatamongodb.Carrito;

public class ItemCarrito {
    private String idProducto;
    private int cantidad;
    private double precio;

    public ItemCarrito(String idProducto, int cantidad, double precio) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public ItemCarrito() {
    }

    public String getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ItemCarrito{" +
                "idProducto='" + idProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}

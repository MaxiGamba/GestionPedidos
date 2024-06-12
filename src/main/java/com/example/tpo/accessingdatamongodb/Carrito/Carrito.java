package com.example.tpo.accessingdatamongodb.Carrito;

import java.util.List;
import java.util.UUID;

public class Carrito {
    private String id;
    private String idUsuario;
    private List<ItemCarrito> productos; // Lista de productos en el carrito
    private String estado; //ACTIVO o FINALIZADO

    public Carrito(String idUsuario, List<ItemCarrito> productos) {
        this.id = UUID.randomUUID().toString(); // Genera un id aleatorio
        this.idUsuario = idUsuario;
        this.productos = productos;
    }

    public Carrito() {
    }

    public String getId() {
        return id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public List<ItemCarrito> getProductos() {
        return productos;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setProductos(List<ItemCarrito> productos) {
        this.productos = productos;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id='" + id + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                ", productos=" + productos +
                ", estado='" + estado + '\'' +
                '}';
    }
}

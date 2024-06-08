package com.example.tpo.accessingdatamongodb.Carrito;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "carritos")
public class Carrito {
    @Id
    private String id;
    private String idUsuario;
    private List<ItemCarrito> productos;
    private String estado; //ACTIVO o FINALIZADO

    public Carrito(String idUsuario, List<ItemCarrito> productos, String estado) {
        this.idUsuario = idUsuario;
        this.productos = productos;
        this.estado = estado;
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

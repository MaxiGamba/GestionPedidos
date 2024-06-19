package com.example.tpo.accessingdatamongodb.Carrito;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Carrito {
    private String id;

    @NotEmpty(message = "El ID del usuario no puede estar vacío")
    private String idUsuario;
    @NotNull(message = "La lista de productos no puede ser nula")
    private List<ItemCarrito> productos; // Lista de productos en el carrito

    private String estado; //ACTIVO o FINALIZADO
    private String fechaCreacion;
    private String fechaModificacion;

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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
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

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
public String toString() {
    return "Carrito{" +
            "id='" + id + '\'' +
            ", idUsuario='" + idUsuario + '\'' +
            ", productos=" + productos +
            ", estado='" + estado + '\'' +
            ", fechaCreacion='" + fechaCreacion + '\'' +
            ", fechaModificacion='" + fechaModificacion + '\'' +
            '}';
    }
}

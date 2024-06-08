package com.example.tpo.accessingdatamongodb.Pedido;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pedidos")
public class Pedido {
    @Id
    private String id;
    private String idUsuario;
    private List<ItemPedido> productos;
    private String estado; // CREADO, FACTURADO, PAGADO
    private double total;
    private double descuentos;
    private double impuestos;

    public Pedido(String idUsuario, List<ItemPedido> productos, String estado, double total, double descuentos, double impuestos) {
        this.idUsuario = idUsuario;
        this.productos = productos;
        this.estado = estado;
        this.total = total;
        this.descuentos = descuentos;
        this.impuestos = impuestos;
    }

    public Pedido() {
    }

    public String getId() {
        return id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public List<ItemPedido> getProductos() {
        return productos;
    }

    public String getEstado() {
        return estado;
    }

    public double getTotal() {
        return total;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setProductos(List<ItemPedido> productos) {
        this.productos = productos;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                ", productos=" + productos +
                ", estado='" + estado + '\'' +
                ", total=" + total +
                ", descuentos=" + descuentos +
                ", impuestos=" + impuestos +
                '}';
    }
}

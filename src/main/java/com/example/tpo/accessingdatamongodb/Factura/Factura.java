package com.example.tpo.accessingdatamongodb.Factura;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "facturas")
public class Factura {
    @Id
    private String id;
    private String idPedido;
    private String idUsuario;
    private double total;
    private String fecha;
    private String hora;
    private String formaPago;
    private String estado; // PENDIENTE o PAGADA

    public Factura( String idPedido, String idUsuario, double total, String formaPago, String estado) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.total = total;
        LocalDateTime fechaHora = LocalDateTime.now(); // Obtiene la fecha y hora actual
        this.fecha = (fechaHora.toLocalDate().toString()); // Guarda la fecha
        this.hora = (fechaHora.toLocalTime().toString()); // Guarda la hora
        this.formaPago = formaPago;
        this.estado = estado;
    }

    public Factura() {
    }

    public String getId() {
        return id;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public double getTotal() {
        return total;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id='" + id + '\'' +
                ", idPedido='" + idPedido + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                ", total=" + total +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", formaPago='" + formaPago + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
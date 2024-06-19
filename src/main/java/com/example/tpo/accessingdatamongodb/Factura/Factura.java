package com.example.tpo.accessingdatamongodb.Factura;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "facturas")
public class Factura {
    @Id
    private String id;
    @NotEmpty(message = "El ID del pedido no puede estar vacío")
    private String idPedido;
    private String idUsuario;
    private double total;
    private String fecha;
    private String hora;
    @NotNull(message = "La forma de pago no puede ser nula")
    private String formaPago; // EFECTIVO, TARJETA DEBITO/CREDITO o CUENTA CORRIENTE
    private String estado; // PENDIENTE o PAGADA

    public Factura( String idPedido, String idUsuario, double total, String fecha, String hora, String formaPago, String estado) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.total = total;
        this.fecha = fecha;
        this.hora = hora;
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
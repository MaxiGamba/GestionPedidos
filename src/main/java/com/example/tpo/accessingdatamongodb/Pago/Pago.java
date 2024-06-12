package com.example.tpo.accessingdatamongodb.Pago;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pagos")
public class Pago {
    @Id
    private String id;
    private String idFactura;
    private String idUsuario;
    private double monto;
    private String fecha;
    private String hora;
    private String formaPago; // EFECTIVO, TARJETA, CTA_CTE
    private String operador;

    public Pago(String idFactura, String idUsuario, double monto, String formaPago, String operador) {
        this.idFactura = idFactura;
        this.idUsuario = idUsuario;
        this.monto = monto;
        LocalDateTime fechaHora = LocalDateTime.now(); // Obtiene la fecha y hora actual
        this.fecha = (fechaHora.toLocalDate().toString()); // Guarda la fecha
        this.hora = (fechaHora.toLocalTime().toString()); // Guarda la hora
        this.formaPago = formaPago;
        this.operador = operador;
    }

    public Pago() {
    }

    public String getId() {
        return id;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public double getMonto() {
        return monto;
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

    public String getOperador() {
        return operador;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setMonto(double monto) {
        this.monto = monto;
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

    public void setOperador(String operador) {
        this.operador = operador;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id='" + id + '\'' +
                ", idFactura='" + idFactura + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", formaPago='" + formaPago + '\'' +
                ", operador='" + operador + '\'' +
                '}';
    }
}

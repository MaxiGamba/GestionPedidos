package com.example.tpo.accessingdatamongodb.Pago;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pagos")
public class Pago {
    @Id
    private String id;
    private List<String> idFacturas;
    private String idUsuario;
    private double monto;
    private String fecha;
    private String hora;
    private String formaPago; // // EFECTIVO, TARJETA DEBITO/CREDITO o CUENTA CORRIENTE
    private String operador;

    public Pago(List<String> idFacturas, String idUsuario, double monto, String fecha, String hora, String formaPago, String operador) {
        this.idFacturas = idFacturas;
        this.idUsuario = idUsuario;
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
        this.formaPago = formaPago;
        this.operador = operador;
    }

    public Pago() {
    }

    public String getId() {
        return id;
    }

    public List<String> getidFacturas() {
        return idFacturas;
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

    public void setIdFacturas(List<String> idFacturas) {
        this.idFacturas = idFacturas;
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
                ", idFacturas='" + String.join(", ", idFacturas) + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", formaPago='" + formaPago + '\'' +
                ", operador='" + operador + '\'' +
                '}';
    }
}

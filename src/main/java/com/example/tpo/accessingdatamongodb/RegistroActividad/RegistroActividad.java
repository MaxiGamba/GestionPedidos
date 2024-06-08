package com.example.tpo.accessingdatamongodb.RegistroActividad;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registroActividades")
public class RegistroActividad {
    @Id
    private String id;
    private String productoId;
    private String campoModificado; // Indica qué campo se modificó, "precio", "imagen", "video", etc..
    private String valorAnterior;
    private String valorNuevo;
    private String operador;  // Indica qué operador realizó la modificación, "admin", "usuario", etc..
    private String fecha;
    private String hora;

    
    public RegistroActividad(String productoId, String campoModificado, String valorAnterior, String valorNuevo, String operador, String fecha, String hora) {
        this.productoId = productoId;
        this.campoModificado = campoModificado;
        this.valorAnterior = valorAnterior;
        this.valorNuevo = valorNuevo;
        this.operador = operador;
        this.fecha = fecha;
        this.hora = hora;
        }

    public RegistroActividad() {
    }

    public String getId() {
        return id;
    }

    public String getProductoId() {
        return productoId;
    }

    public String getCampoModificado() {
        return campoModificado;
    }

    public String getValorAnterior() {
        return valorAnterior;
    }

    public String getValorNuevo() {
        return valorNuevo;
    }

    public String getOperador() {
        return operador;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public void setCampoModificado(String campoModificado) {
        this.campoModificado = campoModificado;
    }

    public void setValorAnterior(String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public void setValorNuevo(String valorNuevo) {
        this.valorNuevo = valorNuevo;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "RegistroActividad{" +
                "id='" + id + '\'' +
                ", productoId='" + productoId + '\'' +
                ", campoModificado='" + campoModificado + '\'' +
                ", valorAnterior='" + valorAnterior + '\'' +
                ", valorNuevo='" + valorNuevo + '\'' +
                ", operador='" + operador + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                '}';
    }
}
        
package com.example.tpo.accessingdatamongodb.Usuario;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String documentoIdentidad;
    private int tiempoConectado;
    private String categoria;
    
    public Usuario(String nombre, String apellido, String direccion, String documentoIdentidad, int tiempoConectado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.documentoIdentidad = documentoIdentidad;
        this.tiempoConectado = tiempoConectado;
        if(tiempoConectado >= 240) {
            this.categoria = "TOP";
        } else if(tiempoConectado >= 120) {
            this.categoria = "MEDIUM";
        } else {
            this.categoria = "LOW";
        }
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public int getTiempoConectado() {
        return tiempoConectado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public void setTiempoConectado(int tiempoConectado) {
        this.tiempoConectado = tiempoConectado;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", tiempoConectado=" + tiempoConectado +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}

package com.example.tpo.accessingdatamongodb.Usuario;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;
    
    @NotEmpty(message = "La dirección no puede estar vacía")
    private String direccion;
    
    @NotEmpty(message = "El documento de identidad no puede estar vacío")
    private String documentoIdentidad;
    
    @NotEmpty(message = "La contraseña no puede estar vacía")
    private String password;
    private int tiempoConectado;
    private String categoria;
    
    public Usuario(String nombre, String password , String direccion, String documentoIdentidad) {
        this.nombre = nombre;
        this.password = password;
        this.direccion = direccion;
        this.documentoIdentidad = documentoIdentidad;
        this.tiempoConectado = 0;
        this.categoria = "LOW";
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
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
                ", direccion='" + direccion + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", tiempoConectado=" + tiempoConectado +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}

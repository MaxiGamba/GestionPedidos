package com.example.tpo.accessingdatamongodb.Producto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
public class Producto {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private List<String> imagenes;
    private List<String> videos;
    private List<String> comentarios;


    public Producto(String nombre, String descripcion, double precio, List<String> imagenes, List<String> videos, List<String> comentarios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenes = imagenes;
        this.videos = videos;
        this.comentarios = comentarios;
    }

    public Producto() {
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public List<String> getVideos() {
        return videos;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }
    
    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", imagenes=" + imagenes +
                ", videos=" + videos +
                ", comentarios=" + comentarios +
                '}';
    }
}
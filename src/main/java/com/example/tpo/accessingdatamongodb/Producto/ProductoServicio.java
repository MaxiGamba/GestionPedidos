package com.example.tpo.accessingdatamongodb.Producto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tpo.accessingdatamongodb.RegistroActividad.*;

@Service
public class ProductoServicio {
    private final ProductoRepositorio repositorioProducto;
    private final RegistroActividadServicio servicioRegistroActividad; // Servicio de registro de actividad

    public ProductoServicio(ProductoRepositorio repositorioProducto, RegistroActividadServicio servicioRegistroActividad) { // Constructor de la clase
        this.repositorioProducto = repositorioProducto;
        this.servicioRegistroActividad = servicioRegistroActividad;
    }

    public List<Producto> getAllProductos() {
        return repositorioProducto.findAll();
    }

    public Producto getProductoById(String id) {
        return repositorioProducto.findById(id).orElse(null);
    }

    public Producto getProductoByNombre(String nombre) {
        return repositorioProducto.findByNombre(nombre);
    }

    public List<Producto> getProductoByPrecio(double precio) {
        return repositorioProducto.findByPrecio(precio);
    }

    public Producto createProducto(Producto producto) {
        return repositorioProducto.save(producto);
    }

    public Producto updateProducto(String id, Producto updatedProducto, String operador) { 
        Producto existingProducto = repositorioProducto.findById(id).orElse(null); // Busca el producto a actualizar
        if (existingProducto != null) { // Si el producto existe
            registrarCambio("nombre", existingProducto.getNombre(), updatedProducto.getNombre(), id, operador);
            // Registra el cambio en el campo "nombre"

            registrarCambio("descripcion", existingProducto.getDescripcion(), updatedProducto.getDescripcion(), id, operador);
            // Registra el cambio en el campo "descripcion"

            registrarCambio("precio", String.valueOf(existingProducto.getPrecio()), String.valueOf(updatedProducto.getPrecio()), id, operador);
            // Registra el cambio en el campo "precio"
            
            if (existingProducto.getImagenes() != null && updatedProducto.getImagenes() != null) { // Si las imagenes existen, asi no tira error por null
                registrarCambio("imagenes", existingProducto.getImagenes().toString(), updatedProducto.getImagenes().toString(), id, operador);
                // Registra el cambio en el campo "imagenes"
            }
            
            if (existingProducto.getVideos() != null && updatedProducto.getVideos() != null) { // Si los videos existen, asi no tira error por null
                registrarCambio("videos", existingProducto.getVideos().toString(), updatedProducto.getVideos().toString(), id, operador);
                // Registra el cambio en el campo "videos"
            }

            registrarCambio("comentarios", existingProducto.getComentarios().toString(), updatedProducto.getComentarios().toString(), id, operador);
            // Registra el cambio en el campo "comentarios"


            updatedProducto.setId(id); // Actualiza el ID del producto
            return repositorioProducto.save(updatedProducto); // Guarda el producto actualizado en la base de datos
        }
        return null;
    }

    public void deleteProducto(String id) {
        repositorioProducto.deleteById(id);
    }

    public void deleteAllProductos() {
        repositorioProducto.deleteAll();
    }

    private void registrarCambio(String campo, String valorAnterior, String valorNuevo, String productoId, String operador) { // Registra un cambio en un campo de un producto
        if (!valorAnterior.equals(valorNuevo)) { // Si el valor anterior es diferente al valor nuevo
            RegistroActividad registro = new RegistroActividad(); // Crea un nuevo registro de actividad
            registro.setCampoModificado(campo);
            registro.setValorAnterior(valorAnterior);
            registro.setValorNuevo(valorNuevo);
            registro.setProductoId(productoId);
            registro.setOperador(operador);

            LocalDateTime fechaHora = LocalDateTime.now(); // Obtiene la fecha y hora actual
            registro.setFecha(fechaHora.toLocalDate().toString()); // Guarda la fecha en el registro
            registro.setHora(fechaHora.toLocalTime().toString()); // Guarda la hora en el registro

            servicioRegistroActividad.createRegistro(registro); // Guarda el registro en la base de datos
        }
    }
}
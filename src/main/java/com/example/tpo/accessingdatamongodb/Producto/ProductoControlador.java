package com.example.tpo.accessingdatamongodb.Producto;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {
    private final ProductoServicio productoServicio;

    public ProductoControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoServicio.getAllProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable String id) {
        return productoServicio.getProductoById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public Producto getProductoByNombre(@PathVariable String nombre) {
        return productoServicio.getProductoByNombre(nombre);
    }

    @GetMapping("/precio/{precio}")
    public List<Producto> getProductoByPrecio(@PathVariable double precio) {
        return productoServicio.getProductoByPrecio(precio);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoServicio.createProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable String id, @RequestBody Producto producto, @RequestParam String operador) {
        return productoServicio.updateProducto(id, producto, operador);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable String id) {
        productoServicio.deleteProducto(id);
    }

    @DeleteMapping
    public void deleteAllProductos() {
        productoServicio.deleteAllProductos();
    }
}

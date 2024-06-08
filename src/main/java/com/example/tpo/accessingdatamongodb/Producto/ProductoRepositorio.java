package com.example.tpo.accessingdatamongodb.Producto;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepositorio extends MongoRepository<Producto, String> {

    Producto findByNombre(String nombre);
    List<Producto> findByPrecio(double precio);
    
}

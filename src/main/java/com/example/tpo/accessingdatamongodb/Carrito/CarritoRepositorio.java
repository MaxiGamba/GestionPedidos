package com.example.tpo.accessingdatamongodb.Carrito;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CarritoRepositorio extends MongoRepository<Carrito, String>{
    
    List<Carrito> findByIdUsuario(String idUsuario);

    @Query("{ 'itemCarrito' : { $elemMatch: { 'idProducto' : ?0 } } }")
    List<Carrito> findByIdProducto(String idProducto);
    
    List<Carrito> findByEstado(String estado);
}

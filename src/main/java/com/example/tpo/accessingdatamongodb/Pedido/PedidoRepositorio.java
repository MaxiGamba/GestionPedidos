package com.example.tpo.accessingdatamongodb.Pedido;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PedidoRepositorio extends MongoRepository<Pedido, String>{
    
    List<Pedido> findByIdUsuario(String idUsuario);

    @Query("{ 'itemPedido' : { $elemMatch: { 'idProducto' : ?0 } } }")
    List<Pedido> findByIdProducto(String idProducto);

    List<Pedido> findByEstado(String estado);
    List<Pedido> findByTotal(double total);

}

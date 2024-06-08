package com.example.tpo.accessingdatamongodb.Factura;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FacturaRepositorio extends MongoRepository<Factura, String>{

    List<Factura> findByIdUsuario(String idUsuario);
    List<Factura> findByIdPedido(String idPedido);
    List<Factura> findByFecha(String fecha);
    List<Factura> findByTotal(double total);
    List<Factura> findByFormaPago(String formaPago);
    List<Factura> findByEstado(String estado);

}

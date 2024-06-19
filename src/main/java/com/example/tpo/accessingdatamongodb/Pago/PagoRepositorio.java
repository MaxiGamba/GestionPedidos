package com.example.tpo.accessingdatamongodb.Pago;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PagoRepositorio extends MongoRepository<Pago, String>{

    @Query("{ 'idFacturas': ?0 }") // Busca por idFactura
    List<Pago> findByIdFactura(String idFactura);

    List<Pago> findByIdUsuario(String idUsuario);
    List<Pago> findByMonto(double monto);
    List<Pago> findByFecha(String fecha);
    List<Pago> findByFormaPago(String formaPago);
    List<Pago> findByOperador(String operador);

}

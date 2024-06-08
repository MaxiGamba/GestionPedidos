package com.example.tpo.accessingdatamongodb.Pago;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PagoRepositorio extends MongoRepository<Pago, String>{

    List<Pago> findByIdFactura(String idFactura);
    List<Pago> findByIdUsuario(String idUsuario);
    List<Pago> findByMonto(double monto);
    List<Pago> findByFecha(String fecha);
    List<Pago> findByFormaPago(String formaPago);
    List<Pago> findByOperador(String operador);

}

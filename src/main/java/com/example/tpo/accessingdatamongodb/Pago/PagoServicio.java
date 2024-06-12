package com.example.tpo.accessingdatamongodb.Pago;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tpo.accessingdatamongodb.Factura.*;

@Service
public class PagoServicio {
    private final PagoRepositorio repositorioPago;
    private final FacturaServicio servicioFactura;

    public PagoServicio(PagoRepositorio repositorioPago, FacturaServicio servicioFactura) {
        this.repositorioPago = repositorioPago;
        this.servicioFactura = servicioFactura;
    }

    public List<Pago> getAllPagos() {
        return repositorioPago.findAll();
    }

    public Pago getPagoById(String id) {
        return repositorioPago.findById(id).orElse(null);
    }

    public Pago createPago(String idFactura, String formaPago, String operador) {
        Factura factura = servicioFactura.getFacturaById(idFactura); // Obtiene la factura por id
        factura.setEstado("PAGADA"); // Cambia el estado de la factura a PAGADA
        servicioFactura.updateFactura(idFactura, factura); // Actualiza la factura

        return repositorioPago.save(new Pago(idFactura, factura.getIdUsuario(), factura.getTotal(), formaPago, operador));
    }

    public Pago updatePago(String id, Pago pago) {
        pago.setId(id);
        return repositorioPago.save(pago);
    }

    public void deletePago(String id) {
        repositorioPago.deleteById(id);
    }

    public void deleteAllPagos() {
        repositorioPago.deleteAll();
    }

    public List<Pago> getPagosByIdFactura(String idFactura) {
        return repositorioPago.findByIdFactura(idFactura);
    }

    public List<Pago> getPagosByIdUsuario(String idUsuario) {
        return repositorioPago.findByIdUsuario(idUsuario);
    }

    public List<Pago> getPagosByMonto(double monto) {
        return repositorioPago.findByMonto(monto);
    }

    public List<Pago> getPagosByFecha(String fecha) {
        return repositorioPago.findByFecha(fecha);
    }

    public List<Pago> getPagosByFormaPago(String formaPago) {
        return repositorioPago.findByFormaPago(formaPago);
    }

    public List<Pago> getPagosByOperador(String operador) {
        return repositorioPago.findByOperador(operador);
    }
}

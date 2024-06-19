package com.example.tpo.accessingdatamongodb.Pago;

import java.time.LocalDateTime;
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

    public Pago createPago(List<String> idFacturas, String formaPago, String operador) {
        if( (!formaPago.toUpperCase().equals("EFECTIVO") && !formaPago.toUpperCase().equals("TARJETA DEBITO") && !formaPago.toUpperCase().equals("CUENTA CORRIENTE") && !formaPago.toUpperCase().equals("TARJETA CREDITO") ) || formaPago == null){
            System.out.println("Forma de pago inválida");
            return null;
        }

        double total = 0;
        String idUsuario = "";
        Factura factura = servicioFactura.getFacturaById(idFacturas.get(0));
        Factura factura2 = servicioFactura.getFacturaById(idFacturas.get(0));

        for (String idFactura : idFacturas) {
            factura = servicioFactura.getFacturaById(idFactura); // Obtiene la factura por id
            if (!factura.getIdUsuario().equals(factura2.getIdUsuario())) {
                System.out.println("Las facturas no pertenecen al mismo usuario, no se puede realizar el pago");
                return null;
            }
            factura2 = servicioFactura.getFacturaById(idFactura);

            if (factura != null) {
                factura.setEstado("PAGADA"); // Cambia el estado de la factura a PAGADA
                servicioFactura.updateFactura(idFactura, factura); // Actualiza la factura
                total += factura.getTotal();
                idUsuario = factura.getIdUsuario();
            }
        }
        if(idUsuario.equals("")){ // Si todas las facturas no existen
            System.err.println("No se puede realizar el pago, las facturas no existen");
            return null;
        }
        LocalDateTime fechaHora = LocalDateTime.now(); // Obtiene la fecha y hora actual
        String fecha = (fechaHora.toLocalDate().toString()); // Guarda la fecha
        String hora = (fechaHora.toLocalTime().toString()); // Guarda la hora
        return repositorioPago.save(new Pago(idFacturas, idUsuario, total, fecha, hora, formaPago.toUpperCase(), operador));
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

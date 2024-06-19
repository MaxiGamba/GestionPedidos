package com.example.tpo.accessingdatamongodb.Factura;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.tpo.accessingdatamongodb.Pedido.*;

@Service
public class FacturaServicio {
    private final FacturaRepositorio repositorioFactura;
    private final PedidoServicio servicioPedido;

    public FacturaServicio(FacturaRepositorio repositorioFactura, PedidoServicio servicioPedido) { // Constructor
        this.repositorioFactura = repositorioFactura;
        this.servicioPedido = servicioPedido;
    }

    public List<Factura> getAllFacturas() {
        return repositorioFactura.findAll();
    }

    public Factura getFacturaById(String id) {
        return repositorioFactura.findById(id).orElse(null);
    }

    public Factura createFactura(String idPedido, String formaPago) {
        if( (!formaPago.toUpperCase().equals("EFECTIVO") && !formaPago.toUpperCase().equals("TARJETA DEBITO") && !formaPago.toUpperCase().equals("CUENTA CORRIENTE") && !formaPago.toUpperCase().equals("TARJETA CREDITO") ) || formaPago == null){
            System.out.println("Forma de pago inválida");
            return null;
        }

        Pedido pedido = servicioPedido.getPedidoById(idPedido); // Obtiene el pedido por id
        pedido.setEstado("FACTURADO"); // Cambia el estado del pedido a FACTURADO
        servicioPedido.updatePedido(idPedido, pedido); // Actualiza el pedido

        LocalDateTime fechaHora = LocalDateTime.now(); // Obtiene la fecha y hora actual
        String fecha = (fechaHora.toLocalDate().toString()); // Guarda la fecha
        String hora = (fechaHora.toLocalTime().toString()); // Guarda la hora
        Factura factura = new Factura(idPedido, pedido.getIdUsuario(), pedido.getTotal(), fecha, hora, formaPago.toUpperCase(), "PENDIENTE"); // Crea la factura
        return repositorioFactura.save(factura);
    }

    public Factura updateFactura(String id, Factura factura) {
        factura.setId(id);
        return repositorioFactura.save(factura); // Actualiza en MongoDB
    }

    public void deleteFactura(String id) {
        repositorioFactura.deleteById(id);
    }

    public void deleteAllFacturas() { // Borra todas las facturas
        repositorioFactura.deleteAll();
    }

    public List<Factura> getFacturaByIdUsuario(String idUsuario) {
        return repositorioFactura.findByIdUsuario(idUsuario);
    }

    public List<Factura> getFacturaByIdPedido(String idPedido) {
        return repositorioFactura.findByIdPedido(idPedido);
    }

    public List<Factura> getFacturaByFecha(String fecha) {
        return repositorioFactura.findByFecha(fecha);
    }

    public List<Factura> getFacturaByTotal(double total) {
        return repositorioFactura.findByTotal(total);
    }

    public List<Factura> getFacturaByFormaPago(String formaPago) {
        return repositorioFactura.findByFormaPago(formaPago);
    }

    public List<Factura> getFacturaByEstado(String estado) {
        return repositorioFactura.findByEstado(estado);
    }
}
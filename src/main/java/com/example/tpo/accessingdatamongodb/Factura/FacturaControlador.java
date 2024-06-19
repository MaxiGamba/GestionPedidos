package com.example.tpo.accessingdatamongodb.Factura;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaControlador {
    private final FacturaServicio facturaServicio;

    public FacturaControlador(FacturaServicio facturaServicio) {
        this.facturaServicio = facturaServicio;
    }

    @GetMapping
    public List<Factura> getAllFacturas() {
        return facturaServicio.getAllFacturas();
    }

    @GetMapping("/{id}")
    public Factura getFacturaById(@PathVariable String id) {
        return facturaServicio.getFacturaById(id);
    }

    @PostMapping
    public Factura createFactura(@RequestParam String idPedido, @RequestParam String formaPago) {
        return facturaServicio.createFactura(idPedido, formaPago);
    }

    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable String id, @RequestBody Factura factura) {
        return facturaServicio.updateFactura(id, factura);
    }

    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable String id) {
        facturaServicio.deleteFactura(id);
    }

    @DeleteMapping
    public void deleteAllFacturas() {
        facturaServicio.deleteAllFacturas();
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Factura> getFacturaByIdUsuario(@PathVariable String idUsuario) {
        return facturaServicio.getFacturaByIdUsuario(idUsuario);
    }

    @GetMapping("/pedido/{idPedido}")
    public List<Factura> getFacturaByIdPedido(@PathVariable String idPedido) {
        return facturaServicio.getFacturaByIdPedido(idPedido);
    }

    @GetMapping("/fecha/{fecha}")
    public List<Factura> getFacturaByFecha(@PathVariable String fecha) {
        return facturaServicio.getFacturaByFecha(fecha);
    }

    @GetMapping("/total/{total}")
    public List<Factura> getFacturaByTotal(@PathVariable double total) {
        return facturaServicio.getFacturaByTotal(total);
    }

    @GetMapping("/formaPago/{formaPago}")
    public List<Factura> getFacturaByFormaPago(@PathVariable String formaPago) {
        return facturaServicio.getFacturaByFormaPago(formaPago);
    }

    @GetMapping("/estado/{estado}")
    public List<Factura> getFacturaByEstado(@PathVariable String estado) {
        return facturaServicio.getFacturaByEstado(estado);
    }
}

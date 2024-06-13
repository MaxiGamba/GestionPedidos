package com.example.tpo.accessingdatamongodb.Pago;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoControlador {
    private final PagoServicio pagoServicio;

    public PagoControlador(PagoServicio pagoServicio) {
        this.pagoServicio = pagoServicio;
    }

    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoServicio.getAllPagos();
    }

    @GetMapping("/{id}")
    public Pago getPagoById(@PathVariable String id) {
        return pagoServicio.getPagoById(id);
    }

    @PostMapping
    public Pago createPago(@RequestParam String idFactura, @RequestParam String formaPago, @RequestParam String operador) {
        return pagoServicio.createPago(idFactura, formaPago, operador);
    }

    @PutMapping("/{id}")
    public Pago updatePago(@PathVariable String id, @RequestBody Pago pago) {
        return pagoServicio.updatePago(id, pago);
    }

    @DeleteMapping("/{id}")
    public void deletePago(@PathVariable String id) {
        pagoServicio.deletePago(id);
    }

    @DeleteMapping
    public void deleteAllPagos() {
        pagoServicio.deleteAllPagos();
    }

    @GetMapping("/factura/{idFactura}")
    public List<Pago> getPagosByIdFactura(@PathVariable String idFactura) {
        return pagoServicio.getPagosByIdFactura(idFactura);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Pago> getPagosByIdUsuario(@PathVariable String idUsuario) {
        return pagoServicio.getPagosByIdUsuario(idUsuario);
    }

    @GetMapping("/monto/{monto}")
    public List<Pago> getPagosByMonto(@PathVariable double monto) {
        return pagoServicio.getPagosByMonto(monto);
    }

    @GetMapping("/fecha/{fecha}")
    public List<Pago> getPagosByFecha(@PathVariable String fecha) {
        return pagoServicio.getPagosByFecha(fecha);
    }

    @GetMapping("/formaPago/{formaPago}")
    public List<Pago> getPagosByFormaPago(@PathVariable String formaPago) {
        return pagoServicio.getPagosByFormaPago(formaPago);
    }

    @GetMapping("/operador/{operador}")
    public List<Pago> getPagosByOperador(@PathVariable String operador) {
        return pagoServicio.getPagosByOperador(operador);
    }
}

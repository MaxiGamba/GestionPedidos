package com.example.tpo.accessingdatamongodb.Pedido;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoControlador {
    private final PedidoServicio pedidoServicio;

    public PedidoControlador(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;
    }

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoServicio.getAllPedidos();
    }

    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable String id) {
        return pedidoServicio.getPedidoById(id);
    }

    @PostMapping
    public Pedido createPedido(@RequestParam String idCarrito, @RequestParam double descuentos, @RequestParam double impuestos) {
        return pedidoServicio.createPedido(idCarrito, descuentos, impuestos);
    }

    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable String id, @RequestBody Pedido pedido) {
        return pedidoServicio.updatePedido(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable String id) {
        pedidoServicio.deletePedido(id);
    }

    @DeleteMapping
    public void deleteAllPedidos() {
        pedidoServicio.deleteAllPedidos();
    }

    @GetMapping("/usuario/{userId}")
    public List<Pedido> getPedidosByUserId(@PathVariable String userId) {
        return pedidoServicio.getPedidosByUserId(userId);
    }

    @GetMapping("/estado/{estado}")
    public List<Pedido> getPedidosByEstado(@PathVariable String estado) {
        return pedidoServicio.getPedidosByEstado(estado);
    }

    @GetMapping("/total/{total}")
    public List<Pedido> getPedidosByTotal(@PathVariable double total) {
        return pedidoServicio.getPedidosByTotal(total);
    }

    @GetMapping("/producto/{idProducto}")
    public List<Pedido> getPedidosByProducto(@PathVariable String idProducto) {
        return pedidoServicio.getPedidosByProducto(idProducto);
    }
}

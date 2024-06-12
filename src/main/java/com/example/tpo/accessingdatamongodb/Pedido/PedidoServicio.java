package com.example.tpo.accessingdatamongodb.Pedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tpo.accessingdatamongodb.Carrito.Carrito;
import com.example.tpo.accessingdatamongodb.Carrito.CarritoServicio;
import com.example.tpo.accessingdatamongodb.Carrito.ItemCarrito;

@Service
public class PedidoServicio {
    private final PedidoRepositorio repositorioPedido;
    private final CarritoServicio servicioCarrito; // Inyecta el servicio de carrito

    public PedidoServicio (PedidoRepositorio repositorioPedido, CarritoServicio servicioCarrito) {
        this.repositorioPedido = repositorioPedido;
        this.servicioCarrito = servicioCarrito;
    }

    public List<Pedido> getAllPedidos() {
        return repositorioPedido.findAll();
    }

    public Pedido getPedidoById(String id) {
        return repositorioPedido.findById(id).orElse(null);
    }

    public Pedido createPedido(String carritoId, double descuentos, double impuestos) {
        Carrito carrito = servicioCarrito.getCarritoById(carritoId); // Obtiene el carrito por id
        carrito.setEstado("FINALIZADO"); // Cambia el estado del carrito a FINALIZADO
        servicioCarrito.updateCarrito(carritoId, carrito); // Actualiza el carrito

        double precioOriginal = 0.0; // Inicializa el precio original en 0
        List<ItemPedido> productosPedido = new ArrayList<>();
        for (ItemCarrito itemCarrito : carrito.getProductos()) { // Recorre los productos del carrito
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setIdProducto(itemCarrito.getIdProducto()); // Guarda el id del producto
            itemPedido.setCantidad(itemCarrito.getCantidad());
            itemPedido.setPrecio(itemCarrito.getPrecio());
            precioOriginal += itemCarrito.getPrecio() * itemCarrito.getCantidad(); // Calcula el precio original
            productosPedido.add(itemPedido); // Agrega el item al pedido
        }

        double total = precioOriginal - descuentos + impuestos; // Calcula el total del pedido

        return repositorioPedido.save(new Pedido(carrito.getIdUsuario(), "CREADO", productosPedido, descuentos, impuestos, total));
    }

    public Pedido updatePedido(String id, Pedido pedido) {
        pedido.setId(id);
        return repositorioPedido.save(pedido);
    }

    public void deletePedido(String id) {
        repositorioPedido.deleteById(id);
    }

    public void deleteAllPedidos() {
        repositorioPedido.deleteAll();
    }

    public List<Pedido> getPedidosByUserId(String userId) {
        return repositorioPedido.findByIdUsuario(userId);
    }

    public List<Pedido> getPedidosByEstado(String estado) {
        return repositorioPedido.findByEstado(estado);
    }

    public List<Pedido> getPedidosByTotal(double total) {
        return repositorioPedido.findByTotal(total);
    }

    public List<Pedido> getPedidosByProducto (String idProducto) {
        return repositorioPedido.findByIdProducto(idProducto);
    }
}

package com.example.tpo.accessingdatamongodb.Carrito;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos")
public class CarritoControlador {
    private final CarritoServicio carritoServicio;

    public CarritoControlador(CarritoServicio carritoServicio) {
        this.carritoServicio = carritoServicio;
    }

    @GetMapping
    public List<Carrito> getAllCarritos() {
        return carritoServicio.getAllCarritos();
    }

    @GetMapping("/{id}")
    public Carrito getCarritoById(@PathVariable String id) {
        return carritoServicio.getCarritoById(id);
    }

    @PostMapping
    public Carrito createCarrito(@RequestBody Carrito carrito) {
        return carritoServicio.createCarrito(carrito);
    }

    @PutMapping("/{id}")
    public Carrito updateCarrito(@PathVariable String id, @RequestBody Carrito carrito) {
        return carritoServicio.updateCarrito(id, carrito);
    }

    @DeleteMapping("/{id}")
    public void deleteCarrito(@PathVariable String id) {
        carritoServicio.deleteCarrito(id);
    }

    @DeleteMapping
    public void deleteAllCarritos() {
        carritoServicio.deleteAllCarritos();
    }

    @PostMapping("/{carritoId}/items")
    public Carrito addItemToCarrito(@PathVariable String carritoId, @RequestBody ItemCarrito itemCarrito) {
        return carritoServicio.addItemToCarrito(carritoId, itemCarrito);
    }

    @DeleteMapping("/{carritoId}/items/{productoId}")
    public Carrito removeItemFromCarrito(@PathVariable String carritoId, @PathVariable String productoId) {
        return carritoServicio.removeItemFromCarrito(carritoId, productoId);
    }

    @PutMapping("/{carritoId}/items")
    public Carrito updateItemInCarrito(@PathVariable String carritoId, @RequestBody ItemCarrito itemCarrito) {
        return carritoServicio.updateItemInCarrito(carritoId, itemCarrito);
    }

    @PostMapping("/clear/{carritoId}")
    public Carrito clearCarrito(@PathVariable String carritoId) {
        return carritoServicio.clearCarrito(carritoId);
    }

    @GetMapping("/usuario/{userId}")
    public List<Carrito> getCarritosByUserId(@PathVariable String userId) {
        return carritoServicio.getCarritosByUserId(userId);
    }

    @GetMapping("/estado/{estado}")
    public List<Carrito> getCarritosByState(@PathVariable String estado) {
        return carritoServicio.getCarritosByState(estado);
    }
}


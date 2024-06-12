package com.example.tpo.accessingdatamongodb.Carrito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class CarritoServicio {
    @Autowired
    private RedisTemplate<String, Carrito> redisTemplate; // Inyección de dependencia redisTemplate

    private static final String CARRO_CACHE_PREFIX = "CARRITO_"; // Prefijo para la cache

    public CarritoServicio(RedisTemplate<String, Carrito> redisTemplate) { // Constructor de la clase
        this.redisTemplate = redisTemplate;
    }

    public List<Carrito> getAllCarritos() {
        Set<String> keys = redisTemplate.keys(CARRO_CACHE_PREFIX + "*");
        List<Carrito> carritos = keys.stream()
            .map(key -> (Carrito) redisTemplate.opsForValue().get(key))
            .collect(Collectors.toList());
        return carritos;
    }

    public Carrito getCarritoById(String id) {
        ValueOperations<String, Carrito> ops = redisTemplate.opsForValue();
        String redisKey = CARRO_CACHE_PREFIX + id;
        Carrito carrito = ops.get(redisKey);
        return carrito;
    }

    public Carrito createCarrito(Carrito carrito) {
        ValueOperations<String, Carrito> ops = redisTemplate.opsForValue();
        ops.set(CARRO_CACHE_PREFIX + carrito.getId(), carrito, 30, TimeUnit.MINUTES);
        return carrito;
    }

    public Carrito updateCarrito(String id, Carrito carrito) {
        carrito.setId(id);
        ValueOperations<String, Carrito> ops = redisTemplate.opsForValue();
        ops.set(CARRO_CACHE_PREFIX + carrito.getId(), carrito, 30, TimeUnit.MINUTES);
        return carrito;
    }

    public void deleteCarrito(String id) {
        redisTemplate.delete(CARRO_CACHE_PREFIX + id);
    }

    
    public void deleteAllCarritos() { // Método para eliminar todos los carritos
        redisTemplate.delete(CARRO_CACHE_PREFIX + "*");
    }   

    public Carrito addItemToCarrito(String carritoId, ItemCarrito itemCarrito) {
        Carrito carrito = getCarritoById(carritoId);
        if (carrito != null) {
            carrito.getProductos().add(itemCarrito);
            updateCarrito(carritoId, carrito);
        }
        return carrito;
    }

    public Carrito removeItemFromCarrito(String carritoId, String productoId) {
        Carrito carrito = getCarritoById(carritoId);
        if (carrito != null) {
            carrito.getProductos().removeIf(item -> item.getIdProducto().equals(productoId));
            updateCarrito(carritoId, carrito);
        }
        return carrito;
    }

    public Carrito updateItemInCarrito(String carritoId, ItemCarrito updatedItem) {
        Carrito carrito = getCarritoById(carritoId);
        if (carrito != null) {
            for (ItemCarrito item : carrito.getProductos()) {
                if (item.getIdProducto().equals(updatedItem.getIdProducto())) {
                    item.setCantidad(updatedItem.getCantidad());
                    item.setPrecio(updatedItem.getPrecio());
                    break;
                }
            }
            updateCarrito(carritoId, carrito);
        }
        return carrito;
    }

    public Carrito clearCarrito(String carritoId) { // Método para vaciar el carrito
        Carrito carrito = getCarritoById(carritoId);
        if (carrito != null) {
            carrito.getProductos().clear();
            updateCarrito(carritoId, carrito);
        }
        return carrito;
    }

    public List<Carrito> getCarritosByUserId(String userId) {
    Set<String> keys = redisTemplate.keys(CARRO_CACHE_PREFIX + userId + "*");
    List<Carrito> carritos = keys.stream()
        .map(key -> (Carrito) redisTemplate.opsForValue().get(key))
        .collect(Collectors.toList());
    return carritos;
    }

public List<Carrito> getCarritosByState(String state) {
    Set<String> keys = redisTemplate.keys(CARRO_CACHE_PREFIX + "*" + state + "*");
    List<Carrito> carritos = keys.stream()
        .map(key -> (Carrito) redisTemplate.opsForValue().get(key))
        .collect(Collectors.toList());
    return carritos;
    }
}
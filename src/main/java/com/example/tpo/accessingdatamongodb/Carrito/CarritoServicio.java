package com.example.tpo.accessingdatamongodb.Carrito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CarritoServicio {
    @Autowired
    private CarritoRepositorio repositorioCarrito;

    @Autowired
    private RedisTemplate<String, Carrito> redisTemplate; // Inyección de dependencia redisTemplate

    private static final String CARRO_CACHE_PREFIX = "CARRITO_"; // Prefijo para la cache

    public CarritoServicio(CarritoRepositorio repositorioCarrito, RedisTemplate<String, Carrito> redisTemplate) { // Constructor de la clase
        this.repositorioCarrito = repositorioCarrito;
        this.redisTemplate = redisTemplate;
    }

    public List<Carrito> getAllCarritos() {
        return repositorioCarrito.findAll();
    }

    public Carrito getCarritoById(String id) {
        ValueOperations<String, Carrito> ops = redisTemplate.opsForValue();
        String redisKey = CARRO_CACHE_PREFIX + id;
        Carrito carrito = ops.get(redisKey);
        if (carrito == null) {
            carrito = repositorioCarrito.findById(id).orElse(null);
            if (carrito != null) {
                ops.set(redisKey, carrito, 30, TimeUnit.MINUTES); // Cache por 30 minutos
            }
        }
        return carrito;
    }

    public Carrito createCarrito(Carrito carrito) {
        Carrito savedCarrito = repositorioCarrito.save(carrito);
        ValueOperations<String, Carrito> ops = redisTemplate.opsForValue();
        ops.set(CARRO_CACHE_PREFIX + savedCarrito.getId(), savedCarrito, 30, TimeUnit.MINUTES);
        return savedCarrito;
    }

    public Carrito updateCarrito(String id, Carrito carrito) {
        carrito.setId(id);
        Carrito updatedCarrito = repositorioCarrito.save(carrito);
        ValueOperations<String, Carrito> ops = redisTemplate.opsForValue();
        ops.set(CARRO_CACHE_PREFIX + updatedCarrito.getId(), updatedCarrito, 30, TimeUnit.MINUTES);
        return updatedCarrito;
    }

    public void deleteCarrito(String id) {
        repositorioCarrito.deleteById(id);
        redisTemplate.delete(CARRO_CACHE_PREFIX + id);
    }

    
    public void deleteAllCarritos() { // Método para eliminar todos los carritos
        repositorioCarrito.deleteAll();
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
        return repositorioCarrito.findByIdUsuario(userId);
    }

    public List<Carrito> getCarritosByProductId(String productId) { // Método para obtener carritos por id de producto
        return repositorioCarrito.findByIdProducto(productId);
    }

    public List<Carrito> getCarritosByState(String state) { // Método para obtener carritos por estado
        return repositorioCarrito.findByEstado(state);
    }
}
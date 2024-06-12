package com.example.tpo.accessingdatamongodb.Factura;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class FacturaServicio {
    @Autowired
    private FacturaRepositorio repositorioFactura;

    @Autowired
    private RedisTemplate<String, Factura> redisTemplate;

    private static final String FACTURA_CACHE_PREFIX = "FACTURA_";

    public FacturaServicio(FacturaRepositorio repositorioFactura, RedisTemplate<String, Factura> redisTemplate) { // Constructor
        this.repositorioFactura = repositorioFactura;
        this.redisTemplate = redisTemplate;
    }

    public List<Factura> getAllFacturas() {
        return repositorioFactura.findAll();
    }

    public Factura getFacturaById(String id) {
        ValueOperations<String, Factura> ops = redisTemplate.opsForValue();
        String redisKey = FACTURA_CACHE_PREFIX + id;
        Factura factura = ops.get(redisKey);
        if (factura == null) {
            factura = repositorioFactura.findById(id).orElse(null);
            if (factura != null) {
                ops.set(redisKey, factura, 30, TimeUnit.MINUTES); // Cache por 30 minutos
            }
        }
        return factura;
    }

    public Factura createFactura(Factura factura) {
        // Genera un ID temporal para la factura
        String tempId = UUID.randomUUID().toString();
        factura.setId(tempId);
        ValueOperations<String, Factura> ops = redisTemplate.opsForValue(); // Guarda en cache
        ops.set(FACTURA_CACHE_PREFIX + tempId, factura, 30, TimeUnit.MINUTES);
        return factura;
    }

    public Factura persistFactura(String id) { // Persiste la factura en MongoDB
        ValueOperations<String, Factura> ops = redisTemplate.opsForValue();
        Factura factura = ops.get(FACTURA_CACHE_PREFIX + id);
        if (factura != null) {
            // Guardar en MongoDB
            Factura savedFactura = repositorioFactura.save(factura);
            // Remover de la cache
            redisTemplate.delete(FACTURA_CACHE_PREFIX + id);
            return savedFactura;
        }
        return null;
    }

    public Factura updateFactura(String id, Factura factura) {
        factura.setId(id);
        Factura updatedFactura = repositorioFactura.save(factura); // Actualiza en MongoDB
        ValueOperations<String, Factura> ops = redisTemplate.opsForValue(); // Actualiza en cache
        ops.set(FACTURA_CACHE_PREFIX + updatedFactura.getId(), updatedFactura, 30, TimeUnit.MINUTES); // Cache por 30 minutos
        return updatedFactura;
    }

    public void deleteFactura(String id) {
        repositorioFactura.deleteById(id);
        redisTemplate.delete(FACTURA_CACHE_PREFIX + id);
    }

    public void deleteAllFacturas() { // Borra todas las facturas
        repositorioFactura.deleteAll();
        redisTemplate.delete(FACTURA_CACHE_PREFIX + "*");
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
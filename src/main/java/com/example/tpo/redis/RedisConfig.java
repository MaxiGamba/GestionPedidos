package com.example.tpo.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.example.tpo.accessingdatamongodb.Carrito.Carrito;
import com.example.tpo.accessingdatamongodb.Factura.Factura;

//import com.example.tpo.accessingdatamongodb.Carrito.*;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Factura> facturaRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Factura> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

    @Bean
    public RedisTemplate<String, Carrito> carritoRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Carrito> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}


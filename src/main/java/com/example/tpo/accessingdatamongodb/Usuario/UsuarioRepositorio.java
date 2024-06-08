package com.example.tpo.accessingdatamongodb.Usuario;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{

    List<Usuario> findByNombre(String nombre);
    List<Usuario> findByApellido(String apellido);
    List<Usuario> findByDireccion(String direccion);
    List<Usuario> findByDocumentoIdentidad(String documentoIdentidad);
    List<Usuario> findByTiempoConectado(int tiempoConectado);
    List<Usuario> findByCategoria(String categoria);
    
}
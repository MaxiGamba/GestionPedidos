package com.example.tpo.accessingdatamongodb.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio repositorioUsuario;

    public UsuarioServicio(UsuarioRepositorio repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public UsuarioServicio() {
    }

    public List<Usuario> getAllUsuarios() {
        return repositorioUsuario.findAll();
    }

    public Usuario getUsuarioById(String id) {
        return repositorioUsuario.findById(id).orElse(null);
    }
    
    public Usuario createUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public Usuario updateUsuario(String id, Usuario usuario) {
        usuario.setId(id);
        return repositorioUsuario.save(usuario);
    }

    public void updateTiempoConectado(String id, int minutos) {
        Usuario usuario = getUsuarioById(id);
        if (usuario != null) {
            usuario.setTiempoConectado(usuario.getTiempoConectado() + minutos);
            usuario.setCategoria(updateCategoriaUsuario(usuario.getTiempoConectado()));
            usuario.setId(id);
            repositorioUsuario.save(usuario);
        }
    }

    private String updateCategoriaUsuario(int minutosConexion) {
        if (minutosConexion >= 240) {
            return "TOP";
        } else if (minutosConexion >= 120) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public void deleteUsuario(String id) {
        repositorioUsuario.deleteById(id);
    }

    public void deleteAllUsuarios() {
        repositorioUsuario.deleteAll();
    }

    public List<Usuario> getUsuariosByNombre(String nombre) {
        return repositorioUsuario.findByNombre(nombre);
    }

    public List<Usuario> getUsuariosByDirreccion(String direccion) {
        return repositorioUsuario.findByDireccion(direccion);
    }

    public List<Usuario> getUsuariosByDocumentoIdentidad(String documentoIdentidad) {
        return repositorioUsuario.findByDocumentoIdentidad(documentoIdentidad);
    }

    public List<Usuario> getUsuariosByTiempoConectado(int tiempoConectado) {
        return repositorioUsuario.findByTiempoConectado(tiempoConectado);
    }

    public List<Usuario> getUsuariosByCategoria(String categoria) {
        return repositorioUsuario.findByCategoria(categoria);
    }
}
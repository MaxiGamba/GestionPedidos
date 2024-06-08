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

    public void deleteUsuario(String id) {
        repositorioUsuario.deleteById(id);
    }

    public void deleteAllUsuarios() {
        repositorioUsuario.deleteAll();
    }
}
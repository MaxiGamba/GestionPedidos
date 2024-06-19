package com.example.tpo.accessingdatamongodb.Usuario;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    private final UsuarioServicio usuarioServicio;
    private final PasswordEncoder passwordEncoder;
    public UsuarioControlador(UsuarioServicio usuarioServicio, PasswordEncoder passwordEncoder) {
        this.usuarioServicio = usuarioServicio;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioServicio.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable String id) {
        return usuarioServicio.getUsuarioById(id);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioServicio.createUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
        return usuarioServicio.updateUsuario(id, usuario);
    }

    @PatchMapping("/{id}/tiempo-conectado")
    public void updateTiempoConectado(@PathVariable String id, @RequestParam int minutos) {
        usuarioServicio.updateTiempoConectado(id, minutos);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable String id) {
        usuarioServicio.deleteUsuario(id);
    }

    @DeleteMapping
    public void deleteAllUsuarios() {
        usuarioServicio.deleteAllUsuarios();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Usuario> getUsuariosByNombre(@PathVariable String nombre) {
        return usuarioServicio.getUsuariosByNombre(nombre);
    }

    @GetMapping("/direccion/{direccion}")
    public List<Usuario> getUsuariosByDireccion(@PathVariable String direccion) {
        return usuarioServicio.getUsuariosByDirreccion(direccion);
    }

    @GetMapping("/documentoIdentidad/{documentoIdentidad}")
    public List<Usuario> getUsuariosByDocumentoIdentidad(@PathVariable String documentoIdentidad) {
        return usuarioServicio.getUsuariosByDocumentoIdentidad(documentoIdentidad);
    }

    @GetMapping("/tiempoConectado/{tiempoConectado}")
    public List<Usuario> getUsuariosByTiempoConectado(@PathVariable int tiempoConectado) {
        return usuarioServicio.getUsuariosByTiempoConectado(tiempoConectado);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Usuario> getUsuariosByCategoria(@PathVariable String categoria) {
        return usuarioServicio.getUsuariosByCategoria(categoria);
    }
}
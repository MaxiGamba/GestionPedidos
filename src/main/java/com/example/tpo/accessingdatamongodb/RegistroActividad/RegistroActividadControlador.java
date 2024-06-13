package com.example.tpo.accessingdatamongodb.RegistroActividad;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros-actividad")
public class RegistroActividadControlador {
    private final RegistroActividadServicio registroActividadServicio;

    public RegistroActividadControlador(RegistroActividadServicio registroActividadServicio) {
        this.registroActividadServicio = registroActividadServicio;
    }

    @GetMapping
    public List<RegistroActividad> getAllRegistros() {
        return registroActividadServicio.getAllRegistros();
    }

    @GetMapping("/{id}")
    public RegistroActividad getRegistroById(@PathVariable String id) {
        return registroActividadServicio.getRegistroById(id);
    }

    @PostMapping
    public RegistroActividad createRegistro(@RequestBody RegistroActividad registro) {
        return registroActividadServicio.createRegistro(registro);
    }

    @PutMapping("/{id}")
    public RegistroActividad updateRegistro(@PathVariable String id, @RequestBody RegistroActividad registro) {
        return registroActividadServicio.updateRegistro(id, registro);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistro(@PathVariable String id) {
        registroActividadServicio.deleteRegistro(id);
    }

    @DeleteMapping
    public void deleteAllRegistros() {
        registroActividadServicio.deleteAllRegistros();
    }

    @GetMapping("/campo/{campoModificado}")
    public List<RegistroActividad> getRegistroByCampoModificado(@PathVariable String campoModificado) {
        return registroActividadServicio.getRegistroByCampoModificado(campoModificado);
    }

    @GetMapping("/operador/{operador}")
    public List<RegistroActividad> getRegistroByOperador(@PathVariable String operador) {
        return registroActividadServicio.getRegistroByOperador(operador);
    }

    @GetMapping("/fecha/{fecha}")
    public List<RegistroActividad> getRegistroByFecha(@PathVariable String fecha) {
        return registroActividadServicio.getRegistroByFecha(fecha);
    }
}


package com.example.tpo.accessingdatamongodb.RegistroActividad;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroActividadServicio {
    @Autowired
    private RegistroActividadRepositorio repositorioRegistroActividad;

    public RegistroActividadServicio(RegistroActividadRepositorio repositorioRegistroActividad) {
        this.repositorioRegistroActividad = repositorioRegistroActividad;
    }

    public RegistroActividadServicio() {
    }

    public List<RegistroActividad> getAllRegistros() {
        return repositorioRegistroActividad.findAll();
    }

    public RegistroActividad getRegistroById(String id) {
        return repositorioRegistroActividad.findById(id).orElse(null);
    }

    public RegistroActividad createRegistro(RegistroActividad registro) {
        return repositorioRegistroActividad.save(registro);
    }

    public RegistroActividad updateRegistro(String id, RegistroActividad registro) {
        registro.setId(id);
        return repositorioRegistroActividad.save(registro);
    }

    public void deleteRegistro(String id) {
        repositorioRegistroActividad.deleteById(id);
    }

    public void deleteAllRegistros() {
        repositorioRegistroActividad.deleteAll();
    }

    public List<RegistroActividad> getRegistroByCampoModificado(String campoModificado) {
        return repositorioRegistroActividad.findByCampoModificado(campoModificado);
    }

    public List<RegistroActividad> getRegistroByOperador(String operador) {
        return repositorioRegistroActividad.findByOperador(operador);
    }

    public List<RegistroActividad> getRegistroByFecha(String fecha) {
        return repositorioRegistroActividad.findByFecha(fecha);
    }
}

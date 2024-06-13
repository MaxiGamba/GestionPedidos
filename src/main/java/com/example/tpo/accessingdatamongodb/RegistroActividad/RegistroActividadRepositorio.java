package com.example.tpo.accessingdatamongodb.RegistroActividad;

import java.sql.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistroActividadRepositorio extends MongoRepository<RegistroActividad, String>{

    List<RegistroActividad> findByCampoModificado(String campoModificado);
    List<RegistroActividad> findByOperador(String operador);
    List<RegistroActividad> findByFecha(String fecha);

}

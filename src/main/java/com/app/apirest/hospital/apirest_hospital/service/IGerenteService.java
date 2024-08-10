package com.app.apirest.hospital.apirest_hospital.service;

import com.app.apirest.hospital.apirest_hospital.models.entity.Gerente;

import java.util.List;

public interface IGerenteService {

    Gerente findById(Long id);
    List<Gerente> findAll();
}

package com.app.apirest.hospital.apirest_hospital.service;

import com.app.apirest.hospital.apirest_hospital.models.dao.GerenteDao;
import com.app.apirest.hospital.apirest_hospital.models.entity.Gerente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenteImpl implements IGerenteService{

    @Autowired
    private GerenteDao gerenteDao;

    @Override
    public Gerente findById(Long id) {
        return gerenteDao.findById(id).orElse(null);
    }

    @Override
    public List<Gerente> findAll() {
        return (List<Gerente>) gerenteDao.findAll();
    }
}
